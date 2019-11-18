name := s"${(name in Global).value}-core"

resolvers ++= Seq(
  "vpon rel" at "http://nexus.vpon.com/content/repositories/releases/",
  "vpon dev" at "http://nexus.vpon.com/content/repositories/developments/",
  Resolver.bintrayRepo("vpon", "maven"),
  "twitter-repo" at "https://maven.twttr.com/"
)

libraryDependencies ++= Seq(
  "com.quadas" %% "dsp-retargeting-common" % "271_e73b048",
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.13",
  "com.quadas.quest" %% "akka" % "0.7",
  "com.quadas.quest" %% "quadas-server" % "0.7"
)
