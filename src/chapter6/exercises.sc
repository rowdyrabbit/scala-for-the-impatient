//Exercise 1
object Conversions {

  def inchesToCentimeter(inches: Double) = {
    inches * 2.54
  }

  def gallonsToLiter(gallons: Double) = {
     gallons * 3.78541
  }

  def milesToKilometre(miles: Double) = {
     miles * 1.609344
  }
}
println("2 inches is: "+Conversions.inchesToCentimeter(2)+ "cm")
println("1 gallon is: "+Conversions.gallonsToLiter(1)+ "L")
println("13.1 miles is: "+Conversions.milesToKilometre(13.1)+ "km")

//Exercise 2
abstract class UnitConversion(conversionFactor: Double) {
  def convert(value: Double): Double = value * conversionFactor
}

object InchesToCentimeter extends UnitConversion(2.54)
object GallonsToLiter extends UnitConversion(3.78541)
object MilesToKilometre extends UnitConversion(1.609344)

println("2 inches is: "+InchesToCentimeter.convert(2)+ "cm")
println("1 gallon is: "+GallonsToLiter.convert(1)+ "L")
println("13.1 miles is: "+MilesToKilometre.convert(13.1)+ "km")

//Exercise 3
object Origin extends java.awt.Point
//This is not actually a good idea as the Point class contains mutator methods (Origin.setLocation(2,2)) which can
//change the coordinates of the point, thereby changing the 'origin'. These methods can also be called from anywhere
//leading to issues with concurrency as well as making the state of the object more difficult to reason about

//Exercise 4
class Point(x: Int, y: Int)
object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}




//Exercise 5
object Reverse extends App {
  val reverseArgs = args.reverse

  for (i <-0 until reverseArgs.size) {
    print(reverseArgs(i)+ " ")
  }
}
Reverse.main(Array("Hello", "World"))

//Exercise 6
object PlayingSuits extends Enumeration {
  val Clubs = Value( "\u2663")
  val Diamonds = Value("\u2666")
  val Hearts = Value("\u2665")
  val Spades = Value("\u2660")
}

println(PlayingSuits.values)

//Exercise 7
def isRed(suit: PlayingSuits.Value) : Boolean = {
  if (suit == PlayingSuits.Hearts || suit == PlayingSuits.Diamonds) true
  else false
}
isRed(PlayingSuits.Diamonds)
//Exercise 8
object RGBColorCube extends Enumeration {
  val White = Value(0xFFFFFF)
  val Red = Value(0x0000FF)
  val Green = Value(0x00FF00)
  val Blue = Value(0xFF0000)
  val Cyan = Value(0xFFFF00)
  val Magenta = Value(0xFF00FF)
  val Yellow = Value(0x00FFFF)
  val Black = Value(0x000000)
}
for (color <- RGBColorCube.values) {
  println(color.id)
}









