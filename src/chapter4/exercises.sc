//Exercise 1
val gizmos = Map("gizmo1" -> 10.0, "gizmo2" -> 20.0, "gizmo3" -> 30.0)
val discountedGizmos = for((k, v) <- gizmos) yield (k, v*.9)

//Exercise 2
val wordCountMap = new collection.mutable.HashMap[String, Int]
val in = new java.util.Scanner(new java.io.File("files/myfile.txt"))
while(in.hasNext()) {
  val currWord = in.next()
  wordCountMap(currWord) = wordCountMap.getOrElse(currWord, 0) + 1
}
for ((word, wordCount) <- wordCountMap) println(word + " " + wordCount)

//Exercise 3
var wordCountMap3 = Map[String, Int]()
val in = new java.util.Scanner(new java.io.File("files/myfile.txt"))

while(in.hasNext()) {
  val currWord = in.next()
  val newWordCount = wordCountMap3.getOrElse(currWord, 0) + 1
  wordCountMap3 = wordCountMap3 + (currWord -> newWordCount)
}
for ((word, wordCount) <- wordCountMap3) println(word + " " + wordCount)

//Exercise 4
var wordCountMap3 = collection.immutable.SortedMap[String, Int]()
val in = new java.util.Scanner(new java.io.File("files/myfile.txt"))

while(in.hasNext()) {
  val currWord = in.next()
  val newWordCount = wordCountMap3.getOrElse(currWord, 0) + 1
  wordCountMap3 = wordCountMap3 + (currWord -> newWordCount)
}
println("Printing the word counts in alphabetically sorted order from an immutable map:")
for ((word, wordCount) <- wordCountMap3) println(word + " " + wordCount)

//Exercise 5
import collection.JavaConversions.mapAsScalaMap
val wordCountMap : collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
val in = new java.util.Scanner(new java.io.File("files/myfile.txt"))
while(in.hasNext()) {
  val currWord = in.next()
  wordCountMap(currWord) = wordCountMap.getOrElse(currWord, 0) + 1
}
println("Printing the word counts in alphabetically sorted order from a mutable map (TreeMap):")
for ((word, wordCount) <- wordCountMap) println(word + " " + wordCount)

//Exercise 6
val daysOfWeek = collection.mutable.LinkedHashMap(
                  "Monday" -> java.util.Calendar.MONDAY,
                  "Tuesday" -> java.util.Calendar.TUESDAY,
                  "Wednesday" -> java.util.Calendar.WEDNESDAY,
                  "Thursday" -> java.util.Calendar.THURSDAY,
                  "Friday" -> java.util.Calendar.FRIDAY
                  )
for ((k, v) <- daysOfWeek) println(k)

//Exercise 7
import collection.JavaConversions.propertiesAsScalaMap
val props : collection.Map[String, String] = System.getProperties()
val longestKey = props.keySet.map(_.length).max
for( (k,v) <- props ) printf("%-" + longestKey + "s | %s\n", k, v)

//Exercise 8
def minmax(values: Array[Int]) = {
  val min = values.min
  val max = values.max
  (min, max)
}
println("minmax result is: "+minmax(Array(1, 2, 3, 5, 6)))

//Exercise 9
def lteqgt(values: Array[Int], v: Int) = {
    val lt = values.count(_ < v)
    val eq = values.count(_ == v)
    val gt = values.count(_ > v)
    (lt, eq, gt)
}

println("lt, eq, gt "+ lteqgt(Array(2, 3, 4, 5, 6, 7), 5))

//Exercise 10
//zip could be useful for mapping an ordered list of values to another ordered list of values, for example:
val currencyCodes = Array("AUD", "NZD", "GBP")
val currencyDescriptions = Array("Australian Dollar", "New Zealand Dollar", "Great British Pound")


currencyCodes.zip(currencyDescriptions)









