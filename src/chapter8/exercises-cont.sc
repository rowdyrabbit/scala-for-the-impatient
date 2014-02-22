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

//Chapter 10
{
  class Stack[A] protected (protected val elems: List[A])

  //It means that only classes that inherit from Stack can use this constructor. All other classes must use an auxiliary constructor.
  //The meaning of protected in the case of the constructor parameter elems is that this val will have protected visibility too - that is, only
  //classes that extend from Stack will be able to see this val.
}







