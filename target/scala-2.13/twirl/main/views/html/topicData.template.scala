
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
    					<h3>Repositories filtered based on the Pushed Date and Given Topic Name</h3>
  					</div>
				</div>
				<div class="container">
					<ol type="1">
						"""),_display_(/*16.8*/for(data <- topicData) yield /*16.30*/ {_display_(Seq[Any](format.raw/*16.32*/("""
						"""),format.raw/*17.7*/("""<li>
							<h4>NAME : """),_display_(/*18.20*/data/*18.24*/.getName()),format.raw/*18.34*/("""</h4>
							<ul>
								<li><h4>ID : """),_display_(/*20.23*/data/*20.27*/.getId()),format.raw/*20.35*/("""</h4></li>
								<li><h4>LANGUAGE : """),_display_(/*21.29*/data/*21.33*/.getLanguage()),format.raw/*21.47*/("""</h4></li>
								<li><h4>CREATED ON : """),_display_(/*22.31*/data/*22.35*/.getCreatedAt()),format.raw/*22.50*/("""</h4></li>
								<li><h4>DESCRIPTION : """),_display_(/*23.32*/data/*23.36*/.getDescription()),format.raw/*23.53*/("""</h4></li>
								<li><h4>OWNER : """),_display_(/*24.26*/data/*24.30*/.getOwner()),format.raw/*24.41*/("""</h4></li>
								<li><h4>SIZE : """),_display_(/*25.25*/data/*25.29*/.getSize()),format.raw/*25.39*/("""</h4></li>
								<li><h4>PUSHED AT : """),_display_(/*26.30*/data/*26.34*/.getPushedAt()),format.raw/*26.48*/("""</h4></li>
								<li><h4>REPOSITORY URL : <a href=""""),_display_(/*27.44*/data/*27.48*/.getUrl()),format.raw/*27.57*/("""" target="_blank">Repository Link</a> </h4></li>
							</ul>
						</li>
						""")))}),format.raw/*30.8*/("""
					"""),format.raw/*31.6*/("""</ol>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*36.2*/("""
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
                  HASH: dbe3e8a06d335ed96f49601e2c1c5b262614db0e
                  MATRIX: 931->1|1065->40|1093->43|1130->72|1169->74|1199->78|1557->410|1595->432|1635->434|1670->442|1722->467|1735->471|1766->481|1835->523|1848->527|1877->535|1944->575|1957->579|1992->593|2061->635|2074->639|2110->654|2180->697|2193->701|2231->718|2295->755|2308->759|2340->770|2403->806|2416->810|2447->820|2515->861|2528->865|2563->879|2645->934|2658->938|2688->947|2802->1031|2836->1038|2920->1092
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|49->18|49->18|49->18|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|61->30|62->31|67->36
                  -- GENERATED --
              */
          