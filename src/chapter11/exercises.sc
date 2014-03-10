//Exercise 1
{
  //3 + 4 -> 5
  //(3 + 4) -> 5
  //(7,5)
  //left associative, so result is ok.

  //3 -> 4 + 5
  //(3 -> 4) + 5
  //compile error because it is left associative and you can't add 5 to a tuple.

}
//Exercise 2
{
  //Because ^ is already a bitwise xor operator and ** could be confused with *? Either way, I think pow needs to have a higher order of precedence, so a custom operator was created.
}

