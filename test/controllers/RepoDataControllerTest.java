package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.jetty.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.RepoDataService;

@RunWith(MockitoJUnitRunner.class)
public class RepoDataControllerTest {

	@InjectMocks
	RepoDataController repoDataController;

	@Mock
	RepoDataService repoDataService;

	public static List<RepoDataModel> repoList;

	@BeforeClass
	public static void setUp() {
		repoList = new ArrayList<RepoDataModel>();

		RepoDataModel repoOneDataModel = new RepoDataModel();
		repoOneDataModel.setUrl("https://github.com/MannParutthi/COMP-6481");
		repoOneDataModel.setName("COMP-6481");
		repoOneDataModel.setId(410654618);
		repoOneDataModel.setLanguage("Java");
		repoOneDataModel.setCloneUrl("https://github.com/MannParutthi/COMP-6481.git");
		repoOneDataModel.setCreatedOn(new Date("Sun Sep 26 16:23:40 EDT 2021"));
		repoOneDataModel.setLastUpdatedOn(new Date("Sun Sep 26 17:04:56 EDT 2021"));
		repoOneDataModel.setDescription(null);

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

		repoList.add(repoOneDataModel);
	}

	@org.junit.Test
	public void test_getRepoData() throws IOException {

		// Mocking
		when(repoDataService.getRepoData("MannParutthi")).thenReturn((CompletableFuture.supplyAsync(() -> repoList)));

		List<RepoDataModel> repoData = null;
		Result res1 = null;
		Result res2 = null;
		try {
			repoData = repoDataService.getRepoData("MannParutthi").toCompletableFuture().get();
			
			Request request1 = Helpers.fakeRequest().method("GET").uri("/repoData/MannParutthi").build();
			res1 = repoDataController.getRepoData(request1, "MannParutthi").toCompletableFuture().get();
			
			Request request2 = Helpers.fakeRequest().method("GET").uri("/repoData/MannParutthi").session("MannParutthi", "randomKeyForTesting").build();
			res2 = repoDataController.getRepoData(request2, "MannParutthi").toCompletableFuture().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // (List<RepoDataModel>) repoDataController.getRepoData(null, "MannParutthi");

		System.out.println("==> " + repoList.get(0).getId() + "==> " + repoData.get(0).getId());

		assertEquals(repoList.get(0).getId(), repoData.get(0).getId());
		assertEquals(HttpStatus.OK_200, res1.status());
		assertEquals(HttpStatus.OK_200, res2.status());
		assertEquals(repoData.isEmpty(), false);
	}

	@org.junit.Test
	public void test_getSaltString() {
		assertEquals(repoDataController.getSaltString().isEmpty(), false);
	}

//	@org.junit.Test
//	public void test_getRepoDataService() {]
//		try {	
//			assertEquals(repoDataService.getRepoData("MannParutthi").toCompletableFuture().get().isEmpty(), false);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
