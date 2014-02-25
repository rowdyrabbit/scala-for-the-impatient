//Exercise 1
{
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with chapter10.RectangleLike
  println("before changing: " + egg)
  egg.translate(10, -10)
  println("after translating: " + egg)
  egg.grow(10, 20)
  println("after growing: " + egg)
}




