package com.merryapps.rxarch.model.repositories;

import com.merryapps.rxarch.model.abstraction.Result;
import java.util.List;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

public class RepositoryListResult implements Result<List<Repository>> {

  private List<Repository> repositories;

  public RepositoryListResult(List<Repository> repositories) {
    this.repositories = repositories;
  }

  @Override public List<Repository> getData() {
    return null;
  }
}
