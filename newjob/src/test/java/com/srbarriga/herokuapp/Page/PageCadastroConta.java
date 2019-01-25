package com.srbarriga.herokuapp.Page;

public class PageCadastroConta extends PageGeral{
	
	/**
	 * @author Jheferson Kaique
	 * @data 24.01.2019
	 *
	 */
	
	//Step 1
	public String url = "https://srbarriga.herokuapp.com/login";
	public String txtEmail = "email";
	public String txtSenha = "senha";
	public String btnLogin = "body > div.jumbotron.col-lg-4 > form > button";

	//Step2
	public String menuContas = "#navbar > ul > li.dropdown > a";
	public String submenuAdicionar = "#navbar > ul > li.dropdown.open > ul > li:nth-child(1) > a";

	//step3
	public String txtNome = "nome";
	public String btnSalvar = "body > div.col-lg-10 > form > div.btn-group > button"; 
	
	//step4
	public String validaMensagemSucesso = "body > div.alert.alert-success";


}
