package com.merryapps.rxarch.ui.repositories;

import com.merryapps.rxarch.model.abstraction.EventResult;
import com.merryapps.rxarch.model.repositories.Repository;
import java.util.List;

/**
 * Models the UI showing a list of {@link Repository}
 * @author Pravin Sonawane
 * @since 0.0.1
 */
public class RepositoryListUiModel implements EventResult<List<Repository>> {

  public RepositoryListUiModel(List<Repository> repositories) {
  }

  @Override public List<Repository> getData() {
    return null;
  }

  /**
   * Updates the UI to show an 'in progress' state.
   */
  void changeState(RepositoryUiState state) {
    //updates views here
  }
}
