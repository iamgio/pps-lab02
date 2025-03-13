package lab

import lab.Expr.*
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 */
class ExprTest:
  @Test def testEvaluate(): Unit = {
    assertEquals(5, evaluate(Expr.Literal(5)))
    assertEquals(12, evaluate(Expr.Add(Expr.Literal(5), Expr.Literal(7))))
    assertEquals(15, evaluate(Expr.Multiply(Expr.Literal(5), Expr.Literal(3))))
    assertEquals(24, evaluate(
      Expr.Multiply(
        Expr.Literal(2),
        Expr.Add(Expr.Literal(5), Expr.Literal(7))
      )
    ))
  }

  @Test def testShow(): Unit = {
    assertEquals("5", show(Expr.Literal(5)))
    assertEquals("5+7", show(Expr.Add(Expr.Literal(5), Expr.Literal(7))))
    assertEquals("5*3", show(Expr.Multiply(Expr.Literal(5), Expr.Literal(3))))
    assertEquals("2*(5+7)", show(
      Expr.Multiply(
        Expr.Literal(2),
        Expr.Add(Expr.Literal(5), Expr.Literal(7))
      )
    ))
    assertEquals("2*((5+7)+4)", show(
      Expr.Multiply(
        Expr.Literal(2),
        Expr.Add(
          Expr.Add(Expr.Literal(5), Expr.Literal(7)),
          Expr.Literal(4)
        )
      )
    ))
  }