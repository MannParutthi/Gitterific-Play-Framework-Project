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


public class RepoIssues {

    private IssueService issueService;
    private RepositoryService repositoryService;
    private GitHubClient gitHubClient;

    public IssueService getIssueService() {
        return issueService;
    }

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public GitHubClient getGitHubClient() {
        return gitHubClient;
    }

    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setGitHubClient(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    // TODO : Mock github service to cover below methods

    public RepoIssues() {
        gitHubClient = new GitHubClient();
        this.issueService = new IssueService(gitHubClient);
        this.repositoryService = new RepositoryService(gitHubClient);
    }

    public CompletionStage<String> getIssueReportFromRepo(String userName, String repo) {
        return CompletableFuture.supplyAsync(() -> fetchRepoIssues(userName, repo))
                .thenApplyAsync(RepoIssues::generateReport)
                .exceptionally(throwable -> "Error");

    }

    private List<Issue> fetchRepoIssues(String userName, String repo) {
        List<Issue> issues = null;
        try {
            Repository repository = this.repositoryService.getRepository(userName, repo);
            issues = this.issueService.getIssues(repository, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issues;
    }

    public static String generateReport(List<Issue> issues) {
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
