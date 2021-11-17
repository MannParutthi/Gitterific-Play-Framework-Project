//package controllers;
//
//import java.util.Random;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.CompletionStage;
//
//import javax.inject.Inject;
//
//import org.eclipse.egit.github.core.User;
//
//import play.mvc.Http;
//import play.mvc.Result;
//
//import static play.mvc.Results.ok;
//import services.UserDataService;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//import model.UserDetails;
//
///**
// * This Controller contains an action to get the User data
// *
// */
//public class UserDataController {
//	private final UserDataService userDataService;
//	private HashMap<String, UserDetails> sessionMapUserData;
//	
//	/**
//	 * Constructor Injection for UserDataService
//	 * @param userDataService
//	 */
//	@Inject
//	UserDataController(UserDataService userDataService) {
//		this.userDataService = userDataService;
//		//sessionMapUserData = new HashMap<String, UserDetails>();
//	}
//	
//	/**
//	 * This method get the User Data for a given username
//	 * @param userName This username is used to get the data of the User
//	 * @return Returns the data of the given User
//	 */
//	public CompletionStage<Result> getUserData(String userName) {
//		CompletionStage<Result> resultCompletionStage = userDataService.getUserData(userName).thenApply(data -> ok(views.html.userData.render(data)));
//		return resultCompletionStage;
//	}
//	
//	/**
//	 * Method to get the Randomkey for session management
//	 * @return Returns the random string
//	 */
//	protected String getSaltString() {
//		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//		StringBuilder salt = new StringBuilder();
//		Random rnd = new Random();
//		while (salt.length() < 18) { // length of the random string.
//			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
//			salt.append(SALTCHARS.charAt(index));
//		}
//		String saltStr = salt.toString();
//		return saltStr;
//	}
//
//	public CompletionStage<Result> getUserData(Http.Request request, String userName) {
//		sessionMapUserData.put("randomKeyTesting", new UserDetails());
//		CompletionStage<Result> resultCompletionStage;
//		if (!request.session().get(userName).isPresent()) {
//			resultCompletionStage = userDataService.getUserData(userName).thenApply(userList -> {
//				String randomKey = getSaltString();
//				System.out.println("my random key ----->"+randomKey);
//				this.sessionMapUserData.put(randomKey, userList);
//				return ok(views.html.userData.render(userList)).addingToSession(request, userName, randomKey);
//			});
//		} else {
//			String key = request.session().get(userName).get();
//			UserDetails userData = this.sessionMapUserData.get(key);
//			System.out.println("inside session ==> " + key);
//			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.userData.render(userData)));
//		}
//		return resultCompletionStage;
//	}
//	
//}
