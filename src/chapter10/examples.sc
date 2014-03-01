{
  trait Logger {
    def log(msg: String)
    def info(msg: String) {log("INFO: " + msg)}
    def warn(msg: String) {log("WARN: " + msg)}
    def severe(msg: String) {log("SEVERE: " + msg)}
  }

  class Test extends Logger {

    def test {
      warn("not implemented")
    }

    //implementation of the log function in the Logger trait
    def log(msg: String) {
      println(msg)
    }
  }
  val test = new Test
  test.test
}
{
  trait Square {
    val width: Int
    val height: Int
    def test {
      println("Height is: " + height + " width is: " + width)
    }
  }

  class FancySquare extends Square {
    val width = 50
    val height = 50
    override def test  {
      println("have to implement width and height or this won't compile. Height is: " + height + " width is: " + width)
    }
  }

  val square = new FancySquare
  square.test
  val instanceSquare = new Square {
    val width = 22
    val height = 22
  }
  instanceSquare.test
}



