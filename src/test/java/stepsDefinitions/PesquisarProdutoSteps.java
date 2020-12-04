package stepsDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.PesquisarProdutoPage;

public class PesquisarProdutoSteps {
	
	PesquisarProdutoPage PP = new PesquisarProdutoPage();
	
	@Dado("^que preencho o campo de pesquisa com \"([^\"]*)\"$")
	public void quePreenchoOCampoDePesquisaCom(String produto) throws Exception {
		Thread.sleep(2000);
	    PP.pesquisarProduto(produto);
	}

	@Quando("^clico em pesquisar$")
	public void clicoEmPesquisar() throws Exception {
	   PP.clicarPesquisar();
	}

	@Entao("^vejo o resultado da busca$")
	public void vejoOResultadoDaBusca() throws Exception {
	    
	}

}
