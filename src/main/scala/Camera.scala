class Camera(var phi: Double, var psi: Double, val maxZoom:Double, val minZoom: Double, var zoom: Double){
  def move_detected: Boolean= {
    val rand = new scala.util.Random
    (rand.nextInt()%2).asInstanceOf[Boolean]
  }
  def zoomIn(zoom: Double): Unit = {
    if(this.zoom + zoom <= maxZoom)
      this.zoom += zoom
    else
      throw new Exception("Zoom exceeds maximum zoom limit")
  }
  def zoomOut(zoom: Double): Unit = {
    if(this.zoom - zoom >= minZoom)
      this.zoom -= zoom
    else
      throw new Exception("Zoom exceeds minimum zoom limit")
  }

  def turnHorizontally(phi: Double): Unit = {
    this.phi += phi
    while(this.phi > math.Pi * 2){
      this.phi -= math.Pi * 2
    }
    while(this.phi < 0){
      this.phi += math.Pi * 2
    }
  }
  def turnVertically(psi: Double): Unit = {
    this.psi += psi
    while (this.psi > math.Pi * 2) {
      this.psi -= math.Pi * 2
    }
    while (this.psi < 0) {
      this.psi += math.Pi * 2
    }
  }
}
