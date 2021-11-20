package controllers;

import javax.inject.Inject;
import org.eclipse.egit.github.core.SearchRepository;

import model.RepoDataModel;
import model.SearchRepoModel;
import model.TopicDataModel;
import model.UserDetails;
import play.mvc.*;
import views.SearchDTO;
import play.i18n.MessagesApi;
import play.cache.Cached;
import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.ws.*;
import services.RepoDataService;
import services.RepoIssues;
import services.SearchForReposService;
import services.TopicDataService;
import services.UserDataService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
 * 
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 * 
 */
public class HomeController {

	private SyncCacheApi cacheApi;

	private final SearchForReposService searchForReposService;
	private final WSClient ws;
	private HashMap<String, List<SearchRepoModel>> cacheMapSearchData;
	private HashMap<String, ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>> prevSearchSessionData;
	private ArrayList<LinkedHashMap<String, List<SearchRepoModel>>> prevSearchData;
	boolean isSessionPresent;
	private final RepoDataService repoDataService;
	private HashMap<String, RepoDataModel> sessionMapRepoData;
	private RepoIssues repoIssues;
	private final TopicDataService topicDataService;
	private HashMap<String, List<TopicDataModel>> topicDataModelMap;
	private final UserDataService userDataService;
	private HashMap<String, UserDetails> sessionMapUserData;

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
	public HomeController(WSClient ws, SyncCacheApi cacheApi, SearchForReposService searchForReposService,RepoDataService repoDataService,RepoIssues repoIssues,TopicDataService topicDataService,UserDataService userDataService) {
		this.cacheApi = cacheApi;
		this.ws = ws;
		this.searchForReposService = searchForReposService;
		cacheMapSearchData = new HashMap<>();
		prevSearchSessionData = new HashMap<String,ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>>();
		this.repoDataService = repoDataService;
		sessionMapRepoData = new HashMap<String, RepoDataModel>();
		this.repoIssues = repoIssues;
		this.topicDataService = topicDataService;
		topicDataModelMap = new HashMap<String, List<TopicDataModel>>();
		this.userDataService = userDataService;
		sessionMapUserData = new HashMap<String, UserDetails>();
	}

	public void setRepoIssues(RepoIssues repoIssues) {
		this.repoIssues = repoIssues;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 * 
	 * @param Http.Request  Takes the Http request as a parameter
	 * @return Result Returns that will be used for rendering in view page
	 * 
	 */
	public Result index(Http.Request request) {
		return Results.ok(views.html.index.render(formFactory.form(SearchDTO.class), messagesApi.preferred(request)));
	}

	/**
	 * Generates the user profile for a given user
	 * 
	 * @param name Username
	 * @return CompletionStage<Result> Returns the User Profile for the given username
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
	 * @return CompletionStage<Result> Returns the Search Results
	 */
//	@Cached(key="search")
	public CompletionStage<Result> getSearchResults(Http.Request request) {
		
		String newSessionKey = getSaltString();
		
		isSessionPresent = false;
		if(request.session().get("savedData").isPresent() && this.prevSearchSessionData.get(request.session().get("savedData").get()) != null) {
			isSessionPresent = true;
		}
		
		if(!isSessionPresent) {
			this.prevSearchSessionData.put(newSessionKey, new ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>());
			prevSearchData = this.prevSearchSessionData.get(newSessionKey);
		}
		else {
			prevSearchData = this.prevSearchSessionData.get(request.session().get("savedData").get());
		}
		
		
		Form<SearchDTO> form = formFactory.form(SearchDTO.class).bindFromRequest(request);
		String searchKeyword = request.queryString("searchTerm").get();

		CompletionStage<Result> resultCompletionStage;
		if (!this.cacheApi.get(searchKeyword).isPresent()) {
			resultCompletionStage = searchForReposService.getReposWithKeyword(searchKeyword)
					.thenApply(searchRepoList -> {
						String randomKey = getCurrentTimeStamp();
						this.cacheMapSearchData.put(randomKey, searchRepoList);
						this.cacheApi.set(searchKeyword, randomKey);

						if(prevSearchData.size() >= 10) {
							prevSearchData.remove(0);
						}
						LinkedHashMap<String, List<SearchRepoModel>> currSearchData = new LinkedHashMap<String, List<SearchRepoModel>>();
						currSearchData.put(searchKeyword, searchRepoList);
						prevSearchData.add(currSearchData);
						Collections.reverse(prevSearchData);
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
			List<SearchRepoModel> searchRepoList = this.cacheMapSearchData.get(key);
			System.out.println("inside cache ==> " + key);
			
			if(prevSearchData.size() >= 10) {
				prevSearchData.remove(0);
			}
			LinkedHashMap<String, List<SearchRepoModel>> currSearchData = new LinkedHashMap<String, List<SearchRepoModel>>();
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
	 * @return String Returns the Random String which is used in session
	 *         management
	 */
	public String getCurrentTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.toString();
	}
	
	/**
	 * This method return the RandomString used in session management
	 * 
	 * @return String Returns a string that is used in session management
	 */
	public String getSaltString() {
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
	
	/**
	 * This method provides the repository data for a given user
	 * 
	 * @param request The request parameter the handle the session 
	 * @param userName Username to get the Repo Details
	 * @param repoName - Repository Name
	 * @return Returns the Repository Data for the given Username
	 */
	public CompletionStage<Result> getRepoData(Http.Request request, String userName, String repoName) {
		System.out.println("key => " + userName+repoName);
		sessionMapRepoData.put("randomKeyForTesting", null); // for testing
		CompletionStage<Result> resultCompletionStage;
		if (!request.session().get(userName+repoName).isPresent() || this.sessionMapRepoData.get(request.session().get(userName+repoName).get()) == null) {
			resultCompletionStage = repoDataService.getRepoData(userName, repoName).thenApply(repoDetails -> {
				String randomKey = getSaltString();
				this.sessionMapRepoData.put(randomKey, repoDetails);
				System.out.println("repoData ==> " + repoDetails.getContributors());
				return ok(views.html.repoData.render(repoDetails)).addingToSession(request, userName+repoName, randomKey);
			});
		} else {
			String key = request.session().get(userName+repoName).get();
			RepoDataModel repoData = this.sessionMapRepoData.get(key);
			System.out.println("inside session ==> " + key);
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.repoData.render(repoData)));
		}
		return resultCompletionStage;
	}
	
	/**
	 * Method to get the Repository Issues for given username and repository
	 * 
	 * @param userName Username to get the Repo Issues
	 * @param repo	Repository Name to get the Repo Issues
	 * @return CompletionStage<Result> Returns the Repo Issues for the given Username and Repository
	 */
	public CompletionStage<Result> getRepoIssues(String userName,String repo) {
		System.out.println(userName + "," + repo);
		return repoIssues.getIssueReportFromRepo(userName,repo)
				.thenApplyAsync(output -> ok(views.html.repoIssueShow.render(output)));
	}
	
	/**
	 * This method provides the repository data for a given user
	 * @param request The request parameter the handle the session 
	 * @param userName Username to get the Repo Details
	 * @return CompletionStage<Result> Returns the Repository Data for the given Username
	 */
	public CompletionStage<Result> getTopicData(Http.Request request, String topicName) {
		topicDataModelMap.put("TestingTopicData", Arrays.asList()); // for testing
		CompletionStage<Result> result = null;
		if (!request.session().get(topicName).isPresent() || this.topicDataModelMap.get(request.session().get(topicName).get()) == null) {
			result = topicDataService.getRepositoryData(topicName).thenApply(topicsList -> {
				String randomKey = getSaltString();
				for(TopicDataModel topic : topicsList) {
					System.out.println(topic.toString());
				}
				topicDataModelMap.put(randomKey, topicsList);
				return ok(views.html.topicData.render(topicsList)).addingToSession(request, topicName, randomKey);
			});
		} else {
			String key = request.session().get(topicName).get();
			List<TopicDataModel> topicData = this.topicDataModelMap.get(key);
			System.out.println("inside session ==> " + key);
			result = CompletableFuture.supplyAsync(() -> ok(views.html.topicData.render(topicData)));
		}
		return result;
	}
	
	/**
	 * This method get the User Data for a given username
	 * @param userName This username is used to get the data of the User
	 * @return CompletionStage<Result> Returns the data of the given User
	 */
	public CompletionStage<Result> getUserData(Http.Request request, String userName) {
		sessionMapUserData.put("randomKeyTesting", new UserDetails());
		System.out.println("hi--------------------------------------");
		System.out.println(this.sessionMapUserData);
		System.out.println(request.session().get(userName));
		System.out.println(!request.session().get(userName).isPresent());
	//	System.out.println(this.sessionMapUserData.get(request.session().get(userName).get()));
		
		CompletionStage<Result> resultCompletionStage;
		if (!request.session().get(userName).isPresent() || this.sessionMapUserData.get(request.session().get(userName).get()) == null) {
			resultCompletionStage = userDataService.getUserData(userName).thenApply(userList -> {
				String randomKey = getSaltString();
				System.out.println("my random key ----->"+randomKey);
				this.sessionMapUserData.put(randomKey, userList);
				return ok(views.html.userData.render(userList)).addingToSession(request, userName, randomKey);
			});
		} else {
			System.out.println("Here-----------------------");
			String key = request.session().get(userName).get();
			UserDetails userData = this.sessionMapUserData.get(key);
			System.out.println("inside session ==> " + key);
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.userData.render(userData)));
		}
		return resultCompletionStage;
	}
}
