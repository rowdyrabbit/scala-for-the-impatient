//Exercise 1
def signum(input : Int) : Int = {
  if (input > 0) 1
  else if (input < 0) -1
  else input
}
println(signum(7))
println(signum(-7))
println(signum(0))

//Exercise 2
//The value is () and the type is Unit
println({})

//Exercise 3
var x = ()
var y = 1
x = y = 1
//Exercise 4
for (i <- 10 to 1 by -1) println(i)
//Exercise 5
def countdown(n: Int) { //it's a procedure because there is no '='. Return type will be 'Unit'
  for (i <- n to 0 by -1) println(i)
}
countdown(20)

//Exercise 6
var acc = 1
for (c <- "Hello") acc *= c.toInt
println("unicode product is: "+acc)
//Exercise 7
var product = 1
"Hello".foreach((c: Char) => product *=c)
println("unicode product without for loop is "+product)
//Exercise 8
def product(input: String) = {
  var acc = 1
  input.foreach((c: Char) => acc *=c)
  acc
}
println(product("Hello"))
//Exercise 9
def calculateProduct(input: String, product: Int = 1) : Int = {
  if (input.length == 0) product
  else input.head * calculateProduct(input.tail, product)
}
def recursiveProduct(input: String) : Int = {
  if (input.length == 0) 0
  else calculateProduct(input)
}
recursiveProduct("Hello")

//Exercise 10
def power(x: Double, n: Int) : Double = {
  if (n > 0 && n % 2 == 0) power(x, n/2) * power(x, n/2)
  else if (n > 0 && n % 2 == 1) x * power(x, n-1)
  else if (n < 0) 1 / power(x, -n)
  else 1
}
power(2, 1)
power(2, 0)
power(2, 2)
power(2, -1)









