package usercase

import model.Constantes
import model.Produtos.*
import model.Produtos.Bebidas.Refrigerante
import model.Produtos.Bebidas.Suco
import model.Produtos.Lanches.Lanche
import model.Produtos.Lanches.Xburger
import model.Produtos.Lanches.Xsalada
import model.Produtos.Sobremesas.Mousse
import model.Produtos.Sobremesas.Sorvete


class Carrinho {
    val produtosAdicionados = ArrayList<Produto>()

    val opcoesRefrigerante =
        listOf("Coca-Cola Original", "Cola-Cola Sem Açúcar", "Guaraná Mineiro", "Fanta Laranja", "Fanta Uva")

    val opcoesSuco =
        listOf(
        "Del Valle Laranja",
        "Del Valle Uva",
        "Del Valle Maracujá",
        "Natural One Maçã",
        "Natural One Limão Siciliano"
    )

    val opcoesSorvete = listOf("Chocolate", "Baunilha", "Flocos", "Creme", "Napolitano")

    val opcoesMousses = listOf("Chocolate", "Maracujá", "Limão", "Morango", "Leite Ninho")

    private fun mostrarIngredientes(tipo: String) {
        when (tipo) {
            "X-Burger" -> {
                println("\n---------- X-BURGER ----------\nIngredientes: ${Xburger.ingredientes}")
            }

            "X-Salada" -> {
                println("\n---------- X-SALADA ----------\nIngredientes: ${Xsalada.ingredientes}")
            }
        }
    }

    fun adicionar(tipo: String, quantidade:Int) {
        mostrarIngredientes(tipo)

        val produtoEscolhido = when (tipo) {
            "X-Burger" -> Xburger(quantidade)
            "X-Salada" -> Xsalada(quantidade)
            "Refrigerante" -> Refrigerante(quantidade)
            "Suco" -> Suco(quantidade)
            "Sorvete" -> Sorvete(quantidade)
            else -> Mousse(quantidade)
        }

        when (tipo) {
            "Refrigerante" -> escolherProduto(produtoEscolhido, opcoesRefrigerante, "REFRIGERANTES")
            "Suco" -> escolherProduto(produtoEscolhido, opcoesSuco, "SUCOS")
            "Sorvete" -> escolherProduto(produtoEscolhido, opcoesSorvete, "SORVETES")
            "Mousse" -> escolherProduto(produtoEscolhido, opcoesMousses, "MOUSSES")
            else -> adicionarObservacao(produtoEscolhido as Lanche)
        }

        produtosAdicionados.add(produtoEscolhido)

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        produtoEscolhido.mostrarInformacoes()

        exibirTotal()
    }

    fun adicionarCombo(opcao: Int, quantidade:Int) {

        val comboEscolhido = when (opcao) {
            1 -> Combo1(quantidade)
            2 -> Combo2(quantidade)
            3 -> Combo3(quantidade)
            4 -> Combo4(quantidade)
            5 -> Combo5(quantidade)
            6 -> Combo6(quantidade)
            7 -> Combo7(quantidade)
            8 -> Combo8(quantidade)
            else -> throw IllegalArgumentException(Constantes.OPCAO_INVALIDA)
        }

        produtosAdicionados.add(comboEscolhido)

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        comboEscolhido.mostrarInformacoes()

        exibirTotal()
    }

    fun escolherProduto(produto: Produto, opcoes: List<String>, categoria: String) {
        do {
            println("\n---------- $categoria DISPONÍVEIS ----------")
            opcoes.forEachIndexed { index, opcao ->
                println("\t${index + 1} - $opcao")
            }
            print(Constantes.OPCAO_DESEJADA)

            try {
                val escolha = readln().toInt()
                if (escolha in 1..opcoes.size) {
                    produto.tipo = opcoes[escolha - 1]
                    return
                } else {
                    println(Constantes.OPCAO_INVALIDA)
                }
            } catch (exception: IllegalArgumentException) {
                println(Constantes.FORMATO_INVALIDO_ITEM)
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
            print(Constantes.OPCAO_DESEJADA)

            try {
                when (readln().toInt()) {
                    1 -> {
                        println("\n---------- ADICIONANDO OBSERVAÇÃO ----------")
                        print("Escreva a sua observação: ")
                        lanche.observacao = readln()
                        return
                    }

                    2 -> return
                    else -> println(Constantes.OPCAO_INVALIDA)
                }
            } catch (exception: IllegalArgumentException) {
                println(Constantes.FORMATO_INVALIDO_OPCAO)
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

    fun editarItem(codigo: String) {
        println("\n---------- EDITANDO PRODUTO ----------")
        try {
            val produto = procurarProduto(codigo)

            var quantidade = EntradaDoUsuario.lerQuantidade(Constantes.NOVA_QUANTIDADE, produto.nome)

            produto.quantidade = quantidade

            println("\n---------- PRODUTO EDITADO ----------")
            produto.mostrarInformacoes()
            exibirTotal()
        } catch (exception: IllegalArgumentException) {
            println(Constantes.VALOR_INVALIDO_QUANTIDADE)
        } catch (exception: NoSuchElementException) {
            println(exception.message)
        }
    }

    fun remover(codigo: String) {
        println("\n---------- REMOVENDO PRODUTO ----------")
        try {
            val produto = procurarProduto(codigo)
            println("\n---------- PRODUTO ----------")
            produto.mostrarInformacoes()
            produtosAdicionados.remove(produto)
            println("\nO PRODUTO ACIMA FOI REMOVIDO COM SUCESSO!")
            exibirTotal()
        } catch (exception: NoSuchElementException) {
            println(exception.message)
        }
    }

    fun exibirCarrinho() {
        println("\n---------- CARRINHO ----------")
        produtosAdicionados.forEach { produto: Produto -> produto.mostrarInformacoes() }
    }

    fun exibirTotal() {
        println("\nVALOR TOTAL DOS PEDIDOS: ${calcularTotalCarrinho()}")
    }
}