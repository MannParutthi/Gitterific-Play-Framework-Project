package actors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.mockito.Mockito;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import controllers.HomeController;
import model.UserDetails;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import services.UserDataService;

/**
 * This is the Test class for RepoDataActor
 * 
 * @author Harman Preet Kaur
 *
 */
public class UserDataActorTest{

	/**
	 * Test Case for UserDataActor
	 * 
	 * @return void
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void userActorTest() throws InterruptedException, ExecutionException {
		
		final HomeController userController = Mockito.mock(HomeController.class);
		
		WSClient client = Mockito.mock(WSClient.class);
		
		WSRequest request = Mockito.mock(WSRequest.class);
		
		when(client.url("https://api.github.com/users/harman8")).thenReturn(request);
		
		UserDataService userDataService = Mockito.mock(UserDataService.class);
		
		final ActorSystem actorSystem = ActorSystem.create();
		
		CompletionStage<Result> result = null;
		
		Result res1;
		
		try {
			UserDetails userDetails;
			userDetails = new UserDetails();
			userDetails.setName("test");
			userDetails.setId(44037806);
			userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
			userDetails.setBlog("");
			userDetails.setCompany("Symfony/Blackfire");
			userDetails.setFollowers(700);
			userDetails.setFollowing(20);
			userDetails.setHireable("false");
			userDetails.setHtmlUrl("https://github.com/harman8");
			userDetails.setPublicRepos(8);
			userDetails.setPublicGists(10);
			userDetails.setUrl("https://api.github.com/users/harman8");
			userDetails.setType("User");
			userDetails.setPrivateGists(0);
			userDetails.setRepoName(Arrays.asList("git"));

		
			Request request1 = Helpers.fakeRequest().method("GET").uri("https://api.github.com/users/harman8").session("harman8","randomKeyTest1995").build();
			result = (CompletionStage<Result>) userController.getUserData(request1, "harman8");

			Mockito.when(userController.getUserData(request1,"harman8")).thenReturn(result);
			
			new TestKit(actorSystem) {{
                final Props props = UserDataActor.getProps(new UserDataService(client));
                final ActorRef userActor = actorSystem.actorOf(props);
                userActor.tell("", getRef());
                within(Duration.ofSeconds(3), () -> {
                	expectNoMessage();
                	assertNotNull(request1);
                    return null;
                });
            }};
		} finally {
			TestKit.shutdownActorSystem(actorSystem);
		}
	}	
}
