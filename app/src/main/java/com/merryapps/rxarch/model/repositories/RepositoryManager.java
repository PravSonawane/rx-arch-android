package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import com.merryapps.rxarch.model.common.NetworkResult;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(new RepositorySearchResponseAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  public ObservableTransformer<RepositorySearchAction, RepositoryListResult> repositories() {

    return actions -> actions
        .flatMap(action -> repositorySearchResult(action.data()))
        .scan(RepositoryListResult.createOnProgress(), (ignored, result) -> {
          switch (result.state()) {
            case IN_PROGRESS:     return RepositoryListResult.createOnProgress();
            case RATE_LIMIT_ERROR:return RepositoryListResult.createOnSuccess(result.data());
            case SUCCESSFUL:      return RepositoryListResult.createOnSuccess(result.data());
            case FAILED:          return RepositoryListResult.createOnError(result.error());
            default:              throw new AssertionError("Unknown state:" + result.state());
          }
        });
  }

  /**
   * Get all public repositories.
   * @return an {@link Observable} stream of {@link List<Repository>}
   */
  @SuppressWarnings("Convert2streamapi") @NonNull
  private Observable<RepositorySearchResult> repositorySearchResult(final String searchTerm) {
    return networkResult(searchTerm)
        .scan(RepositorySearchResult.createOnProgress(), (ignored, result) -> {
          switch (result.state()) {
            case RETRYING:
            case IN_PROGRESS: return RepositorySearchResult.createOnProgress();
            case SUCCESSFUL:  return constructOnSuccess(result);
            case FAILED:      return RepositorySearchResult.createOnError(result.error());
            default:          throw new AssertionError("Unknown state:" + result.state());
          }
        });
  }

  public Observable<NetworkResult<SearchResponse>> networkResult(final String searchTerm) {
    return retrofit.create(GithubRepositoryService.class)
        .searchRepositories(searchTerm)
        .map(NetworkResult::createOnSuccessful)
        .onErrorReturn(NetworkResult::createOnError)
        .subscribeOn(Schedulers.io())
        .startWith(NetworkResult.createInProgress());
  }

  @NonNull private RepositorySearchResult constructOnSuccess(NetworkResult<SearchResponse> result) {
    if (!result.data().isRateLimitError()) {
      return RepositorySearchResult.createOnSuccess(
          convertToRepositoryList(result.data().getSearchResponseRaw()));
    }
    RateLimitErrorRaw error = result.data().getRateLimitErrorRaw();
    String message = error.getMessage();
    String url = error.getDocumentationUrl();
    return RepositorySearchResult.createOnRateLimitError(message, url);
  }

  private List<Repository> convertToRepositoryList(SearchResponseRaw response) {
    if (response == null || response.getItemInternals() == null || response.getItemInternals()
        .isEmpty()) {
      return Collections.emptyList();
    }
    List<Repository> repositories = new ArrayList<>(response.getItemInternals().size());
    for (RepositoryItemInternal i : response.getItemInternals()) {
      repositories.add(new Repository(i));
    }
    return repositories;
  }
}
