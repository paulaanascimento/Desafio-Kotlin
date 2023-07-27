import model.idBebida
import model.idCombo
import model.idLanche
import model.idSobremesa
import usercase.Carrinho
import usercase.FinalizarPedido

val carrinho = Carrinho()

fun main() {
    print("\nBOAS VINDAS À LANCHONETE FASTFOOD")
    menuPrincipal()
}

fun menuPrincipal(){
    do{
        println("\n--------- MENU PRINCIPAL ---------\n" +
                "\t1 - Lanche\n" +
                "\t2 - Bebida\n" +
                "\t3 - Sobremesa\n" +
                "\t4 - Combo")
        print("Digite o número correspondente ao item desejado: ")

        try {
            when(readln().toInt()){
                1 -> lanche()
                2 -> bebida()
                3 -> sobremesa()
//                4 -> combo()
                else -> println("\nOpção inválida, tente novamente.")
            }
        } catch (exception:IllegalArgumentException){
            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
        }

    } while (true)
}

fun lanche(){
    idLanche++
    do{
        println("\n---------- LANCHE ----------\n" +
                "\t1 - X-Burger R$10,00\n" +
                "\t2 - X-Salada R$12,00")
        print("Digite o número correspondente ao item desejado: ")

        try {
            when(readln().toInt()){
                1 -> {
                    //carrinho.adicionar("x-burger")
                    continuar()
                }
                2 -> {
                    //carrinho.adicionar("x-salada")
                    continuar()
                }
                else -> println("\nOpção inválida, tente novamente.")
            }
        } catch (exception:IllegalArgumentException){
            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
        }

    } while (true)
}

fun bebida(){
    idBebida++
    do{
        println("\n---------- BEBIDA ----------\n" +
                "\t1 - Refrigerante R$8,00\n" +
                "\t2 - Suco R$6,00")
        print("Digite o número correspondente ao item desejado: ")

        try {
            when(readln().toInt()){
                1 -> {
                    //carrinho.adicionar("refrigerante")
                    continuar()
                }
                2 -> {
                    //carrinho.adicionar("suco")
                    continuar()
                }
                else -> println("\nOpção inválida, tente novamente.")
            }
        } catch (exception:IllegalArgumentException){
            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
        }

    } while (true)
}

fun sobremesa(){
    idSobremesa++
    do{
        println("\n---------- SOBREMESA ----------\n" +
                "\t1 - Sorvete R$7,00\n" +
                "\t2 - Mousse R$5,00")
        print("Digite o número correspondente ao item desejado: ")

        try {
            when(readln().toInt()){
                1 -> {
                    //carrinho.adicionar("sorvete")
                    continuar()
                }
                2 -> {
                    //carrinho.adicionar("mousse")
                    continuar()
                }
                else -> println("\nOpção inválida, tente novamente.")
            }
        } catch (exception:IllegalArgumentException){
            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
        }

    } while (true)
}

//fun combo(){
//    idCombo++
//    do{
//        println("\n---------- COMBO ----------\n" +
//                "\t1 - X-Burger, Refrigerante, Sorvete\n" +
//                "\t2 - X-Burger, Refrigerante, Mousse\n" +
//                "\t3 - X-Burger, Suco, Sorvete\n" +
//                "\t4 - X-Burger, Suco, Mousse\n" +
//                "\t5 - X-Salada, Refrigerante, Sorvete\n" +
//                "\t6 - X-Salada, Refrigerante, Mousse\n" +
//                "\t7 - X-Salada, Suco, Sorvete\n" +
//                "\t8 - X-Salada, Suco, Mousse\n")
//        print("Digite o número correspondente ao item desejado: ")
//
//        try {
//            when(readln().toInt()){
//                1 -> {
//                    carrinho.adicionarCombo(1)
//                    continuar()
//                }
//                2 -> {
//                    carrinho.adicionarCombo(2)
//                    continuar()
//                }
//                3 -> {
//                    carrinho.adicionarCombo(3)
//                    continuar()
//                }
//                4 -> {
//                    carrinho.adicionarCombo(4)
//                    continuar()
//                }
//                5 -> {
//                    carrinho.adicionarCombo(5)
//                    continuar()
//                }
//                6 -> {
//                    carrinho.adicionarCombo(6)
//                    continuar()
//                }
//                7 -> {
//                    carrinho.adicionarCombo(7)
//                    continuar()
//                }
//                8 -> {
//                    carrinho.adicionarCombo(8)
//                    continuar()
//                }
//                else -> println("\nOpção inválida, tente novamente.")
//            }
//        } catch (exception:IllegalArgumentException){
//            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
//        }
//
//    } while (true)
//}

fun continuar(){
    do{
        println("\n------------------------------\n" +
                "\t1 - Ver Carrinho\n" +
                "\t2 - Incluir Item\n" +
                "\t3 - Editar Item\n" +
                "\t4 - Remover Item\n" +
                "\t5 - Finalizar Pedido")
        print("Digite o número correspondente a opção desejada: ")

        try {
            when(readln().toInt()){
                1 -> carrinho.mostrarProdutosAdicionados()
                2 -> menuPrincipal()
//                3 -> carrinho.editarItem()
//                4 -> carrinho.remover()
                5 -> {
                    if(carrinho.produtosAdicionados.isEmpty()){
                        throw UnsupportedOperationException("\nO carrinho está vazio.")
                    } else {
                        val finalizarPedido = FinalizarPedido()
                        finalizarPedido.selecionarPagamento()
                        Thread.sleep(5000)
                        carrinho.produtosAdicionados.clear()
                        limparTerminal()
                        main()
                    }
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

fun limparTerminal() {
    for(i in 0..50){
        println()
    }
}