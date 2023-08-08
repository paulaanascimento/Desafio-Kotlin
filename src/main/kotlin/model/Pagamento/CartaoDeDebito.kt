package model.Pagamento

import Constantes

class CartaoDeDebito : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        println(Constantes.COMPRA_FINALIZADA)
    }
}