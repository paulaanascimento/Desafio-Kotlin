package usercase

import model.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarrinhoTest {

    @Test
    fun getProdutosAdicionados() {
    }

    @Test
    fun deveAdicionarXburgerALista() {
        val inputStream = "2".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("x-burger", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Xburger)
    }

    @Test
    fun deveAdicionarXSaladaALista() {
        val inputStream = "1".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("x-salada", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Xsalada)
    }

    @Test
    fun deveAdicionarRefrigeranteALista() {
        val inputStream = "1".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Refrigerante)
    }

    @Test
    fun deveAdicionarSucoALista() {
        val inputStream = "3".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("suco", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Suco)
    }

    @Test
    fun deveAdicionarSorveteALista() {
        val inputStream = "1".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("sorvete", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Sorvete)
    }

    @Test
    fun deveAdicionarMousseALista() {
        val inputStream = "2".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionar("mousse", inputStream)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Mousse)
    }

    @Test
    fun adicionarCombo() {
    }

    @Test
    fun calcularTotalCarrinho() {
    }

    @Test
    fun mostrarTotalCarrinho() {
    }

    @Test
    fun mostrarProdutosAdicionados() {
    }

    @Test
    fun editarItem() {
    }

    @Test
    fun remover() {
    }
}