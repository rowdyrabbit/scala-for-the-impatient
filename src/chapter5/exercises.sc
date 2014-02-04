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

