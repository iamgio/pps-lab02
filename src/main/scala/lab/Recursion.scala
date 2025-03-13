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

def reverseNumber(n: Int): Int =
  @tailrec
  def _reverse(n: Int, accumulator: Int): Int =
    n match
      case 0 => accumulator
      case _ => _reverse(n / 10, accumulator * 10 + n % 10)
  _reverse(n, 0)
  