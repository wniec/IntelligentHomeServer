package Devices

import com.zeroc.Ice.Current

class CentralHeating(var goalTemperature: Double, var currentTemperature: Double, var on: Boolean) extends generated.CentralHeating{
  override def turnOn(current: Current): Unit = on = true
  override def turnOff(current: Current): Unit = on = false
  override def isOn(current: Current): Boolean = on
  override def setTemperature(temperature: Double, current: Current): Unit = goalTemperature = temperature
  override def getTemperature(current: Current): Double = currentTemperature
}
