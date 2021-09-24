package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;
import br.pe.joaopedro.page.CampoTreinamentoPage;

public class TestScroll {
	
private WebDriver driver; 
private DSL dsl;
private CampoTreinamentoPage page;

	@Before
	public void Inicio() {
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");	
	    page = new CampoTreinamentoPage();
	    dsl = new DSL();
	}
	
	@After
	public void Fim() {
		killDriver();
		
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0,arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);	
		
	}
	
}
