package Devices

import com.zeroc.Ice.Current
import generated.InvalidArgument

class Camera(var phi: Double, var psi: Double, val maxZoom: Double, val minZoom: Double, var zoom: Double) extends generated.Camera {
  override def move(phi: Double, psi: Double, current: Current): Unit = {
    println(s"MOVING CAMERA TO $psi , $phi")
    turnVertically(psi)
    turnHorizontally(phi)
  }

  override def zoomIn(value: Double, current: Current): Unit = {
    if (this.zoom * value <= maxZoom)
      this.zoom *= value
    else
      throw new InvalidArgument("ZOOM EXCEEDS MAXIMUM ZOOM LIMIT")
  }

  override def zoomOut(value: Double, current: Current): Unit = {
    if (this.zoom / value >= minZoom)
      this.zoom /= value
    else
      throw new InvalidArgument("ZOOM EXCEEDS MINIMUM ZOOM LIMIT")
  }

  override def moveDetected(current: Current): Boolean = {
    val rand = new scala.util.Random
    println("CHECKING IF MOVE IS DETECTED")
    (rand.nextInt() % 2) > 0
  }

  private def turnHorizontally(phi: Double): Unit = {
    this.phi += phi
    while (this.phi > math.Pi * 2) {
      this.phi -= math.Pi * 2
    }
    while (this.phi < 0) {
      this.phi += math.Pi * 2
    }
  }

  private def turnVertically(psi: Double): Unit = {
    this.psi += psi
    while (this.psi > math.Pi * 2) {
      this.psi -= math.Pi * 2
    }
    while (this.psi < 0) {
      this.psi += math.Pi * 2
    }
  }
}
