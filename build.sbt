name  := "scala-pet-store"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.8"
crossScalaVersions := Seq("2.12.8", "2.13.0")

resolvers += Resolver.sonatypeRepo("snapshots")

val CatsVersion = "1.6.1"
val CirceVersion = "0.11.1"
val CirceConfigVersion = "0.6.1"
val DoobieVersion = "0.7.0"
val EnumeratumCirceVersion = "1.5.21"
val H2Version = "1.4.199"
val Http4sVersion = "0.20.1"
val KindProjectorVersion = "0.9.9"
val LogbackVersion = "1.2.3"
val ScalaCheckVersion = "1.14.0"
val ScalaTestVersion = "3.0.7"
val FlywayVersion = "5.2.4"
val TsecVersion = "0.1.0"

libraryDependencies ++= Seq(
  "org.typelevel"   %% "cats-core" % CatsVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-literal" % CirceVersion,
  "io.circe" %% "circe-generic-extras" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion,
  "io.circe" %% "circe-config" % CirceConfigVersion,
  "org.tpolecat" %% "doobie-core" % DoobieVersion,
  "org.tpolecat" %% "doobie-h2" % DoobieVersion,
  "org.tpolecat" %% "doobie-scalatest" % DoobieVersion,
  "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
  "com.beachape" %% "enumeratum-circe" % EnumeratumCirceVersion,
  "com.h2database" %% "h2" % H2Version,
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "ch.qos.logback" % "logback-classic" % LogbackVersion,
  "org.flywaydb" % "flyway-core" % FlywayVersion,
  "org.http4s" %% "http4s-blaze-client" % Http4sVersion % Test, 
  "org.scalacheck" %% "scalacheck" % ScalaCheckVersion % Test,
  "org.scalatest" %% "scalatest" % ScalaTestVersion % Test,
  
  // Authentication dependencies
  "io.github.jmcardon" %% "tsec-common"
  "io.github.jmcardon" %% "tsec-password"
  "io.github.jmcardon" %% "tsec-mac"
  "io.github.jmcardon" %% "tsec-signatures"
  "io.github.jmcardon" %% "tsec-jwt-mac"
  "io.github.jmcardon" %% "tsec-jwt-sig"
  "io.github.jmcardon" %% "tsec-http4s"
)

def scalacOptionsForVersion(version: String): Seq[String] = {
  // format: off
  val defaultOpts = Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs
    "-encoding", "utf-8" // Specify character encoding used by source files
    "-explaintypes", // Explain type errors in more details
    "-feature", // Emit warning and location for usages of features that should be imported explicitly
    "language:existentials" // Existential types (besides wildcard types) can be written and inferred
    "-language:experimental.macros", // Allow macro definition (besides implementation and application)
    "-language:higherKinds", // Allow higher-kinded types
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-unchecked", // Enable additional warnings where generated code depends on assumptions
  )
}













