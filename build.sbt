organization := "tv.cntt"
name         := "xitrum-new"
version      := "1.0-SNAPSHOT"

scalaVersion := "2.12.13"

// Xitrum requires Java 8
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

//------------------------------------------------------------------------------

libraryDependencies += "tv.cntt" %% "xitrum" % "3.30.1"

// Xitrum uses SLF4J, an implementation of SLF4J is needed
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

// For writing condition in logback.xml
libraryDependencies += "org.codehaus.janino" % "janino" % "3.1.2"


libraryDependencies += "io.kamon" %% "kamon-core" % "2.5.0"
libraryDependencies += "io.kamon" %% "kamon-status-page" % "2.5.0"
libraryDependencies += "io.kamon" %% "kamon-prometheus" % "2.5.0"
libraryDependencies += "io.kamon" %% "kamon-system-metrics" % "2.5.0"
libraryDependencies += "io.kamon" %% "kamon-akka" % "2.5.0"
libraryDependencies += "io.kamon" %% "kamon-akka-http" % "2.5.0"

libraryDependencies += "org.squeryl" %% "squeryl" % "0.9.17"

val AkkaVersion = "2.6.11"
val AkkaHttpVersion = "10.2.10"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.10",
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true
addCompilerPlugin("tv.cntt" %% "xgettext" % "1.5.4")
scalacOptions += "-P:xgettext:xitrum.I18n"

// Put config directory in classpath for easier development --------------------

// For "sbt console"
unmanagedClasspath in Compile += baseDirectory.value / "config"

// For "sbt fgRun"
unmanagedClasspath in Runtime += baseDirectory.value / "config"

// Copy these to target/xitrum when sbt xitrum-package is run
XitrumPackage.copy("config", "public", "script")
