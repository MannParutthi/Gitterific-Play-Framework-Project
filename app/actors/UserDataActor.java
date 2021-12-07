package actors;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.UserDetails;
import play.libs.ws.WSClient;
import services.UserDataService;

/**
 * This is the class for UserDataActor
 * 
 * @author Harman Preet Kaur
 *
 */
public class UserDataActor extends AbstractActor {
	
	static public class UserDataReqDetails {
		public final String userName;
		public UserDataReqDetails(String userName) {
			this.userName = userName;
		}
	}
	
	private final UserDataService userDataService;
	
	@Inject
	public UserDataActor( UserDataService userDataService) {
		this.userDataService = userDataService;
	}

	/**
     * 
	 * This method return the Props for UserDataActor
	 * 
	 * @param UserDataService
	 * @return akka.actor.Props
	 */
	public static Props getProps( UserDataService s) {
		return Props.create(UserDataActor.class, () -> new UserDataActor(s));
	}

	/**
     * Overriding the createReceive method for UserDataActor functionality
     * 
     * @return akka.Actor.AbstractActor.Receive
     */
	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(UserDataReqDetails.class, this::sendUserData)
			        .build();
	}
	
	/**
	 * This method is used to Send Data
	 * 
	 * @param newData
	 * @return void
	 */
	public void sendUserData(UserDataReqDetails reqData) {
		try {
		CompletionStage<UserDetails> response = userDataService.getUserData(reqData.userName);
		System.out.println("response --> "+response);
		sender().tell(response.toCompletableFuture().get(), self());
		}
		catch(InterruptedException e) {
			sender().tell(new UserDetails(), self());
		}
		catch(ExecutionException e) {
			sender().tell(new UserDetails(), self());
		}
	}

}

