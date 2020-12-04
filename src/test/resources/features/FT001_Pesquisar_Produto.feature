#language: pt
#enconding: UTF-8

@FT001_Pesquisar_Produto @All
Funcionalidade: Pesquisar produto na barra de pesquisa do site Shoestock

  @CE001_CU_Validar_Campo_Usuario
  Cenario: Pesquisar produto
    Dado que preencho o campo de pesquisa com "tenis nike"
    Quando clico em pesquisar
    Entao vejo o resultado da busca