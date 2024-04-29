package Devices

class Lamp(var brightness: Int, var on: Boolean) {
  def turnOn(): Unit = on = true
  def turnOff(): Unit = on = false

  def setBrightness(brightness: Int): Unit = this.brightness = math.max(math.min(brightness, 8000), 0)
}
