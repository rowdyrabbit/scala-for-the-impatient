//Exercise 1
{
  import io.Source
  val source = Source.fromFile("files/reverseme.txt", "UTF-8")
  val lines = source.getLines()
  for ( l <- lines) {
    println(l.reverse)
  }
}




