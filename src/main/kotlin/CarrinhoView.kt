import model.Produto
import usercase.Carrinho

class CarrinhoView {

    private val carrinho = Carrinho()

    fun exibirCarrinho() {
        println("\n---------- CARRINHO ----------")
        carrinho.produtosAdicionados.forEach { produto: Produto -> produto.mostrarInformacoes() }
    }

    fun exibirTotal() {
        println("\nVALOR TOTAL DOS PEDIDOS: ${carrinho.calcularTotalCarrinho()}")
    }
}