name := """damp-wildwood-52313"""
organization := "pl.edu.pwr.bbk"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += jdbc

libraryDependencies += "org.webjars" % "bootstrap" % "4.0.0-2"
libraryDependencies += "org.webjars" % "font-awesome" % "5.0.9"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.2"
