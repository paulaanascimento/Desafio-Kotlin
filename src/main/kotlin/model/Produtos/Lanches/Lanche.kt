package model.Produtos.Lanches

import model.Produtos.Produto

open class Lanche(
    codigo: String, quantidade: Int, nome: String, valor: Double
) : Produto(codigo, quantidade, nome, valor) {
    var observacao = ""

    companion object {
        var idLanche = 9
    }

    override fun mostrarInformacoes() {
        println("\nLanche: $nome")
        super.mostrarInformacoes()
        println("Observação: $observacao")
    }
}