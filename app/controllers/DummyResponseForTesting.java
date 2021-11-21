package controllers;

import java.util.Arrays;
import java.util.Date;

import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import model.UserDetails;

public class DummyResponseForTesting {

	public static RepoDataModel getRepoData() {
		RepoDataModel repoOneDataModel;
		repoOneDataModel = new RepoDataModel();
		repoOneDataModel.setUrl("https://github.com/MannParutthi/COMP-6481");
		repoOneDataModel.setName("COMP-6481");
		repoOneDataModel.setId(410654618);
		repoOneDataModel.setLanguage("Java");
		repoOneDataModel.setCloneUrl("https://github.com/MannParutthi/COMP-6481.git");
		repoOneDataModel.setCreatedOn(new Date("Sun Sep 26 16:23:40 EDT 2021"));
		repoOneDataModel.setLastUpdatedOn(new Date("Sun Sep 26 17:04:56 EDT 2021"));
		repoOneDataModel.setDescription(null);
		repoOneDataModel.setOwner("MannParutthi");

		RepoContributorModel repoOneContributorModel = new RepoContributorModel();
		repoOneContributorModel.setLoginName("MannParutthi");
		repoOneContributorModel.setUrl("https://api.github.com/users/MannParutthi");
		repoOneDataModel.setContributors(Arrays.asList(repoOneContributorModel));

		RepoIssueModel repoOneIssueModel = new RepoIssueModel();
		repoOneIssueModel.setTitle("Null Pointer Exception");
		repoOneIssueModel.setUrl(null);
		repoOneDataModel.setIssues(Arrays.asList());

		RepoCommitModel repoOneCommitOneModel = new RepoCommitModel();
		repoOneCommitOneModel.setLoginName("MannParutthi");
		repoOneCommitOneModel.setUrl(
				"https://api.github.com/repos/MannParutthi/COMP-6481/commits/64e2d10b3aed94d7cd3c2a60636dd26ef709f724");
		RepoCommitModel repoOneCommitTwoModel = new RepoCommitModel();
		repoOneCommitTwoModel.setLoginName("MannParutthi");
		repoOneCommitTwoModel.setUrl(
				"https://api.github.com/repos/MannParutthi/COMP-6481/commits/41ad9975a31dba5c5e836487fe4d209382a45e59");
		RepoCommitModel repoOneCommitThreeModel = new RepoCommitModel();
		repoOneCommitThreeModel.setLoginName("MannParutthi");
		repoOneCommitThreeModel.setUrl(
				"https://api.github.com/repos/MannParutthi/COMP-6481/commits/adbeaa530ffd8e85f1c488187ff44fc35bf2bae5");
		RepoCommitModel repoOneCommitFourModel = new RepoCommitModel();
		repoOneCommitFourModel.setLoginName("MannParutthi");
		repoOneCommitFourModel.setUrl(
				"https://api.github.com/repos/MannParutthi/COMP-6481/commits/20cd2f55a3b6b38aa0a614c5e87760b442400088");
		RepoCommitModel repoOneCommitFiveModel = new RepoCommitModel();
		repoOneCommitFiveModel.setLoginName("MannParutthi");
		repoOneCommitFiveModel.setUrl(
				"https://api.github.com/repos/MannParutthi/COMP-6481/commits/8eeb1c82596f8a87c0c1a52b521d115aca5f018f");
		repoOneDataModel.setCommits(Arrays.asList(repoOneCommitOneModel, repoOneCommitTwoModel, repoOneCommitThreeModel,
				repoOneCommitFourModel, repoOneCommitFiveModel));
		return repoOneDataModel;
	}
	
	public static UserDetails getUserData() {
		UserDetails userDetails = new UserDetails();
		userDetails.setName("test");
		userDetails.setId(44037806);
		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
		userDetails.setBlog("http://fabien.potencier.org/");
		userDetails.setCollaborators(3);
		userDetails.setCompany("Symfony/Blackfire");
		userDetails.setFollowers(700);
		userDetails.setFollowing(20);
		userDetails.setHireable(false);
		userDetails.setHtmlUrl("https://github.com/fabpot");
		userDetails.setPublicRepos(8);
		userDetails.setPublicGists(10);
		userDetails.setUrl("https://api.github.com/users/fabpot");
		userDetails.setType("User");
		userDetails.setPrivateGists(0);
		userDetails.setTotalPrivateRepos(0);
		userDetails.setRepoName(Arrays.asList("git"));
		return userDetails;
	}

}
