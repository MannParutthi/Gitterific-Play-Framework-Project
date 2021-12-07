package actors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.mockito.Mockito;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import controllers.HomeController;
import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.RepoDataService;

/**
 * This is the Test class for RepoDataActor
 * 
 * @author Manan Dineshbhai Paruthi
 *
 */
public class RepoDataActorTest{

	/**
	 * Test Case for RepoDataActor
	 * 
	 * @return void
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void repoActorTest() throws InterruptedException, ExecutionException {
		
		final HomeController repoController = Mockito.mock(HomeController.class);
		
		WSClient client = Mockito.mock(WSClient.class);
		
		WSRequest request = Mockito.mock(WSRequest.class);
		
		when(client.url("https://api.github.com/repos/MannParutthi/COMP-6481")).thenReturn(request);
		
		RepoDataService repoDataService = Mockito.mock(RepoDataService.class);
		
		final ActorSystem actorSystem = ActorSystem.create();
		
		CompletionStage<Result> result = null;
		
		Result res1;
		
		try {
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

			
			Request request1 = Helpers.fakeRequest().method("GET").uri("https://api.github.com/repos/MannParutthi/COMP-6481").session("MannParutthiCOMP-6481", "randomKeyForTesting1996").build();
			result = (CompletionStage<Result>) repoController.getRepoData(request1, "MannParutthi", "COMP-6481");

			Mockito.when(repoController.getRepoData(request1,"MannParutthi", "COMP-6481")).thenReturn(result);
			
			new TestKit(actorSystem) {{
                final Props props = RepoDataActor.getProps(new RepoDataService(client));
                final ActorRef repoActor = actorSystem.actorOf(props);
                repoActor.tell("", getRef());
                within(Duration.ofSeconds(3), () -> {
                	expectNoMessage();
                	assertNotNull(request1);
                    return null;
                });
            }};
		} finally {
			TestKit.shutdownActorSystem(actorSystem);
		}
	}	
}
