package com.merryapps.rxarch.model.core;

/**
 * An action is an intent by the UI, device hardware, network, etc. to get, update, modify or delete
 * data.
 *
 * <p>
 * Actions encapsulate the data that is associated with the action. This data can be obtained by
 * using the action's {@link #data()} method.
 * </p>
 * <p>
 * Actions are responded by {@link Result}s.
 * </p>
 *
 * //TODO citation needed
 *
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public interface Action<T> {

  T data();
}
