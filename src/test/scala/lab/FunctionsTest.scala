package lab

import org.junit.Assert.assertEquals
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
