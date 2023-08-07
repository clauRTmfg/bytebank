package br.com.alura.bytebank.teste

fun testaExpressao() {
    val v0: Double = 1.0

    // o ? significa que a variável pode conter null
    val v1: Double? = if (v0 != null) {
        v0 + 0.1
    } else {
        null
    }

    val v2: Double? = when {
        v0 != null -> {
            v0 + 0.1
        }

        else -> {
            null
        }
    }
}