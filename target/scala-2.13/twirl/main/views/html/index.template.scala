
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
/*1.2*/import helper._
/*2.2*/import play.mvc.Http.Request
/*3.2*/import views.SearchDTO

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[play.data.Form[SearchDTO],play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(newSearchForm: play.data.Form[SearchDTO])(implicit messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.83*/("""
"""),_display_(/*5.2*/main("Welcome to Gitterific")/*5.31*/ {_display_(Seq[Any](format.raw/*5.33*/("""
  		"""),format.raw/*6.5*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
  					
  					
  					
					"""),_display_(/*16.7*/helper/*16.13*/.form(action = routes.HomeController.getSearchResults())/*16.69*/ {_display_(Seq[Any](format.raw/*16.71*/("""
    					"""),_display_(/*17.11*/helper/*17.17*/.inputText(newSearchForm("searchTerm"))),format.raw/*17.56*/("""
    					"""),format.raw/*18.10*/("""<button type="submit" class="btn btn-primary btn-block">Search</button>
					""")))}),format.raw/*19.7*/("""
				"""),format.raw/*20.5*/("""</div>
  			</body>
  		</html>
""")))}))
      }
    }
  }

  def render(newSearchForm:play.data.Form[SearchDTO],messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(newSearchForm)(messages)

  def f:((play.data.Form[SearchDTO]) => (play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (newSearchForm) => (messages) => apply(newSearchForm)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 78a27bbd37980525a2653e31b3bbdcba701ecc86
                  MATRIX: 610->1|633->19|669->50|1034->75|1210->156|1238->159|1275->188|1314->190|1346->196|1535->359|1550->365|1615->421|1655->423|1694->435|1709->441|1769->480|1808->491|1917->570|1950->576
                  LINES: 23->1|24->2|25->3|30->4|35->4|36->5|36->5|36->5|37->6|47->16|47->16|47->16|47->16|48->17|48->17|48->17|49->18|50->19|51->20
                  -- GENERATED --
              */
          