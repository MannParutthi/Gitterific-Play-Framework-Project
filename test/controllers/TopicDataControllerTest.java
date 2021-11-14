package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import services.TopicDataService;

@RunWith(JUnitPlatform.class)
public class TopicDataControllerTest{
	
	@Mock
	RepositoryService repositoryService;
	
	@InjectMocks
	TopicDataService topicDataService;
	
	public List<SearchRepository> repos;
	
	@Test
	public void test_getRepositoryData() throws IOException {
		
		List<SearchRepository> repos = new ArrayList<SearchRepository>();
		
		repos.add(new SearchRepository("AndroidCot","Android"));
		repos.add(new SearchRepository("Argisht44","android"));
		repos.add(new SearchRepository("home-assistant","android"));
		repos.add(new SearchRepository("getActivity","AndroidProject"));
		repos.add(new SearchRepository("JessYanCoding","AndroidAutoSize"));
		repos.add(new SearchRepository("kiwibrowser","android"));
		repos.add(new SearchRepository("aserbao","AndroidCamera"));
		repos.add(new SearchRepository("gotify","android"));
		repos.add(new SearchRepository("Tencent","QMUI_Android"));
		repos.add(new SearchRepository("open-android","Android"));

		// Mocking
		when(repositoryService.searchRepositories("Android")).thenReturn(repos);
		
		List<SearchRepository> count = (List<SearchRepository>) topicDataService.getRepositoryData("Android");
	
		assertEquals(repos.size(), count.size());
		
		//assertEquals(repos.size(), topicDataService.getRepositoryData("Android"));
	}
	
}
