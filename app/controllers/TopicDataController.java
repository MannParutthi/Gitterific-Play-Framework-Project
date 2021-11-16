package controllers;

import static play.mvc.Results.ok;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import model.TopicDataModel;
import play.mvc.Http;
import play.mvc.Result;
import services.TopicDataService;

/**
 * This controller contains an action to o get the repository topic for the given topic
 *
 */
public class TopicDataController {
	private final TopicDataService topicDataService;
	private HashMap<String, List<TopicDataModel>> topicDataModelMap;
	
	/**
	 * Constructor Injection for TopicDataService
	 * 
	 * @param topicDataService 
	 */
	@Inject
	TopicDataController(TopicDataService topicDataService) {
		this.topicDataService = topicDataService;
		topicDataModelMap = new HashMap<String, List<TopicDataModel>>();
	}
	/**
	 * This method is used to generate the Random String used for session management
	 * @return Returns the Random String
	 */
	protected String getRandomKey() {
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
	 * @param request The request parameter the handle the session 
	 * @param userName Username to get the Repo Details
	 * @return Returns the Repository Data for the given Username
	 */
	public CompletionStage<Result> getTopicData(Http.Request request, String topicName) {
		topicDataModelMap.put("Testing branch", Arrays.asList()); // for testing
		CompletionStage<Result> result = null;
		if (request.session().get(topicName).isEmpty() || this.topicDataModelMap.get(request.session().get(topicName).get()) == null) {
			result = topicDataService.getRepositoryData(topicName).thenApply(topicsList -> {
				String randomKey = getRandomKey();
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
	 * This method gets the repository results for the given topic
	 *  
	 * @param keyword Keyword used for searching the given Topic
	 * @return Returns the list of all Topics Data that are filtered with the given topic
	 */
//	public CompletionStage<Result> getTopicData(HttpString keyword) {
//		CompletionStage<Result> resultCompletionStage = topicDataService.getRepositoryData(keyword).thenApply(data -> ok(views.html.topicData.render(data)));		
//		return resultCompletionStage;
//	}
}
