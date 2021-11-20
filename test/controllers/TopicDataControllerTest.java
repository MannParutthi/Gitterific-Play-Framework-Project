package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Yashwanth Gundlapally
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
	
	/**
	 * This method is used to setup test data for testing
	 * 
	 * @return void
	 */
	@BeforeClass
	public static void setUp() {
		topicLists = new ArrayList<TopicDataModel>();

		TopicDataModel topicDataModel1 = new TopicDataModel();
		TopicDataModel topicDataModel2 = new TopicDataModel();
		
		SearchRepository sr1 = new SearchRepository("Java", "John");
		SearchRepository sr2 = new SearchRepository("Java", "Adams");
		
		// for testing Date branch
		Date d1 = new Date("Sun Sep 26 17:04:56 EDT 2021");
		Date d2 = new Date("Mon Sep 28 19:04:57 EDT 2021");
		
		topicDataModel1.setCreatedAt(sr1.getCreatedAt());
		topicDataModel1.setDescription(sr1.getDescription());
		topicDataModel1.setId(sr1.getId());
		topicDataModel1.setLanguage(sr1.getLanguage());
		topicDataModel1.setName(sr1.getName());
		topicDataModel1.setOwner(sr1.getOwner());
		topicDataModel1.setUrl(sr1.getUrl());
		topicDataModel1.setPushedAt(d1);
		topicDataModel1.setSize(sr1.getSize());
		
		topicDataModel2.setCreatedAt(sr2.getCreatedAt());
		topicDataModel2.setDescription(sr2.getDescription());
		topicDataModel2.setId(sr2.getId());
		topicDataModel2.setLanguage(sr2.getLanguage());
		topicDataModel2.setName(sr2.getName());
		topicDataModel2.setOwner(sr2.getOwner());
		topicDataModel2.setUrl(sr2.getUrl());
		topicDataModel2.setPushedAt(d2);
		topicDataModel2.setSize(sr2.getSize());
		
		topicLists.add(topicDataModel1);
		topicLists.add(topicDataModel2);
	}
	
	/**
	 * This method tests the Topic Data Controller
	 * 
	 * @return void
	 * @throws IOException
	 */
	@org.junit.Test
	public void test_getTopicData() throws IOException {

		// Mocking
		when(topicDataService.getRepositoryData("android")).thenReturn((CompletableFuture.supplyAsync(() -> topicLists)));
		
		List<TopicDataModel> topicData = null;
		Result res1 = null;
		Result res2 = null;
		
		try {
			topicData = topicDataService.getRepositoryData("android").toCompletableFuture().get();
			
			Request request1 = Helpers.fakeRequest().method("GET").uri("/topicData/Java").build();
			res1 = topicDataController.getTopicData(request1, "android").toCompletableFuture().get();
			
			Request request2 = Helpers.fakeRequest().method("GET").uri("topicData/Java").session("Java","TestingTopicData").build();
			res2 = topicDataController.getTopicData(request2, "Java").toCompletableFuture().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertEquals(topicLists.get(0).getId(), topicData.get(0).getId());
		assertEquals(HttpStatus.OK_200, res1.status());
		//assertEquals(HttpStatus.OK_200, res2.status());
		assertEquals(topicData.isEmpty(), false);
	}
	
	/**
	 * This method tests the random key generator
	 * 
	 * @return void
	 * 
	 */
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