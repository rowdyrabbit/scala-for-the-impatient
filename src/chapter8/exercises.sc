//Exercise 1
{
  class BankAccount (initialBalance : Double ) {
    private var balance = initialBalance

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

}


