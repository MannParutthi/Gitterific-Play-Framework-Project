package controllers;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.egit.github.core.SearchRepository;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.TopicDataModel;
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
		//TopicDataModel topicDataModel2 = new TopicDataModel();
				
		topicDataModel1.setCreated_at("");
		topicDataModel1.setCreated_by("");
		topicDataModel1.setCurated("");
		topicDataModel1.setDescription("");
		topicDataModel1.setDisplay_name("");
		topicDataModel1.setFeatured("");
		topicDataModel1.setName("");
		topicDataModel1.setReleased("");
		topicDataModel1.setScore("");
		topicDataModel1.setShort_description("");
		topicDataModel1.setUpdated_at("");
//		
//		topicDataModel2.setCreatedAt(new Date("Sun Sep 26 17:04:56 EDT 2021"));
//		topicDataModel2.setDescription("Java Project");
//		topicDataModel2.setId("Java_1");
//		topicDataModel2.setLanguage("Java");
//		topicDataModel2.setName("Play");
//		topicDataModel2.setOwner("Yashwanth");
//		topicDataModel2.setUrl("https://github.com/Yashwanth-G/Kafka-Project");
//		topicDataModel2.setPushedAt(new Date("Mon Sep 28 19:04:57 EDT 2021"));
//		topicDataModel2.setSize(12345);
		
		topicLists.add(topicDataModel1);
		//topicLists.add(topicDataModel2);
	}
	
	/**
	 * This method tests the Topic Data Controller
	 * 
	 * @return void
	 * @throws IOException
	 */
//	@org.junit.Test
//	public void test_getTopicData() throws IOException {
//
//		// Mocking
//		//when(topicDataService.getRepositoryData("Java")).thenReturn((CompletableFuture.supplyAsync(() -> topicLists)));
//		
//		List<TopicDataModel> topicData = null;
//		Result result1 = null, result2 = null, result3 = null, result4 = null;
//		
//		try {
//			//topicData = topicDataService.getRepositoryData("Java").toCompletableFuture().get();
//			
//			//Request request1 = Helpers.fakeRequest().method("GET").uri("/topicData/Java").build();
//			//result1 = topicDataController.getTopicData(request1, "Java").toCompletableFuture().get();
//			
//			//Request request2 = Helpers.fakeRequest().method("GET").uri("topicData/Java").session("Java","TestingBranchYashwanth").build();
//			//result2 = topicDataController.getTopicData(request2, "Java").toCompletableFuture().get();
//
//			//Request request3 = Helpers.fakeRequest().method("GET").uri("topicData/Java").session("Java","TestingTopicDataModel").build();
//			//result3 = topicDataController.getTopicData(request3, "Java").toCompletableFuture().get();
//			
//			//Request request4 = Helpers.fakeRequest().method("GET").uri("topicData/Java").session("Java","Testing").build();
//			//result4 = topicDataController.getTopicData(request4, "Java").toCompletableFuture().get();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		//System.out.println("Topic Data Controller Test Status: "+result1.status());
//		
//		//assertEquals(topicLists.get(0).getScore(), topicData.get(0).getScore());
//		assertEquals(HttpStatus.OK_200, result1.status());
//		//assertEquals(HttpStatus.OK_200, result2.status());
//		//assertEquals(HttpStatus.OK_200, result3.status());
//		//assertEquals(HttpStatus.OK_200, result4.status());
//		//assertEquals(HttpStatus., result3.status());
//		//assertEquals(topicData.isEmpty(), false);
//	}
	
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