package br.pe.joaopedro.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJanela {
	
	@Test	
	public void InteragirJanela() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");	
	    
	    driver.findElement(By.id("buttonPopUpEasy")).click();
	    driver.switchTo().window("Popup");
	    driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	    driver.close();
	    driver.switchTo().window("");
	    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Deu certo");
	    driver.quit();
	    }
	
	@Test
	public void InteragirJanelaSemTitulo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	    driver.findElement(By.id("buttonPopUpHard")).click();
	    System.out.println(driver.getWindowHandle()); 	//a janela corrente
	    System.out.println(driver.getWindowHandles()); 	//as janelas abertas
	    driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
	    driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
	    driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
	    driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
	    driver.quit();
	    }
}
