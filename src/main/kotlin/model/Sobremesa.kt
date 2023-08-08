package model

open class Sobremesa (codigo:String, quantidade:Int, nome:String, valor:Double) : Produto (codigo, quantidade, nome, valor){

    override fun mostrarInformacoes(){
        println("\nSobremesa: $nome - $tipo")
        super.mostrarInformacoes()
    }
}