package Devices

import com.zeroc.Ice.Current

class CentralHeating(var goalTemperature: Double, var currentTemperature: Double, var on: Boolean) extends generated.CentralHeating{
  override def turnOn(current: Current): Unit = {
    on = true
    println("CENTRAL HEATING IS STARTING")
  }
  override def turnOff(current: Current): Unit = {
    on = false
    println("CENTRAL HEATING IS TURNING OFF")
  }
  override def isOn(current: Current): Boolean = on
  override def setTemperature(temperature: Double, current: Current): Unit = {
    goalTemperature = temperature
    println(s"GOAL TEMPERATURE IS SET TO $temperature")
  }
  override def getTemperature(current: Current): Double = currentTemperature
}
