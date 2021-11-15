package controllers;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.eclipse.egit.github.core.User;

import play.mvc.Result;

import static play.mvc.Results.ok;
import services.UserDataService;


public class UserDataController {
	private final UserDataService userDataService;
	
	@Inject
	UserDataController(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	public CompletionStage<Result> getUserData(String userName) {
		CompletionStage<Result> resultCompletionStage = userDataService.getUserData(userName).thenApply(data -> ok(views.html.userData.render(data)));
		return resultCompletionStage;
	}
	
}
