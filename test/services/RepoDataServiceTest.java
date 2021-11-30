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
import play.api.libs.ws.WSClient;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


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
	
	@org.junit.Test
	public void test_repoDataServiceMethod()  {
		
		Result result = null;
		
		Http.RequestBuilder request1 = new Http.RequestBuilder().method("GET").uri("/repoData/octobox/octobox");
		
		result = Helpers.route(app, request1);
		
		assertEquals(Http.Status.OK, result.status());
	}
	
//	@org.junit.Test
//    public void testRepoNotFoundException()  {
//       
//		try {
//			when(repositoryService.getRepository("MannParutthi", "COMP-6481")).thenThrow(new Exception());
//			assertThrows(Exception.class, () -> {
//				repoDataService.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481", -1);
//	            throw new Exception();
//	        });
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//    }
}
