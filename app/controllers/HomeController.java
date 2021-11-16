package controllers;

import javax.inject.Inject;
import org.eclipse.egit.github.core.SearchRepository;
import play.mvc.*;
import views.SearchDTO;
import play.i18n.MessagesApi;
import play.cache.Cached;
import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.ws.*;
import services.SearchForReposService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

	private SyncCacheApi cacheApi;

	private final SearchForReposService searchForReposService;
	private final WSClient ws;
	private HashMap<String, List<SearchRepository>> cacheMapSearchData;
	private HashMap<String, ArrayList<LinkedHashMap<String, List<SearchRepository>>>> prevSearchSessionData;
	private ArrayList<LinkedHashMap<String, List<SearchRepository>>> prevSearchData;
	boolean isSessionPresent;

	@Inject
	private FormFactory formFactory;

	@Inject
	private MessagesApi messagesApi;

	/**
	 * Parameterized Constructor with WebService Client and Search Repository
	 * Service
	 * 
	 * @param ws                    WebService Client
	 * @param searchForReposService Repository Service Search
	 */
	@Inject
	public HomeController(WSClient ws, SyncCacheApi cacheApi, SearchForReposService searchForReposService) {
		this.cacheApi = cacheApi;
		this.ws = ws;
		this.searchForReposService = searchForReposService;
		cacheMapSearchData = new HashMap<String, List<SearchRepository>>();
		prevSearchSessionData = new HashMap<String,ArrayList<LinkedHashMap<String, List<SearchRepository>>>>();
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

	/**
	 * Generates the user profile for a given user
	 * 
	 * @param name Username
	 * @return Returns the User Profile for the given username
	 */
	public CompletionStage<Result> getUserProfile(String name) {
		WSRequest requestUser = ws.url("https://api.github.com/users/defunkt");
		CompletionStage<? extends WSResponse> responsePromise = requestUser.get();
		return responsePromise.thenApply(response -> Results.ok(response.getBody()));
	}

	/**
	 * This method handles the session management for the home page
	 * 
	 * @param request Http Request for session managing
	 * @return Returns the Search Results
	 */
//	@Cached(key="search")
	public CompletionStage<Result> getSearchResults(Http.Request request) {
		
		String newSessionKey = getSaltString();
		
		isSessionPresent = false;
		if(request.session().get("savedData").isPresent()) {
			isSessionPresent = true;
		}
		
		if(!isSessionPresent) {
			this.prevSearchSessionData.put(newSessionKey, new ArrayList<LinkedHashMap<String, List<SearchRepository>>>());
			prevSearchData = this.prevSearchSessionData.get(newSessionKey);
		}
		else {
			prevSearchData = this.prevSearchSessionData.get(request.session().get("savedData").get());
		}
		
		
		Form<SearchDTO> form = formFactory.form(SearchDTO.class).bindFromRequest(request);
		String searchKeyword = request.queryString("searchTerm").get();

		CompletionStage<Result> resultCompletionStage;
		if (this.cacheApi.get(searchKeyword).isEmpty()) {
			resultCompletionStage = searchForReposService.getReposWithKeyword(searchKeyword)
					.thenApply(searchRepoList -> {
						String randomKey = getCurrentTimeStamp();
						this.cacheMapSearchData.put(randomKey, searchRepoList);
						this.cacheApi.set(searchKeyword, randomKey);
						
						if(prevSearchData.size() >= 10) {
							prevSearchData.remove(0);
						}
						LinkedHashMap<String, List<SearchRepository>> currSearchData = new LinkedHashMap<String, List<SearchRepository>>();
						currSearchData.put(searchKeyword, searchRepoList);
						prevSearchData.add(currSearchData);
						
						if(isSessionPresent) {
							return ok(views.html.searchResults.render(prevSearchData)); 
						}
						else {
							return ok(views.html.searchResults.render(prevSearchData)).addingToSession(request, "savedData", newSessionKey); 
						}
						
						//.withHeader("Cache-Control", "max-age=3600");
					});
		} else {
			String key = this.cacheApi.get(searchKeyword).get().toString();
			List<SearchRepository> searchRepoList = this.cacheMapSearchData.get(key);
			System.out.println("inside cache ==> " + key);
			
			if(prevSearchData.size() >= 10) {
				prevSearchData.remove(0);
			}
			LinkedHashMap<String, List<SearchRepository>> currSearchData = new LinkedHashMap<String, List<SearchRepository>>();
			currSearchData.put(searchKeyword, searchRepoList);
			prevSearchData.add(currSearchData);
			
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.searchResults.render(prevSearchData)));
		}
		return resultCompletionStage;
	}

	/**
	 * This method is used to generate a random string which is used in session
	 * management
	 * 
	 * @return RandomString Returns the Random String which is used in session
	 *         management
	 */
	protected String getCurrentTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.toString();
	}
	
	protected void getLastTenResults() {

		LinkedHashMap<String, List<SearchRepository>> results = new LinkedHashMap<String, List<SearchRepository>>();
		
		System.out.println("===>  "); 
	
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
