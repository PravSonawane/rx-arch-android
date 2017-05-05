package com.merryapps.rxarch.model.repositories;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * An API for {@link RepositoryInternal} on https://github.com
 * //TODO add javaDoc on usage
 * @author Pravin Sonawane
 * @since 0.0.1
 */
interface GithubRepositoryService {

  /** Fetch all repositories on Github. //TODO handle pagination **/
  @GET("/repositories")
  Observable<List<RepositoryInternal>> getRepositories();

}
