name := """Proverb-App"""
organization := "com.cyberxpert"
maintainer := "Vasanth <vazandvel@gmail.com>"
packageName := "proverb-app"
version := "1.0.1"
description := {
  """This is a sbt docker image example. available routes GET / and GET /proverbs. """

}
lazy val imageDescription = {
  """This  Dockerfile creates an image with the Proverb App running on it.The app provides two endpoints: one to get all proverbs, another to get a proverb"""
}

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

Docker / packageName := packageName.value
Docker / version := version.value
dockerBaseImage := "eclipse-temurin:17-jdk-jammy"
dockerExposedVolumes := Seq("/opt/docker/logs")
Docker / defaultLinuxInstallLocation := "/opt/docker"
dockerLabels := Map(
  "MAINTAINER" -> maintainer.value,
  "VENDOR" -> organization.value,
  "DESCRIPTION" -> description.value,
  "IMAGE_DESCRIPTION" -> imageDescription
)
// dockerUsername
// mappings in Docker := mappings.value
// Adds additional packages into Twirl
// TwirlKeys.templateImports += "com.cyberxpert.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.cyberxpert.binders._"
