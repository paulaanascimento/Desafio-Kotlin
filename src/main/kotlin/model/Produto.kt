package model

var idLanche = 9
var idBebida = 9
var idSobremesa = 9
var idCombo = 9

abstract class Produto (val codigo:String, var quantidade:Int, val nome:String, val valor:Double){
    var tipo = ""

    val valorTotal:Double
        get() = valor * quantidade

    open fun mostrarInformacoes(){
        println("Código: $codigo\n" +
                "Valor Unitário: $valor\n" +
                "Quantidade: $quantidade\n" +
                "Valor Total: $valorTotal")
    }
}
