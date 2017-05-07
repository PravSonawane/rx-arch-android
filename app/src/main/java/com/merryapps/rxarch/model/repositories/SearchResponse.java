package com.merryapps.rxarch.model.repositories;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */

class SearchResponse {

  private SearchResponseRaw searchResponseRaw;
  private RateLimitErrorRaw rateLimitErrorRaw;

  SearchResponse(SearchResponseRaw response) {
    this.searchResponseRaw = response != null ? response : throwIae("response");
  }

  SearchResponse(RateLimitErrorRaw error) {
    this.rateLimitErrorRaw = error != null ? error : throwIae("error");
  }

  boolean isRateLimitError() {
    return rateLimitErrorRaw != null;
  }

  SearchResponseRaw getSearchResponseRaw() {
    return searchResponseRaw;
  }

  RateLimitErrorRaw getRateLimitErrorRaw() {
    return rateLimitErrorRaw;
  }

  private static <T> T throwIae(String argName) {
    throw new IllegalArgumentException(argName + " cannot be null");
  }
}
