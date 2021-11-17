package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.TopicDataModel;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.TopicDataService;

/**
 * Controller for testing the Topic Data
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class TopicDataControllerTest{

	@InjectMocks
	HomeController topicDataController;
	
	@Mock
	RepositoryService repositoryService;

	@Mock
	TopicDataService topicDataService;

	public static List<TopicDataModel> topicLists;

	public static List<SearchRepository> repos = null;
	
	@BeforeClass
	public static void setUp() {
		topicLists = new ArrayList<TopicDataModel>();

		TopicDataModel topicDataModel = new TopicDataModel();
		SearchRepository sr = new SearchRepository("Java", "John");
		topicDataModel.setCreatedAt(sr.getCreatedAt());
		topicDataModel.setDescription(sr.getDescription());
		topicDataModel.setId(sr.getId());
		topicDataModel.setLanguage(sr.getLanguage());
		topicDataModel.setName(sr.getName());
		topicDataModel.setOwner(sr.getOwner());
		topicDataModel.setUrl(sr.getUrl());
		topicDataModel.setPushedAt(sr.getPushedAt());
		topicDataModel.setSize(sr.getSize());
		topicLists.add(topicDataModel);
	}
	
	@org.junit.Test
	public void test_getRepoData() throws IOException {

		// Mocking
		when(topicDataService.getRepositoryData("android")).thenReturn((CompletableFuture.supplyAsync(() -> topicLists)));
		
		List<TopicDataModel> topicData = null;
		Result res1 = null;
		
		try {
			topicData = topicDataService.getRepositoryData("android").toCompletableFuture().get();
			
			Request request1 = Helpers.fakeRequest().method("GET").uri("/topicData/Java").build();
			res1 = topicDataController.getTopicData(request1, "android").toCompletableFuture().get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertEquals(topicLists.get(0).getId(), topicData.get(0).getId());
		assertEquals(HttpStatus.OK_200, res1.status());
		assertEquals(topicData.isEmpty(), false);
		assertEquals(topicData.get(0).getId(), topicLists.get(0).getId());
	}
	
	@org.junit.Test
	public void test_getRandomKey() {
		assertEquals(topicDataController.getSaltString().isEmpty(), false);
	}
}
	
//	@org.junit.Test
//	public void test_getRepositoryData() {
//		repos = new ArrayList<SearchRepository>();
//		
//		
//		
//	}
//		List<TopicDataModel> result = null;
//		
//		repos = new ArrayList<SearchRepository>();
//		
//		repos.add(new SearchRepository("Java", "John"));
//		repos.add(new SearchRepository("C", "Bala"));
//		
//		try {
//			when(repositoryService.searchRepositories("java")).thenReturn((List<SearchRepository>) (CompletableFuture.supplyAsync(() -> repos)));
//			try {
//				result = topicDataService.getRepositoryData("java").toCompletableFuture().get();
//			} catch (InterruptedException | ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("Java", result.get(0).getName());
//	}