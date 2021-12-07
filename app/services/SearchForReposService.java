package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

import com.fasterxml.jackson.databind.JsonNode;

import model.RepoDataModel;
import model.SearchRepoModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

/**
 * This ServiceForReposService class is used for Searching the Repo Service
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
public class SearchForReposService {
	private WSClient ws;

	/**
	 * Default Constructor
	 */
	@Inject
	public SearchForReposService(WSClient ws) {
		this.ws = ws;
	}

	/**
	 * This method is used to set the Web Service Client
	 * 
	 * @param ws
	 * @return void
	 */
	public void setWs(WSClient ws) {
		this.ws = ws;
	}

	/**
	 * This method is used to get the list of repos for the given repo name
	 *
	 * @param keyword used for getting the Repositories
	 * @return CompletableFuture<List<SearchRepoModel>> Returns the list with contains the given keyword
	 */
	public CompletableFuture<List<SearchRepoModel>> getReposWithKeyword(String keyword) {
		return getRequestData(keyword)
				.thenApplyAsync(this::getSearchRepoModels);
	}

	/**
	 * This method is used to convert the WSResponse into JSON form
	 * 
	 * @param keyword
	 * @return CompletableFuture<JsonNode> Returns the converted JSON data
	 */
	public CompletableFuture<JsonNode> getRequestData(String keyword) {
		return ws.url("https://api.github.com/search/repositories?q=topic:" + keyword)
				.get().toCompletableFuture().thenApplyAsync(WSResponse::asJson);
	}

	/**
	 * This method is used to convert the JSON Object into List
	 * 
	 * @param json
	 * @return List<SearchRepoModel> 
	 */
	public List<SearchRepoModel> getSearchRepoModels(JsonNode json) {
		List<SearchRepoModel> searchRepoList = new ArrayList<>();
		int i = 0;
		for (JsonNode repoData : json.findValue("items")) {
			SearchRepoModel repoModel = new SearchRepoModel();
			repoModel.setUserName(repoData.findValue("owner").get("login").asText());
			repoModel.setRepoName(repoData.get("name").asText());
			repoModel.setTopics(repoData.get("topics").toString()
					.replace("[", "").replace("]", "")
					.replace("\"", "")
					.split(","));
			searchRepoList.add(repoModel);
			i++;
			if (i == 10) {
				break;
			}
		}
		return searchRepoList;
	}
}
