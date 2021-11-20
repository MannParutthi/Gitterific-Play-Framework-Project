package model;

/**
 * Model class for Repo Contributor
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoContributorModel {
	private String loginName, url;

	/**
	 * Gets the login name 
	 * @return Returns the Login Name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Sets the login name
	 * @param loginName Used to set the LoginName
	 * @return void
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Gets the Url
	 * @return Returns the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the Url
	 * @param url Sets the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
