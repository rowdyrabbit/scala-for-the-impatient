//Exercise 4
//I think package object syntax was added instead of allowing functions to be defined under a package because of a JVM limitation
//that doesn't allow methods to be defined outside the context of a class. When a package object is compiled, it is compiled into a JVM class with static methods and fields

//Exercise 5
//The meaning of private[com] def giveRaise(rate: Double) is that the giveRaise function is visible throughout the
//com package. It could be useful if you wanted to make a function visible throughout a specific package name and below.
//It probably isn't a good idea to allow state to be changed from anywhere inside the com package as this would include
//libraries outside of the current application's control.

//Exercise 6
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}
def copyFromJavaHashMapToScalaHashMap() = {

}


