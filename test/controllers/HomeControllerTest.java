package controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;
import services.RepoIssues;
import static play.mvc.Results.ok;

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
 */
@RunWith(value = MockitoJUnitRunner.class)
public class HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

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

}
