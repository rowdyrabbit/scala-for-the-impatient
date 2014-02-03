import scala.collection.mutable.ArrayBuffer

//Exercise 1
val n = 10
val a = for (i <- 0 until n) yield util.Random.nextInt(n)
println(a.mkString(","))

//Exercise 2
val array = Array(1,2,3,4,5)
for(i <- 1 until array.length by 2) {
  val temp = array(i)
  array(i) = array(i-1)
  array(i-1) = temp
}
println(array.mkString(","))

//Exercise 3
val array = Array(1,2,3,4,5)
val iter = for (groups <- array.grouped(2); reverseGroups <- groups.reverse) yield reverseGroups
println("new array is: "+iter.toArray.mkString(","))

//Exercise 4
val array = Array(-2, 4, 7, -6, 5)
val positive = for (i <- 0 until array.length if array(i) > 0) yield array(i)
val negative = for (i <- 0 until array.length if array(i) <= 0) yield array(i)
val b = new ArrayBuffer[Int]()
b ++= positive
b ++= negative
println(b.toArray.mkString(","))

//Exercise 5
val dblArray = Array(5.0, 2.5, 7.5)
println("average of double array is: "+dblArray.sum/dblArray.length)

//Exercise 6
val array = Array(5,3,4,7,1)
util.Sorting.quickSort(array)
println("Sorting an array in reverse order = "+array.reverse.mkString(", "))
val arrayBuffer = ArrayBuffer(5, 3, 4, 7, 1)
println("Sorting an arrayBuffer in reverse order = "+arrayBuffer.sortWith(_>_))

//Exercise 7
val array = Array(6, 5, 5, 4, 4, 4, 3, 2)
println("De-duped array: "+array.distinct.mkString(", "))

//Exercise 9
val tzList = for (elem <- java.util.TimeZone.getAvailableIDs if elem.contains("America")) yield elem.stripPrefix("America/")
util.Sorting.quickSort(tzList)

//Exercise 10
import java.awt.datatransfer._
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val scalaBuff = flavors.getNativesForFlavor(DataFlavor.imageFlavor)