package models

/**
 * Created by achau on 2/12/15.
 */
case class Restaurant(
                       id: Long,
                       name: String,
                       image_urls: List[String],
                       categories: List[String],
                       wait_time: Long,
                       price_rating: Long,
                       store_hours: List[String],
                       phone_number: String,
                       location: Location,
                       distance: String
                       )
