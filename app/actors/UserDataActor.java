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

	public static Props getProps( UserDataService s) {
		return Props.create(UserDataActor.class, () -> new UserDataActor(s));
	}

	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(UserDataReqDetails.class, this::sendUserData)
			        .build();
	}
	
	private void sendUserData(UserDataReqDetails reqData) {
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

