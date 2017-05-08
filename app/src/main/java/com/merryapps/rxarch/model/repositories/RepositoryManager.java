package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import com.merryapps.rxarch.model.network.NetworkResult;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.merryapps.rxarch.model.network.NetworkUtils.toNetworkResult;

/**
 * {@link Repository} manager for https://github.com
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryManager {

  private static final String TAG = "RepositoryManager";

  private static final String BASE_URL = "https://api.github.com/";
  private final Retrofit retrofit;

  public RepositoryManager() {
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(new RepositorySearchResponseAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  public ObservableTransformer<RepositorySearchAction, RepositorySearchResult> repositories() {
    return actions -> actions
        .flatMap(action -> executeNetworkRequest(action.data()))
            .scan(RepositorySearchResult.onInProgress(), (ignored, result) -> {
              switch (result.state()) {
                case RETRYING:
                case IN_PROGRESS: return RepositorySearchResult.onInProgress();
                case SUCCESSFUL:  return constructOnSuccess(result);
                case FAILED:      return RepositorySearchResult.onError(result.error());
                default:          throw new AssertionError("Unknown state:" + result.state());
              }
            });
  }

  private Observable<NetworkResult<SearchResponse>> executeNetworkRequest(final String searchTerm) {
    return retrofit.create(GithubRepositoryService.class)
        .searchRepositories(searchTerm)
        .compose(toNetworkResult());
  }

  /**
   * Constructs a {@link RepositorySearchResult} when the {@link NetworkResult#state()} returns
   * {@link NetworkResult.State#SUCCESSFUL}.
   *
   * <p>
   * The {@link SearchResponse#isRateLimitError()} method returns <code>true</code> when a rate
   * limit error is received.
   * </p>
   */
  @NonNull private RepositorySearchResult constructOnSuccess(NetworkResult<SearchResponse> result) {
    if (!result.data().isRateLimitError()) {
      return RepositorySearchResult.onSuccess(
          convertToRepositoryList(result.data().getSearchResponseRaw()));
    }
    RateLimitErrorRaw error = result.data().getRateLimitErrorRaw();
    String message = error.getMessage();
    String url = error.getDocumentationUrl();
    return RepositorySearchResult.onRateLimitError(message, url);
  }

  /**
   * Converts from <code>List<RepositoryItemInternal></code> to <code>List<Repository></code>
   */
  @NonNull
  private List<Repository> convertToRepositoryList(SearchResponseRaw response) {
    if (response == null || response.getItemInternals() == null || response.getItemInternals()
        .isEmpty()) {
      return Collections.emptyList();
    }
    List<Repository> repositories = new ArrayList<>(response.getItemInternals().size());
    for (ItemRaw i : response.getItemInternals()) {
      repositories.add(new Repository(i));
    }
    return repositories;
  }
}
