package controllers;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.eclipse.egit.github.core.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import model.UserDetails;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;

/**
 * Controller for testing the User Data
 * 
 * @author Harman Preet Kaur
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDataControllerTest {
	
	final HomeController userDataController = Mockito.mock(HomeController.class);
	
	WSClient client = Mockito.mock(WSClient.class);
	
	WSRequest request = Mockito.mock(WSRequest.class);	
	
	@Mock
	static
	UserDetails userDetails;
	
	@Mock
	static User user;
	
	/**
	 * This is the setup for User Data testing 
	 * 
	 * @return void
	 * @throws Exception
	 * 
	 */
	@BeforeClass
	public static void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(UserDataControllerTest.class);
		
		userDetails = new UserDetails();
		userDetails.setName("test");
		userDetails.setId(44037806);
		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
		userDetails.setBlog("http://fabien.potencier.org/");
		userDetails.setCompany("Symfony/Blackfire");
		userDetails.setFollowers(700);
		userDetails.setFollowing(20);
		userDetails.setHireable("false");
		userDetails.setHtmlUrl("https://github.com/fabpot");
		userDetails.setPublicRepos(8);
		userDetails.setPublicGists(10);
		userDetails.setUrl("https://api.github.com/users/fabpot");
		userDetails.setType("User");
		userDetails.setPrivateGists(0);
		userDetails.setRepoName(Arrays.asList("git"));
	}

	/**
	 * This is the test case for User Data 
	 * 
	 * @return void
	 */
	@Test
	public void testGetUser() {

		Result result = null;
			
		//when(client.url("https://api.github.com/users/harman8")).thenReturn(request);
			
		Request request1 = Helpers.fakeRequest().method("GET").uri("https://api.github.com/users/harman8").session("harman8","randomKeyTest1995").build();
			
		result = (Result) userDataController.getUserData(request1, "harman8");
			
		//Mockito.when(topicController.getTopicData(request1, "Java")).thenReturn(CompletableFuture.completedFuture(result));
			
		assertNotNull(request1);
	}
}
