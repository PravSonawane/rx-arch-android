package com.merryapps.rxarch.ui.repositories;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public enum RepositoryUiState {

  LOAD_IN_PROGRESS,
  LOAD_SUCCESSFUL,
  LOAD_FAILED,
  UPDATE_IN_PROGRESS,
  UPDATE_SUCCESSFUL,
  UPDATE_FAILED;

  //TODO deliberately listed all states even if some of them are almost the same. This is to
  // avoid if statements
}
