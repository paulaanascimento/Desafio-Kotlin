package usercase

import model.Constantes

class EntradaDoUsuario {
    companion object {
        fun lerQuantidade(texto: String, categoria: String): Int {
            var quantidade = 0
            do {
                try {
                    print("$texto $categoria: ")
                    quantidade = readln().toInt()

                    if (quantidade <= 0) {
                        println(Constantes.NUMERO_MAIOR_QUE_ZERO)
                    }
                } catch (exception: IllegalArgumentException) {
                    println(Constantes.VALOR_INVALIDO_QUANTIDADE)
                }
            } while (quantidade <= 0)

            return quantidade
        }

        fun lerCodigoProduto(texto: String, categoria: String):String{
            return readln()
        }
    }
}