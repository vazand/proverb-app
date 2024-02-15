# App info
This is a proverb app. currently it contains 11 positive proverbs. we can get a random solo proverb using (GET /) and can get all of them using (GET /proverbs) as Json.   

# SBT docker packaging 

Here I have used [sbt-native-packager](https://www.scala-sbt.org/sbt-native-packager/) for docker packaging,
I'm using playframework so it's already configured.

# To build the image you can use:
### Terminal
> sbt
### in sbt console 
    > compile
    > Docker / stage
    > Docker / publishLocal
This will create a local docker image with name `packageName+version`

### important env's (For production version )
    >APPLICATION_SECRET
    >HTTP_PORT

### for setting docker env variables we can use like this (in build.sbt)
dockerEnvVars ++= Map(
  ("APPLICATION_SECRET", "mysecretKey1234567890-!@#$%^&*()_"),
  ("HTTP_PORT", "9500")
)

### other docker configs (in build.sbt)

dockerBaseImage := "openjdk:11-jre"

Docker / packageName := "proverb-app"


## For running the app using docker

>docker run --rm -p 9500:9500 --name myProverbApp proverb-app:1.0.1
>
here,
  - --rm will remove the container when exit.
  - ImageName -> proverb-app:1.0.1
  - ContainerName -> myProverbApp


# Continuous Integration Continuous Deployment(CICD)

Here I'm using Jenkins for automating the CICD
Continuous Integration(CI) Steps:

    > Build
    > Test
    > Package
    > Storing Package (ex: docker hub/nexus,github)

Continuous Deployment(CD):

    > Get package From Storage (ex: docker hub/nexus,github)
    > Publish to Production Environment
