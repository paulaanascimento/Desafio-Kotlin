package model.Pagamento

import model.Constantes

class CartaoDeDebito : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        println(Constantes.COMPRA_FINALIZADA)
    }
}