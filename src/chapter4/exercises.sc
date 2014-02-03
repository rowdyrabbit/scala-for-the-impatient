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
//Exercise 6
val daysOfWeek = collection.mutable.LinkedHashMap(
                  "Monday" -> java.util.Calendar.MONDAY,
                  "Tuesday" -> java.util.Calendar.TUESDAY,
                  "Wednesday" -> java.util.Calendar.WEDNESDAY,
                  "Thursday" -> java.util.Calendar.THURSDAY,
                  "Friday" -> java.util.Calendar.FRIDAY
                  )
for ((k, v) <- daysOfWeek) println(k)


//Exercise 10
//zip could be useful for mapping an ordered list of values to another ordered list of values, for example:
val currencyCodes = Array("AUD", "NZD", "GBP")
val currencyDescriptions = Array("Australian Dollar", "New Zealand Dollar", "Great British Pound")


currencyCodes.zip(currencyDescriptions)









