package model;

import java.util.Date;

/**
 * This Model Class is for TopicData 
 * 
 * @author Yashwanth Gundlapally
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
	 * This method gets the name of the Topic 
	 * @return Returns the Name of the Topic
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the name of the Topic
	 * @param name 
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the ID of the Topic
	 * @return Returns the ID of the Topic
	 */
	public String getId() {
		return Id;
	}
	/**
	 * This method sets the ID of the Topic
	 * @param id Sets the ID for the Topic
	 * @return void
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * This method sets the language of the Topic
	 * @return Returns the Language of the topic
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * This method sets the Language of the Topic
	 * @param language Sets the Language for the topic
	 * @return void
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * This method gets the Description of the Topic 
	 * @return Returns the Description for the topic
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * This method sets the Description for the topic
	 * @param description Sets the Description for the topic
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * This method gets the Owner of the Topic
	 * @return Returns the Owner 
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * This method sets the Owner of the Topic
	 * @param owner Sets the Owner 
	 * @return void
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * This method gets the URL of the Topic
	 * @return Returns the URL of the Topic
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * This method sets the URL of the Topic
	 * @param url used for setting the URL
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * This method gets the Created Date of a Topic
	 * @return Gets the Created Date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * This method sets the Created Date for a Topic
	 * @param createdAt used for setting the Created Date for the topic
	 * @return void
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * This method gets the Topic Pushed Date
	 * @return Returns the Pushed Date
	 */
	public Date getPushedAt() {
		return pushedAt;
	}
	/**
	 * This method sets the Topic Pushed Date
	 * @param pushedAt Used for setting the Pushed Date
	 * @return void
	 */
	public void setPushedAt(Date pushedAt) {
		this.pushedAt = pushedAt;
	}
	/**
	 * This method gets the Topic size
	 * @return Returns the Size of the Topic
	 */
	public int getSize() {
		return size;
	}
	/**
	 * This method sets the Topic size
	 * @param size used for setting the size of the topic
	 * @return void
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Returns the Topic Data Model Object
	 * @return Returns the topic data model object with all the values
	 */
	@Override
	public String toString() {
		return "TopicDataModel [name=" + name + ", Id=" + Id + ", language=" + language + ", description=" + description
				+ ", owner=" + owner + ", url=" + url + ", size=" + size + ", createdAt=" + createdAt + ", pushedAt="
				+ pushedAt + "]";
	}
}
