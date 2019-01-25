package com.srbarriga.herokuapp.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srbarriga.herokuapp.Page.PageCadastroConta;

import BasePage.BasePage;
import cucumber.api.java.gl.E;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * @author Jheferson kaique
 * @data 23.01.2019
 *
 */
public class CadastroConta extends PageCadastroConta {

	private static Logger logger = LoggerFactory.getLogger(CadastroConta.class);

	BasePage comandos = new BasePage();

	@Dado("^que acesso site$")
	public void entrarSite() {
		comandos.esperaIniciar(10);
		logger.info("CT-03: TESTE CADASTRO CONTA");
		logger.info("Acessa a URL: " + url);
		comandos.abrirUrl(url);
	}

	@Quando("^preencher dados de usuario$")
	public void preencherDados() {
		logger.info("Step 1 -> Preenche usuário, senha e clica em Entrar");
		comandos.escreverId(txtEmail, email);
		comandos.escreverId(txtSenha, senha);
		comandos.clicar(btnLogin);
	}

	@E("^acesso a subcategoria adicionar$")
	public void acessaSubcategoria() {
		logger.info("Step 2 -> No menu, clica em  Contas >> Adicionar.");
		comandos.clicarViaCss(menuContas);
		comandos.clicarViaCss(submenuAdicionar);
	}

	@E("^preencho o nome$")
	public void preencheDado() {
		logger.info("Step 3 -> Preenche o campo nome da conta e clica em Salvar.");
		comandos.esperaElemento(txtNome);
		comandos.escrever(txtNome, nome);
		comandos.clicar(btnSalvar);
	}

	@Entao("^valido mensagem de usuario cadastrado")
	public void validaMensagem() throws IOException {
		logger.info("Step 4 -> Valida mensagem de cadastro de conta com sucesso.");
		if (comandos.elementoExiste(validaMensagemSucesso)) {
			logger.info("Conta adicionada com sucesso!");
		} else {
			logger.info("Conta não adicionada");
		}
		// Tira screenshot
		comandos.screenShot();

		// Valida mensagem
		logger.info("Step 5 -> Compara tela cadastro");
		if (comandos.validacao(nome) == true) {
			logger.info("Dado Encontrado!");
		} else {
			logger.info("Dado não Encontrado!");
		}

		// Fecha o browser
		logger.info("Step 6 -> Fechando o browser. ");
		comandos.encerraDriver();
	}
}
