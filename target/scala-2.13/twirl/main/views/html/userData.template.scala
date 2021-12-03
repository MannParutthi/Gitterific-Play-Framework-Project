
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

object userData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[model.UserDetails,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data: model.UserDetails):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.27*/("""
"""),_display_(/*2.2*/main("Welcome to Gitterific")/*2.31*/ {_display_(Seq[Any](format.raw/*2.33*/("""
		"""),format.raw/*3.3*/("""<!DOCTYPE html>
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
					<h4>ID : """),_display_(/*15.16*/data/*15.20*/.getId()),format.raw/*15.28*/("""</h4>
					<h4>Email : """),_display_(/*16.19*/data/*16.23*/.getEmail()),format.raw/*16.34*/("""</h4>					
					<h4>Location : """),_display_(/*17.22*/data/*17.26*/.getLocation()),format.raw/*17.40*/("""</h4>
					<h4>AvatarUrl : """),_display_(/*18.23*/data/*18.27*/.getAvatarUrl()),format.raw/*18.42*/("""</h4>
					<h4>Blog : """),_display_(/*19.18*/data/*19.22*/.getBlog()),format.raw/*19.32*/("""</h4>
					<h4>Company : """),_display_(/*20.21*/data/*20.25*/.getCompany()),format.raw/*20.38*/("""</h4>
					<h4>Name : """),_display_(/*21.18*/data/*21.22*/.getName()),format.raw/*21.32*/("""</h4>
					<h4>CreatedAt : """),_display_(/*22.23*/data/*22.27*/.getCreatedAt()),format.raw/*22.42*/("""</h4>
					<h4>Followers : """),_display_(/*23.23*/data/*23.27*/.getFollowers()),format.raw/*23.42*/("""</h4>					
					<h4>Following : """),_display_(/*24.23*/data/*24.27*/.getFollowing()),format.raw/*24.42*/("""</h4>
					<h4>Hireable : """),_display_(/*25.22*/data/*25.26*/.isHireable()),format.raw/*25.39*/("""</h4>
					<h4>HtmlUrl : """),_display_(/*26.21*/data/*26.25*/.getHtmlUrl()),format.raw/*26.38*/("""</h4>
					<h4>Login : """),_display_(/*27.19*/data/*27.23*/.getLogin()),format.raw/*27.34*/("""</h4>
					<h4>OwnedPrivateRepos : """),_display_(/*28.31*/data/*28.35*/.getOwnedPrivateRepos()),format.raw/*28.58*/("""</h4>
					<h4>PrivateGists : """),_display_(/*29.26*/data/*29.30*/.getPrivateGists()),format.raw/*29.48*/("""</h4>
					<h4>PublicGists : """),_display_(/*30.25*/data/*30.29*/.getPublicGists()),format.raw/*30.46*/("""</h4>
					<h4>PublicRepos : """),_display_(/*31.25*/data/*31.29*/.getPublicRepos()),format.raw/*31.46*/("""</h4>
					<h4>Type : """),_display_(/*32.18*/data/*32.22*/.getType()),format.raw/*32.32*/("""</h4>
					<h4>Url : """),_display_(/*33.17*/data/*33.21*/.getUrl()),format.raw/*33.30*/("""</h4>

  					    		"""),_display_(/*35.15*/for(repo <- data.getRepoName()) yield /*35.46*/ {_display_(Seq[Any](format.raw/*35.48*/("""
  					    			"""),format.raw/*36.15*/("""<ol type="A">
  					    				<li>				    					
  					    						<li><h4>Repo Name : <a href='"""),_display_(/*38.48*/routes/*38.54*/.HomeController.getRepoData(data.getLogin(), repo)),format.raw/*38.104*/("""'>"""),_display_(/*38.107*/repo),format.raw/*38.111*/("""</a></h4></li>
  					    				</li>
  					    			</ol>
  					    		""")))}),format.raw/*41.15*/("""
 				"""),format.raw/*42.6*/("""</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*46.2*/("""
"""))
      }
    }
  }

  def render(data:model.UserDetails): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((model.UserDetails) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/userData.scala.html
                  HASH: be4a44247b3ae377f76751f7915369e4e518f551
                  MATRIX: 921->1|1041->26|1069->29|1106->58|1145->60|1175->64|1466->328|1479->332|1508->340|1560->365|1573->369|1605->380|1665->413|1678->417|1713->431|1769->460|1782->464|1818->479|1869->503|1882->507|1913->517|1967->544|1980->548|2014->561|2065->585|2078->589|2109->599|2165->628|2178->632|2214->647|2270->676|2283->680|2319->695|2380->729|2393->733|2429->748|2484->776|2497->780|2531->793|2585->820|2598->824|2632->837|2684->862|2697->866|2729->877|2793->914|2806->918|2850->941|2909->973|2922->977|2961->995|3019->1026|3032->1030|3070->1047|3128->1078|3141->1082|3179->1099|3230->1123|3243->1127|3274->1137|3324->1160|3337->1164|3367->1173|3417->1196|3464->1227|3504->1229|3548->1245|3671->1341|3686->1347|3758->1397|3789->1400|3815->1404|3919->1477|3953->1484|4025->1526
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|66->35|66->35|66->35|67->36|69->38|69->38|69->38|69->38|69->38|72->41|73->42|77->46
                  -- GENERATED --
              */
          