package controllers

import play.api._
import play.api.mvc._
import model.PreviewConfig

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(PreviewConfig("Someone Special", "Fast and Furious", "The winning combination!")))
  }

  def update = Action { request =>
    val j = request.body.asJson.get
    val obj = j.as[PreviewConfig]
    System.out.println("updated obj:" + obj)
    Ok("")
  }
}