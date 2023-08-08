class Dinheiro : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        print("\nDigite o valor que irá pagar em dinheiro: ")
        val valorPago = readln().toDouble()

        if (valorPago < valor) {
            throw UnsupportedOperationException("\nO valor informado para o pagamento é menor que o total do pedido.")
        } else if (valorPago >= valor) {
            println("\nValor do Troco: ${valorPago - valor}")
            println("\nCompra finalizada com sucesso!Boa refeição!")
        }
    }
}