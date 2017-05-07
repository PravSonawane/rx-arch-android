package com.merryapps.rxarch.model.core;

/**
 * The result of an {@link Action}. The result contains the data that got
 * generated/modified because of the action and the new state of the system as a result of that
 * action.
 *
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public interface Result<TData,TState> {

  TData data();

  TState state();

  Throwable error();
}
