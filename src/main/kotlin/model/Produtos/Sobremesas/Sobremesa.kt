package model.Produtos.Sobremesas

import model.Produtos.Produto

open class Sobremesa(
    codigo: String, quantidade: Int, nome: String, valor: Double
) : Produto(codigo, quantidade, nome, valor) {

    companion object{
        var idSobremesa = 9
    }

    override fun mostrarInformacoes() {
        println("\nSobremesa: $nome - $tipo")
        super.mostrarInformacoes()
    }
}