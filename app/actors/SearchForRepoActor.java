package actors;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import scala.concurrent.duration.Duration;
import services.SearchForReposService;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import controllers.HomeController;
import model.RepoDataModel;
import model.SearchRepoModel;
import play.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class SearchForRepoActor extends AbstractActorWithTimers {
	private Set<ActorRef> userActors;

	private static final class Tick {
	}
	
	static public class RegisterMsg {
    }
	
	static public Props getProps(SearchForReposService s) {
		return Props.create(SearchForRepoActor.class, () -> new SearchForRepoActor(s));
	}
	
	final SearchForReposService searchForReposService;
	@Inject
	public SearchForRepoActor(SearchForReposService s) {
		this.userActors = new HashSet<>();
		this.searchForReposService = s;
	 }

	@Override
	public void preStart() {
		Logger.info("SearchForRepoActor {} started", self());
		getTimers().startPeriodicTimer("Timer", new Tick(), Duration.create(15, TimeUnit.SECONDS));
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Tick.class, msg -> notifyClients())
				.match(RegisterMsg.class, msg -> userActors.add(sender()))
				.build();
	}
	
	private void notifyClients() {
		System.out.println("inside notify ==> " + userActors);
		try {
			List<SearchRepoModel> response = searchForReposService.getReposWithKeyword("octobox").get();
			SearchSupervisorActor.NewData newData = new SearchSupervisorActor.NewData(response);
			userActors.forEach(ar -> ar.tell(newData, self()));
		}
		catch(InterruptedException e) {
			userActors.forEach(ar -> ar.tell(Arrays.asList(), self()));
		}
		catch(ExecutionException e) {
			userActors.forEach(ar -> ar.tell(Arrays.asList(), self()));
		}
	}
}
