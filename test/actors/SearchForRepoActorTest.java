package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import play.Application;
import play.libs.ws.WSClient;
import play.routing.RoutingDsl;
import play.server.Server;
import play.test.WithApplication;
import services.SearchForReposService;
import utils.JSONLoader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static play.mvc.Results.ok;

@RunWith(value = MockitoJUnitRunner.class)
public class SearchForRepoActorTest extends WithApplication {

    private Server server;
    private WSClient ws;
    private SearchForReposService searchForReposService;
    static ActorSystem actorSystem;

    @Override
    protected Application provideApplication() {
        return super.provideApplication();
    }

    @Before
    public void init() {
        actorSystem = ActorSystem.create();

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
    public void test1() throws ExecutionException, InterruptedException {
        new TestKit(actorSystem) {{

            SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
            service.setWs(ws);
            when(service.getReposWithKeyword(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> service.getSearchRepoModels(
                    Objects.requireNonNull(JSONLoader.getJSONMessage(new File("test/simulated/repotopics/results.json"))))));
            assertFalse(service.getReposWithKeyword("asda").get().isEmpty());
            final ActorRef searchForRepoActor = actorSystem.actorOf(SearchForRepoActor.getProps(service));
            searchForRepoActor.tell(new SearchForRepoActor.Tick(), ActorRef.noSender());
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        new TestKit(actorSystem) {{
            SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
            service.setWs(ws);
            final ActorRef searchForRepoActor = actorSystem.actorOf(SearchForRepoActor.getProps(service));
            searchForRepoActor.tell(new SearchForRepoActor.RequestMsg("java"), ActorRef.noSender());
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        new TestKit(actorSystem) {{
            SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
            service.setWs(ws);
            when(service.getReposWithKeyword(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> service.getSearchRepoModels(
                    Objects.requireNonNull(JSONLoader.getJSONMessage(new File("test/simulated/repotopics/results.json"))))));
            assertFalse(service.getReposWithKeyword("java").get().isEmpty());
            final ActorRef searchForRepoActor = actorSystem.actorOf(SearchForRepoActor.getProps(service));
            searchForRepoActor.tell(new SearchForRepoActor.RequestMsg("java"), ActorRef.noSender());
            searchForRepoActor.tell(new SearchForRepoActor.Tick(), ActorRef.noSender());
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        new TestKit(actorSystem) {{
            SearchForReposService service = mock(SearchForReposService.class, CALLS_REAL_METHODS);
            service.setWs(ws);
            final ActorRef searchForRepoActor = actorSystem.actorOf(SearchForRepoActor.getProps(service));
            searchForRepoActor.tell(new SearchForRepoActor.RegisterMsg(), ActorRef.noSender());
            within(Duration.ofSeconds(3), () -> {
                expectNoMessage();
                return null;
            });
        }};
    }

}