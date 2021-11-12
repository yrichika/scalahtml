# ScalaHTML


This simple module is to generate a complete HTML `String` only from Scala code.
No mixture of Scala and HTML. You only need to write Scala, and the final product will be an HTML text as `String`.

With Template engines, you have to write programming code within HTML texts.
Often it's difficult to split loops, `if`s, and HTML tags with template engines.
And we end up writing complicated and mixed-up codes.

With this ScalaHTML, you don't need to write any HTML tags.
Just write Scala for complicated HTML pages!

This is more like a suggestion than a module.
This is a suggestion to write HTML with complicated logic in a better way, a suggestion to create something easier to read than template engines.

---


## Requirements

```
3.0 >= Scala >= 2.13.5
```

## Installation

Add the line below to `build.sbt`.

```
libraryDependencies += "io.github.yrichika" %% "scalahtml" % "0.1.1"
```


---

## How to Use

### The HTML Tag and the Main Operator 

First, please `import scalahtml.Tags._`.
Then start with `html5()` or `doctypeHtml \\ html()`.


```scala
import scalahtml.Tags._


val html = doctypeHtml() \\ html() {
  "any string or tag methods here"
}

// And this is the shortcut for the above code.
// This creates exactly the same result.
val html = html5() {
  "any string or tag methods here"
}

```

Above code (the value in `html` val) will produce:

```html
<!DOCTYPE html>
<html>
    "any string here or tag methods here"
</html>
```

Here `\\` operator is important. `\\` concatenates sibling tags.
It's just an alias for `+`: string concatenation operator.


For example:

```scala
val content = div() {
  p()("any paragraph") \\ // <- important!!
  p()("another paragraph")
}

```

This will combine `<p>any paragraph</p>` and `<p>another paragraph</p>` and creates:


```html
<main>
  <p>any paragraph</p> // if you forget to add `\\`, this tag will not be added.
  <p>another paragraph</p>
</main>
```

If you forget to use `\\`, then the left side of the operator will be ignored. It will not be in the final HTML text.

To summarize, **use `\\` operator wherever you have sibling tags**.

There are aliases for `\\`. Please use whichever you like.

- `lf`
- `nl`
- `nextLine`
- `newLine`

This code below will produce exactly the same result as the code above.

```scala
val content = div() {
  p()("any paragraph") nl // or lf, nextLine, newLine, +
  p()("another paragraph")
}

```

---

### Adding Attributes

Any tag methods accept `Map[String, String]` as tag attributes at the first parameter list.

```scala
val tagWithAttributes = div(Map("id" -> "main", "class" -> "container")) {
  p()("lorem ipsum...")
  // ...
}
```

There are two aliases for `Map`: `attributes` and `attrs`.
I added these aliases for readability. But right now, I'm not sure if it's helpful or not.


```scala
val tagWithAttributes1 = div(attributes("id" -> "main", "class" -> "container")) {
  p()("lorem ipsum...")
  // ... 
}

// Or
val tagWithAttributes2 = div(attrs("id" -> "main", "class" -> "container")) {
  p()("lorem ipsum...")
  // ... 
}


```

--


### Adding Attributes Without Values


Some HTML tags accept attributes without any values.
For example, `<audio>` may have a `controls` attribute without any value.

```html
<audio controls>
  <!-- some sources here -->
</audio>
```

In this case, you may provide `Map[String, String]` with an empty string key or value.

```scala
// Map with empty string value (Recommended)
val audioTag = audio(attrs("controls" -> "")) {
  // ...
}

// Or Map with empty string key (Not Recommended, but still works only if there is one "" key)
val audioTag2 = audio(attrs("" -> "controls")) {
  // ...
}
```

Use empty string values unless you have a reason to do so.
If you have multiple empty string keys, only one of the attributes will be added. 


---


### Building Tags


To nest HTML tags or to put text contents in a tag, simply pass another tag or `String` to the second argument list.

```scala
val content = div(attrs("id" -> "main")) {
  // pass another tag or simple String to the second argument list
  p()("a paragraph in a div tag") \\
  p() {
    span(attrs("class" -> "text-bold"))("a span tag in a paragraph tag") \\
    span()("another span in the same paragraph tag")
  }
}

```

The code above produces this:

```html
<div id="main">
    <p>a paragraph in a div tag</p>
    <p>
        <span class="text-bold">a span tag in a paragraph tag</span>
        <span>another span in the same paragraph tag</span>
    </p>
</div>
```

---


### Tags with Loops and ifs

Here is a loop example. You just need to write Scala.
This is an example of how you don't have to mix Scala with HTML tags.

```scala

// To create some <li>s from a `List`
val aList = List(1, 2, 3, 4, 5)
val listOfNumbers = aList.map(_.toString).foldLeft("")((acc, b) => {
  acc \\ li()(b)
})
// the result `listOfNumbers` has the string below:
// <li>1</li><li>2</li><li>3</li><li>4</li><li>5</li>
```

Loop with `if` and `filter` examples:

```scala
val anotherList = List(1, 2, 3, 4, 5, 100, 200)
val listOfNumsLessThan10 = anotherList.filter(_ <= 10).map(_.toString).foldLeft("")((acc, b) => {
  acc \\ li()(b)
})
// the result `listOfNumsLessThan10` has the string below. Filtered out 100 and 200.
// <li>1</li><li>2</li><li>3</li><li>4</li><li>5</li>

// loop with if-else
val listOfSomething = anotherList.map { number =>
  if (number < 10) "small number"
  else number.toString
}.foldLeft("")((acc, b) => acc \\ li()(b))
// result: `listOfSomething`
// <li>small number</li>
// <li>small number</li>
// <li>small number</li>
// <li>small number</li>
// <li>small number</li>
// <li>100</li>
// <li>200</li>

// The result `listOfSomething` is just another html `String`.
// you can mix it with another tag afterward.
val unorderedList = ul() {
  listOfSomething
}

```




---

### Available Methods

#### Utility Methods

```scala
import scalahtml.Tags._

// Add comment in html text
commentOut("lorem ipsum") // <!-- lorem ipsum -->

doctypeHtml() // <!DOCTYPE html>
doctype(Map("html" -> "")) // <!DOCTYPE html>

// If you want to write custom tags
tag("custom-tag", Map("id" -> "custom-a")) {
  "some content"
} // <custom-tag id="custom-a">some content</custom-tag>

// `selfClosingTag` or `tagSelf` create self-closing custom tags
selfClosingTag("custom-self", Map("class" -> "form-input")) // <custom-self class="form-input">
selfClosingTag("custom-self2", hasEndSlash = true) // <custom-self2 />
// `tagSelf` is just an alias for `selfClosingTag`
tagSelf("custom-self3") // <custom-self3>


// To use extension methods, please `import scalahtml.Tags._`, or `import scalahtml.Tags.*` for Scala3.

val htmlText: String = html5() {
  // ...
}
// `toHtmlDocument` converts HTML String to jsoup HTML Document
// How to use jsoup Document object:
// https://jsoup.org/cookbook/extracting-data/dom-navigation
val document = htmlText.toHtmlDocument

// This will output HTML text to the console.
htmlText.print

```


#### Tag Methods


- `a(attributes: Map[String, String]) { content: String }`: `<a></a>`
- `abbr(attributes: Map[String, String]) { content: String }`: `<abbr></abbr>`
- `address(attributes: Map[String, String]) { content: String }`: `<address></address>`
- `area(attributes: Map[String, String]) { content: String }`: `<area></area>`
- `article(attributes: Map[String, String]) { content: String }`: `<article></article>`
- `aside(attributes: Map[String, String]) { content: String }`: `<aside></aside>`
- `audio(attributes: Map[String, String]) { content: String }`: `<audio></audio>`
- `b(attributes: Map[String, String]) { content: String }`: `<b></b>`
- `base(attributes: Map[String, String]) { content: String }`: `<base></base>`
- `bdi(attributes: Map[String, String]) { content: String }`: `<bdi></bdi>`
- `bdo(attributes: Map[String, String]) { content: String }`: `<bdo></bdo>`
- `blockquote(attributes: Map[String, String]) { content: String }`: `<blockquote></blockquote>`
- `body(attributes: Map[String, String]) { content: String }`: `<body></body>`
- `br(attributes: Map[String, String] = Map())`: `<br>`
- `button(attributes: Map[String, String]) { content: String }`: `<button></button>`
- `canvas(attributes: Map[String, String]) { content: String }`: `<canvas></canvas>`
- `caption(attributes: Map[String, String]) { content: String }`: `<caption></caption>`
- `cite(attributes: Map[String, String]) { content: String }`: `<cite></cite>`
- `code(attributes: Map[String, String]) { content: String }`: `<code></code>`
- `col(attributes: Map[String, String] = Map())`: `<col>`
- `colgroup(attributes: Map[String, String]) { content: String }`: `<colgroup></colgroup>`
- `data(attributes: Map[String, String]) { content: String }`: `<data></data>`
- `datalist(attributes: Map[String, String]) { content: String }`: `<datalist></datalist>`
- `dd(attributes: Map[String, String]) { content: String }`: `<dd></dd>`
- `del(attributes: Map[String, String]) { content: String }`: `<del></del>`
- `details(attributes: Map[String, String]) { content: String }`: `<details></details>`
- `dfn(attributes: Map[String, String]) { content: String }`: `<dfn></dfn>`
- `dialog(attributes: Map[String, String]) { content: String }`: `<dialog></dialog>`
- `div(attributes: Map[String, String]) { content: String }`: `<div></div>`
- `dl(attributes: Map[String, String]) { content: String }`: `<dl></dl>`
- `dt(attributes: Map[String, String]) { content: String }`: `<dt></dt>`
- `em(attributes: Map[String, String]) { content: String }`: `<em></em>`
- `embed(attributes: Map[String, String]) { content: String }`: `<embed></embed>`
- `fieldset(attributes: Map[String, String]) { content: String }`: `<fieldset></fieldset>`
- `figcaption(attributes: Map[String, String]) { content: String }`: `<figcaption></figcaption>`
- `figure(attributes: Map[String, String]) { content: String }`: `<figure></figure>`
- `footer(attributes: Map[String, String]) { content: String }`: `<footer></footer>`
- `form(attributes: Map[String, String]) { content: String }`: `<form></form>`
- `h1(attributes: Map[String, String]) { content: String }`: `<h1></h1>`
- `h2(attributes: Map[String, String]) { content: String }`: `<h2></h2>`
- `h3(attributes: Map[String, String]) { content: String }`: `<h3></h3>`
- `h4(attributes: Map[String, String]) { content: String }`: `<h4></h4>`
- `h5(attributes: Map[String, String]) { content: String }`: `<h5></h5>`
- `h6(attributes: Map[String, String]) { content: String }`: `<h6></h6>`
- `head(attributes: Map[String, String]) { content: String }`: `<head></head>`
- `header(attributes: Map[String, String]) { content: String }`: `<header></header>`
- `hr(attributes: Map[String, String] = Map())`: `<hr>`
- `html(attributes: Map[String, String]) { content: String }`: `<html></html>`
- `i(attributes: Map[String, String]) { content: String }`: `<i></i>`
- `iframe(attributes: Map[String, String]) { content: String }`: `<iframe></iframe>`
- `img(attributes: Map[String, String] = Map())`: `<img>`
- `input(attributes: Map[String, String] = Map())`: `<input>`
- `ins(attributes: Map[String, String]) { content: String }`: `<ins></ins>`
- `kbd(attributes: Map[String, String]) { content: String }`: `<kbd></kbd>`
- `label(attributes: Map[String, String]) { content: String }`: `<label></label>`
- `legend(attributes: Map[String, String]) { content: String }`: `<legend></legend>`
- `li(attributes: Map[String, String]) { content: String }`: `<li></li>`
- `link(attributes: Map[String, String] = Map())`: `<link>`
- `main(attributes: Map[String, String]) { content: String }`: `<main></main>`
- `main_(attributes: Map[String, String]) { content: String }`: `<main></main>`
  - This is an alias for `main`. Depending on where you write code, `main` might conflict with Scala's `main` method.
- `map(attributes: Map[String, String]) { content: String }`: `<map></map>`
- `mark(attributes: Map[String, String]) { content: String }`: `<mark></mark>`
- `meta(attributes: Map[String, String] = Map())`: `<meta>`
- `meter(attributes: Map[String, String]) { content: String }`: `<meter></meter>`
- `nav(attributes: Map[String, String]) { content: String }`: `<nav></nav>`
- `noscript(attributes: Map[String, String]) { content: String }`: `<noscript></noscript>`
- `object_(attributes: Map[String, String]) { content: String }`: `<object></object>`
  - Because `object` is Scala's keyword, `_` has to be added to this method name.
- `ol(attributes: Map[String, String]) { content: String }`: `<ol></ol>`
- `optgroup(attributes: Map[String, String]) { content: String }`: `<optgroup></optgroup>`
- `option(attributes: Map[String, String]) { content: String }`: `<option></option>`
- `output(attributes: Map[String, String]) { content: String }`: `<output></output>`
- `p(attributes: Map[String, String]) { content: String }`: `<p></p>`
- `param(attributes: Map[String, String] = Map())`: `<param>`
- `picture(attributes: Map[String, String]) { content: String }`: `<picture></picture>`
- `pre(attributes: Map[String, String]) { content: String }`: `<pre></pre>`
- `progress(attributes: Map[String, String]) { content: String }`: `<progress></progress>`
- `q(attributes: Map[String, String]) { content: String }`: `<q></q>`
- `rp(attributes: Map[String, String]) { content: String }`: `<rp></rp>`
- `rt(attributes: Map[String, String]) { content: String }`: `<rt></rt>`
- `ruby(attributes: Map[String, String]) { content: String }`: `<ruby></ruby>`
- `s(attributes: Map[String, String]) { content: String }`: `<s></s>`
- `samp(attributes: Map[String, String]) { content: String }`: `<samp></samp>`
- `script(attributes: Map[String, String]) { content: String }`: `<script></script>`
- `section(attributes: Map[String, String]) { content: String }`: `<section></section>`
- `select(attributes: Map[String, String]) { content: String }`: `<select></select>`
- `small(attributes: Map[String, String]) { content: String }`: `<small></small>`
- `source(attributes: Map[String, String] = Map())`: `<source>`
- `span(attributes: Map[String, String]) { content: String }`: `<span></span>`
- `strong(attributes: Map[String, String]) { content: String }`: `<strong></strong>`
- `style(attributes: Map[String, String]) { content: String }`: `<style></style>`
- `sub(attributes: Map[String, String]) { content: String }`: `<sub></sub>`
- `summary(attributes: Map[String, String]) { content: String }`: `<summary></summary>`
- `sup(attributes: Map[String, String]) { content: String }`: `<sup></sup>`
- `svg(attributes: Map[String, String]) { content: String }`: `<svg></svg>`
- `table(attributes: Map[String, String]) { content: String }`: `<table></table>`
- `tbody(attributes: Map[String, String]) { content: String }`: `<tbody></tbody>`
- `td(attributes: Map[String, String]) { content: String }`: `<td></td>`
- `template(attributes: Map[String, String]) { content: String }`: `<template></template>`
- `textarea(attributes: Map[String, String]) { content: String }`: `<textarea></textarea>`
- `tfoot(attributes: Map[String, String]) { content: String }`: `<tfoot></tfoot>`
- `th(attributes: Map[String, String]) { content: String }`: `<th></th>`
- `thead(attributes: Map[String, String]) { content: String }`: `<thead></thead>`
- `time(attributes: Map[String, String]) { content: String }`: `<time></time>`
- `title(attributes: Map[String, String]) { content: String }`: `<title></title>`
- `tr(attributes: Map[String, String]) { content: String }`: `<tr></tr>`
- `track(attributes: Map[String, String] = Map())`: `<track>`
- `u(attributes: Map[String, String]) { content: String }`: `<u></u>`
- `ul(attributes: Map[String, String]) { content: String }`: `<ul></ul>`
- `var_(attributes: Map[String, String]) { content: String }`: `<var></var>`
  - `var` name conflicts with Scala's `var`. Please don't forget to add `_`.
- `video(attributes: Map[String, String]) { content: String }`: `<video></video>`
- `wbr(attributes: Map[String, String] = Map())`: `<wbr>`

---

## Examples


```scala
import scalahtml.Tags._

val html = html5() {
  htmlHead \\
  body() {
    main_(attributes("class" -> "container mx-auto")) {
      h1(attributes("class" -> "text-5xl"))("ScalaHTML generated HTML") \\
      simpleTextContent \\
      simpleForm
    }
  }
}

// You can separate tags.
def htmlHead = head() {
  meta(attributes("charset" -> "UTF-8")) \\
  meta(attributes("http-equiv" -> "X-UA-Compatible", "content" -> "IE=edge")) \\
  meta(attributes("name" -> "viewport", "content" -> "width=device-width, initial-scale=1.0")) \\
  link(attributes(
    "href" -> "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css",
    "rel" -> "stylesheet"
  )) \\
  title()("ScalaHTML")
}

def simpleTextContent = div(attributes("id" -> "simple-content", "class" -> "mb-2")) {
  p(Map("class" -> "text-xl"))("I hope this integrates scala and HTML") \\
  a(Map("href" -> "https://github.com/yrichika/scalahtml", "class" -> "underline text-blue-400 hover:text-blue-600")) {
    "GitHub Repo"
  }
}

def simpleForm = div(attributes("id" -> "simple-form")) {
  form(attributes("action" -> "#", "method" -> "POST")) {
    input(attributes("type" -> "text", "name" -> "sample_input", "id" -> "sample-input", "class" -> "rounded border-2 border-blue-400 block mb-3")) \\
    textarea(attributes("name" -> "sample_text", "id" -> "sample-text", "cols" -> "30", "rows" -> "10", "class" -> "rounded border-2 border-blue-400 block mb-3"))("") \\
    button(attributes("type" -> "submit", "class" -> "text-xl bg-blue-400 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"))("Send!")
  }
}
```

The code above creates the html text below:


```html
<!doctype html>
<html>
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
      <title>ScalaHTML</title>
  </head>
 <body>
    <main class="container mx-auto">
        <h1 class="text-5xl">ScalaHTML generated HTML</h1>
        <div id="simple-content" class="mb-2">
            <p class="text-xl">I hope this integrates scala and HTML</p>
            <a href="https://github.com/yrichika/scalahtml" class="underline text-blue-400 hover:text-blue-600">GitHub Repo</a>
        </div>
        <div id="simple-form">
            <form action="#" method="POST">
            <input type="text" name="sample_input" id="sample-input" class="rounded border-2 border-blue-400 block mb-3"><textarea name="sample_text" id="sample-text" class="rounded border-2 border-blue-400 block mb-3" rows="10" cols="30"></textarea><button type="submit" class="text-xl bg-blue-400 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">Send!</button>
            </form>
        </div>
    </main>
 </body>
</html>
```

---



## Integrations

You can integrate ScalaHTML with other libraries.
It's easy to integrate with other libraries because ScalaHTML just generates a simple `String`.

Right now, it works with Akka HTTP. I haven't tested with other frameworks or libraries yet.
But it should work with libraries, which have any function to return a simple HTML `String` as an HTTP response.

Here is an example with Akka HTTP.

Assuming that you created a class with ScalaHTML like this:

```scala
import scalahtml.Tags._

// you can pass any data by class parameters
class SampleHtmlText(val titleText: String) {

  // This is the complete html text.
  val html = html5() {
    headContent \\
    bodyContent
  }

  // Other defs or vals are building blocks of the whole HTML text.
  def headContent = head() {
    meta(Map("charset" -> "UTF-8")) \\
    title()(titleText)
  }

  def bodyContent = body() {
    div() {
      h1() {
        titleText
      }
    }
  }
}
```

And you can use the class as a response with Akka HTTP like this:

```scala
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Main extends App {

  implicit val system = ActorSystem("scalahtml")
  implicit val mat = ActorMaterializer
  import system.dispatcher

  val route = pathEndOrSingleSlash {
    // You don't have to use classes.
    // Could be an object, val, def or anything you want!
    val htmlText = new SampleHtmlText("ScalaHTML!")
    complete(HttpEntity(
        ContentTypes.`text/html(UTF-8)`,
        // and just pass the generated html text
        htmlText.html
      )
    )
  }

  Http().newServerAt("localhost", 8080).bind(route)
}
```
