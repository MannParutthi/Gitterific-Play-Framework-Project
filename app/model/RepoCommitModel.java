package model;

/**
 * Model Class for Repository Commit 
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoCommitModel {
	private String loginName, url;

	/**
	 * Gets the Login Name
	 * @return String Returns the Login Name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Sets the LoginName 
	 * @param loginName Returns the LoginName
	 * @return void
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Gets the URL
	 * @return String Returns the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL
	 * @param url Used to set the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
