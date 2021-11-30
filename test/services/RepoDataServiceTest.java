package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.egit.github.core.Contributor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.HomeController;
import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.api.libs.ws.WSClient;
import play.api.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.RepoDataService;
import utils.JSONLoader;

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
public class RepoDataServiceTest {
	@InjectMocks
	RepoDataService repoDataService;
	
	@Mock
	RepoDataService repoDataServiceMock;
	
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

		try { 
			
//			when(wsClientMock.url("https://api.github.com/repos/MannParutthi/COMP-6481")).thenReturn(repoJson);
//			when(wsClientMock.url("https://api.github.com/repos/MannParutthi/COMP-6481/contributors").get()).thenReturn(repoContributorsJson);
			
			when(repoDataServiceMock.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481", -1)).thenReturn(repoJson);
			when(repoDataServiceMock.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481/contributors", -1)).thenReturn(repoContributorsJson);
			when(repoDataServiceMock.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481/issues", -1)).thenReturn(repoIssuesJson);
			when(repoDataServiceMock.getJsonData("https://api.github.com/repos/MannParutthi/COMP-6481/commits", -1)).thenReturn(repoCommitsJson);
			
			RepoDataModel repoData = repoDataService.getRepoData("MannParutthi", "COMP-6481").toCompletableFuture().get();
			assertNotNull(repoData);
			assertEquals(repoData.getId(), 410654618);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//    @Test
//    public void testRepoNotFoundException()  {
//       
//		try {
//			when(repositoryService.getRepository(anyString(), anyString())).thenThrow(new IOException());
//			assertThrows(IOException.class, () -> {
//				repoDataService.getRepoData("MannParutthi", "COMP-6481");
//	            throw new IOException();
//	        });
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//    }
}
