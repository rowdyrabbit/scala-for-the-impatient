import java.io.{FileInputStream, ObjectInputStream, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer
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




//Exercise 9
{
  import java.io.File

  def subdirs(dir: File) : Iterator[File] = {
    val dirs = dir.listFiles.filter(_.isDirectory)
    dirs.toIterator ++ dirs.toIterator.flatMap(subdirs _)
  }
  val classFiles = for (
    dir <- subdirs(new File("."));
    classFile <- dir.listFiles.filter(f => "\\.clazz".r.findFirstIn(f.getName).isDefined)
  ) yield classFile
  println("number of .clazz files: "+ classFiles.size)
}

//Chapter 10
{
  object Person {
    def apply(name: String) = new Person(name)
  }
  
  class Person(val name: String) extends Serializable {
    private val friends = new ArrayBuffer[Person]
    def addFriend(f : Person) = friends += f

    override def toString: String = {
      name + " (has friends: " + friends.map(_.name).mkString(", ") + ")"
    }
  }

  val harry = Person("harry")
  val jack = Person("jack")
  val mary = Person("mary")
  mary.addFriend(jack)
  mary.addFriend(harry)

  val allPeeps = Array(harry, jack, mary)
  val out = new ObjectOutputStream(new FileOutputStream("files/friends.obj"))
  out.writeObject(allPeeps)
  out.close

  val in = new ObjectInputStream(new FileInputStream("files/friends.obj"))
  val savedPeeps = in.readObject().asInstanceOf[Array[Person]]
  for (p <- savedPeeps) println(p)
}





