package controllers;

import static play.mvc.Results.ok;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import play.mvc.Result;
import services.RepoIssues;

/**
 * This controller contains an action to render Repo Issues 
 * to the View Page 
 *
 */
public class RepoIssueController {
	private RepoIssues repoIssues;

	/**
	 * Constructor Injection for Repo Issues
	 * 
	 * @param repoIssues  Parameter for injection
	 */
	@Inject
	RepoIssueController(RepoIssues repoIssues) {
		this.repoIssues = repoIssues;
	}

	/**
	 * Method to get the Repository Issues for given username and repository
	 * 
	 * @param userName Username to get the Repo Issues
	 * @param repo	Repository Name to get the Repo Issues
	 * @return	Returns the Repo Issues for the given Username and Repository
	 */
	public CompletionStage<Result> getRepoIssues(String userName,String repo) {
		System.out.println(userName + "," + repo);
		return repoIssues.getIssueReportFromRepo(userName,repo)
				.thenApply(output -> ok(views.html.repoIssueShow.render(output)));
	}

}
