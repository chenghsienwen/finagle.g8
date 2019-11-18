package com.vpon

import com.quadas.conn.{ AerospikeConfig, AerospikeHost }
import com.quadas.quest.server.QuadasServer
import com.typesafe.config.ConfigValueFactory
import com.twitter.finagle.{ Service, SimpleFilter }
import org.jboss.netty.handler.codec.http._
import com.twitter.util.Future
import org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1
import org.jboss.netty.buffer.ChannelBuffers.copiedBuffer
import org.jboss.netty.util.CharsetUtil.UTF_8
import com.twitter.finagle.builder.{ Server, ServerBuilder }
import com.twitter.finagle.http.{ Http, Request, Response, Status }
import java.net.InetSocketAddress

object Main extends QuadasServer {

  class Respond extends Service[Request, Response] {
    def apply(request: Request) = {
      Future.value(
        Response(request.version, Status.Ok))
    }
  }

  val respond = new Respond

  val myService: Service[Request, Response] = respond

  val server: Server = ServerBuilder()
    .codec(Http())
    .bindTo(new InetSocketAddress(8080))
    .name("httpserver")
    .build(myService)

}

