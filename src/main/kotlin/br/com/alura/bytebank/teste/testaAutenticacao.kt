package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.Diretor
import br.com.alura.bytebank.modelo.Gerente
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaAutenticacao() {
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
        senha = 6789,
        plr = 500.0
    )

    val cliente = Cliente(
        nome = "Otone",
        cpf = "777.777.777-77",
        senha = 4444
    )

    val sistema = SistemaInterno()
    sistema.login(thomas, 1234)
    sistema.login(almeida, 6789)
    sistema.login(cliente, 9999)

}