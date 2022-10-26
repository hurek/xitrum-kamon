package quickstart.action

import xitrum.FutureAction
import xitrum.annotation.{Error404, Error500}

@Error404
class NotFoundError extends FutureAction{
  def execute(): Unit = {
    respondText("Not found")
  }
}

@Error500
class ServerError extends FutureAction {
  def execute(): Unit = {
    respondText("Server error")
  }
}
