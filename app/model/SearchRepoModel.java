package model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;

/**
 * This is the Model Class used for displaying search results in the Home Page
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
public class SearchRepoModel {
	private String userName, repoName;
	private String[] topics;
	
	/**
	 * This method returns the Username
	 * 
	 * @return String Returns the Username
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * This method sets the username
	 * 
	 * @param userName
	 * @return void
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * This method returns the Repository name
	 * 
	 * @return String Returns the Repository name
	 */
	public String getRepoName() {
		return repoName;
	}
	
	/**
	 * This method sets the Repository name
	 * 
	 * @param repoName
	 * @return void
	 */
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	
	/**
	 * This method returns the topic lists 
	 * 
	 * @return String[] Returns the topics list
	 */
	public String[] getTopics() {
		return topics;
	}
	
	/**
	 * This method sets the list of topics
	 * 
	 * @param strings
	 * @return void
	 */
	public void setTopics(String[] strings) {
		this.topics = strings;
	}
	
	@Override
	public String toString() {
		return "SearchRepoModel [userName=" + userName + ", repoName=" + repoName + ", topics="
				+ Arrays.toString(topics) + "]";
	}
	
	public JsonNode getJson() {
		ObjectNode jsonData = Json.newObject();
		jsonData.put("user", getUserName());
		jsonData.put("repo", getRepoName());
		String allTopics = "";
		for (String topic : getTopics()) {
			allTopics += topic + ", ";
		}
		jsonData.put("topics", allTopics);
		return jsonData;
	}
	
	
}
