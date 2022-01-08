package actors;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.Materializer;
import akka.testkit.TestProbe;
import akka.testkit.javadsl.TestKit;
import model.UserDetails;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.libs.oauth.OAuth;
import services.UserDataService;
import actors.UserDataActor;
import actors.UserDataActor.UserDataReqDetails;
import model.*;
import static org.mockito.Mockito.when;


public class UserDataActorTest {


	@Mock
	UserDataService userDataService;
	
	static ActorSystem actorSystem;
	UserDetails userDetails;
	
	@Before
	public  void setup() {
		actorSystem = ActorSystem.create();
		
		userDetails = new UserDetails();
		userDetails.setName("test");
		userDetails.setId(44037806);
		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
		userDetails.setBlog("http://fabien.potencier.org/");
		userDetails.setCompany("Symfony/Blackfire");
		userDetails.setFollowers(700);
		userDetails.setFollowing(20);
		userDetails.setHtmlUrl("https://github.com/fabpot");
		userDetails.setPublicRepos(8);
		userDetails.setPublicGists(10);
		userDetails.setUrl("https://api.github.com/users/fabpot");
		userDetails.setType("User");
		userDetails.setPrivateGists(0);

	}
	
	@After
	public void teardown() {
		TestKit.shutdownActorSystem(actorSystem);
		actorSystem = null;
	}
	
	@Test
	public void userActorTest() throws ExecutionException, InterruptedException {
		final TestKit testProbe = new TestKit(actorSystem);
		final UserDataService userDataService = Mockito.mock(UserDataService.class);
		when(userDataService.getUserData("harman8")).thenReturn(CompletableFuture.supplyAsync(() -> userDetails));
		
		System.out.println(actorSystem);
		final ActorRef userDataActor = actorSystem.actorOf(UserDataActor.getProps(userDataService));
		userDataActor.tell(new UserDataReqDetails("harman8"), testProbe.getRef());
		UserDetails user = testProbe.expectMsgClass(UserDetails.class);
		System.out.println("i am user--------- "+user);
		assertEquals(user.getName(),"test");

	}

}