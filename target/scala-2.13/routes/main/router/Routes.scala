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
  HomeController_2: controllers.HomeController,
  // @LINE:10
  Assets_1: controllers.Assets,
  // @LINE:13
  UserDataController_3: controllers.UserDataController,
<<<<<<< HEAD
  // @LINE:14
  TopicDataController_0: controllers.TopicDataController,
=======
  // @LINE:15
  RepoDataController_1: controllers.RepoDataController,
>>>>>>> main
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_2: controllers.HomeController,
    // @LINE:10
    Assets_1: controllers.Assets,
    // @LINE:13
    UserDataController_3: controllers.UserDataController,
<<<<<<< HEAD
    // @LINE:14
    TopicDataController_0: controllers.TopicDataController
  ) = this(errorHandler, HomeController_2, Assets_1, UserDataController_3, TopicDataController_0, "/")
=======
    // @LINE:15
    RepoDataController_1: controllers.RepoDataController
  ) = this(errorHandler, HomeController_2, Assets_0, UserDataController_3, RepoDataController_1, "/")
>>>>>>> main

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
<<<<<<< HEAD
    new Routes(errorHandler, HomeController_2, Assets_1, UserDataController_3, TopicDataController_0, prefix)
=======
    new Routes(errorHandler, HomeController_2, Assets_0, UserDataController_3, RepoDataController_1, prefix)
>>>>>>> main
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """git/""" + "$" + """name<[^/]+>""", """controllers.HomeController.getUserProfile(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userData/""" + "$" + """userName<[^/]+>""", """controllers.UserDataController.getUserData(userName:String)"""),
<<<<<<< HEAD
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """topicData/""" + "$" + """topic<[^/]+>""", """controllers.TopicDataController.getTopicData(topic:String)"""),
=======
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repoData/""" + "$" + """userName<[^/]+>""", """controllers.RepoDataController.getRepoData(request:Request, userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchResult""", """controllers.HomeController.getSearchResults(request:Request)"""),
>>>>>>> main
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
<<<<<<< HEAD
    HomeController_2.index,
=======
    
    (req:play.mvc.Http.Request) =>
      HomeController_2.index(fakeValue[play.mvc.Http.Request]),
>>>>>>> main
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
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:11
  private[this] lazy val controllers_HomeController_getUserProfile2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("git/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getUserProfile2_invoker = createInvoker(
    HomeController_2.getUserProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getUserProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """git/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserDataController_getUserData3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userData/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserDataController_getUserData3_invoker = createInvoker(
    UserDataController_3.getUserData(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserDataController",
      "getUserData",
      Seq(classOf[String]),
      "GET",
      this.prefix + """userData/""" + "$" + """userName<[^/]+>""",
      """""",
      Seq()
    )
  )

<<<<<<< HEAD
  // @LINE:14
  private[this] lazy val controllers_TopicDataController_getTopicData4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("topicData/"), DynamicPart("topic", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TopicDataController_getTopicData4_invoker = createInvoker(
    TopicDataController_0.getTopicData(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TopicDataController",
      "getTopicData",
      Seq(classOf[String]),
      "GET",
      this.prefix + """topicData/""" + "$" + """topic<[^/]+>""",
=======
  // @LINE:15
  private[this] lazy val controllers_RepoDataController_getRepoData4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repoData/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RepoDataController_getRepoData4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RepoDataController_1.getRepoData(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RepoDataController",
      "getRepoData",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """repoData/""" + "$" + """userName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_getSearchResults5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchResult")))
  )
  private[this] lazy val controllers_HomeController_getSearchResults5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_2.getSearchResults(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getSearchResults",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """searchResult""",
>>>>>>> main
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
<<<<<<< HEAD
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
=======
        controllers_HomeController_index0_invoker.call(
          req => HomeController_2.index(req))
>>>>>>> main
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_HomeController_getUserProfile2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_getUserProfile2_invoker.call(HomeController_2.getUserProfile(name))
      }
  
    // @LINE:13
    case controllers_UserDataController_getUserData3_route(params@_) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserDataController_getUserData3_invoker.call(UserDataController_3.getUserData(userName))
      }
  
<<<<<<< HEAD
    // @LINE:14
    case controllers_TopicDataController_getTopicData4_route(params@_) =>
      call(params.fromPath[String]("topic", None)) { (topic) =>
        controllers_TopicDataController_getTopicData4_invoker.call(TopicDataController_0.getTopicData(topic))
=======
    // @LINE:15
    case controllers_RepoDataController_getRepoData4_route(params@_) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_RepoDataController_getRepoData4_invoker.call(
          req => RepoDataController_1.getRepoData(req, userName))
      }
  
    // @LINE:17
    case controllers_HomeController_getSearchResults5_route(params@_) =>
      call { 
        controllers_HomeController_getSearchResults5_invoker.call(
          req => HomeController_2.getSearchResults(req))
>>>>>>> main
      }
  }
}
