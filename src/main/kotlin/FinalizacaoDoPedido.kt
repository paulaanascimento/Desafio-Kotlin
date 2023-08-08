class FinalizacaoDoPedido {
    private val pagamento = Pagamento()
    private val carrinhoView = CarrinhoView()

    fun finalizarPedido() {
        carrinhoView.exibirCarrinho()
        carrinhoView.exibirTotal()
        pagamento.selecionarPagamento()
    }
}