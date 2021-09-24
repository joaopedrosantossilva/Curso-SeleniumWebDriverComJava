package br.pe.joaopedro.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.pe.joaopedro.page.DemoPage;

public class DemoTest {

	private WebDriver driver;
	
	private DemoPage demo = new DemoPage();

	@Before
	public void inicializacao() {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://try.discourse.org/");
	}

	@After
	public void finalizacao() {
		//driver.quit();
	}

	@Test
	public void testDemo() throws InterruptedException  {
		demo.scrollAteFinalPagina();
	}

}
