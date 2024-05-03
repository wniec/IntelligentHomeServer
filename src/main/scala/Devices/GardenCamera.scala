package Devices

import com.zeroc.Ice.Current

class GardenCamera(override val maxZoom: Double, override val minZoom: Double, var infrared: Boolean) extends Camera(0,0,maxZoom,minZoom, 2) with generated.GardenCamera{
  def turnInfraredOn(current: Current): Unit ={
    println("INFRARED MODE IS ON")
    infrared = true
  }
  def turnInfraredOff(current: Current): Unit ={
    println("INFRARED MODE IS OFF")
    infrared = false
  }
}
