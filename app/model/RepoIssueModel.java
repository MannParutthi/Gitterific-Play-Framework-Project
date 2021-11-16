package model;

/**
 * Model class for Repo Issue
 *
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
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
