/*
 * Copyright (c) 2019. coderinx.org
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */
package org.coderinx.utils.modification

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * Returns a list containing the results of applying the given [transform] function
 * to each element in the original collection in separate coroutines using [async] coroutine builder.
 * Type of [Dispatchers] should be specified outside of the function
 *
 */
suspend inline fun <T, R> Iterable<T>.parallelMap(crossinline transform: suspend (T) -> R): List<R> =
    coroutineScope {
        this@parallelMap
            .map { async { transform.invoke(it) } }
            .awaitAll()
    }