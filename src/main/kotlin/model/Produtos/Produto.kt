package model.Produtos

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
