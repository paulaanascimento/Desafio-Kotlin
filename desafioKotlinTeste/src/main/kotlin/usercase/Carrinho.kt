package usercase

import model.*
import java.io.*

class Carrinho {
    val produtosAdicionados = ArrayList<Produto>()

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

    fun adicionar(tipo: String, inputStream: InputStream) {
        mostrarIngredientes(tipo)
        var quantidade = 0
        try {
            print("\nDigite a quantidade de $tipo que deseja comprar: ")
            quantidade = BufferedReader(InputStreamReader(inputStream)).readLine().toInt()

            if (quantidade <= 0) {
                println("\nDigite um número maior que zero.")
            }
        } catch (exception: IllegalArgumentException) {
            println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
        }

        val produtoEscolhido = when (tipo) {
            "x-burger" -> Xburger(quantidade)
            "x-salada" -> Xsalada(quantidade)
            "refrigerante" -> Refrigerante(quantidade)
            "suco" -> Suco(quantidade)
            "sorvete" -> Sorvete(quantidade)
            else -> Mousse(quantidade)
        }

        when (tipo) {
            "refrigerante" -> escolherRefrigerante(produtoEscolhido as Refrigerante, "5".byteInputStream())
            "suco" -> escolherSuco(produtoEscolhido as Suco, "3".byteInputStream())
            "sorvete" -> escolherSorvete(produtoEscolhido as Sorvete, "1".byteInputStream())
            "mousse" -> escolherMousse(produtoEscolhido as Mousse, "4".byteInputStream())
            else -> adicionarObservacao(produtoEscolhido as Lanche, "2".byteInputStream())
        }

        produtosAdicionados.add(produtoEscolhido)

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        produtoEscolhido.mostrarInformacoes()

        mostrarTotalCarrinho()
    }

    fun adicionarCombo(opcao: Int, inputStream: InputStream, opcaoBebiba: InputStream, opcaoSobremesa: InputStream) {
        val lanche: Lanche
        val bebida: Bebida
        val sobremesa: Sobremesa

        var quantidade = 0
        do {
            try {
                print("\nDigite a quantidade de que deseja comprar do combo: ")
                quantidade = BufferedReader(InputStreamReader(inputStream)).readLine().toInt()

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

                escolherRefrigerante(bebida, opcaoBebiba)
                escolherSorvete(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Refrigerante, Sorvete", quantidade))
            }

            2 -> {
                lanche = Xburger(1)
                bebida = Refrigerante(1)
                sobremesa = Mousse(1)

                escolherRefrigerante(bebida, opcaoBebiba)
                escolherMousse(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Refrigerante, Mousse", quantidade))
            }

            3 -> {
                lanche = Xburger(1)
                bebida = Suco(1)
                sobremesa = Sorvete(1)

                escolherSuco(bebida, opcaoBebiba)
                escolherSorvete(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Suco, Sorvete", quantidade))
            }

            4 -> {
                lanche = Xburger(1)
                bebida = Suco(1)
                sobremesa = Mousse(1)

                escolherSuco(bebida, opcaoBebiba)
                escolherMousse(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Burger, Suco, Mousse", quantidade))
            }

            5 -> {
                lanche = Xsalada(1)
                bebida = Refrigerante(1)
                sobremesa = Sorvete(1)

                escolherRefrigerante(bebida, opcaoBebiba)
                escolherSorvete(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Refrigerante, Sorvete", quantidade))
            }

            6 -> {
                lanche = Xsalada(1)
                bebida = Refrigerante(1)
                sobremesa = Mousse(1)

                escolherRefrigerante(bebida, opcaoBebiba)
                escolherMousse(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Refrigerante, Mousse", quantidade))
            }

            7 -> {
                lanche = Xsalada(1)
                bebida = Suco(1)
                sobremesa = Sorvete(1)

                escolherSuco(bebida, opcaoBebiba)
                escolherSorvete(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Suco, Sorvete", quantidade))
            }

            8 -> {
                lanche = Xsalada(1)
                bebida = Suco(1)
                sobremesa = Mousse(1)

                escolherSuco(bebida, opcaoBebiba)
                escolherMousse(sobremesa, opcaoSobremesa)

                produtosAdicionados.add(Combo(lanche, bebida, sobremesa, "X-Salada, Suco, Mousse", quantidade))
            }
        }

        println("\n---------- PRODUTO ADICIONADO AO CARRINHO ----------")
        produtosAdicionados.last().mostrarInformacoes()

        mostrarTotalCarrinho()
    }

    private fun escolherRefrigerante(refrigerante: Refrigerante, inputStream: InputStream) {
        do {
            println(
                "\n---------- REFRIGERANTES DISPONÍVEIS ----------\n" +
                        "\t1 - Coca-Cola Original\n" +
                        "\t2 - Cola-Cola Sem Açúcar\n" +
                        "\t3 - Guaraná Mineiro\n" +
                        "\t4 - Fanta Laranja\n" +
                        "\t5 - Fanta Uva"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (BufferedReader(InputStreamReader(inputStream)).readLine().toInt()) {
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
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
            }

        } while (true)
    }

    private fun escolherSuco(suco: Suco, inputStream: InputStream) {
        do {
            println(
                "\n---------- SUCOS DISPONÍVEIS ----------\n" +
                        "\t1 - Del Valle Laranja\n" +
                        "\t2 - Del Valle Uva\n" +
                        "\t3 - Del Valle Maracujá\n" +
                        "\t4 - Natural One Maçã\n" +
                        "\t5 - Natural One Limão Siciliano"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (BufferedReader(InputStreamReader(inputStream)).readLine().toInt()) {
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
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
            }

        } while (true)
    }

    private fun escolherSorvete(sorvete: Sorvete, inputStream: InputStream) {
        do {
            println(
                "\n---------- SORVETES DISPONÍVEIS ----------\n" +
                        "\t1 - Chocolate\n" +
                        "\t2 - Baunilha\n" +
                        "\t3 - Flocos\n" +
                        "\t4 - Creme\n" +
                        "\t5 - Napolitano"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (BufferedReader(InputStreamReader(inputStream)).readLine().toInt()) {
                    1 -> {
                        sorvete.sabor = "Chocolate"
                        return
                    }

                    2 -> {
                        sorvete.sabor = "Baunilha"
                        return
                    }

                    3 -> {
                        sorvete.sabor = "Flocos"
                        return
                    }

                    4 -> {
                        sorvete.sabor = "Creme"
                        return
                    }

                    5 -> {
                        sorvete.sabor = "Napolitano"
                        return
                    }

                    else -> println("\nOpção inválida, tente novamente.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
            }

        } while (true)
    }

    private fun escolherMousse(mousse: Mousse, inputStream: InputStream) {
        do {
            println(
                "\n---------- MOUSSES DISPONÍVEIS ----------\n" +
                        "\t1 - Chocolate\n" +
                        "\t2 - Maracujá\n" +
                        "\t3 - Limão\n" +
                        "\t4 - Morango\n" +
                        "\t5 - Leite Ninho"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (BufferedReader(InputStreamReader(inputStream)).readLine().toInt()) {
                    1 -> {
                        mousse.sabor = "Chocolate"
                        return
                    }

                    2 -> {
                        mousse.sabor = "Maracujá"
                        return
                    }

                    3 -> {
                        mousse.sabor = "Limão"
                        return
                    }

                    4 -> {
                        mousse.sabor = "Morango"
                        return
                    }

                    5 -> {
                        mousse.sabor = "Leite Ninho"
                        return
                    }

                    else -> println("\nOpção inválida, tente novamente.")
                }
            } catch (exception: IllegalArgumentException) {
                println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
            }

        } while (true)
    }

    private fun adicionarObservacao(lanche: Lanche, inputStream: InputStream) {
        do {
            println(
                "\nDeseja adicionar alguma observação?\n" +
                        "\t1 - Sim\n" +
                        "\t2 - Não"
            )
            print("Digite o número correspondente a opção desejada: ")

            try {
                when (BufferedReader(InputStreamReader(inputStream)).readLine().toInt()) {
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

    fun mostrarTotalCarrinho() {
        println("\nVALOR TOTAL DOS PEDIDOS: ${calcularTotalCarrinho()}")
    }

    fun mostrarProdutosAdicionados() {
        println("\n---------- CARRINHO ----------")
        produtosAdicionados.forEach { produto: Produto -> produto.mostrarInformacoes() }
    }

    private fun procurarProduto(codigo: String): Produto {
        val produtoProcurado = produtosAdicionados.filter { produto: Produto -> produto.codigo == codigo }

        if (produtoProcurado.isEmpty()) {
            throw NoSuchElementException("\nNão há produto associado ao código informado.")
        } else return produtoProcurado.first()
    }

    fun editarItem(codigo: InputStream, novaQuantidade: InputStream, outputStream: OutputStream) {
        println("\n---------- EDITANDO PRODUTO ----------")
        print("Digite o código do produto que deseja editar: ")

        try {
            val produto = procurarProduto(BufferedReader(InputStreamReader(codigo)).readLine())
            produto.mostrarInformacoes()

            var quantidade: Int
            do {
                print("\nDigite a nova quantidade: ")
                quantidade = BufferedReader(InputStreamReader(novaQuantidade)).readLine().toInt()

                if (quantidade <= 0) {
                    println("\nDigite um número maior que zero.")
                }
            } while (quantidade <= 0)

            produto.quantidade = quantidade

            println("\n---------- PRODUTO EDITADO ----------")
            produto.mostrarInformacoes()
            mostrarTotalCarrinho()
        } catch (exception: IllegalArgumentException) {
            PrintStream(outputStream).println("\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.")
        } catch (exception: NoSuchElementException) {
            println(exception.message)
        }
    }

    fun remover(inputStream: InputStream, outputStream: OutputStream) {
        println("\n---------- REMOVENDO PRODUTO ----------")
        print("Digite o código do produto que deseja remover: ")
        try {
            val produto = procurarProduto(BufferedReader(InputStreamReader(inputStream)).readLine())
            println("\n---------- PRODUTO ----------")
            produto.mostrarInformacoes()
            produtosAdicionados.remove(produto)
            println("\nO PRODUTO ACIMA FOI REMOVIDO COM SUCESSO!")
            mostrarTotalCarrinho()
        } catch (exception: NoSuchElementException) {
            PrintStream(outputStream).println(exception.message)
        }
    }
}