package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.util.Random
import play.api.libs.json.Json

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be
    * called when the application receives a `GET` request with a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  final val positiveProverbs: List[String] = List(
    "The beauty of the soul is known in the face.",
    "The face is the index of the mind.",
    "Look before you leap.",
    "No man was ever ruined by being cursed.",
    "Knowledge is power.",
    "A friend in need is a friend indeed.",
    "Where there is a will, there is a way.",
    "Every cloud has a silver lining.",
    "Hard work pays off.",
    "The early bird catches the worm.",
    "A GOOD DAY"
  )

  private val logger: Logger = Logger(this.getClass())
  def randomProverb() = Action { implicit request: Request[AnyContent] =>
    logger.info("available routes GET('/','/proverbs')")
    logger.debug("randomProverb accessed")
    val randomNum = Random.between(0, positiveProverbs.length)
    val jsEngProverb = Json.obj("Proverb" -> positiveProverbs(randomNum))
    Ok(jsEngProverb).as("application/json")

  }
  def proverbs() = Action { implicit request: Request[AnyContent] =>
    logger.debug("proverbs accessed")

    val jsEngProverb = Json.obj("Proverbs" -> positiveProverbs)
    Ok(jsEngProverb).as("application/json")

  }

}
