package controllers;

import static play.mvc.Results.ok;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import play.mvc.Result;
import services.RepoDataService;

public class RepoDataController {
	private final RepoDataService repoDataService;
	
	@Inject
	RepoDataController(RepoDataService repoDataService) {
		this.repoDataService = repoDataService;
	}
	
	public CompletionStage<Result> getRepoData(String userName) {
		CompletionStage<Result> resultCompletionStage = repoDataService.getRepoData(userName).thenApply(repoList -> ok(views.html.repoData.render(repoList)));
		return resultCompletionStage;
	}
}
