package lab

val positiveLiteral = (x: Int) => x match
  case n if n >= 0 => "positive"
  case _ => "negative"

def positiveMethod(x: Int) = x match
  case n if n >= 0 => "positive"
  case _ => "negative"

val negLiteral: (String => Boolean) => (String => Boolean) = predicate => !predicate(_)

def negMethod(predicate: String => Boolean): String => Boolean = !predicate(_)

def negGeneric[X](predicate: X => Boolean): X => Boolean = !predicate(_)