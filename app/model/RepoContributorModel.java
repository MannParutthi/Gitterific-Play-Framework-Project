package model;

/**
 * THis is the Model class for Repo Contributor
 *
 *@author Manan Dineshbhai Paruthi
 */
public class RepoContributorModel {
	private String loginName, url;
	private int noOfContributions;

	/**
	 * This method gets the login name 
	 * @return Returns the Login Name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * This method sets the login name
	 * @param loginName Used to set the LoginName
	 * @return void
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * This method gets the URL
	 * @return Returns the URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method sets the URL
	 * @param url Sets the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public int getNoOfContributions() {
		return noOfContributions;
	}

	public void setNoOfContributions(int noOfContributions) {
		this.noOfContributions = noOfContributions;
	}
}
