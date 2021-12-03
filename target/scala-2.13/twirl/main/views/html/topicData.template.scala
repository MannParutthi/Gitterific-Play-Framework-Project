
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

object topicData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[model.TopicDataModel],ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(topicData: List[model.TopicDataModel])(arrayListOfResult: ArrayList[LinkedHashMap[String,List[model.SearchRepoModel]]])(topicSearchKeyword: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.150*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
		<html>
			<head lang="en">
  				<meta charset="UTF-8">
			</head>
			<body>
				<div class="container">
					"""),_display_(/*10.7*/for(mapOfSearchAndResult <- arrayListOfResult) yield /*10.53*/ {_display_(Seq[Any](format.raw/*10.55*/("""
						"""),_display_(/*11.8*/for((keyword,repoList) <- mapOfSearchAndResult) yield /*11.55*/ {_display_(Seq[Any](format.raw/*11.57*/("""
						"""),format.raw/*12.7*/("""<p>Search Term : """),_display_(/*12.25*/keyword),format.raw/*12.32*/(""" """),format.raw/*12.33*/("""</p>
							<ul>
							"""),_display_(/*14.9*/for(repo <- repoList) yield /*14.30*/ {_display_(Seq[Any](format.raw/*14.32*/("""
								"""),format.raw/*15.9*/("""<li>
									<ol type="1">
										<li><h1>User: <a href='"""),_display_(/*17.35*/routes/*17.41*/.HomeController.getUserData(repo.getUserName())),format.raw/*17.88*/("""'>"""),_display_(/*17.91*/repo/*17.95*/.getUserName()),format.raw/*17.109*/("""</a> / Repo : <a href='"""),_display_(/*17.133*/routes/*17.139*/.HomeController.getRepoData(repo.getUserName(), repo.getRepoName())),format.raw/*17.206*/("""'>"""),_display_(/*17.209*/repo/*17.213*/.getRepoName()),format.raw/*17.227*/("""</a></h1></li>
											<span>Topics : </span>
											"""),_display_(/*19.13*/for(topic <- repo.getTopics()) yield /*19.43*/ {_display_(Seq[Any](format.raw/*19.45*/("""
												"""),format.raw/*20.13*/("""<span><a href='"""),_display_(/*20.29*/routes/*20.35*/.HomeController.getTopicData(topic)),format.raw/*20.70*/("""' target="_blank">"""),_display_(/*20.89*/topic),format.raw/*20.94*/("""</a> ,</span>
											""")))}),format.raw/*21.13*/("""										
									"""),format.raw/*22.10*/("""</ol>
								</li>	
								</br>							
							""")))}),format.raw/*25.9*/("""					
							"""),format.raw/*26.8*/("""</ul>
							<hr>
						""")))}),format.raw/*28.8*/("""
					""")))}),format.raw/*29.7*/("""
 				"""),format.raw/*30.6*/("""</div>
 				<div class="container">
 					<h2><b>Latest 10 Repositories for """),_display_(/*32.42*/topicSearchKeyword),format.raw/*32.60*/("""</b></h2><br/> 
					<ol type="1">
						"""),_display_(/*34.8*/for(data <- topicData) yield /*34.30*/ {_display_(Seq[Any](format.raw/*34.32*/("""
						"""),format.raw/*35.7*/("""<li>
							<ul>
								<li><h1><b>Repository Name</b>: """),_display_(/*37.42*/data/*37.46*/.getName()),format.raw/*37.56*/("""</h1></li>
								<li><h1><b>Description</b>: """),_display_(/*38.38*/data/*38.42*/.getShort_description()),format.raw/*38.65*/("""</h1></li>
								<li><h1><b>Created By</b>: """),_display_(/*39.37*/data/*39.41*/.getCreated_by()),format.raw/*39.57*/("""</h1></li>
								<li><h1><b>Updated At</b>: """),_display_(/*40.37*/data/*40.41*/.getUpdated_at()),format.raw/*40.57*/("""</h1></li>							
							</ul>
							<br/>
						</li>
						""")))}),format.raw/*44.8*/("""
					"""),format.raw/*45.6*/("""</ol>
					<hr>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*51.2*/("""
"""))
      }
    }
  }

  def render(topicData:List[model.TopicDataModel],arrayListOfResult:ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]],topicSearchKeyword:String): play.twirl.api.HtmlFormat.Appendable = apply(topicData)(arrayListOfResult)(topicSearchKeyword)

  def f:((List[model.TopicDataModel]) => (ArrayList[LinkedHashMap[String, List[model.SearchRepoModel]]]) => (String) => play.twirl.api.HtmlFormat.Appendable) = (topicData) => (arrayListOfResult) => (topicSearchKeyword) => apply(topicData)(arrayListOfResult)(topicSearchKeyword)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/topicData.scala.html
                  HASH: eef27fee63f951f41a5700bd76a1143b34d1d08e
                  MATRIX: 1000->1|1244->149|1272->152|1309->181|1348->183|1378->187|1540->323|1602->369|1642->371|1677->380|1740->427|1780->429|1815->437|1860->455|1888->462|1917->463|1970->490|2007->511|2047->513|2084->523|2175->587|2190->593|2258->640|2288->643|2301->647|2337->661|2389->685|2405->691|2494->758|2525->761|2539->765|2575->779|2665->842|2711->872|2751->874|2793->888|2836->904|2851->910|2907->945|2953->964|2979->969|3037->996|3086->1017|3169->1070|3210->1084|3267->1111|3305->1119|3339->1126|3445->1205|3484->1223|3554->1267|3592->1289|3632->1291|3667->1299|3754->1359|3767->1363|3798->1373|3874->1422|3887->1426|3931->1449|4006->1497|4019->1501|4056->1517|4131->1565|4144->1569|4181->1585|4278->1652|4312->1659|4407->1724
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|43->12|45->14|45->14|45->14|46->15|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|52->21|53->22|56->25|57->26|59->28|60->29|61->30|63->32|63->32|65->34|65->34|65->34|66->35|68->37|68->37|68->37|69->38|69->38|69->38|70->39|70->39|70->39|71->40|71->40|71->40|75->44|76->45|82->51
                  -- GENERATED --
              */
          