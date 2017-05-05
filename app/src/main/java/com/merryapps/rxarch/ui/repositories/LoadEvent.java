package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.core.Action;

/**
 * //TODO add description here
 *
 * @author Pravin Sonawane (june.pravin@gmail.com)
 * @since v1.0.0
 */

public class LoadEvent implements Action<Object> {

  @Override public Object data() {
    return new Object(); //TODO should create proper type
  }
}
