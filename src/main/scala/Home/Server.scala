package Home

import com.zeroc.Ice.Util

object Server{
  def main(args: Array[String]): Unit = {
    val communicator = Util.initialize(args)
    println("Hello world!")
  }
}