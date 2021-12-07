package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;

import com.fasterxml.jackson.databind.JsonNode;

import model.UserDetails;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

/**
 * This UserDataService class is used for fetching the user details from the API
 *
 * @author Harman Preet Kaur
 */
public class UserDataService {	

	private UserService userService;
	private GitHubClient gitHubClient;
	private UserDetails userDetails;
	private RepositoryService repositoryService;
	private WSClient ws;

	/**
	 * Default Constructor
	 */
	@Inject
	public UserDataService(WSClient ws) {
		this.ws = ws;
	}
	
	/**
	 * This method returns the User Data for the given login
	 * 
	 * @param login used for fetching the user data
	 * @return Returns the User Data for the given user
	 */
	public CompletionStage<UserDetails> getUserData(String login) {
		userDetails = new UserDetails();
		return CompletableFuture.supplyAsync(() -> {
			User user = null;
			List<Repository> repoList = null;
			try {
				
				JsonNode userJson = getJsonData("https://api.github.com/users/" + login , -1);
				JsonNode repoJson = getJsonData("https://api.github.com/users/" + login +"/repos", -1);
				List<String> listOfRepoNames = new ArrayList<String>();
				for (JsonNode repoName : repoJson) {
					listOfRepoNames.add(repoName.get("name").asText());
					System.out.println("this is repo name "+repoName.get("name").asText());
				}
				
				userDetails.setRepoName(listOfRepoNames);
				System.out.println("printttttttttttttttttttt "+userDetails.getRepoName());
				userDetails.setEmail(userJson.get("email").asText());
				userDetails.setId(userJson.get("id").asInt());
				userDetails.setLocation(userJson.get("location").asText());
				userDetails.setAvatarUrl(userJson.get("avatar_url").asText());
				userDetails.setBlog(userJson.get("blog").asText());
				userDetails.setCompany(userJson.get("company").asText());
				userDetails.setName(userJson.get("name").asText());
				userDetails.setCreatedAt(userJson.get("created_at").asText());
				userDetails.setFollowers(userJson.get("followers").asInt());
				userDetails.setFollowing(userJson.get("following").asInt());
				userDetails.setHireable(userJson.get("hireable").asText());
				userDetails.setHtmlUrl(userJson.get("html_url").asText());
				userDetails.setLogin(userJson.get("login").asText());
				userDetails.setPublicGists(userJson.get("public_gists").asInt());
				userDetails.setPublicRepos(userJson.get("public_repos").asInt());
				userDetails.setType(userJson.get("type").asText());
				userDetails.setUrl(userJson.get("url").asText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userDetails;
		});
		
	}
	
	/**
	 * This method returns the JsonNode for the given URI
	 * 
	 * @param url
	 * @param limit
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * @return JsonNode
	 */
	public JsonNode getJsonData(String url, int limit) throws InterruptedException, ExecutionException {
		if(limit == -1) {
			return ws.url(url).get().thenApply((WSResponse r) -> { return r.asJson(); }).toCompletableFuture().get();
		}
		else {
			//use limit here - stream().limit()
			return ws.url(url).get().thenApply((WSResponse r) -> { return r.asJson(); }).toCompletableFuture().get();
		}
		
	}
}
