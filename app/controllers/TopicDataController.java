package controllers;

import static play.mvc.Results.ok;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import play.mvc.Result;
import services.TopicDataService;

/**
 * This controller contains an action to o get the repository topic for the given topic
 *
 */
public class TopicDataController {
	private final TopicDataService topicDataService;
	
	/**
	 * Constructor Injection for TopicDataService
	 * 
	 * @param topicDataService 
	 */
	@Inject
	TopicDataController(TopicDataService topicDataService) {
		this.topicDataService = topicDataService;
	}
	
	/**
	 * This method gets the repository results for the given topic
	 * 
	 * @param keyword Keyword used for searching the given Topic
	 * @return Returns the list of all Topics Data that are filtered with the given topic
	 */
	public CompletionStage<Result> getTopicData(String keyword) {
		CompletionStage<Result> resultCompletionStage = topicDataService.getRepositoryData(keyword).thenApply(data -> ok(views.html.topicData.render(data)));		
		return resultCompletionStage;
	}
}
