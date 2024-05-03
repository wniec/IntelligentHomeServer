package home

object Main {
  def main(args: Array[String]):Unit={
    println("")
    println(args.last)
    val runargs = Seq(args.head).toArray
    if(args.last == "adapter=Adapter1"){
      val endpoints1 = "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z"
      val server1 = new Server("Adapter1", endpoints1)
      server1.run(runargs)
    }
    else if(args.last == "adapter=Adapter2"){
      val endpoints2 = "tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z"
      val server2 = new Server("Adapter2", endpoints2)
      server2.run(runargs)
    }

  }
}
