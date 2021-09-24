package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.pe.joaopedro.core.DriverFactory;
import br.pe.joaopedro.page.CampoTreinamentoPage;

public class TesteRegra {
	
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		
		getDriver().get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");	
	    page = new CampoTreinamentoPage();		
	}
	
	@After
	public void saida() {
		getDriver().quit();	
	}
	
	@Test
	public void RegraNome() {
        
		getDriver().findElement(By.id("elementosForm:cadastrar")).click();
	    Alert alert = getDriver().switchTo().alert();
	    Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	    alert.accept();
	
	    }
	
	@Test
	public void Regrasobrenome() {
	
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Joao");
	    getDriver().findElement(By.id("elementosForm:cadastrar")).click();
	    Alert alert = getDriver().switchTo().alert();
	    Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	    alert.accept();

		}
	
	@Test
	public void RegraSexo() {
		
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Joao");
	    getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
	    getDriver().findElement(By.id("elementosForm:cadastrar")).click();
	    Alert alert = getDriver().switchTo().alert();
	    Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	    alert.accept();
	    
	}
	
	@Test
	public void RegraVegetariano() {
	  
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Joao");
	    getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
	    getDriver().findElement(By.id("elementosForm:sexo:0")).click();
	    getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
	    getDriver().findElement(By.id("elementosForm:comidaFavorita:3")).click();
	    getDriver().findElement(By.id("elementosForm:cadastrar")).click();
	    Alert alert = getDriver().switchTo().alert();
	    Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	    alert.accept();
	  
	}
	@Test
	public void RegraEsportes() {
		
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Joao");
	    getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
	    getDriver().findElement(By.id("elementosForm:sexo:0")).click();
	    getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
	    page.setEsporte("Karate","O que eh esporte?");
	    getDriver().findElement(By.id("elementosForm:cadastrar")).click();
	    Alert alert = getDriver().switchTo().alert();	    
	    Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());	    
	    alert.accept();

	}	
}