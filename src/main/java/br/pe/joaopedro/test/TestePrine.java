package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.getDriver;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;

public class TestePrine {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));
	}
}
