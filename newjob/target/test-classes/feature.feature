# language:pt

@ProvaYaman
Funcionalidade: Realizar automacoes referente a prova da yaman

  @jheferson_oliveira
  @novo_usuario
  Cenario: Cadastrar novo usuario
    Dado acessar site
    Quando preecher dados do usuario
    Entao valido mensagem de cadastro
    
  @jheferson_oliveira
  @login
  Cenario: Realizar login
    Dado acesso site
    Quando preecho dados do usuario
    Entao valido mensagem de usuario logado
    
  @jheferson_oliveira
  @cadastroConta
  Cenario: Cadastro Conta
    Dado que acesso site
    Quando preencher dados de usuario
    E acesso a subcategoria adicionar
    E preencho o nome
    Entao valido mensagem de usuario cadastrado
    
  @jheferson_oliveira
  @contaExistente
  Cenario: Conta Existente
    Dado que acessei o site
    Quando eu preecho dados de usuario
    Entao valido mensagem de usuario ja cadastrado
    
    
