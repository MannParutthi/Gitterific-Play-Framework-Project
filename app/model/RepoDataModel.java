package model;

import java.util.Date;
import java.util.List;

public class RepoDataModel {
	private long id;
	private String description, language, url, cloneUrl, name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date createdOn, lastUpdatedOn;
	private List<RepoContributorModel> contributors;
	private List<RepoIssueModel> issues;
	private List<RepoCommitModel> commits;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCloneUrl() {
		return cloneUrl;
	}
	public void setCloneUrl(String cloneUrl) {
		this.cloneUrl = cloneUrl;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public List<RepoContributorModel> getContributors() {
		return contributors;
	}
	public void setContributors(List<RepoContributorModel> contributors) {
		this.contributors = contributors;
	}
	public List<RepoIssueModel> getIssues() {
		return issues;
	}
	public void setIssues(List<RepoIssueModel> issues) {
		this.issues = issues;
	}
	public List<RepoCommitModel> getCommits() {
		return commits;
	}
	public void setCommits(List<RepoCommitModel> commits) {
		this.commits = commits;
	}
}
