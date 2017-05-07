package com.merryapps.rxarch.model.repositories;

import com.merryapps.rxarch.model.core.Result;
import java.util.Collections;
import java.util.List;

import static com.merryapps.rxarch.model.repositories.RepositorySearchResult.State.FAILED;
import static com.merryapps.rxarch.model.repositories.RepositorySearchResult.State.IN_PROGRESS;
import static com.merryapps.rxarch.model.repositories.RepositorySearchResult.State.RATE_LIMIT_ERROR;
import static com.merryapps.rxarch.model.repositories.RepositorySearchResult.State.SUCCESSFUL;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class RepositorySearchResult implements Result<List<Repository>,RepositorySearchResult.State> {

  private final List<Repository> data;
  private final State state;
  private final Throwable error;
  private final RateLimitError rateLimitError;

  private RepositorySearchResult(List<Repository> data, State state, RateLimitError
      rateLimitError, Throwable error) {
    this.data = data != null ? data : Collections.emptyList();
    this.state = state != null ? state : throwIae("state");
    this.error = error;
    this.rateLimitError = rateLimitError;
  }

  @Override public List<Repository> data() {
    return this.data;
  }

  @Override public State state() {
    return this.state;
  }

  @Override public Throwable error() {
    return this.error;
  }

  public RateLimitError rateLimitError() {
    return this.rateLimitError;
  }

  static RepositorySearchResult createOnSuccess(List<Repository> repositories) {
    return new RepositorySearchResult(repositories, SUCCESSFUL, null, null);
  }

  static RepositorySearchResult createOnProgress() {
    return new RepositorySearchResult(Collections.emptyList(), IN_PROGRESS, null, null);
  }

  static RepositorySearchResult createOnError(Throwable throwable) {
    return new RepositorySearchResult(Collections.emptyList(), FAILED, null, throwable);
  }

  static RepositorySearchResult createOnRateLimitError(String message, String url) {
    RateLimitError error = new RateLimitError(message, url);
    return new RepositorySearchResult(Collections.emptyList(), RATE_LIMIT_ERROR, error, null);
  }

  private State throwIae(String argName) {
    throw new IllegalArgumentException(argName + " cannot be null");
  }

  public enum State {
    IN_PROGRESS,
    SUCCESSFUL,
    FAILED,
    RATE_LIMIT_ERROR
  }

  /**
   * An error received when the rate limit for this API is exceeded.
   */
  public static class RateLimitError {
    
    private static final String EMPTY_STRING = "";
    private static final RateLimitError DEFAULT_ERROR = new RateLimitError(EMPTY_STRING,EMPTY_STRING);
        
    private final String message;
    
    private final String documentationUrl;

    private RateLimitError(String message, String documentationUrl) {
      this.message = message;
      this.documentationUrl = documentationUrl;
    }

    public String message() {
      return message;
    }

    public String documentationUrl() {
      return documentationUrl;
    }
  }
}
