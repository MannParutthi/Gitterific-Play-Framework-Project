package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;

import model.RepoCommitModel;
import model.RepoContributorModel;
import model.RepoDataModel;
import model.RepoIssueModel;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;


/**
 * This RepoDataService class is used to interact with API and get the Repository Data
 *
 * @author Manan Dineshbhai Paruthi
 *
 */
public class RepoDataService {

	private WSClient ws;

	/**
	 * Default Constructor
	 */
	@Inject
	public RepoDataService(WSClient ws) {
		this.ws = ws;
	}

	/**
	 * This method is used to return the list of Repository Data for the given username from API
	 * 
	 * @param userName Username to get the Repo Data
	 * @param repoName Repository name 
	 * @return Returns the Repository Data for the given User name and Repository name 
	 */
	public CompletionStage<RepoDataModel> getRepoData(String userName, String repoName) {
		return CompletableFuture.supplyAsync(() -> {
			RepoDataModel repoData = new RepoDataModel();
			try {
				JsonNode repoJson = getJsonData("https://api.github.com/repos/" + userName + "/" + repoName, -1);
				
				repoData.setName(repoJson.get("name").asText());
				repoData.setId(repoJson.get("id").asInt());
				repoData.setDescription(repoJson.get("description").asText());
				repoData.setLanguage(repoJson.get("language").asText());
				repoData.setUrl(repoJson.get("html_url").asText());
				repoData.setCloneUrl(repoJson.get("clone_url").asText());
				repoData.setCreatedOn(repoJson.get("created_at").asText());
				repoData.setLastUpdatedOn(repoJson.get("updated_at").asText());
				repoData.setOwner(repoJson.get("owner").get("login").asText());

				List<RepoContributorModel> repoContributorList = new ArrayList<RepoContributorModel>();
				if(repoJson.get("size").asInt() > 0) {
					JsonNode repoContributorsJson = getJsonData("https://api.github.com/repos/" + userName + "/" + repoName + "/contributors", -1);
					if(repoContributorsJson.size()>0) {
						for (JsonNode contributorJson : repoContributorsJson) {
							RepoContributorModel repoContributorDetails = new RepoContributorModel();
							repoContributorDetails.setLoginName(contributorJson.get("login").asText());
							repoContributorDetails.setUrl(contributorJson.get("html_url").asText());
							repoContributorDetails.setNoOfContributions(contributorJson.get("contributions").asInt());
							repoContributorList.add(repoContributorDetails);
						}
					}
				}
				repoData.setContributors(repoContributorList);
				

				List<RepoIssueModel> repoIssueList = new ArrayList<RepoIssueModel>();
				JsonNode repoIssuesJson = getJsonData("https://api.github.com/repos/" + userName + "/" + repoName + "/issues", 20);
				if(repoIssuesJson.size()>0) {
					for (JsonNode issueJson : repoIssuesJson) {
						RepoIssueModel repoIssueDetails = new RepoIssueModel();
						repoIssueDetails.setTitle(issueJson.get("title").asText());
						repoIssueDetails.setUrl(issueJson.get("html_url").asText());
						repoIssueDetails.setState(issueJson.get("state").asText());
						repoIssueList.add(repoIssueDetails);
					}
				}
				repoData.setIssues(repoIssueList);

				List<RepoCommitModel> repoCommitList = new ArrayList<RepoCommitModel>();
				if (repoJson.get("size").asInt() > 0) {
					JsonNode repoCommitsJson = getJsonData("https://api.github.com/repos/" + userName + "/" + repoName + "/commits", -1);
					if(repoCommitsJson.size()>0) {
						for (JsonNode commitJson : repoCommitsJson) {
							RepoCommitModel repoCommitDetails = new RepoCommitModel();
							repoCommitDetails.setLoginName(commitJson.get("commit").get("author").get("name").asText());
							repoCommitDetails.setEmail(commitJson.get("commit").get("author").get("email").asText());
							repoCommitDetails.setMessage(commitJson.get("commit").get("message").asText());
							repoCommitDetails.setDate(commitJson.get("commit").get("author").get("date").asText());
							repoCommitDetails.setUrl(commitJson.get("commit").get("url").asText());
							repoCommitList.add(repoCommitDetails);
						}
					}
				}
				
				repoData.setCommits(repoCommitList);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("chk here ===> " + repoData);
			return repoData;
		});
	}
	
	/**
	 * This method returns the JsonNode for the given URI
	 * 
	 * @param url
	 * @param limit
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * @return JsonNode
	 */
	public JsonNode getJsonData(String url, int limit) throws InterruptedException, ExecutionException {
		if(limit == -1) {
			return ws.url(url).get().thenApply((WSResponse r) -> { return r.asJson(); }).toCompletableFuture().get();
		}
		else {
			//use limit here - stream().limit()
			return ws.url(url).get().thenApply((WSResponse r) -> { return r.asJson(); }).toCompletableFuture().get();
		}
		
	}

}
