
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
  					<li>
  					    <h4>CONTRIBUTORS : </h4>
  					    """),_display_(/*26.13*/for(contributor <- repo.getContributors()) yield /*26.55*/ {_display_(Seq[Any](format.raw/*26.57*/("""
  					    	"""),format.raw/*27.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>LOGIN NAME : <a href='"""),_display_(/*30.47*/routes/*30.53*/.HomeController.getUserData(contributor.getLoginName())),format.raw/*30.108*/("""'>"""),_display_(/*30.111*/contributor/*30.122*/.getLoginName()),format.raw/*30.137*/("""</a></h4></li>
  					    				<li><h4>URL : <a href=""""),_display_(/*31.40*/contributor/*31.51*/.getUrl()),format.raw/*31.60*/("""">"""),_display_(/*31.63*/contributor/*31.74*/.getUrl()),format.raw/*31.83*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*35.13*/("""
  					"""),format.raw/*36.8*/("""</li>
  					<li>
  						<h4>ISSUES : </h4>
  					    """),_display_(/*39.13*/for(issue <- repo.getIssues()) yield /*39.43*/ {_display_(Seq[Any](format.raw/*39.45*/("""
  					    	"""),format.raw/*40.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>TITLE : """),_display_(/*43.33*/issue/*43.38*/.getTitle()),format.raw/*43.49*/("""</h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*44.34*/issue/*44.39*/.getUrl()),format.raw/*44.48*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*48.13*/("""
  					"""),format.raw/*49.8*/("""</li>
  					<li>
  					   	<h4>COMMITS : </h4>
  					    """),_display_(/*52.13*/for(commit <- repo.getCommits()) yield /*52.45*/ {_display_(Seq[Any](format.raw/*52.47*/("""
  					    	"""),format.raw/*53.13*/("""<ul>
  					    		<li>
  					    			<ol type="A">
  					    				<li><h4>LOGIN NAME : <a href='"""),_display_(/*56.47*/routes/*56.53*/.HomeController.getUserData(commit.getLoginName())),format.raw/*56.103*/("""'>"""),_display_(/*56.106*/commit/*56.112*/.getLoginName()),format.raw/*56.127*/("""</a></h4></li>
  					    				<li><h4>URL : <a>"""),_display_(/*57.34*/commit/*57.40*/.getUrl()),format.raw/*57.49*/("""</a></h4></li>
  					    			</ol>
  					    		</li>
  					    	</ul>
  					    """)))}),format.raw/*61.13*/("""
  					"""),format.raw/*62.8*/("""</li>
  				</ol>
 			</div>
  		</body>
  	</html>	
""")))}),format.raw/*67.2*/("""
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
                  HASH: 2f613a0beb971c5d93be1466a6fc5df801cebe76
                  MATRIX: 923->1|1045->28|1073->31|1110->60|1149->62|1178->65|1461->321|1474->325|1505->335|1581->384|1594->388|1623->396|1692->438|1705->442|1743->459|1809->498|1822->502|1857->516|1921->553|1934->557|1964->566|2035->610|2048->614|2083->628|2151->669|2164->673|2200->688|2273->734|2286->738|2326->757|2427->831|2485->873|2525->875|2567->889|2694->989|2709->995|2786->1050|2817->1053|2838->1064|2875->1079|2957->1134|2977->1145|3007->1154|3037->1157|3057->1168|3087->1177|3206->1265|3242->1274|3329->1334|3375->1364|3415->1366|3457->1380|3570->1466|3584->1471|3616->1482|3688->1527|3702->1532|3732->1541|3851->1629|3887->1638|3978->1702|4026->1734|4066->1736|4108->1750|4235->1850|4250->1856|4322->1906|4353->1909|4369->1915|4406->1930|4482->1979|4497->1985|4527->1994|4646->2082|4682->2091|4771->2150
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|57->26|57->26|57->26|58->27|61->30|61->30|61->30|61->30|61->30|61->30|62->31|62->31|62->31|62->31|62->31|62->31|66->35|67->36|70->39|70->39|70->39|71->40|74->43|74->43|74->43|75->44|75->44|75->44|79->48|80->49|83->52|83->52|83->52|84->53|87->56|87->56|87->56|87->56|87->56|87->56|88->57|88->57|88->57|92->61|93->62|98->67
                  -- GENERATED --
              */
          