package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

import akka.actor.ActorSystem;
import controllers.HomeController;
import model.TopicDataModel;
import play.Application;
import play.cache.SyncCacheApi;
import play.inject.Bindings;
import play.inject.guice.GuiceApplicationBuilder;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import static play.mvc.Results.ok;


/**
 * This class is used for testing the Topic Data Service
 * 
 * @author Yashwanth Gundlapally
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TopicDataServiceTest extends WithApplication {
	
	@Mock
	RepositoryService repositoryService;
	
	public static List<TopicDataModel> topicLists;
	
	static JsonNode json;
	
	public static List<SearchRepository> topicDataList;
	
	 public static class FakeTopicClient extends HomeController {
	        
		 @Inject
		 public FakeTopicClient(WSClient ws, SyncCacheApi cacheApi, SearchForReposService searchForReposService,
				RepoDataService repoDataService, RepoIssues repoIssues, TopicDataService topicDataService,
				UserDataService userDataService, ActorSystem system) {
			super(ws, cacheApi, searchForReposService, repoDataService, repoIssues, topicDataService, userDataService, system);
		}
	}
	
	 /**
	 * This method is used for DI Injection
	 * 
	 * @return play.Application
	 * 
	 */
	@Override
	protected Application provideApplication() {
	    return new GuiceApplicationBuilder()
	         .bindings(Bindings.bind(HomeController.class).to(FakeTopicClient.class))
	         .build();
	}
	
	/**
	 * This method is used for setting up the data for testing
	 * 
	 * @return void
	 * 
	 */
	@BeforeClass
	public static void setUp() {
		
		String jsonData = "{\"name\":\"graphql\",\"display_name\":\"GraphQL\",\"short_description\":\"GraphQLisaquerylanguageforAPIsandaruntimeforfulfillingthosequerieswithyourexistingdata.\",\"description\":\"GraphQLisadataquerylanguagedevelopedbyFacebook.ItprovidesanalternativetoRESTandad-hocwebservicearchitectures.Itallowsclientstodefinethestructureofthedatarequired,andexactlythesamestructureofthedataisreturnedfromtheserver.Itisastronglytypedruntimewhichallowsclientstodictatewhatdataisneeded.\",\"created_by\":\"Facebook\",\"released\":\"2015\",\"created_at\":\"2016-12-17T02:09:00Z\",\"updated_at\":\"2021-11-29T00:24:35Z\",\"featured\":true,\"curated\":true,\"score\":1}";
		
		json = Json.parse(jsonData);
		
		topicDataList = new ArrayList<SearchRepository>();
		
		topicDataList.add(null);
	}
	
	/**
	 * This method is used for testing the topic Data Service
	 * 
	 * @return void
	 */
	@org.junit.Test
	public void test_getTopicDataService() {
		TopicDataModel topicDataModel = new TopicDataModel();
		TopicDataModel topicDataModel1 = new TopicDataModel();
		topicDataModel.setCreated_at(json.get("created_at").asText());
		topicDataModel.setCreated_by(json.get("created_by").asText());
		topicDataModel.setCurated(json.get("curated").asText());
		topicDataModel.setDescription(json.get("description").asText());
		topicDataModel.setDisplay_name(json.get("display_name").asText());
		topicDataModel.setFeatured(json.get("featured").asText());
		topicDataModel.setName(json.get("name").asText());
		topicDataModel.setReleased(json.get("released").asText());
		topicDataModel.setScore(json.get("score").asText());
		topicDataModel.setShort_description(json.get("short_description").asText());
		topicDataModel.setUpdated_at(json.get("updated_at").asText());
		topicDataModel1.setDescription(null);
		topicDataModel1.setCreated_at(null);
		topicDataModel1.setCreated_by(null);
		topicDataModel1.setCurated(null);
		topicDataModel1.setDisplay_name(null);
		topicDataModel1.setFeatured(null);
		topicDataModel1.setName(null);
		topicDataModel1.setReleased(null);
		topicDataModel1.setScore(null);
		topicDataModel1.setShort_description(null);
		topicDataModel1.setUpdated_at(null);
		
		assertEquals(topicDataModel.getCreated_at(), "2016-12-17T02:09:00Z");
		assertEquals(topicDataModel.getCreated_by(), "Facebook");
		assertEquals(topicDataModel.getCurated(), "true");
		assertEquals(topicDataModel.getDescription(), "GraphQLisadataquerylanguagedevelopedbyFacebook.ItprovidesanalternativetoRESTandad-hocwebservicearchitectures.Itallowsclientstodefinethestructureofthedatarequired,andexactlythesamestructureofthedataisreturnedfromtheserver.Itisastronglytypedruntimewhichallowsclientstodictatewhatdataisneeded.");
		assertEquals(topicDataModel.getDisplay_name(), "GraphQL");
		assertEquals(topicDataModel.getFeatured(), "true");
		assertEquals(topicDataModel.getName(), "graphql");
		assertEquals(topicDataModel.getReleased(), "2015");
		assertEquals(topicDataModel.getScore(), "1");
		assertEquals(topicDataModel.getShort_description(), "GraphQLisaquerylanguageforAPIsandaruntimeforfulfillingthosequerieswithyourexistingdata.");
		assertEquals(topicDataModel.getUpdated_at(), "2021-11-29T00:24:35Z");
		assertEquals(topicDataModel1.getDescription(), "NA");
		assertEquals(topicDataModel1.getCreated_at(), "NA");
		assertEquals(topicDataModel1.getCreated_by(), "NA");
		assertEquals(topicDataModel1.getCurated(), "NA");
		assertEquals(topicDataModel1.getDescription(), "NA");
		assertEquals(topicDataModel1.getDisplay_name(), "NA");
		assertEquals(topicDataModel1.getFeatured(), "NA");
		assertEquals(topicDataModel1.getName(), "NA");
		assertEquals(topicDataModel1.getReleased(), "NA");
		assertEquals(topicDataModel1.getScore(), "NA");
		assertEquals(topicDataModel1.getShort_description(), "NA");
		assertEquals(topicDataModel1.getUpdated_at(), "NA");
	}
	
	/**
	 * Test method for testing TopicData
	 * 
	 * @return void
	 */
	@org.junit.Test
	public void test_topicDataServiceMethod()  {
		
		Result result = null;
		
		Http.RequestBuilder request1 = Helpers.fakeRequest().method("GET").uri("/topicData/Java");
		result = Helpers.route(app, request1);
		
		assertEquals(Http.Status.OK, result.status());     
		
	}
}
