package com.srbarriga.herokuapp.Page;

public class PageNovoUsuario extends PageGeral{
	
	/**
	 * @author Jheferson Kaique
	 * @data 24.01.2019
	 *
	 */
	
	public String url = "https://srbarriga.herokuapp.com/cadastro";
	public String txtEmail = "email";
	public String txtSenha = "senha";
	public String btnCadastrar = "body > div.jumbotron.col-lg-4 > form > input";
	public String txtNome = "nome";
	public String lblValidarMensagemCadastro= "body > div.alert.alert-success";
	public String lblValidarMensagemCadastroErro= "body > div.alert.alert-danger";
	public String menuSair = "#navbar > ul > li:nth-child(5) > a";
	public String menuCadastro = "#bs-example-navbar-collapse-1 > ul > li.active > a";
	public String lblValidarMensagemCadastroInvalido = "body > div.alert.alert-danger";
	


}
