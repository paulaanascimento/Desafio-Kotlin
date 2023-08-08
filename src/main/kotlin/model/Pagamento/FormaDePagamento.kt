package model.Pagamento

interface FormaDePagamento {
    fun processarPagamento(valor:Double)
}