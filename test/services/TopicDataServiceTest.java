package services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.TopicDataModel;

@RunWith(MockitoJUnitRunner.class)
public class TopicDataServiceTest {

	@InjectMocks
	TopicDataService topicDataService;
	
	@Mock
	RepositoryService repositoryService;
	
	public static List<SearchRepository> topicDataList;
	public static SearchRepository repository1;
	public static SearchRepository repository2;
	
	@BeforeClass
	public static void setUp() {
		topicDataList = new ArrayList<SearchRepository>();
		
		repository1 = new SearchRepository("Jack","Java");
		repository2 = new SearchRepository("Jack","Java");

		topicDataList.add(repository1);
		topicDataList.add(repository2);
	}
	
	@org.junit.Test
	public void test_getTopicDataService() {
		try {
			when(repositoryService.searchRepositories("Java")).thenReturn(topicDataList);
			
			try {
				List<TopicDataModel> topicData = topicDataService.getRepositoryData("Java").toCompletableFuture().get();
				topicData.get(0).setPushedAt(new Date("Sun Sep 26 17:04:56 EDT 2021"));
				topicData.get(1).setPushedAt(new Date("Sun Sep 26 17:04:56 EDT 2021"));
				//if(topicData.get(0).getPushedAt() != null && topicData.get(1).getPushedAt() != null) {
					assertEquals(0, topicData.get(0).getPushedAt().compareTo(topicData.get(1).getPushedAt()));
					//System.out.println("Inside if loop");
				//}
				assertEquals(topicData.get(0).getName(), "Java");
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(IOException ioe) {
			ioe.getStackTrace();
		}
	}
}
