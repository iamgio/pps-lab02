package lab

import scala.annotation.tailrec

def power(base: Double, exponent: Int): Double =
  @tailrec
  def _power(base: Double, exponent: Int, accumulator: Double): Double =
    exponent match
      case 0 => 1.0
      case 1 => base * accumulator
      case _ => _power(base, exponent - 1, base * accumulator)
  _power(base, exponent, 1.0)