package com.neroyang.leban

import dbslick_huodong.{User, UserDao}

import scala.util.{Failure, Success, Try}

class ApiServlet extends ServiceApiServerStack {

  import org.json4s.JsonDSL._
  import org.json4s.native.Serialization.read

  post("/users") {
    Try {
      val user = read[User](request.body)
      db.run(UserDao insertOrUpdate user) onComplete {
        case Success(e) => render("success" -> "true")
        case Failure(e) => render("success" -> "false")
      }
    }.getOrElse(render("error" -> "参数不匹配!"))
  }


  //    post("/baoming") {
  //      val newperson = Map("id" -> 1,
  //        "myschool" -> params("Myschool"),
  //        "myname" -> params("Myname"),
  //        "mynum" -> params("Mynum"),
  //        "mysex" -> params("Mysex"),
  //        "mywechat" -> params("Mywechat"),
  //        "date1" -> params("date1"),
  //        "date2" -> params("date2"),
  //        "date3" -> params("date3"),
  //        "masterword" -> params("Masterword"),
  //        "servantword" -> params("Servantword"),
  //        "matchid" -> 0)
  //      Database
  //        .forConfig("h2mem1")
  //        .run(Person
  //          .map(p =>
  //            (p.id, p.myschool, p.myname, p.mynum, p.mysex, p.mywechat, p.date1, p.date2, p.date3, p.masterword, p.servantword, p.matchid)) +=(newperson.get("id"), newperson.get("myschool"), newperson.get("myname"), newperson.get("mynum"), newperson.get("mysex"), newperson.get("mywechat"), newperson.get("date1"), newperson.get("date2"), newperson.get("date3"), newperson.get("masterword"), newperson.get("servantword"), newperson.get("matchid")))
  //    }
  //  override def error(handler: ErrorHandler): Unit = ???
}
