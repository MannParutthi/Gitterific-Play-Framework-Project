package controllers;

import static play.mvc.Results.ok;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import play.mvc.Result;
import services.RepoIssues;

public class RepoIssueController {
	private RepoIssues repoIssues;

	@Inject
	RepoIssueController(RepoIssues repoIssues) {
		this.repoIssues = repoIssues;
	}

	public CompletionStage<Result> getRepoIssues(String userName,String repo) {
		System.out.println(userName + "," + repo);
		return repoIssues.getIssueReportFromRepo(userName,repo)
				.thenApply(output -> ok(views.html.repoIssueShow.render(output)));
	}

}
