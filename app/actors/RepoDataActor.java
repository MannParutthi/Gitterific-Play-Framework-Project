package actors;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.RepoDataModel;
import play.libs.ws.WSClient;
import services.RepoDataService;

public class RepoDataActor extends AbstractActor {
	
	static public class RepoDataReqDetails {
		public final String userName, repoName;
		public RepoDataReqDetails(String userName, String repoName) {
			this.userName = userName;
			this.repoName = repoName;
		}
	}
	
	private final RepoDataService repoDataService;
	
	@Inject
	public RepoDataActor( RepoDataService repoDataService) {
		this.repoDataService = repoDataService;
	}

	public static Props getProps( RepoDataService s) {
		return Props.create(RepoDataActor.class, () -> new RepoDataActor(s));
	}

	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(RepoDataReqDetails.class, this::sendRepoData)
			        .build();
	}
	
	private void sendRepoData(RepoDataReqDetails reqData) {
		try {
		CompletionStage<RepoDataModel> response = repoDataService.getRepoData(reqData.userName, reqData.repoName);
		System.out.println("response --> "+response);
		sender().tell(response.toCompletableFuture().get(), self());
		}
		catch(InterruptedException e) {
			sender().tell(new RepoDataModel(), self());
		}
		catch(ExecutionException e) {
			sender().tell(new RepoDataModel(), self());
		}
	}

}
