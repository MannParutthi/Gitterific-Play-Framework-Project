
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
  					<div class="jumbotron">
    					<h1>Gitterific</h1>
  					</div>
  					
  					
					"""),_display_(/*18.7*/helper/*18.13*/.form(action = routes.HomeController.getSearchResults())/*18.69*/ {_display_(Seq[Any](format.raw/*18.71*/("""
    					"""),_display_(/*19.11*/helper/*19.17*/.inputText(newSearchForm("searchTerm"))),format.raw/*19.56*/("""
    					"""),format.raw/*20.10*/("""<button type="submit" class="btn btn-primary btn-block">Search</button>
					""")))}),format.raw/*21.7*/("""
				"""),format.raw/*22.5*/("""</div>
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
                  HASH: 42e92cfae705b331abc941aff977b79121164207
                  MATRIX: 610->1|633->19|669->50|1034->75|1210->156|1238->159|1275->188|1314->190|1346->196|1603->427|1618->433|1683->489|1723->491|1762->503|1777->509|1837->548|1876->559|1985->638|2018->644
                  LINES: 23->1|24->2|25->3|30->4|35->4|36->5|36->5|36->5|37->6|49->18|49->18|49->18|49->18|50->19|50->19|50->19|51->20|52->21|53->22
                  -- GENERATED --
              */
          