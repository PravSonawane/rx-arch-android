package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.merryapps.rxarch.model.repositories.RepositoryListResult.State.SUCCESSFUL;

/**
 * {@link Repository} manager for https://github.com
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryManager {

  private static final String BASE_URL = "https://api.github.com/";
  private final Retrofit retrofit;

  public RepositoryManager() {
    GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  public ObservableTransformer<GetRepositoriesAction, RepositoryListResult> repositories() {

    return actions -> actions.flatMap(action -> getRepositories())
        .map(repositories -> RepositoryListResult.create(repositories, SUCCESSFUL))
        .onErrorReturn(RepositoryListResult::createOnError)
        .observeOn(AndroidSchedulers.mainThread())
        .startWith(RepositoryListResult.createOnProgress());
  }

  /**
   * Get all public repositories.
   * @return an {@link Observable} stream of {@link List<Repository>}
   */
  @SuppressWarnings("Convert2streamapi") @NonNull
  private Observable<List<Repository>> getRepositories() {
    //TODO implement conversion and schedule on IO, retry, cache, pagination here
    return retrofit.create(GithubRepositoryService.class)
        .getRepositories()
        .flatMapIterable(list -> list)
        .map(Repository::new)
        .toList()
        .toObservable()
        .subscribeOn(Schedulers.io());
  }
}
