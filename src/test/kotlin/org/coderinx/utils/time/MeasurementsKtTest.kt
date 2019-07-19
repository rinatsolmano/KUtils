/*
 * Copyright (c) 2019. coderinx.org
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.coderinx.utils.time

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.concurrent.TimeUnit

class MeasurementsKtTest {

    @TestFactory
    fun `returns expected result with measured time`() = TimeUnit.values()
        .map { timeUnit ->
            DynamicTest.dynamicTest("test measure in $timeUnit") {
                val (time, result) = withTimeMeasurement(timeUnit) {
                    50 * 10
                }
                assertTrue(time >= 0)
                assertEquals(500, result)
            }
        }

    @TestFactory
    fun `measures time as expected`() = TimeUnit.values()
        .map { timeUnit ->
            DynamicTest.dynamicTest("test measure in $timeUnit") {
                val time = measureTime(timeUnit) {
                    println("Hello world!")
                }
                assertTrue(time >= 0)
            }
        }
}