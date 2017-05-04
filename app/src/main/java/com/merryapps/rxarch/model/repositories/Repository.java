package com.merryapps.rxarch.model.repositories;

/**
 * A Github repository
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class Repository {

  private RepositoryInternal repositoryInternal;

  Repository(RepositoryInternal repositoryInternal) {
    this.repositoryInternal = repositoryInternal;
  }

  RepositoryInternal getRepositoryInternal() {
    return repositoryInternal;
  }

  public String getName() {
    return repositoryInternal.getFullName();
  }
}
