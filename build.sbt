name := """play-java-hello-world-tutorial"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaWs,
  "org.eclipse.mylyn.github" % "org.eclipse.egit.github.core" % "2.1.5",
  "org.mockito" % "mockito-core" % "2.22.0" % "test",
   "javax.xml.bind" % "jaxb-api" % "2.3.1",
  "com.typesafe.akka" %% "akka-actor" % "2.6.14",
  "com.typesafe.akka" %% "akka-testkit" % "2.6.14" % Test,
  ehcache
)

