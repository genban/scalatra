package database

import slick.driver.MySQLDriver.api._

/**
  * Created by GuoPC on 16/4/26.
  */
trait MysqlSupport {

  lazy val db = Database.forURL("jdbc:mysql://localhost:3306/tmp?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf8",
    user = "root",
    password = "",
    driver = "com.mysql.jdbc.Driver",
    executor = AsyncExecutor("user1", numThreads = 10, queueSize = 1000))

}
