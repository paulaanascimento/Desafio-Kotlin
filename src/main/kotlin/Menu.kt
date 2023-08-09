import model.Constantes
import model.Produtos.Bebidas.Bebida
import model.Produtos.Combo
import model.Produtos.Lanches.Lanche
import model.Produtos.Sobremesas.Sobremesa
import usercase.Carrinho
import usercase.EntradaDoUsuario
import usercase.FinalizacaoDoPedido

class Menu(private val carrinho: Carrinho) {
    private val opcoesLanche = listOf("X-Burger", "X-Salada")
    private val opcoesBebida = listOf("Refrigerante", "Suco")
    private val opcoesSobremesa = listOf("Sorvete", "Mousse")

    private val opcoesCombo = listOf(
        Constantes.COMBO1, Constantes.COMBO2, Constantes.COMBO3, Constantes.COMBO4,
                Constantes.COMBO5, Constantes.COMBO6, Constantes.COMBO7, Constantes.COMBO8)

    fun menuPrincipal(){
        do{
            println("\n--------- MENU PRINCIPAL ---------\n" +
                    "\t1 - Lanche\n" +
                    "\t2 - Bebida\n" +
                    "\t3 - Sobremesa\n" +
                    "\t4 - Combo")
            print(Constantes.ITEM_DESEJADO)

            try {
                val opcaoSelecionada = readln().toInt()
                when (opcaoSelecionada) {
                    1 -> Lanche.idLanche++
                    2 -> Bebida.idBebida++
                    3 -> Sobremesa.idSobremesa++
                    4 -> Combo.idCombo++
                    else -> println(Constantes.OPCAO_INVALIDA)
                }

                if (opcaoSelecionada in 1..4) {
                    menuSecundario(getOpcoes(opcaoSelecionada), getNomeCategoria(opcaoSelecionada))
                }
            } catch (exception:IllegalArgumentException){
                println(Constantes.FORMATO_INVALIDO_ITEM)
            }

        } while (true)
    }

    private fun menuSecundario(opcoes: List<String>, categoria: String){
        do{
            println("\n---------- $categoria ----------")
            opcoes.forEachIndexed { index, opcao ->
                println("\t${index + 1} - $opcao")
            }
            print(Constantes.ITEM_DESEJADO)

            try {
                val opcaoSelecionada = readln().toInt()
                if (opcaoSelecionada in 1..opcoes.size) {
                    if (categoria != "COMBO") {
                        carrinho.adicionar(opcoes[opcaoSelecionada - 1], EntradaDoUsuario.lerQuantidade(Constantes.QUANTIDADE, opcoes[opcaoSelecionada - 1]))
                    } else if (opcaoSelecionada in 1..8) {
                        carrinho.adicionarCombo(opcaoSelecionada, EntradaDoUsuario.lerQuantidade(Constantes.QUANTIDADE,"combo"))
                    }
                    continuar()
                } else {
                    println(Constantes.OPCAO_INVALIDA)
                }

            } catch (exception:IllegalArgumentException){
                println(Constantes.FORMATO_INVALIDO_ITEM)
            }

        } while (true)
    }

    private fun continuar(){
        do{
            println("\n------------------------------\n" +
                    "\t1 - Ver Carrinho\n" +
                    "\t2 - Incluir Item\n" +
                    "\t3 - Editar Item\n" +
                    "\t4 - Remover Item\n" +
                    "\t5 - Finalizar Pedido")
            print(Constantes.OPCAO_DESEJADA)

            try {
                when (readln().toInt()) {
                    1 -> carrinho.exibirCarrinho()
                    2 -> menuPrincipal()
//                    3 -> carrinho.editarItem(EntradaDoUsuario.lerCodigoProduto(Constantes.CODIGO_PRODUTO, "editar"))
                    4 -> carrinho.remover(EntradaDoUsuario.lerCodigoProduto(Constantes.CODIGO_PRODUTO, "remover"))
                    5 -> {
                        if (carrinho.produtosAdicionados.isEmpty()) {
                            throw UnsupportedOperationException("\nO carrinho está vazio.")
                        } else {
                            finalizarPedido()
                        }
                    }
                    else -> println(Constantes.OPCAO_INVALIDA)
                }
            } catch (exception:IllegalArgumentException){
                println(Constantes.FORMATO_INVALIDO_ITEM)
            } catch (exception:UnsupportedOperationException){
                println(exception.message)
            }

        } while (true)
    }

    private fun finalizarPedido() {
        val finalizacaoDoPedido = FinalizacaoDoPedido()
        finalizacaoDoPedido.finalizarPedido()
        Thread.sleep(5000)
        carrinho.produtosAdicionados.clear()
        limparTerminal()
        main()
    }

    private fun getOpcoes(selectedOption: Int): List<String> {
        return when (selectedOption) {
            1 -> opcoesLanche
            2 -> opcoesBebida
            3 -> opcoesSobremesa
            4 -> opcoesCombo
            else -> emptyList()
        }
    }

    private fun getNomeCategoria(selectedOption: Int): String {
        return when (selectedOption) {
            1 -> "LANCHE"
            2 -> "BEBIDA"
            3 -> "SOBREMESA"
            4 -> "COMBO"
            else -> ""
        }
    }
}