package model.Produtos.Bebidas

import model.Produtos.Produto

open class Bebida(
    codigo: String, quantidade: Int, nome: String, valor: Double
) : Produto(codigo, quantidade, nome, valor) {

    companion object {
        var idBebida = 9
    }

    override fun mostrarInformacoes() {
        println("\nBebida: $nome - $tipo")
        super.mostrarInformacoes()
    }
}