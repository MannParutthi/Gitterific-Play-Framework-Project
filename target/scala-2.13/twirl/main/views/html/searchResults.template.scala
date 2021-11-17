
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[ArrayList[LinkedHashMap[String, List[org.eclipse.egit.github.core.SearchRepository]]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(arrayListOfResult: ArrayList[LinkedHashMap[String,List[org.eclipse.egit.github.core.SearchRepository]]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.107*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
  					<div class="jumbotron">
    					<h1 >Gitterific</h1>
  					</div>
				</div>
				<div class="container">
					"""),_display_(/*15.7*/for(mapOfSearchAndResult <- arrayListOfResult) yield /*15.53*/ {_display_(Seq[Any](format.raw/*15.55*/("""
						"""),_display_(/*16.8*/for((keyword,repoList) <- mapOfSearchAndResult) yield /*16.55*/ {_display_(Seq[Any](format.raw/*16.57*/("""
						"""),format.raw/*17.7*/("""<p> """),_display_(/*17.12*/keyword),format.raw/*17.19*/(""" """),format.raw/*17.20*/("""</p>
							<ul>
							"""),_display_(/*19.9*/for(repo <- repoList) yield /*19.30*/ {_display_(Seq[Any](format.raw/*19.32*/("""
								"""),format.raw/*20.9*/("""<li>
									<ol type="1">
										<li><h1>NAME: <a href='"""),_display_(/*22.35*/routes/*22.41*/.HomeController.getRepoIssues(repo.getOwner(), repo.getName())),format.raw/*22.103*/("""'>"""),_display_(/*22.106*/repo/*22.110*/.getName()),format.raw/*22.120*/("""</a></h1></li>
										<li><h1>OWNER: <a href='"""),_display_(/*23.36*/routes/*23.42*/.HomeController.getUserData(repo.getOwner())),format.raw/*23.86*/("""'>"""),_display_(/*23.89*/repo/*23.93*/.getOwner()),format.raw/*23.104*/("""</a></h1></li>
									</ol>
								</li>
							""")))}),format.raw/*26.9*/("""
							"""),format.raw/*27.8*/("""</ul>
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

  def render(arrayListOfResult:ArrayList[LinkedHashMap[String, List[org.eclipse.egit.github.core.SearchRepository]]]): play.twirl.api.HtmlFormat.Appendable = apply(arrayListOfResult)

  def f:((ArrayList[LinkedHashMap[String, List[org.eclipse.egit.github.core.SearchRepository]]]) => play.twirl.api.HtmlFormat.Appendable) = (arrayListOfResult) => apply(arrayListOfResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchResults.scala.html
                  HASH: 179f298c80f97db7cdb483e7ba88346c296d6ddb
                  MATRIX: 994->1|1195->106|1223->109|1260->138|1299->140|1329->144|1610->399|1672->445|1712->447|1747->456|1810->503|1850->505|1885->513|1917->518|1945->525|1974->526|2027->553|2064->574|2104->576|2141->586|2232->650|2247->656|2331->718|2362->721|2376->725|2408->735|2486->786|2501->792|2566->836|2596->839|2609->843|2642->854|2727->909|2763->918|2807->932|2845->940|2879->947|2951->989
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|48->17|50->19|50->19|50->19|51->20|53->22|53->22|53->22|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|54->23|57->26|58->27|59->28|60->29|61->30|65->34
                  -- GENERATED --
              */
          