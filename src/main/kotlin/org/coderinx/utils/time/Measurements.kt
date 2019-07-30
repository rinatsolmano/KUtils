/*
 * Copyright (c) 2019. coderinx.org
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:kotlin.jvm.JvmName("MeasurementsKt")

package org.coderinx.utils.time

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

data class MeasuredResult<T>(
    val time: Long,
    val result: T
)

/**
 * Executes the given [block] and returns it result and elapsed time in given [timeUnit].
 */
@JvmOverloads
fun <T> withTimeMeasurement(timeUnit: TimeUnit = MILLISECONDS, block: () -> T): MeasuredResult<T> {
    val start = System.nanoTime()
    val result = block.invoke()
    val elapsed = System.nanoTime() - start
    return when (timeUnit) {
        NANOSECONDS -> MeasuredResult(elapsed, result)
        MICROSECONDS -> MeasuredResult(NANOSECONDS.toMicros(elapsed), result)
        MILLISECONDS -> MeasuredResult(NANOSECONDS.toMillis(elapsed), result)
        SECONDS -> MeasuredResult(NANOSECONDS.toSeconds(elapsed), result)
        MINUTES -> MeasuredResult(NANOSECONDS.toMinutes(elapsed), result)
        HOURS -> MeasuredResult(NANOSECONDS.toHours(elapsed), result)
        DAYS -> MeasuredResult(NANOSECONDS.toDays(elapsed), result)
    }
}

/**
 * Executes the given [block] and returns elapsed time in given [timeUnit].
 */
@JvmOverloads
fun measureTime(timeUnit: TimeUnit = MILLISECONDS, block: () -> Unit): Long {
    val start = System.nanoTime()
    block.invoke()
    val elapsed = System.nanoTime() - start
    return when (timeUnit) {
        NANOSECONDS -> (elapsed)
        MICROSECONDS -> (NANOSECONDS.toMicros(elapsed))
        MILLISECONDS -> (NANOSECONDS.toMillis(elapsed))
        SECONDS -> (NANOSECONDS.toSeconds(elapsed))
        MINUTES -> (NANOSECONDS.toMinutes(elapsed))
        HOURS -> (NANOSECONDS.toHours(elapsed))
        DAYS -> (NANOSECONDS.toDays(elapsed))
    }
}

