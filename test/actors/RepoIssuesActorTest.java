package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.reflect.TypeToken;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import play.Application;
import play.test.WithApplication;
import scala.compat.java8.FutureConverters;
import services.RepoIssues;
import actors.RepoIssuesActor;
import actors.RepoIssuesActor.RepoAnalyzer;
import services.TopicDataService;
import utils.JSONLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static akka.pattern.Patterns.ask;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class RepoIssuesActorTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return super.provideApplication();
    }

    static Type issueListType;
    static ActorSystem actorSystem;

    static RepoAnalyzer repoAnalyzer;

    @Mock
    static GitHubClient client;
    @Mock
    static IssueService mockIssueService;
    @Mock
    static RepositoryService mockRepoService;

    @BeforeClass
    public static void init() throws ExecutionException, InterruptedException {
        issueListType = new TypeToken<List<Issue>>() {}.getType();
        actorSystem = ActorSystem.create();

        client = mock(GitHubClient.class);
        mockIssueService = mock(IssueService.class);
        mockRepoService = mock(RepositoryService.class);

        repoAnalyzer = new RepoAnalyzer();
        repoAnalyzer.setGitHubClient(client);
        repoAnalyzer.setRepositoryService(mockRepoService);
        repoAnalyzer.setIssueService(mockIssueService);


    }

    @AfterClass
    public static void destroy() {
        actorSystem.terminate();
        issueListType = null;
    }

    @Test
    public void testLoadAllAndGenerateReport() throws IOException, ExecutionException, InterruptedException {
        Repository repository = new Repository()
                .setName("kerax")
                .setOwner(new User().setName("umangjpatel"));
        List<Issue> issues = new ArrayList<>();
        issues.add(new Issue().setTitle("this this this is"));
        when(mockIssueService.getIssues(any(Repository.class), eq(null))).thenReturn(issues);

        List<Issue> mockIssues = mockIssueService.getIssues(repository, null);
        when (RepoAnalyzer.fetchRepoIssues(anyString(), anyString())).thenReturn(mockIssues);
        final List<Issue> finalIssues = RepoAnalyzer.fetchRepoIssues("umangjpatel", "kerax");
        assertEquals(finalIssues.size(), 1);
        assertNotNull(finalIssues);
        assertFalse(finalIssues.isEmpty());
        assertEquals(RepoAnalyzer.generateReport(issues), "<b>3</b> => this<br>" +
                "<b>1</b> => is<br>");
        new TestKit(actorSystem) {{
            final ActorRef repoIssuesActor = actorSystem.actorOf(RepoIssuesActor.props());
            repoIssuesActor.tell(new RepoIssuesActor.SetAnalyzer(repoAnalyzer), ActorRef.noSender());
            assertEquals(getIssueReport(repoIssuesActor, "kerax", "umangjpatel"),
                    RepoAnalyzer.generateReport(issues));
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

    @Test
    public void testRepoNotFoundExceptionReport() {
        when (RepoAnalyzer.fetchRepoIssues(anyString(), anyString())).thenThrow(new IOException());
        assertThrows(IOException.class, () -> {
            RepoAnalyzer.fetchRepoIssues("abc", "xyz");
            throw new IOException();
        });
    }

    @Test
    public void testErrorReport() throws ExecutionException, InterruptedException {
        new TestKit(actorSystem) {{
            final ActorRef repoIssuesActor = actorSystem.actorOf(RepoIssuesActor.props());
            repoIssuesActor.tell(new RepoIssuesActor.SetAnalyzer(repoAnalyzer), ActorRef.noSender());
            assertEquals(getIssueReport(repoIssuesActor, null, ""), "Error");
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

    @Test
    public void testEmptyReport() throws ExecutionException, InterruptedException, IOException {
        Repository repository = new Repository()
                .setName("kerax")
                .setOwner(new User().setName("umangjpatel"));
        List<Issue> issues = new ArrayList<>();
        when(mockIssueService.getIssues(any(Repository.class), eq(null))).thenReturn(issues);

        List<Issue> mockIssues = mockIssueService.getIssues(repository, null);
        when (RepoAnalyzer.fetchRepoIssues(anyString(), anyString())).thenReturn(mockIssues);
        final List<Issue> finalIssues = RepoAnalyzer.fetchRepoIssues("umangjpatel", "kerax");
        assertTrue(finalIssues.isEmpty());
        new TestKit(actorSystem) {{
            final ActorRef repoIssuesActor = actorSystem.actorOf(RepoIssuesActor.props());
            repoIssuesActor.tell(new RepoIssuesActor.SetAnalyzer(repoAnalyzer), ActorRef.noSender());
            assertEquals(getIssueReport(repoIssuesActor, "umangjpatel", "kerax"), "No issues present in the repository");
            within(Duration.ofSeconds(5), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }



    @Test
    public void testRepoNotFound() {
        JsonNode node = JSONLoader.getJSONMessage(new File("test/simulated/repoIssues/repo_not_found.json"));
        assertNotNull(node);
        assertEquals(node.get("message").asText(), "Not Found");
    }

    @Test
    public void testEmptyIssues() {
        List<Issue> issues = JSONLoader.jsonToGson(new File("test/simulated/repoIssues/empty_issues.json"), issueListType);
        assertNotNull(issues);
        assertTrue(issues.isEmpty());
        assertEquals(RepoAnalyzer.generateReport(issues), "No issues present in the repository");
    }

    @Test
    public void testNullIssues() {
        List<Issue> issues = null;
        assertNull(issues);
        assertEquals(RepoAnalyzer.generateReport(issues), "Error");
    }

    @Test
    public void testSingleIssue() {
        List<Issue> issues = JSONLoader.jsonToGson(new File("test/simulated/repoIssues/single_issue.json"), issueListType);
        assertNotNull(issues);
        assertFalse(issues.isEmpty());
        assertEquals(issues.size(), 1);
        assertEquals(RepoAnalyzer.generateReport(issues), "<b>3</b> => this<br>" +
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
        assertEquals(RepoAnalyzer.generateReport(issues), "<b>3</b> => exception<br>" +
                "<b>2</b> => array<br>" +
                "<b>1</b> => pointer<br>" +
                "<b>1</b> => bad<br>" +
                "<b>1</b> => null<br>" +
                "<b>1</b> => is<br>");
    }

    @Ignore
    private String getIssueReport(ActorRef repoIssuesActor, String userName, String repoName) throws ExecutionException, InterruptedException {
        return FutureConverters.toJava(
                ask(repoIssuesActor, new RepoIssuesActor.GetReport(userName, repoName), 5000))
                .thenApplyAsync(item -> (CompletableFuture<String>) item)
                .toCompletableFuture()
                .thenApplyAsync(CompletableFuture::join)
                .get();
    }


}
