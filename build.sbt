name := "CustomerBackend"

version := "1.0"

lazy val `customerbackend` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws,
  "org.scalatestplus" %% "play" % "1.1.0" % "test",
  "org.mockito" % "mockito-core" % "1.9.5")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  