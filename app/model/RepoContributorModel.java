package model;

public class RepoContributorModel {
	private String loginName, url;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RepoContributorModel [loginName=" + loginName + ", url=" + url + "]";
	}
}
