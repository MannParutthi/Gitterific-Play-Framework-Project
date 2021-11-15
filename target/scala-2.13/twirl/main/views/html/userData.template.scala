
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
					<p>Id</p>
					<h3>"""),_display_(/*16.11*/data/*16.15*/.getId()),format.raw/*16.23*/("""</h3>
					<p>Email</p>
					<h3>"""),_display_(/*18.11*/data/*18.15*/.getEmail()),format.raw/*18.26*/("""</h3>					
					<p>Location</p>
					<h3>"""),_display_(/*20.11*/data/*20.15*/.getLocation()),format.raw/*20.29*/("""</h3>
					<p>AvatarUrl</p>
					<h3>"""),_display_(/*22.11*/data/*22.15*/.getAvatarUrl()),format.raw/*22.30*/("""</h3>
					<p>Blog</p>
					<h3>"""),_display_(/*24.11*/data/*24.15*/.getBlog()),format.raw/*24.25*/("""</h3>
					<p>Collaborators</p>
					<h3>"""),_display_(/*26.11*/data/*26.15*/.getCollaborators()),format.raw/*26.34*/("""</h3>
					<p>Company</p>
					<h3>"""),_display_(/*28.11*/data/*28.15*/.getCompany()),format.raw/*28.28*/("""</h3>
					<p>Name</p>
					<h3>"""),_display_(/*30.11*/data/*30.15*/.getName()),format.raw/*30.25*/("""</h3>
					<p>CreatedAt</p>
					<h3>"""),_display_(/*32.11*/data/*32.15*/.getCreatedAt()),format.raw/*32.30*/("""</h3>
					<p>DiskUsage</p>
					<h3>"""),_display_(/*34.11*/data/*34.15*/.getDiskUsage()),format.raw/*34.30*/("""</h3>
					<p>Followers</p>
					<h3>"""),_display_(/*36.11*/data/*36.15*/.getFollowers()),format.raw/*36.30*/("""</h3>
					<p>Following</p>
					<h3>"""),_display_(/*38.11*/data/*38.15*/.getFollowing()),format.raw/*38.30*/("""</h3>
					<p>GravatarId</p>
					<h3>"""),_display_(/*40.11*/data/*40.15*/.getGravatarId()),format.raw/*40.31*/("""</h3>
					<p>Hireable</p>
					<h3>"""),_display_(/*42.11*/data/*42.15*/.isHireable()),format.raw/*42.28*/("""</h3>
					<p>HtmlUrl</p>
					<h3>"""),_display_(/*44.11*/data/*44.15*/.getHtmlUrl()),format.raw/*44.28*/("""</h3>
					<p>Login</p>
					<h3>"""),_display_(/*46.11*/data/*46.15*/.getLogin()),format.raw/*46.26*/("""</h3>
					<p>OwnedPrivateRepos</p>
					<h3>"""),_display_(/*48.11*/data/*48.15*/.getOwnedPrivateRepos()),format.raw/*48.38*/("""</h3>
					<p>Plan</p>
					<h3>"""),_display_(/*50.11*/data/*50.15*/.getPlan()),format.raw/*50.25*/("""</h3>
					<p>PrivateGists</p>
					<h3>"""),_display_(/*52.11*/data/*52.15*/.getPrivateGists()),format.raw/*52.33*/("""</h3>
					<p>PublicGists</p>
					<h3>"""),_display_(/*54.11*/data/*54.15*/.getPublicGists()),format.raw/*54.32*/("""</h3>
					<p>PublicRepos</p>
					<h3>"""),_display_(/*56.11*/data/*56.15*/.getPublicRepos()),format.raw/*56.32*/("""</h3>
					<p>TotalPrivateRepos</p>
					<h3>"""),_display_(/*58.11*/data/*58.15*/.getTotalPrivateRepos()),format.raw/*58.38*/("""</h3>
					<p>Type</p>
					<h3>"""),_display_(/*60.11*/data/*60.15*/.getType()),format.raw/*60.25*/("""</h3>
					<p>Url</p>
					<h3>"""),_display_(/*62.11*/data/*62.15*/.getUrl()),format.raw/*62.24*/("""</h3>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*67.2*/("""
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
                  HASH: e156c22320be64f7911f4080c73cd2ac6d137f64
                  MATRIX: 921->1|1041->26|1069->29|1106->58|1145->60|1175->64|1477->339|1490->343|1519->351|1582->387|1595->391|1627->402|1698->446|1711->450|1746->464|1813->504|1826->508|1862->523|1924->558|1937->562|1968->572|2039->616|2052->620|2092->639|2157->677|2170->681|2204->694|2266->729|2279->733|2310->743|2377->783|2390->787|2426->802|2493->842|2506->846|2542->861|2609->901|2622->905|2658->920|2725->960|2738->964|2774->979|2842->1020|2855->1024|2892->1040|2958->1079|2971->1083|3005->1096|3070->1134|3083->1138|3117->1151|3180->1187|3193->1191|3225->1202|3300->1250|3313->1254|3357->1277|3419->1312|3432->1316|3463->1326|3533->1369|3546->1373|3585->1391|3654->1433|3667->1437|3705->1454|3774->1496|3787->1500|3825->1517|3900->1565|3913->1569|3957->1592|4019->1627|4032->1631|4063->1641|4124->1675|4137->1679|4167->1688|4251->1742
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|49->18|49->18|49->18|51->20|51->20|51->20|53->22|53->22|53->22|55->24|55->24|55->24|57->26|57->26|57->26|59->28|59->28|59->28|61->30|61->30|61->30|63->32|63->32|63->32|65->34|65->34|65->34|67->36|67->36|67->36|69->38|69->38|69->38|71->40|71->40|71->40|73->42|73->42|73->42|75->44|75->44|75->44|77->46|77->46|77->46|79->48|79->48|79->48|81->50|81->50|81->50|83->52|83->52|83->52|85->54|85->54|85->54|87->56|87->56|87->56|89->58|89->58|89->58|91->60|91->60|91->60|93->62|93->62|93->62|98->67
                  -- GENERATED --
              */
          