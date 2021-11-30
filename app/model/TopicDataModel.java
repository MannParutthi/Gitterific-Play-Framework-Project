package model;

public class TopicDataModel {

	private String name, display_name, short_description, description, created_by, released, created_at, updated_at, featured, curated, score;
	
	public String getName() {
		if(name != null)
			return name;
		return "NA";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplay_name() {
		if(display_name != null)
			return display_name;
		return "NA";
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getShort_description() {
		if(short_description != null)
			return short_description;
		return "NA";
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {		
		if(description != null)
			return description;
		return "NA";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreated_by() {
		if(created_by != null)
			return created_by;
		return "NA";
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getReleased() {
		if(released != null)
			return released;
		return "NA";
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getCreated_at() {
		if(created_at != null)
			return created_at;
		return "NA";
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		if(updated_at != null)
			return updated_at;
		return "NA";
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public String getFeatured() {
		if(featured != null)
			return featured;
		return "NA";
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	public String getCurated() {
		if(curated != null)
			return curated;
		return "NA";
	}
	public void setCurated(String curated) {
		this.curated = curated;
	}
	public String getScore() {
		if(score != null)
			return score;
		return "NA";
	}
	public void setScore(String score) {
		this.score = score;
	}
}
