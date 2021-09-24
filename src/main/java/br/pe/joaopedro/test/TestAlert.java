package br.pe.joaopedro.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAlert {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");			
	}
	
	@After
	public void saida() {
		driver.quit();	
	}

	@Test
	public void InteragirComAlertSimples() {
	    driver.findElement(By.id("alert")).click();
	    Alert alert = driver.switchTo().alert();
	    String texto = alert.getText();
	    Assert.assertEquals("Alert Simples", texto);
	    alert.accept();
	    driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	    driver.quit();
	}
	
	@Test
	public void InteragirComAlertConfirmOk() {
	    driver.findElement(By.id("confirm")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.accept();
	    Assert.assertEquals("Confirmado", alert.getText());
	    alert.accept();
	}
	
	
	@Test
	public void InteragirComAlertConfirmCancelar()	{
	    driver.findElement(By.id("confirm")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.dismiss();
	    Assert.assertEquals("Negado", alert.getText());
	    alert.accept();
	}
	
	@Test
	public void InteragirComAlertPromptOk() {
	    driver.findElement(By.id("prompt")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Digite um numero", alert.getText());
	    alert.sendKeys("2");
	    alert.accept();
	    Assert.assertEquals("Era 2?", alert.getText());
	    alert.accept();
	    Assert.assertEquals(":D", alert.getText());
	    alert.accept();
	   	}
	
	@Test
	public void InteragirComAlertPromptCancelar() {
	    driver.findElement(By.id("prompt")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Digite um numero", alert.getText());
	    alert.sendKeys("2");
	    alert.accept();
	    Assert.assertEquals("Era 2?", alert.getText());
	    alert.dismiss();
	    Assert.assertEquals(":(", alert.getText());
	    alert.accept();
	   	}
	
}

	
