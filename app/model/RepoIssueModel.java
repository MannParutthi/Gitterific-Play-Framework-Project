package model;

/**
 * Model class for Repo Issue
 *
 * @author Kevinkumar Patel
 */
public class RepoIssueModel {
	private String title, url;

	/**
	 * Gets the Title
	 * @return Returns the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the Title
	 * @param title Sets the Title
	 * @return void
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param url Sets the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
