name := s"${(name in Global).value}tests"

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.2",
  "org.scalatest" %% "scalatest" % "3.0.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.11",
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.4.11",
  "org.mockito" % "mockito-core" % "1.10.19"
)
