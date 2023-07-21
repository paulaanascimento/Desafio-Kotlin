import model.idBebida
import model.idLanche
import usercase.Carrinho
import usercase.FinalizarPedido

fun main() {
    print("\nBOAS VINDAS À LANCHONETE FASTFOOD")
    menuPrincipal()
}

fun menuPrincipal(){
    do{
        println("\n--------- MENU PRINCIPAL ---------\n" +
                "\t1 - Lanche\n" +
                "\t2 - Bebida")
        print("Digite o número correspondente ao item desejado: ")

        try {
            when(readln().toInt()){
                1 -> lanche()
                2 -> bebida()
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
                    Carrinho.adicionar("x-burger")
                    continuar()
                }
                2 -> {
                    Carrinho.adicionar("x-salada")
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
                    Carrinho.adicionar("refrigerante")
                    continuar()
                }
                2 -> {
                    Carrinho.adicionar("suco")
                    continuar()
                }
                else -> println("\nOpção inválida, tente novamente.")
            }
        } catch (exception:IllegalArgumentException){
            println("\nFormato inválido, para escolher o item, você deve informar o número dele.")
        }

    } while (true)
}

fun continuar(){
    do{
        println("\n------------------------------\n" +
                "\t1 - Ver usercase.Carrinho\n" +
                "\t2 - Incluir Item\n" +
                "\t3 - Editar Item\n" +
                "\t4 - Remover Item\n" +
                "\t5 - Finalizar Pedido")
        print("Digite o número correspondente a opção desejada: ")

        try {
            when(readln().toInt()){
                1 -> Carrinho.mostrarProdutosAdicionados()
                2 -> menuPrincipal()
                3 -> Carrinho.editarItem()
                4 -> Carrinho.remover()
                5 -> {
                    if(Carrinho.produtosAdicionados.isEmpty()){
                       throw UnsupportedOperationException("\nO carrinho está vazio.")
                    } else {
                        FinalizarPedido.selecionarPagamento()
                        Thread.sleep(5000)
                        Carrinho.produtosAdicionados.clear()
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