package Devices

import com.zeroc.Ice.Current

import java.util
import scala.collection.mutable
import scala.jdk.CollectionConverters.MapHasAsJava
class Fridge(val products:mutable.Map[String, Int], var temperature: Double = 4.0) extends generated.Fridge{
  override def put(product: String, amount: Int, current: Current): Unit = {
    if(products.contains(product))
      products(product) += amount
    else
      products(product) = amount
  }
  override def take(product: String, amount: Int, current: Current): Unit = {
    if(products(product) > amount)
      products(product) -= amount
    else if(products(product) == amount)
      products.remove(product)
    else
      throw new Exception("THERE IS NOTHING TO TAKE")
  }
  override def setTemperature(temperature: Double, current: Current):Unit={
    if(0 <= temperature && temperature <= 8){
      this.temperature = temperature
    }
    else
      throw new Exception("TEMPERATURE IN FRIDGE MUST BE BETWEEN 0 AND 8 CELSIUS DEGREES")
  }

  override def list(current: Current): util.Map[String, Integer] = {
    products.map((kv:(String, Int)) => (kv._1,Integer.valueOf(kv._2))).asJava
  }
}
