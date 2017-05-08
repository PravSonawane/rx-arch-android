package com.merryapps.rxarch.model.network;

import com.merryapps.rxarch.model.core.Result;
import io.reactivex.Observable;

import static com.merryapps.rxarch.model.network.NetworkResult.State.FAILED;
import static com.merryapps.rxarch.model.network.NetworkResult.State.IN_PROGRESS;
import static com.merryapps.rxarch.model.network.NetworkResult.State.RETRYING;
import static com.merryapps.rxarch.model.network.NetworkResult.State.SUCCESSFUL;

/**
 * Represents the result of a network operation. The characteristic of a network operation are
 * the states (represented by {@link State}) associated with it.
 *
 * <p>
 *   Utility methods of {@link NetworkUtils} can be used to create {@link NetworkResult}s as a
 *   part of {@link Observable} streams.
 * </p>
 *
 * <p>
 *   T - The type of the retrofit response being wrapped.
 * </p>
 * @author Pravin Sonawane
 * @since 0.0.1
 * @see NetworkUtils
 */

public class NetworkResult<T> implements Result<T,NetworkResult.State> {
  
  private final T data;
  private final State state;
  private final Throwable error;

  public NetworkResult(T data, State state, Throwable error) {
    this.data = data;
    this.state = state;
    this.error = error;
  }

  @Override public T data() {
    return this.data;
  }

  @Override public State state() {
    return this.state;
  }

  @Override public Throwable error() {
    return this.error;
  }

  public static <T> NetworkResult<T> create(T data, NetworkResult.State state, Throwable
      throwable) {
    return new NetworkResult<>(data, state, throwable);
  }

  public static <T> NetworkResult<T> onSuccess(T data) {
    return new NetworkResult<>(data, SUCCESSFUL, null);
  }

  public static <T> NetworkResult<T> onInProgress(T data) {
    return new NetworkResult<>(data, IN_PROGRESS, null);
  }

  public static <T> NetworkResult<T> onInProgress() {
    return new NetworkResult<>(null, IN_PROGRESS, null);
  }

  public static <T> NetworkResult<T> onRetrying(T data) {
    return new NetworkResult<>(data, RETRYING, null);
  }

  public static <T> NetworkResult<T> onRetrying() {
    return new NetworkResult<>(null, RETRYING, null);
  }

  public static <T> NetworkResult<T> onError(Throwable throwable) {
    return new NetworkResult<>(null, FAILED, throwable);
  }

  public enum State {
    IN_PROGRESS,
    SUCCESSFUL,
    RETRYING,
    FAILED
  }
}
