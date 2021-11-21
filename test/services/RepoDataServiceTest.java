package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
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
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.RepoDataService;


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
	RepositoryService repositoryService;
	
	@Mock
	IssueService issueService;
	
	@Mock
	CommitService commitService;

	public static Repository repoData;
	public static List<Contributor> repoContributorList;
	public static List<Issue> repoIssueList;
	public static List<RepositoryCommit> repoCommitList;

	/**
	 * This method is used for setting up the test data for testing
	 * 
	 * @return void
	 * 
	 */
	@BeforeClass
	public static void setUp() {
		repoData = new Repository();
		repoData.setName("SOEN6441");
		repoData.setId(1);
		repoData.setDescription("SOEN6441 Project");
		repoData.setLanguage("JAVA");
		repoData.setHtmlUrl("https://github.com/MannParutthi/SOEN6441");
		repoData.setCloneUrl("https://github.com/MannParutthi/SOEN6441.git");
		repoData.setCreatedAt(new Date("Sun Sep 26 16:23:40 EDT 2021"));
		repoData.setUpdatedAt(new Date("Sun Sep 26 17:04:56 EDT 2021"));
		repoData.setSize(1);
		repoData.setOwner(new User().setLogin("MannParutthi"));

		repoContributorList = new ArrayList<Contributor>();
		Contributor contributor = new Contributor();
		contributor.setLogin("MannParutthi");
		contributor.setUrl("https://api.github.com/users/MannParutthi");
		repoContributorList.add(contributor);
		
		repoIssueList = new ArrayList<Issue>();
		Issue issue = new Issue();
		issue.setTitle("Null Pointer Exception");
		issue.setUrl("https://api.github.com/users/MannParutthi");
		repoIssueList.add(issue);
		
		repoCommitList = new ArrayList<RepositoryCommit>();
		RepositoryCommit commit = new RepositoryCommit();
		commit.setAuthor(new User().setLogin("MannParutthi"));
		commit.setUrl("https://api.github.com/repos/MannParutthi/COMP-6481/commits/64e2d10b3aed94d7cd3c2a60636dd26ef709f724");
		repoCommitList.add(commit);
	}

	/**
	 * This method unit tests the Repo Data Service
	 * 
	 * @return void
	 * 
	 */
	@org.junit.Test
	public void test_getRepoDataService() {

		
		try {
			when(repositoryService.getRepository("MannParutthi", "COMP-6481")).thenReturn(repoData);
			when(repositoryService.getContributors(repoData, false)).thenReturn(repoContributorList);
			when(issueService.getIssues(repoData, null)).thenReturn(repoIssueList);
			when(commitService.getCommits(repoData)).thenReturn(repoCommitList);
			
			RepoDataModel repoData = repoDataService.getRepoData("MannParutthi", "COMP-6481").toCompletableFuture().get();
			assertEquals(repoData.getId(), 1);
			assertEquals(repoData.getIssues().get(0).getTitle(), "Null Pointer Exception");
			assertEquals(repoData.getIssues().get(0).getUrl(), "https://api.github.com/users/MannParutthi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @Test
    public void testRepoNotFoundException()  {
       
		try {
			when(repositoryService.getRepository(anyString(), anyString())).thenThrow(new IOException());
			assertThrows(IOException.class, () -> {
				repoDataService.getRepoData("MannParutthi", "COMP-6481");
	            throw new IOException();
	        });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        
    }
}
