package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */
class SearchResponseRaw {

  @SerializedName("total_count") @Expose private Integer totalCount;
  @SerializedName("incomplete_results") @Expose private Boolean incompleteResults;
  @SerializedName("items") @Expose private List<RepositoryItemInternal> items = null;


  Integer getTotalCount() {
    return totalCount;
  }

  void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  Boolean getIncompleteResults() {
    return incompleteResults;
  }

  void setIncompleteResults(Boolean incompleteResults) {
    this.incompleteResults = incompleteResults;
  }

  List<RepositoryItemInternal> getItemInternals() {
    return items;
  }

  void setItemInternals(List<RepositoryItemInternal> repositoryItemInternals) {
    this.items = repositoryItemInternals;
  }

  //TODO remove later
  @Override public String toString() {
    return "SearchResponseRaw{"
        + "totalCount="
        + totalCount
        + ", incompleteResults="
        + incompleteResults
        + ", items="
        + items
        + '}';
  }
}