import scala.io.Source

//Exercise 6
//Not quite sure what this question was asking, so I'm just returning all strings declared in the file
{
  val stringPattern = """"([^"\\]*(\\.[^"\\]*)*)"""".r

  val file = Source.fromFile("files/java_source.java").mkString

  val matches = stringPattern.findAllIn(file).toList
  println(matches)
}

//Exercise 7
{
  val floats = "([0-9]\\.[0-9]*| \\.[0-9]*)".r

  val file = Source.fromFile("files/floats.txt").mkString
  val tokens = file.split("\\s+").filter(
    floats findFirstIn _ match {
      case Some(_) => false
      case None => true
  } )

  println(tokens.mkString(", "))
}

//Exercise 8
{
  var source = Source.fromURL("http://horstmann.com/scala/", "UTF-8").mkString
  val imgsrcPattern = """<\s*img[^>]*src\s*=\s*['"\s]*([^'"]+)['"\s]*[^>]*>""".r
  for(imgsrcPattern(image) <- imgsrcPattern.findAllIn(source)) println("image: "+image)
}







