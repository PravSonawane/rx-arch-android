package com.merryapps.rxarch.model.abstraction;

/**
 * Encapsulates an action. An action is an intent by the user, device and/or the network to get,
 * update, modify or delete data. An action can also be used to update the state of a part (or
 * whole) of the system.
 *
 * <p>
 *   Actions are responded by {@link Result}s.
 * </p>
 *
 * //TODO citation needed
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public interface Action<T> {

  T getData();

}
