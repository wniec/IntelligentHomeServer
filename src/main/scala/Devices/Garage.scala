package Devices

class Garage(var carInside: Boolean){
  def driveIn(): Unit = {
    if(carInside)
      throw new Exception("Car is already in garage")
    else
      this.carInside = true
  }
  def driveOut(): Unit = {
    if(!carInside)
      throw new Exception("No Car in Devices.Garage to drive out")
    else
      this.carInside = false
  }

}
