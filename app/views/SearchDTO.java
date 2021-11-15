package views;

//import javax.validation.Constraint;

public class SearchDTO {
//	@Constraint.Required
	private String searchKeyword;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}
