package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.abstraction.EventResult;
import com.merryapps.rxarch.model.repositories.Repository;
import java.util.Collections;
import java.util.List;

import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.FAILED;
import static com.merryapps.rxarch.ui.repositories.RepositoryListUiModel.State.IN_PROGRESS;

/**
 * Models the UI showing a list of {@link Repository}
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryListUiModel implements EventResult<List<Repository>,RepositoryListUiModel.State> {

  private final List<Repository> repositories;
  private final State state;
  private final Throwable error;

  RepositoryListUiModel(List<Repository> repositories, State state) {
    this.repositories = repositories;
    this.state = state;
    this.error = null;
  }

  RepositoryListUiModel(State state, Throwable error) {
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

  static RepositoryListUiModel create(List<Repository> repositories, State state) {
    return new RepositoryListUiModel(repositories,state);
  }

  static RepositoryListUiModel createOnError(Throwable throwable) {
    return new RepositoryListUiModel(FAILED, throwable);
  }

  static RepositoryListUiModel createOnProgress() {
    return new RepositoryListUiModel(IN_PROGRESS, null);
  }

  public static enum State {
    IN_PROGRESS,
    SUCCESSFUL,
    FAILED
  }
}
