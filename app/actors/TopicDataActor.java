package actors;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.*;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.TopicDataModel;
import play.libs.ws.WSClient;
import services.TopicDataService;

/**
 * This is the class for TopicDataActor
 * 
 * 
 * @author Yashwanth Gundlapally
 *
 */
public class TopicDataActor extends AbstractActor {
	
	static public class TopicDataReqDetails {
		public final String topicName;
		public TopicDataReqDetails(String topicName) {
			this.topicName = topicName;
		}
	}
	
	private final TopicDataService topicDataService;
	
	@Inject
	public TopicDataActor(TopicDataService topicDataService) {
		this.topicDataService = topicDataService;
	}

	 /**
     * 
	 * This method return the Props for TopicDataActor
	 * 
	 * @param TopicDataService
	 * @return akka.actor.Props
	 */
	public static Props getProps(TopicDataService s) {
		return Props.create(TopicDataActor.class, () -> new TopicDataActor(s));
	}

	
	/**
     * Overriding the createReceive method for TopicDataActor functionality
     * 
     * @return akka.Actor.AbstractActor.Receive
     */
	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(TopicDataReqDetails.class, this::sendTopicData)
			        .build();
	}
	
	/**
	 * This method is used to Send Data
	 * 
	 * @param newData
	 * @return void
	 */
	public void sendTopicData(TopicDataReqDetails topicData) {
		try {
		CompletionStage<List<TopicDataModel>> response = topicDataService.getRepositoryData(topicData.topicName);
		System.out.println("response --> "+response);
		sender().tell(response.toCompletableFuture().get(), self());
		}
		catch(InterruptedException e) {
			sender().tell(new TopicDataModel(), self());
		}
		catch(ExecutionException e) {
			sender().tell(new TopicDataModel(), self());
		}
	}

}
