package services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

import model.RepoDataModel;

public class SearchForReposService {
	private RepositoryService repositoryService;
	private GitHubClient gitHubClient;
	
	public SearchForReposService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
	}
	
	public CompletableFuture<List<SearchRepository>> getReposWithKeyword(String keyword) {
		
		return CompletableFuture.supplyAsync(() -> {
			List<SearchRepository> listOfRepos = null;
			try {
				listOfRepos = repositoryService.searchRepositories(keyword).stream().limit(10).collect(Collectors.toList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listOfRepos;
		});
	}
}
