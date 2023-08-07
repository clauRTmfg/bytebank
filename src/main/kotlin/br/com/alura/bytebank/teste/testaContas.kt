package br.com.alura.bytebank.teste

import br.com.alura.bytebank.exception.AutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca

fun testaContas() {
    val clau = Cliente(nome = "Clau", cpf = "0", senha = 1)
    val cc = ContaCorrente(titular = clau, numero = 1001)
    val re = Cliente(nome = "Re", cpf = "0", senha = 2)
    val cp = ContaPoupanca(titular = re, numero = 2001)

    cc.deposita(1000.0)
    cp.deposita(1000.0)

    println("cc saldo : ${cc.saldo}")
    println("cp saldo : ${cp.saldo}")

    println()
    cc.saca(100.0)
    cp.saca(100.0)

    println("cc saldo : ${cc.saldo}")
    println("cp saldo : ${cp.saldo}")
    println()

    try {
        cc.transfere(cp, 50.0, 2)
        println("Transferência com sucesso !")
    } catch(e: SaldoInsuficienteException) {
        println("Falha na transferência: ${e.message}")
        e.printStackTrace()
    } catch (e: AutenticacaoException) {
        println("Senha inválida : ${e.message}")
        e.printStackTrace()
    } catch (e: Exception) { /* aqui trata qquer outro erro possível */
        println("Erro desconhecido")
        e.printStackTrace()
    }


    println("cc saldo : ${cc.saldo}")
    println("cp saldo : ${cp.saldo}")
    println()
}