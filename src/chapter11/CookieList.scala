package chapter11


class CookieList (val c1: String, val c2: String, val c3: String, val c4: String) {

}

object CookieList {
  def apply(c1: String, c2: String, c3: String, c4: String) = new CookieList(c1, c2, c3, c4)
}

