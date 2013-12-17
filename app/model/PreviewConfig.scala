package model

import play.api.libs.json.{JsValue, Reads}
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class PreviewConfig(name: String, intro: String, description: String)

object PreviewConfig {
  implicit val jsonReads: Reads[PreviewConfig] = (
    (__ \ "name").read[String] and
      (__ \ "intro").read[String] and
      (__ \ "description").read[String]
    )(PreviewConfig.apply _)
}
