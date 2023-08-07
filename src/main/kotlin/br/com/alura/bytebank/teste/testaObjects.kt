package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.*

fun testaObjects() {
    // aqui um exemplo de Object Expression
    val c = object : Autenticavel {
        val nome: String = "Cliente"
        val cpf: String = "333.333.333-33"
        var senha: Int = 1111

        override fun autentica(senha: Int) = this.senha == senha
    }

    val cliente = Cliente(nome = "Cliente", cpf = "0", senha = 1)
    val c1 = ContaCorrente(titular = cliente, numero = 1)
    val c2 = ContaPoupanca(titular = cliente, numero = 2)

    testaContas()

    println("Total de contas = ${Conta.total}")
}