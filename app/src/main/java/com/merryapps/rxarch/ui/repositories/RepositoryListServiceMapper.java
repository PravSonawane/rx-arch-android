package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.repositories.RepositoryListResult;
import com.merryapps.rxarch.model.repositories.RepositoryManager;
import com.merryapps.rxarch.model.abstraction.ServiceMapper;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static com.merryapps.rxarch.model.repositories.RepositoryListResult.State.SUCCESSFUL;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryListServiceMapper implements ServiceMapper<LoadAction,
    RepositoryListResult> {

  private final RepositoryManager repositoryManager;

  public RepositoryListServiceMapper(RepositoryManager repositoryManager) {
    this.repositoryManager = repositoryManager;
  }

  @Override
  public ObservableTransformer<LoadAction, RepositoryListResult> transformToResult() {

    return actions -> actions.flatMap(action -> repositoryManager.getRepositories())
        .map(repositories -> RepositoryListResult.create(repositories, SUCCESSFUL))
        .onErrorReturn(RepositoryListResult::createOnError)
        .observeOn(AndroidSchedulers.mainThread())
        .startWith(RepositoryListResult.createOnProgress());
  }
}
