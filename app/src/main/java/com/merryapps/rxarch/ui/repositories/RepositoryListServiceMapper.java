package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.repositories.RepositoryListResult;
import com.merryapps.rxarch.model.repositories.RepositoryManager;
import com.merryapps.rxarch.ui.abstraction.ServiceMapper;
import io.reactivex.ObservableTransformer;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryListServiceMapper implements ServiceMapper<RepositoryListResult,
    RepositoryListResult> {

  private final RepositoryManager repositoryManager;

  public RepositoryListServiceMapper(RepositoryManager repositoryManager) {
    this.repositoryManager = repositoryManager;
  }

  @Override
  public ObservableTransformer<RepositoryListResult, RepositoryListResult> createTransformer(
      RepositoryListResult type) {
    //TODO implement this
    return null;
  }
}
