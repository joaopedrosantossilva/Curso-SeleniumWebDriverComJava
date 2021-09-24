package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.getDriver;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void Inicio() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
		
	}
	
	@After
	public void Concluir() {
		killDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escrever("j_idt718:name", "Joao");
		dsl.clicarBotao("j_idt718:j_idt721");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.textToBe(By.id("j_idt718:display"), "Joao"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt790")));
		Assert.assertEquals("Joao", dsl.obterTexto("j_idt718:display"));
		
	}


}
