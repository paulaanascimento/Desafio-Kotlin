package usercase

import CarrinhoView
import model.*

class Carrinho {
    private val carrinhoView = CarrinhoView()
    val produtosAdicionados = ArrayList<Produto>()

    private val opcoesRefrigerante =
        listOf("Coca-Cola Original", "Cola-Cola Sem Açúcar", "Guaraná Mineiro", "Fanta Laranja", "Fanta Uva")
    private val opcoesSuco =
        listOf(
        "Del Valle Laranja",
        "Del Valle Uva",
        "Del Valle Maracujá",
        "Natural One Maçã",
        "Natural One Limão Siciliano"
    )

    private val opcoesSorvete = listOf("Chocolate", "Baunilha", "Flocos", "Creme", "Napolitano")

    private val opcoesMousses = listOf("Chocolate", "Maracujá", "Limão", "Morango", "Leite Ninho")

    private fun mostrarIngredientes(tipo: String) {
        when (tipo) {
            "x-burger" -> {
                println("\n---------- X-BURGER ----------\nIngredientes: ${Xburger.ingredientes}")
            }

            "x-salada" -> {
                println("\n---------- X-SALADA ----------\nIngredientes: ${Xsalada.ingredientes}")
            }
        }
    }

    fun adicionar(tipo: String) {
        mostrarIngredientes(tipo)
        var quantidade = 0
        do {
            try {
                print("\nDigite a quantidade de $tipo que deseja comprar: ")
                quantidade = readln().toInt()

                if (quantidade <= 0) {
                    println("\nDigite um número maior que zero.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
            }
        } while (quantidade <= 0)

        val produtoEscolhido = when (tipo) {
            "x-burger" -> Xburger(quantidade)
            "x-salada" -> Xsalada(quantidade)
            "refrigerante" -> Refrigerante(quantidade)
            "suco" -> Suco(quantidade)
            "sorvete" -> Sorvete(quantidade)
            else -> Mousse(quantidade)
        }

        when (tipo) {
            "refrigerante" -> escolherProduto(produtoEscolhido, opcoesRefrigerante, "REFRIGERANTES")
            "suco" -> escolherProduto(produtoEscolhido, opcoesSuco, "SUCOS")
            "sorvete" -> escolherProduto(produtoEscolhido, opcoesSorvete, "SORVETES")
            "mousse" -> escolherProduto(produtoEscolhido, opcoesMousses, "MOUSSES")
            else -> adicionarObservacao(produtoEscolhido as Lanche)
        }

        produtosAdicionados.add(produtoEscolhido)

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        produtoEscolhido.mostrarInformacoes()

        carrinhoView.exibirTotal()
    }

    fun adicionarCombo(opcao: Int) {
        val lanche: Lanche
        val bebida: Bebida
        val sobremesa: Sobremesa

        var quantidade = 0
        do {
            try {
                print("\nDigite a quantidade de que deseja comprar do combo: ")
                quantidade = readln().toInt()

                if (quantidade <= 0) {
                    println("\nDigite um número maior que zero.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
            }
        } while (quantidade <= 0)

        when (opcao) {
            1 -> {
                lanche = Xburger(1)
                bebida = Refrigerante(1)
                sobremesa = Sorvete(1)

                escolherProduto(bebida, opcoesRefrigerante, "REFRIGERANTES")
                escolherProduto(sobremesa, opcoesSorvete, "SORVETES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Refrigerante, Sorvete", quantidade))
            }

            2 -> {
                lanche = Xburger(1)
                bebida = Refrigerante(1)
                sobremesa = Mousse(1)

                escolherProduto(bebida, opcoesRefrigerante, "REFRIGERANTES")
                escolherProduto(sobremesa, opcoesMousses, "MOUSSES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Refrigerante, Mousse", quantidade))
            }

            3 -> {
                lanche = Xburger(1)
                bebida = Suco(1)
                sobremesa = Sorvete(1)

                escolherProduto(bebida, opcoesSuco, "SUCOS")
                escolherProduto(sobremesa, opcoesSorvete, "SORVETES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Suco, Sorvete", quantidade))
            }

            4 -> {
                lanche = Xburger(1)
                bebida = Suco(1)
                sobremesa = Mousse(1)

                escolherProduto(bebida, opcoesSuco, "SUCOS")
                escolherProduto(sobremesa, opcoesMousses, "MOUSSES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Suco, Mousse", quantidade))
            }

            5 -> {
                lanche = Xsalada(1)
                bebida = Refrigerante(1)
                sobremesa = Sorvete(1)

                escolherProduto(bebida, opcoesRefrigerante, "REFRIGERANTES")
                escolherProduto(sobremesa, opcoesSorvete, "SORVETES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Refrigerante, Sorvete", quantidade))
            }

            6 -> {
                lanche = Xsalada(1)
                bebida = Refrigerante(1)
                sobremesa = Mousse(1)

                escolherProduto(bebida, opcoesRefrigerante, "REFRIGERANTES")
                escolherProduto(sobremesa, opcoesMousses, "MOUSSES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Refrigerante, Mousse", quantidade))
            }

            7 -> {
                lanche = Xsalada(1)
                bebida = Suco(1)
                sobremesa = Sorvete(1)

                escolherProduto(bebida, opcoesSuco, "SUCOS")
                escolherProduto(sobremesa, opcoesSorvete, "SORVETES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Suco, Sorvete", quantidade))
            }

            8 -> {
                lanche = Xsalada(1)
                bebida = Suco(1)
                sobremesa = Mousse(1)

                escolherProduto(bebida, opcoesSuco, "SUCOS")
                escolherProduto(sobremesa, opcoesMousses, "MOUSSES")

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Suco, Mousse", quantidade))
            }
        }

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        produtosAdicionados.last().mostrarInformacoes()

        carrinhoView.exibirTotal()
    }

    private fun escolherProduto(produto: Produto, opcoes: List<String>, categoria: String) {
        do {
            println("\n---------- $categoria DISPONÍVEIS ----------")
            opcoes.forEachIndexed { index, opcao ->
                println("\t${index + 1} - $opcao")
            }
            print("Digite o número correspondente a opção desejada: ")

            try {
                val escolha = readln().toInt()
                if (escolha in 1..opcoes.size) {
                    produto.tipo = opcoes[escolha - 1]
                    return
                } else {
                    println("\nOpção inválida, tente novamente.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
            }

        } while (true)
    }

    private fun adicionarObservacao(lanche: Lanche) {
        do {
            println(
                "\nDeseja adicionar alguma observação?\n" +
                        "\t1 - Sim\n" +
                        "\t2 - Não"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (readln().toInt()) {
                    1 -> {
                        println("\n---------- ADICIONANDO OBSERVAÇÃO ----------")
                        print("Escreva a sua observação: ")
                        lanche.observacao = readln()
                        return
                    }

                    2 -> return
                    else -> println("\nOpção inválida, tente novamente.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher uma opção, você deve informar o número dela.")
            }

        } while (true)
    }

    fun calcularTotalCarrinho(): Double {
        var soma = 0.0
        produtosAdicionados.forEach { produto: Produto -> soma += produto.valorTotal }
        return soma
    }

    private fun procurarProduto(codigo: String): Produto {
        val produtoProcurado = produtosAdicionados.filter { produto: Produto -> produto.codigo == codigo }

        if (produtoProcurado.isEmpty()) {
            throw NoSuchElementException("\nNão há produto associado ao código informado.")
        } else return produtoProcurado.first()
    }

    fun editarItem() {
        println("\n---------- EDITANDO PRODUTO ----------")
        print("Digite o código do produto que deseja editar: ")

        try {
            val produto = procurarProduto(readln())
            produto.mostrarInformacoes()

            var quantidade: Int
            do {
                print("\nDigite a nova quantidade: ")
                quantidade = readln().toInt()

                if (quantidade <= 0) {
                    println("\nDigite um número maior que zero.")
                }
            } while (quantidade <= 0)

            produto.quantidade = quantidade

            println("\n---------- PRODUTO EDITADO ----------")
            produto.mostrarInformacoes()
            carrinhoView.exibirTotal()
        } catch (exception: IllegalArgumentException) {
            println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
        } catch (exception: NoSuchElementException) {
            println(exception.message)
        }
    }

    fun remover() {
        println("\n---------- REMOVENDO PRODUTO ----------")
        print("Digite o código do produto que deseja remover: ")
        try {
            val produto = procurarProduto(readln())
            println("\n---------- PRODUTO ----------")
            produto.mostrarInformacoes()
            produtosAdicionados.remove(produto)
            println("\nO PRODUTO ACIMA FOI REMOVIDO COM SUCESSO!")
            carrinhoView.exibirTotal()
        } catch (exception: NoSuchElementException) {
            println(exception.message)
        }
    }
}