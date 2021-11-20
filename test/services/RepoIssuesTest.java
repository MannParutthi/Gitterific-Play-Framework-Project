package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.reflect.TypeToken;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.*;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import play.Application;
import play.test.WithApplication;
import utils.JSONLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;


/**
 * This class is used for testing the Repo Issues
 * 
 * @author Kevinkumar Patel
 *
 */
@RunWith(value = MockitoJUnitRunner.class)
public class RepoIssuesTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return super.provideApplication();
    }

    Type issueListType;
    @Mock
    GitHubClient client;
    @Mock
    IssueService mockIssueService;
    @Mock
    RepositoryService mockRepoService;
    @InjectMocks
    RepoIssues repoIssues;
    
    /**
     * This method is used for setting up the test data for testing
     *
     * @return void
     */
    @Before
    public void init() {
        issueListType = new TypeToken<List<Issue>>() {}.getType();
        MockitoAnnotations.initMocks(this);
        client = mock(GitHubClient.class);
        mockIssueService = mock(IssueService.class);
        mockRepoService = mock(RepositoryService.class);

        repoIssues = new RepoIssues();
        repoIssues.setGitHubClient(client);
        repoIssues.setRepositoryService(mockRepoService);
        repoIssues.setIssueService(mockIssueService);


    }

    /**
     * This method is used for testing the Issue Service
     * 
     * @return void
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testLoadAllAndGenerateReport() throws IOException {
        Repository repository = new Repository()
                .setName("kerax")
                .setOwner(new User().setName("umangjpatel"));
        List<Issue> issues = new ArrayList<>();
        issues.add(new Issue().setTitle("this this this is"));
        when(mockIssueService.getIssues(any(Repository.class), eq(null))).thenReturn(issues);

        List<Issue> mockIssues = mockIssueService.getIssues(repository, null);
        when (repoIssues.fetchRepoIssues(anyString(), anyString())).thenReturn(mockIssues);
        final List<Issue> finalIssues = repoIssues.fetchRepoIssues("umangjpatel", "kerax");
        assertEquals(finalIssues.size(), 1);
        assertNotNull(finalIssues);
        assertFalse(finalIssues.isEmpty());
        assertEquals(RepoIssues.generateReport(issues), "<b>3</b> => this<br>" +
                "<b>1</b> => is<br>");
    }

    @Test
    public void testRepoNotFoundExceptionReport() {
        when (repoIssues.fetchRepoIssues(anyString(), anyString())).thenThrow(new IOException());
        assertThrows(IOException.class, () -> {
            repoIssues.fetchRepoIssues("abc", "xyz");
            throw new IOException();
        });
    }

    @Test
    public void testEmptyIssuesReport() throws ExecutionException, InterruptedException {
        RepoIssues issues = mock(RepoIssues.class, CALLS_REAL_METHODS);
        when (issues.getIssueReportFromRepo(anyString(), anyString()))
                .thenReturn(CompletableFuture.supplyAsync(() -> RepoIssues.generateReport(new ArrayList<>())));
        CompletableFuture<String> result = issues.getIssueReportFromRepo("abc", "xyz");
        assertEquals(result.get(), "No issues present in the repository");
    }

    @Test
    public void testErrorReport() throws ExecutionException, InterruptedException {
        RepoIssues issues = mock(RepoIssues.class, CALLS_REAL_METHODS);
        when (issues.getIssueReportFromRepo(anyString(), anyString()))
                .thenReturn(CompletableFuture.supplyAsync(() -> RepoIssues.generateReport(null)));
        CompletableFuture<String> result = issues.getIssueReportFromRepo("abc", "xyz");
        assertEquals(result.get(), "Error");
    }
    
    /**
     * This method is used for testing the JSON Loader
     * 
     * @return void
     */
    @Test
    public void testRepoNotFound() {
        JsonNode node = JSONLoader.getJSONMessage(new File("test/simulated/repoIssues/repo_not_found.json"));
        assertNotNull(node);
        assertEquals(node.get("message").asText(), "Not Found");
    }

    /**
     * This method is used for testing the JSON Loader
     * 
     * @return void
     */
    @Test
    public void testEmptyIssues() {
        List<Issue> issues = JSONLoader.jsonToGson(new File("test/simulated/repoIssues/empty_issues.json"), issueListType);
        assertNotNull(issues);
        assertTrue(issues.isEmpty());
        assertEquals(RepoIssues.generateReport(issues), "No issues present in the repository");
    }

    /**
     * This method is used for testing the JSON Loader
     * 
     * @return void
     */
    @Test
    public void testNullIssues() {
        List<Issue> issues = null;
        assertNull(issues);
        assertEquals(RepoIssues.generateReport(issues), "Error");
    }

    @Test
    public void testSingleIssue() {
        List<Issue> issues = JSONLoader.jsonToGson(new File("test/simulated/repoIssues/single_issue.json"), issueListType);
        assertNotNull(issues);
        assertFalse(issues.isEmpty());
        assertEquals(issues.size(), 1);
        assertEquals(RepoIssues.generateReport(issues), "<b>3</b> => this<br>" +
                "<b>1</b> => is<br>");
    }

    /**
     * This method is used for testing the JSON Loader
     * 
     * @return void
     */
    @Test
    public void testManyIssues() {
        List<Issue> issues = JSONLoader.jsonToGson(new File("test/simulated/repoIssues/many_issues.json"), issueListType);
        assertNotNull(issues);
        assertFalse(issues.isEmpty());
        assertTrue(issues.size() > 1);
        assertEquals(RepoIssues.generateReport(issues), "<b>3</b> => exception<br>" +
                "<b>2</b> => array<br>" +
                "<b>1</b> => pointer<br>" +
                "<b>1</b> => bad<br>" +
                "<b>1</b> => null<br>" +
                "<b>1</b> => is<br>");
    }

    /**
     * This method is used to destroy the objects/references after testing
     * 
     * @return void
     * 
     */
    @After
    public void destroy() {
        issueListType = null;
    }

}
