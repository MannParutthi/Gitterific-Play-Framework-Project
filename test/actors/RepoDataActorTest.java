package actors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import services.RepoDataService;
import actors.RepoDataActor.RepoDataReqDetails;
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
	@Mock
	RepoDataService repoDataService;
	
	static ActorSystem actorSystem;
	RepoDataModel repoOneDataModel;
	
	@Before
	public  void setup() {
		actorSystem = ActorSystem.create();
		
		
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
		repoOneDataModel.setIssues(Arrays.asList(repoOneIssueModel));
		
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
	
	@After
	public void teardown() {
		TestKit.shutdownActorSystem(actorSystem);
		actorSystem = null;
	}
	
	@Test
	public void repoActorTest() throws ExecutionException, InterruptedException {
		final TestKit testProbe = new TestKit(actorSystem);
		final RepoDataService repoDataService = Mockito.mock(RepoDataService.class);
		when(repoDataService.getRepoData("MannParutthi", "COMP-6481")).thenReturn(CompletableFuture.supplyAsync(() -> repoOneDataModel));
		
		final ActorRef repoDataActor = actorSystem.actorOf(RepoDataActor.getProps(repoDataService));
		repoDataActor.tell(new RepoDataReqDetails("MannParutthi", "COMP-6481"), testProbe.getRef());
		RepoDataModel repo = testProbe.expectMsgClass(RepoDataModel.class);
		assertEquals(repo.getName(),"COMP-6481");
		assertEquals(repo.getId(), 410654618);
		assertEquals(repo.getUrl(), "https://github.com/MannParutthi/COMP-6481");
		assertEquals(repo.getLanguage(), "Java");
		assertEquals(repo.getOwner(), "MannParutthi");
		assertEquals(repo.getIssues().get(0).getTitle(), "Null Pointer Exception");
		assertEquals(repo.getCommits().get(3).getLoginName(), "MannParutthi");
	}
}