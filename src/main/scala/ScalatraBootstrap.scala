import com.neroyang.leban._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new ApiServlet, "/*")
  }
}

//curl --include --request POST --header "Content-type: application/json" --data '{"name":"测试","age":18}' http://localhost:8080/users
