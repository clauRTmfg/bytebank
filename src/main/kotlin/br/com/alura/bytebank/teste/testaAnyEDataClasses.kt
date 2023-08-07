package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaAnyEDataClasses() {
    val end1 = Endereco(
        logradouro = "Av. Lacerda Franco", numero = 570,
        complemento = "apto 57", bairro = "Cambuci", cidade = "São Paulo",
        estado = "SP", cep = "01536-000"
    )
    val end2 = end1.copy()
    val (logradouro, numero) = end1

    println(end1)
    println()
    println(logradouro)
    println(numero)
    println()
    println(end1.equals(end2))
}