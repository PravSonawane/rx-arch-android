package com.merryapps.rxarch.model.abstraction;

import io.reactivex.ObservableTransformer;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 * //TODO check if name conveys the meaning and citation needed
 */
public interface ServiceMapper<Action,Result> {

  /**
   * Creates a transformer that maps from UiType to Model type.
   * //TODO check this description
   * @return
   */
  ObservableTransformer<Action,Result> transformToResult();
}
