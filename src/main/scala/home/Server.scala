package home

import Devices.{Camera, CentralHeating, Fridge, Garage, GardenCamera, Lamp}
import com.zeroc.Ice.{Communicator, Identity, Util}

import scala.collection.mutable
class Server(val name: String, val endpoints: String){
  def run(args: Array[String]): Unit ={
    var status = 0
    var communicator: Communicator = null
    try{
      communicator = Util.initialize(args)
      println(endpoints)
      val adapter = communicator.createObjectAdapterWithEndpoints(name, endpoints)

      val cameraServant = new Camera(1,2,20,1,3)
      val fridgeServant = new Fridge(mutable.Map[String, Int]())
      val heatingServant = new CentralHeating(18.0,16.0, true)
      val garageServant = new Garage(false)
      val gardenCameraServant = new GardenCamera(20,2,true)
      val lampServants = (1 to 20).map((_:Int) => new Lamp(4000,false))

      adapter.add(cameraServant, new Identity("camera", "camera"))
      adapter.add(fridgeServant, new Identity("fridge", "fridge"))
      adapter.add(heatingServant, new Identity("heating", "heating"))
      adapter.add(garageServant, new Identity("garage", "garage"))
      adapter.add(gardenCameraServant, new Identity("garden", "garden"))

      lampServants.zip(1 to lampServants.size).foreach((pair: (Lamp, Int)) =>{
        adapter.add(pair._1,new Identity(pair._2.toString,"lamp"))
      })

      adapter.activate()
      System.out.println(name+" entering event processing loop...")

      communicator.waitForShutdown()
    }
    catch{
      case e: Exception =>
        e.printStackTrace(System.err)
      status = 1
    }
    if (communicator != null) {

      try communicator.destroy()
      catch {
      case e: Exception =>
        e.printStackTrace(System.err)
        status = 1
    }
    }
    System.exit(status)
  }
}