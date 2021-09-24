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
import org.openqa.selenium.support.ui.Select;

import br.pe.joaopedro.core.BaseTest;
import br.pe.joaopedro.core.DSL;
import br.pe.joaopedro.core.DriverFactory;
import br.pe.joaopedro.page.CampoTreinamentoPage;

public class TestCadastro extends BaseTest {

	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@Test
	public void Cadastro() {

		// Inserindo os campos
		// driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao Pedro");
		// //Adicionando o nome
		// driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
		// //Adicionando o sobrenome
		// driver.findElement(By.id("elementosForm:sexo:0")).click(); //Adicionando o
		// sexo
		// driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		// //Selecionando a comida favorita 1
		// driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		// //Selecionando a comida favorita 2
		// new
		// Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		// //Selecinando a escolaridade
		// new
		// Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
		// //Selecinando o futebol
		// driver.findElement(By.id("elementosForm:cadastrar")).click(); //Clicar no
		// botão de confirmar

		// dsl.escrever("elementosForm:sobrenome", "Santos");
		// dsl.clicarRadio("elementosForm:sexo:0");
		// dsl.clicarRadio("elementosForm:comidaFavorita:1");
		// dsl.clicarRadio("elementosForm:comidaFavorita:2");
		// dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		// dsl.clicarBotao("elementosForm:cadastrar");

		page.setNome("Joao Pedro");
		page.setSobrenome("Santos");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Futebol");
		page.cadastrar();

		// Confirmar o resultado
		// FORMA 1
		// Assert.assertEquals("Cadastrado!",
		// driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText());
		// Assert.assertEquals("Nome: Joao Pedro",
		// driver.findElement(By.id("descNome")).getText());
		// Assert.assertEquals("Sobrenome: Santos",
		// driver.findElement(By.id("descSobrenome")).getText());
		// Assert.assertEquals("Sexo: Masculino",
		// driver.findElement(By.id("descSexo")).getText());
		// Assert.assertEquals("Comida: Frango Pizza",
		// driver.findElement(By.id("descComida")).getText());
		// Assert.assertEquals("Escolaridade: mestrado",
		// driver.findElement(By.id("descEscolaridade")).getText());
		// Assert.assertEquals("Esportes: Futebol",
		// driver.findElement(By.id("descEsportes")).getText());
		// Assert.assertEquals("Sugestoes:",
		// driver.findElement(By.id("descSugestoes")).getText());
		// FORMA 2
		// Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		// //inicia com
		/*Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Joao Pedro"));
		Assert.assertEquals("Santos", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", dsl.obterTexto("descSexo"));
		Assert.assertEquals("Frango Pizza", dsl.obterTexto("descComida"));
		Assert.assertEquals("mestrado", dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Futebol", dsl.obterTexto("descEsportes"));
		Assert.assertEquals("Sugestoes:", dsl.obterTexto("descSugestoes"));*/
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Joao Pedro", page.obterNomeCadastro());
		Assert.assertEquals("Santos", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Carne Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Futebol", page.obterEsportesCadastro());

	}

}
