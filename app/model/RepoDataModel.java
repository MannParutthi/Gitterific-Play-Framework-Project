package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * This is the Model Class for Repo Data
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoDataModel {
	private long id;
	private String description, language, url, cloneUrl, name, owner;
	private String createdOn, lastUpdatedOn;
	private List<RepoContributorModel> contributors;
	private List<RepoIssueModel> issues;
	private List<RepoCommitModel> commits;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * This method gets the Repo Name
	 * @return Returns the Name of the Repository
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the Repo Name
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the ID
	 * @return Returns the ID of the Repository
	 */
	public long getId() {
		return id;
	}
	/**
	 * This method sets the ID
	 * @param id Sets the ID of the Repository
	 * @return void
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * This method gets the Description of the Repo
	 * @return Returns the Description of the Repository
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * This method sets the Description
	 * @param description Sets the Description of the Repository
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * This method gets the Language of the Repo
	 * @return Returns the language of the Repository
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * This method sets the Language of the Repo
	 * @param language Sets the Language of the Repository
	 * @return void
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * This method gets the URL 
	 * @return	Returns the URL of the Repository
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * This method sets the URL
	 * @param url Sets the URL of the Repository
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * This method gets the Clone URL
	 * @return Returns the Clone URL of the Repository
	 */
	public String getCloneUrl() {
		return cloneUrl;
	}
	/**
	 * This method sets the Clone URL
	 * @param cloneUrl Sets the CloneURL of the Repository
	 * @return void
	 */
	public void setCloneUrl(String cloneUrl) {
		this.cloneUrl = cloneUrl;
	}
	/**
	 * This method gets the Created Date
	 * @return Returns the Created Date of the Repository
	 */
	public String getCreatedOn() {
		return createdOn;
	}
	/**
	 * This method sets the Created Date
	 * @param createdOn Sets the Created Date for the Repository
	 * @return void
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * This gets the Last Updated Date
	 * @return Returns the Last Updated Date
	 */
	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	/**
	 * This sets the Last Updated Date
	 * @param lastUpdatedOn Sets the Last Updated Date
	 * @return void
	 */
	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	/**
	 * This method gets the List of Contributors
	 * @return Returns the list of Contributors of the Repository
	 */
	public List<RepoContributorModel> getContributors() {
		if(contributors == null) { return Arrays.asList(); }
		return contributors;
	}
	/**
	 * This method sets the Contributors list
	 * @param contributors Sets the List of Contributors for the Repository
	 * @return void
	 */
	public void setContributors(List<RepoContributorModel> contributors) {
		this.contributors = contributors;
	}
	/**
	 * This method gets the List of Repo Issues
	 * @return Returns the issues of the Repository
	 */
	public List<RepoIssueModel> getIssues() {
		if(issues == null) { return Arrays.asList(); }
		return issues;
	}
	/**
	 * This method sets the List of Repo Issues
	 * @param issues Sets the Issues of the Repository
	 * @return void
	 */
	public void setIssues(List<RepoIssueModel> issues) {
		this.issues = issues;
	}
	/**
	 * This method gets the list of Repo Commits
	 * @return Returns the list of commits of the Repository
	 */
	public List<RepoCommitModel> getCommits() {
		if(commits == null) { return Arrays.asList(); }
		return commits;
	}
	/**
	 * This method sets the List of commits
	 * @param commits Sets the commits for the Repository
	 * @return void
	 */
	public void setCommits(List<RepoCommitModel> commits) {
		this.commits = commits;
	}
}
