package br.com.alura.bytebank.modelo

data class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var complemento: String = "",
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = ""
) {


    override fun toString(): String {
        // exemplo de raw string (""")
        return """
Endereco:
$logradouro, $numero, ${complemento}.
$bairro, $cidade, ${estado}.
CEP: $cep
""".trimIndent()
    }

    // o ?  verifica se o objeto é null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco /* aqui é um casting */

        if (logradouro != other.logradouro) return false
        if (numero != other.numero) return false
        if (complemento != other.complemento) return false
        if (bairro != other.bairro) return false
        if (cidade != other.cidade) return false
        if (estado != other.estado) return false
        return cep == other.cep
    }

    override fun hashCode(): Int {
        var result = logradouro.hashCode()
        result = 31 * result + numero
        result = 31 * result + complemento.hashCode()
        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        result = 31 * result + estado.hashCode()
        result = 31 * result + cep.hashCode()
        return result
    }

    fun endCompleto() : String {
        return """
Endereco:
$logradouro, $numero, ${complemento}.
$bairro, $cidade - ${estado}.
CEP: $cep
""".trimIndent()
    }

}
