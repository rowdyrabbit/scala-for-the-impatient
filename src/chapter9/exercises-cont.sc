import scala.io.Source

//Exercise 6
//Not quite sure what this question was asking, so I'm just returning all strings declared in the file
{
  val stringPattern = """"([^"\\]*(\\.[^"\\]*)*)"""".r

  val file = Source.fromFile("files/java_source.java").mkString

  val matches = stringPattern.findAllIn(file).toList
  println(matches)
}


