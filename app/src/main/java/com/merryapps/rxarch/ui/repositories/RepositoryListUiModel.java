package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.core.Result;
import com.merryapps.rxarch.model.repositories.Repository;
import java.util.Collections;
import java.util.List;

import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.FAILED;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.IDLE;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.IN_PROGRESS;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.SUCCESSFUL;

/**
 * Models the UI showing a list of {@link Repository}
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryListUiModel implements Result<List<Repository>,RepositoryListUiModel.State> {

  private final List<Repository> repositories;
  private final State state;
  private final Throwable error;

  private RepositoryListUiModel(List<Repository> repositories, State state) {
    this.repositories = repositories;
    this.state = state;
    this.error = null;
  }

  private RepositoryListUiModel(State state, Throwable error) {
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


  static RepositoryListUiModel createSuccessful(List<Repository> repositories) {
    return new RepositoryListUiModel(repositories, SUCCESSFUL);
  }

  static RepositoryListUiModel createInProgress() {
    return new RepositoryListUiModel(IN_PROGRESS, null);
  }

  static RepositoryListUiModel createError(Throwable throwable) {
    return new RepositoryListUiModel(FAILED, throwable);
  }

  static RepositoryListUiModel createIdle(List<Repository> repositories) {
    return new RepositoryListUiModel(repositories, IDLE);
  }

  public static enum State {
    IDLE,
    IN_PROGRESS,
    SUCCESSFUL,
    FAILED
  }
}
