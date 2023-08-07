package br.com.alura.bytebank.br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco

private fun testaScopeFunction() {

    //    val endereco = Endereco(logradouro = "Av. Lacerda Franco", numero = 570)
//    val endUpper = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(endUpper)
    // assim nao precisamos criar uma variavel de referencia ao objeto Endereco
    Endereco(logradouro = "Av. Lacerda Franco", numero = 570)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".uppercase()
        }.let { enderecoEmMaiusculo ->
            println(enderecoEmMaiusculo)
        }
    // ou então assim
    Endereco(logradouro = "Av. Lacerda Franco", numero = 570)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".uppercase()
        }.let(::println)
    // usando o run
    Endereco(logradouro = "Av. Lacerda Franco", numero = 570)
        .run {
            "$logradouro, $numero".uppercase()
        }.let(::println)

    listOf(Endereco(complemento = "casa"), Endereco(), Endereco(complemento = "apto"))
        .filter(predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = ::println)
    // ou assim
    listOf(Endereco(complemento = "casa"), Endereco(), Endereco(complemento = "apto"))
        .filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(::println)

    with(Endereco()) {
        logradouro = "Av. Lacerda Franco"
        numero = 570
        complemento = "apto 57"
        bairro = "Cambuci"
        cidade = "São Paulo"
        estado = "SP"
        cep = "01536-000"
        endCompleto()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }

    println()
    val taxaMensal = 0.05
    val contaPoupanca = ContaPoupanca(Cliente(nome = "Clau", cpf = "222.222.222-99", senha = 8888), 1001)
    contaPoupanca.run {
        deposita(1000.0)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println(rendimentoMensal)
    }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) { saldo += saldo * taxaMensal }
        saldo
    }.let(::println)
}