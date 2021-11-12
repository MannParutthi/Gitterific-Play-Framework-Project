
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

object topicData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[org.eclipse.egit.github.core.SearchRepository],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topicData: List[org.eclipse.egit.github.core.SearchRepository]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.66*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
  					<div class="jumbotron">
    					<h3>Repositories filtered based on the Creation Date</h3>
  					</div>
				</div>
				<div class="container">
					<ol type="1">
						"""),_display_(/*16.8*/for(data <- topicData) yield /*16.30*/ {_display_(Seq[Any](format.raw/*16.32*/("""
						"""),format.raw/*17.7*/("""<li>
							<h4>NAME : """),_display_(/*18.20*/data/*18.24*/.getName()),format.raw/*18.34*/("""</h4>
							<ul>
								<li><h4>ID : """),_display_(/*20.23*/data/*20.27*/.getId()),format.raw/*20.35*/("""</h4></li>
								<li><h4>DESCRIPTION : """),_display_(/*21.32*/data/*21.36*/.getDescription()),format.raw/*21.53*/("""</h4></li>
								<li><h4>LANGUAGE : """),_display_(/*22.29*/data/*22.33*/.getLanguage()),format.raw/*22.47*/("""</h4></li>
								<li><h4>CREATED ON : """),_display_(/*23.31*/data/*23.35*/.getCreatedAt()),format.raw/*23.50*/("""</h4></li>
								<li><h4>DESCRIPTION : """),_display_(/*24.32*/data/*24.36*/.getDescription()),format.raw/*24.53*/("""</h4></li>
								<li><h4>OWNER : """),_display_(/*25.26*/data/*25.30*/.getOwner()),format.raw/*25.41*/("""</h4></li>
								<li><h4>CREATED ON : <a href=""""),_display_(/*26.40*/data/*26.44*/.getUrl()),format.raw/*26.53*/("""" target="_blank">Repository Link</a> </h4></li>
							</ul>
						</li>
						""")))}),format.raw/*29.8*/("""
					"""),format.raw/*30.6*/("""</ol>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*35.2*/("""
"""))
      }
    }
  }

  def render(topicData:List[org.eclipse.egit.github.core.SearchRepository]): play.twirl.api.HtmlFormat.Appendable = apply(topicData)

  def f:((List[org.eclipse.egit.github.core.SearchRepository]) => play.twirl.api.HtmlFormat.Appendable) = (topicData) => apply(topicData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/topicData.scala.html
                  HASH: 72d090634db130f8ce063805b739ad959055f949
                  MATRIX: 956->1|1115->65|1143->68|1180->97|1219->99|1249->103|1588->416|1626->438|1666->440|1701->448|1753->473|1766->477|1797->487|1866->529|1879->533|1908->541|1978->584|1991->588|2029->605|2096->645|2109->649|2144->663|2213->705|2226->709|2262->724|2332->767|2345->771|2383->788|2447->825|2460->829|2492->840|2570->891|2583->895|2613->904|2727->988|2761->995|2845->1049
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|49->18|49->18|49->18|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|60->29|61->30|66->35
                  -- GENERATED --
              */
          