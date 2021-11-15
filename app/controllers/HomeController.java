package controllers;

//import java.io.File;
//import java.io.InputStream;
//import java.nio.ByteBuffer;
//import java.time.Duration;
//import java.time.temporal.ChronoUnit;
//import java.util.concurrent.CompletionStage;
//import java.util.function.Supplier;
//
//import javax.inject.Inject;
//
//import akka.stream.scaladsl.Source;
//import akka.util.ByteString;
//import play.api.libs.json.JsValue;
//import play.api.libs.ws.*;
//import play.api.mvc.MultipartFormData.Part;
//import play.mvc.*;
//import scala.xml.Elem;
//import scala.xml.NodeBuffer;

import javax.inject.Inject;
import javax.naming.directory.SearchResult;

//import org.eclipse.egit.github.core.Issue;

import org.eclipse.egit.github.core.SearchRepository;
import play.mvc.*;
//import services.GitHubService;
import play.libs.ws.*;
import utils.SessionHelper;
import views.html.index;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static java.util.stream.Collectors.toList;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController {

	
	 private final WSClient ws;

	  @Inject
	  public HomeController(WSClient ws) {
	    this.ws = ws;
	  }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(Http.Request request) {
        // Session Usage
        if (!SessionHelper.isSessionExist(request)) {
            return Results.ok(index.render()).addingToSession(request, SessionHelper.getSessionKey(), SessionHelper.getUserAgentNameFromRequest(request));
        }
        return Results.ok(views.html.index.render());
    }
    
    public CompletionStage<Result> getUserProfile(String name) {
    	WSRequest requestUser = ws.url("https://api.github.com/users/defunkt");
    	CompletionStage<? extends WSResponse> responsePromise = requestUser.get();
        return responsePromise.thenApply(response -> Results.ok(response.getBody()));
    }
    

}
