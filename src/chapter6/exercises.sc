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

  println("2 inches is: "+inchesToCentimeter(2)+ "cm")
  println("1 gallon is: "+gallonsToLiter(1)+ "L")
  println("13.1 miles is: "+milesToKilometre(13.1)+ "km")


}