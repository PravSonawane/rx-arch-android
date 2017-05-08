package com.merryapps.rxarch.model.cache;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public interface Cache<T> {

  T data();

  long creationTime();

  State state();

  enum State {
    VALID,
    EXPIRED
  }
}
