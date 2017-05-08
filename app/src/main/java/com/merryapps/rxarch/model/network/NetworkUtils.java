package com.merryapps.rxarch.model.network;

import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class NetworkUtils {

  /**
   * Converts an {@code Observable<T>} into an {@code Observable<NetworkResult<T>>}
   */
  public static <T> ObservableTransformer<T, NetworkResult<T>> toNetworkResult() {
    return t -> t
        .map(NetworkResult::onSuccess)
        .onErrorReturn(NetworkResult::onError)
        .subscribeOn(Schedulers.io())
        .startWith(NetworkResult.onInProgress());
  }
}
