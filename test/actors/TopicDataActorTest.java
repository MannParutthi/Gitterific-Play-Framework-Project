package actors;

import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.mockito.Mockito;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import controllers.HomeController;
import model.TopicDataModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import services.TopicDataService;

public class TopicDataActorTest extends WithApplication{
	
	@Test
	public void test_Topic() throws InterruptedException, ExecutionException {
		final HomeController topicController = Mockito.mock(HomeController.class);
		WSClient client = Mockito.mock(WSClient.class);
		WSRequest request = Mockito.mock(WSRequest.class);
		//when(client.url("https://api.github.com/search/topics?q=java")).thenReturn(request);
		final ActorSystem actorSystem = ActorSystem.create();
		CompletionStage<Result> result = null;
		try {
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
			
			Request request1 = Helpers.fakeRequest().method("GET").uri("https://api.github.com/search/topics?q=java").session("Java","TestingBranchYashwanth").build();
			System.out.println("Request has body: "+request1.hasBody());
			result = (CompletionStage<Result>) topicController.getTopicData(request1, "Java");
			Mockito.when(topicController.getTopicData(request1, "Java")).thenReturn(result);
			
			new TestKit(actorSystem) {{
                final Props props = TopicDataActor.getProps(new TopicDataService(client));
                final ActorRef topicActor = actorSystem.actorOf(props);
                topicActor.tell("", getRef());
                within(Duration.ofSeconds(3), () -> {  
                    expectNoMessage();
                    return null;
                });
            }};
		} finally {
			TestKit.shutdownActorSystem(actorSystem);
		}
	}	
}
