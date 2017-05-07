package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.core.Result;
import com.merryapps.rxarch.model.repositories.Repository;
import java.util.Collections;
import java.util.List;

import static com.merryapps.rxarch.ui.repositories.RepositoryListUiResult.State.FAILED;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiResult.State.IDLE;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiResult.State.IN_PROGRESS;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiResult.State.SUCCESSFUL;

/**
 * Models the UI showing a list of {@link Repository}
 * @author Pravin Sonawane
 * @since 0.0.1
 */
class RepositoryListUiResult implements Result<List<Repository>,RepositoryListUiResult.State> {

  private final List<Repository> repositories;
  private final State state;
  private final Throwable error;

  private RepositoryListUiResult(List<Repository> repositories, State state) {
    this.repositories = repositories;
    this.state = state;
    this.error = null;
  }

  private RepositoryListUiResult(State state, Throwable error) {
    this.repositories = Collections.emptyList();
    this.state = state;
    this.error = error;
  }

  @Override public List<Repository> data() {
    return repositories;
  }

  @Override public State state() {
    return state;
  }

  @Override public Throwable error() {
    return error;
  }


  static RepositoryListUiResult onSuccess(List<Repository> repositories) {
    return new RepositoryListUiResult(repositories, SUCCESSFUL);
  }

  static RepositoryListUiResult onInProgress() {
    return new RepositoryListUiResult(IN_PROGRESS, null);
  }

  static RepositoryListUiResult onError(Throwable throwable) {
    return new RepositoryListUiResult(FAILED, throwable);
  }

  static RepositoryListUiResult createIdle(List<Repository> repositories) {
    return new RepositoryListUiResult(repositories, IDLE);
  }

  public enum State {
    IDLE,
    IN_PROGRESS,
    SUCCESSFUL,
    FAILED
  }
}
