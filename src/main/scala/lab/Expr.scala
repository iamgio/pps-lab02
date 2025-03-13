package lab

import lab.Expr.{Add, Literal, Multiply}

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