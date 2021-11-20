package services;

import com.fasterxml.jackson.databind.JsonNode;
import model.SearchRepoModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import play.libs.ws.WSClient;
import play.routing.RoutingDsl;
import play.server.Server;
import utils.JSONLoader;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static play.mvc.Results.ok;

@RunWith(MockitoJUnitRunner.class)
public class SearchForReposServiceTest {

    private Server server;
    private WSClient ws;
    private SearchForReposService searchForReposService;

    @Before
    public void setup() {
        server =
                Server.forRouter(
                        (components) ->
                                RoutingDsl.fromComponents(components)
                                        .GET("/repositories")
                                        .routingTo(request -> ok().sendResource("github/repositories.json"))
                                        .build());
        ws = play.test.WSTestClient.newClient(server.httpPort());
        searchForReposService = new SearchForReposService(ws);
    }

    @Test
    public void testEmptyInfoExtractionFromService() throws ExecutionException, InterruptedException {
        SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
        service.setWs(ws);
        when(service.getReposWithKeyword(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> service.getSearchRepoModels(
                Objects.requireNonNull(JSONLoader.getJSONMessage(new File("test/simulated/repotopics/empty_results.json"))))));
        assertTrue(service.getReposWithKeyword("asda").get().isEmpty());
    }

    @Test
    public void testInfoExtractionFromService() throws ExecutionException, InterruptedException {
        SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
        service.setWs(ws);
        when(service.getReposWithKeyword(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> service.getSearchRepoModels(
                Objects.requireNonNull(JSONLoader.getJSONMessage(new File("test/simulated/repotopics/results.json"))))));
        assertFalse(service.getReposWithKeyword("asda").get().isEmpty());
    }

    @Test
    public void testExtractEmptyJSON() {
        SearchForReposService searchForReposService = new SearchForReposService(ws);
        JsonNode node = JSONLoader.getJSONMessage(new File("test/simulated/repotopics/empty_results.json"));
        assert node != null;
        assertTrue(searchForReposService.getSearchRepoModels(node).isEmpty());
    }

    @Test
    public void testExtractSomeResultsJSON() {
        SearchForReposService searchForReposService = new SearchForReposService(ws);
        JsonNode node = JSONLoader.getJSONMessage(new File("test/simulated/repotopics/results.json"));
        assert node != null;
        SearchRepoModel model = new SearchRepoModel();
        model.setRepoName("CS-Notes");
        model.setUserName("CyC2018");
        model.setTopics(new String[]{
                "algorithm",
                "computer-science",
                "cpp",
                "interview",
                "java",
                "leetcode",
                "python",
                "system-design"
        });
        assertEquals(searchForReposService.getSearchRepoModels(node).get(0).getRepoName(), model.getRepoName());
        assertEquals(searchForReposService.getSearchRepoModels(node).get(1).getUserName(), model.getUserName());
        assertEquals(Arrays.toString(searchForReposService.getSearchRepoModels(node).get(0).getTopics()), Arrays.toString(model.getTopics()));
    }

    @After
    public void tearDown() throws IOException {
        try {
            ws.close();
        } finally {
            server.stop();
        }
    }


}
