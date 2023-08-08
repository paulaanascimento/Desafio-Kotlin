package usercase

class FinalizacaoDoPedido {
    private val pagamento = Pagamento()
    private val carrinho = Carrinho()

    fun finalizarPedido() {
        carrinho.exibirCarrinho()
        carrinho.exibirTotal()
        pagamento.selecionarPagamento()
    }
}