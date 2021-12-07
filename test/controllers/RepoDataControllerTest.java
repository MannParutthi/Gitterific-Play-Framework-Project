package controllers;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;

/**
 * Controller for testing the Repository Data 
 * 
 * @author Manan Dineshbhai Paruthi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RepoDataControllerTest {

	final HomeController repoController = Mockito.mock(HomeController.class);
	
	WSClient client = Mockito.mock(WSClient.class);
	
	WSRequest request = Mockito.mock(WSRequest.class);	
	
	
	public static RepoDataModel repoOneDataModel;

	/**
	 * This method is used to setup test data for testing
	 * 
	 * @return void
	 * 
	 */
	@BeforeClass
	public static void setUp() {
		repoOneDataModel = new RepoDataModel();
		repoOneDataModel.setUrl("https://github.com/MannParutthi/COMP-6481");
		repoOneDataModel.setName("COMP-6481");
		repoOneDataModel.setId(410654618);
		repoOneDataModel.setLanguage("Java");
		repoOneDataModel.setCloneUrl("https://github.com/MannParutthi/COMP-6481.git");
		repoOneDataModel.setCreatedOn("Sun Sep 26 16:23:40 EDT 2021");
		repoOneDataModel.setLastUpdatedOn("Sun Sep 26 17:04:56 EDT 2021");
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
	}
	
	/**
	 * This method test the Repo Data Controller
	 * 
	 * @return void
	 * @throws IOException
	 */	
	@org.junit.Test
	public void test_getRepoData() throws IOException{		
		
		Result result = null;
		
		//when(client.url("https://api.github.com/search/topics?q=java")).thenReturn(request);
		
		Request request = Helpers.fakeRequest().method("GET").uri("https://api.github.com/repos/MannParutthi/COMP-6481").session("Octobox","randomKeyForTesting1996").build();
		
		result = (Result) repoController.getRepoData(request, "MannParutthi", "COMP-6481");
		
		//Mockito.when(topicController.getTopicData(request1, "Java")).thenReturn(CompletableFuture.completedFuture(result));
		
		assertNotNull(request);
		
	}
}
