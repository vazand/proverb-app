package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

//import play.api.mvc.Result
//import play.api.mvc.Results._
//import scala.util.Success
//import play.api.mvc.Results

class HomeControllerSpecs
    extends PlaySpec
    with GuiceOneAppPerTest
    with Injecting {

  "HomeController endpoints" should {
    "returns a result  Ok for /proverbs" in {
      val controller = new HomeController(Helpers.stubControllerComponents())
      val result = controller.proverbs().apply(FakeRequest(GET, "/proverbs"))
      println("--------------------------------------------")
      println(result)
      println("--------------------------------------------")
      contentType(result) mustBe Some("application/json")
      status(result) mustBe OK
    }

    "returns a result  Ok for /" in {
      val controller = new HomeController(Helpers.stubControllerComponents())
      val result = controller.randomProverb().apply(FakeRequest(GET, "/"))
      println("--------------------------------------------")
      println(contentAsString(result))
      println("--------------------------------------------")
      contentType(result) mustBe Some("application/json")
      contentAsJson(result)
      status(result) mustBe OK
    }
  }

}
