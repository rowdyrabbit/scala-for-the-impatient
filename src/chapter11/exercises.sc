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

