package br.pe.joaopedro.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGogle {
	
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
	public void teste() {
	//  System.setProperty("webdriver.gecko.driver", "/User/joaop/Documents/Drivers/chromedriver.exe")
	//	WebDriver driver = new FirefoxDriver(); Para utilizar o mozila
		WebDriver driver = new ChromeDriver(); // Para utilizar o chrome
	//	driver.manage().window().setSize(new Dimension(1200,765));
		driver.manage().window().maximize(); //maximizar o browser
		driver.get("http://www.google.com.br");
	//	System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle()); //Compara o valor esperado, com o valor que é retornado driver.GetTitle()
	}

}
