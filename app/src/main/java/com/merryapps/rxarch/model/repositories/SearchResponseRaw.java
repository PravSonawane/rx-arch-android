package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Represents a search response received from the network.
 * @author Pravin Sonawane
 * @since 0.0.1
 * @see GithubRepositoryService
 */
class SearchResponseRaw {

  @SerializedName("total_count") @Expose private Integer totalCount;
  @SerializedName("incomplete_results") @Expose private Boolean incompleteResults;
  @SerializedName("items") @Expose private List<ItemRaw> items = null;


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

  List<ItemRaw> getItemInternals() {
    return items;
  }

  void setItemInternals(List<ItemRaw> itemRaws) {
    this.items = itemRaws;
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
