package model;

import java.util.Date;

/**
 * Model Class for Topic 
 *
 */
public class TopicDataModel {

	private String name, Id, language, description, owner, url;
	private int size;
	private Date createdAt, pushedAt;
	
	/**
	 * Default Constructor
	 */
	public TopicDataModel() {}
	
	/**
	 * Gets the name of the Topic 
	 * @return Returns the Name of the Topic
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the Topic
	 * @param name Sets the Name of the Topic
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the ID of the Topic
	 * @return Returns the ID of the Topic
	 */
	public String getId() {
		return Id;
	}
	/**
	 * Sets the ID of the Topic
	 * @param id Sets the ID for the Topic
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * Gets the language of the Topic
	 * @return Returns the Language of the topic
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * Sets the Language of the Topic
	 * @param language Sets the Language for the topic
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * Gets the Description of the Topic 
	 * @return Returns the Description for the topic
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Sets the Description for the topic
	 * @param description Sets the Description for the topic
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the Owner of the Topic
	 * @return Returns the Owner 
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Sets the Owner of the Topic
	 * @param owner Sets the Owner 
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * Gets the URL of the Topic
	 * @return Returns the URL of the Topic
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Sets the URL of the Topic
	 * @param url used for setting the URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Gets the Created Date of a Topic
	 * @return Gets the Created Date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * Sets the Created Date for a Topic
	 * @param createdAt used for setting the Created Date for the topic
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * Get the Topic Pushed Date
	 * @return Returns the Pushed Date
	 */
	public Date getPushedAt() {
		return pushedAt;
	}
	/**
	 * Sets the Topic Pushed Date
	 * @param pushedAt Used for setting the Pushed Date
	 */
	public void setPushedAt(Date pushedAt) {
		this.pushedAt = pushedAt;
	}
	/**
	 * Gets the Topic size
	 * @return Returns the Size of the Topic
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Sets the Topic size
	 * @param size used for setting the size of the topic
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
