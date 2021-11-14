package model;

import java.util.Date;

import org.eclipse.egit.github.core.UserPlan;

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

	private String gravatarId;

	private String htmlUrl;

	private String location;

	private String login;

	private String name;

	private String type;

	private String url;

	private UserPlan plan;

	public boolean isHireable() {
		return hireable;
	}

	public void setHireable(boolean hireable) {
		this.hireable = hireable;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}

	public int getDiskUsage() {
		return diskUsage;
	}

	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnedPrivateRepos() {
		return ownedPrivateRepos;
	}

	public void setOwnedPrivateRepos(int ownedPrivateRepos) {
		this.ownedPrivateRepos = ownedPrivateRepos;
	}

	public int getPrivateGists() {
		return privateGists;
	}

	public void setPrivateGists(int privateGists) {
		this.privateGists = privateGists;
	}

	public int getPublicGists() {
		return publicGists;
	}

	public void setPublicGists(int publicGists) {
		this.publicGists = publicGists;
	}

	public int getPublicRepos() {
		return publicRepos;
	}

	public void setPublicRepos(int publicRepos) {
		this.publicRepos = publicRepos;
	}

	public int getTotalPrivateRepos() {
		return totalPrivateRepos;
	}

	public void setTotalPrivateRepos(int totalPrivateRepos) {
		this.totalPrivateRepos = totalPrivateRepos;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGravatarId() {
		return gravatarId;
	}

	public void setGravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UserPlan getPlan() {
		return plan;
	}

	public void setPlan(UserPlan plan) {
		this.plan = plan;
	}
}
