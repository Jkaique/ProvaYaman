package com.srbarriga.herokuapp.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srbarriga.herokuapp.Page.PageLogin;

import BasePage.BasePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * @author Jheferson Kaique
 * @data 24.01.2019
 *
 */
public class Login extends PageLogin {

	private static Logger logger = LoggerFactory.getLogger(Login.class);

	BasePage comandos = new BasePage();

	@Dado("^acesso site$")
	public void acessarSite() {

		comandos.esperaIniciar(10);
		logger.info("CT-02: TESTE LOGIN");
		logger.info("Acessa a URL: " + url);
		comandos.abrirUrl(url);
	}

	@Quando("^preecho dados do usuario$")
	public void preencherDados() {

		logger.info("Step 1 -> Preenche usuário, senha e clica em Entrar");
		comandos.esperaElemento(txtEmail);
		comandos.escreverId(txtEmail, email);

		logger.info("Step 2 -> Inserir senha");
		comandos.escreverId(txtSenha, senha);
		comandos.clicar(btnEntrar);
	}

	@Entao("^valido mensagem de usuario logado")
	public void validarMensagem() throws IOException {
		logger.info("Step 3 -> Salva Evidência com o print da tela de [Bem Vindo]");
		if (comandos.elementoExiste(lblValidarMensagemSucesso)) {
			logger.info("Mensagem bem vindo encontrada!");
		} else {
			logger.info("Mensagem não encontrada!");
		}
		comandos.screenShot();
		comandos.clicar(menuSair);
		logger.info("Step 4 -> Fechando o browser. ");
		comandos.encerraDriver();
	}

}