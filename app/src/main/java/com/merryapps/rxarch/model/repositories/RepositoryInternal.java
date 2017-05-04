package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by m727708 on 5/3/17.
 */
class RepositoryInternal {

  @SerializedName("id") @Expose private Integer id;
  @SerializedName("owner") @Expose private OwnerInternal ownerInternal;
  @SerializedName("name") @Expose private String name;
  @SerializedName("full_name") @Expose private String fullName;
  @SerializedName("description") @Expose private String description;
  @SerializedName("private") @Expose private Boolean _private;
  @SerializedName("fork") @Expose private Boolean fork;
  @SerializedName("url") @Expose private String url;
  @SerializedName("html_url") @Expose private String htmlUrl;

  public Integer getId() {
    return id;
  }

  void setId(Integer id) {
    this.id = id;
  }

  public OwnerInternal getOwnerInternal() {
    return ownerInternal;
  }

  void setOwnerInternal(OwnerInternal ownerInternal) {
    this.ownerInternal = ownerInternal;
  }

  public String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getDescription() {
    return description;
  }

  void setDescription(String description) {
    this.description = description;
  }

  public Boolean getPrivate() {
    return _private;
  }

  void setPrivate(Boolean _private) {
    this._private = _private;
  }

  public Boolean getFork() {
    return fork;
  }

  void setFork(Boolean fork) {
    this.fork = fork;
  }

  public String getUrl() {
    return url;
  }

  void setUrl(String url) {
    this.url = url;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }
}
