name := """Proverb-App"""
organization := "com.cyberxpert"
maintainer := "vazandvel@gmail.com"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(
  PlayScala,
  DockerPlugin,
  JavaAppPackaging
)

scalaVersion := "2.13.12"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
PlayKeys.devSettings := Seq("play.server.http.port" -> "9500")

dockerExposedPorts ++= Seq(9500)
dockerEnvVars ++= Map(
  ("APPLICATION_SECRET", "mysecretKey1234567890-!@#$%^&*()_"),
  ("HTTP_PORT", "9500")
)

Docker / packageName := "proverb-app"
Docker  / version := "1.0.1"
dockerBaseImage := "openjdk:11-jre"
Docker / maintainer := "https://github.com/vazand"
Docker / description := {
  """This is a sbt docker image example. 
  available routes GET / and GET /proverbs. """

}
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.cyberxpert.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.cyberxpert.binders._"
