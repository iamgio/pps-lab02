package lab

import scala.annotation.tailrec

object Lab2 extends App:
  // Task 3, svolto da solo
  
  val positiveLiteral = (x: Int) => x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveMethod(x: Int) = x match
    case n if n >= 0 => "positive"
    case _ => "negative"
  
  val negLiteral: (String => Boolean) => String => Boolean = predicate => !predicate(_)

  def negMethod(predicate: String => Boolean): String => Boolean = !predicate(_)
  
  def negGeneric[X](predicate: X => Boolean): X => Boolean = !predicate(_)

  // Task 4, svolto da solo

  val nonCurriedPredicateLiteral: (Int, Int, Boolean) => Boolean = _ <= _ == _

  val curriedPredicateLiteral: (Int, Int) => (Boolean => Boolean) =
    (x, y) => z => x <= y == z

  def nonCurriedPredicateMethod(x: Int, y: Int, z: Boolean) = x <= y == z

  def curriedPredicateMethod(x: Int, y: Int)(z: Boolean) = x <= y == z

  // Task 5, svolto da solo

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def composeGeneric[A, B, C](f: B => C, g: A => B): A => C =
    x => f(g(x))
    
  // Task 6, svolto da solo

  def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D =
    composeGeneric(f, x => g(h(x)))

  // Task 7, svolto da solo
    
  def power(base: Double, exponent: Int): Double =
    @tailrec
    def _power(base: Double, exponent: Int, accumulator: Double): Double =
      exponent match
        case 0 => 1.0
        case 1 => base * accumulator
        case _ => _power(base, exponent - 1, base * accumulator)

    _power(base, exponent, 1.0)

  // Task 8, svolto da solo
  
  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(n: Int, accumulator: Int): Int =
      n match
        case 0 => accumulator
        case _ => _reverse(n / 10, accumulator * 10 + n % 10)

    _reverse(n, 0)

  // Task 9, svolto da solo

  enum Expr:
    case Literal(value: Int)
    case Add(left: Expr, right: Expr)
    case Multiply(left: Expr, right: Expr)

  object Expr:
    def evaluate(expr: Expr): Int =
      expr match
        case Literal(value) => value
        case Add(left, right) => evaluate(left) + evaluate(right)
        case Multiply(left, right) => evaluate(left) * evaluate(right)

    def show(expr: Expr): String =
      def join(left: String, right: String, operator: String, wrap: Boolean) =
        left + operator + right match
          case result if wrap => s"($result)"
          case result if !wrap => result


      def _show(expr: Expr, root: Boolean): String =
        def joinExpressions(left: Expr, right: Expr)(operator: String) =
          join(_show(left, false), _show(right, false), operator, !root)

        expr match
          case Literal(value) => value.toString
          case Add(left, right) => joinExpressions(left, right)("+")
          case Multiply(left, right) => joinExpressions(left, right)("*")

      _show(expr, true)