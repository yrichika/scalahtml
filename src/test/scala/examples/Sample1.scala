package examples

import scalahtml.Tags._

object Sample1 extends App {


  val anotherList = List(1, 2, 3, 4, 5, 100, 200)
  val listOfNums = anotherList.map { number =>
    if (number < 10) "small number"
    else number.toString
  }.foldLeft("")((acc, b) => acc \\ li()(b))

  println(listOfNums)


  val htmlText = html5() {
    htmlHead \\
      body() {
        main_(attributes("class" -> "container mx-auto")) {
          h1(attrs("class" -> "text-5xl"))("ScalaHTML generated HTML") \\
            simpleTextContent \\
            simpleForm
        }
      }
  }


  def htmlHead = head() {
    meta(Map("charset" -> "UTF-8")) \\
      meta(Map("http-equiv" -> "X-UA-Compatible", "content" -> "IE=edge")) \\
      meta(attributes("name" -> "viewport", "content" -> "width=device-width, initial-scale=1.0")) \\
      link(attrs(
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

  //html.print
  //html.toHtmlDocument


}
