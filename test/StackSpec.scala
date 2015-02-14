import models.Location
import play.api.mvc.{Result, SimpleResult}
import play.api.test.FakeRequest

import collection.mutable.Stack
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play._
import org.mockito.Mockito._
import controllers.Application

import scala.concurrent.Future
import play.api.test.Helpers._

class StackSpec extends PlaySpec with MockitoSugar {

  case class Role(name:String)

  case class User(id: String, name: String, email:String)

  trait UserRepository {
    def roles(user:User) : Set[Role]
  }

  case class Data(retrievalDate: java.util.Date)

  trait DataService {
    def findData: Data
  }


  "A Stack" must {
    "pop values in last-in-first-out order" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() mustBe 2
      stack.pop() mustBe 1
    }
    "throw NoSuchElementException if an empty stack is popped" in {
      val emptyStack = new Stack[Int]
      a [NoSuchElementException] must be thrownBy {
        emptyStack.pop()
      }
    }
  }

  "Example Page#index" should {
    "should be valid" in {
      val result: Future[Result] = controllers.Application.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "ok"
    }
  }

}