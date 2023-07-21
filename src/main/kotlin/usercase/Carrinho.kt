package usercase

import model.*

class Carrinho {
    companion object{
        val produtosAdicionados = ArrayList<Produto>()

        private fun mostrarIngredientes(tipo:String) {
            when (tipo) {
                "x-burger" -> {
                    println("\n---------- X-BURGER ----------\nIngredientes: ${Xburger.ingredientes}")
                }
                "x-salada" -> {
                    println("\n---------- X-SALADA ----------\nIngredientes: ${Xsalada.ingredientes}")
                }
            }
        }

        fun adicionar(tipo: String){
            mostrarIngredientes(tipo)
            var quantidade = 0
            do{
                try {
                    print("\nDigite a quantidade de $tipo que deseja comprar: ")
                    quantidade = readln().toInt()

                    if(quantidade <= 0){
                        println("\nDigite um número maior que zero.")
                    }
                } catch (exception:IllegalArgumentException){
                    println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
                }
            }while (quantidade <=0)

            val produtoEscolhido = when (tipo) {
                "x-burger" -> {
                    Xburger(quantidade)
                }
                "x-salada" -> {
                    Xsalada(quantidade)
                }
                "refrigerante" -> {
                    Refrigerante(quantidade)
                }
                else -> {
                    Suco(quantidade)
                }
            }

            when (tipo) {
                "refrigerante" -> {
                    escolherRefrigerante(produtoEscolhido as Refrigerante)
                }
                "suco" -> {
                    escolherSuco(produtoEscolhido as Suco)
                }
                else -> adicionarObservacao(produtoEscolhido as Lanche)
            }

            produtosAdicionados.add(produtoEscolhido)

            println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
            produtoEscolhido.mostrarInformacoes()

            mostrarTotalCarrinho()
        }

        private fun escolherRefrigerante(refrigerante: Refrigerante){
            do{
                println("\n---------- REFRIGERANTES DISPONÍVEIS ----------\n" +
                        "\t1 - Coca-Cola Original\n" +
                        "\t2 - Cola-Cola Sem Açúcar\n" +
                        "\t3 - Guaraná Mineiro\n" +
                        "\t4 - Fanta Laranja\n" +
                        "\t5 - Fanta Uva")
                print("Digite o número correspondente a opção desejada: ")

                try {
                    when(readln().toInt()){
                        1 -> {
                            refrigerante.tipo = "Coca-Cola Original"
                            return
                        }
                        2 -> {
                            refrigerante.tipo = "Cola-Cola Sem Açúcar"
                            return
                        }
                        3 -> {
                            refrigerante.tipo = "Guaraná Mineiro"
                            return
                        }
                        4 -> {
                            refrigerante.tipo = "Fanta Laranja"
                            return
                        }
                        5 -> {
                            refrigerante.tipo = "Fanta Uva"
                            return
                        }
                        else -> println("\nOpção inválida, tente novamente.")
                    }
                } catch (exception:IllegalArgumentException){
                    println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
                }

            } while (true)
        }

        private fun escolherSuco(suco: Suco){
            do{
                println("\n---------- SUCOS DISPONÍVEIS ----------\n" +
                        "\t1 - Del Valle Laranja\n" +
                        "\t2 - Del Valle Uva\n" +
                        "\t3 - Del Valle Maracujá\n" +
                        "\t4 - Natural One Maçã\n" +
                        "\t5 - Natural One Limão Siciliano")
                print("Digite o número correspondente a opção desejada: ")

                try {
                    when(readln().toInt()){
                        1 -> {
                            suco.tipo = "Del Valle Laranja"
                            return
                        }
                        2 -> {
                            suco.tipo = "Del Valle Uva"
                            return
                        }
                        3 -> {
                            suco.tipo = "Del Valle Maracujá"
                            return
                        }
                        4 -> {
                            suco.tipo = "Natural One Maçã"
                            return
                        }
                        5 -> {
                            suco.tipo = "Natural One Limão Siciliano"
                            return
                        }
                        else -> println("\nOpção inválida, tente novamente.")
                    }
                } catch (exception:IllegalArgumentException){
                    println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
                }

            } while (true)
        }

        private fun adicionarObservacao(lanche: Lanche){
            do{
                println("\nDeseja adicionar alguma observação?\n" +
                        "\t1 - Sim\n" +
                        "\t2 - Não")
                print("Digite o número correspondente a opção desejada: ")

                try {
                    when(readln().toInt()){
                        1 -> {
                            println("\n---------- ADICIONANDO OBSERVAÇÃO ----------")
                            print("Escreva a sua observação: ")
                            lanche.observacao = readln()
                            return
                        }
                        2 -> return
                        else -> println("\nOpção inválida, tente novamente.")
                    }
                } catch (exception:IllegalArgumentException){
                    println("\nFormato inválido, para escolher uma opção, você deve informar o número dela.")
                }

            } while (true)
        }

        fun calcularTotalCarrinho():Double{
            var soma = 0.0
            produtosAdicionados.forEach { produto: Produto -> soma += produto.valorTotal}
            return soma
        }

        fun mostrarTotalCarrinho(){
            println("\nVALOR TOTAL DOS PEDIDOS: ${calcularTotalCarrinho()}")
        }

        fun mostrarProdutosAdicionados(){
            println("\n---------- CARRINHO ----------")
            produtosAdicionados.forEach { produto: Produto -> produto.mostrarInformacoes() }
        }

        private fun procurarProduto(codigo:String):Produto{
            val produtoProcurado = produtosAdicionados.filter { produto: Produto -> produto.codigo == codigo }

            if(produtoProcurado.isEmpty()){
                throw NoSuchElementException("\nNão há produto associado ao código informado.")
            } else return produtoProcurado.first()
        }

        fun editarItem(){
            println("\n---------- EDITANDO PRODUTO ----------")
            print("Digite o código do produto que deseja editar: ")

            try {
                val produto = procurarProduto(readln())
                produto.mostrarInformacoes()

                var quantidade: Int
                do{
                    print("\nDigite a nova quantidade: ")
                    quantidade = readln().toInt()

                    if(quantidade <= 0){
                            println("\nDigite um número maior que zero.")
                    }
                }while (quantidade <=0)

                produto.quantidade = quantidade

                println("\n---------- PRODUTO EDITADO ----------")
                produto.mostrarInformacoes()
                mostrarTotalCarrinho()
            } catch (exception:IllegalArgumentException){
                println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
            }catch (exception:NoSuchElementException){
                println(exception.message)
            }
        }

        fun remover(){
            println("\n---------- REMOVENDO PRODUTO ----------")
            print("Digite o código do produto que deseja remover: ")
            try {
                val produto = procurarProduto(readln())
                println("\n---------- PRODUTO ----------")
                produto.mostrarInformacoes()
                produtosAdicionados.remove(produto)
                println("\nO PRODUTO ACIMA FOI REMOVIDO COM SUCESSO!")
                mostrarTotalCarrinho()
            } catch (exception:NoSuchElementException){
                println(exception.message)
            }
        }
    }
}