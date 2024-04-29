package Devices

class CentralHeating(var goalTemperature: Int, var currentTemperature: Int, var on: Boolean){
  def turnOn(): Unit = (on = true)
  def turnOff(): Unit = (on = false)
}
