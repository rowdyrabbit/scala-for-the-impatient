import scala.io.Source

//Exercise 1
{
  import io.Source
  val source = Source.fromFile("files/reverseme.txt", "UTF-8")
  val lines = source.getLines()
  for ( l <- lines) {
    println(l.reverse)
  }
  source.close
}











//Exercise 2
{
  import io.Source
  val n = 5
  val source = Source.fromFile("files/tabs.txt", "UTF-8")
  val iter = source.buffered
  var count: Int = 0
  var outputString = ""
  while(iter.hasNext) {
    if (iter.head == '\t') {
       outputString = outputString + (" " * (n - count % n))
       count = 0
       iter.next  //read it and throw it away.
    } else if (iter.head == '\n') {
      outputString = outputString + iter.next
      count = 0
    } else {
      outputString = outputString + iter.next
      count = count +1
    }
  }
  source.close
  println(outputString)
}



//Exercise 3
{
  for (w <- Source.fromFile("files/bigwords.txt", "UTF-8").mkString.split("\\s+")) {if (w.length > 12) println (w)}
}


//Exercise 4
{
  var sum: Double = 0
  var max: Double = Double.MinValue
  var min: Double = Double.MaxValue
  var count: Int = 0
  val tokens = Source.fromFile("files/floating_point.txt", "UTF-8").mkString.split("\\s+")
  val numbers = for (w <- tokens) yield w.toDouble
  for (n <- numbers) {
    sum += n
    count += 1
    if (n > max) max = n
    if (n < min) min = n
  }
  println("Sum is: "+sum)
  println("Minimum is: "+min)
  println("Maximum is: "+max)
  println("Average is: "+sum/count)
}



//Exercise 5
{
  val out = new java.io.PrintWriter("files/powers.txt")
  for(i <- 0 to 20){
    out.println("%8.0f    %f".format(math.pow(2.0, i), math.pow(2.0, -i)))
  }
  out.close
}




