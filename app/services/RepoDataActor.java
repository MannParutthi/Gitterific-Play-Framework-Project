package services;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.RepoDataModel;

public class RepoDataActor extends AbstractActor {
	
	static public class RepoDataReqDetails {
		public final String userName, repoName;
		public RepoDataReqDetails(String userName, String repoName) {
			this.userName = userName;
			this.repoName = repoName;
		}
	}
	
	private final ActorRef ws;
	private final RepoDataService repoDataService;
	
	@Inject
	public RepoDataActor(final ActorRef wsOut, RepoDataService repoDataService) {
		this.ws = wsOut;
		this.repoDataService = repoDataService;
	}

	public static Props getProps() {
		return Props.create(RepoDataActor.class);
	}

	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(RepoDataReqDetails.class, this::sendRepoData)
			        .build();
	}
	
	private void sendRepoData(RepoDataReqDetails reqData) {
		CompletionStage<RepoDataModel> response = repoDataService.getRepoData(reqData.userName, reqData.repoName);
		ws.tell(response, self());
	}

}
