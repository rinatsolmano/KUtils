package org.coderinx.utils.time

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

class MeasurementsKtTest {

    @Test
    fun `returns expected result with measured time in milliseconds`() {
        val (result, time) = measureTimeMillis {
            50 + 50
        }
        assertEquals(100, result)
        assertNotNull(time)
        println(result)
        println(time)
    }

    @Test
    fun `throws appropriate exception when it occurs`() {
        assertThrows(RuntimeException::class.java) {
            measureTimeMillis {
                throw RuntimeException("Error")
            }
        }
    }

    @Test
    fun `some test`() {
        val (result, time) = withTimeMeasurement(TimeUnit.NANOSECONDS) {
            100 + 1000
        }

        println(result)
        println(time)

    }
}