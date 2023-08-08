package model

open class Bebida (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){

    override fun mostrarInformacoes(){
        println("\nBebida: $nome - $tipo")
        super.mostrarInformacoes()
    }
}