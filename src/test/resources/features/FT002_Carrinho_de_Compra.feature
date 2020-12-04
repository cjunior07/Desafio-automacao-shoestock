#language: pt
#enconding: UTF-8

@FT002_Carrinho_de_Compras @All 
Funcionalidade: Carrinho de compra

  @CE001_Adicionar_produto_no_carrinho_de_compras
  Cenario: Adicionar produto no carrinho de compras
    Dado que preencho o campo de pesquisa com "Tenis nike"
    Quando clico em pesquisar
    E seleciono o produto
    E seleciono o tamanho
    E clico em comprar
    Entao vejo o produto no meu carrinho
    
  @CE002_Validar_botões_de_tamanho_não_selecionado
  Cenario: Validar botões de tamanho não selecionado
    Dado que preencho o campo de pesquisa com "Tenis nike"
    Quando clico em pesquisar
    E seleciono o produto
    E clico em comprar
    Entao vejo a mensagem de "Selecione o tamanho"
    
  @CE003_Excluir_produto_no_carrinho_de_compras
  Cenario: Excluir produto no carrinho de compras
    Dado que preencho o campo de pesquisa com "Tenis nike"
    Quando clico em pesquisar
    E seleciono o produto
    E seleciono o tamanho
    E clico em comprar
    E clico em excluir no produto selecionado
    Entao vejo a mensagem de "Seu carrinho está vazio"
    
  @CE004_Validar_produto_tela_pagamento
  Cenario: Validar produto na tela de pagamento
    Dado que preencho o campo de pesquisa com "Tenis nike"
    Quando clico em pesquisar
    E seleciono o produto
    E seleciono o tamanho
    E clico em comprar
    E clico em continuar
    E preencho meu login com "junior.andrade.360@hotmail.com" e senha com "Teste123"
    E acesso a conta
    Entao vejo meu pedido na tela de pagamento