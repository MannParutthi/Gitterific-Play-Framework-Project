
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
										<li><h1>OWNER: <a href='"""),_display_(/*22.36*/routes/*22.42*/.HomeController.getUserData(repo.getUserName())),format.raw/*22.89*/("""'>"""),_display_(/*22.92*/repo/*22.96*/.getUserName()),format.raw/*22.110*/("""</a></h1></li>
										<li><h1>REPO NAME: <a href='"""),_display_(/*23.40*/routes/*23.46*/.HomeController.getRepoData(repo.getUserName(), repo.getRepoName())),format.raw/*23.113*/("""'>"""),_display_(/*23.116*/repo/*23.120*/.getRepoName()),format.raw/*23.134*/("""</a></h1></li>
										<li>
											"""),_display_(/*25.13*/for(topic <- repo.getTopics()) yield /*25.43*/ {_display_(Seq[Any](format.raw/*25.45*/("""
												"""),format.raw/*26.13*/("""<p>"""),_display_(/*26.17*/topic),format.raw/*26.22*/("""</p>
											""")))}),format.raw/*27.13*/("""
										"""),format.raw/*28.11*/("""</li>
									</ol>
								</li>
								<hr>
							""")))}),format.raw/*32.9*/("""
							"""),format.raw/*33.8*/("""</ul>
						""")))}),format.raw/*34.8*/("""
					""")))}),format.raw/*35.7*/("""
 				"""),format.raw/*36.6*/("""</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*40.2*/("""
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
                  HASH: 5e7f86a83cb1f8d65bc0d874bcd44d2f44b9bcdf
                  MATRIX: 970->1|1146->82|1174->85|1211->114|1250->116|1280->120|1561->375|1623->421|1663->423|1698->432|1761->479|1801->481|1836->489|1868->494|1896->501|1925->502|1978->529|2015->550|2055->552|2092->562|2184->627|2199->633|2267->680|2297->683|2310->687|2346->701|2428->756|2443->762|2532->829|2563->832|2577->836|2613->850|2684->894|2730->924|2770->926|2812->940|2843->944|2869->949|2918->967|2958->979|3048->1039|3084->1048|3128->1062|3166->1070|3200->1077|3272->1119
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|48->17|50->19|50->19|50->19|51->20|53->22|53->22|53->22|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|54->23|56->25|56->25|56->25|57->26|57->26|57->26|58->27|59->28|63->32|64->33|65->34|66->35|67->36|71->40
                  -- GENERATED --
              */
          