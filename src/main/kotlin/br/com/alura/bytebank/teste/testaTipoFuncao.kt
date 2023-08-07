package br.com.alura.bytebank.br.com.alura.bytebank.teste

fun testaTipoFuncao() {

    //Tipo Função Referência
    val minhaFuncao = ::soma
    println(minhaFuncao(3, 4))
    println(soma(8, 9))

    // Tipo Função Classe
    val minhaFuncaoClass = Soma()
    println(minhaFuncaoClass(5, 9))

    // Tipo Função Lambda
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b -> a + b }
    println(minhaFuncaoLambda(10, 6))

    // Tipo Função Anônima
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(1, 9))

    // Tipo Função Lambda com mais de um retorno possível.
    // Para isso é necessário o uso de Labels, senão é retornado apenas o último comando
    val calculaBonificacaoLambda: (salario: Double) -> Double = label@{ salario ->
        if (salario > 1000.0) {
            return@label salario + 50
        }
        salario + 100.0
    }
    println(calculaBonificacaoLambda(1100.0))

    // Tipo Função Anônima com mais de um retorno
    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0) {
            return salario + 50
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(2000.0))
}

fun soma(a: Int, b: Int) : Int {
    return a + b
}

class Soma: (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}

