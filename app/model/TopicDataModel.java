package model;

import java.util.Date;

public class TopicDataModel {

	private String name, Id, language, description, owner, url;
	private Date createdAt;
	
	public TopicDataModel() {}
	
	public TopicDataModel(String name, String id, String language, String description, String owner, String url,
			Date createdAt) {
		super();
		this.name = name;
		Id = id;
		this.language = language;
		this.description = description;
		this.owner = owner;
		this.url = url;
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "TopicDataModel [name=" + name + ", Id=" + Id + ", language=" + language + ", description=" + description
				+ ", owner=" + owner + ", url=" + url + ", createdAt=" + createdAt + "]";
	}	
	
}
