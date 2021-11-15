
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

object repoIssueShow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issueReport: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.23*/("""

"""),_display_(/*3.2*/main("Welcome to Gitterific")/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
	"""),format.raw/*4.2*/("""<!DOCTYPE html>
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
			"""),_display_(/*15.5*/Html(issueReport)),format.raw/*15.22*/("""
  		"""),format.raw/*16.5*/("""</body>
  	</html>	
""")))}))
      }
    }
  }

  def render(issueReport:String): play.twirl.api.HtmlFormat.Appendable = apply(issueReport)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (issueReport) => apply(issueReport)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repoIssueShow.scala.html
                  HASH: 53d77cfb6f461d77ff89303161ef2aa702d61907
                  MATRIX: 915->1|1031->22|1061->27|1098->56|1137->58|1166->61|1406->275|1444->292|1477->298
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|46->15|46->15|47->16
                  -- GENERATED --
              */
          