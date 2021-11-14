
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
					<p>AvatarUrl</p>
					<h3>"""),_display_(/*20.11*/data/*20.15*/.getAvatarUrl()),format.raw/*20.30*/("""</h3>
					<p>Blog</p>
					<h3>"""),_display_(/*22.11*/data/*22.15*/.getBlog()),format.raw/*22.25*/("""</h3>
					<p>Email</p>
					<h3>"""),_display_(/*24.11*/data/*24.15*/.getEmail()),format.raw/*24.26*/("""</h3>
					<p>AvatarUrl</p>
					<h3>"""),_display_(/*26.11*/data/*26.15*/.getAvatarUrl()),format.raw/*26.30*/("""</h3>
					<p>Blog</p>
					<h3>"""),_display_(/*28.11*/data/*28.15*/.getBlog()),format.raw/*28.25*/("""</h3>
 				</div>
  			</body>
  		</html>
  		
""")))}),format.raw/*33.2*/("""
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
                  HASH: 47d7c19c3799e5db1af677b106ff102e4174c65d
                  MATRIX: 921->1|1041->26|1069->29|1106->58|1145->60|1175->64|1477->339|1490->343|1519->351|1582->387|1595->391|1627->402|1694->442|1707->446|1743->461|1805->496|1818->500|1849->510|1912->546|1925->550|1957->561|2024->601|2037->605|2073->620|2135->655|2148->659|2179->669|2263->723
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|47->16|47->16|47->16|49->18|49->18|49->18|51->20|51->20|51->20|53->22|53->22|53->22|55->24|55->24|55->24|57->26|57->26|57->26|59->28|59->28|59->28|64->33
                  -- GENERATED --
              */
          