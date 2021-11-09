
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

object userData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[org.eclipse.egit.github.core.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data: org.eclipse.egit.github.core.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
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
					<p>Id</p>
					<h1>"""),_display_(/*16.11*/data/*16.15*/.getId()),format.raw/*16.23*/("""</h1>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(data:org.eclipse.egit.github.core.User): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((org.eclipse.egit.github.core.User) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/userData.scala.html
                  HASH: 69002653c4ebe29f2aa5b03714ebf7a62fcf045b
                  MATRIX: 937->1|1072->44|1109->73|1148->75|1177->78|1466->340|1479->344|1508->352|1587->401
                  LINES: 27->1|32->2|32->2|32->2|33->3|46->16|46->16|46->16|51->21
                  -- GENERATED --
              */
          