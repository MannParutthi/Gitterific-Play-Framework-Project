
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

object searchResults extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[org.eclipse.egit.github.core.SearchRepository],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repoList: List[org.eclipse.egit.github.core.SearchRepository]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.65*/("""
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
					<ul>
					"""),_display_(/*16.7*/for(repo <- repoList) yield /*16.28*/ {_display_(Seq[Any](format.raw/*16.30*/("""
					"""),format.raw/*17.6*/("""<li>
						<ol type="1">
							<li><h1>NAME: <a href='"""),_display_(/*19.32*/routes/*19.38*/.TopicDataController.getTopicData(repo.getName())),format.raw/*19.87*/("""'>"""),_display_(/*19.90*/repo/*19.94*/.getName()),format.raw/*19.104*/("""</a></h1></li>
							<li><h1>OWNER: <a href='"""),_display_(/*20.33*/routes/*20.39*/.UserDataController.getUserData(repo.getOwner())),format.raw/*20.87*/("""'>"""),_display_(/*20.90*/repo/*20.94*/.getOwner()),format.raw/*20.105*/("""</a></h1></li>
						</ol>
					</li>
					""")))}),format.raw/*23.7*/("""
					"""),format.raw/*24.6*/("""</ul>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*29.2*/("""
"""))
      }
    }
  }

  def render(repoList:List[org.eclipse.egit.github.core.SearchRepository]): play.twirl.api.HtmlFormat.Appendable = apply(repoList)

  def f:((List[org.eclipse.egit.github.core.SearchRepository]) => play.twirl.api.HtmlFormat.Appendable) = (repoList) => apply(repoList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchResults.scala.html
                  HASH: 95e4505641e731fdfc848579e9effe94aa22c810
                  MATRIX: 960->1|1118->64|1146->67|1183->96|1222->98|1252->102|1544->368|1581->389|1621->391|1655->398|1740->456|1755->462|1825->511|1855->514|1868->518|1900->528|1975->576|1990->582|2059->630|2089->633|2102->637|2135->648|2212->695|2246->702|2330->756
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|50->19|50->19|50->19|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|54->23|55->24|60->29
                  -- GENERATED --
              */
          