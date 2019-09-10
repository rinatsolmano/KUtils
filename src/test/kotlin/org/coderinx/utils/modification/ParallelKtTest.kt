package org.coderinx.utils.modification

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.coderinx.utils.time.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ParallelKtTest {

    @Test
    fun `parallelMap should apply transformations in parallel`() = runBlocking(Dispatchers.IO) {
        val given = generateSequence(0) { it + 1 }.take(100).toList()
        val sequentialTime = measureTime {
            given.map { it.fakeTransform() }
        }
        val parallelTime = measureTime {
            given.parallelMap { it.fakeTransform() }
        }
        println("Sequential: $sequentialTime ms, parallel: $parallelTime ms")
        assertTrue(sequentialTime / parallelTime > 10)
    }
}

fun Int.fakeTransform(): Int {
    Thread.sleep(10)
    return this
}