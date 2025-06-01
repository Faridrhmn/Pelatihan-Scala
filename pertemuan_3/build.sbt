ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "pertemuan_3",
      libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.6",
      libraryDependencies += "com.lihaoyi" %% "upickle" % "3.1.3"

  )
