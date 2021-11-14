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

import model.GitHubApi;

//import org.eclipse.egit.github.core.Issue;

import play.mvc.*;
import views.SearchDTO;
import play.i18n.MessagesApi;
import play.data.Form;
import play.data.FormFactory;
//import services.GitHubService;
import play.libs.ws.*;
import play.mvc.Http.Request;
import services.SearchForReposService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static java.util.stream.Collectors.toList;
import static play.mvc.Results.ok;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController {

	private final SearchForReposService searchForReposService;
	private final WSClient ws;

	@Inject
	private GitHubApi githubimpl;

	@Inject
	private FormFactory formFactory;

	@Inject
	private MessagesApi messagesApi;

	@Inject
	public HomeController(WSClient ws, SearchForReposService searchForReposService) {
		this.ws = ws;
		this.searchForReposService = searchForReposService;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */
	public Result index(Http.Request request) {
		return Results.ok(views.html.index.render(formFactory.form(SearchDTO.class), messagesApi.preferred(request)));
	}

	public CompletionStage<Result> getUserProfile(String name) {
		WSRequest requestUser = ws.url("https://api.github.com/users/defunkt");
		CompletionStage<? extends WSResponse> responsePromise = requestUser.get();
		return responsePromise.thenApply(response -> Results.ok(response.getBody()));
	}

	public Result github() {
		return Results.ok(githubimpl.getRepositoryInfo(10));
	}

	public CompletionStage<Result> getSearchResults(Http.Request request) {
		System.out.println("inside submit !!!!");
		Form<SearchDTO> form = formFactory.form(SearchDTO.class).bindFromRequest(request);
		
		System.out.println(request.queryString("searchTerm").get());
		
		CompletionStage<Result> resultCompletionStage = searchForReposService.getReposWithKeyword(request.queryString("searchTerm").get()).thenApply(data -> ok(views.html.searchResults.render(data)));
		return resultCompletionStage;
	}

}
