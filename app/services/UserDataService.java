package services;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

import model.UserDetails;

public class UserDataService {	

	private UserService userService;
	private GitHubClient gitHubClient;
	private UserDetails userDetails;
	
	public UserDataService() {
		gitHubClient = new GitHubClient();
		this.userService = new UserService(gitHubClient);
		
	}
	
	public CompletionStage<UserDetails> getUserData(String login) {
		userDetails = new UserDetails();
		return CompletableFuture.supplyAsync(() -> {
			User user = null;
			try {
				user = userService.getUser(login);
				userDetails.setCompany(user.getCompany());
				userDetails.setEmail(user.getEmail());
				userDetails.setId(user.getId());
				userDetails.setLocation(user.getLocation());
				userDetails.setAvatarUrl(user.getAvatarUrl());
				userDetails.setBlog(user.getBlog());
				userDetails.setCollaborators(user.getCollaborators());
				userDetails.setCompany(user.getCompany());
				userDetails.setName(user.getName());
				System.out.println("chk ==> " + user.getId() + user.getEmail() + user.getHtmlUrl() + user.getPublicRepos());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userDetails;
		});
		
	}

}
