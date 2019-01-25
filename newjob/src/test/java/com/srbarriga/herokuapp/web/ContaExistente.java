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

public class ContaExistente extends PageNovoUsuario {

	private static Logger logger = LoggerFactory.getLogger(ContaExistente.class);

	BasePage comandos = new BasePage();

	@Dado("^que acessei o site$")
	public void entrarSite() {
		comandos.esperaIniciar(10);
		logger.info("CT-04: TESTE CONTA EXISTENTE");
		logger.info("Acessa a URL: " + url);
		comandos.abrirUrl(url);
	}

	@Quando("^eu preecho dados de usuario$")
	public void preencherDados() {
		logger.info("Step 1 -> Preenche usuário, senha e clica em Entrar");
		comandos.esperaElemento(txtEmail);
		comandos.escrever(txtNome, nome);
		comandos.escrever(txtEmail, email);
		comandos.escrever(txtSenha, senha);
		comandos.clicar(btnCadastrar);
	}

	@Entao("^valido mensagem de usuario ja cadastrado")
	public void validaMensagem() throws IOException {
		logger.info("Step 2 -> Valida mensagem de cadastro de conta já existente.");
		if (comandos.elementoExiste(lblValidarMensagemCadastroErro)) {
			logger.info("Usuario já cadastrado!! ");
		}
		comandos.screenShot();
		logger.info("Step 3 -> Fechando o browser. ");
		comandos.encerraDriver();
	}

}
