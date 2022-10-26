package quickstart

import com.sun.jna.platform.mac.SystemB.Timezone
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
    super.main(args)
    // Init db with postgresqladapter and HikariDataSource (create session factory)
    Server.start()
    // do some init ops here
    // start schedulers
    Server.stopAtShutdown()

  }
}
