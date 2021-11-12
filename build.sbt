name := "scalahtml"

version := "0.1.1"

scalaVersion := "2.13.5"
crossScalaVersions := Seq(
  "2.13.5",
  "3.0.1"
)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.9",
  "org.scalatest" %% "scalatest" % "3.2.9" % "test",
  "org.jsoup" % "jsoup" % "1.14.3"
)
