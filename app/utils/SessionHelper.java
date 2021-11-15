package utils;

import org.eclipse.egit.github.core.SearchRepository;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SessionHelper {

    private static final HashMap<String, LinkedHashMap<String, ArrayList<SearchRepository>>> sessionSearchReposByKeywordHashMap = new HashMap<>();
    private static final String SESSION_KEY = "sessionId";

    public static String getSessionKey() {
        return SESSION_KEY;
    }

    public static String getUserAgentNameFromRequest(Http.Request request) {
        return request.getHeaders().get("User-Agent").orElse(null);
    }

    public static LinkedHashMap<String, ArrayList<SearchRepository>> getSearchReposHashMapFromSession(Http.Request request) {
        String key = getSessionValue(request);
        return sessionSearchReposByKeywordHashMap.get(key);
    }

    public static void setSessionSearchReposByKeywordHashMap(Http.Request request, String searchKeyword, ArrayList<SearchRepository> searchRepositories) {
        String key = getSessionValue(request);
        LinkedHashMap<String, ArrayList<SearchRepository>> searchReposLinkedHashMap = getSearchReposHashMapFromSession(request);
        if (searchReposLinkedHashMap == null)
            searchReposLinkedHashMap = new LinkedHashMap<>();
        searchReposLinkedHashMap.put(searchKeyword, searchRepositories);
        sessionSearchReposByKeywordHashMap.put(key, searchReposLinkedHashMap);
    }

    public static boolean isSessionExist(Http.Request request) {
        return request.session().get(SESSION_KEY).orElse(null) != null;
    }

    public static String getSessionValue(Http.Request request) {
        return request.session().get(SESSION_KEY).orElse(null);
    }


}
