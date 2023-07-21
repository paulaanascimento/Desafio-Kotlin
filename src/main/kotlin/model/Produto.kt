package model

var idLanche = 9
var idBebida = 9
var idSobremesa = 9
var idCombo = 9

abstract class Produto (val codigo:String, var quantidade:Int, val nome:String, val valor:Double){
    val valorTotal:Double
        get() = valor * quantidade

    open fun mostrarInformacoes(){
        println("Código: $codigo\n" +
                "Valor Unitário: $valor\n" +
                "Quantidade: $quantidade\n" +
                "Valor Total: $valorTotal")
    }
}

open class Lanche (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){
    var observacao = ""

    override fun mostrarInformacoes(){
        println("\nLanche: $nome")
        super.mostrarInformacoes()
        println("Observação: $observacao")
    }
}

class Xburger(quantidade:Int):Lanche("LAN${idLanche}", quantidade, "X-Burger", 10.0){
    companion object{
        val ingredientes = mutableListOf("Pão de brioche", "hamburguer", "cheddar", "maionese")
    }
}

class Xsalada(quantidade:Int):Lanche("LAN${idLanche}", quantidade, "X-Salada", 12.0){
    companion object{
        val ingredientes = mutableListOf("Pão de brioche", "hamburguer", "muçarela", "alface", "tomate", "maionese")
    }
}

open class Bebida (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){
    var tipo = ""

    override fun mostrarInformacoes(){
        println("\nBebida: $nome - $tipo")
        super.mostrarInformacoes()
    }
}

class Refrigerante(quantidade: Int):Bebida("BEB${idBebida}", quantidade, "Refrigerante", 8.0)

class Suco(quantidade: Int):Bebida("BEB${idBebida}", quantidade, "Suco", 6.0)

open class Sobremesa (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){
    var sabor = ""

    override fun mostrarInformacoes(){
        println("\nSobremesa: $nome - $sabor")
        super.mostrarInformacoes()
    }
}

class Sorvete(quantidade: Int):Sobremesa("SOB${idSobremesa}", quantidade, "Sorvete", 7.0)

class Mousse(quantidade: Int):Sobremesa("SOB${idSobremesa}", quantidade, "Mousse", 5.0)

class Combo (private val lanche:Lanche, private val bebida:Bebida, private val sobremesa:Sobremesa, nome:String, quantidade: Int) : Produto ("COM${idCombo}", quantidade, nome, (lanche.valor + bebida.valor + sobremesa.valor) - 5.0) {
    override fun mostrarInformacoes() {
        println("\nCombo: $nome\n" +
                "Bebida: ${bebida.nome} - ${bebida.tipo}\n" +
                "Sobremesa: ${sobremesa.nome} - ${sobremesa.sabor}")
        super.mostrarInformacoes()
    }
}
