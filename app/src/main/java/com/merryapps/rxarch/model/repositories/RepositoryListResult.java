package com.merryapps.rxarch.model.repositories;

import com.merryapps.rxarch.model.abstraction.Result;
import java.util.Collections;
import java.util.List;

import static com.merryapps.rxarch.model.repositories.RepositoryListResult.State.FAILED;
import static com.merryapps.rxarch.model.repositories.RepositoryListResult.State.IN_PROGRESS;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class RepositoryListResult implements Result<List<Repository>,RepositoryListResult.State> {

  private final List<Repository> repositories;
  private final State state;
  private final Throwable error;

  private RepositoryListResult(List<Repository> repositories, State state, Throwable error) {
    this.repositories = repositories;
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

  public static RepositoryListResult create(List<Repository> repositories, State state) {
    return new RepositoryListResult(repositories, state, null);
  }

  public static RepositoryListResult createOnProgress() {
    return new RepositoryListResult(Collections.emptyList(), IN_PROGRESS, null);
  }

  public static RepositoryListResult createOnError(Throwable throwable) {
    return new RepositoryListResult(Collections.emptyList(), FAILED, throwable);
  }

  public enum State {
    IN_PROGRESS,
    SUCCESSFUL,
    FAILED
  }
}