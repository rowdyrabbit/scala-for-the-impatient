package chapter10

trait RectangleLike {

  def getX() : Double

  def getY() : Double

  def getWidth() : Double

  def getHeight() : Double

  def setFrame(x: Double, y: Double, width: Double, height: Double)


  def translate(x_offset: Double, y_offset: Double) = {
    setFrame(getX() + x_offset, getY() + y_offset, getWidth(), getHeight())
  }

  def grow(width_addition: Double, height_addition: Double) = {
    setFrame(getX(), getY(), getWidth() + width_addition, getHeight() + height_addition)
  }

  override def toString = {
    "x: " + getX() + " y: " + getY() + " width: " + getWidth() + " height: " + getHeight()
  }
}
