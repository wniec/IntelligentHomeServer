package Devices

class GardenCamera(override val maxZoom: Double, override val minZoom: Double, var infrared: Boolean) extends Camera(0,0,maxZoom,minZoom, 2){
  def turnInfraredOn(): Unit ={
    infrared = true
  }
  def turnInfraredOff(): Unit ={
    infrared = false
  }
}
