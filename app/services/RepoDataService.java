package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.Contributor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;

import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.mvc.Http.Session;

/**
 * Service Class for Repository Data
 *
 * @author Manan Dineshbhai Paruthi
 *
 */
public class RepoDataService {

	private RepositoryService repositoryService;
	private IssueService issueService;
	private CommitService commitService;
	private GitHubClient gitHubClient;

	/**
	 * Default Constructor
	 */
	public RepoDataService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
		this.issueService = new IssueService(gitHubClient);
		this.commitService = new CommitService(gitHubClient);
	}

	/**
	 * Returns the list of Repository Data for the given username
	 * 
	 * @param userName Username to get the Repo Data
	 * @param repoName Repository name 
	 * @return Returns the Repository Data for the given User name and Repository name 
	 */
	public CompletionStage<RepoDataModel> getRepoData(String userName, String repoName) {
		return CompletableFuture.supplyAsync(() -> {
			RepoDataModel repoData = new RepoDataModel();
			try {
				Repository repository = repositoryService.getRepository(userName, repoName);
				repoData.setName(repository.getName());
				repoData.setId(repository.getId());
				repoData.setDescription(repository.getDescription());
				repoData.setLanguage(repository.getLanguage());
				repoData.setUrl(repository.getHtmlUrl());
				repoData.setCloneUrl(repository.getCloneUrl());
				repoData.setCreatedOn(repository.getCreatedAt());
				repoData.setLastUpdatedOn(repository.getUpdatedAt());
				repoData.setOwner(repository.getOwner().getLogin());

				List<RepoContributorModel> repoContributorList = new ArrayList<RepoContributorModel>();
				List<Contributor> contributorList = repositoryService.getContributors(repository, false);
				for (Contributor contributor : contributorList) {
					RepoContributorModel repoContributorDetails = new RepoContributorModel();
					repoContributorDetails.setLoginName(contributor.getLogin());
					repoContributorDetails.setUrl(contributor.getUrl());
					repoContributorList.add(repoContributorDetails);
				}
				repoData.setContributors(repoContributorList);repoData.setContributors(repoContributorList);
				

				List<RepoIssueModel> repoIssueList = new ArrayList<RepoIssueModel>();
				List<Issue> issueList = issueService.getIssues(repository, null).stream().limit(20)
						.collect(Collectors.toList());
				for (Issue issue : issueList) {
					RepoIssueModel repoIssueDetails = new RepoIssueModel();
					repoIssueDetails.setTitle(issue.getTitle());
					repoIssueDetails.setUrl(issue.getUrl());
					repoIssueList.add(repoIssueDetails);
				}
				repoData.setIssues(repoIssueList);

				List<RepoCommitModel> repoCommitList = new ArrayList<RepoCommitModel>();
				List<RepositoryCommit> commitList = Arrays.asList();
				if (repository.getSize() > 0) {
					commitList = commitService.getCommits(repository);
				}
				for (RepositoryCommit commit : commitList) {
					RepoCommitModel repoCommitDetails = new RepoCommitModel();
					repoCommitDetails.setLoginName(commit.getAuthor().getLogin());
					repoCommitDetails.setUrl(commit.getUrl());
					repoCommitList.add(repoCommitDetails);
				}
				repoData.setCommits(repoCommitList);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return repoData;
		});
	}

}
