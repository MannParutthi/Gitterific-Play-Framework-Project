package controllers;

import java.util.Random;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.eclipse.egit.github.core.User;

import play.mvc.Http;
import play.mvc.Result;

import static play.mvc.Results.ok;
import services.UserDataService;


public class UserDataController {
	private final UserDataService userDataService;
//	private HashMap<String, List<RepoDataModel>> sessionMapRepoData;
	
	@Inject
	UserDataController(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	public CompletionStage<Result> getUserData(String userName) {
		CompletionStage<Result> resultCompletionStage = userDataService.getUserData(userName).thenApply(data -> ok(views.html.userData.render(data)));
		return resultCompletionStage;
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

//	public CompletionStage<Result> getRepoData(Http.Request request, String userName) {
//		sessionMapRepoData.put("randomKeyForTesting", Arrays.asList());
//		CompletionStage<Result> resultCompletionStage;
//		if (request.session().get(userName).isEmpty()) {
//			resultCompletionStage = repoDataService.getRepoData(userName).thenApply(repoList -> {
//				String randomKey = getSaltString();
//				this.sessionMapRepoData.put(randomKey, repoList);
//				return ok(views.html.repoData.render(repoList)).addingToSession(request, userName, randomKey);
//			});
//		} else {
//			String key = request.session().get(userName).get();
//			List<RepoDataModel> repoData = this.sessionMapRepoData.get(key);
//			System.out.println("inside session ==> " + key);
//			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.repoData.render(repoData)));
//		}
//		return resultCompletionStage;
//	}
	
}
