package quickstart.action

import xitrum.FutureAction
import xitrum.annotation.GET

@GET("")
class SiteIndex extends FutureAction {
  def execute(): Unit = {
    respondText("Hello from xitrum")
  }
}
