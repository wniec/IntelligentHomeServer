package Devices

import com.zeroc.Ice.Current

class Lamp(var brightness: Int, var on: Boolean) extends generated.Lamp{
  def turnOn(current: Current): Unit = {
    println("LAMP TURNED ON")
    on = true
  }
  def turnOff(current: Current): Unit = {
    on = false
    println("LAMP TURNED OFF")
  }
  def isOn(current: Current): Boolean = on

  def setBrightness(lumens: Int, current: Current): Unit = {
    println(s"LAMP BRIGHTNESS SET TO $lumens")
    this.brightness = math.max(math.min(lumens, 8000), 0)
  }
}
