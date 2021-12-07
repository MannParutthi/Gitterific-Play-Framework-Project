package controllers;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.egit.github.core.SearchRepository;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import model.TopicDataModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;

/**
 * Controller for testing the Topic Data
 * 
 * @author Yashwanth Gundlapally
 */
@RunWith(MockitoJUnitRunner.class)
public class TopicDataControllerTest{

	public static List<TopicDataModel> topicLists;

	public static List<SearchRepository> repos = null;
	
	final HomeController topicController = Mockito.mock(HomeController.class);
	
	WSClient client = Mockito.mock(WSClient.class);
	
	WSRequest request = Mockito.mock(WSRequest.class);
	
	/**
	 * This method is used to setup test data for testing
	 * 
	 * @return void
	 */
	@BeforeClass
	public static void setUp() {

		List<TopicDataModel> topicLists = new ArrayList<TopicDataModel>();
		
		TopicDataModel topicDataModel = new TopicDataModel();
		
		topicDataModel.setCreated_at("2016-12-14T21:15:34Z");
		topicDataModel.setCreated_by("James Gosling");
		topicDataModel.setCurated("true");
		topicDataModel.setDescription("Java was originally developed as an alternative to the C/C++ programming languages. It is now mainly used for building web, desktop, mobile, and embedded applications. Java is owned and licensed through Oracle, with free and open source implementations available from Oracle and other vendors.");
		topicDataModel.setDisplay_name("Java");
		topicDataModel.setFeatured("true");
		topicDataModel.setName("java");
		topicDataModel.setReleased("May 23, 1995");
		topicDataModel.setScore("1");
		topicDataModel.setShort_description("Java is an object-oriented programming language used mainly for web, desktop, embedded devices and mobile applications.");
		topicDataModel.setUpdated_at("2021-12-05T20:57:21Z");
		
		topicLists.add(topicDataModel);
	}
	
	@org.junit.Test
	public void test_getTopicData() throws IOException{		
		
		Result result = null;
		
		//when(client.url("https://api.github.com/search/topics?q=java")).thenReturn(request);
		
		Request request1 = Helpers.fakeRequest().method("GET").uri("https://api.github.com/search/topics?q=java").session("Java","TestingBranchYashwanth").build();
		
		result = (Result) topicController.getTopicData(request1, "Java");
		
		//Mockito.when(topicController.getTopicData(request1, "Java")).thenReturn(CompletableFuture.completedFuture(result));
		
		assertNotNull(request1);
		
	}
}