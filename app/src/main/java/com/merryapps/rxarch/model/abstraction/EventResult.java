package com.merryapps.rxarch.model.abstraction;

/**
 * Encapsulates the result of an {@link Event}. The result contains the data that changed and the
 * new state of the event generator. The event generator is expected to update its state using
 * this information.
 *
 * //TODO citation needed
 *
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public interface EventResult<T,R> {

  T data();

  R state();

  Throwable error();
}
