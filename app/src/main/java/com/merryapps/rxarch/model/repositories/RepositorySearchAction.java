package com.merryapps.rxarch.model.repositories;

import android.support.annotation.NonNull;
import com.merryapps.rxarch.model.core.Action;

/**
 * //TODO add description here
 *
 * @author Pravin Sonawane (june.pravin@gmail.com)
 * @since v1.0.0
 */

public class RepositorySearchAction implements Action<String> {

  private final String searchTerm;

  public RepositorySearchAction(String searchTerm) {
    //TODO add null check
    this.searchTerm = searchTerm;
  }

  /**
   * Returns the search term used for searching
   */
  @NonNull
  @Override public String data() {
    return searchTerm;
  }
}
