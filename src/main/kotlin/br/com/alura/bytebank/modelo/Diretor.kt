package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Administrador

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : Administrador(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override val bonificacao: Double
        get() {
            return salario + plr
        }
}