package local

import akka.actor._ 

object Local extends App {
  implicit val system = ActorSystem("LocalSystem") //http://alvinalexander.com/scala/scala-implicit-method-arguments-fields-example
  val localActor = system.actorOf(Props[LocalActor], name="LocalActor") //local actor
  localActor ! "START"

  }

class LocalActor extends Actor {

  //create remote actor
  val remote = context.actorFor("akka.tcp//HelloRemoteSystem@127.0.0.1:5150/user/RemoteActor")
  var counter=0

  def receive = {
    case "START" =>
      println("test hello from local to local")
      remote ! "Hello from Local Actor" // on receiving start message send hello
    //  remote ! "Hello from Local Actor" // on receiving start message send hello
    case msg : String => 
      println(s"LocalActor received Message : '$msg'")
      if(counter < 5) {
        sender ! "Hello back to you"
        counter += 1
      }
  }

}


