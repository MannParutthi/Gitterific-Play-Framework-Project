package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.Contributor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.RepoDataModel;
import play.Application;
import play.libs.ws.WSClient;
import play.cache.SyncCacheApi;
import play.inject.Bindings;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import services.TopicDataServiceTest.FakeTopicClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import akka.actor.ActorSystem;
import controllers.HomeController;


/**
 * This class is used for testing the Service class: RepoDataService 
 * 
 * @author Manan Dineshbhai Paruthi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RepoDataServiceTest extends WithApplication  {
	@InjectMocks
	RepoDataService repoDataService;
	
	@Mock
	RepositoryService repositoryService;
	
	@Mock
	WSClient wsClientMock; 

	public static Repository repoData;
	public static List<Contributor> repoContributorList;
	public static List<Issue> repoIssueList;
	public static List<RepositoryCommit> repoCommitList;
	
	public static JsonNode repoJson;
	public static JsonNode repoContributorsJson;
	public static JsonNode repoIssuesJson;
	public static JsonNode repoCommitsJson;

	public static class FakeRepoClient extends HomeController {
        
		 @Inject
		 public FakeRepoClient(WSClient ws, SyncCacheApi cacheApi, SearchForReposService searchForReposService,
			RepoDataService repoDataService, RepoIssues repoIssues, TopicDataService topicDataService,
			UserDataService userDataService, ActorSystem system) {
			super(ws, cacheApi, searchForReposService, repoDataService, repoIssues, topicDataService, userDataService, system);
		}
	}
	
	/**
	 * This method is used for DI Injection
	 * 
	 * @return play.Application
	 * 
	 */
	@Override
	protected Application provideApplication() {
	    return new GuiceApplicationBuilder()
	         .bindings(Bindings.bind(HomeController.class).to(FakeRepoClient.class))
	         .build();
	}

	/**
	 * This method is used for setting up the test data for testing
	 * 
	 * @return void
	 * 
	 */
	@BeforeClass
	public static void setUp() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			repoJson = objectMapper.readTree(new File("test/simulated/repoData/repoSampleData.json"));
			repoContributorsJson = objectMapper.readTree(new File("test/simulated/repoData/repoContributorsSampleData.json"));
			repoIssuesJson = objectMapper.readTree(new File("test/simulated/repoData/repoIssuesSampleData.json"));
			repoCommitsJson = objectMapper.readTree(new File("test/simulated/repoData/repoCommitsSampleData.json"));
//			when(repoDataService.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481", -1)).thenReturn(repoJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * This method unit tests the Repo Data Service
	 * 
	 * @return void
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 * 
	 */
	@org.junit.Test
	public void test_getRepoDataService() throws JsonProcessingException, IOException {

		RepoDataModel repoDataModel = new RepoDataModel();
		repoDataModel.setContributors(null);
		repoDataModel.setIssues(null);
		repoDataModel.setCommits(null);
		
		assertEquals(repoDataModel.getContributors().size(), 0);
		assertEquals(repoDataModel.getIssues().size(), 0);
		assertEquals(repoDataModel.getCommits().size(), 0);
	}
	
	/**
	 * Test Method for testing RepoDataService
	 * 
	 * @return void
	 * 
	 */
	@org.junit.Test
	public void test_repoDataServiceMethod()  {
		
		Result result = null;
		
		Http.RequestBuilder request1 = Helpers.fakeRequest().method("GET").uri("/repoData/MannParutthi/COMP-6481");
		
		result = Helpers.route(app, request1);
		
		assertNotNull(request1);
	}
}
