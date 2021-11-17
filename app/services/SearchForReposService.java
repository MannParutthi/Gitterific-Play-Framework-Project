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
 * Service for Searching the Repo Service
 *
 */
public class SearchForReposService {
	private RepositoryService repositoryService;
	private GitHubClient gitHubClient;
	private final WSClient ws;

	/**
	 * Default Constructor
	 */
	@Inject
	public SearchForReposService(WSClient ws) {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
		this.ws = ws;
	}

	/**
	 * Gets the list of repos for the given repo name
	 * 
	 * @param keywordKeyword used for getting the Repositories
	 * @return Returns the List of Repositories for the given name
	 */
	public CompletableFuture<List<SearchRepoModel>> getReposWithKeyword(String keyword) {
		return CompletableFuture.supplyAsync(() -> {
			List<SearchRepoModel> searchRepoList = new ArrayList<SearchRepoModel>();
			WSRequest requestData = ws.url("https://api.github.com/search/repositories?q=topic:" + keyword);
			CompletionStage<? extends WSResponse> responsePromise = requestData.get();
			try {
				JsonNode json = responsePromise.thenApply((WSResponse r) -> {
					return r.asJson();
				}).toCompletableFuture().get();
				int i = 0;
				for (JsonNode repoData : json.findValue("items")) {
					SearchRepoModel repoModel = new SearchRepoModel();
					repoModel.setUserName(repoData.findValue("owner").findValue("login").toString());
					repoModel.setRepoName(repoData.findValue("name").toString());
					repoModel.setTopics(repoData.findValue("topics").toString().substring(1, repoData.findValue("topics").toString().length()-2).split(","));
					searchRepoList.add(repoModel);
					i++;
					if (i == 10) {
						break;
					}
				}
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
			return searchRepoList;

//		return CompletableFuture.supplyAsync(() -> {
//			List<SearchRepository> listOfRepos = null;
//			try {
//				listOfRepos = repositoryService.searchRepositories(keyword).stream().limit(10).collect(Collectors.toList());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return listOfRepos;
		});
	}
}
