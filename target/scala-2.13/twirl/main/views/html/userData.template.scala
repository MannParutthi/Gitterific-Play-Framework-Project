
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
					<h4>Collaborators : """),_display_(/*20.27*/data/*20.31*/.getCollaborators()),format.raw/*20.50*/("""</h4>
					<h4>Company : """),_display_(/*21.21*/data/*21.25*/.getCompany()),format.raw/*21.38*/("""</h4>
					<h4>Name : """),_display_(/*22.18*/data/*22.22*/.getName()),format.raw/*22.32*/("""</h4>
					<h4>CreatedAt : """),_display_(/*23.23*/data/*23.27*/.getCreatedAt()),format.raw/*23.42*/("""</h4>
					<h4>DiskUsage : """),_display_(/*24.23*/data/*24.27*/.getDiskUsage()),format.raw/*24.42*/("""</h4>
					<h4>Followers : """),_display_(/*25.23*/data/*25.27*/.getFollowers()),format.raw/*25.42*/("""</h4>					
					<h4>Following : """),_display_(/*26.23*/data/*26.27*/.getFollowing()),format.raw/*26.42*/("""</h4>
					<h4>Hireable : """),_display_(/*27.22*/data/*27.26*/.isHireable()),format.raw/*27.39*/("""</h4>
					<h4>HtmlUrl : """),_display_(/*28.21*/data/*28.25*/.getHtmlUrl()),format.raw/*28.38*/("""</h4>
					<h4>Login : """),_display_(/*29.19*/data/*29.23*/.getLogin()),format.raw/*29.34*/("""</h4>
					<h4>OwnedPrivateRepos : """),_display_(/*30.31*/data/*30.35*/.getOwnedPrivateRepos()),format.raw/*30.58*/("""</h4>
					<h4>Plan : """),_display_(/*31.18*/data/*31.22*/.getPlan()),format.raw/*31.32*/("""</h4>
					<h4>PrivateGists : """),_display_(/*32.26*/data/*32.30*/.getPrivateGists()),format.raw/*32.48*/("""</h4>
					<h4>PublicGists : """),_display_(/*33.25*/data/*33.29*/.getPublicGists()),format.raw/*33.46*/("""</h4>
					<h4>PublicRepos : """),_display_(/*34.25*/data/*34.29*/.getPublicRepos()),format.raw/*34.46*/("""</h4>
					<h4>TotalPrivateRepos : """),_display_(/*35.31*/data/*35.35*/.getTotalPrivateRepos()),format.raw/*35.58*/("""</h4>
					<h4>Type : """),_display_(/*36.18*/data/*36.22*/.getType()),format.raw/*36.32*/("""</h4>
					<h4>Url : """),_display_(/*37.17*/data/*37.21*/.getUrl()),format.raw/*37.30*/("""</h4>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*42.2*/("""
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
                  HASH: ea53fcc71974d1c8894bef2dfbd0d39b36efcedd
                  MATRIX: 921->1|1041->26|1069->29|1106->58|1145->60|1175->64|1466->328|1479->332|1508->340|1560->365|1573->369|1605->380|1665->413|1678->417|1713->431|1769->460|1782->464|1818->479|1869->503|1882->507|1913->517|1973->550|1986->554|2026->573|2080->600|2093->604|2127->617|2178->641|2191->645|2222->655|2278->684|2291->688|2327->703|2383->732|2396->736|2432->751|2488->780|2501->784|2537->799|2598->833|2611->837|2647->852|2702->880|2715->884|2749->897|2803->924|2816->928|2850->941|2902->966|2915->970|2947->981|3011->1018|3024->1022|3068->1045|3119->1069|3132->1073|3163->1083|3222->1115|3235->1119|3274->1137|3332->1168|3345->1172|3383->1189|3441->1220|3454->1224|3492->1241|3556->1278|3569->1282|3613->1305|3664->1329|3677->1333|3708->1343|3758->1366|3771->1370|3801->1379|3885->1433
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|65->34|65->34|65->34|66->35|66->35|66->35|67->36|67->36|67->36|68->37|68->37|68->37|73->42
                  -- GENERATED --
              */
          