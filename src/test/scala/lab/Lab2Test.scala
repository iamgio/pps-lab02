package lab

import lab.Lab2.*
import lab.Lab2.Expr.*
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test

/**
 * Tests for lab 2
 */
class Lab2Test:
  @Test def testPositiveLiteral(): Unit =
    assertEquals("positive", positiveLiteral(10))
    assertEquals("negative", positiveLiteral(-10))
    assertEquals("positive", positiveLiteral(0))

  @Test def testPositiveMethod(): Unit =
    assertEquals("positive", positiveMethod(10))
    assertEquals("negative", positiveMethod(-10))
    assertEquals("positive", positiveMethod(0))

  @Test def testNegLiteral(): Unit =
    val empty: String => Boolean = _ == ""
    val notEmpty = negLiteral(empty)
    assertTrue(notEmpty("foo"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test def testNegMethod(): Unit =
    val empty: String => Boolean = _ == ""
    val notEmpty = negMethod(empty)
    assertTrue(notEmpty("foo"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test def testNegGeneric(): Unit =
    val isZero: Int => Boolean = _ == 0
    val notZero = negGeneric(isZero)
    assertTrue(notZero(2))
    assertFalse(notZero(0))
    assertTrue(notZero(2) && !notZero(0))

  @Test def testNonCurriedPredicateLiteral(): Unit =
    assertTrue(nonCurriedPredicateLiteral(2, 3, true))
    assertFalse(nonCurriedPredicateLiteral(2, 3, false))

  @Test def testCurriedPredicateLiteral(): Unit =
    assertTrue(curriedPredicateLiteral(2, 3)(true))
    assertFalse(curriedPredicateLiteral(2, 3)(false))

  @Test def testNonCurriedPredicateMethod(): Unit =
    assertTrue(nonCurriedPredicateMethod(2, 3, true))
    assertFalse(nonCurriedPredicateMethod(2, 3, false))

  @Test def testCurriedPredicateMethod(): Unit =
    assertTrue(curriedPredicateMethod(2, 3)(true))
    assertFalse(curriedPredicateMethod(2, 3)(false))

  @Test def testComposition(): Unit =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  @Test def testCompositionGeneric(): Unit =
    assertEquals(9, composeGeneric[Int, Int, Int](_ - 1, _ * 2)(5))
    assertEquals("a1", composeGeneric[Int, String, String](_.toLowerCase, "A" + _)(1))

  @Test def testCompositionThree(): Unit =
    assertEquals("6!", composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3))

  @Test def testPower(): Unit =
    assertEquals(9, power(3.0, 2).toInt)
    assertEquals(125, power(5.0, 3).toInt)

  @Test def testReverse(): Unit =
    assertEquals(54321, reverseNumber(12345))
    assertEquals(72901, reverseNumber(10927))

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