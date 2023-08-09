package usercase

import model.Produtos.Bebidas.Refrigerante
import model.Produtos.Bebidas.Suco
import model.Produtos.Combo
import model.Produtos.Lanches.Xburger
import model.Produtos.Lanches.Xsalada
import model.Produtos.Sobremesas.Mousse
import model.Produtos.Sobremesas.Sorvete
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarrinhoTest {
    @Test
    fun deveAdicionarLanche() {
        val carrinho = Carrinho()
        carrinho.adicionar("X-Burger", 2)
        carrinho.adicionar("X-Salada", 1)
        assertEquals(2, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Xburger)
        assertTrue(carrinho.produtosAdicionados[1] is Xsalada)
    }

    @Test
    fun deveAdicionarBebida() {
        val carrinho = Carrinho()
        carrinho.adicionar("Suco", 1)
        carrinho.adicionar("Refrigerante", 1)
        assertEquals(2, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Suco)
        assertTrue(carrinho.produtosAdicionados[1] is Refrigerante)
    }

    @Test
    fun deveAdicionarSobremesa() {
        val carrinho = Carrinho()
        carrinho.adicionar("Sorvete", 10)
        carrinho.adicionar("Mousse", 1)
        assertEquals(2, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Sorvete)
        assertTrue(carrinho.produtosAdicionados[1] is Mousse)
    }

    @Test
    fun deveAdicionarCombo() {
        val carrinho = Carrinho()
        carrinho.adicionarCombo(5, 1)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Combo)
    }

    @Test
    fun deveEditarItem() {
        val carrinho = Carrinho()
        carrinho.adicionar("Refrigerante", 2)
        assertEquals(2, carrinho.produtosAdicionados[0].quantidade)
        carrinho.editarItem("BEB9", 5)
        assertEquals(5, carrinho.produtosAdicionados[0].quantidade)
    }

    @Test
    fun deveRemoverProduto() {
        val carrinho = Carrinho()
        carrinho.adicionar("Refrigerante", 1)
        carrinho.remover("BEB9")
        assertEquals(0, carrinho.produtosAdicionados.size)
    }
}