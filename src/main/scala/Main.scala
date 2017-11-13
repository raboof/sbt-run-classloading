import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Main extends App {
  val config = ConfigFactory.load()
  ActorSystem("backend", config)
}
