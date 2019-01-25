package com.srbarriga.herokuapp.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srbarriga.herokuapp.Page.PageNovoUsuario;

import BasePage.BasePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * @author Jheferson Kaique
 * @data 24.01.2019
 *
 */
public class NovoUsuario extends PageNovoUsuario {

	private static Logger logger = LoggerFactory.getLogger(NovoUsuario.class);

	BasePage comandos = new BasePage();

	@Dado("^acessar site$")
	public void entrarSite() {
		comandos.esperaIniciar(10);
		logger.info("CT-01: TESTE NOVO USUÁRIO");
		logger.info("Acessa a URL: " + url);
		comandos.abrirUrl(url);
	}

	@Quando("^preecher dados do usuario$")
	public void preencherDados() {
		logger.info("Step 1 -> Clica em Menu >> Novo Usuário e preenche os campos para o cadastro.");
		comandos.esperaElemento(txtEmail);
		comandos.escrever(txtNome, nome);
		comandos.escrever(txtEmail, email);
		comandos.escrever(txtSenha, senha);
		comandos.clicar(btnCadastrar);
	}

	@Entao("^valido mensagem de cadastro")
	public void validaMensagem() throws IOException {

		logger.info("Step 2 -> Valida mensagem de cadastro de novo usuário com sucesso.");
		if (comandos.elementoExiste(lblValidarMensagemCadastro)) {
			logger.info("Usuario cadastrado com sucesso");
		} else {
			logger.info("Usuario não cadastrado! Endereço de email já utilizado");
		}
		comandos.screenShot();
		logger.info("Step 4 -> Fechando o browser. ");
		comandos.encerraDriver();
	}

}
