package model.Produtos.Lanches

class Xburger(quantidade: Int) : Lanche("LAN$idLanche", quantidade, "X-Burger", 10.0) {
    companion object {
        val ingredientes = mutableListOf("Pão de brioche", "hamburguer", "cheddar", "maionese")
    }
}