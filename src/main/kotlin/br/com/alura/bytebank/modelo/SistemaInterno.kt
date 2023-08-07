package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.modelo.Autenticavel

class SistemaInterno {

    fun login(usuario: Autenticavel, senha: Int, autenticado: () -> Unit = {}){
        if (usuario.autentica(senha)){
            println("Bem-vindo ao Bytebank")
            autenticado() // o código deste tipo função é aquele implementado lá na
             //  chamada do login em testeHOF
        } else {
            println("Falha na autenticação")
        }
    }
}