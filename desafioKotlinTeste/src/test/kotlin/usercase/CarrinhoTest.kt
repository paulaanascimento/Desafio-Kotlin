package usercase

import model.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class CarrinhoTest {

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
    fun deveLancarExcecaoFormatoInvalido() {
        val inputStream = "teste".byteInputStream()
        val carrinho = Carrinho()

        assertThrows(IllegalArgumentException::class.java){
            carrinho.adicionar("mousse", inputStream)
        }
    }

    @Test
    fun deveAdicionarComboNormalmente() {
        val quantidade = "2".byteInputStream()
        val opcBebida = "3".byteInputStream()
        val opcSobremesa = "4".byteInputStream()
        val carrinho = Carrinho()
        carrinho.adicionarCombo(5,quantidade, opcBebida, opcSobremesa)
        assertEquals(1, carrinho.produtosAdicionados.size)
        assertTrue(carrinho.produtosAdicionados[0] is Combo)
    }

    @Test
    fun deveEditarItemNormalmente() {
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", "1".byteInputStream())
        assertEquals(1, carrinho.produtosAdicionados[0].quantidade)
        val outputStream = ByteArrayOutputStream()
        carrinho.editarItem("BEB9".byteInputStream(), "5".byteInputStream(), outputStream)
        assertEquals(5, carrinho.produtosAdicionados[0].quantidade)
    }

    @Test
    fun deveRetornarQueOProdutoParaEdicaoNaoExiste() {
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", "1".byteInputStream())
        assertEquals(1, carrinho.produtosAdicionados[0].quantidade)
        val outputStream = ByteArrayOutputStream()
        carrinho.editarItem("BEB10".byteInputStream(), "5".byteInputStream(), outputStream)
        assertEquals(String(outputStream.toByteArray()), "\nNão há produto associado ao código informado.\n")
    }

    @Test
    fun deveRetornarQueOFormatoDaQuantidadeNaoEValido() {
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", "1".byteInputStream())
        assertEquals(1, carrinho.produtosAdicionados[0].quantidade)
        val outputStream = ByteArrayOutputStream()
        carrinho.editarItem("BEB9".byteInputStream(), "teste".byteInputStream(), outputStream)
        assertEquals(String(outputStream.toByteArray()), "\nFormato inválido! Para adicionar a quantidade, você deve informar o número correspondente.\n")
    }

    @Test
    fun deveRemoverProdutoNormalmente() {
        val carrinho = Carrinho()
        carrinho.adicionar("refrigerante", "1".byteInputStream())
        val outputStream = ByteArrayOutputStream()
        carrinho.remover("BEB9".byteInputStream(), outputStream)
        assertEquals(0, carrinho.produtosAdicionados.size)
    }

    @Test
    fun deveRetornarQueOProdutoASerRemovidoNaoExiste() {
        val carrinho = Carrinho()
        val outputStream = ByteArrayOutputStream()
        carrinho.adicionar("refrigerante", "1".byteInputStream())
        carrinho.remover("BEB10".byteInputStream(), outputStream)
        assertEquals(String(outputStream.toByteArray()), "\nNão há produto associado ao código informado.\n")
    }
}