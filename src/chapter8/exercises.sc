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











