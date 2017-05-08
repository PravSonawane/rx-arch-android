package com.merryapps.rxarch.model.network;

import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;

/**
 * Utility for wrapping retrofit responses into {@link NetworkResult}
 * @author Pravin Sonawane
 * @since 0.0.1
 * @see NetworkResult
 */
public class NetworkUtils {

  /**
   * Converts an {@code Observable<T>} into an {@code Observable<NetworkResult<T>>}. Used to
   * convert responses of retrofit calls into {@link NetworkResult}.
   */
  public static <T> ObservableTransformer<T, NetworkResult<T>> toNetworkResult() {
    return t -> t
        .map(NetworkResult::onSuccess)
        .onErrorReturn(NetworkResult::onError)
        .subscribeOn(Schedulers.io())
        .startWith(NetworkResult.onInProgress());
  }
}
