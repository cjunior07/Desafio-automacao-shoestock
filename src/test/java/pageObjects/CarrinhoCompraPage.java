package pageObjects;

import static utils.Utils.driver;
import static utils.Utils.recuperarDado;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarrinhoCompraPage {

	public CarrinhoCompraPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@class=\"item-card__images__image-link\"])[1]/img")
	private WebElement btnProduto;

	@FindBy(xpath = "(//*[@class=\"item-card__images__image-link\"])[1]")
	private WebElement valorProduto;

	@FindBy(xpath = "(//*[@data-size='size-36'])[1]")
	private WebElement btnTamanho;

	@FindBy(css = "button[id='buy-button-now']")
	private WebElement btnComprar;
	
	@FindBy(xpath = "(//*[@aria-label='remover produto'])[1]")
	private WebElement btnLixeira1;
	
	@FindBy(css = "a[qa-auto='cart-buy-button']")
	private WebElement btnContinuar;
	
	@FindBy(css = "#username")
	private WebElement inputUser;
	
	@FindBy(css = "#password")
	private WebElement inputPass;
	
	@FindBy(css = "button[id='login-button']")
	private WebElement btnAcessarConta;
	

	public void clicarProduto() throws InterruptedException, IOException {
		String valor = valorProduto.getAttribute("title");
		utils.Utils.gravarTexto(valor, "nome_produto");
		btnProduto.click();
	}

	public void selecionarTamanho() throws InterruptedException {
		btnTamanho.click();
	}

	public void clicarComprar() throws InterruptedException {
		utils.Utils.moverScroll("250");
		Thread.sleep(1000);
		btnComprar.click();
	}

	public void validarProdutoCarrinho() throws Exception {
		String nomeProduto = recuperarDado("nome_produto");
		utils.Utils.paginaContemTexto(nomeProduto);
	}
	
	public void ClicarLixeira() throws Exception {
		String nomeProduto = recuperarDado("nome_produto");
		utils.Utils.paginaContemTexto(nomeProduto);
		btnLixeira1.click();
	}
	
	public void clicarContinuar() throws InterruptedException {
		btnContinuar.click();
	}
	
	public void preencherUsuarioESenha(String User, String pass) {
		inputUser.sendKeys(User);
		inputPass.sendKeys(pass);
	}
	
	public void clicarBotaoAcessarConta() {
		btnAcessarConta.click();
	}
	
	public void validarProdutoTelaPagamento() throws Exception {
		utils.Utils.paginaContemTexto("Resumo do Pedido");
		utils.Utils.paginaContemTexto("Pagamento");
		String nomeProduto = recuperarDado("nome_produto");
		utils.Utils.paginaContemTexto(nomeProduto);
	}

}
