package br.com.alura.bytebank.teste

import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca

fun testesKotlin() {

    val contaClau = ContaCorrente(
        titular = Cliente(nome = "Clau", cpf = "0", senha = 1),
        numero = 1
    )

    // usando labels nos parametros é possível inverter a ordem
    val contaThomas = ContaPoupanca(
        numero = 2,
        titular = Cliente(nome = "Thomas", cpf = "0", senha = 2)
    )

    contaClau.run {
        deposita(100.0)
        exibeConta()
    };

    with(contaThomas) {
        deposita(200.0)
        exibeConta()
    };

    println("Sacando da conta Clau")
    contaClau.saca(40.0)
    println("Saldo Clau : ${contaClau.saldo}")


    println("Sacando da conta Thomas")
    contaThomas.saca(300.0)
    println("Saldo Thomas : ${contaThomas.saldo}")
    println()

    println("Transferindo da conta Thomas para conta Clau")
    try {
        contaThomas.transfere(destino = contaClau, valor = 30.0, 2)
    } catch (e: SaldoInsuficienteException){
        e.printStackTrace()
    }

    println("Saldo Clau : ${contaClau.saldo}")
    contaClau.verificaStatus()
    println("Saldo Thomas : ${contaThomas.saldo}")
    contaThomas.verificaStatus()

}