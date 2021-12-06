package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import model.TopicDataModel;
import model.TopicDataModel;
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
		repoOneDataModel.setCreatedOn(LocalDate.now().toString());
		repoOneDataModel.setLastUpdatedOn(LocalDate.now().toString());
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
		//userDetails.setCollaborators(3);
		userDetails.setCompany("Symfony/Blackfire");
		userDetails.setFollowers(700);
		userDetails.setFollowing(20);
		userDetails.setHireable("false");
		userDetails.setHtmlUrl("https://github.com/fabpot");
		userDetails.setPublicRepos(8);
		userDetails.setPublicGists(10);
		userDetails.setUrl("https://api.github.com/users/fabpot");
		userDetails.setType("User");
		userDetails.setPrivateGists(0);
		//userDetails.setTotalPrivateRepos(0);
		userDetails.setRepoName(Arrays.asList("git"));
		userDetails.setCreatedAt("Sun Sep 26 16:23:40 EDT 2021");
		userDetails.setOwnedPrivateRepos(2);
		//userDetails.setDiskUsage(2);
		userDetails.setEmail("harman.preet@gmail.com");
		userDetails.setLocation("Montreal");
		userDetails.setLogin("harman8");
		//userDetails.setPlan(null);
		return userDetails;
	}
	
	public static List<TopicDataModel> getTopicData() {
		List<TopicDataModel> topicLists = new ArrayList<TopicDataModel>();
		
		TopicDataModel topicDataModel = new TopicDataModel();
		//TopicDataModel topicDataModel2 = new TopicDataModel();
		
		topicDataModel.setCreated_at("2016-12-14T21:15:34Z");
		topicDataModel.setCreated_by("James Gosling");
		topicDataModel.setCurated("true");
		topicDataModel.setDescription("Java was originally developed as an alternative to the C/C++ programming languages. It is now mainly used for building web, desktop, mobile, and embedded applications. Java is owned and licensed through Oracle, with free and open source implementations available from Oracle and other vendors.");
		topicDataModel.setDisplay_name("Java");
		topicDataModel.setFeatured("true");
		topicDataModel.setName("java");
		topicDataModel.setReleased("May 23, 1995");
		topicDataModel.setScore("1");
		topicDataModel.setShort_description("Java is an object-oriented programming language used mainly for web, desktop, embedded devices and mobile applications.");
		topicDataModel.setUpdated_at("2021-12-05T20:57:21Z");
		
		topicLists.add(topicDataModel);
		
		return topicLists;
	}
}
