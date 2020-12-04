package stepsDefinitions;

import static utils.Utils.acessarSistema;
import static utils.Utils.driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Utils;

public class Hooks {
	
	@Before(order = 1)
	public void suitUp(){ 
		acessarSistema();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) throws Exception {
		Utils.capturarTela(scenario);
		driver.quit();
	}
	
	@After(order = 2, value = "@CE008_MF_Validar_Campo_CPF_Invalido")
	public void aceitarAlert() throws Exception {
		driver.switchTo().alert().accept();
	}

}
