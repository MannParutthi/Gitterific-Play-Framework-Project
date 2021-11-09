package controllers;

import static play.mvc.Results.ok;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import play.mvc.Result;
import services.TopicDataService;
import services.UserDataService;


public class TopicDataController {
	private final TopicDataService topicDataService;
	
	@Inject
	TopicDataController(TopicDataService topicDataService) {
		this.topicDataService = topicDataService;
	}
	
	public CompletionStage<Result> getTopicData(String keyword) {
		CompletionStage<Result> resultCompletionStage = topicDataService.getRepositoryData(keyword).thenApply(data -> ok(views.html.topicData.render(data)));
		return resultCompletionStage;
//		User user = new User();
	}
	
}
