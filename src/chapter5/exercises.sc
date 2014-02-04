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

