package model.Produtos

import model.Constantes
import model.Produtos.Bebidas.Bebida
import model.Produtos.Bebidas.Refrigerante
import model.Produtos.Bebidas.Suco
import model.Produtos.Lanches.Lanche
import model.Produtos.Lanches.Xburger
import model.Produtos.Lanches.Xsalada
import model.Produtos.Sobremesas.Mousse
import model.Produtos.Sobremesas.Sobremesa
import model.Produtos.Sobremesas.Sorvete
import usercase.Carrinho

open class Combo(
    private val lanche: Lanche,
    private val bebida: Bebida,
    private val sobremesa: Sobremesa,
    nome: String, quantidade: Int
) : Produto(
    "COM$idCombo", quantidade, nome,
    (lanche.valor + bebida.valor + sobremesa.valor) - 5.0
) {

    companion object{
        var idCombo = 9
    }
    override fun mostrarInformacoes() {
        println(
            "\nCombo: $nome\n" +
                    "Bebida: ${bebida.nome} - ${bebida.tipo}\n" +
                    "Sobremesa: ${sobremesa.nome} - ${sobremesa.tipo}"
        )
        super.mostrarInformacoes()
    }
}

class Combo1(quantidade: Int) : Combo(
    Xburger(1),
    Refrigerante(1),
    Sorvete(1),
    Constantes.COMBO1,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesRefrigerante, Constantes.REFRIGERANTES)
        carrinho.escolherProduto(this, carrinho.opcoesSorvete, Constantes.SORVETES)
    }
}

class Combo2(quantidade: Int) : Combo(
    Xburger(1),
    Refrigerante(1),
    Mousse(1),
    Constantes.COMBO2,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesRefrigerante, Constantes.REFRIGERANTES)
        carrinho.escolherProduto(this, carrinho.opcoesMousses, Constantes.MOUSSES)
    }
}

class Combo3(quantidade: Int) : Combo(
    Xburger(1),
    Suco(1),
    Sorvete(1),
    Constantes.COMBO3,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesSuco, Constantes.SUCOS)
        carrinho.escolherProduto(this, carrinho.opcoesSorvete, Constantes.SORVETES)
    }
}

class Combo4(quantidade: Int) : Combo(
    Xburger(1),
    Suco(1),
    Mousse(1),
    Constantes.COMBO4,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesSuco, Constantes.SUCOS)
        carrinho.escolherProduto(this, carrinho.opcoesMousses, Constantes.MOUSSES)
    }
}

class Combo5(quantidade: Int) : Combo(
    Xsalada(1),
    Refrigerante(1),
    Sorvete(1),
    Constantes.COMBO5,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesRefrigerante, Constantes.REFRIGERANTES)
        carrinho.escolherProduto(this, carrinho.opcoesSorvete, Constantes.SORVETES)
    }
}

class Combo6(quantidade: Int) : Combo(
    Xsalada(1),
    Refrigerante(1),
    Mousse(1),
    Constantes.COMBO6,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesRefrigerante, Constantes.REFRIGERANTES)
        carrinho.escolherProduto(this, carrinho.opcoesMousses, Constantes.MOUSSES)
    }
}

class Combo7(quantidade: Int) : Combo(
    Xsalada(1),
    Suco(1),
    Sorvete(1),
    Constantes.COMBO7,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesSuco, Constantes.SUCOS)
        carrinho.escolherProduto(this, carrinho.opcoesSorvete, Constantes.SORVETES)
    }
}

class Combo8(quantidade: Int) : Combo(
    Xsalada(1),
    Suco(1),
    Mousse(1),
    Constantes.COMBO8,
    quantidade
) {
    init {
        val carrinho = Carrinho()
        carrinho.escolherProduto(this, carrinho.opcoesSuco, Constantes.SUCOS)
        carrinho.escolherProduto(this, carrinho.opcoesMousses, Constantes.MOUSSES)
    }
}