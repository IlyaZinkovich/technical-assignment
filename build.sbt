name := "technical-assignment"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"

mainClass in assembly := Some("route.Simulation")