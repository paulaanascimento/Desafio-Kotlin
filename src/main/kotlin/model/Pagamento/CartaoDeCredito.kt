package model.Pagamento

import Constantes

class CartaoDeCredito : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        println(Constantes.COMPRA_FINALIZADA)
    }
}