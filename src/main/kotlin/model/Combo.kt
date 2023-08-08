package model

class Combo (private val lanche:Lanche, private val bebida: Bebida, private val sobremesa:Sobremesa, nome:String, quantidade: Int) : Produto ("COM${idCombo}", quantidade, nome, (lanche.valor + bebida.valor + sobremesa.valor) - 5.0) {
    override fun mostrarInformacoes() {
        println("\nCombo: $nome\n" +
                "Bebida: ${bebida.nome} - ${bebida.tipo}\n" +
                "Sobremesa: ${sobremesa.nome} - ${sobremesa.tipo}")
        super.mostrarInformacoes()
    }
}