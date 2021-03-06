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

/**
 * Actor for fetching the Search Results
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
public class SearchForRepoActor extends AbstractActorWithTimers {
	private Set<ActorRef> userActors;
	private String key;

	public static final class Tick {
	}
	
	static public class RegisterMsg {
    }
	
	static public class RequestMsg {
		public String searchKeyword;
        public RequestMsg(String data) {
            this.searchKeyword = data;
        }
    }
	
	/**
     * 
	 * This method return the Props for SearchResultsActor
	 * 
	 * @param SearchForReposService
	 * @return akka.actor.Props
	 */
	static public Props getProps(SearchForReposService s) {
		return Props.create(SearchForRepoActor.class, () -> new SearchForRepoActor(s));
	}
	
	final SearchForReposService searchForReposService;
	@Inject
	public SearchForRepoActor(SearchForReposService s) {
		this.userActors = new HashSet<>();
		this.searchForReposService = s;
	 }

	/**
	 * This method is used to get the time
	 * 
	 * @return void
	 */
	@Override
	public void preStart() {
		Logger.info("SearchForRepoActor {} started", self());
		getTimers().startPeriodicTimer("Timer", new Tick(), Duration.create(10, TimeUnit.SECONDS));
	}

	/**
     * Overriding the createReceive method for SearchResults functionality
     * 
     * @return akka.Actor.AbstractActor.Receive
     */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Tick.class, msg -> notifyClients())
				.match(RegisterMsg.class, msg -> userActors.add(sender()))
				.match(RequestMsg.class, msg -> getMessage(msg.searchKeyword))
				.build();
	}
	
	/**
	 * This method returns the key
	 * 
	 * @return void
	 * @param key
	 */
	public void getMessage(String key) {
		System.out.println("msg is here "+key);
		this.key = key;
	}
	
	/**
	 * This method notifies when there are new results
	 * 
	 * @return void
	 */
	public void notifyClients() {
		System.out.println("inside notify ==> ");
		try {
			if(key != null) {
				List<SearchRepoModel> response = searchForReposService.getReposWithKeyword(key).get();
				SearchSupervisorActor.NewData newData = new SearchSupervisorActor.NewData(response);
				userActors.forEach(ar -> ar.tell(newData, self()));
			}
		}
		catch(InterruptedException e) {
			userActors.forEach(ar -> ar.tell(Arrays.asList(), self()));
		}
		catch(ExecutionException e) {
			userActors.forEach(ar -> ar.tell(Arrays.asList(), self()));
		}
	}
}
