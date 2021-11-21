package services;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.RequestException;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.Issue;

/**
 * This RepoIssuesService class is used to interact with API to get the RepoIssues
 *
 *@author Kevinkumar Patel
 */
public class RepoIssues {

    private IssueService issueService;
    private RepositoryService repositoryService;
    private GitHubClient gitHubClient;
    
    /**
     * Default Constructor
     */
    public RepoIssues() {
        this.gitHubClient = new GitHubClient();
        this.issueService = new IssueService(this.gitHubClient);
        this.repositoryService = new RepositoryService(this.gitHubClient);
    }

    /**
     * Sets the Issue Service
     * @param issueService used for setting the Issue Service
     * @return void
     */
    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * Sets the Repository Service
     * @param repositoryService used for setting the repository service
     * @return void
     */
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    /**
     * Sets the GitHub Client
     * @param gitHubClient used for setting the github client
     * @return void
     */
    public void setGitHubClient(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    /**
     * Gets the Issue Report from the Repository for the given username and repository
     * @param userName	Username to get the Issue Reports 
     * @param repo Repo Name to get the Issue Reports
     * @return Returns the list of Repo Issues for the given username and repository
     */
    public CompletableFuture<String> getIssueReportFromRepo(String userName, String repo) {
        return CompletableFuture.supplyAsync(() -> fetchRepoIssues(userName, repo))
                .thenApplyAsync(RepoIssues::generateReport)
                .exceptionally(throwable -> "Error");

    }
    /**
     * Fetches the List of Repo Issues for the given username and Repo
     * @param userName Username to get the List of Issues
     * @param repo Repository Name to fetch the list of Issues
     * @return Returns the List of Issues for the given username and repository
     */
    public List<Issue> fetchRepoIssues(String userName, String repo) {
        List<Issue> issues = null;
        try {
            Repository repository = repositoryService.getRepository(userName, repo);
            issues = this.issueService.getIssues(repository, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issues;
    }
    /**
     * Generates the Report for the list of uses provided
     * @param issues Issues to generate the report 
     * @return Returns the Report for the given list of issues
     */
    public static String generateReport(List<Issue> issues) {
        if (issues == null)
            return "Error";
        if (issues.isEmpty())
            return "No issues present in the repository";
        Map<String, Integer> map = issues.stream()
                .map(issue -> issue.getTitle().split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(word -> word.length() > 1)
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        map = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        StringBuilder builder = new StringBuilder();
        map.entrySet().stream()
                .map(e -> "<b>" + e.getValue() + "</b> => " + e.getKey() + "<br>")
                .forEach(builder::append);
        return builder.toString();
    }
}
