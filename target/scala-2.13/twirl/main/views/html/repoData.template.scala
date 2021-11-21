
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

object repoData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[model.RepoDataModel,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repo: model.RepoDataModel):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
	"""),format.raw/*3.2*/("""<!DOCTYPE html>
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
  				<h4>NAME : """),_display_(/*15.19*/repo/*15.23*/.getName()),format.raw/*15.33*/("""</h4>
  				<ol type="1">
  					<li><h4>ID : """),_display_(/*17.22*/repo/*17.26*/.getId()),format.raw/*17.34*/("""</h4></li>
  					<li><h4>DESCRIPTION : """),_display_(/*18.31*/repo/*18.35*/.getDescription()),format.raw/*18.52*/("""</h4></li>
  					<li><h4>LANGUAGE : """),_display_(/*19.28*/repo/*19.32*/.getLanguage()),format.raw/*19.46*/("""</h4></li>
  					<li><h4>URL : <a>"""),_display_(/*20.26*/repo/*20.30*/.getUrl()),format.raw/*20.39*/("""</a></h4></li>
  					<li><h4>CLONE URL : """),_display_(/*21.29*/repo/*21.33*/.getCloneUrl()),format.raw/*21.47*/("""</h4></li>
  					<li><h4>CREATED ON : """),_display_(/*22.30*/repo/*22.34*/.getCreatedOn()),format.raw/*22.49*/("""</h4></li>
  					<li><h4>LAST UPDATED ON : """),_display_(/*23.35*/repo/*23.39*/.getLastUpdatedOn()),format.raw/*23.58*/("""</h4></li>
  					<li><h4>GET
  					<li>
  					    <h4>CONTRIBUTORS : </h4>
  					    """),_display_(/*27.13*/for(contributor <- repo.getContributors()) yield /*27.55*/ {_display_(Seq[Any](format.raw/*27.57*/("""
  					    	"""),format.raw/*28.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>LOGIN NAME : <a href='"""),_display_(/*31.47*/routes/*31.53*/.HomeController.getUserData(contributor.getLoginName())),format.raw/*31.108*/("""'>"""),_display_(/*31.111*/contributor/*31.122*/.getLoginName()),format.raw/*31.137*/("""</a></h4></li>
  					    				<li><h4>URL : <a href=""""),_display_(/*32.40*/contributor/*32.51*/.getUrl()),format.raw/*32.60*/("""">"""),_display_(/*32.63*/contributor/*32.74*/.getUrl()),format.raw/*32.83*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*36.13*/("""
  					"""),format.raw/*37.8*/("""</li>
  					<li>
  						<h4>ISSUES : </h4>
  						<h4><a href='"""),_display_(/*40.23*/routes/*40.29*/.HomeController.getRepoIssues(repo.getOwner() , repo.getName())),format.raw/*40.92*/("""'>GET WORD LEVEL STATISTICS</a></h4>
  					    """),_display_(/*41.13*/for(issue <- repo.getIssues()) yield /*41.43*/ {_display_(Seq[Any](format.raw/*41.45*/("""
  					    	"""),format.raw/*42.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>TITLE : """),_display_(/*45.33*/issue/*45.38*/.getTitle()),format.raw/*45.49*/("""</h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*46.34*/issue/*46.39*/.getUrl()),format.raw/*46.48*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*50.13*/("""
  					"""),format.raw/*51.8*/("""</li>
  					<li>
  					   	<h4>COMMITS : </h4>
  					    """),_display_(/*54.13*/for(commit <- repo.getCommits()) yield /*54.45*/ {_display_(Seq[Any](format.raw/*54.47*/("""
  					    	"""),format.raw/*55.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>LOGIN NAME : <a href='"""),_display_(/*58.47*/routes/*58.53*/.HomeController.getUserData(commit.getLoginName())),format.raw/*58.103*/("""'>"""),_display_(/*58.106*/commit/*58.112*/.getLoginName()),format.raw/*58.127*/("""</a></h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*59.34*/commit/*59.40*/.getUrl()),format.raw/*59.49*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*63.13*/("""
  					"""),format.raw/*64.8*/("""</li>
  				</ol>
 			</div>
  		</body>
  	</html>	
""")))}),format.raw/*69.2*/("""
"""))
      }
    }
  }

  def render(repo:model.RepoDataModel): play.twirl.api.HtmlFormat.Appendable = apply(repo)

  def f:((model.RepoDataModel) => play.twirl.api.HtmlFormat.Appendable) = (repo) => apply(repo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repoData.scala.html
                  HASH: e2785225fa10a5dd61863f22de3abb63b06abaaf
                  MATRIX: 923->1|1045->28|1073->31|1110->60|1149->62|1178->65|1461->321|1474->325|1505->335|1581->384|1594->388|1623->396|1692->438|1705->442|1743->459|1809->498|1822->502|1857->516|1921->553|1934->557|1964->566|2035->610|2048->614|2083->628|2151->669|2164->673|2200->688|2273->734|2286->738|2326->757|2447->851|2505->893|2545->895|2587->909|2714->1009|2729->1015|2806->1070|2837->1073|2858->1084|2895->1099|2977->1154|2997->1165|3027->1174|3057->1177|3077->1188|3107->1197|3226->1285|3262->1294|3359->1364|3374->1370|3458->1433|3535->1483|3581->1513|3621->1515|3663->1529|3776->1615|3790->1620|3822->1631|3894->1676|3908->1681|3938->1690|4057->1778|4093->1787|4184->1851|4232->1883|4272->1885|4314->1899|4441->1999|4456->2005|4528->2055|4559->2058|4575->2064|4612->2079|4688->2128|4703->2134|4733->2143|4852->2231|4888->2240|4977->2299
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|58->27|58->27|58->27|59->28|62->31|62->31|62->31|62->31|62->31|62->31|63->32|63->32|63->32|63->32|63->32|63->32|67->36|68->37|71->40|71->40|71->40|72->41|72->41|72->41|73->42|76->45|76->45|76->45|77->46|77->46|77->46|81->50|82->51|85->54|85->54|85->54|86->55|89->58|89->58|89->58|89->58|89->58|89->58|90->59|90->59|90->59|94->63|95->64|100->69
                  -- GENERATED --
              */
          