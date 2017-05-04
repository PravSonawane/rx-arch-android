package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.abstraction.Event;

/**
 * //TODO add description here
 *
 * @author Pravin Sonawane (june.pravin@gmail.com)
 * @since v1.0.0
 */

public class LoadEvent implements Event<Object> {

  @Override public Object getData() {
    return new Object(); //TODO should create proper type
  }
}
