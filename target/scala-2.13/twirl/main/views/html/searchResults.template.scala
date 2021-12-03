
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[play.mvc.Http.Request,ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: play.mvc.Http.Request, arrayListOfResult: ArrayList[LinkedHashMap[String,List[model.SearchRepoModel]]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.115*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
  				<script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
  				<script type='text/javascript' src='"""),_display_(/*8.44*/routes/*8.50*/.Assets.versioned("javascripts/index.js")),format.raw/*8.91*/("""'></script>  
			</head>
			<body data-ws-url=""""),_display_(/*10.24*/routes/*10.30*/.HomeController.ws.webSocketURL(request)),format.raw/*10.70*/("""">
				<div id="time">=> </div>
				<div class="container">
					"""),_display_(/*13.7*/for(mapOfSearchAndResult <- arrayListOfResult) yield /*13.53*/ {_display_(Seq[Any](format.raw/*13.55*/("""
						"""),_display_(/*14.8*/for((keyword,repoList) <- mapOfSearchAndResult) yield /*14.55*/ {_display_(Seq[Any](format.raw/*14.57*/("""
						"""),format.raw/*15.7*/("""<p>Search Term : """),_display_(/*15.25*/keyword),format.raw/*15.32*/(""" """),format.raw/*15.33*/("""</p>
							<ul>
							"""),_display_(/*17.9*/for(repo <- repoList) yield /*17.30*/ {_display_(Seq[Any](format.raw/*17.32*/("""
								"""),format.raw/*18.9*/("""<li>
									<ol type="1">
										<li><h1>User: <a href='"""),_display_(/*20.35*/routes/*20.41*/.HomeController.getUserData(repo.getUserName())),format.raw/*20.88*/("""'>"""),_display_(/*20.91*/repo/*20.95*/.getUserName()),format.raw/*20.109*/("""</a> / Repo : <a href='"""),_display_(/*20.133*/routes/*20.139*/.HomeController.getRepoData(repo.getUserName(), repo.getRepoName())),format.raw/*20.206*/("""'>"""),_display_(/*20.209*/repo/*20.213*/.getRepoName()),format.raw/*20.227*/("""</a></h1></li>
											<span>Topics : </span>
											"""),_display_(/*22.13*/for(topic <- repo.getTopics()) yield /*22.43*/ {_display_(Seq[Any](format.raw/*22.45*/("""
												"""),format.raw/*23.13*/("""<span><a href='"""),_display_(/*23.29*/routes/*23.35*/.HomeController.getTopicData(topic)),format.raw/*23.70*/("""' target="_blank">"""),_display_(/*23.89*/topic),format.raw/*23.94*/("""</a> ,</span>
											""")))}),format.raw/*24.13*/("""										
									"""),format.raw/*25.10*/("""</ol>
								</li>	
								</br>							
							""")))}),format.raw/*28.9*/("""					
							"""),format.raw/*29.8*/("""</ul>
							<hr>
						""")))}),format.raw/*31.8*/("""
					""")))}),format.raw/*32.7*/("""
 				"""),format.raw/*33.6*/("""</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*37.2*/("""
"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,arrayListOfResult:ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]]): play.twirl.api.HtmlFormat.Appendable = apply(request,arrayListOfResult)

  def f:((play.mvc.Http.Request,ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]]) => play.twirl.api.HtmlFormat.Appendable) = (request,arrayListOfResult) => apply(request,arrayListOfResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchResults.scala.html
                  HASH: 71f5f654a2e4aebb128bb55243dadb7cc3be7ce9
                  MATRIX: 992->1|1201->114|1229->117|1266->146|1305->148|1335->152|1580->371|1594->377|1655->418|1732->468|1747->474|1808->514|1903->583|1965->629|2005->631|2040->640|2103->687|2143->689|2178->697|2223->715|2251->722|2280->723|2333->750|2370->771|2410->773|2447->783|2538->847|2553->853|2621->900|2651->903|2664->907|2700->921|2752->945|2768->951|2857->1018|2888->1021|2902->1025|2938->1039|3028->1102|3074->1132|3114->1134|3156->1148|3199->1164|3214->1170|3270->1205|3316->1224|3342->1229|3400->1256|3449->1277|3532->1330|3573->1344|3630->1371|3668->1379|3702->1386|3774->1428
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|39->8|39->8|39->8|41->10|41->10|41->10|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|46->15|48->17|48->17|48->17|49->18|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|54->23|55->24|56->25|59->28|60->29|62->31|63->32|64->33|68->37
                  -- GENERATED --
              */
          