package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.JsonNode;

import model.SearchRepoModel;
import model.TopicDataModel;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;

/**
 * This TopicDataService Class is used to interact with API and get the repositories of matching topic 
 * 
 * @author Yashwanth Gundlapally
 *
 */
public class TopicDataService implements WSBodyReadables, WSBodyWritables{
	
	private WSClient ws;
		
	@Inject
	public TopicDataService(WSClient ws) {
		this.ws = ws;
	}
	
	
	/**
	 * Gets the Repository Data for the given name
	 * @param keyword used for getting the Repository data
	 * @return Returns the list of repositories details for the given topic
	 */
	public CompletableFuture<List<TopicDataModel>> getRepositoryData(String keyword) {
		return CompletableFuture.supplyAsync(() -> {
			List<TopicDataModel> topicDataModelList = new ArrayList<TopicDataModel>();
			
				String url = "https://api.github.com/search/topics?q="+keyword;
				// implements WSBodyReadables or use WSBodyReadables.instance.json()
				WSRequest request = ws.url(url).addHeader("Authorization", "token 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");
				CompletionStage<JsonNode> jsonPromise = request.get().thenApply(r -> r.getBody(json()));
					try {
						for(JsonNode topicsJson : jsonPromise.toCompletableFuture().get().get("items")) {
							TopicDataModel topicDataModel = new TopicDataModel();
							topicDataModel.setName(topicsJson.get("name").asText());
							topicDataModel.setCreated_at(topicsJson.get("created_at").asText());
							topicDataModel.setCreated_by(topicsJson.get("created_by").asText());
							topicDataModel.setReleased(topicsJson.get("released").asText());
							topicDataModel.setUpdated_at(topicsJson.get("updated_at").asText());
							topicDataModel.setCurated(topicsJson.get("curated").asText());
							topicDataModel.setDescription(topicsJson.get("description").asText());
							topicDataModel.setDisplay_name(topicsJson.get("display_name").asText());
							topicDataModel.setFeatured(topicsJson.get("featured").asText());
							topicDataModel.setScore(topicsJson.get("score").asText());
							topicDataModel.setShort_description(topicsJson.get("short_description").asText());	
							topicDataModelList.add(topicDataModel);
						}
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			// Sorting Repositories using the Creation Date
				Collections.sort(topicDataModelList, new Comparator<TopicDataModel>() {
				  public int compare(TopicDataModel o1, TopicDataModel o2) {
				      if (new DateTime(o1.getUpdated_at()) == null || new DateTime(o2.getUpdated_at()) == null)
				        return 0;
				      return new DateTime(o2.getUpdated_at()).compareTo(new DateTime(o1.getUpdated_at()));
				  }
				});
			
			// Filtering the first 10 Repositories
			return topicDataModelList.stream().limit(10).collect(Collectors.toList());
		});
	}	
}
