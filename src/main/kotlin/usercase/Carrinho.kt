package usercase

import EntradaDoUsuario
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
        val quantidade = EntradaDoUsuario.lerQuantidade(tipo)

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

        exibirTotal()
    }

    fun adicionarCombo(opcao: Int) {

        val quantidade = EntradaDoUsuario.lerQuantidade("combo")

        val comboEscolhido = when (opcao) {
            1 -> Combo1(quantidade)
            2 -> Combo2(quantidade)
            3 -> Combo3(quantidade)
            4 -> Combo4(quantidade)
            5 -> Combo5(quantidade)
            6 -> Combo6(quantidade)
            7 -> Combo7(quantidade)
            8 -> Combo8(quantidade)
            else -> throw IllegalArgumentException("Opção inválida")
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
            exibirTotal()
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