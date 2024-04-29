package Home
import Devices.{Camera, CentralHeating, Fridge, Garage, GardenCamera, Lamp}
import com.zeroc.Ice.Current

import java.util

class Home  extends Home.HomeServer{
  val cameras: Array[Camera]
  val gardenCameras: Array[GardenCamera]
  val centralHeating: CentralHeating
  val fridge: Fridge
  val garage: Garage
  val lamps: Array[Lamp]

  override def move(what: String, x: Double, y: Double, current: Current): Unit = {
    what match {
      case "camera" => println("LOL")
      case "gardenCamera" => println("LOL")
    }
  }

  override def set(what: String, value: Double, current: Current): Unit = {

  }

  override def perform(op: operation, b1: Short, current: Current): Unit = {

  }
  override def list(): String = {
  }

  def put(where: String, what: Map[String, Integer], current: Current): Unit={

  }
}
