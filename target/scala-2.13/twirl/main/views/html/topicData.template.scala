
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

object topicData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[model.TopicDataModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topicData: List[model.TopicDataModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.41*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
  					<div class="jumbotron">
    					<h3 style="font-size:2vw;"><b>Latest 10 Repositories filtered by Pushed Date</b></h3><br/>
  					</div>
				</div>
								<div class="container">
					<ol type="1">
						"""),_display_(/*16.8*/for(data <- topicData) yield /*16.30*/ {_display_(Seq[Any](format.raw/*16.32*/("""
						"""),format.raw/*17.7*/("""<li>
							<h4 style="font-size:1.5vw;"><b>Name</b> : """),_display_(/*18.52*/data/*18.56*/.getName()),format.raw/*18.66*/("""</h4>
							<ul>
								<li><h4 style="font-size:1.5vw;"><b>ID</b> : """),_display_(/*20.55*/data/*20.59*/.getId()),format.raw/*20.67*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Language</b> : """),_display_(/*21.61*/data/*21.65*/.getLanguage()),format.raw/*21.79*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Created On</b> : """),_display_(/*22.63*/data/*22.67*/.getCreatedAt()),format.raw/*22.82*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Description</b> : """),_display_(/*23.64*/data/*23.68*/.getDescription()),format.raw/*23.85*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Owner</b> : """),_display_(/*24.58*/data/*24.62*/.getOwner()),format.raw/*24.73*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Size</b> : """),_display_(/*25.57*/data/*25.61*/.getSize()),format.raw/*25.71*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Puhsed At</b> : """),_display_(/*26.62*/data/*26.66*/.getPushedAt()),format.raw/*26.80*/("""</h4></li>
								<li><h4 style="font-size:1.5vw;"><b>Repository URL</b> : <a href=""""),_display_(/*27.76*/data/*27.80*/.getUrl()),format.raw/*27.89*/("""" target="_blank">Repository Link</a> </h4></li>
							</ul>
							<br/><br/>
						</li>
						""")))}),format.raw/*31.8*/("""
					"""),format.raw/*32.6*/("""</ol>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*37.2*/("""
"""))
      }
    }
  }

  def render(topicData:List[model.TopicDataModel]): play.twirl.api.HtmlFormat.Appendable = apply(topicData)

  def f:((List[model.TopicDataModel]) => play.twirl.api.HtmlFormat.Appendable) = (topicData) => apply(topicData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/topicData.scala.html
                  HASH: f325e0f4525a0efdffbe12969e6e1979ee574984
                  MATRIX: 931->1|1065->40|1093->43|1130->72|1169->74|1199->78|1575->428|1613->450|1653->452|1688->460|1772->517|1785->521|1816->531|1917->605|1930->609|1959->617|2058->689|2071->693|2106->707|2207->781|2220->785|2256->800|2358->875|2371->879|2409->896|2505->965|2518->969|2550->980|2645->1048|2658->1052|2689->1062|2789->1135|2802->1139|2837->1153|2951->1240|2964->1244|2994->1253|3127->1356|3161->1363|3245->1417
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|49->18|49->18|49->18|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|62->31|63->32|68->37
                  -- GENERATED --
              */
          