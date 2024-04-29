import scala.collection.mutable
class Fridge(val products:mutable.Map[String, Int], var temperature: Float = 4) {
  def put(product: String): Unit = {
    if(products.contains(product))
      products(product) += 1
    else
      products(product) = 1
  }
  def take(product: String): Unit = {
    if(products(product) > 1)
      products(product) -= 1
    else
      products.remove(product)
  }
  def setTemperature(temperature: Int):Unit={
    if(0 <= temperature && temperature <= 8){
      this.temperature = temperature
    }
    else
      throw throw new Exception("temperature in Fridge must be between 0 and 8 Celsius Degrees")
  }
}
