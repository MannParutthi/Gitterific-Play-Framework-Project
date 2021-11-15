package services;

import java.io.IOException;
import java.util.ArrayList;
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


public class RepoDataService {
	
	private RepositoryService repositoryService;
	private IssueService issueService;
	private CommitService commitService;
	private GitHubClient gitHubClient;
	
	public RepoDataService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
		this.issueService = new IssueService(gitHubClient);
		this.commitService = new CommitService(gitHubClient);
	}
	
	public CompletionStage<List<RepoDataModel>> getRepoData(String userName) {
		return CompletableFuture.supplyAsync(() -> {		
			List<RepoDataModel> repoData = new ArrayList<RepoDataModel>();
			try {
				List<Repository> repoList = repositoryService.getRepositories(userName);	
				for (Repository repository : repoList) {
					RepoDataModel repoDetails = new RepoDataModel();
					repoDetails.setName(repository.getName());
					repoDetails.setId(repository.getId());
					repoDetails.setDescription(repository.getDescription());
					repoDetails.setLanguage(repository.getLanguage());
					repoDetails.setUrl(repository.getHtmlUrl());
					repoDetails.setCloneUrl(repository.getCloneUrl());
					repoDetails.setCreatedOn(repository.getCreatedAt());
					repoDetails.setLastUpdatedOn(repository.getUpdatedAt());
					
					List<RepoContributorModel> repoContributorList = new ArrayList<RepoContributorModel>();
					List<Contributor> contributorList = repositoryService.getContributors(repository, false);
					for (Contributor contributor : contributorList) {
						RepoContributorModel repoContributorDetails = new RepoContributorModel();
						repoContributorDetails.setLoginName(contributor.getLogin());
						repoContributorDetails.setUrl(contributor.getUrl());
						repoContributorList.add(repoContributorDetails);
					}
					repoDetails.setContributors(repoContributorList);
					
					List<RepoIssueModel> repoIssueList = new ArrayList<RepoIssueModel>();
					List<Issue> issueList = issueService.getIssues(repository, null).stream().limit(20).collect(Collectors.toList());
					for (Issue issue : issueList) {
						RepoIssueModel repoIssueDetails = new RepoIssueModel();
						repoIssueDetails.setTitle(issue.getTitle());
						repoIssueDetails.setUrl(issue.getUrl());
						repoIssueList.add(repoIssueDetails);
					}
					repoDetails.setIssues(repoIssueList);
					
					List<RepoCommitModel> repoCommitList = new ArrayList<RepoCommitModel>();
					List<RepositoryCommit> commitList = commitService.getCommits(repository);
					for (RepositoryCommit commit : commitList) {
						RepoCommitModel repoCommitDetails = new RepoCommitModel();
						repoCommitDetails.setLoginName(commit.getAuthor().getLogin());
						repoCommitDetails.setUrl(commit.getUrl());
						repoCommitList.add(repoCommitDetails);
					}
					repoDetails.setCommits(repoCommitList);
					
					repoData.add(repoDetails);
				} 
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return repoData;
		});
	}

}
