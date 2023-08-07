package br.com.alura.bytebank.teste

fun testes() {
    //    for (i in 1..5) {
    for (i in 5 downTo 1) {
        val titular: String = "Clau $i"
        val conta = 1000 + i
        var saldo = i * 100.0

        println("Titular : $titular")
        println("modelo.Conta : $conta")
        println("Saldo : $saldo")

        //verificaStatus(saldo)
        println()

    }
}