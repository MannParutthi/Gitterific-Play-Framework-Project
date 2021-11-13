package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.reflect.TypeToken;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.junit.*;
import simulated.utils.JSONLoader;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.*;

public class RepoIssuesTest {

    Repository repository;
    Type issueListType;

    @Before
    public void init() {
        issueListType = new TypeToken<List<Issue>>() {}.getType();
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
        assertEquals(RepoIssues.generateReport(issues), "No issues present in the repository");
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

    @After
    public void destroy() {
        repository = null;
    }

}
