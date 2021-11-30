package model;

import java.util.Date;

/**
 * This is the Model Class for Repository Commit 
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoCommitModel {
	private String loginName, url, email, message;
	private String date;

	/**
	 * This method gets the Login Name
	 * @return String Returns the Login Name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * This method sets the LoginName 
	 * @param loginName Returns the LoginName
	 * @return void
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * This method gets the URL
	 * @return String Returns the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method sets the URL
	 * @param url Used to set the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
