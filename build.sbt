
name         := "spark-play-activator"
organization := "com.dvgodoy"
version      := "0.0.1"
scalaVersion := Version.scala

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaSource in Compile <<= baseDirectory / "src/scala"

libraryDependencies ++= Dependencies.sparkAkkaHadoop

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4",
  "com.google.guava" % "guava" % "11.0.2"
)

releaseSettings

scalariformSettings

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
