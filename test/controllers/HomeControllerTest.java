package controllers;

import model.SearchRepoModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import play.Application;
import play.cache.SyncCacheApi;
import play.data.FormFactory;
import play.inject.guice.GuiceApplicationBuilder;
import play.libs.ws.WSClient;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.routing.RoutingDsl;
import play.server.Server;
import play.test.Helpers;
import play.test.WithApplication;
import services.RepoIssues;
import services.SearchForReposService;

import static play.mvc.Results.ok;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

/**
 * Test Controller to test Home Page
 * 
 * @author Harman Preet Kaur
 * @author Manan Dineshbhai Paruthi
 * @author Yashwanth Gundlapally
 * @author Kevinkumar Patel
 *
 */
@RunWith(value = MockitoJUnitRunner.class)
public class HomeControllerTest extends WithApplication {

    private Server server;
    private WSClient ws;
    private HomeController controller;

    /**
     * Override for implementing DI injection
     * 
     * @return play.Application
     * 
     */
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    /**
     * Setup for testing
     * 
     * @return void
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        server =
                Server.forRouter(
                        (components) ->
                                RoutingDsl.fromComponents(components)
                                        .GET("/searchResults?searchTerm=java")
                                        .routingTo(request -> ok().sendResource("test/simulated/repotopics/results.json"))
                                        .build());
        ws = play.test.WSTestClient.newClient(server.httpPort());
        controller = mock(HomeController.class, CALLS_REAL_METHODS);

        controller.setWs(ws);

        controller.setSearchForReposService(new SearchForReposService(ws));
    }

    /**
     * Testing for home page
     * 
     * @return void
     */
    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    /**
     * Test method for RepoIssueGeneration
     * 
     * @return void
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testRepoIssueReportGeneration() throws ExecutionException, InterruptedException {
        HomeController homeController = mock(HomeController.class, CALLS_REAL_METHODS);
        homeController.setRepoIssues(new RepoIssues());
        when(homeController.getRepoIssues(anyString(), anyString())).thenReturn(CompletableFuture.supplyAsync(new Supplier<Result>() {
            @Override
            public Result get() {
                return ok("<b>1</b> => this<br>");
            }
        }));
        assertEquals(homeController.getRepoIssues("", "").toCompletableFuture().get().status(), 200);
    }

    /**
     * Test method for Fetching Search Results from new Session
     * 
     * @return void
     * 
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testFetchSearchResultsFromRouteCallNewSession() throws ExecutionException, InterruptedException {
        controller.setPrevSearchSessionData(new HashMap<>());
        controller.setCacheApi(mock(SyncCacheApi.class));
        controller.setCacheMapSearchData(new HashMap<>());
        controller.setFormFactory(mock(FormFactory.class));
        Request requestWithoutSession = Helpers.fakeRequest().method("GET").uri("/searchResults?searchTerm=java").build();
        Result result = controller.getSearchResults(requestWithoutSession).toCompletableFuture().get();
        assertEquals(result.status(), 200);
        // controller.getSearchResults(requestWithoutSession);
    }

    /**
     * Test method for Fetching Search Results from Route Call New session
     * 
     * @return void
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testFetchSearchResultsFromRouteCallWithNewSession() throws ExecutionException, InterruptedException {
        String testKey = controller.getCurrentTimeStamp();
        ArrayList<LinkedHashMap<String,
                List< SearchRepoModel >>> prevSearchData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LinkedHashMap<String, List<SearchRepoModel>> map = new LinkedHashMap<>();
            prevSearchData.add(map);
        }
        HashMap<String, ArrayList<LinkedHashMap<String,
                                List< SearchRepoModel >>>> prevSearchSessionData = new HashMap<>();
        prevSearchSessionData.put(testKey, prevSearchData);
        controller.setPrevSearchData(prevSearchData);
        controller.setPrevSearchSessionData(prevSearchSessionData);
        controller.setCacheMapSearchData(new HashMap<>());
        SyncCacheApi cache = mock(SyncCacheApi.class);
        cache.set("java", controller.getCurrentTimeStamp());
        controller.setCacheApi(cache);
        controller.setFormFactory(mock(FormFactory.class));
        Request requestWithSession = Helpers.fakeRequest().method("GET").uri("/searchResults?searchTerm=java")
                .session("savedData", testKey).build();
        Result result = controller.getSearchResults(requestWithSession).toCompletableFuture().get();
        assertEquals(result.status(), 200);
        // controller.getSearchResults(requestWithoutSession);
    }

    /**
     * Test method for Fetching Search Results from Old Session
     * 
     * @return void
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testFetchOldSearchResultsFromRouteCallWithOldSession() throws ExecutionException, InterruptedException {
        String testKey = controller.getSaltString();
        System.out.println(testKey);
        ArrayList<LinkedHashMap<String,
                List< SearchRepoModel >>> prevSearchData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LinkedHashMap<String, List<SearchRepoModel>> map = new LinkedHashMap<>();
            map.put("java", new ArrayList<>());
            prevSearchData.add(map);
        }
        HashMap<String, List<SearchRepoModel>> cacheMapSearchData = new HashMap<>();
        cacheMapSearchData.put("java", new ArrayList<>());
        HashMap<String, ArrayList<LinkedHashMap<String,
                List< SearchRepoModel >>>> prevSearchSessionData = new HashMap<>();
        prevSearchSessionData.put("java", prevSearchData);
        controller.setPrevSearchData(prevSearchData);
        controller.setPrevSearchSessionData(prevSearchSessionData);
        controller.setCacheMapSearchData(cacheMapSearchData);

        controller.setFormFactory(mock(FormFactory.class));
        Request requestWithSession = Helpers.fakeRequest().method("GET")
                .uri("/searchResults?searchTerm=java")
                .session("savedData", testKey).build();
        SyncCacheApi cache = mock(SyncCacheApi.class);
        cache.set("java", testKey);
        controller.setCacheApi(cache);
        Result result = controller.getSearchResults(requestWithSession).toCompletableFuture().get();
        assertEquals(result.status(), 200);
    }

    /**
     * Closing method after testing
     * 
     * @return void
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
        try {
            ws.close();
        } finally {
            server.stop();
        }
    }

}
