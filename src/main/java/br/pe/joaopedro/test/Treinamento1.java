package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;
import junit.framework.Assert;

public class Treinamento1 {
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {

		DriverFactory.getDriver()
				.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void concluir() {
		killDriver();
	}

	@Test
	public void testTextfieldDuplo() {

		dsl.escrever("elementosForm:nome", "Joao");
		Assert.assertEquals("Joao", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escrever("elementosForm:nome", "Junior");
		Assert.assertEquals("Junior", dsl.obterValorCampo("elementosForm:nome"));

	}

}
