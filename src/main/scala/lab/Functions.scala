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

// Compose

def compose(f: Int => Int, g: Int => Int): Int => Int =
  x => f(g(x))

def composeGeneric[A, B, C](f: B => C, g: A => B): A => C =
  x => f(g(x))

//def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D =
