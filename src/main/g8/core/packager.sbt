

import com.quadas.sbt.Settings._
import com.typesafe.sbt.packager.docker.Cmd
import sbt.IO

enablePlugins(JavaAppPackaging, DockerPlugin)

packageName in Universal := "app"
executableScriptName := "run.sh"
makeBatScripts := Seq.empty // Disable generating of .bat script
scriptClasspath := Seq("*")

/*
  Docker settings for the images used in uat
 */

dockerBaseImage := "bellsoft/liberica-openjre-alpine:8u212"
dockerUpdateLatest := false
dockerAlias := DockerAlias(dockerPublishRepo.value, dockerPublishUser.value, nameOfBranch.value, Some(buildNumber.value))
// prevent from error: "can't execute 'bash': No such file or directory"
dockerCommands := dockerCommands.value.flatMap {
  case cmd@Cmd("FROM", _) => List(cmd, Cmd("RUN", "apk add --update --no-cache bash"))
  case other => List(other)
}

/*
  More settings can come here. Please refer to http://www.scala-sbt.org/sbt-native-packager/formats/universal.html
 */



