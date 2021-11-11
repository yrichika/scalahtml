package scalahtml

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.collection.immutable

object Tags {

  val attributes = immutable.Map
  val attrs = immutable.Map

  def commentOut(content: String) = s"<!-- $content -->"

  /**
   * This is just an alias for `doctype(Map("html" -> ""))`
   * This will produce `<!DOCTYPE html>`
   */
  def doctypeHtml(attributes: Map[String, String] = Map()) = {
    val attrs = Map("html" -> "") ++ attributes
    doctype(attrs)
  }

  def doctype(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("!DOCTYPE", attributes)

  // --- html5 tags ---

  def a(attributes: Map[String, String] = Map())(content: String) =
    generateTag("a", attributes)(content)

  def abbr(attributes: Map[String, String] = Map())(content: String) =
    generateTag("abbr", attributes)(content)

  def address(attributes: Map[String, String] = Map())(content: String) =
    generateTag("address", attributes)(content)

  def area(attributes: Map[String, String] = Map())(content: String) =
    generateTag("area", attributes)(content)

  def article(attributes: Map[String, String] = Map())(content: String) =
    generateTag("article", attributes)(content)

  def aside(attributes: Map[String, String] = Map())(content: String) =
    generateTag("aside", attributes)(content)

  def audio(attributes: Map[String, String] = Map())(content: String) =
    generateTag("audio", attributes)(content)

  def b(attributes: Map[String, String] = Map())(content: String) =
    generateTag("b", attributes)(content)

  def base(attributes: Map[String, String] = Map())(content: String) =
    generateTag("base", attributes)(content)

  def bdi(attributes: Map[String, String] = Map())(content: String) =
    generateTag("bdi", attributes)(content)

  def bdo(attributes: Map[String, String] = Map())(content: String) =
    generateTag("bdo", attributes)(content)

  def blockquote(attributes: Map[String, String] = Map())(content: String) =
    generateTag("blockquote", attributes)(content)

  def body(attributes: Map[String, String] = Map())(content: String) =
    generateTag("body", attributes)(content)

  def br(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("br", attributes)

  def button(attributes: Map[String, String] = Map())(content: String) =
    generateTag("button", attributes)(content)

  def canvas(attributes: Map[String, String] = Map())(content: String) =
    generateTag("canvas", attributes)(content)

  def caption(attributes: Map[String, String] = Map())(content: String) =
    generateTag("caption", attributes)(content)

  def cite(attributes: Map[String, String] = Map())(content: String) =
    generateTag("cite", attributes)(content)

  def code(attributes: Map[String, String] = Map())(content: String) =
    generateTag("code", attributes)(content)

  def col(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("col", attributes)

  def colgroup(attributes: Map[String, String] = Map())(content: String) =
    generateTag("colgroup", attributes)(content)

  def data(attributes: Map[String, String] = Map())(content: String) =
    generateTag("data", attributes)(content)

  def datalist(attributes: Map[String, String] = Map())(content: String) =
    generateTag("datalist", attributes)(content)

  def dd(attributes: Map[String, String] = Map())(content: String) =
    generateTag("dd", attributes)(content)

  def del(attributes: Map[String, String] = Map())(content: String) =
    generateTag("del", attributes)(content)

  def details(attributes: Map[String, String] = Map())(content: String) =
    generateTag("details", attributes)(content)

  def dfn(attributes: Map[String, String] = Map())(content: String) =
    generateTag("dfn", attributes)(content)

  def dialog(attributes: Map[String, String] = Map())(content: String) =
    generateTag("dialog", attributes)(content)

  def div(attributes: Map[String, String] = Map())(content: String) =
    generateTag("div", attributes)(content)

  def dl(attributes: Map[String, String] = Map())(content: String) =
    generateTag("dl", attributes)(content)

  def dt(attributes: Map[String, String] = Map())(content: String) =
    generateTag("dt", attributes)(content)

  def em(attributes: Map[String, String] = Map())(content: String) =
    generateTag("em", attributes)(content)

  def embed(attributes: Map[String, String] = Map())(content: String) =
    generateTag("embed", attributes)(content)

  def fieldset(attributes: Map[String, String] = Map())(content: String) =
    generateTag("fieldset", attributes)(content)

  def figcaption(attributes: Map[String, String] = Map())(content: String) =
    generateTag("figcaption", attributes)(content)

  def figure(attributes: Map[String, String] = Map())(content: String) =
    generateTag("figure", attributes)(content)

  def footer(attributes: Map[String, String] = Map())(content: String) =
    generateTag("footer", attributes)(content)

  def form(attributes: Map[String, String] = Map())(content: String) =
    generateTag("form", attributes)(content)

  def h1(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h1", attributes)(content)

  def h2(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h2", attributes)(content)

  def h3(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h3", attributes)(content)

  def h4(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h4", attributes)(content)

  def h5(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h5", attributes)(content)

  def h6(attributes: Map[String, String] = Map())(content: String) =
    generateTag("h6", attributes)(content)

  def head(attributes: Map[String, String] = Map())(content: String) =
    generateTag("head", attributes)(content)

  def header(attributes: Map[String, String] = Map())(content: String) =
    generateTag("header", attributes)(content)

  def hr(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("hr", attributes)

  def html(attributes: Map[String, String] = Map())(content: String) =
    generateTag("html", attributes)(content)

  def html5(attributes: Map[String, String] = Map())(content: String) =
    doctypeHtml() + html(attributes)(content)

  def i(attributes: Map[String, String] = Map())(content: String) =
    generateTag("i", attributes)(content)

  def iframe(attributes: Map[String, String] = Map())(content: String) =
    generateTag("iframe", attributes)(content)

  def img(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("img", attributes)

  def input(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("input", attributes)

  def ins(attributes: Map[String, String] = Map())(content: String) =
    generateTag("ins", attributes)(content)

  def kbd(attributes: Map[String, String] = Map())(content: String) =
    generateTag("kbd", attributes)(content)

  def label(attributes: Map[String, String] = Map())(content: String) =
    generateTag("label", attributes)(content)

  def legend(attributes: Map[String, String] = Map())(content: String) =
    generateTag("legend", attributes)(content)

  def li(attributes: Map[String, String] = Map())(content: String) =
    generateTag("li", attributes)(content)

  def link(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("link", attributes)

  def main(attributes: Map[String, String] = Map())(content: String) =
    generateTag("main", attributes)(content)

  /**
   * This is just an alias for this object's `main` method.
   * `main` sometimes conflicts with Scala's main method.
   * You can specify this main method by `Tags.main`,
   * but if you want to write shorter, use this method.
   */
  def main_(attributes: Map[String, String] = Map())(content: String) =
    this.main(attributes)(content)


  def map(attributes: Map[String, String] = Map())(content: String) =
    generateTag("map", attributes)(content)

  def mark(attributes: Map[String, String] = Map())(content: String) =
    generateTag("mark", attributes)(content)

  def meta(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("meta", attributes)

  def meter(attributes: Map[String, String] = Map())(content: String) =
    generateTag("meter", attributes)(content)

  def nav(attributes: Map[String, String] = Map())(content: String) =
    generateTag("nav", attributes)(content)

  def noscript(attributes: Map[String, String] = Map())(content: String) =
    generateTag("noscript", attributes)(content)

  /**
   * `object` is scala keyword. That's why this has underbar at the end.
   * Please don't forget to add `_` when you use this!
   */
  def object_(attributes: Map[String, String] = Map())(content: String) =
    generateTag("object", attributes)(content)

  def ol(attributes: Map[String, String] = Map())(content: String) =
    generateTag("ol", attributes)(content)

  def optgroup(attributes: Map[String, String] = Map())(content: String) =
    generateTag("optgroup", attributes)(content)

  def option(attributes: Map[String, String] = Map())(content: String) =
    generateTag("option", attributes)(content)

  def output(attributes: Map[String, String] = Map())(content: String) =
    generateTag("output", attributes)(content)

  def p(attributes: Map[String, String] = Map())(content: String) =
    generateTag("p", attributes)(content)

  def param(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("param", attributes)

  def picture(attributes: Map[String, String] = Map())(content: String) =
    generateTag("picture", attributes)(content)

  def pre(attributes: Map[String, String] = Map())(content: String) =
    generateTag("pre", attributes)(content)

  def progress(attributes: Map[String, String] = Map())(content: String) =
    generateTag("progress", attributes)(content)

  def q(attributes: Map[String, String] = Map())(content: String) =
    generateTag("q", attributes)(content)

  def rp(attributes: Map[String, String] = Map())(content: String) =
    generateTag("rp", attributes)(content)

  def rt(attributes: Map[String, String] = Map())(content: String) =
    generateTag("rt", attributes)(content)

  def ruby(attributes: Map[String, String] = Map())(content: String) =
    generateTag("ruby", attributes)(content)

  def s(attributes: Map[String, String] = Map())(content: String) =
    generateTag("s", attributes)(content)

  def samp(attributes: Map[String, String] = Map())(content: String) =
    generateTag("samp", attributes)(content)

  def script(attributes: Map[String, String] = Map())(content: String) =
    generateTag("script", attributes)(content)

  def section(attributes: Map[String, String] = Map())(content: String) =
    generateTag("section", attributes)(content)

  def select(attributes: Map[String, String] = Map())(content: String) =
    generateTag("select", attributes)(content)

  def small(attributes: Map[String, String] = Map())(content: String) =
    generateTag("small", attributes)(content)

  def source(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("source", attributes)

  def span(attributes: Map[String, String] = Map())(content: String) =
    generateTag("span", attributes)(content)

  def strong(attributes: Map[String, String] = Map())(content: String) =
    generateTag("strong", attributes)(content)

  def style(attributes: Map[String, String] = Map())(content: String) =
    generateTag("style", attributes)(content)

  def sub(attributes: Map[String, String] = Map())(content: String) =
    generateTag("sub", attributes)(content)

  def summary(attributes: Map[String, String] = Map())(content: String) =
    generateTag("summary", attributes)(content)

  def sup(attributes: Map[String, String] = Map())(content: String) =
    generateTag("sup", attributes)(content)

  def svg(attributes: Map[String, String] = Map())(content: String) =
    generateTag("svg", attributes)(content)

  def table(attributes: Map[String, String] = Map())(content: String) =
    generateTag("table", attributes)(content)

  def tbody(attributes: Map[String, String] = Map())(content: String) =
    generateTag("tbody", attributes)(content)

  def td(attributes: Map[String, String] = Map())(content: String) =
    generateTag("td", attributes)(content)

  def template(attributes: Map[String, String] = Map())(content: String) =
    generateTag("template", attributes)(content)

  def textarea(attributes: Map[String, String] = Map())(content: String) =
    generateTag("textarea", attributes)(content)

  def tfoot(attributes: Map[String, String] = Map())(content: String) =
    generateTag("tfoot", attributes)(content)

  def th(attributes: Map[String, String] = Map())(content: String) =
    generateTag("th", attributes)(content)

  def thead(attributes: Map[String, String] = Map())(content: String) =
    generateTag("thead", attributes)(content)

  def time(attributes: Map[String, String] = Map())(content: String) =
    generateTag("time", attributes)(content)

  def title(attributes: Map[String, String] = Map())(content: String) =
    generateTag("title", attributes)(content)

  def tr(attributes: Map[String, String] = Map())(content: String) =
    generateTag("tr", attributes)(content)

  def track(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("track", attributes)

  def u(attributes: Map[String, String] = Map())(content: String) =
    generateTag("u", attributes)(content)

  def ul(attributes: Map[String, String] = Map())(content: String) =
    generateTag("ul", attributes)(content)

  /**
   * `var` is scala keyword. That's why this has underbar at the end.
   * Please don't forget to add `_` when you use this!
   * @param attributes
   * @param content
   * @return String
   */
  def var_(attributes: Map[String, String] = Map())(content: String) =
    generateTag("var", attributes)(content)

  def video(attributes: Map[String, String] = Map())(content: String) =
    generateTag("video", attributes)(content)

  def wbr(attributes: Map[String, String] = Map()) =
    generateSelfClosingTag("wbr", attributes)

  // --- for custom tags ---

  def tag(tagName: String, attributes: Map[String, String] = Map())(content: String = "") =
    generateTag(tagName, attributes)(content)

  def selfClosingTag(tagName: String, attributes: Map[String, String] = Map(), hasEndSlash: Boolean = false) =
    generateSelfClosingTag(tagName, attributes, hasEndSlash)

  def tagSelf(tagName: String, attributes: Map[String, String] = Map(), hasEndSlash: Boolean = false) =
    selfClosingTag(tagName, attributes, hasEndSlash)

  // --- base functions ---


  def generateTag(tagName: String, attributes: Map[String, String] = Map())(content: String) = {
    if (attributes.isEmpty) {
      s"<$tagName>$content</$tagName>"
    } else {
      val attrs = attributesMapToString(attributes)
      s"<$tagName$attrs>$content</$tagName>"
    }
  }

  def generateSelfClosingTag(tagName: String, attributes: Map[String, String] = Map(), hasEndSlash: Boolean = false): String = {
    val withOrWithoutEndSlash = if (hasEndSlash) " />" else ">"
    if (attributes.isEmpty) {
      s"<$tagName$withOrWithoutEndSlash"
    } else {
      val attrs = attributesMapToString(attributes)
      s"<$tagName$attrs$withOrWithoutEndSlash"
    }
  }

  def attributesMapToString(attributes: Map[String, String]) = {
    val attrsList = for ((key, value) <- attributes) yield {
      if (value.isEmpty) s""" $key"""
      else if (key.isEmpty) s""" $value"""
      else s""" $key="$value""""
    }
    attrsList.mkString
  }

  // extension (str: String) { // TODO: for Scala3
  implicit class HtmlString (val str: String) {
    def \\(b: String): String = str + b
    def lf(b: String): String = \\(b)
    def nl(b: String): String = \\(b)
    def nextLine(b: String): String = \\(b)
    def newLine(b: String): String = \\(b)

    def toHtmlDocument: Document = Jsoup.parse(str)

    def print: Unit = println(str.toHtmlDocument.html())

  }
}
