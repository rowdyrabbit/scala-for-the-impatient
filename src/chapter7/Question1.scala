package chapter7

package com.horstmann {
  object Utils {
    def sayHi(msg: String) = {
      "Hi! "+msg
    }
  }
}

package com.horstmann.impatient {
  class TryToSayHi {

    //The following won't compile because this package (com.horstmann.impatient) does not have access to the com.horstmann package
    //Utils.sayHi("I don't think I can say hi")
  }
}

package com {
  package horstmann {
    package impatient {
      class CanSayHi {
          Utils.sayHi("I can say hi!")
      }
    }
  }
}

