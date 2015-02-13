package models

/**
 * Created by achau on 2/12/15.
 */
case class Location(
                   addresses: List[String],
                   city: String,
                   country_code: String,
                   cross_streets: String,
                   display_addresses: List[String],
                   neighborhoods: List[String],
                   postal_code: String,
                   state_code: String
                     )
