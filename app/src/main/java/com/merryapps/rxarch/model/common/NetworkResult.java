package com.merryapps.rxarch.model.common;

import com.merryapps.rxarch.model.core.Result;
import java.util.Collections;

import static com.merryapps.rxarch.model.common.NetworkResult.State.FAILED;
import static com.merryapps.rxarch.model.common.NetworkResult.State.IN_PROGRESS;
import static com.merryapps.rxarch.model.common.NetworkResult.State.RETRYING;
import static com.merryapps.rxarch.model.common.NetworkResult.State.SUCCESSFUL;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
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

  public static <T> NetworkResult<T> createOnSuccessful(T data) {
    return new NetworkResult<>(data, SUCCESSFUL, null);
  }

  public static <T> NetworkResult<T> createInProgress(T data) {
    return new NetworkResult<>(data, IN_PROGRESS, null);
  }

  @SuppressWarnings("unchecked") public static <T> NetworkResult<T> createInProgress() {
    return (NetworkResult<T>) new NetworkResult(Collections.emptyList(), IN_PROGRESS, null);
  }

  public static <T> NetworkResult<T> createOnRetrying(T data) {
    return new NetworkResult<>(data, RETRYING, null);
  }

  @SuppressWarnings("unchecked") public static <T> NetworkResult<T> createOnRetrying() {
    return (NetworkResult<T>) new NetworkResult<>(Collections.emptyList(), RETRYING, null);
  }

  @SuppressWarnings("unchecked") public static <T> NetworkResult<T> createOnError(Throwable throwable) {
    return (NetworkResult<T>) new NetworkResult<>(Collections.emptyList(), FAILED, throwable);
  }

  public enum State {
    IN_PROGRESS,
    SUCCESSFUL,
    RETRYING,
    FAILED
  }
}
