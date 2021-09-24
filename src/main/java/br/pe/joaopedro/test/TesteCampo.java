package br.pe.joaopedro.test;
import static br.pe.joaopedro.core.DriverFactory.getDriver;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;

public class TesteCampo {

	private DSL dsl;
	
	@Before
	public void inicializa() {
		

	    getDriver().get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");		
	    dsl = new DSL();
	}
	
	@After
	public void saida() {
		killDriver();
	}
	
	@Test
	public void testeTextField() {
	
		//inicializa(); não precisa colocar, quando utiliza o before
		//getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");	   
		//Assert.assertEquals("Teste de escrita", getDriver()..findElement(By.id("elementosForm:nome")).getAttribute("value")); 
	    dsl.escrever("elementosForm:nome", "Teste de escrita");
	    Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome")); 
		  
	}
	
	@Test
	public void testeInteragirTextArea() {
		
	    //getDriver()..findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste do text area");
	    //Assert.assertEquals("Teste do text area", getDriver()..findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		dsl.escrever("elementosForm:sugestoes", "Teste do text area");
		Assert.assertEquals("Teste do text area", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void testeInteragirRadioButton() {
		//getDriver()..findElement(By.id("elementosForm:sexo:0")).click();
		//Assert.assertTrue( getDriver()..findElement(By.id("elementosForm:sexo:0")).isSelected()); //Verifica se o item foi realmente checado.
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));;
	}
	
	@Test
	public void testeInteragirCheckBox() {
		getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).click();
	    Assert.assertTrue( getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).isSelected()); //Verifica se o item foi realmente checado.
		
	}
	
	@Test
	public void testeInteragirComboBox() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
	    Assert.assertEquals("2o grau incompleto", dsl.obterValorCombo("elementosForm:escolaridade"));	    
	}
	
	@Test
	public void VerificarValoresCombo() {
		WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
	    Select combo = new Select(element); 
	  	List<WebElement> options = combo.getOptions();
	  	Assert.assertEquals(8, options.size());
	  	boolean encontrou = false;
	  	for(WebElement option: options) {
	  		if(option.getText().equals("Mestrado")) {
	  			encontrou = true;
	  			break;
	  		}
	  	}
	  	Assert.assertTrue(encontrou);
	}
	

	@Test
	public void VerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));	
		Select combo = new Select(element);
	    List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
	    Assert.assertEquals(3, allSelectedOptions.size());
	    
	    combo.deselectByVisibleText("Corrida");
	    allSelectedOptions = combo.getAllSelectedOptions();
	    Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void InteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		WebElement botao = getDriver().findElement(By.id("buttonSimple"));
		//botao.click();
	    Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void InteragirComLinks() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		}
	
	@Test
	public void BuscarTextosnaPagina() {
	    //Assert.assertTrue(getDriver()..findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
	    Assert.assertEquals("Campo de Treinamento", getDriver().findElement(By.tagName("h3")).getText());
	    Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
	    //Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", getDriver()..findElement(By.tagName("span")).getText());
	    Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
	
	@Test
	public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("alert('Test js via selenium')");
		js.executeAsyncScript("document.getElementById('elementosForma:nome').value = 'Escrita via js'");
		
	}
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Nome", "Maria", "Botao","elementosForm:tableUsuarios");
		
	}
	
}
	
