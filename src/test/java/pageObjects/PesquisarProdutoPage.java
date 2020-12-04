package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PesquisarProdutoPage {
	
		// Construtor
		public PesquisarProdutoPage() {
			PageFactory.initElements(driver, this);
		}
		
		// Elementos

		@FindBy(css = "input[id='search-input']")
		private WebElement inputPesquisa;
		
		@FindBy(css = "button[title='Buscar']")
		private WebElement btnPesquisa;
		
		@FindBy(css = ".search-list")
		private WebElement resultadoBusca;
		
		public void pesquisarProduto(String produto) {
			inputPesquisa.sendKeys(produto);
		}
		
		public void clicarPesquisar() {
			btnPesquisa.click();
		}
		
		public void validarResultadoDaBusca() {
			assertTrue(utils.Utils.elementoExiste(resultadoBusca));
		}

}
