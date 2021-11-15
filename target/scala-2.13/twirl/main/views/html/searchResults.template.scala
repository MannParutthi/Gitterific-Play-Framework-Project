
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
							<li><h1>NAME: """),_display_(/*19.23*/repo/*19.27*/.getName()),format.raw/*19.37*/("""</h1></li>
							<li><h1>OWNER: """),_display_(/*20.24*/repo/*20.28*/.getOwner()),format.raw/*20.39*/("""</h1></li>
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
                  HASH: 0adb1b522814760b40431fd5a15b5275b401e106
                  MATRIX: 960->1|1118->64|1146->67|1183->96|1222->98|1252->102|1544->368|1581->389|1621->391|1655->398|1731->447|1744->451|1775->461|1837->496|1850->500|1882->511|1955->554|1989->561|2073->615
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|50->19|50->19|50->19|51->20|51->20|51->20|54->23|55->24|60->29
                  -- GENERATED --
              */
          