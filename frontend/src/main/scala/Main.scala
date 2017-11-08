import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory


object Main extends App {
  // val config = ConfigFactory.load()
  val config = ConfigFactory.parseString("""  
    | akka {
    |   actor {
    |     provider = "akka.remote.RemoteActorRefProvider"
    |   }
    |
    |   remote {
    |     enabled-transports = ["akka.remote.netty.tcp"]
    |     netty.tcp {
    |       hostname = "0.0.0.0"
    |       port = 2552
    |     }
    |   }
    | }
  """.stripMargin)
  val frontend = ActorSystem("frontend", config)

  println(config.getString("akka.remote.netty.tcp.hostname"))
  println(config.getInt("akka.remote.netty.tcp.port"))

  val path = "akka.tcp://backend@0.0.0.0:2551/user/simple"
  val simple = frontend.actorSelection(path)

  simple ! "Hello Remote!"
}
