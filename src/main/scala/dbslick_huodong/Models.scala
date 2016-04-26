package dbslick_huodong

import slick.driver.MySQLDriver.api._


/**
  * Created by GuoPC on 16/4/26.
  */

case class User(id: Option[Int], name: String, age: Int)

class UserTable(tag: Tag) extends Table[User](tag, "student") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name", O.SqlType("varchar(32) NOT NULL"))

  def age = column[Int]("age", O.SqlType("TINYINT NOT NULL"))


  override def * = (id.?, name, age) <>(User.tupled, User.unapply)
}

object UserDao {
  private lazy val query = TableQuery[UserTable]

  //  val usersAutoInc = users.map(u => (u.name, u.age)) returning users.map(_.id)

  def insertOrUpdate(u: User) = query insertOrUpdate u

}




