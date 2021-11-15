package utils;

import org.eclipse.egit.github.core.SearchRepository;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class SessionHelperTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    Http.RequestBuilder request;

    @Before
    public void init() {
        request = fakeRequest(GET, "/");
        request.header("User-Agent", "chrome");
        request.session(SessionHelper.getSessionKey(), request.getHeaders().get("User-Agent").get());
        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void testIsSessionExist() {
        assertTrue(SessionHelper.isSessionExist(request.build()));
    }

    @Test
    public void testSearchResultsSessionData() {
        ArrayList<SearchRepository> searchRepositoryList = new ArrayList<>();
        LinkedHashMap<String, ArrayList<SearchRepository>> searchReposLinkedHash = new LinkedHashMap<>() {{
            put("searchKeyword", searchRepositoryList);
        }};
        SessionHelper.setSessionSearchReposByKeywordHashMap(request.build(), "searchKeyword", searchRepositoryList);
        assertNotNull(searchReposLinkedHash.get("searchKeyword"));
        assertEquals(searchReposLinkedHash.get("searchKeyword"), SessionHelper.getSearchReposHashMapFromSession(request.build()).get("searchKeyword"));
    }

    @Test
    public void getSessionValueTest() {
        assertEquals(request.getHeaders().get("User-Agent").get(), SessionHelper.getSessionValue(request.build()));
    }

    @Test
    public void testGetUserAgentNameFromRequest() {
        assertEquals(SessionHelper.getUserAgentNameFromRequest(request.build()), "chrome");
    }

}
