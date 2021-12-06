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

    public static Props props(ActorRef wsout) {
        return Props.create(SearchSupervisorActor.class, wsout);
    }
    
    @Override
    public void preStart() {
       	context().actorSelection("/user/searchForRepoActor/").tell(new SearchForRepoActor.RegisterMsg(), self());
    }

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(NewData.class, this::sendData)
				.build();
	}
	
	private void sendData(NewData newData) {
        final ObjectNode response = Json.newObject();
        for (int i=0; i< newData.data.size(); i++) {
        	response.put(String.valueOf(i), newData.data.get(i).getJson());
		}
        ws.tell(response, self());
    }
}
