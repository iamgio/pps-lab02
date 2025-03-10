package lab

// Positive

val positiveLiteral = (x: Int) => x match
  case n if n >= 0 => "positive"
  case _ => "negative"

def positiveMethod(x: Int) = x match
  case n if n >= 0 => "positive"
  case _ => "negative"

// Neg

val negLiteral: (String => Boolean) => (String => Boolean) = predicate => !predicate(_)

def negMethod(predicate: String => Boolean): String => Boolean = !predicate(_)

def negGeneric[X](predicate: X => Boolean): X => Boolean = !predicate(_)

// Currying

val nonCurriedPredicateLiteral: (Int, Int, Boolean) => Boolean = _ <= _ == _

val curriedPredicateLiteral: (Int, Int) => (Boolean => Boolean) =
  (x, y) => z => x <= y == z
  
def nonCurriedPredicateMethod(x: Int, y: Int, z: Boolean) = x <= y == z

def curriedPredicateMethod(x: Int, y: Int)(z: Boolean) = x <= y == z