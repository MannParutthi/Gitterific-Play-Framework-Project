
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
  					    				<li><h4>NO OF CONTRIBUTIONS : """),_display_(/*33.47*/contributor/*33.58*/.getNoOfContributions()),format.raw/*33.81*/("""</h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*37.13*/("""
  					"""),format.raw/*38.8*/("""</li>
  					<li>
  						<h4>ISSUES : </h4>
  						<h4><a href='"""),_display_(/*41.23*/routes/*41.29*/.HomeController.getRepoIssues(repo.getOwner() , repo.getName())),format.raw/*41.92*/("""'>GET WORD LEVEL STATISTICS</a></h4>
  					    """),_display_(/*42.13*/for(issue <- repo.getIssues()) yield /*42.43*/ {_display_(Seq[Any](format.raw/*42.45*/("""
  					    	"""),format.raw/*43.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>TITLE : """),_display_(/*46.33*/issue/*46.38*/.getTitle()),format.raw/*46.49*/("""</h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*47.34*/issue/*47.39*/.getUrl()),format.raw/*47.48*/("""</a></h4></li>
  					    				<li><h4>STATE : """),_display_(/*48.33*/issue/*48.38*/.getState()),format.raw/*48.49*/("""</h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*52.13*/("""
  					"""),format.raw/*53.8*/("""</li>
  					<li>
  					   	<h4>COMMITS : </h4>
  					    """),_display_(/*56.13*/for(commit <- repo.getCommits()) yield /*56.45*/ {_display_(Seq[Any](format.raw/*56.47*/("""
  					    	"""),format.raw/*57.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>NAME : """),_display_(/*60.32*/commit/*60.38*/.getLoginName()),format.raw/*60.53*/("""</h4></li>
  					    				<li><h4>COMMIT MESSAGE : """),_display_(/*61.42*/commit/*61.48*/.getMessage()),format.raw/*61.61*/("""</h4></li>
  					    				<li><h4>EMAIL : """),_display_(/*62.33*/commit/*62.39*/.getEmail()),format.raw/*62.50*/("""</h4></li>
  					    				<li><h4>DATE : """),_display_(/*63.32*/commit/*63.38*/.getDate()),format.raw/*63.48*/("""</h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*64.34*/commit/*64.40*/.getUrl()),format.raw/*64.49*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*68.13*/("""
  					"""),format.raw/*69.8*/("""</li>
  				</ol>
 			</div>
  		</body>
  	</html>	
""")))}),format.raw/*74.2*/("""
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
                  HASH: c7726c881b93de6a1f2c611291bc5ae0bad3f5a3
                  MATRIX: 923->1|1045->28|1073->31|1110->60|1149->62|1178->65|1461->321|1474->325|1505->335|1581->384|1594->388|1623->396|1692->438|1705->442|1743->459|1809->498|1822->502|1857->516|1921->553|1934->557|1964->566|2035->610|2048->614|2083->628|2151->669|2164->673|2200->688|2273->734|2286->738|2326->757|2447->851|2505->893|2545->895|2587->909|2714->1009|2729->1015|2806->1070|2837->1073|2858->1084|2895->1099|2977->1154|2997->1165|3027->1174|3057->1177|3077->1188|3107->1197|3196->1259|3216->1270|3260->1293|3375->1377|3411->1386|3508->1456|3523->1462|3607->1525|3684->1575|3730->1605|3770->1607|3812->1621|3925->1707|3939->1712|3971->1723|4043->1768|4057->1773|4087->1782|4162->1830|4176->1835|4208->1846|4323->1930|4359->1939|4450->2003|4498->2035|4538->2037|4580->2051|4692->2136|4707->2142|4743->2157|4823->2210|4838->2216|4872->2229|4943->2273|4958->2279|4990->2290|5060->2333|5075->2339|5106->2349|5178->2394|5193->2400|5223->2409|5342->2497|5378->2506|5467->2565
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|58->27|58->27|58->27|59->28|62->31|62->31|62->31|62->31|62->31|62->31|63->32|63->32|63->32|63->32|63->32|63->32|64->33|64->33|64->33|68->37|69->38|72->41|72->41|72->41|73->42|73->42|73->42|74->43|77->46|77->46|77->46|78->47|78->47|78->47|79->48|79->48|79->48|83->52|84->53|87->56|87->56|87->56|88->57|91->60|91->60|91->60|92->61|92->61|92->61|93->62|93->62|93->62|94->63|94->63|94->63|95->64|95->64|95->64|99->68|100->69|105->74
                  -- GENERATED --
              */
          