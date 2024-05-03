package Devices

import com.zeroc.Ice.Current

class Lamp(var brightness: Int, var on: Boolean) extends generated.Lamp{
  def turnOn(current: Current): Unit = on = true
  def turnOff(current: Current): Unit = on = false
  def isOn(current: Current): Boolean = on

  def setBrightness(lumens: Int, current: Current): Unit = this.brightness = math.max(math.min(lumens, 8000), 0)
}
