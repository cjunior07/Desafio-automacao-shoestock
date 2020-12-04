package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;

public class Utils {

	public static ChromeDriver driver;

	public static void acessarSistema() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

		// Removendo log do selenium e chromedriver
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.err.close();
	    System.setErr(System.out);
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("–no-sandbox");
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.shoestock.com.br/");
	}

	public static void addEnvironmentAllure() {
		try {
			File env = new File("./target/allure-reports/environment.properties");
			BufferedWriter as = new BufferedWriter(new FileWriter(env));
			as.write("Analista: Claudio da L. A. Junior");
			as.newLine();
			as.write("E-mail: Junior.Andrade.360@hotmail.com");
			as.newLine();
			as.write("Navegador = Chrome");
			as.newLine();
			as.write("Desafio = Yaman");
			as.newLine();
			as.write("Sistema Operacional = " + System.getProperty("os.name").toLowerCase());
			as.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void moverScroll(String valor) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,"+valor+")", "");
	}

	public static void capturarTela(Scenario scenario) {
		File screenshot = gerarScreenShot(scenario);
		embedScreenshot(screenshot, scenario.getName());
		addEnvironmentAllure();
	}

	public static File gerarScreenShot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/allure-reports", scenario.getName() + " - " + scenario.getStatus() + ".png")));
		} catch (Exception e) {

		}

		return imagem;
	}

	public static void embedScreenshot(File file, String description) {
		Path content = Paths.get(file.getPath());
		try (InputStream is = Files.newInputStream(content)) {
			Allure.addAttachment(description, is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void aguardarVisibilidade(Boolean visibilidade, Integer tempoEspera, WebElement elemento)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, tempoEspera);

		if (visibilidade = true) {
			wait.until(ExpectedConditions.visibilityOf(elemento));
		} else {
			wait.until(ExpectedConditions.invisibilityOf(elemento));
		}

	}

	public static void esperarPagina(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}

	public static void paginaContemTexto(String text) throws Exception {
		esperarPagina(1);
		boolean existe = driver.getPageSource().contains(text);
		if (existe == false) {
			System.out.println("Nao encontrei a string" + text);
		}
		assertTrue(existe);

	}
	
	public static void paginaNaoContemTexto(String text) throws Exception {
		esperarPagina(1);
		boolean existe = driver.getPageSource().contains(text);
		if (existe == true) {
			System.out.println("Encontrei a string" + text);
		}
		assertFalse(existe);
	}

	public static boolean elementoExiste(WebElement elemento) {
		boolean existe = false;
		try {
			existe = elemento.isEnabled();
		} catch (NoSuchElementException e) {
			existe = false;
		}
		return existe;
	}

	public static String caminhoProjeto() {
		String diretorio = System.getProperty("user.dir");
		return diretorio;
	}

	public static void gravarTexto(String texto, String caminho) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter(caminhoProjeto() + "\\src\\test\\resources\\massa\\" + caminho + ".txt", false));
		buffWrite.append(texto);
		buffWrite.close();
	}

	public static String recuperarDado(String file) throws IOException {
		String ultimo = "";
		try {
			InputStream is = new FileInputStream(caminhoProjeto() + "\\src\\test\\resources\\massa\\" + file + ".txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ultimo;
	}

	public static void validarAlertaCampoJavaScript(WebElement elemento, String msg) {
		String validationMessage = elemento.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage, msg);

	}

}
