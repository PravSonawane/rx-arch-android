package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by m727708 on 5/3/17.
 */
class OwnerInternal {

  @SerializedName("login") @Expose private String login;
  @SerializedName("id") @Expose private Integer id;
  @SerializedName("avatar_url") @Expose private String avatarUrl;
  @SerializedName("gravatar_id") @Expose private String gravatarId;
  @SerializedName("url") @Expose private String url;
  @SerializedName("html_url") @Expose private String htmlUrl;
  @SerializedName("followers_url") @Expose private String followersUrl;
  @SerializedName("following_url") @Expose private String followingUrl;
  @SerializedName("gists_url") @Expose private String gistsUrl;
  @SerializedName("starred_url") @Expose private String starredUrl;
  @SerializedName("subscriptions_url") @Expose private String subscriptionsUrl;
  @SerializedName("organizations_url") @Expose private String organizationsUrl;
  @SerializedName("repos_url") @Expose private String reposUrl;
  @SerializedName("events_url") @Expose private String eventsUrl;
  @SerializedName("received_events_url") @Expose private String receivedEventsUrl;
  @SerializedName("type") @Expose private String type;
  @SerializedName("site_admin") @Expose private Boolean siteAdmin;

  public String getLogin() {
    return login;
  }

  void setLogin(String login) {
    this.login = login;
  }

  public Integer getId() {
    return id;
  }

  void setId(Integer id) {
    this.id = id;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getGravatarId() {
    return gravatarId;
  }

  void setGravatarId(String gravatarId) {
    this.gravatarId = gravatarId;
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

  public String getFollowersUrl() {
    return followersUrl;
  }

  void setFollowersUrl(String followersUrl) {
    this.followersUrl = followersUrl;
  }

  public String getFollowingUrl() {
    return followingUrl;
  }

  void setFollowingUrl(String followingUrl) {
    this.followingUrl = followingUrl;
  }

  public String getGistsUrl() {
    return gistsUrl;
  }

  void setGistsUrl(String gistsUrl) {
    this.gistsUrl = gistsUrl;
  }

  public String getStarredUrl() {
    return starredUrl;
  }

  void setStarredUrl(String starredUrl) {
    this.starredUrl = starredUrl;
  }

  public String getSubscriptionsUrl() {
    return subscriptionsUrl;
  }

  void setSubscriptionsUrl(String subscriptionsUrl) {
    this.subscriptionsUrl = subscriptionsUrl;
  }

  public String getOrganizationsUrl() {
    return organizationsUrl;
  }

  void setOrganizationsUrl(String organizationsUrl) {
    this.organizationsUrl = organizationsUrl;
  }

  public String getReposUrl() {
    return reposUrl;
  }

  void setReposUrl(String reposUrl) {
    this.reposUrl = reposUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  void setEventsUrl(String eventsUrl) {
    this.eventsUrl = eventsUrl;
  }

  public String getReceivedEventsUrl() {
    return receivedEventsUrl;
  }

  void setReceivedEventsUrl(String receivedEventsUrl) {
    this.receivedEventsUrl = receivedEventsUrl;
  }

  public String getType() {
    return type;
  }

  void setType(String type) {
    this.type = type;
  }

  public Boolean getSiteAdmin() {
    return siteAdmin;
  }

  void setSiteAdmin(Boolean siteAdmin) {
    this.siteAdmin = siteAdmin;
  }
}
