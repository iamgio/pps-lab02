package lab

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 */
class RecursionTest:
  @Test def testPower(): Unit =
    assertEquals(9, power(3.0, 2).toInt)
    assertEquals(125, power(5.0, 3).toInt)