package Devices

import com.zeroc.Ice.Current

class Garage(var is_opened: Boolean) extends generated.Garage{
  override def open(current: Current): Unit ={
    is_opened = true
    println("GARAGE IS BEING OPENED")
  }
  override def close(current: Current): Unit = {
    is_opened = false
    println("GARAGE IS BEING CLOSED")
  }
  override def isOpen(current: Current): Boolean = is_opened
}
