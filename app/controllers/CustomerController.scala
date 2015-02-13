package controllers

import models.{Restaurant, Location}
import play.api.libs.json.Json
import play.api.mvc._

object CustomerController extends Controller {

  implicit val locationWrites = Json.writes[Location]

  implicit val restaurantWrites = Json.writes[Restaurant]

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def getRestaurantById(id: Long) = Action { implicit request =>
    val loc1 = Location(List("address 1"), "Berkeley", "US", "Channing & College", List("address 1"), List("neighborhood1"), "95012", "CA")
    val rest1 = Restaurant(1, "Joshayas", List("imgurl1"), List("categories"), 123123, 2, List("9:00am to 5:00pm"), "6503949133", loc1, "10 miles")
    Ok(Json.toJson(rest1))
  }

  def getRestaurantsFromSearch(term: Option[String], limit: Option[Long], category_filter: Option[String], cll: Option[String], location: Option[String]) =  Action { implicit request =>
    val loc1 = Location(List("address 1"), "Berkeley", "US", "Channing & College", List("address 1"), List("neighborhood1"), "95012", "CA")
    val rest1 = Restaurant(1, "Joshayas", List("imgurl1"), List("categories"), 123123, 2, List("9:00am to 5:00pm"), "6503949133", loc1, "10 miles")
    Ok(Json.arr(Json.toJson(rest1), Json.toJson(rest1)))
  }

  def registerForRestaurant(id: Long) = Action { implicit request =>
    id match {
      case 1 =>
        Ok(Json.obj("response" -> "successfully registered"))
      case _ =>
        BadRequest(Json.obj("response" -> "failed to register"))
    }
  }

  def getCurrentWaitlist = Action { implicit request =>
    val loc1 = Location(List("address 1"), "Berkeley", "US", "Channing & College", List("address 1"), List("neighborhood1"), "95012", "CA")
    val rest1 = Restaurant(1, "Joshayas", List("imgurl1"), List("categories"), 123123, 2, List("9:00am to 5:00pm"), "6503949133", loc1, "10 miles")
    Ok(Json.obj("restaurant" -> Json.toJson(rest1), "current_waittime" -> 23*1000*60))
  }

  def getCustomerInfo = Action { implicit request =>
    Ok(
      Json.obj(
        "id" -> 1,
        "full_name" -> "Kevin Xie",
        "facebook_id" -> 123131234,
        "email" -> "xiekevin@gmail.com",
        "avatar_url" -> "cats.com",
        "phone_number" -> "4082344321",
        "settings_id" -> 23
      )
    )
  }
}