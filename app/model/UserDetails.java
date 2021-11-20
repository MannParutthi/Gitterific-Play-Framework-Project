package model;

import java.util.Date;
import java.util.List;

import org.eclipse.egit.github.core.UserPlan;

/**
 * This is the model class for User Data
 * 
 * @author Harman Preet Kaur
 *
 */
public class UserDetails {
	private boolean hireable;

	private Date createdAt;

	private int collaborators;

	private int diskUsage;

	private int followers;

	private int following;

	private int id;

	private int ownedPrivateRepos;

	private int privateGists;

	private int publicGists;

	private int publicRepos;

	private int totalPrivateRepos;

	private String avatarUrl;

	private String blog;

	private String company;

	private String email;

	private String htmlUrl;

	private String location;

	private String login;

	private String name;

	private String type;

	private String url;

	private UserPlan plan;
	
	private List<String> repoName;

	public List<String> getRepoName() {
		return repoName;
	}

	public void setRepoName(List<String> repoName) {
		this.repoName = repoName;
	}

	/**
	 * This method returns whether the user is hireable or not
	 * 
	 * @return boolean Returns whether the user is hireable or not
	 */
	public boolean isHireable() {
		return hireable;
	}

	/**
	 * This method sis used to set the hire status of the user
	 * 
	 * @param hireable
	 * @return void
	 */
	public void setHireable(boolean hireable) {
		this.hireable = hireable;
	}
	
	/**
	 * This method returns the user created date
	 * 
	 * @return Date Returns the date when the user was created
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method is used to set the createdAt Date
	 * 
	 * @param createdAt  
	 * 
	 * @return void
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method returns the count of collaborators
	 * 
	 * @return int count of the collaborators
	 */
	public int getCollaborators() {
		return collaborators;
	}
	
	/**
	 * This method sets the collaborators for a user
	 *  
	 * @param collaborators
	 * @return void
	 */
	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}

	/**
	 * This method returns the sie of the disk used
	 * 
	 * @return int Returns the disk usage
	 */
	public int getDiskUsage() {
		return diskUsage;
	}

	/**
	 * This method sets the disk usage
	 * 
	 * @param diskUsage 
	 * @return void
	 */
	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}

	/**
	 * This method returns the count of followers 
	 * 
	 * @return int Returns the number of followers
	 */
	public int getFollowers() {
		return followers;
	}

	/**
	 * This method sets the followers
	 * 
	 * @param followers
	 * @return void
	 */
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	
	/**
	 * This method returns the following count
	 * 
	 * @return int Returns the count of the user followers
	 */
	public int getFollowing() {
		return following;
	}

	/**
	 * This method sets the count of user followers
	 * @param following 
	 * @return void
	 */
	public void setFollowing(int following) {
		this.following = following;
	}

	/**
	 * This method returns the ID
	 * 
	 * @return int Returns the ID 
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method sets the ID 
	 * 
	 * @param id
	 * @return void
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method returns the count of Private repos owned by the user
	 * @return int Returns the count of the private repos owned by the user
	 */
	public int getOwnedPrivateRepos() {
		return ownedPrivateRepos;
	}
	
	/**
	 * This method sets the private repos owned by the user
	 * @param ownedPrivateRepos
	 * @return void
	 */
	public void setOwnedPrivateRepos(int ownedPrivateRepos) {
		this.ownedPrivateRepos = ownedPrivateRepos;
	}
	
	/**
	 * This method returns the private gists 
	 * 
	 * @return int Returns the count of the private gists
	 */
	public int getPrivateGists() {
		return privateGists;
	}
	
	/**
	 * This method sets the private gists 
	 * 
	 * @param privateGists
	 * @return void
	 */
	public void setPrivateGists(int privateGists) {
		this.privateGists = privateGists;
	}
	
	/**
	 * This method returns the public gists 
	 * 
	 * @return int Returns the public gists 
	 */
	public int getPublicGists() {
		return publicGists;
	}
	
	/**
	 * This method sets the Public gists 
	 * 
	 * @param publicGists
	 * @return void
	 */
	public void setPublicGists(int publicGists) {
		this.publicGists = publicGists;
	}

	/**
	 * THis method returns the count of the private repos
	 * 
	 * @return int Returns the count of the public repos 
	 */
	public int getPublicRepos() {
		return publicRepos;
	}

	/**
	 * This method sets the public repos 
	 * 
	 * @param publicRepos
	 * @return void
	 */
	public void setPublicRepos(int publicRepos) {
		this.publicRepos = publicRepos;
	}

	/**
	 * This method returns the total private repos of the user
	 * 
	 * @return int Returns the total private repos 
	 */
	public int getTotalPrivateRepos() {
		return totalPrivateRepos;
	}
	
	/**
	 * This method sets the total private repos 
	 * 
	 * @param totalPrivateRepos
	 * @return void
	 */
	public void setTotalPrivateRepos(int totalPrivateRepos) {
		this.totalPrivateRepos = totalPrivateRepos;
	}
	
	/**
	 * This method returns the Avatar URL
	 * 
	 * @return String Returns the Avatar URL 
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * This method sets the Avatar URL
	 * 
	 * @param avatarUrl
	 * @return void
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	/**
	 * This method returns the blog
	 * @return String returns the blog
	 */
	public String getBlog() {
		return blog;
	}

	/**
	 * This method sets the blog
	 * @param blog
	 * @return void
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}

	/**
	 * This method returns the Company
	 * 
	 * @return String Returns the company name
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * This method sets the company
	 * 
	 * @param company 
	 * @return void
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * This method returns the email
	 * @return String Returns the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method sets the email
	 * @param email
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method returns the URL
	 * @return String 
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * This method sets the URL 
	 * @param htmlUrl
	 * @return void
	 */
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	
	/**
	 * This method returns the location
	 * @return String Returns the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * This method sets the location
	 * 
	 * @param location
	 * @return void
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * This method returns the login
	 * @return String Returns the login 
	 */
	public String getLogin() {
		return login;
	}

	/** 
	 * This method sets the login
	 * @param login
	 * @return void
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * This method returns the Name 
	 * @return String Returns the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the Name
	 * 
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the type
	 * @return String Returns the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method sets the Type 
	 * @param type
	 * @return void
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This method returns the URL
	 * @return String Returns the URL 
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * This method sets the URL
	 * @param url
	 * 
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * This method returns the user plan
	 * @return UserPlan  Returns the user plan
	 */
	public UserPlan getPlan() {
		return plan;
	}

	/**
	 * This method sets the Plan
	 * @param plan
	 * @return void
	 */
	public void setPlan(UserPlan plan) {
		this.plan = plan;
	}
}
