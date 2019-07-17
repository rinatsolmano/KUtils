package org.coderinx.utils.time

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

fun <T> withTimeMeasurement(unit: TimeUnit = NANOSECONDS, block: () -> T): Pair<T, Long> {
    val start = System.nanoTime()
    val result = block.invoke()
    val finish = System.nanoTime()
    val timeInNanos = finish - start
    return when (unit) {
        NANOSECONDS -> Pair(result, timeInNanos)
        MICROSECONDS -> Pair(result, NANOSECONDS.toMicros(timeInNanos))
        MILLISECONDS -> Pair(result, NANOSECONDS.toMicros(timeInNanos))
        SECONDS -> Pair(result, NANOSECONDS.toSeconds(timeInNanos))
        MINUTES -> Pair(result, NANOSECONDS.toMinutes(timeInNanos))
        HOURS -> Pair(result, NANOSECONDS.toHours(timeInNanos))
        DAYS -> Pair(result, NANOSECONDS.toDays(timeInNanos))
    }
}

fun <T> measureTimeMillis(block: () -> T): Pair<T, Long> {
    val start = System.nanoTime()
    val result = block.invoke()
    val finish = System.nanoTime()
    val timeInNanos = finish - start
    return Pair(result, NANOSECONDS.toMillis(timeInNanos))
}

