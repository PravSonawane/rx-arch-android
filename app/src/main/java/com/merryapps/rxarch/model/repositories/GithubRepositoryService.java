package com.merryapps.rxarch.model.repositories;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * An API for {@link RepositoryItemInternal} on https://github.com
 * //TODO add javaDoc on usage
 * @author Pravin Sonawane
 * @since 0.0.1
 */
interface GithubRepositoryService {

  /** Search repositories on Github. **/
  @GET("/search/repositories")
  Observable<SearchResponse> searchRepositories(@Query("q")String searchTerm);

}
