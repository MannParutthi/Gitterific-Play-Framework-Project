package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Model Class for Repo Data
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoDataModel {
	private long id;
	private String description, language, url, cloneUrl, name;
	private Date createdOn, lastUpdatedOn;
	private List<RepoContributorModel> contributors;
	private List<RepoIssueModel> issues;
	private List<RepoCommitModel> commits;
	
	/**
	 * Gets the Repo name
	 * @return Returns the Name of the Repository
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the Repo Name
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the ID
	 * @return Returns the ID of the Repository
	 */
	public long getId() {
		return id;
	}
	/**
	 * Sets the ID
	 * @param id Sets the ID of the Repository
	 * @return void
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Gets the Description of the Repo
	 * @return Returns the Description of the Repository
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Sets the Description
	 * @param description Sets the Description of the Repository
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the Language of the Repo
	 * @return Returns the language of the Repository
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * Sets the Language of the Repo
	 * @param language Sets the Language of the Repository
	 * @return void
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * Gets the URL 
	 * @return	Returns the URL of the Repository
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Sets the URL
	 * @param url Sets the URL of the Repository
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Gets the Clone URL
	 * @return Returns the Clone URL of the Repository
	 */
	public String getCloneUrl() {
		return cloneUrl;
	}
	/**
	 * Sets the Clone URL
	 * @param cloneUrl Sets the CloneURL of the Repository
	 * @return void
	 */
	public void setCloneUrl(String cloneUrl) {
		this.cloneUrl = cloneUrl;
	}
	/**
	 * Gets the Created Date
	 * @return Returns the Created Date of the Repository
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * Sets the Created Date
	 * @param createdOn Sets the Created Date for the Repository
	 * @return void
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * Gets the Last Updated Date
	 * @return Returns the Last Updated Date
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	/**
	 * Sets the Last Updated Date
	 * @param lastUpdatedOn Sets the Last Updated Date
	 * @return void
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	/**
	 * Get the List of Contributors
	 * @return Returns the list of Contributors of the Repository
	 */
	public List<RepoContributorModel> getContributors() {
		return contributors;
	}
	/**
	 * Sets the Contributors list
	 * @param contributors Sets the List of Contributors for the Repository
	 * @return void
	 */
	public void setContributors(List<RepoContributorModel> contributors) {
		this.contributors = contributors;
	}
	/**
	 * Get the List of Repo Issues
	 * @return Returns the issues of the Repository
	 */
	public List<RepoIssueModel> getIssues() {
		return issues;
	}
	/**
	 * Sets the List of Repo Issues
	 * @param issues Sets the Issues of the Repository
	 * @return void
	 */
	public void setIssues(List<RepoIssueModel> issues) {
		this.issues = issues;
	}
	/**
	 * Gets the list of Repo Commits
	 * @return Returns the list of commits of the Repository
	 */
	public List<RepoCommitModel> getCommits() {
		return commits;
	}
	/**
	 * Sets the List of commits
	 * @param commits Sets the commits for the Repository
	 * @return void
	 */
	public void setCommits(List<RepoCommitModel> commits) {
		this.commits = commits;
	}
}
