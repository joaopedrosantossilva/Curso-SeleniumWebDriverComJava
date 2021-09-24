package br.pe.joaopedro.test;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteFrames {
	
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
		public void Cadastro(){
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
			
			driver.switchTo().frame("frame1"); //Abrir o frame
			driver.findElement(By.id("frameButton")).click();
			Alert alert = driver.switchTo().alert();		
			String msg = alert.getText();
			Assert.assertEquals("Frame OK!", msg);		
			alert.accept();
			
			driver.switchTo().defaultContent(); //Sair do frame e voltar para o form principal
			driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
}
	
