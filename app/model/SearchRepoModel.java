package model;

import java.util.List;

public class SearchRepoModel {
	private String userName, repoName;
	private String[] topics;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String[] getTopics() {
		return topics;
	}
	public void setTopics(String[] strings) {
		this.topics = strings;
	}
}
