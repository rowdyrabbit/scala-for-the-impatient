package chapter7

package object random {

  private[random] var prev = 0

  def nextInt() : Int = {
    val next = (previous * 1664525) + (1013904223 % math.pow(2, 32))
    prev = next
    next
  }

  def nextDouble() : Double = {
    nextInt.toDouble
  }

  def setSeed(seed: Int) {
    prev = seed
  }

}
