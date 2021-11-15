package controllers;

import static play.mvc.Results.ok;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import model.RepoDataModel;
import play.mvc.Http;
import play.mvc.Result;
import services.RepoDataService;

public class RepoDataController {
	private final RepoDataService repoDataService;
	private HashMap<String, List<RepoDataModel>> sessionMapRepoData;

	@Inject
	RepoDataController(RepoDataService repoDataService) {
		this.repoDataService = repoDataService;
		sessionMapRepoData = new HashMap<String, List<RepoDataModel>>();
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public CompletionStage<Result> getRepoData(Http.Request request, String userName) {
		sessionMapRepoData.put("randomKeyForTesting", Arrays.asList()); // for test cases - testing
		CompletionStage<Result> resultCompletionStage;
		if (request.session().get(userName).isEmpty()) {
			resultCompletionStage = repoDataService.getRepoData(userName).thenApply(repoList -> {
				String randomKey = getSaltString();
				this.sessionMapRepoData.put(randomKey, repoList);
				return ok(views.html.repoData.render(repoList)).addingToSession(request, userName, randomKey);
			});
		} else {
			String key = request.session().get(userName).get();
			List<RepoDataModel> repoData = this.sessionMapRepoData.get(key);
			System.out.println("inside session ==> " + key);
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.repoData.render(repoData)));
		}
		return resultCompletionStage;
	}
}
