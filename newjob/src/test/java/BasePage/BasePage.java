package BasePage;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srbarriga.herokuapp.Page.PageGeral;

public class BasePage extends PageGeral {

	/**
	 * @author Jheferson Kaique
	 * @data 24.01.2019
	 *
	 */

	// Instancia chromeDriver e webDriverWait
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void escreverId(String elemento, String variavel) {
		driver.findElement(By.id(elemento)).sendKeys(variavel);

	}

	public void escrever(String elemento, String texto) {
		encontra(elemento).sendKeys(texto);
	}

	public void clicarViaCss(String elemento) {
		driver.findElement(By.cssSelector(elemento)).click();
	}

	public void clicar(String elemento) {
		encontra(elemento).click();
	}

	public boolean elementoExiste(String elemento) {
		try {
			assertEquals(true, encontra(elemento).isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void screenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(caminhoEvidencia + "Print_CadastroUsuario.png"));

	}

	public void abrirUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void esperaIniciar(int segundos) {
		driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}

	public void esperaElemento(String elemento) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elemento)));
	}

	public WebElement encontra(String name) {
		WebElement elemento = null;
		boolean status = true;
		while (status == true) {
			try {
				elemento = driver.findElement(By.id(name));
				break;
			} catch (Exception e) {
			}
			try {
				elemento = driver.findElement(By.cssSelector(name));
				break;
			} catch (Exception e) {
			}

			status = false;
		}
		return elemento;
	}

	public void encerraDriver() {
		driver.quit();

	}

	public boolean validacao(String variavel) {
		String dadosPagina = driver.getPageSource();
		try {
			equals(dadosPagina.contains(variavel));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
