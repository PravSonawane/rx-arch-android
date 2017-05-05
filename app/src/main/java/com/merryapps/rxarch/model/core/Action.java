package com.merryapps.rxarch.model.core;

/**
 * An action is an intent by the UI, device and/or the network to get, update, modify or delete
 * data.
 *
 * <p>
 *   Actions encapsulate the data that is required to be acted upon.
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
