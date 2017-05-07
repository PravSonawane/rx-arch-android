package com.merryapps.rxarch.model.repositories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Pravin Sonawane
 * @since 0.0.1
 */
class RepositoryItemInternal {

  @SerializedName("id") @Expose private Integer id;
  @SerializedName("name") @Expose private String name;
  @SerializedName("full_name") @Expose private String fullName;
  @SerializedName("owner") @Expose private OwnerInternal ownerInternal;
  @SerializedName("private") @Expose private Boolean _private;
  @SerializedName("html_url") @Expose private String htmlUrl;
  @SerializedName("description") @Expose private String description;
  @SerializedName("fork") @Expose private Boolean fork;
  @SerializedName("url") @Expose private String url;
  @SerializedName("forks_url") @Expose private String forksUrl;
  @SerializedName("keys_url") @Expose private String keysUrl;
  @SerializedName("collaborators_url") @Expose private String collaboratorsUrl;
  @SerializedName("teams_url") @Expose private String teamsUrl;
  @SerializedName("hooks_url") @Expose private String hooksUrl;
  @SerializedName("issue_events_url") @Expose private String issueEventsUrl;
  @SerializedName("events_url") @Expose private String eventsUrl;
  @SerializedName("assignees_url") @Expose private String assigneesUrl;
  @SerializedName("branches_url") @Expose private String branchesUrl;
  @SerializedName("tags_url") @Expose private String tagsUrl;
  @SerializedName("blobs_url") @Expose private String blobsUrl;
  @SerializedName("git_tags_url") @Expose private String gitTagsUrl;
  @SerializedName("git_refs_url") @Expose private String gitRefsUrl;
  @SerializedName("trees_url") @Expose private String treesUrl;
  @SerializedName("statuses_url") @Expose private String statusesUrl;
  @SerializedName("languages_url") @Expose private String languagesUrl;
  @SerializedName("stargazers_url") @Expose private String stargazersUrl;
  @SerializedName("contributors_url") @Expose private String contributorsUrl;
  @SerializedName("subscribers_url") @Expose private String subscribersUrl;
  @SerializedName("subscription_url") @Expose private String subscriptionUrl;
  @SerializedName("commits_url") @Expose private String commitsUrl;
  @SerializedName("git_commits_url") @Expose private String gitCommitsUrl;
  @SerializedName("comments_url") @Expose private String commentsUrl;
  @SerializedName("issue_comment_url") @Expose private String issueCommentUrl;
  @SerializedName("contents_url") @Expose private String contentsUrl;
  @SerializedName("compare_url") @Expose private String compareUrl;
  @SerializedName("merges_url") @Expose private String mergesUrl;
  @SerializedName("archive_url") @Expose private String archiveUrl;
  @SerializedName("downloads_url") @Expose private String downloadsUrl;
  @SerializedName("issues_url") @Expose private String issuesUrl;
  @SerializedName("pulls_url") @Expose private String pullsUrl;
  @SerializedName("milestones_url") @Expose private String milestonesUrl;
  @SerializedName("notifications_url") @Expose private String notificationsUrl;
  @SerializedName("labels_url") @Expose private String labelsUrl;
  @SerializedName("releases_url") @Expose private String releasesUrl;
  @SerializedName("deployments_url") @Expose private String deploymentsUrl;
  @SerializedName("created_at") @Expose private String createdAt;
  @SerializedName("updated_at") @Expose private String updatedAt;
  @SerializedName("pushed_at") @Expose private String pushedAt;
  @SerializedName("git_url") @Expose private String gitUrl;
  @SerializedName("ssh_url") @Expose private String sshUrl;
  @SerializedName("clone_url") @Expose private String cloneUrl;
  @SerializedName("svn_url") @Expose private String svnUrl;
  @SerializedName("homepage") @Expose private String homepage;
  @SerializedName("size") @Expose private Integer size;
  @SerializedName("stargazers_count") @Expose private Integer stargazersCount;
  @SerializedName("watchers_count") @Expose private Integer watchersCount;
  @SerializedName("language") @Expose private String language;
  @SerializedName("has_issues") @Expose private Boolean hasIssues;
  @SerializedName("has_projects") @Expose private Boolean hasProjects;
  @SerializedName("has_downloads") @Expose private Boolean hasDownloads;
  @SerializedName("has_wiki") @Expose private Boolean hasWiki;
  @SerializedName("has_pages") @Expose private Boolean hasPages;
  @SerializedName("forks_count") @Expose private Integer forksCount;
  @SerializedName("mirror_url") @Expose private Object mirrorUrl;
  @SerializedName("open_issues_count") @Expose private Integer openIssuesCount;
  @SerializedName("forks") @Expose private Integer forks;
  @SerializedName("open_issues") @Expose private Integer openIssues;
  @SerializedName("watchers") @Expose private Integer watchers;
  @SerializedName("default_branch") @Expose private String defaultBranch;
  @SerializedName("score") @Expose private Double score;

  Integer getId() {
    return id;
  }

  void setId(Integer id) {
    this.id = id;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  String getFullName() {
    return fullName;
  }

  void setFullName(String fullName) {
    this.fullName = fullName;
  }

  OwnerInternal getOwnerInternal() {
    return ownerInternal;
  }

  void setOwnerInternal(OwnerInternal ownerInternal) {
    this.ownerInternal = ownerInternal;
  }

  Boolean getPrivate() {
    return _private;
  }

  void setPrivate(Boolean _private) {
    this._private = _private;
  }

  String getHtmlUrl() {
    return htmlUrl;
  }

  void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  String getDescription() {
    return description;
  }

  void setDescription(String description) {
    this.description = description;
  }

  Boolean getFork() {
    return fork;
  }

  void setFork(Boolean fork) {
    this.fork = fork;
  }

  String getUrl() {
    return url;
  }

  void setUrl(String url) {
    this.url = url;
  }

  String getForksUrl() {
    return forksUrl;
  }

  void setForksUrl(String forksUrl) {
    this.forksUrl = forksUrl;
  }

  String getKeysUrl() {
    return keysUrl;
  }

  void setKeysUrl(String keysUrl) {
    this.keysUrl = keysUrl;
  }

  String getCollaboratorsUrl() {
    return collaboratorsUrl;
  }

  void setCollaboratorsUrl(String collaboratorsUrl) {
    this.collaboratorsUrl = collaboratorsUrl;
  }

  String getTeamsUrl() {
    return teamsUrl;
  }

  void setTeamsUrl(String teamsUrl) {
    this.teamsUrl = teamsUrl;
  }

  String getHooksUrl() {
    return hooksUrl;
  }

  void setHooksUrl(String hooksUrl) {
    this.hooksUrl = hooksUrl;
  }

  String getIssueEventsUrl() {
    return issueEventsUrl;
  }

  void setIssueEventsUrl(String issueEventsUrl) {
    this.issueEventsUrl = issueEventsUrl;
  }

  String getEventsUrl() {
    return eventsUrl;
  }

  void setEventsUrl(String eventsUrl) {
    this.eventsUrl = eventsUrl;
  }

  String getAssigneesUrl() {
    return assigneesUrl;
  }

  void setAssigneesUrl(String assigneesUrl) {
    this.assigneesUrl = assigneesUrl;
  }

  String getBranchesUrl() {
    return branchesUrl;
  }

  void setBranchesUrl(String branchesUrl) {
    this.branchesUrl = branchesUrl;
  }

  String getTagsUrl() {
    return tagsUrl;
  }

  void setTagsUrl(String tagsUrl) {
    this.tagsUrl = tagsUrl;
  }

  String getBlobsUrl() {
    return blobsUrl;
  }

  void setBlobsUrl(String blobsUrl) {
    this.blobsUrl = blobsUrl;
  }

  String getGitTagsUrl() {
    return gitTagsUrl;
  }

  void setGitTagsUrl(String gitTagsUrl) {
    this.gitTagsUrl = gitTagsUrl;
  }

  String getGitRefsUrl() {
    return gitRefsUrl;
  }

  void setGitRefsUrl(String gitRefsUrl) {
    this.gitRefsUrl = gitRefsUrl;
  }

  String getTreesUrl() {
    return treesUrl;
  }

  void setTreesUrl(String treesUrl) {
    this.treesUrl = treesUrl;
  }

  String getStatusesUrl() {
    return statusesUrl;
  }

  void setStatusesUrl(String statusesUrl) {
    this.statusesUrl = statusesUrl;
  }

  String getLanguagesUrl() {
    return languagesUrl;
  }

  void setLanguagesUrl(String languagesUrl) {
    this.languagesUrl = languagesUrl;
  }

  String getStargazersUrl() {
    return stargazersUrl;
  }

  void setStargazersUrl(String stargazersUrl) {
    this.stargazersUrl = stargazersUrl;
  }

  String getContributorsUrl() {
    return contributorsUrl;
  }

  void setContributorsUrl(String contributorsUrl) {
    this.contributorsUrl = contributorsUrl;
  }

  String getSubscribersUrl() {
    return subscribersUrl;
  }

  void setSubscribersUrl(String subscribersUrl) {
    this.subscribersUrl = subscribersUrl;
  }

  String getSubscriptionUrl() {
    return subscriptionUrl;
  }

  void setSubscriptionUrl(String subscriptionUrl) {
    this.subscriptionUrl = subscriptionUrl;
  }

  String getCommitsUrl() {
    return commitsUrl;
  }

  void setCommitsUrl(String commitsUrl) {
    this.commitsUrl = commitsUrl;
  }

  String getGitCommitsUrl() {
    return gitCommitsUrl;
  }

  void setGitCommitsUrl(String gitCommitsUrl) {
    this.gitCommitsUrl = gitCommitsUrl;
  }

  String getCommentsUrl() {
    return commentsUrl;
  }

  void setCommentsUrl(String commentsUrl) {
    this.commentsUrl = commentsUrl;
  }

  String getIssueCommentUrl() {
    return issueCommentUrl;
  }

  void setIssueCommentUrl(String issueCommentUrl) {
    this.issueCommentUrl = issueCommentUrl;
  }

  String getContentsUrl() {
    return contentsUrl;
  }

  void setContentsUrl(String contentsUrl) {
    this.contentsUrl = contentsUrl;
  }

  String getCompareUrl() {
    return compareUrl;
  }

  void setCompareUrl(String compareUrl) {
    this.compareUrl = compareUrl;
  }

  String getMergesUrl() {
    return mergesUrl;
  }

  void setMergesUrl(String mergesUrl) {
    this.mergesUrl = mergesUrl;
  }

  String getArchiveUrl() {
    return archiveUrl;
  }

  void setArchiveUrl(String archiveUrl) {
    this.archiveUrl = archiveUrl;
  }

  String getDownloadsUrl() {
    return downloadsUrl;
  }

  void setDownloadsUrl(String downloadsUrl) {
    this.downloadsUrl = downloadsUrl;
  }

  String getIssuesUrl() {
    return issuesUrl;
  }

  void setIssuesUrl(String issuesUrl) {
    this.issuesUrl = issuesUrl;
  }

  String getPullsUrl() {
    return pullsUrl;
  }

  void setPullsUrl(String pullsUrl) {
    this.pullsUrl = pullsUrl;
  }

  String getMilestonesUrl() {
    return milestonesUrl;
  }

  void setMilestonesUrl(String milestonesUrl) {
    this.milestonesUrl = milestonesUrl;
  }

  String getNotificationsUrl() {
    return notificationsUrl;
  }

  void setNotificationsUrl(String notificationsUrl) {
    this.notificationsUrl = notificationsUrl;
  }

  String getLabelsUrl() {
    return labelsUrl;
  }

  void setLabelsUrl(String labelsUrl) {
    this.labelsUrl = labelsUrl;
  }

  String getReleasesUrl() {
    return releasesUrl;
  }

  void setReleasesUrl(String releasesUrl) {
    this.releasesUrl = releasesUrl;
  }

  String getDeploymentsUrl() {
    return deploymentsUrl;
  }

  void setDeploymentsUrl(String deploymentsUrl) {
    this.deploymentsUrl = deploymentsUrl;
  }

  String getCreatedAt() {
    return createdAt;
  }

  void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  String getUpdatedAt() {
    return updatedAt;
  }

  void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  String getPushedAt() {
    return pushedAt;
  }

  void setPushedAt(String pushedAt) {
    this.pushedAt = pushedAt;
  }

  String getGitUrl() {
    return gitUrl;
  }

  void setGitUrl(String gitUrl) {
    this.gitUrl = gitUrl;
  }

  String getSshUrl() {
    return sshUrl;
  }

  void setSshUrl(String sshUrl) {
    this.sshUrl = sshUrl;
  }

  String getCloneUrl() {
    return cloneUrl;
  }

  void setCloneUrl(String cloneUrl) {
    this.cloneUrl = cloneUrl;
  }

  String getSvnUrl() {
    return svnUrl;
  }

  void setSvnUrl(String svnUrl) {
    this.svnUrl = svnUrl;
  }

  String getHomepage() {
    return homepage;
  }

  void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  Integer getSize() {
    return size;
  }

  void setSize(Integer size) {
    this.size = size;
  }

  Integer getStargazersCount() {
    return stargazersCount;
  }

  void setStargazersCount(Integer stargazersCount) {
    this.stargazersCount = stargazersCount;
  }

  Integer getWatchersCount() {
    return watchersCount;
  }

  void setWatchersCount(Integer watchersCount) {
    this.watchersCount = watchersCount;
  }

  String getLanguage() {
    return language;
  }

  void setLanguage(String language) {
    this.language = language;
  }

  Boolean getHasIssues() {
    return hasIssues;
  }

  void setHasIssues(Boolean hasIssues) {
    this.hasIssues = hasIssues;
  }

  Boolean getHasProjects() {
    return hasProjects;
  }

  void setHasProjects(Boolean hasProjects) {
    this.hasProjects = hasProjects;
  }

  Boolean getHasDownloads() {
    return hasDownloads;
  }

  void setHasDownloads(Boolean hasDownloads) {
    this.hasDownloads = hasDownloads;
  }

  Boolean getHasWiki() {
    return hasWiki;
  }

  void setHasWiki(Boolean hasWiki) {
    this.hasWiki = hasWiki;
  }

  Boolean getHasPages() {
    return hasPages;
  }

  void setHasPages(Boolean hasPages) {
    this.hasPages = hasPages;
  }

  Integer getForksCount() {
    return forksCount;
  }

  void setForksCount(Integer forksCount) {
    this.forksCount = forksCount;
  }

  Object getMirrorUrl() {
    return mirrorUrl;
  }

  void setMirrorUrl(Object mirrorUrl) {
    this.mirrorUrl = mirrorUrl;
  }

  Integer getOpenIssuesCount() {
    return openIssuesCount;
  }

  void setOpenIssuesCount(Integer openIssuesCount) {
    this.openIssuesCount = openIssuesCount;
  }

  Integer getForks() {
    return forks;
  }

  void setForks(Integer forks) {
    this.forks = forks;
  }

  Integer getOpenIssues() {
    return openIssues;
  }

  void setOpenIssues(Integer openIssues) {
    this.openIssues = openIssues;
  }

  Integer getWatchers() {
    return watchers;
  }

  void setWatchers(Integer watchers) {
    this.watchers = watchers;
  }

  String getDefaultBranch() {
    return defaultBranch;
  }

  void setDefaultBranch(String defaultBranch) {
    this.defaultBranch = defaultBranch;
  }

  Double getScore() {
    return score;
  }

  void setScore(Double score) {
    this.score = score;
  }

  @Override public String toString() {
    return "RepositoryItemInternal{" + "fullName='" + fullName + '\'' + '}';
  }
}
