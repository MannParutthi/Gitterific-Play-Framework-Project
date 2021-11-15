//package controllers;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//import org.eclipse.jetty.http.HttpStatus;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.jupiter.api.Test;
//
//
//import model.TopicDataModel;
//import play.mvc.Result;
//import services.TopicDataService;
//
//@RunWith(MockitoJUnitRunner.class)
public class TopicDataControllerTest{
	/*
	public static List<TopicDataModel> reposList;
	
	@InjectMocks
	TopicDataController topicDataController;
	
	@Mock
	TopicDataService topicDataService;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUp() {
		
		MockitoAnnotations.initMocks(TopicDataControllerTest.class);
		
		reposList = new ArrayList<TopicDataModel>();
		
		TopicDataModel topicDataModel = new TopicDataModel();
		topicDataModel.setCreatedAt(new Date("Tue Apr 02 01:52:50 EDT 2019"));
		topicDataModel.setDescription("iphone: Home Assistant Companion for Android");
		topicDataModel.setId("home-assistant/android");
		topicDataModel.setLanguage("Kotlin");
		topicDataModel.setName("android");
		topicDataModel.setOwner("home-assistant");
		topicDataModel.setUrl("https://github.com/home-assistant/android");
		reposList.add(topicDataModel);
	}
	
	@Test
	public void test_getRepositoryData() throws IOException {
		
		when(topicDataService.getRepositoryData("android")).thenReturn(CompletableFuture.supplyAsync(() -> reposList));
		
		List<TopicDataModel> topicList = null;
		
		Result result = null;
		try {
			result = topicDataController.getTopicData("Android").toCompletableFuture().get();
			topicList = topicDataService.getRepositoryData("Android").toCompletableFuture().get();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(reposList.get(0).getLanguage());
		assertNotNull(topicList);
		assertEquals(reposList.get(0).getId(), topicList.get(0).getId());
		assertEquals(HttpStatus.OK_200, result.status());
	}
	*/
}
