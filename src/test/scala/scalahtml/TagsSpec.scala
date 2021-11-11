package scalahtml

import org.jsoup.nodes.Document
import testcase.TestCase
import testcase.helpers.TestRandom

class TagsSpec extends TestCase {
  // import Tags.* // TODO: for Scala3
  import Tags._

  val randomStringContent = TestRandom.string(5)

  "comment" should {
    "retrn html comment string" in {
      val result = commentOut("some comment")
      result shouldBe "<!-- some comment -->"
    }
  }

  "doctypeHtml" should {
    "return html5 doctype tag string" in {
      val result = doctypeHtml()
      result shouldBe s"<!DOCTYPE html>"
    }
  }

  "doctype" should {
    "return doctype tag string" in {
      val result = doctype()
      result shouldBe s"<!DOCTYPE>"
    }
  }



  "a" should {
    "return a tag string with content" in {
      val result = Tags.a() {
        randomStringContent
      }
      result shouldBe s"<a>$randomStringContent</a>"
    }
  }

  "abbr" should {
    "return abbr tag string with content" in {
      val result = abbr() {
        randomStringContent
      }
      result shouldBe s"<abbr>$randomStringContent</abbr>"
    }
  }

  "address" should {
    "return address tag string with content" in {
      val result = address() {
        randomStringContent
      }
      result shouldBe s"<address>$randomStringContent</address>"
    }
  }

  "area" should {
    "return area tag string with content" in {
      val result = area() {
        randomStringContent
      }
      result shouldBe s"<area>$randomStringContent</area>"
    }
  }

  "article" should {
    "return article tag string with content" in {
      val result = article() {
        randomStringContent
      }
      result shouldBe s"<article>$randomStringContent</article>"
    }
  }

  "aside" should {
    "return aside tag string with content" in {
      val result = aside() {
        randomStringContent
      }
      result shouldBe s"<aside>$randomStringContent</aside>"
    }
  }

  "audio" should {
    "return audio tag string with content" in {
      val result = audio() {
        randomStringContent
      }
      result shouldBe s"<audio>$randomStringContent</audio>"
    }
  }

  "b" should {
    "return b tag string with content" in {
      val result = b() {
        randomStringContent
      }
      result shouldBe s"<b>$randomStringContent</b>"
    }
  }

  "base" should {
    "return base tag string with content" in {
      val result = base() {
        randomStringContent
      }
      result shouldBe s"<base>$randomStringContent</base>"
    }
  }

  "bdi" should {
    "return bdi tag string with content" in {
      val result = bdi() {
        randomStringContent
      }
      result shouldBe s"<bdi>$randomStringContent</bdi>"
    }
  }

  "bdo" should {
    "return bdo tag string with content" in {
      val result = bdo() {
        randomStringContent
      }
      result shouldBe s"<bdo>$randomStringContent</bdo>"
    }
  }

  "blockquote" should {
    "return blockquote tag string with content" in {
      val result = blockquote() {
        randomStringContent
      }
      result shouldBe s"<blockquote>$randomStringContent</blockquote>"
    }
  }

  "body" should {
    "return body tag string with content" in {
      val result = body() {
        randomStringContent
      }
      result shouldBe s"<body>$randomStringContent</body>"
    }
  }

  "br" should {
    "return br tag string with content" in {
      val result = br()
      result shouldBe s"<br>"
    }
  }

  "button" should {
    "return button tag string with content" in {
      val result = button() {
        randomStringContent
      }
      result shouldBe s"<button>$randomStringContent</button>"
    }
  }

  "canvas" should {
    "return canvas tag string with content" in {
      val result = canvas() {
        randomStringContent
      }
      result shouldBe s"<canvas>$randomStringContent</canvas>"
    }
  }
  
  "caption" should {
    "return caption tag string with content" in {
      val result = caption() {
        randomStringContent
      }
      result shouldBe s"<caption>$randomStringContent</caption>"
    }
  }

  "cite" should {
    "return cite tag string with content" in {
      val result = cite() {
        randomStringContent
      }
      result shouldBe s"<cite>$randomStringContent</cite>"
    }
  }

  "code" should {
    "return code tag string with content" in {
      val result = code() {
        randomStringContent
      }
      result shouldBe s"<code>$randomStringContent</code>"
    }
  }

  "col" should {
    "return col tag string with content" in {
      val result = col()
      result shouldBe s"<col>"
    }
  }

  "colgroup" should {
    "return colgroup tag string with content" in {
      val result = colgroup() {
        randomStringContent
      }
      result shouldBe s"<colgroup>$randomStringContent</colgroup>"
    }
  }

  "data" should {
    "return data tag string with content" in {
      val result = data() {
        randomStringContent
      }
      result shouldBe s"<data>$randomStringContent</data>"
    }
  }

  "datalist" should {
    "return datalist tag string with content" in {
      val result = datalist() {
        randomStringContent
      }
      result shouldBe s"<datalist>$randomStringContent</datalist>"
    }
  }

  "dd" should {
    "return dd tag string with content" in {
      val result = dd() {
        randomStringContent
      }
      result shouldBe s"<dd>$randomStringContent</dd>"
    }
  }

  "del" should {
    "return del tag string with content" in {
      val result = del() {
        randomStringContent
      }
      result shouldBe s"<del>$randomStringContent</del>"
    }
  }

  "details" should {
    "return details tag string with content" in {
      val result = details() {
        randomStringContent
      }
      result shouldBe s"<details>$randomStringContent</details>"
    }
  }

  "dfn" should {
    "return dfn tag string with content" in {
      val result = dfn() {
        randomStringContent
      }
      result shouldBe s"<dfn>$randomStringContent</dfn>"
    }
  }

  "dialog" should {
    "return dialog tag string with content" in {
      val result = dialog() {
        randomStringContent
      }
      result shouldBe s"<dialog>$randomStringContent</dialog>"
    }
  }

  "div" should {
    "return div tag string with content" in {
      val result = div() {
        randomStringContent
      }
      result shouldBe s"<div>$randomStringContent</div>"
    }
  }

  "dl" should {
    "return dl tag string with content" in {
      val result = dl() {
        randomStringContent
      }
      result shouldBe s"<dl>$randomStringContent</dl>"
    }
  }

  "dt" should {
    "return dt tag string with content" in {
      val result = dt() {
        randomStringContent
      }
      result shouldBe s"<dt>$randomStringContent</dt>"
    }
  }

  "em" should {
    "return em tag string with content" in {
      val result = em() {
        randomStringContent
      }
      result shouldBe s"<em>$randomStringContent</em>"
    }
  }

  "embed" should {
    "return embed tag string with content" in {
      val result = embed() {
        randomStringContent
      }
      result shouldBe s"<embed>$randomStringContent</embed>"
    }
  }

  "fieldset" should {
    "return fieldset tag string with content" in {
      val result = fieldset() {
        randomStringContent
      }
      result shouldBe s"<fieldset>$randomStringContent</fieldset>"
    }
  }

  "figcaption" should {
    "return figcaption tag string with content" in {
      val result = figcaption() {
        randomStringContent
      }
      result shouldBe s"<figcaption>$randomStringContent</figcaption>"
    }
  }

  "figure" should {
    "return figure tag string with content" in {
      val result = figure() {
        randomStringContent
      }
      result shouldBe s"<figure>$randomStringContent</figure>"
    }
  }

  "footer" should {
    "return footer tag string with content" in {
      val result = footer() {
        randomStringContent
      }
      result shouldBe s"<footer>$randomStringContent</footer>"
    }
  }

  "form" should {
    "return form tag string with content" in {
      val result = form() {
        randomStringContent
      }
      result shouldBe s"<form>$randomStringContent</form>"
    }
  }

  "h1" should {
    "return h1 tag string with content" in {
      val result = h1() {
        randomStringContent
      }
      result shouldBe s"<h1>$randomStringContent</h1>"
    }
  }

  "h2" should {
    "return h2 tag string with content" in {
      val result = h2() {
        randomStringContent
      }
      result shouldBe s"<h2>$randomStringContent</h2>"
    }
  }

  "h3" should {
    "return h3 tag string with content" in {
      val result = h3() {
        randomStringContent
      }
      result shouldBe s"<h3>$randomStringContent</h3>"
    }
  }

  "h4" should {
    "return h4 tag string with content" in {
      val result = h4() {
        randomStringContent
      }
      result shouldBe s"<h4>$randomStringContent</h4>"
    }
  }

  "h5" should {
    "return h5 tag string with content" in {
      val result = h5() {
        randomStringContent
      }
      result shouldBe s"<h5>$randomStringContent</h5>"
    }
  }

  "h6" should {
    "return h6 tag string with content" in {
      val result = h6() {
        randomStringContent
      }
      result shouldBe s"<h6>$randomStringContent</h6>"
    }
  }

  "head" should {
    "return head tag string with content" in {
      val result = head() {
        randomStringContent
      }
      result shouldBe s"<head>$randomStringContent</head>"
    }
  }

  "header" should {
    "return header tag string with content" in {
      val result = header() {
        randomStringContent
      }
      result shouldBe s"<header>$randomStringContent</header>"
    }
  }

  "hr" should {
    "return hr tag string with content" in {
      val result = hr()
      result shouldBe s"<hr>"
    }
  }

  "html" should {
    "return html tag string with content" in {
      val result = html() {
        randomStringContent
      }
      result shouldBe s"<html>$randomStringContent</html>"
    }
  }

  "html5" should {
    "return html5 tag string with content" in {
      val result = html5() {
        randomStringContent
      }
      result shouldBe s"<!DOCTYPE html><html>$randomStringContent</html>"
    }
  }

  "i" should {
    "return i tag string with content" in {
      val result = i() {
        randomStringContent
      }
      result shouldBe s"<i>$randomStringContent</i>"
    }
  }

  "iframe" should {
    "return iframe tag string with content" in {
      val result = iframe() {
        randomStringContent
      }
      result shouldBe s"<iframe>$randomStringContent</iframe>"
    }
  }

  "img" should {
    "return img tag string with content" in {
      val result = img()
      result shouldBe s"<img>"
    }
  }

  "input" should {
    "return input tag string with content" in {
      val result = input()
      result shouldBe s"<input>"
    }
  }

  "ins" should {
    "return ins tag string with content" in {
      val result = ins() {
        randomStringContent
      }
      result shouldBe s"<ins>$randomStringContent</ins>"
    }
  }

  "kbd" should {
    "return kbd tag string with content" in {
      val result = kbd() {
        randomStringContent
      }
      result shouldBe s"<kbd>$randomStringContent</kbd>"
    }
  }

  "label" should {
    "return label tag string with content" in {
      val result = label() {
        randomStringContent
      }
      result shouldBe s"<label>$randomStringContent</label>"
    }
  }

  "legend" should {
    "return legend tag string with content" in {
      val result = legend() {
        randomStringContent
      }
      result shouldBe s"<legend>$randomStringContent</legend>"
    }
  }

  "li" should {
    "return li tag string with content" in {
      val result = li() {
        randomStringContent
      }
      result shouldBe s"<li>$randomStringContent</li>"
    }
  }

  "link" should {
    "return link tag string with content" in {
      val result = link()
      result shouldBe s"<link>"
    }
  }
  
  "main" should {
    "return main tag string with content" in {
      val result = main() {
        randomStringContent
      }
      result shouldBe s"<main>$randomStringContent</main>"
    }
  }


  "main_" should {
    "return main tag string with content" in {
      val result = main_() {
        randomStringContent
      }
      result shouldBe s"<main>$randomStringContent</main>"
    }
  }

  "map" should {
    "return map tag string with content" in {
      val result = map() {
        randomStringContent
      }
      result shouldBe s"<map>$randomStringContent</map>"
    }
  }

  "mark" should {
    "return mark tag string with content" in {
      val result = mark() {
        randomStringContent
      }
      result shouldBe s"<mark>$randomStringContent</mark>"
    }
  }

  "meta" should {
    "return meta tag string with content" in {
      val result = meta()
      result shouldBe s"<meta>"
    }
  }

  "meter" should {
    "return meter tag string with content" in {
      val result = meter() {
        randomStringContent
      }
      result shouldBe s"<meter>$randomStringContent</meter>"
    }
  }

  "nav" should {
    "return nav tag string with content" in {
      val result = nav() {
        randomStringContent
      }
      result shouldBe s"<nav>$randomStringContent</nav>"
    }
  }

  "noscript" should {
    "return noscript tag string with content" in {
      val result = noscript() {
        randomStringContent
      }
      result shouldBe s"<noscript>$randomStringContent</noscript>"
    }
  }

  "object_" should {
    "return object_ tag string with content" in {
      val result = object_() {
        randomStringContent
      }
      result shouldBe s"<object>$randomStringContent</object>"
    }
  }

  "ol" should {
    "return ol tag string with content" in {
      val result = ol() {
        randomStringContent
      }
      result shouldBe s"<ol>$randomStringContent</ol>"
    }
  }

  "optgroup" should {
    "return optgroup tag string with content" in {
      val result = optgroup() {
        randomStringContent
      }
      result shouldBe s"<optgroup>$randomStringContent</optgroup>"
    }
  }

  "option" should {
    "return option tag string with content" in {
      val result = option() {
        randomStringContent
      }
      result shouldBe s"<option>$randomStringContent</option>"
    }
  }

  "output" should {
    "return output tag string with content" in {
      val result = output() {
        randomStringContent
      }
      result shouldBe s"<output>$randomStringContent</output>"
    }
  }

  "p" should {
    "return p tag string with content" in {
      val result = p() {
        randomStringContent
      }
      result shouldBe s"<p>$randomStringContent</p>"
    }
  }

  "param" should {
    "return param tag string with content" in {
      val result = param()
      result shouldBe s"<param>"
    }
  }

  "picture" should {
    "return picture tag string with content" in {
      val result = picture() {
        randomStringContent
      }
      result shouldBe s"<picture>$randomStringContent</picture>"
    }
  }

  "pre" should {
    "return pre tag string with content" in {
      val result = pre() {
        randomStringContent
      }
      result shouldBe s"<pre>$randomStringContent</pre>"
    }
  }

  "progress" should {
    "return progress tag string with content" in {
      val result = progress() {
        randomStringContent
      }
      result shouldBe s"<progress>$randomStringContent</progress>"
    }
  }

  "q" should {
    "return q tag string with content" in {
      val result = q() {
        randomStringContent
      }
      result shouldBe s"<q>$randomStringContent</q>"
    }
  }

  "rp" should {
    "return rp tag string with content" in {
      val result = rp() {
        randomStringContent
      }
      result shouldBe s"<rp>$randomStringContent</rp>"
    }
  }

  "rt" should {
    "return rt tag string with content" in {
      val result = rt() {
        randomStringContent
      }
      result shouldBe s"<rt>$randomStringContent</rt>"
    }
  }

  "ruby" should {
    "return ruby tag string with content" in {
      val result = ruby() {
        randomStringContent
      }
      result shouldBe s"<ruby>$randomStringContent</ruby>"
    }
  }

  "s" should {
    "return s tag string with content" in {
      val result = s() {
        randomStringContent
      }
      result shouldBe s"<s>$randomStringContent</s>"
    }
  }

  "samp" should {
    "return samp tag string with content" in {
      val result = samp() {
        randomStringContent
      }
      result shouldBe s"<samp>$randomStringContent</samp>"
    }
  }

  "script" should {
    "return script tag string with content" in {
      val result = script() {
        randomStringContent
      }
      result shouldBe s"<script>$randomStringContent</script>"
    }
  }

  "section" should {
    "return section tag string with content" in {
      val result = section() {
        randomStringContent
      }
      result shouldBe s"<section>$randomStringContent</section>"
    }
  }

  "select" should {
    "return select tag string with content" in {
      val result = select() {
        randomStringContent
      }
      result shouldBe s"<select>$randomStringContent</select>"
    }
  }

  "small" should {
    "return small tag string with content" in {
      val result = small() {
        randomStringContent
      }
      result shouldBe s"<small>$randomStringContent</small>"
    }
  }

  "source" should {
    "return source tag string with content" in {
      val result = source()
      result shouldBe s"<source>"
    }
  }

  "span" should {
    "return span tag string with content" in {
      val result = span() {
        randomStringContent
      }
      result shouldBe s"<span>$randomStringContent</span>"
    }
  }

  "strong" should {
    "return strong tag string with content" in {
      val result = strong() {
        randomStringContent
      }
      result shouldBe s"<strong>$randomStringContent</strong>"
    }
  }

  "style" should {
    "return style tag string with content" in {
      val result = style() {
        randomStringContent
      }
      result shouldBe s"<style>$randomStringContent</style>"
    }
  }

  "sub" should {
    "return sub tag string with content" in {
      val result = sub() {
        randomStringContent
      }
      result shouldBe s"<sub>$randomStringContent</sub>"
    }
  }

  "summary" should {
    "return summary tag string with content" in {
      val result = summary() {
        randomStringContent
      }
      result shouldBe s"<summary>$randomStringContent</summary>"
    }
  }

  "sup" should {
    "return sup tag string with content" in {
      val result = sup() {
        randomStringContent
      }
      result shouldBe s"<sup>$randomStringContent</sup>"
    }
  }

  "svg" should {
    "return svg tag string with content" in {
      val result = svg() {
        randomStringContent
      }
      result shouldBe s"<svg>$randomStringContent</svg>"
    }
  }

  "table" should {
    "return table tag string with content" in {
      val result = table() {
        randomStringContent
      }
      result shouldBe s"<table>$randomStringContent</table>"
    }
  }

  "tbody" should {
    "return tbody tag string with content" in {
      val result = tbody() {
        randomStringContent
      }
      result shouldBe s"<tbody>$randomStringContent</tbody>"
    }
  }

  "td" should {
    "return td tag string with content" in {
      val result = td() {
        randomStringContent
      }
      result shouldBe s"<td>$randomStringContent</td>"
    }
  }

  "template" should {
    "return template tag string with content" in {
      val result = template() {
        randomStringContent
      }
      result shouldBe s"<template>$randomStringContent</template>"
    }
  }

  "textarea" should {
    "return textarea tag string with content" in {
      val result = textarea() {
        randomStringContent
      }
      result shouldBe s"<textarea>$randomStringContent</textarea>"
    }
  }

  "tfoot" should {
    "return tfoot tag string with content" in {
      val result = tfoot() {
        randomStringContent
      }
      result shouldBe s"<tfoot>$randomStringContent</tfoot>"
    }
  }

  "th" should {
    "return th tag string with content" in {
      val result = th() {
        randomStringContent
      }
      result shouldBe s"<th>$randomStringContent</th>"
    }
  }

  "thead" should {
    "return thead tag string with content" in {
      val result = thead() {
        randomStringContent
      }
      result shouldBe s"<thead>$randomStringContent</thead>"
    }
  }

  "time" should {
    "return time tag string with content" in {
      val result = time() {
        randomStringContent
      }
      result shouldBe s"<time>$randomStringContent</time>"
    }
  }

  "title" should {
    "return title tag string with content" in {
      val result = title() {
        randomStringContent
      }
      result shouldBe s"<title>$randomStringContent</title>"
    }
  }

  "tr" should {
    "return tr tag string with content" in {
      val result = tr() {
        randomStringContent
      }
      result shouldBe s"<tr>$randomStringContent</tr>"
    }
  }

  "track" should {
    "return track tag string with content" in {
      val result = track()
      result shouldBe s"<track>"
    }
  }

  "u" should {
    "return u tag string with content" in {
      val result = u() {
        randomStringContent
      }
      result shouldBe s"<u>$randomStringContent</u>"
    }
  }

  "ul" should {
    "return ul tag string with content" in {
      val result = ul() {
        randomStringContent
      }
      result shouldBe s"<ul>$randomStringContent</ul>"
    }
  }

  "var_" should {
    "return var_ tag string with content" in {
      val result = var_() {
        randomStringContent
      }
      result shouldBe s"<var>$randomStringContent</var>"
    }
  }

  "video" should {
    "return video tag string with content" in {
      val result = video() {
        randomStringContent
      }
      result shouldBe s"<video>$randomStringContent</video>"
    }
  }

  "wbr" should {
    "return wbr tag string with content" in {
      val result = wbr()
      result shouldBe s"<wbr>"
    }
  }
  
  
  // -----------------------------
  
  "tag" should  {
    val anyTagName = TestRandom.string(5)
    val content = TestRandom.string(5)
    "generate any named tag" in {
      val result = tag(anyTagName) {
        content
      }
      result shouldBe s"<$anyTagName>$content</$anyTagName>"
    }
  }


  "selfClosingTag" should {
    val anyTagName = TestRandom.string(5)
    "generate self-closing any named tag" in {
      val result = selfClosingTag(anyTagName)
      result shouldBe s"<$anyTagName>"
    }
    "with end slash if hasEndSlash parameter is true" in {
      val result = selfClosingTag(anyTagName, hasEndSlash = true)
      result shouldBe s"<$anyTagName />"
    }
  }


  "tagSelf" should {
    val anyTagName = TestRandom.string(5)
    "generate self-closing any named tag" in {
      val result = tagSelf(anyTagName)
      result shouldBe s"<$anyTagName>"
    }
    "with end slash if hasEndSlash parameter is true" in {
      val result = tagSelf(anyTagName, hasEndSlash = true)
      result shouldBe s"<$anyTagName />"
    }
  }


  "generateTag" should {
    val id = TestRandom.string(5)
    val content = TestRandom.string(5)
    val classValue = TestRandom.string(5)
    val tagName = "some-tag"
    "generate tag with content" in {
      val result = generateTag(tagName) {
        content
      }
      result shouldBe s"<$tagName>$content</$tagName>"
    }
    "generate tag with attributes if given" in {
      val attributes = Map("id" -> id, "class" -> classValue)
      val result = generateTag("some-tag", attributes) {
        content
      }
      result shouldBe s"""<$tagName id="$id" class="$classValue">$content</$tagName>"""
    }
  }

  "generateSelfClosingTag" should {
    val tagName = "self-closing"
    val id = TestRandom.string(5)
    val classValue = TestRandom.string(5)

    "generate self-closing tag" in {
      val result = generateSelfClosingTag(tagName)
      result shouldBe s"<$tagName>"
    }
    "add end slash if hasEndSlash parameter true" in {
      val result = generateSelfClosingTag(tagName, hasEndSlash = true)
      result shouldBe s"<$tagName />"
    }
    "generate tag with attributes if given" in {
      val attrs = Map("id" -> id, "class" -> classValue)

      val result = generateSelfClosingTag(tagName, attrs)
      result shouldBe s"""<$tagName id="$id" class="$classValue">"""
    }
  }


  "attributesMapToString" should {
    val id = TestRandom.string(5)
    val classValue = TestRandom.string(5)
    val someValue = TestRandom.string(5)
    "convert Map to tag attribute string" in {
      val attrs = Map("id" -> id, "class" -> classValue)

      val result = attributesMapToString(attrs)
      result shouldBe s""" id="$id" class="$classValue""""
    }
    "create attribute with no value if Map has empty key" in {
      // empty key
      val onlyValue = Map("" -> someValue, "class" -> classValue)

      val result = attributesMapToString(onlyValue)
      result shouldBe s""" $someValue class="$classValue""""
    }
    "create attribute with no value if Map has empty value" in {
      // empty value
      val onlyValue = Map(someValue -> "", "class" -> classValue)

      val result = attributesMapToString(onlyValue)
      result shouldBe s""" $someValue class="$classValue""""
    }
  }

  """\\""" should {
    "concatenate strings" in {
      val text = TestRandom.string(5)
      val result = div()(text) \\ div()(text)
      result shouldBe s"<div>$text</div><div>$text</div>"
    }
  }

  "toHtmlDocument" should {
    "convert html string to jsoup Document" in {
      val html = html5() {
        head()("")
        body()("")
      }
      val result = html.toHtmlDocument
      result shouldBe a[Document]
    }
  }

}
