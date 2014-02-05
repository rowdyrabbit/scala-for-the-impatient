import scala.reflect.BeanProperty

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

//Chapter 6
class Person(var age: Int) {
    if (age < 0 ) age = 0
}

var person = new Person(-2)
println("Negative age has been reset to: "+person.age)

//Chapter 7


