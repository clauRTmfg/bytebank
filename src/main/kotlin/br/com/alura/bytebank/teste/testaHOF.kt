package br.com.alura.bytebank.br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaHigherOrderFunctions() {

    // aqui o 3o parâmetro da chamada pode ser como expressão lambda,
    // pois o tipo função é o último parâmetro da função.
    funcaoSoma(2, 7) {valor ->
        println(valor) // isto só é executado se lá dentro de funcaoSoma
        // <resultado> for executado
    }
    // ou assim
    funcaoSoma(1, 5, resultado = (::println))

    somaReceiver(1, 5, resultado = (::println))


    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }
    SistemaInterno().login(autenticavel, 1234, autenticado = {
        println("realizar pagamento") // isto só será executado se a autenticação for feita
    })
}

fun funcaoSoma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("executando soma")
    resultado(a + b) // esta linha é necessária para que o println lá em cima funcione
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("executando soma")
    resultado(a + b)
}