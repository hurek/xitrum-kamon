package quickstart

import kamon.Kamon
import org.squeryl.PrimitiveTypeMode
import xitrum.Server

object Boot {
  def main(args: Array[String]): Unit = {
    Kamon.init()
    BootRunner.main(args)
  }
}

object BootRunner extends App with PrimitiveTypeMode {
  override def main(args: Array[String]): Unit = {
    Server.start()
    Server.stopAtShutdown()
  }
}
