package controllers;

import javax.inject.Inject;

import actors.RepoIssuesActor;
import org.eclipse.egit.github.core.SearchRepository;

import actors.RepoDataActor;
import actors.RepoDataActor.RepoDataReqDetails;
import actors.TopicDataActor;
import actors.TopicDataActor.TopicDataReqDetails;
import actors.SearchForRepoActor;
import actors.SearchSupervisorActor;
import actors.SearchForRepoActor.RequestMsg;
import actors.UserDataActor;
import actors.UserDataActor.UserDataReqDetails;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import model.RepoDataModel;
import model.SearchRepoModel;
import model.TopicDataModel;
import model.UserDetails;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import static akka.pattern.Patterns.ask;

import services.*;
import views.SearchDTO;
import play.i18n.MessagesApi;
import play.cache.Cached;
import play.cache.SyncCacheApi;
import play.data.Form;
import play.data.FormFactory;
import play.libs.streams.ActorFlow;
import play.libs.ws.*;

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
import java.util.concurrent.TimeUnit;

import static play.mvc.Results.ok;
import controllers.DummyResponseForTesting;
import java.time.Duration;

/**
 * HomeController is the Controller that handles the HTTP requests for searching for information on given topic, for fetching the repository data,
 * for fetching the repository issues, for fetching the Topics data, and for fetching the User Data.
 * 
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 * 
 */

public class HomeController {
	
	@Inject private ActorSystem actorSystem;
    @Inject private Materializer materializer;
	ActorRef repoDataActor, searchForRepoActor, topicDataActor,userDataActor;

	private SyncCacheApi cacheApi;

	private SearchForReposService searchForReposService;
	private WSClient ws;
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
	
	private int count = 0;

	/**
	 * Parameterized Constructor with WebService Client and Search Repository
	 * Service
	 * 
	 * @param ws                    WebService Client
	 * @param searchForReposService Repository Service Search
	 */
	@Inject
	public HomeController(WSClient ws, SyncCacheApi cacheApi, SearchForReposService searchForReposService,
			RepoDataService repoDataService, RepoIssues repoIssues, TopicDataService topicDataService,
			UserDataService userDataService, ActorSystem system) {
		repoDataActor = system.actorOf(RepoDataActor.getProps( repoDataService));
		searchForRepoActor = system.actorOf(SearchForRepoActor.getProps(searchForReposService), "searchForRepoActor");
		
		topicDataActor = system.actorOf(TopicDataActor.getProps( topicDataService));
		userDataActor = system.actorOf(UserDataActor.getProps( userDataService));
		this.cacheApi = cacheApi;
		this.ws = ws;
		this.searchForReposService = searchForReposService;
		cacheMapSearchData = new HashMap<>();
		prevSearchSessionData = new HashMap<String, ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>>();
		this.repoDataService = repoDataService;
		sessionMapRepoData = new HashMap<String, RepoDataModel>();
		this.repoIssues = repoIssues;
		this.topicDataService = topicDataService;
		topicDataModelMap = new HashMap<String, List<TopicDataModel>>();
		this.userDataService = userDataService;
		sessionMapUserData = new HashMap<String, UserDetails>();
	}
	
	public WebSocket ws() {
        return WebSocket.Json.accept(request -> ActorFlow.actorRef(SearchSupervisorActor::props, actorSystem, materializer));
    }
	
	/**
	 * This method sets the Repo Issues
	 * 
	 * @param repoIssues
	 * @return void
	 */
	public void setRepoIssues(RepoIssues repoIssues) {
		this.repoIssues = repoIssues;
	}

	/**
	 * This method sets the Searched Data for Cache
	 * 
	 * @param cacheMapSearchData
	 * @return void
	 */
	public void setCacheMapSearchData(HashMap<String, List<SearchRepoModel>> cacheMapSearchData) {
		this.cacheMapSearchData = cacheMapSearchData;
	}

	/**
	 * This method sets the previous searched data to show the top 10 search results in search results page
	 * 
	 * @param prevSearchSessionData
	 * @return void
	 */
	public void setPrevSearchSessionData(HashMap<String, ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>> prevSearchSessionData) {
		this.prevSearchSessionData = prevSearchSessionData;
	}

	/**
	 * THis method sets the previous searched data
	 * 
	 * @param prevSearchData
	 * @return void
	 */
	public void setPrevSearchData(ArrayList<LinkedHashMap<String, List<SearchRepoModel>>> prevSearchData) {
		this.prevSearchData = prevSearchData;
	}

	/**
	 * This sets the CacheApi reference
	 * 
	 * @param cacheApi
	 * @return void
	 */
	public void setCacheApi(SyncCacheApi cacheApi) {
		this.cacheApi = cacheApi;
	}

	/**
	 * This method sets the Web Service Client
	 * 
	 * @param ws
	 * @return void
	 */
	public void setWs(WSClient ws) {
		this.ws = ws;
	}

	/**
	 * This method sets the form factory
	 * 
	 * @param formFactory
	 * @return void
	 */
	public void setFormFactory(FormFactory formFactory) {
		this.formFactory = formFactory;
	}

	/**
	 * This method sets the Repos for searching
	 * 
	 * @param searchForReposService
	 * @return void
	 */
	public void setSearchForReposService(SearchForReposService searchForReposService) {
		this.searchForReposService = searchForReposService;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 * 
	 * @param Http.Request Takes the Http request as a parameter
	 * @return Result Returns that will be used for rendering in view page
	 * 
	 */
	public Result index(Http.Request request) {
		return Results.ok(views.html.index.render(request, formFactory.form(SearchDTO.class), messagesApi.preferred(request)));
	}
	

	/**
	 * This method is used for caching the data in the search results page
	 * 
	 * @param request Http Request for session managing
	 * @return CompletionStage<Result> Returns the Search Results
	 */
//	@Cached(key="search")
	public CompletionStage<Result> getSearchResults(Http.Request request) {

		String newSessionKey = getSaltString();

		isSessionPresent = false;
		if (request.session().get("savedData").isPresent()
				&& this.prevSearchSessionData.get(request.session().get("savedData").get()) != null) {
			isSessionPresent = true;
		}

		if (!isSessionPresent) {
			this.prevSearchSessionData.put(newSessionKey,
					new ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>());
			prevSearchData = this.prevSearchSessionData.get(newSessionKey);
		} else {
			prevSearchData = this.prevSearchSessionData.get(request.session().get("savedData").get());
		}

//		Form<SearchDTO> form = formFactory.form(SearchDTO.class).bindFromRequest(request);
		String searchKeyword = request.queryString("searchTerm").get();
		FutureConverters.toJava(ask(searchForRepoActor, new RequestMsg(searchKeyword), 10000));
		CompletionStage<Result> resultCompletionStage;
		if (!this.cacheApi.get(searchKeyword).isPresent()) {
			resultCompletionStage = searchForReposService.getReposWithKeyword(searchKeyword)
					.thenApply(searchRepoList -> {
						String randomKey = getCurrentTimeStamp();
						this.cacheMapSearchData.put(randomKey, searchRepoList);
						this.cacheApi.set(searchKeyword, randomKey);

						if (prevSearchData.size() >= 10) {
							prevSearchData.remove(0);
						}
						LinkedHashMap<String, List<SearchRepoModel>> currSearchData = new LinkedHashMap<String, List<SearchRepoModel>>();
						currSearchData.put(searchKeyword, searchRepoList);
						prevSearchData.add(currSearchData);
						++count;
						Collections.reverse(prevSearchData);
						if (isSessionPresent) {
							++count;
							return ok(views.html.searchResults.render(request, prevSearchData));
						} else {
							++count;
							return ok(views.html.searchResults.render(request, prevSearchData)).addingToSession(request,
									"savedData", newSessionKey);
						}

						// .withHeader("Cache-Control", "max-age=3600");
					});
		} else {
			String key = this.cacheApi.get(searchKeyword).get().toString();
			List<SearchRepoModel> searchRepoList = this.cacheMapSearchData.get(key);
			System.out.println("inside cache ==> " + key);

			if (prevSearchData.size() >= 10) {
				prevSearchData.remove(0);
			}
			LinkedHashMap<String, List<SearchRepoModel>> currSearchData = new LinkedHashMap<String, List<SearchRepoModel>>();
			currSearchData.put(searchKeyword, searchRepoList);
			prevSearchData.add(currSearchData);
			++count;
			Collections.reverse(prevSearchData);
			resultCompletionStage = CompletableFuture
					.supplyAsync(() -> ok(views.html.searchResults.render(request, prevSearchData)));
		}
		return resultCompletionStage;
	}

	/**
	 * This method is used to get the time stamp
	 * 
	 * @return String Returns the Random String which is used in session
	 *         management
	 */
	public String getCurrentTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.toString();
	}

	/**
	 * This method is used to get the Randomkey that is used in session management
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
	 * This method is used to get the repository data for a given user and repo name
	 * 
	 * @param request The request parameter the handle the session 
	 * @param userName Username to get the Repo Details
	 * @param repoName - Repository Name
	 * @return Returns the Repository Data for the given Username
	 */
	public CompletionStage<Result> getRepoData(Http.Request request, String userName, String repoName) {
		sessionMapRepoData.put("randomKeyForTesting1996", DummyResponseForTesting.getRepoData()); // for testing
		sessionMapRepoData.put("randomTestingKey1996", null); //for testing
		System.out.println("key => " + userName + repoName + " == " + request.session().get(userName + repoName) + " == " + sessionMapRepoData);
		CompletionStage<Result> resultCompletionStage;
		if (!request.session().get(userName + repoName).isPresent()
				|| this.sessionMapRepoData.get(request.session().get(userName + repoName).get()) == null) {
			return FutureConverters.toJava(ask(repoDataActor, new RepoDataReqDetails(userName, repoName), 10000)).thenApply(response -> {
				RepoDataModel repoDetails = (RepoDataModel)response;
				String randomKey = getSaltString();
				this.sessionMapRepoData.put(randomKey, repoDetails);
				System.out.println("repoDataaaaa ==> " + repoDetails);
				
				 return ok(views.html.repoData.render(repoDetails)).addingToSession(request, userName + repoName,
						randomKey);
			});
		} else {
			String key = request.session().get(userName + repoName).get();
			RepoDataModel repoData = this.sessionMapRepoData.get(key);
			System.out.println("inside session ==> " + key);
			resultCompletionStage = CompletableFuture.supplyAsync(() -> ok(views.html.repoData.render(repoData)));
		}
		return resultCompletionStage;
	}

	/**
	 * This Method is used to get the Repository Issues for given a username and a repository
	 * 
	 * @param userName Username to get the Repo Issues
	 * @param repo	Repository Name to get the Repo Issues
	 * @return CompletionStage<Result> Returns the Repo Issues for the given Username and Repository
	 */
	public CompletionStage<Result> getRepoIssues(String userName,String repo) {
		System.out.println(userName + "," + repo);
		ActorSystem actorSystem = ActorSystem.create("ActorSystem");
		ActorRef repoIssuesActor = actorSystem.actorOf(RepoIssuesActor.props(), "repoIssuesActor");
		return FutureConverters.toJava(
						ask(repoIssuesActor, new RepoIssuesActor.GetReport(userName, repo), 5000))
				.thenApplyAsync(report -> (CompletableFuture<String>) report)
				.toCompletableFuture()
				.thenApplyAsync(CompletableFuture::join)
				.thenApply(output -> ok(views.html.repoIssueShow.render(output)));
		// DO NOT DELETE ANY LINES BELOW (previous part 1 code)
//		return repoIssues.getIssueReportFromRepo(userName,repo)
//				.thenApplyAsync(output -> ok(views.html.repoIssueShow.render(output)));
	}

	/**
	 * This method is used to get the repositories containing the given topic
	 * 
	 * @param request The request parameter the handle the session 
	 * @param userName Username to get the Repo Details
	 * @return CompletionStage<Result> Returns the Repository Data for the given Username
	 */
	public CompletionStage<Result> getTopicData(Http.Request request, String topicName) {
		topicDataModelMap.put("TestingBranchYashwanth", DummyResponseForTesting.getTopicData());
		topicDataModelMap.put("TestingTopicDataModel", null);// for testing
		if(count == 0) {
			prevSearchData = new ArrayList<LinkedHashMap<String, List<SearchRepoModel>>>();
			List<SearchRepoModel> sp = new ArrayList<SearchRepoModel>();
			LinkedHashMap<String, List<SearchRepoModel>> l1 = new LinkedHashMap<String, List<SearchRepoModel>>();
			
			SearchRepoModel spm = new SearchRepoModel();
			spm.setRepoName("CS-Notes");
			spm.setUserName("CyC2018");
			String[] str = new String[] {"algorithm" , "computer-science" , "cpp" , "interview" , "java" , "leetcode" , "python" , "system-design"};
			spm.setTopics(str);
			sp.add(spm);
			l1.put("Java", sp);
			prevSearchData.add(l1);
			
			LinkedHashMap<String, List<SearchRepoModel>> l2 = new LinkedHashMap<String, List<SearchRepoModel>>();
			List<SearchRepoModel> sp1 = new ArrayList<SearchRepoModel>();
			SearchRepoModel spm1 = new SearchRepoModel();
			spm.setRepoName("CS-Notes-1");
			spm.setUserName("CyC2018-1");
			String[] str1 = new String[] {"algorithms" , "Computer-Sciences" , "c++" , "interviews" , "Java" , "Leetcode" , "Python" , "System-Design"};
			spm1.setTopics(str1);
			sp1.add(spm);
			l2.put("Java", sp1);
			prevSearchData.add(l2);
			count = 1;
		}
		CompletionStage<Result> result = null;
		if (!request.session().get(topicName).isPresent() || this.sessionMapUserData.get(request.session().get(topicName).get()) == null) {
			return FutureConverters.toJava(ask(topicDataActor, new TopicDataReqDetails(topicName), 10000)).thenApply(response -> {
				List<TopicDataModel> topicsList = (List<TopicDataModel>)response;
				String randomKey = getSaltString();
				topicDataModelMap.put(randomKey, topicsList);
			return ok(views.html.topicData.render(topicsList, prevSearchData, topicName)).addingToSession(request, topicName, randomKey);
			});
		} else {
			String key = request.session().get(topicName).get();
			List<TopicDataModel> topicData = this.topicDataModelMap.get(key);
			System.out.println("inside session ==> " + key);
			result = CompletableFuture.supplyAsync(() -> ok(views.html.topicData.render(topicData, prevSearchData, topicName)));
		}
		return result;
	}

	/**
	 * This method is used to get the User Data for a given Github Username
	 * @param UserName This username is used to get the data of the User
	 * @return CompletionStage<Result> Returns the data of the given User
	 */
	public CompletionStage<Result> getUserData(Http.Request request, String userName) {
		sessionMapUserData.put("randomKeyTest1995", DummyResponseForTesting.getUserData());
		sessionMapUserData.put("randomKeyTestingNull", null);
		System.out.println("hi--------------------------------------");
		System.out.println("key => " + userName + " == " + request.session().get(userName) + " == " + sessionMapUserData);
		System.out.println(this.sessionMapUserData);
		System.out.println(request.session().get(userName));
		System.out.println(!request.session().get(userName).isPresent());
		// System.out.println(this.sessionMapUserData.get(request.session().get(userName).get()));

		CompletionStage<Result> resultCompletionStage;
		if (!request.session().get(userName).isPresent()
				|| this.sessionMapUserData.get(request.session().get(userName).get()) == null) {
			return FutureConverters.toJava(ask(userDataActor, new UserDataReqDetails(userName), 10000)).thenApply(response -> {
				UserDetails userDetails = (UserDetails)response;
				String randomKey = getSaltString();
				this.sessionMapUserData.put(randomKey, userDetails);
				System.out.println("user------  " + userDetails);
				
				 return ok(views.html.userData.render(userDetails)).addingToSession(request, userName,
						randomKey);
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