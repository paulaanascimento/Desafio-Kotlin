package usercase

import model.Constantes
import model.Pagamento.CartaoDeCredito
import model.Pagamento.CartaoDeDebito
import model.Pagamento.Dinheiro
import model.Pagamento.ValeRefeicao

class Pagamento {
    private val carrinho = Carrinho()
    private var id = 109

    fun selecionarPagamento() {
        val formasDePagamento = listOf(
            CartaoDeCredito(),
            CartaoDeDebito(),
            ValeRefeicao(),
            Dinheiro()
        )

        id++
        do {
            println(
                "\n---------- FORMAS DE PAGAMENTO ----------\n" +
                        "\t1 - Cartão de Crédito\n" +
                        "\t2 - Cartão de Débito\n" +
                        "\t3 - Vale Refeição\n" +
                        "\t4 - Dinheiro"
            )
            print(Constantes.OPCAO_DESEJADA)

            try {
                val opcao = readln().toInt()
                if (opcao in 1..4) {
                    val formaDePagamento = formasDePagamento[opcao - 1]
                    formaDePagamento.processarPagamento(carrinho.calcularTotalCarrinho())
                    println("CÓDIGO PARA RETIRAR O PEDIDO CLI$id")
                    return
                } else {
                    println(Constantes.OPCAO_INVALIDA)
                }
            } catch (exception: IllegalArgumentException) {
                println(Constantes.FORMATO_INVALIDO_ITEM)
            } catch (exception: UnsupportedOperationException) {
                println(exception.message)
            }

        } while (true)
    }
}