// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:10
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:10
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userData/""" + "$" + """userName<[^/]+>""", """controllers.HomeController.getUserData(request:Request, userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repoIssues/""" + "$" + """userName<[^/]+>/""" + "$" + """repoName<[^/]+>""", """controllers.HomeController.getRepoIssues(userName:String, repoName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """topicData/""" + "$" + """topic<[^/]+>""", """controllers.HomeController.getTopicData(request:Request, topic:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repoData/""" + "$" + """userName<[^/]+>/""" + "$" + """repoName<[^/]+>""", """controllers.HomeController.getRepoData(request:Request, userName:String, repoName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchResult""", """controllers.HomeController.getSearchResults(request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_getUserData2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userData/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getUserData2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.getUserData(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getUserData",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """userData/""" + "$" + """userName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_getRepoIssues3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repoIssues/"), DynamicPart("userName", """[^/]+""",true), StaticPart("/"), DynamicPart("repoName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getRepoIssues3_invoker = createInvoker(
    HomeController_1.getRepoIssues(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRepoIssues",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """repoIssues/""" + "$" + """userName<[^/]+>/""" + "$" + """repoName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_getTopicData4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("topicData/"), DynamicPart("topic", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getTopicData4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.getTopicData(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getTopicData",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """topicData/""" + "$" + """topic<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_getRepoData5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repoData/"), DynamicPart("userName", """[^/]+""",true), StaticPart("/"), DynamicPart("repoName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getRepoData5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.getRepoData(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRepoData",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "GET",
      this.prefix + """repoData/""" + "$" + """userName<[^/]+>/""" + "$" + """repoName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_getSearchResults6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchResult")))
  )
  private[this] lazy val controllers_HomeController_getSearchResults6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.getSearchResults(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getSearchResults",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """searchResult""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_1.index(req))
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_HomeController_getUserData2_route(params@_) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_HomeController_getUserData2_invoker.call(
          req => HomeController_1.getUserData(req, userName))
      }
  
    // @LINE:14
    case controllers_HomeController_getRepoIssues3_route(params@_) =>
      call(params.fromPath[String]("userName", None), params.fromPath[String]("repoName", None)) { (userName, repoName) =>
        controllers_HomeController_getRepoIssues3_invoker.call(HomeController_1.getRepoIssues(userName, repoName))
      }
  
    // @LINE:15
    case controllers_HomeController_getTopicData4_route(params@_) =>
      call(params.fromPath[String]("topic", None)) { (topic) =>
        controllers_HomeController_getTopicData4_invoker.call(
          req => HomeController_1.getTopicData(req, topic))
      }
  
    // @LINE:17
    case controllers_HomeController_getRepoData5_route(params@_) =>
      call(params.fromPath[String]("userName", None), params.fromPath[String]("repoName", None)) { (userName, repoName) =>
        controllers_HomeController_getRepoData5_invoker.call(
          req => HomeController_1.getRepoData(req, userName, repoName))
      }
  
    // @LINE:19
    case controllers_HomeController_getSearchResults6_route(params@_) =>
      call { 
        controllers_HomeController_getSearchResults6_invoker.call(
          req => HomeController_1.getSearchResults(req))
      }
  }
}
