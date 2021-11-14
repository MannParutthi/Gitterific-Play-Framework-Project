package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

import model.TopicDataModel;

public class TopicDataService{

	private RepositoryService repositoryService;
	private GitHubClient gitHubClient;
	//private AsyncCacheApi cache;
	//Cache<k, V> cache;
	
	public TopicDataService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
	}
	
	public CompletableFuture<List<TopicDataModel>> getRepositoryData(String keyword) {
		return CompletableFuture.supplyAsync(() -> {
			List<TopicDataModel> topicRepoList = new ArrayList<TopicDataModel>();
			List<SearchRepository> repoList = null;
			try {
				repoList = repositoryService.searchRepositories(keyword);
				for(SearchRepository searchRepository : repoList) {
					TopicDataModel topicDataModel = new TopicDataModel();
					topicDataModel.setCreatedAt(searchRepository.getCreatedAt());
					topicDataModel.setDescription(searchRepository.getDescription());
					topicDataModel.setId(searchRepository.getId());
					topicDataModel.setLanguage(searchRepository.getLanguage());
					topicDataModel.setName(searchRepository.getName());
					topicDataModel.setOwner(searchRepository.getOwner());
					topicDataModel.setUrl(searchRepository.getUrl());
					topicRepoList.add(topicDataModel);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Sorting Repositories using the Creation Date
			Collections.sort(topicRepoList, new Comparator<TopicDataModel>() {
				  public int compare(TopicDataModel o1, TopicDataModel o2) {
				      if (o1.getCreatedAt() == null || o2.getCreatedAt() == null)
				        return 0;
				      return o2.getCreatedAt().compareTo(o1.getCreatedAt());
				  }
				});
			
			// Filtering the first 10 Repositories
			return topicRepoList.stream().limit(10).collect(Collectors.toList());
		});
	}
}
