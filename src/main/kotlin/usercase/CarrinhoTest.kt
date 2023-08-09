package usercase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarrinhoTest {

//    @org.junit.jupiter.api.Test
//    fun adicionar() {
//    }
//
//    @org.junit.jupiter.api.Test
//    fun adicionarCombo() {
//    }
//
//    @org.junit.jupiter.api.Test
//    fun escolherProduto() {
//    }
//
//    @org.junit.jupiter.api.Test
//    fun calcularTotalCarrinho() {
//    }
//
//    @org.junit.jupiter.api.Test
//    fun editarItem() {
//    }

    @Test
    fun remover() {
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", 1)
        carrinho.remover("BEB9")
        assertEquals(0, carrinho.produtosAdicionados.size)
    }}


//    @org.junit.jupiter.api.Test
//    fun exibirCarrinho() {
//    }
//
//    @org.junit.jupiter.api.Test
//    fun exibirTotal() {
//    }
//}