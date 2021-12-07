package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import services.RepoIssues;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Actor class for RepoIssues
 * 
 * @author Kevinkumar Patel
 *
 */
public class RepoIssuesActor extends AbstractActor {

    private RepoAnalyzer analyzer;

    public void setAnalyzer(RepoAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * 
	 * This method return the Props for RepoDataActor
	 * 
	 * @param RepoDataService
	 * @return akka.actor.Props
	 */
    public static Props props() {
        return Props.create(RepoIssuesActor.class);
    }

    public static final class GetReport {
        private String userName, repoName;

        public GetReport(String userName, String repoName) {
            this.userName = userName;
            this.repoName = repoName;
        }
    }

    public static final class SetAnalyzer {
        private RepoAnalyzer analyzer;

        public SetAnalyzer(RepoAnalyzer analyzer) {
            this.analyzer = analyzer;
        }
    }
    
    /**
     * Overriding the createReceive method for RepoIssues functionality
     * 
     * @return akka.Actor.AbstractActor.Receive
     */
    @Override 
    public Receive createReceive() {
        return receiveBuilder()
                .match(GetReport.class, this::onGetReport)
                .match(SetAnalyzer.class, setAnalyzer -> this.setAnalyzer(setAnalyzer.analyzer))
                .build();
    }

    /**
     * This method calls the RepoIssues
     * 
     * @param getReport
     */
    public void onGetReport(GetReport getReport) {
        CompletableFuture<String> result;
        if (getReport != null &&
                getReport.userName != null && !getReport.userName.isBlank() &&
                getReport.repoName != null && !getReport.repoName.isBlank()) {
            result = RepoAnalyzer.getIssueReportFromRepo(getReport.userName, getReport.repoName)
                    .exceptionally(throwable -> "Error");
        } else {
            result = CompletableFuture.supplyAsync(() -> "Error");
        }
        getSender().tell(result, getSender());
    }

    public static final class RepoAnalyzer {
        private static GitHubClient gitHubClient = new GitHubClient();
        private static IssueService issueService = new IssueService(gitHubClient);
        private static RepositoryService repositoryService = new RepositoryService(gitHubClient);

        public void setGitHubClient(GitHubClient gitHubClient) {
            RepoAnalyzer.gitHubClient = gitHubClient;
        }

        public void setIssueService(IssueService issueService) {
            RepoAnalyzer.issueService = issueService;
        }

        public void setRepositoryService(RepositoryService repositoryService) {
            RepoAnalyzer.repositoryService = repositoryService;
        }

        public static CompletableFuture<String> getIssueReportFromRepo(String userName, String repo) {
            return CompletableFuture.supplyAsync(() -> fetchRepoIssues(userName, repo))
                    .thenApplyAsync(RepoIssues::generateReport)
                    .exceptionally(throwable -> "Error");

        }

        /**
         * This method fetches the RepoIssues from api
         * 
         * @param userName
         * @param repo
         * @return List<issue>
         */
        public static List<Issue> fetchRepoIssues(String userName, String repo) {
            List<Issue> issues = null;
            try {
                Repository repository = repositoryService.getRepository(userName, repo);
                issues = issueService.getIssues(repository, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return issues;
        }
        
        /**
         * This method generates the list of issues
         * 
         * @param issues
         * @return String
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
}
