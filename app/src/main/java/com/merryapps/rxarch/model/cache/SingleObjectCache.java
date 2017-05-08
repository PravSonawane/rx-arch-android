package com.merryapps.rxarch.model.cache;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class SingleObjectCache<T> implements Cache<T> {

  private final T data;
  private final long creationTime;
  private State state;

  public SingleObjectCache(T data) {
    this.data = data;
    this.creationTime = System.currentTimeMillis();
  }

  @Override public T data() {
    return data;
  }

  @Override public long creationTime() {
    return creationTime;
  }

  @Override public State state() {
    return state;
  }
}
