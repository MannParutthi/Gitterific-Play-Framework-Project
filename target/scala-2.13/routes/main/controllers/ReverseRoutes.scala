// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getRepoIssues(userName:String, repoName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "repoIssues/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userName", userName)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repoName", repoName)))
    }
  
    // @LINE:13
    def getUserData(userName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userData/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userName", userName)))
    }
  
    // @LINE:20
    def getSearchResults(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchResult")
    }
  
    // @LINE:11
    def getUserProfile(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "git/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:16
    def getTopicData(topic:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "topicData/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("topic", topic)))
    }
  
    // @LINE:18
    def getRepoData(userName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "repoData/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userName", userName)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
