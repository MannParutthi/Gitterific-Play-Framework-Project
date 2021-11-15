package controllers;

import javax.inject.Inject;
import org.eclipse.egit.github.core.SearchRepository;
import play.mvc.*;
import views.SearchDTO;
import play.i18n.MessagesApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.ws.*;
import services.SearchForReposService;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static play.mvc.Results.ok;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController {

	private final SearchForReposService searchForReposService;
	private final WSClient ws;
	private HashMap<String, List<SearchRepository>> sessionMapRepoData;

	@Inject
	private FormFactory formFactory;

	@Inject
	private MessagesApi messagesApi;

	@Inject
	public HomeController(WSClient ws, SearchForReposService searchForReposService) {
		this.ws = ws;
		this.searchForReposService = searchForReposService;
		sessionMapRepoData = new HashMap<String, List<SearchRepository>>();
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

	public CompletionStage<Result> getSearchResults(Http.Request request) {
		Form<SearchDTO> form = formFactory.form(SearchDTO.class).bindFromRequest(request);
		String searchKeyword = request.queryString("searchTerm").get();
		System.out.println(searchKeyword);
		System.out.println("sessions ==> " + request.session().data());
		System.out.println("MAP ==> " + this.sessionMapRepoData);
		System.out.println("chk session for keyword ==> " + request.session().get(searchKeyword));
		
		CompletionStage<Result> resultCompletionStage;
		if (request.session().get(searchKeyword).isEmpty()) {
		resultCompletionStage = searchForReposService
				.getReposWithKeyword(searchKeyword).thenApply(searchRepoList -> {
					String randomKey = getSaltString();
					this.sessionMapRepoData.put(randomKey, searchRepoList);
					return ok(views.html.searchResults.render(searchRepoList));
				});
		}
		else {
			String key = request.session().get(searchKeyword).get();
			List<SearchRepository> searchRepoList = this.sessionMapRepoData.get(key);
			System.out.println("inside session ==> " + key);
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.searchResults.render(searchRepoList)));
		}
		return resultCompletionStage;
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

}
