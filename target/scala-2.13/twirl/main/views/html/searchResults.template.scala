
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(arrayListOfResult: ArrayList[LinkedHashMap[String,List[model.SearchRepoModel]]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.83*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
					"""),_display_(/*10.7*/for(mapOfSearchAndResult <- arrayListOfResult) yield /*10.53*/ {_display_(Seq[Any](format.raw/*10.55*/("""
						"""),_display_(/*11.8*/for((keyword,repoList) <- mapOfSearchAndResult) yield /*11.55*/ {_display_(Seq[Any](format.raw/*11.57*/("""
						"""),format.raw/*12.7*/("""<p>Search Term : """),_display_(/*12.25*/keyword),format.raw/*12.32*/(""" """),format.raw/*12.33*/("""</p>
							<ul>
							"""),_display_(/*14.9*/for(repo <- repoList) yield /*14.30*/ {_display_(Seq[Any](format.raw/*14.32*/("""
								"""),format.raw/*15.9*/("""<li>
									<ol type="1">
										<li><h1>User: <a href='"""),_display_(/*17.35*/routes/*17.41*/.HomeController.getUserData(repo.getUserName())),format.raw/*17.88*/("""'>"""),_display_(/*17.91*/repo/*17.95*/.getUserName()),format.raw/*17.109*/("""</a> / Repo : <a href='"""),_display_(/*17.133*/routes/*17.139*/.HomeController.getRepoData(repo.getUserName(), repo.getRepoName())),format.raw/*17.206*/("""'>"""),_display_(/*17.209*/repo/*17.213*/.getRepoName()),format.raw/*17.227*/("""</a></h1></li>
											<span>Topics : </span>
											"""),_display_(/*19.13*/for(topic <- repo.getTopics()) yield /*19.43*/ {_display_(Seq[Any](format.raw/*19.45*/("""
												"""),format.raw/*20.13*/("""<span><a href='"""),_display_(/*20.29*/routes/*20.35*/.HomeController.getTopicData(topic)),format.raw/*20.70*/("""'>"""),_display_(/*20.73*/topic),format.raw/*20.78*/("""</a> ,</span>
											""")))}),format.raw/*21.13*/("""										
									"""),format.raw/*22.10*/("""</ol>
								</li>	
								</br>							
							""")))}),format.raw/*25.9*/("""					
							"""),format.raw/*26.8*/("""</ul>
							<hr>
						""")))}),format.raw/*28.8*/("""
					""")))}),format.raw/*29.7*/("""
 				"""),format.raw/*30.6*/("""</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*34.2*/("""
"""))
      }
    }
  }

  def render(arrayListOfResult:ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]]): play.twirl.api.HtmlFormat.Appendable = apply(arrayListOfResult)

  def f:((ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]]) => play.twirl.api.HtmlFormat.Appendable) = (arrayListOfResult) => apply(arrayListOfResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchResults.scala.html
                  HASH: b56cd69e34636ecdc062217e6b2e04d0d96f03c0
                  MATRIX: 970->1|1146->82|1174->85|1211->114|1250->116|1280->120|1442->256|1504->302|1544->304|1579->313|1642->360|1682->362|1717->370|1762->388|1790->395|1819->396|1872->423|1909->444|1949->446|1986->456|2077->520|2092->526|2160->573|2190->576|2203->580|2239->594|2291->618|2307->624|2396->691|2427->694|2441->698|2477->712|2567->775|2613->805|2653->807|2695->821|2738->837|2753->843|2809->878|2839->881|2865->886|2923->913|2972->934|3055->987|3096->1001|3153->1028|3191->1036|3225->1043|3297->1085
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|43->12|45->14|45->14|45->14|46->15|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|52->21|53->22|56->25|57->26|59->28|60->29|61->30|65->34
                  -- GENERATED --
              */
          