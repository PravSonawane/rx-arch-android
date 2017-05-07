package com.merryapps.rxarch.model.repositories;

/**
 * A Github repository
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class Repository {

  private RepositoryItemInternal repositoryItemInternal;

  Repository(RepositoryItemInternal repositoryItemInternal) {
    this.repositoryItemInternal = repositoryItemInternal;
  }

  RepositoryItemInternal getRepositoryItemInternal() {
    return repositoryItemInternal;
  }

  public String getName() {
    return repositoryItemInternal.getFullName();
  }
}
