package model

class Xsalada(quantidade:Int):Lanche("LAN${idLanche}", quantidade, "X-Salada", 12.0){
    companion object{
        val ingredientes = mutableListOf("Pão de brioche", "hamburguer", "muçarela", "alface", "tomate", "maionese")
    }
}