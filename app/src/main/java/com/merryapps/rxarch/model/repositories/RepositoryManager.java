package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import io.reactivex.Observable;
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

  private static final String BASE_URL = "https://api.github.com/";
  private final Retrofit retrofit;

  public RepositoryManager() {
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  /**
   * Get all public repositories.
   * @return an {@link Observable} stream of {@link List<Repository>}
   */
  @NonNull
  public Observable<List<Repository>> getRepositories() {
    //TODO implement conversion and schedule on IO, retry, cache, pagination here
    return null;
  }
}
