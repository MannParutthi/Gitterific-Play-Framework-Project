
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

object repoData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[model.RepoDataModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repoList: List[model.RepoDataModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.39*/("""
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
				<ul>
				"""),_display_(/*16.6*/for(repo <- repoList) yield /*16.27*/ {_display_(Seq[Any](format.raw/*16.29*/("""
  					"""),format.raw/*17.8*/("""<li>
  						<h4>NAME : """),_display_(/*18.21*/repo/*18.25*/.getName()),format.raw/*18.35*/("""</h4>
  						<ol type="1">
  							<li><h4>ID : """),_display_(/*20.24*/repo/*20.28*/.getId()),format.raw/*20.36*/("""</h4></li>
  							<li><h4>DESCRIPTION : """),_display_(/*21.33*/repo/*21.37*/.getDescription()),format.raw/*21.54*/("""</h4></li>
  							<li><h4>LANGUAGE : """),_display_(/*22.30*/repo/*22.34*/.getLanguage()),format.raw/*22.48*/("""</h4></li>
  					    	<li><h4>URL : <a>"""),_display_(/*23.31*/repo/*23.35*/.getUrl()),format.raw/*23.44*/("""</a></h4></li>
  					    	<li><h4>CLONE URL : """),_display_(/*24.34*/repo/*24.38*/.getCloneUrl()),format.raw/*24.52*/("""</h4></li>
  					    	<li><h4>CREATED ON : """),_display_(/*25.35*/repo/*25.39*/.getCreatedOn()),format.raw/*25.54*/("""</h4></li>
  					    	<li><h4>LAST UPDATED ON : """),_display_(/*26.40*/repo/*26.44*/.getLastUpdatedOn()),format.raw/*26.63*/("""</h4></li>
  					    	<li>
  					    		<h4>CONTRIBUTORS : </h4>
  					    		"""),_display_(/*29.15*/for(contributor <- repo.getContributors()) yield /*29.57*/ {_display_(Seq[Any](format.raw/*29.59*/("""
  					    			"""),format.raw/*30.15*/("""<ul>
  					    				<li>
  					    					<ol type="A">
  					    						<li><h4>LOGIN NAME : """),_display_(/*33.40*/contributor/*33.51*/.getLoginName()),format.raw/*33.66*/("""</h4></li>
  					    						<li><h4>URL : <a>"""),_display_(/*34.36*/contributor/*34.47*/.getUrl()),format.raw/*34.56*/("""</a></h4></li>
  					    					</ol>
  					    				</li>
  					    			</ul>
  					    		""")))}),format.raw/*38.15*/("""
  					    	"""),format.raw/*39.13*/("""</li>
  					    	<li>
  					    		<h4>ISSUES : </h4>
  					    		"""),_display_(/*42.15*/for(issue <- repo.getIssues()) yield /*42.45*/ {_display_(Seq[Any](format.raw/*42.47*/("""
  					    			"""),format.raw/*43.15*/("""<ul>
  					    				<li>
  					    					<ol type="A">
  					    						<li><h4>TITLE : """),_display_(/*46.35*/issue/*46.40*/.getTitle()),format.raw/*46.51*/("""</h4></li>
  					    						<li><h4>URL : <a>"""),_display_(/*47.36*/issue/*47.41*/.getUrl()),format.raw/*47.50*/("""</a></h4></li>
  					    					</ol>
  					    				</li>
  					    			</ul>
  					    		""")))}),format.raw/*51.15*/("""
  					    	"""),format.raw/*52.13*/("""</li>
  					    	<li>
  					    		<h4>COMMITS : </h4>
  					    		"""),_display_(/*55.15*/for(commit <- repo.getCommits()) yield /*55.47*/ {_display_(Seq[Any](format.raw/*55.49*/("""
  					    			"""),format.raw/*56.15*/("""<ul>
  					    				<li>
  					    					<ol type="A">
  					    						<li><h4>LOGIN NAME : """),_display_(/*59.40*/commit/*59.46*/.getLoginName()),format.raw/*59.61*/("""</h4></li>
  					    						<li><h4>URL : <a>"""),_display_(/*60.36*/commit/*60.42*/.getUrl()),format.raw/*60.51*/("""</a></h4></li>
  					    					</ol>
  					    				</li>
  					    			</ul>
  					    		""")))}),format.raw/*64.15*/("""
  					    	"""),format.raw/*65.13*/("""</li>
  					    </ol>
  					</li>
				""")))}),format.raw/*68.6*/("""
				"""),format.raw/*69.5*/("""</ul>
 			</div>
  		</body>
  	</html>	
""")))}),format.raw/*73.2*/("""
"""))
      }
    }
  }

  def render(repoList:List[model.RepoDataModel]): play.twirl.api.HtmlFormat.Appendable = apply(repoList)

  def f:((List[model.RepoDataModel]) => play.twirl.api.HtmlFormat.Appendable) = (repoList) => apply(repoList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repoData.scala.html
                  HASH: d41ef503b410c9cdc1e7d00b0fa1c7e14176995b
                  MATRIX: 929->1|1061->38|1089->41|1126->70|1165->72|1194->75|1473->328|1510->349|1550->351|1586->360|1639->386|1652->390|1683->400|1763->453|1776->457|1805->465|1876->509|1889->513|1927->530|1995->571|2008->575|2043->589|2112->631|2125->635|2155->644|2231->693|2244->697|2279->711|2352->757|2365->761|2401->776|2479->827|2492->831|2532->850|2642->933|2700->975|2740->977|2784->993|2908->1090|2928->1101|2964->1116|3038->1163|3058->1174|3088->1183|3215->1279|3257->1293|3356->1365|3402->1395|3442->1397|3486->1413|3605->1505|3619->1510|3651->1521|3725->1568|3739->1573|3769->1582|3896->1678|3938->1692|4038->1765|4086->1797|4126->1799|4170->1815|4294->1912|4309->1918|4345->1933|4419->1980|4434->1986|4464->1995|4591->2091|4633->2105|4707->2149|4740->2155|4816->2201
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|48->17|49->18|49->18|49->18|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|60->29|60->29|60->29|61->30|64->33|64->33|64->33|65->34|65->34|65->34|69->38|70->39|73->42|73->42|73->42|74->43|77->46|77->46|77->46|78->47|78->47|78->47|82->51|83->52|86->55|86->55|86->55|87->56|90->59|90->59|90->59|91->60|91->60|91->60|95->64|96->65|99->68|100->69|104->73
                  -- GENERATED --
              */
          