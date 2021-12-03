package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;

import play.api.libs.ws.WSClient;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Http.Request;
import play.test.Helpers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static play.mvc.Results.ok;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.TopicDataModel;
import model.UserDetails;
import services.UserDataService;
import play.test.WithApplication;


/**
 * Service for testing the User Data
 * 
 * @author Harman Preet Kaur
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDataServiceTest extends WithApplication{
	
	@InjectMocks
	UserDataService userDataService;
	
	@Mock
	UserService userService;
	
	@Mock
	RepositoryService repositoryService;
	
//	static
//	UserDetails userDetails;
	@Mock
	WSClient wsClientMock; 
	
	//@Mock
	static User user;
	
	//@Mock
	static List<Repository> repoList;
	
	//@Mock
	static Repository repository;
	
	public static JsonNode userJson;
	public static JsonNode repoJson;
	
	/**
	 * This method is used for setting up the test data for testing
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			repoJson = objectMapper.readTree(new File("test/simulated/userData/reposSampleData.json"));
			userJson = objectMapper.readTree(new File("test/simulated/userData/userSampleData.json"));
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@org.junit.Test
	public void test_getUserDataService() {
		UserDetails userDataModel = new UserDetails();

	
		userDataModel.setEmail(userJson.get("email").asText());
		userDataModel.setId(userJson.get("id").asInt());
		userDataModel.setLocation(userJson.get("location").asText());
		userDataModel.setAvatarUrl(userJson.get("avatar_url").asText());
		userDataModel.setBlog(userJson.get("blog").asText());
		userDataModel.setCompany(userJson.get("company").asText());
		userDataModel.setName(userJson.get("name").asText());
		userDataModel.setCreatedAt(userJson.get("created_at").asText());
		userDataModel.setFollowers(userJson.get("followers").asInt());
		userDataModel.setFollowing(userJson.get("following").asInt());
		userDataModel.setHireable(userJson.get("hireable").asText());
		userDataModel.setHtmlUrl(userJson.get("html_url").asText());
		userDataModel.setLogin(userJson.get("login").asText());
		userDataModel.setPublicGists(userJson.get("public_gists").asInt());
		userDataModel.setPublicRepos(userJson.get("public_repos").asInt());
		userDataModel.setType(userJson.get("type").asText());
		userDataModel.setUrl(userJson.get("url").asText());
		
		assertEquals(userDataModel.getEmail(),"null");
		assertEquals(userDataModel.getId(),44037806);
		assertEquals(userDataModel.getLocation(),"null");
		assertEquals(userDataModel.getAvatarUrl(),"https://avatars.githubusercontent.com/u/44037806?v=4");
		assertEquals(userDataModel.getBlog(),"");
		assertEquals(userDataModel.getCompany(),"null");
		assertEquals(userDataModel.getName(),"null");
		assertEquals(userDataModel.getCreatedAt(),"2018-10-10T19:23:36Z");
		assertEquals(userDataModel.getFollowers(),0);
		assertEquals(userDataModel.getFollowing(),0);
		assertEquals(userDataModel.isHireable(),"null");
		assertEquals(userDataModel.getHtmlUrl(),"https://github.com/harman8");
		assertEquals(userDataModel.getLogin(),"harman8");
		assertEquals(userDataModel.getPublicGists(),0);
		assertEquals(userDataModel.getPublicRepos(),1);
		assertEquals(userDataModel.getType(),"User");
		assertEquals(userDataModel.getUrl(),"https://api.github.com/users/harman8");
		
	}

	
	@org.junit.Test
	public void test_userDataServiceMethod()  {
		
		Result result = null;
		
		Http.RequestBuilder request1 = new Http.RequestBuilder().method("GET").uri("/userData/harman8");
		
		result = Helpers.route(app, request1);
		
		assertEquals(Http.Status.OK, result.status());
	}
	
}
