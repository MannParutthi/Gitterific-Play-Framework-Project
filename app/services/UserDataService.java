package services;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

public class UserDataService {	

	private UserService userService;
	private GitHubClient gitHubClient;
	
	public UserDataService() {
		gitHubClient = new GitHubClient();
		this.userService = new UserService(gitHubClient);
	}
	
	public CompletionStage<User> getUserData(String login) {
		return CompletableFuture.supplyAsync(() -> {
			User user = null;
			try {
				user = userService.getUser(login);
				System.out.println("chk ==> " + user.getId() + user.getEmail() + user.getHtmlUrl() + user.getPublicRepos());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		});
		
	}
}
