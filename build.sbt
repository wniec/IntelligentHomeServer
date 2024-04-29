ThisBuild / version := "0.1.0-SNAPSHOT"
libraryDependencies += "com.zeroc" % "ice" % "3.7.10"
ThisBuild / scalaVersion := "2.13.13"
lazy val root = (project in file("."))
  .settings(
    name := "IntelligentHomeServer"
  )
