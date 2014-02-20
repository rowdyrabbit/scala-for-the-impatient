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

  }

  class LabeledPoint(val description: String, x: Double, y: Double) extends Point(x, y) {

  }

  val point = new LabeledPoint("home", 3.45566, 1.22333)
  println("created point: " + point.description + " with coordinates x="+point.x+" and y="+point.y)
}












