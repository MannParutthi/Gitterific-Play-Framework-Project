package services;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

public class TopicDataService {

	private RepositoryService repositoryService;
	private GitHubClient gitHubClient;
	
	public TopicDataService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
	}
	
	public CompletableFuture<List<SearchRepository>> getRepositoryData(String keyword) {
		return CompletableFuture.supplyAsync(() -> {
			List<SearchRepository> repoList = null;
			try {
				repoList = repositoryService.searchRepositories(keyword);
				for(int i = 0 ; i < repoList.size(); i++)
					System.out.println(repoList.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// Sorting Repositories using the Creation Date
			Collections.sort(repoList, new Comparator<SearchRepository>() {
				  public int compare(SearchRepository o1, SearchRepository o2) {
				      if (o1.getCreatedAt() == null || o2.getCreatedAt() == null)
				        return 0;
				      return o2.getCreatedAt().compareTo(o1.getCreatedAt());
				  }
				});
			
			
			// Filtering the first 10 Repositories
			List<SearchRepository> displayFirstTen = repoList.stream().limit(10).collect(Collectors.toList());
			return displayFirstTen;
		});
	}
}
