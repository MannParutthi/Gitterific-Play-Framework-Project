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
import play.mvc.Result;
import services.TopicDataService;

/**
 * Controller for testing the Topic Data
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class TopicDataControllerTest{

	@InjectMocks
	TopicDataController topicDataController;
	
	@Mock
	RepositoryService repositoryService;

	@Mock
	TopicDataService topicDataService;

	public static List<TopicDataModel> topicLists;

	List<SearchRepository> repos = null;
	
	@BeforeClass
	public static void setUp() {
		topicLists = new ArrayList<TopicDataModel>();

		TopicDataModel topicDataModel = new TopicDataModel();
		topicDataModel.setCreatedAt(new Date("Tue Apr 02 01:52:50 EDT 2019"));
		topicDataModel.setDescription("iphone: Home Assistant Companion for Android");
		topicDataModel.setId("home-assistant/android");
		topicDataModel.setLanguage("Kotlin");
		topicDataModel.setName("android");
		topicDataModel.setOwner("home-assistant");
		topicDataModel.setUrl("https://github.com/home-assistant/android");
		topicDataModel.setPushedAt(new Date("Mon Nov 15 18:15:17 EST 2021"));
		topicDataModel.setSize(7315);
		topicLists.add(topicDataModel);
				
	}
	
	@org.junit.Test
	public void test_getRepoData() throws IOException {

		// Mocking
		when(topicDataService.getRepositoryData("android")).thenReturn((CompletableFuture.supplyAsync(() -> topicLists)));
		
		List<TopicDataModel> topicData = null;
		Result res1 = null;
		//Result res2 = null;
		try {
			topicData = topicDataService.getRepositoryData("android").toCompletableFuture().get();
			res1 = topicDataController.getTopicData("android").toCompletableFuture().get();
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
}
