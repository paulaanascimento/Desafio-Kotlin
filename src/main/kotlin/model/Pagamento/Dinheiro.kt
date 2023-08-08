package model.Pagamento

import Constantes

class Dinheiro : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        print(Constantes.PAGAMENTO_DINHEIRO)
        val valorPago = readln().toDouble()

        if (valorPago < valor) {
            throw UnsupportedOperationException(Constantes.VALOR_MENOR)
        } else if (valorPago >= valor) {
            val troco = valorPago - valor
            println("\nValor do Troco: $troco")
            println(Constantes.COMPRA_FINALIZADA)
        }
    }
}