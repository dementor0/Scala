package com.example.dmtr

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route

import scala.concurrent.Future
import UserRegistry._
import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.AskPattern._
import akka.util.Timeout

//#import-json-formats
//#user-routes-class
class UserRoutes(userRegistry: ActorRef[UserRegistry.Command])(implicit
    val system: ActorSystem[_]
) {

  //#user-routes-class
  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import JsonFormats._
  //#import-json-formats

  // If ask takes more time than this to complete the request is failed
  private implicit val timeout = Timeout.create(
    system.settings.config.getDuration("my-app.routes.ask-timeout")
  )

  def getUsers(): Future[Users] =
    userRegistry.ask(GetUsers)
  def getUser(name: String): Future[GetUserResponse] =
    userRegistry.ask(GetUser(name, _))
  def createUser(user: User): Future[ActionPerformed] =
    userRegistry.ask(CreateUser(user, _))
  def deleteUser(name: String): Future[ActionPerformed] =
    userRegistry.ask(DeleteUser(name, _))

  //#all-routes
  //#users-get-post
  //#users-get-delete
  val userRoutes: Route = {
    //путь который используется для сопоставления входящего запроса
    pathPrefix("users") {
      concat(
        //используется на внутреннем уровне чтобы отличать полностью согласованный путь от альтернатив в этом случае будет соответствовать "Users"

        pathEnd {
          concat(                                               //обьединяет 2 или более маршрутов
            get {                                               //метод get - получение всех пользователей
              complete(getUsers())
            },
            post {                                              //метод post
              entity(as[User]) { user =>                        //entity - преобразовывает тело запроса в обьект типа user
                onSuccess(createUser(user)) { performed =>
                  complete((StatusCodes.Created, performed))
                }
              }
            }
          )
        },
        //#users-get-delete
        //#users-get-post
        path(Segment) { name =>
          concat(
            get {                                               //метод get - получить одного пользователя
              //#retrieve-user-info
              rejectEmptyResponse {                           //разворачивает future, возвращает код состояния HTTP 404 для NONE и в случае ошибки передает ExeptoinHandler, который возвращает HTTP код состояния 500 по умолчанию
                onSuccess(getUser(name)) { response =>
                  complete(response.maybeUser)
                }
              }
              //#retrieve-user-info
            },
            delete {                                            //метод delete - удаление пользователя
              //#users-delete-logic
              onSuccess(deleteUser(name)) { performed =>
                complete((StatusCodes.OK, performed))
              }
              //#users-delete-logic
            }
          )
        }
      )
      //#users-get-delete
    }
  }
  //#all-routes
}
