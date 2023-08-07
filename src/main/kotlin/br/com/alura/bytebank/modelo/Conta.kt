package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exception.AutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import java.lang.NumberFormatException

abstract class Conta(
    val titular: Cliente,
    val numero: Int = 0 // inicializacao torna o parametro opcional
): Autenticavel by titular{ /* aqui uma DELEGATION */

    var saldo = 0.0
        protected set

    // aqui um exemplo de Companion Declaration,
    // que torna a variavel um membro estático da classe
    companion object {
        var total = 0
            private set
    }

    init {
        total++
    }

    // aqui uma DELEGATION caso não seja feito o uso do "by"
    // na declaração da classe. Então reutilizamos um código já implementado
//    override fun autentica(senha: Int): Boolean {
//        return titular.autentica(senha)
//    }

    fun deposita(valor: Double) {
        saldo += valor
    }

    abstract fun saca(valor: Double)

    fun transfere(destino: Conta, valor: Double, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException()
        }
        if (!autentica(senha)) {
            throw AutenticacaoException()
        }
        // throw NumberFormatException
        saldo -= valor
        destino.deposita(valor)
    }

    fun exibeConta() {
        println("Titular : ${this.titular}")
        println("modelo.Conta   : ${this.numero}")
        println("Saldo   : ${this.saldo}")
        println()
    }

    fun verificaStatus() {
        //    if (saldo > 0.0) {
//        println("Status da conta : positiva")
//    } else if (saldo == 0.0) {
//        println("Status da conta : neutra")
//    } else println(message = "Status da conta : negativa")

        when {
            saldo > 0.0 -> println("Status da conta : positiva")
            saldo == 0.0 -> println("Status da conta : neutra")
            saldo < 0 -> println("Status da conta : negativa")
        }
    }
}