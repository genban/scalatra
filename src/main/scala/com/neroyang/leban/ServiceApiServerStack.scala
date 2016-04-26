package com.neroyang.leban

import database.MysqlSupport
import org.json4s.native.Serialization
import org.json4s.{Formats, NoTypeHints}
import org.scalatra.json.NativeJsonSupport
import org.scalatra.scalate.ScalateSupport
import org.scalatra.{FutureSupport, ScalatraServlet}

/**
  * Created by GuoPC on 16/4/26.
  */
trait ServiceApiServerStack extends ScalatraServlet with ScalateSupport with NativeJsonSupport with MysqlSupport with FutureSupport {

  /* wire up the precompiled templates */

  protected implicit val jsonFormats: Formats = Serialization.formats(NoTypeHints)

  protected implicit val executor: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global


  before() {
    contentType = "application/json; charset=utf-8"
  }



  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }


}
