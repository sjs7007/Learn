
import akka.actor._ 

object HelloRemote extends App {
  val system = ActorSystem("HelloRemoteSystem") //to use actor boiler plate
  val remoteActor = system.actorOf(Props[RemoteActor], name="RemoteActor") //create actor of type RemoteActor
  remoteActor ! "The RemoteActor is alive" //send string to remote actor
}

class RemoteActor extends Actor {
  def receive = {
    case msg: String => //on receiveing any string
      println(s"RemoteActor received message '$msg'")
  //    sender ! "Hello from the RemoteActor" //send hello msg back 
  }
}



