package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Analista
import br.com.alura.bytebank.modelo.CalculadoraBonificacao
import br.com.alura.bytebank.modelo.Diretor
import br.com.alura.bytebank.modelo.Gerente

fun testaFuncionarios() {
    val clau = Analista(
        nome = "Clau",
        cpf = "111.111.111-11",
        salario = 1000.0
    )

    val thomas = Gerente(
        nome = "Thomas",
        cpf = "222.222.222-22",
        salario = 2000.0,
        senha = 1234
    )

    val almeida = Diretor(
        nome = "Almeida",
        cpf = "333.333.333-33",
        salario = 3000.0,
        senha = 9999,
        plr = 500.0
    )

    println("nome : ${almeida.nome}")
    println("cpf : ${almeida.cpf}")
    println("salario : ${almeida.salario}")
    println("bonificacao : ${almeida.bonificacao}")

    if (almeida.autentica(1234)) {
        println("Autenticação com sucesso !")
    } else {
        println("Falha na autenticação!")
    }

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(clau)
    calculadora.registra(thomas)
    calculadora.registra(almeida)

    println("Total de bonificação : ${calculadora.total}")
}