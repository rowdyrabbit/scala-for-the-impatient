import java.awt.Point
import java.beans.{PropertyChangeListener, PropertyChangeSupport}
import java.io.{BufferedInputStream, InputStream, FileInputStream}

//Exercise 1
{
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with chapter10.RectangleLike
  println("before changing: " + egg)
  egg.translate(10, -10)
  println("after translating: " + egg)
  egg.grow(10, 20)
  println("after growing: " + egg)
}




//Exercise 2
{
  class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x, y) with scala.math.Ordered[Point] {
    def compare(other: Point): Int = {
      if (this.x < other.x || (this.x == other.x && this.y < other.y)) {
        -1
      } else if (this.x == other.x && this.y == other.y) {
        0
      } else {
        1
      }
    }
  }
  
  object OrderedPoint {
    def apply(x: Int, y: Int) = new OrderedPoint(x, y)
  }

  val p1 = OrderedPoint(1, 1)
  val p2 = OrderedPoint(1, -1)
  val p3 = OrderedPoint(2, 1)
  val p4 = OrderedPoint(1, 1)

  println(p2 < p3) //should be true  (p2 comes before p3 because p2's x value comes before p3's)
  println(p2 < p1) //should be true  (p2 comes before p1 because p2's y value is less than p1's)
  println(p3 < p1) //should be false (p3 comes before p1 because p3's x value is larger than p1's)
  println(p4 < p1) //should be false (they are equal)
}




//Exercise 3
{
  //There's a lot of hierarchy going on here, you need to continually substitute up the inheritance hierarchy to determine the linearization of the BitSet class
  //BitSet -> lin(BitSetLike), lin(SortedSet)
  //BitSetLike, SortedSet, SortedSetLike, Sorted, Set, SetLike, Subtractable, GenSet, GenericSetTemplate, GenSetLike,
  //Iterable, IterableLike, Equals, GenIterable, GenIterableLike, Traversable, GenTraversable, GenericTraversableTemplate,
  //TraversableLike, GenTraversableLike, Parallelizable, TraversableOnce, GenTraversableOnce, FilterMonadic,
  //HasNewBuilder
}
//Exercise 4
{
  trait Logger {
    def log(msg: String) = {
      println(msg)
    }
  }

  trait CryptoLogger extends Logger {
    val key: Int = 3
    override def log(msg: String) = {

      super.log((for (char <- msg) yield (cipherChar(char))).mkString )
    }

    def cipherChar(input: Int) : Char = {
      //this should probably take into account cases where the input char + the key extend outside of the A-Z range and should roll over
      (input + key).toChar
    }
  }

  class Test extends Logger {
    def test() {
      log("logging some info")
    }
  }

  val plain = new Test
  plain.test()

  val cryptoWith3 = new Test with CryptoLogger
  cryptoWith3.test()

  val cryptoWithNeg3 = new Test with CryptoLogger {
    override val key = -3
  }
  cryptoWithNeg3.test()
}



//Exercise 5
{
  trait PropertyChangeSupportCopy {
    val support = new PropertyChangeSupport()

    def addPropertyChangeListener(listener: PropertyChangeListener) {
      support.addPropertyChangeListener(listener)
    }

    def hasListeners(propertyName: String) : Boolean = {
      support.hasListeners(propertyName)
    }

    //etc etc

  }

  val point = new java.awt.Point(3, 4) with PropertyChangeSupportCopy
  point.hasListeners("anything")
}

//Exercise 6
{
  //Not possible in Java because it doesn't allow multiple inheritance. I.e. JContainer cannot extend both JComponent and Container.

  class Component

  class Container extends Component

  trait JComponent extends Component

  class JContainer extends Container with JComponent

  class JButton extends JComponent

  class JPanel extends JContainer

}

//Exercise 7
{

}

//Exercise 8
{
   trait BufferedInputStreamCopy {
      this: InputStream =>
     //not a real implemntation of read...
     override def read(): Int = {
      5
     }
   }

  val file = new FileInputStream("files/test.txt") with BufferedInputStreamCopy
  for(i <- 1 to 10) print(file.read())
}

//Exercise 9
{
  trait Logger {
    def log(msg: String)
  }

  trait ConsoleLogger extends Logger {
    def log(msg: String) = println(msg)
  }

  trait BufferedInputStreamCopy {
    this: InputStream with Logger =>
    //not a real implemntation of read...
    override def read(): Int = {
      log("reading...")
      5
    }
  }

  val file = new FileInputStream("files/test.txt") with BufferedInputStreamCopy with ConsoleLogger
  for(i <- 1 to 10) println(file.read())
}

//Exercise 10
{
  class IterableInputStream extends java.io.InputStream with Iterable[Byte] {

  }
}









