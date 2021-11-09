
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
    					<h1 >Repositories filter with keyword </h1>
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
                  HASH: 910c7b519c9d6749b4b2a438eaa084f017b6bd31
                  MATRIX: 956->1|1115->65|1143->68|1180->97|1219->99|1249->103|1574->402|1612->424|1652->426|1687->434|1739->459|1752->463|1783->473|1852->515|1865->519|1894->527|1964->570|1977->574|2015->591|2082->631|2095->635|2130->649|2199->691|2212->695|2248->710|2318->753|2331->757|2369->774|2433->811|2446->815|2478->826|2556->877|2569->881|2599->890|2713->974|2747->981|2831->1035
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|49->18|49->18|49->18|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|60->29|61->30|66->35
                  -- GENERATED --
              */
          