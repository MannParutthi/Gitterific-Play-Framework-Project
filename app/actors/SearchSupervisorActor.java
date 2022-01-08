package actors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import model.SearchRepoModel;
import play.Logger;
import play.libs.Json;

/**
 * This class is used for Supervisor Actor
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
public class SearchSupervisorActor extends AbstractActor {
	private final ActorRef ws;
    
    static public class NewData {
        public final List<SearchRepoModel> data;
        public NewData(List<SearchRepoModel> data) {
            this.data = data;
        }
    }

    public SearchSupervisorActor(final ActorRef wsOut) {
    	ws =  wsOut;
    	Logger.debug("New SearchSupervisorActor {} for WebSocket {}; SearchForRepoActor= {}", self(), wsOut);
    }

    /**
     * This method return the Props for SupervisorActor
     * 
     * @param wsout
     * @return
     */
    public static Props props(ActorRef wsout) {
        return Props.create(SearchSupervisorActor.class, wsout);
    }
    
    /**
     * This method is used to pre start the Supervisor Actor
     * 
     * @return void
     */
    @Override
    public void preStart() {
       	context().actorSelection("/user/supervisorStrategyActor/SearchForRepoActor/").tell(new SearchForRepoActor.RegisterMsg(), self());
    	//context().actorSelection("/user/SearchForRepoActor/").tell(new SearchForRepoActor.RegisterMsg(), self());
    }

    /**
     * Overriding the createReceive method for SupervisorActor functionality
     *
     * @return akka.Actor.AbstractActor.Receive
     */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(NewData.class, this::sendData)
				.build();
	}
	
	/**
	 * This method is used to Send Data
	 * 
	 * @param newData
	 * @return void
	 */
	public void sendData(NewData newData) {
        final ObjectNode response = Json.newObject();
        for (int i=0; i< newData.data.size(); i++) {
        	response.put(String.valueOf(i), newData.data.get(i).getJson());
		}
        ws.tell(response, self());
    }
}
