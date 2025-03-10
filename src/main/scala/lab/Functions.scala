package lab

val positiveLiteral = (x: Int) => x match
  case n if n >= 0 => "positive"
  case _ => "negative"

def positiveMethod(x: Int) = x match
  case n if n >= 0 => "positive"
  case _ => "negative"



