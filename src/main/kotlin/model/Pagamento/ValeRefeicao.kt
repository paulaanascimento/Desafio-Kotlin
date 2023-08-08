package model.Pagamento

import Constantes
import model.Pagamento.FormaDePagamento

class ValeRefeicao : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        println(Constantes.COMPRA_FINALIZADA)
    }
}