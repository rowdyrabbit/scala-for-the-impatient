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

    override def log(msg: String) {
      println(msg)
    }
  }
  val test = new Test
  test.test

}

