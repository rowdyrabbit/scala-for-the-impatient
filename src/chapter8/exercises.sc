//Exercise 1
{
  class BankAccount (initialBalance : Double ) {
    protected var balance = initialBalance

    def deposit (amount: Double) = {balance += amount; balance}
    def withdraw (amount: Double) = {balance -= amount; balance}
  }

  class CheckingAccount(initialBalance : Double )  extends BankAccount(initialBalance ) {
    override def deposit (amount: Double) = {super.deposit(amount -1)}
    override def withdraw (amount: Double) = {super.withdraw(amount +1)}
  }

  val checkAccnt = new CheckingAccount(50)
  println("after first deposit of $10, balance should be $59: "+checkAccnt.deposit(10))
  println("after subsequent withdrawal of $10, balance should be $48: "+checkAccnt.withdraw(10))

  //Exercise 2

  class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    var transactionCount = 0
    val interestRate = 1.04

    override def deposit(amount: Double) = {
      val balance = super.deposit(if (transactionCount < 3) amount else amount - 1)
      transactionCount += 1
      balance
    }

    override def withdraw(amount: Double) = {
      val balance = super.withdraw(if (transactionCount < 3) amount else amount + 1)
      transactionCount += 1
      balance
    }

    def earnMonthlyInterest() = {
      transactionCount = 0
      balance = balance * 1.04
    }
  }

  val savingAccount = new SavingsAccount(500)
  println("after first deposit, balance should be 550: "+savingAccount.deposit(50))
  println("after second deposit, balance should be 650: "+savingAccount.deposit(100))
  println("after third deposit, balance should be 700: "+savingAccount.deposit(50))
  println("after fourth deposit, fee should be charged and balance should be 749: "+savingAccount.deposit(50))
  savingAccount.earnMonthlyInterest()
}




















//Exercise 3
{
  abstract class Shape(shapeName: String) {
    val name = shapeName
    def canRoll(): Boolean
  }

  class Square extends Shape("square") {
    def canRoll(): Boolean = {
      false
    }
  }

  class Circle extends Shape("circle") {
    def canRoll() : Boolean = {
      true
    }
  }

  val square = new Square()
  val circle = new Circle()
  println("A square can roll = "+square.canRoll())
  println("A circle can roll = "+circle.canRoll())
}





//Exercise 4
{
  abstract class Item() {
    def price() : Double
    def description() : String
  }

  class SimpleItem(override val price: Double, override val description: String) extends Item {
  }

  class Bundle extends Item {
    private var items: List[Item] = List()
    def price: Double = {
      items.map(_.price).sum
    }
    def description: String = {
      items.map(_.description).mkString(" & ")
    }
    def add(item : Item) = {
      items = item :: items
    }
  }

  val simple = new SimpleItem(5.55, "caramel popcorn")
  println("created simple item: " + simple.description + " with price: "+simple.price)

  var bundle = new Bundle()
  bundle.add(new SimpleItem(4, "caramels"))
  bundle.add(new SimpleItem(3, "chocolate"))
  bundle.add(new SimpleItem(2.5, "fairy floss"))
  println("created bundle: " + bundle.description + " with total price: "+bundle.price)
}





//Exercise 5
{
  class Point(val x: Double, val y: Double) {
    override def toString: String = {
      "x=" + x + " & y=" + y
    }
  }
  class LabeledPoint(val description: String, x: Double, y: Double) extends Point(x, y) {
  }
  val point = new LabeledPoint("home", 3.45566, 1.22333)
  println("created point: " + point.description + " with coordinates x="+point.x+" and y="+point.y)

//Exercise 6
  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(val width: Double, val height: Double) extends Shape {
    def centerPoint: Point = {
      new Point(width/2, height/2)
    }
  }
  class Circle(val diameter: Double) extends Shape {
    def centerPoint: Point = {
      new Point(diameter/2, diameter/2)
    }
  }
  val rect = new Rectangle(50, 70)
  val circle = new Circle(100)
  println("rectangle centre is: "+rect.centerPoint)
  println("circle centre is: "+circle.centerPoint)
}








//Exercise 7
{
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width)    {
    def this(width: Int = 0)  {
      this(0,0,width)
    }
  }

  println(new Square)
  println(new Square(10))
  println(new Square(5,5,20))
}







//Exercise 8
//Compiled from "Person.scala"
//public class chapter8.Person extends java.lang.Object{
//  private final java.lang.String name;
//  public java.lang.String name();
//  public java.lang.String toString();
//  public chapter8.Person(java.lang.String);
//}

//Compiled from "SecretAgent.scala"
//public class chapter8.SecretAgent extends chapter8.Person{
//  private final java.lang.String name;
//  private final java.lang.String toString;
//  public java.lang.String name();
//  public java.lang.String toString();
//  public chapter8.SecretAgent(java.lang.String);
//}

















