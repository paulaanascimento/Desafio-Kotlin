import model.Constantes
import usercase.Carrinho

fun main() {
    print(Constantes.BOAS_VINDAS)

    val carrinho = Carrinho()
    val menu = Menu(carrinho)
    menu.menuPrincipal()
}

fun limparTerminal() {
    for(i in 0..50){
        println()
    }
}