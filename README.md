# Desafio Kotlin
<div align="justify">
Neste desafio foi solicitada a criação de um sistema de Totem de Auto-Atendimento para uma lanchonete. Sendo assim, os clientes podem realizar os seus pedidos de forma autônoma. Neste projeto, foram aplicados os conceitos de POO, como: classes concretas e abstratas, herança e polimorfismo. Além disso, foram utilizadas Collections e Exceptions.
<div>

# Estrutura
## Classe 'Produto'
Classe abstrata que representa um produto genérico disponível na lanchonete. Ela possui `codigo`, `quantidade`, `nome` e `valor` como atributos. Além disso, possui um getter para calcular o `valorTotal` do produto (valor * quantidade) e um método `mostrarInformacoes()` para exibir as informações do produto.

## Classes 'Lanche', 'Bebida' e 'Sobremesa'
Essas são classes filhas de `Produto` e representam os três tipos de produtos disponíveis na lanchonete. Cada uma dessas classes possui atributos específicos e sobrescreve o método `mostrarInformacoes()` para exibir as informações específicas do tipo de produto.

As classes filhas de `Lanche` são `Xburger` e `Xsalada`, e cada uma delas possui um companion object que define uma lista de ingredientes.

As classes filhas de `Bebida` são `Refrigerante` e `Suco`.

As classes filhas de `Sobremesa` são `Sorvete` e `Mousse`.

## Classe 'Combo'
Essa classe representa um combo disponível na lanchonete, que é composto por um lanche, uma bebida e uma sobremesa. Ela herda de `Produto`, e o preço do combo é calculado a partir da soma dos valores dos itens menos um desconto fixo de R$5. A classe possui um método `mostrarInformacoes()` para exibir as informações do combo.

## Classe 'Carrinho'
Essa classe é responsável por gerenciar o carrinho de compras do cliente. Ela possui uma lista chamada `produtosAdicionados`, que armazena os produtos que o cliente escolheu adicionar ao carrinho. A classe oferece as seguintes funcionalidades:

`adicionar(tipo: String)`: Permite adicionar um produto ao carrinho, seja lanche, bebida ou sobremesa, e exibe os ingredientes ou sabores disponíveis, conforme o caso. A quantidade do produto é solicitada ao usuário e o produto escolhido é criado e adicionado à lista de produtos do carrinho.

`adicionarCombo(opcao: Int)`: Permite adicionar um combo ao carrinho, com base na opção escolhida pelo usuário. A quantidade do combo é solicitada ao usuário, e o combo correspondente é criado e adicionado à lista de produtos do carrinho.

`mostrarTotalCarrinho()`: Exibe o valor total dos pedidos no carrinho.

`mostrarProdutosAdicionados()`: Exibe as informações de todos os produtos adicionados ao carrinho.

`editarItem()`: Permite editar a quantidade de um produto no carrinho.

`remover()`: Permite remover um produto do carrinho.

## Classe 'FinalizarPedido'
Essa classe representa o processo final de finalização do pedido. Ela oferece um método `selecionarPagamento()` que exibe as formas de pagamento disponíveis e permite ao cliente escolher a opção desejada. Se o cliente optar por pagar em dinheiro, é solicitado o valor pago, e o troco é calculado e exibido. Ao final, o pedido é finalizado, e um código único é gerado para que o cliente possa retirar o pedido na lanchonete.

## Arquivo Totem
Local onde está armazenada a função `main`, `menuPrincipal()`, `lanche()`, `bebida()`, `sobremesa()`, `combo()` e `continuar()`

Essas funções são responsáveis por exibir os menus principais e secundários do programa, onde o cliente pode escolher os produtos a serem adicionados ao carrinho, editar ou remover itens do carrinho e finalizar o pedido.

`limparTerminal()`: Essa função é utilizada para limpar a tela do terminal, tornando a interação com o programa mais clara e organizada.
