package com.vpon

import com.quadas.conn.{ AerospikeConfig, AerospikeHost }
import com.quadas.quest.server.QuadasServer
import com.typesafe.config.ConfigValueFactory
import com.twitter.finagle.{Service, SimpleFilter}
import org.jboss.netty.handler.codec.http._
import com.twitter.util.Future
import org.jboss.netty.handler.codec.http.HttpResponseStatus._
import org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1
import org.jboss.netty.buffer.ChannelBuffers.copiedBuffer
import org.jboss.netty.util.CharsetUtil.UTF_8
import com.twitter.finagle.builder.{Server, ServerBuilder}
import com.twitter.finagle.http.Http
import java.net.InetSocketAddress

object Main extends QuadasServer {

  class Respond extends Service[HttpRequest, HttpResponse] {
    def apply(request: HttpRequest) = {
      val response = new DefaultHttpResponse(HTTP_1_1, OK)
      response.setContent(copiedBuffer("I'm a Simple HTTP Server powered by Twitter's Finagle", UTF_8))
      Future.value(response)
    }
  }

  def main(args: Array[String]) {

    val respond = new Respond

    val myService: Service[HttpRequest, HttpResponse] =  respond

    val server: Server = ServerBuilder()
      .codec(Http())
      .bindTo(new InetSocketAddress(8080))
      .name("httpserver")
      .build(myService)
  }
}

