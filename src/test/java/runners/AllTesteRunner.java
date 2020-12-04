package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber-report/cucumber.json", "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"},
		features = "src/test/resources/features/",
		glue = "stepsDefinitions",
		dryRun = false,
		tags = {"@CE004_Validar_produto_tela_pagamento"},
		snippets = SnippetType.CAMELCASE,
		strict = true,
		monochrome = true
		)

public class AllTesteRunner {

}
