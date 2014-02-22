//Exercise 9
{
  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
    override def toString = "range = " + range  + " env = " + env.toBuffer
  }

  class Ant extends Creature {
    override def range = 2
    override def toString = "range = " + range  + " env = " + env.toBuffer
  }
  println(new Ant)
  println(new Creature)
  //If you use a def in both the super and subclass then it's fine - a def can override another def
  //And the env array is correctly initialised in the subclass because we have overridden the range with a function
}

{
  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
    override def toString = "range = " + range  + " env = " + env.toBuffer
  }

  class Ant extends Creature {
    override val range = 2
    override def toString = "range = " + range  + " env = " + env.toBuffer
  }
  println(new Ant)
  println(new Creature)
  //If you override a val or def in a superclass with a val in the subclass and use that value in the superclass constructor
  //then the val in the subclass will not have been initialised. You cannot rely on the value of a val in the body of a constructor.
}








