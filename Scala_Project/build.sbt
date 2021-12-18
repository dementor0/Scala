import sbt._
import Versions._

/* default settings */
name := "dmtr"
version := "0.1"
scalaVersion := "2.13.4"

organization := "ie.mcmahon"

libraryDependencies ++= Seq(
  /* akka-http */
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  /* better config loading options https://github.com/iheartradio/ficus */
  "com.iheart" %% "ficus" % FicusVersion,
  /* JSON library powered by cats https://circe.github.io/circe/ */
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion,
  /* Scala Logging Library https://github.com/lightbend/scala-logging */
  "com.typesafe.scala-logging" %% "scala-logging" % ScalaLoggingVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  /* test libraries */
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.1.4" % Test
)
