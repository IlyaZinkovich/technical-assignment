name := "technical-assignment"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" % "scala-logging_2.12" % "3.7.2"
)

mainClass in assembly := Some("route.simulation.SimulationApp")

coverageEnabled := true