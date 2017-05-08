package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a rate limit error response received from the network.
 * @author Pravin Sonawane
 * @since 0.0.1
 * @see SearchResponseRaw
 */
class RateLimitErrorRaw {

  @SerializedName("message") @Expose private String message;
  @SerializedName("documentation_url") @Expose private String documentationUrl;

  RateLimitErrorRaw(String message, String documentationUrl) {
    this.message = message;
    this.documentationUrl = documentationUrl;
  }

  String getMessage() {
    return message;
  }

  String getDocumentationUrl() {
    return documentationUrl;
  }

  //TODO remote toString later
  @Override public String toString() {
    return "RateLimitErrorRaw{"
        + "message='"
        + message
        + '\''
        + ", documentationUrl='"
        + documentationUrl
        + '\''
        + '}';
  }
}
