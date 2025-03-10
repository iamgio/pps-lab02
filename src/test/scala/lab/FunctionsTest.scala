package lab

import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test

/**
 *
 */
class FunctionsTest:
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