
name := "bug::ConfigFactory"
scalaVersion in Global := "2.12.4"

val akkaVersion = "2.5.6"
libraryDependencies in Global ++= Seq(
  "com.typesafe.akka" %% "akka-actor"  % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion
)


lazy val backend  = project in file("backend")
lazy val frontend = project in file("frontend")
