package stepsDefinitions;

import static utils.Utils.paginaContemTexto;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.CarrinhoCompraPage;

public class CarrinhoCompraSteps {

	CarrinhoCompraPage CCP = new CarrinhoCompraPage();

	@Quando("^seleciono o produto$")
	public void selecionoOProduto() throws Exception {
		CCP.clicarProduto();
	}

	@Quando("^seleciono o tamanho$")
	public void selecionoOTamanho() throws Exception {
		CCP.selecionarTamanho();
	}

	@Quando("^clico em comprar$")
	public void clicoEmComprar() throws Exception {
		CCP.clicarComprar();
	}

	@Entao("^vejo o produto no meu carrinho$")
	public void vejoOProdutoNoMeuCarrinho() throws Exception {
		CCP.validarProdutoCarrinho();
	}

	@Entao("^vejo a mensagem de \"([^\"]*)\"$")
	public void vejoAMensagemDe(String text) throws Exception {
		paginaContemTexto(text);
	}

	@E("^clico em excluir no produto selecionado$")
	public void clicoEmExcluirNoProdutoSelecionado() throws Throwable {
		CCP.ClicarLixeira();
	}

	@E("^clico em continuar$")
	public void clicoEmContinuar() throws Throwable {
		CCP.clicarContinuar();
	}

	@E("^preencho meu login com \"([^\"]*)\" e senha com \"([^\"]*)\"$")
	public void preenchoMeuLoginComESenhaCom(String User, String pass) throws Throwable {
		CCP.preencherUsuarioESenha(User, pass);
	}

	@E("^acesso a conta$")
	public void acessoAConta() throws Throwable {
		CCP.clicarBotaoAcessarConta();
	}

	@Entao("^vejo meu pedido na tela de pagamento$")
	public void vejoMeuPedidoNaTelaDePagamento() throws Throwable {
		CCP.validarProdutoTelaPagamento();
	}
}
