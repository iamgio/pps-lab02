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