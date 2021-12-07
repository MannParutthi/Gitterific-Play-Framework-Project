package actors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.Duration;

import org.junit.Test;
import org.mockito.Mockito;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.Materializer;
import akka.testkit.javadsl.TestKit;
import controllers.HomeController;
import play.libs.streams.ActorFlow;
import play.mvc.Http.Request;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.WebSocket;
import play.test.Helpers;
import play.test.WithApplication;

/**
 * Test Class for SearchSupervisorActor
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
public class SearchSupervisorActorTest extends WithApplication{

	/**
	 * Test method for testing SupervisorActor
	 * 
	 * @return void
	 */
	@Test
	public void test_SupervisorActor() {
		final ActorSystem actorSystem = ActorSystem.create();
		ActorRef wsout = Mockito.mock(ActorRef.class);
		try {
			new TestKit(actorSystem) {{
			final Props props = SearchSupervisorActor.props(wsout);
			final ActorRef searchSupervisorActor = actorSystem.actorOf(props);
			searchSupervisorActor.tell(new SearchForRepoActor.RequestMsg("java"), ActorRef.noSender());
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


