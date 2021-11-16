package model;

/**
 * Model Class for Repository Commit 
 *
 */
public class RepoCommitModel {
	private String loginName, url;

	/**
	 * Gets the Login Name
	 * @return Returns the Login Name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Sets the LoginName 
	 * @param loginName Returns the LoginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Gets the URL
	 * @return Returns the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL
	 * @param url Used to set the URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
