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
