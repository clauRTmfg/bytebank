package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Administrador

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int
) : Administrador(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override val bonificacao: Double
        get() {
            return salario
        }
}