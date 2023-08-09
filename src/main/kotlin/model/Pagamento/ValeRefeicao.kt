package model.Pagamento

import model.Constantes

class ValeRefeicao : FormaDePagamento {
    override fun processarPagamento(valor: Double) {
        println(Constantes.COMPRA_FINALIZADA)
    }
}