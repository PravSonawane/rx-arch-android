package com.merryapps.rxarch.model.abstraction;

/**
 * Encapsulates the result of an {@link Action}. The result contains the data that got
 * generated/modified because of the action and the state of the system as a result of that action.
 *
 * //TODO citation needed
 *
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public interface Result<T,R> {

  T data();

  R state();

  Throwable error();
}
