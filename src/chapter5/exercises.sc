import scala.beans.BeanProperty

//Exercise 1
class Counter {
  private var value: Int = 0
  def increment() {
    if (value < Int.MaxValue) {
      value += 1
    }
  }
  def current() = value
}

val myCounter = new Counter()
myCounter.increment()
println(myCounter.current)

//Exercise 2
class BankAccount {
  private var currBalance: Double = 0.0

  def deposit(amount: Double) = {
    currBalance += amount
  }
  def withdraw(amount: Double) = {
    if (amount <= currBalance) currBalance -= amount
  }
  def balance = currBalance
}

val myAccount = new BankAccount()
myAccount.deposit(50.50f)
println("balance is: "+myAccount.balance)
myAccount.withdraw(30.5f)
println("balance is: "+myAccount.balance)

//Exercise 3
class Time(val hrs: Int, val mins: Int) {

  def before(other: Time) : Boolean = {
    if (other.hrs > this.hrs) {
      true
    } else if (other.hrs == this.hrs) {
       if(other.mins > this.mins) true
       else false
    } else {
      false
    }
  }
}
println("23:20 is before 23:30 is: "+ new Time(23, 20).before(new Time(23, 30)))
println("11:00 is before 11:00 is: "+ new Time(11, 0).before(new Time(11, 0)))
println("12:00 is before 12:01 is: "+ new Time(12, 1).before(new Time(12, 0)))

//Exercise 4
class Time(val hrs: Int, val mins: Int) {

  def minsSinceMidnight = hrs * 60 + mins

  def before(other: Time) : Boolean = {

    if (other.minsSinceMidnight > this.minsSinceMidnight) true
    else false
  }
}
println("23:20 is before 23:30 is: "+ new Time(23, 20).before(new Time(23, 30)))
println("11:00 is before 11:00 is: "+ new Time(11, 0).before(new Time(11, 0)))
println("00:01 is before 23:59 is: "+ new Time(0, 1).before(new Time(23, 59)))

//Exercise 5
class Student(@BeanProperty var name: String, @BeanProperty var id: Int) {
}

val student = new Student("Test", 1)
println(student.getName()+ " "+student.getId())
student.setName("Fred")
println(student.getName()+ " "+student.getId())

//Exercise 6
class Person(var age: Int) {
    if (age < 0 ) age = 0
}
var person = new Person(-2)
println("Negative age has been reset to: "+person.age)

//Exercise 7
class Person(val name: String) {  //val because if we allow updates to name then the firstName and lastName methods will be incorrect/out of sync
  def firstName = name.split(' ')(0)
  def lastName = name.split(' ')(1)
}
val person = new Person("Mary Lamb")
println(person.firstName)
println(person.lastName)

//Exercise 8
class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
  //Only one constructor is needed!
}

//Exercise 9 - don't really want to do this, it's so painful!
//class Car {
//  private String manufacturer;
//  private String modelName;
//  private int modelYear = -1;
//  private String licensePlate = "";
//
//  public Car(String manufacturer, String modelName) {
//    this.manufacturer = manufacturer;
//    this.modelName = modelName;
//  }
//  public Car(String manufacturer, String modelName, int modelYear) {
//    this(manufacturer, modelName);
//    this.modelYear = modelYear;
//  }
//  public Car(String manufacturer, String modelName, String licensePlate) {
//    this(manufacturer, modelName);
//    this.licensePlate = licensePlate;
//  }
//  public Car(String manufacturer, String modelName, String licensePlate, int modelYear) {
//    this(manufacturer, modelName, licensePlate);
//    this.modelYear = modelYear;
//  }
//  //Plus getter methods for all fields, and a setter for the licensePlate field
//}

//Exercise 10 - I prefer the primary constructor in the first class example, it's simpler
class Employee(val name: String, var salary: Double) {
  def this() {this("", 0.0)}
}
class Employee {
  private var _name: String = ""
  var salary: Double = 0.0

  def this(name: String, salary: Double) {
    this()
    _name = name
    this.salary = salary
  }

  def name = _name
}
val emp = new Employee("John", 3200)
println("Employee: "+emp.name + " has a salary of: "+emp.salary)
emp.salary = 4000
println("After a pay rise employee: "+emp.name + " has a salary of: "+emp.salary)


