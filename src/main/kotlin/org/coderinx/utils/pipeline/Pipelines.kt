package org.coderinx.utils.pipeline

fun <A, B> A.pipeline(
        step1: (A) -> B
): B {
    return step1(this)
}

fun <A, B, C> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C
): C {
    return step2(step1(this))
}

fun <A, B, C, D> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D
): D {
    return step3(step2(step1(this)))
}

fun <A, B, C, D, E> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E
): E {
    return step4(step3(step2(step1(this))))
}

fun <A, B, C, D, E, F> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F
): F {
    return step5(step4(step3(step2(step1(this)))))
}

fun <A, B, C, D, E, F, G> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F,
        step6: (F) -> G
): G {
    return step6(step5(step4(step3(step2(step1(this))))))
}

fun <A, B, C, D, E, F, G, H> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F,
        step6: (F) -> G,
        step7: (G) -> H
): H {
    return step7(step6(step5(step4(step3(step2(step1(this)))))))
}

fun <A, B, C, D, E, F, G, H, I> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F,
        step6: (F) -> G,
        step7: (G) -> H,
        step8: (H) -> I
): I {
    return step8(step7(step6(step5(step4(step3(step2(step1(this))))))))
}

fun <A, B, C, D, E, F, G, H, I, J> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F,
        step6: (F) -> G,
        step7: (G) -> H,
        step8: (H) -> I,
        step9: (I) -> J
): J {
    return step9(step8(step7(step6(step5(step4(step3(step2(step1(this)))))))))
}

fun <A, B, C, D, E, F, G, H, I, J, K> A.pipeline(
        step1: (A) -> B,
        step2: (B) -> C,
        step3: (C) -> D,
        step4: (D) -> E,
        step5: (E) -> F,
        step6: (F) -> G,
        step7: (G) -> H,
        step8: (H) -> I,
        step9: (I) -> J,
        step10: (J) -> K
): K {
    return step10(step9(step8(step7(step6(step5(step4(step3(step2(step1(this))))))))))
}

fun <T> T.pipeline(steps: List<(T) -> T>): T {
    var result = this
    for (step in steps) {
        result = step(result)
    }
    return result
}

fun <T> T.pipeline(vararg steps: (T) -> T): T {
    var result = this
    for (step in steps) {
        result = step(result)
    }
    return result
}