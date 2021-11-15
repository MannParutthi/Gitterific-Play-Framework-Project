// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUserDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def getUserData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserDataController.getUserData",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userData/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userName", userName0))})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseRepoIssueController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getRepoIssues: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RepoIssueController.getRepoIssues",
      """
        function(userName0,repoName1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "repoIssues/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userName", userName0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("repoName", repoName1))})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseTopicDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getTopicData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TopicDataController.getTopicData",
      """
        function(topic0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "topicData/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("topic", topic0))})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseRepoDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getRepoData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RepoDataController.getRepoData",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "repoData/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userName", userName0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getUserProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getUserProfile",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "git/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:20
    def getSearchResults: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getSearchResults",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchResult"})
        }
      """
    )
  
  }


}
