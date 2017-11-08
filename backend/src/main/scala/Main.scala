import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Simple extends Actor {
  def receive = {
    case m => println(s"received $m")
  }
}

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
    |       port = 2551
    |     }
    |   }
    | }
  """.stripMargin)

  println(config.getString("akka.remote.netty.tcp.hostname"))
  println(config.getInt("akka.remote.netty.tcp.port"))
  val backend = ActorSystem("backend", config)

  val simple = backend.actorOf(Props[Simple], "simple")
}
