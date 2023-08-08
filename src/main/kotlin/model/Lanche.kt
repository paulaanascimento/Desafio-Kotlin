package model

open class Lanche (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){
    var observacao = ""

    override fun mostrarInformacoes(){
        println("\nLanche: $nome")
        super.mostrarInformacoes()
        println("Observação: $observacao")
    }
}