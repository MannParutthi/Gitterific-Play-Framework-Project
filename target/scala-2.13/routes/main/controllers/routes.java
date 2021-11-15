// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserDataController UserDataController = new controllers.ReverseUserDataController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRepoIssueController RepoIssueController = new controllers.ReverseRepoIssueController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTopicDataController TopicDataController = new controllers.ReverseTopicDataController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRepoDataController RepoDataController = new controllers.ReverseRepoDataController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserDataController UserDataController = new controllers.javascript.ReverseUserDataController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRepoIssueController RepoIssueController = new controllers.javascript.ReverseRepoIssueController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTopicDataController TopicDataController = new controllers.javascript.ReverseTopicDataController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRepoDataController RepoDataController = new controllers.javascript.ReverseRepoDataController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
