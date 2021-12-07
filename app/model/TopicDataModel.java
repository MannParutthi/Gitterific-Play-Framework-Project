package model;

/**
 * This is the model class for Topic Data
 * 
 * @author Yashwanth Gundlapally
 *
 */
public class TopicDataModel {

	private String name, display_name, short_description, description, created_by, released, created_at, updated_at, featured, curated, score;
	
	/**
	 * Return the Topic Name
	 * 
	 * @return String
	 */
	public String getName() {
		if(name != null)
			return name;
		return "NA";
	}
	/**
	 * Sets the Topic Name
	 * 
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the Display Name 
	 * 
	 * @return String
	 */
	public String getDisplay_name() {
		if(display_name != null)
			return display_name;
		return "NA";
	}
	
	/**
	 * Sets the Display Name
	 * 
	 * @param display_name
	 * @return void
	 */
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	/**
	 * Returns the short description for Repository
	 * 
	 * @return String
	 */
	public String getShort_description() {
		if(short_description != null)
			return short_description;
		return "NA";
	}
	/**
	 * Sets the Short Description for the Repository
	 * 
	 * @param short_description
	 * @return void
	 */
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	
	/**
	 * Returns the Description of the Repository
	 * 
	 * @return String
	 */
	public String getDescription() {		
		if(description != null)
			return description;
		return "NA";
	}
	
	/**
	 * Sets the Description for the Repository
	 * 
	 * @param description
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the owner of the Repository
	 * 
	 * @return String
	 */
	public String getCreated_by() {
		if(created_by != null)
			return created_by;
		return "NA";
	}
	
	/**
	 * Sets the owner of the Repository
	 * 
	 * @param created_by
	 * @return void
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	/**
	 * Returns the released date of the Repository
	 * 
	 * @return String
	 */
	public String getReleased() {
		if(released != null)
			return released;
		return "NA";
	}
	
	/**
	 * Sets the released date of the Repository
	 * 
	 * @param released
	 * @return void
	 */
	public void setReleased(String released) {
		this.released = released;
	}
	
	/**
	 * Returns the created date of the Repository
	 * 
	 * @return String
	 */
	public String getCreated_at() {
		if(created_at != null)
			return created_at;
		return "NA";
	}
	
	/**
	 * Sets the created date for the Repository
	 * 
	 * @param created_at
	 * @return void
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	/**
	 * Returns the updated date of the Repository
	 * 
	 * @return String
	 */
	public String getUpdated_at() {
		if(updated_at != null)
			return updated_at;
		return "NA";
	}
	
	/**
	 * Sets the updated date of the Repository
	 * 
	 * @param updated_at
	 * @return void
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	/**
	 * Returns the featured value for the Repository
	 * 
	 * @return String
	 */
	public String getFeatured() {
		if(featured != null)
			return featured;
		return "NA";
	}
	
	/**
	 * Sets the featured value for the Repository
	 * 
	 * @param featured
	 * @return void
	 */
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	
	/**
	 * Returns the curated value of the Repository
	 * 
	 * @return String
	 */
	public String getCurated() {
		if(curated != null)
			return curated;
		return "NA";
	}
	
	/**
	 * Sets the cureated value for the Repository
	 * 
	 * @param curated
	 * @return void
	 */
	public void setCurated(String curated) {
		this.curated = curated;
	}
	
	/**
	 * Returns the score
	 * 
	 * @return String
	 */
	public String getScore() {
		if(score != null)
			return score;
		return "NA";
	}
	
	/**
	 * Sets the score
	 * 
	 * @param score
	 * @return void
	 */
	public void setScore(String score) {
		this.score = score;
	}
}
