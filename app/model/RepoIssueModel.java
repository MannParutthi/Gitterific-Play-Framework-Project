package model;

/**
 * This is the Model class for Repo Issue
 *
 * @author Kevinkumar Patel
 */
public class RepoIssueModel {
	private String title, url, state;

	/**
	 * This method gets the title
	 * @return Returns the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method sets the Title
	 * @param title Sets the Title
	 * @return void
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * This method returns the state
	 * 
	 * @return String
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * This method sets the state
	 * 
	 * @param state
	 * @return void
	 */
	public void setState(String state) {
		this.state = state;
	}
}
