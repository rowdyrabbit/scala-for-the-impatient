//Exercise 1
{
  //3 + 4 -> 5
  //(3 + 4) -> 5
  //(7,5)
  //left associative, so result is ok.

  //3 -> 4 + 5
  //(3 -> 4) + 5
  //compile error because it is left associative and you can't add 5 to a tuple.

}
//Exercise 2
{
  //Because ^ is already a bitwise xor operator and ** could be confused with *? Either way, I think pow needs to have a higher order of precedence, so a custom operator was created.
}
//Exercise 3
{
  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }

  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
    override def toString = num + "/" + den
    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
    def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

    def +(fraction: Fraction) : Fraction = {
      val newNum = this.num * fraction.den + fraction.num * this.den
      val newDen = this.den * fraction.den
      new Fraction(newNum, newDen)
    }

    def -(fraction: Fraction) : Fraction = {
      val newNum = this.num * fraction.den - fraction.num * this.den
      val newDen = this.den * fraction.den
      new Fraction(newNum, newDen)
    }

    def *(fraction: Fraction) : Fraction = {
      val newNum = this.num * fraction.num
      val newDen = this.den * fraction.den
      new Fraction(newNum, newDen)
    }

    def /(fraction: Fraction) : Fraction = {
      val newNum = this.num * fraction.den
      val newDen = this.den * fraction.num
      new Fraction(newNum, newDen)
    }
  }

  val a = Fraction(1, 2)
  val b = Fraction(2, 8)
  println(a - b)
  println(a + b)
  println(a * a)
  println(b / a)
}



//Exercise 4
{

}








