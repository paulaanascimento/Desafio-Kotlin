package usercase

class FinalizarPedido {
    companion object{
        private var id = 109

        fun selecionarPagamento(){
            Carrinho.mostrarProdutosAdicionados()
            Carrinho.mostrarTotalCarrinho()

            id++
            do{
                println("\n---------- FORMAS DE PAGAMENTO ----------\n" +
                        "\t1 - Cartão de Crédito\n" +
                        "\t2 - Cartão de Débito\n" +
                        "\t3 - Vale Refeição\n" +
                        "\t4 - Dinheiro")
                print("Digite o número correspondente a opção desejada: ")

                try {
                    when(readln().toInt()){
                        1, 2, 3 -> {
                            println("\nCompra finalizada com sucesso!Boa refeição!")
                            println("CÓDIGO PARA RETIRAR O PEDIDO CLI$id")
                            return
                        }
                        4 -> {
                            pagarEmDinheiro()
                            println("\nCompra finalizada com sucesso!Boa refeição!")
                            println("CÓDIGO PARA RETIRAR O PEDIDO CLI$id")
                            return
                        }
                        else -> println("\nOpção inválida, tente novamente.")
                    }
                } catch (exception:IllegalArgumentException){
                    println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
                } catch (exception:UnsupportedOperationException){
                    println(exception.message)
                }

            } while (true)
        }

        private fun pagarEmDinheiro(){
            print("\nDigite o valor que irá pagar em dinheiro: ")
            val valor = readln().toInt()

            if(valor < Carrinho.calcularTotalCarrinho()){
                throw UnsupportedOperationException("\nO valor informado para o pagamento é menor que o total do pedido.")
            } else if(valor > Carrinho.calcularTotalCarrinho()){
                println("\nValor do Troco: ${valor - Carrinho.calcularTotalCarrinho()}")
            }
        }
    }
}