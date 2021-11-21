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

/**
 * This TopicDataService Class is used to interact with API and get the repositories of matching topic 
 * 
 * @author Yashwanth Gundlapally
 *
 */
public class TopicDataService{
	
	private RepositoryService repositoryService;
	private GitHubClient gitHubClient;
	public List<TopicDataModel> topicRepoList;
	
	/**
	 * Default Constructor
	 */
	public TopicDataService() {
		gitHubClient = new GitHubClient();
		this.repositoryService = new RepositoryService(gitHubClient);
	}
	
	/**
	 * Gets the Repository Data for the given name
	 * @param keyword used for getting the Repository data
	 * @return Returns the list of repositories details for the given topic
	 */
	public CompletableFuture<List<TopicDataModel>> getRepositoryData(String keyword) {
		return CompletableFuture.supplyAsync(() -> {
			topicRepoList = new ArrayList<TopicDataModel>();
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
					topicDataModel.setSize(searchRepository.getSize());
					topicDataModel.setPushedAt(searchRepository.getPushedAt());
					topicRepoList.add(topicDataModel);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Sorting Repositories using the Creation Date
			Collections.sort(topicRepoList, new Comparator<TopicDataModel>() {
				  public int compare(TopicDataModel o1, TopicDataModel o2) {
				      if (o1.getPushedAt() == null || o2.getPushedAt() == null)
				        return 0;
				      return o2.getPushedAt().compareTo(o1.getPushedAt());
				  }
				});
			
			// Filtering the first 10 Repositories
			return topicRepoList.stream().limit(10).collect(Collectors.toList());
		});
	}
}
