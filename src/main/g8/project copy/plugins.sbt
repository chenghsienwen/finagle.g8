resolvers += "quadas repo" at "http://nexus.vpon.com/content/groups/public/"


addSbtPlugin("org.scalariform"    % "sbt-scalariform"     % "1.8.3")
addSbtPlugin("pl.project13.scala" % "sbt-jmh"             % "0.3.7")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"       % "1.6.0" )
addSbtPlugin("com.typesafe.sbt"   % "sbt-native-packager" % "1.3.4" )
addSbtPlugin("org.wartremover"    % "sbt-wartremover"     % "2.4.3" )
addSbtPlugin("com.github.gseitz"  % "sbt-release"         % "1.0.12" )
addSbtPlugin("com.timushev.sbt"   % "sbt-updates"         % "0.3.1" )
addSbtPlugin("net.virtual-void"   % "sbt-dependency-graph" % "0.10.0-RC1")
// addSbtPlugin("com.quadas"         % "sbt-buildinfo"       % "1.0"      )


