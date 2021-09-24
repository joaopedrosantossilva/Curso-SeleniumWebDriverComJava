package br.pe.joaopedro.suites;
import static br.pe.joaopedro.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.pe.joaopedro.core.DriverFactory;
import br.pe.joaopedro.test.TestCadastro;
import br.pe.joaopedro.test.TesteCampo;
import br.pe.joaopedro.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TestCadastro.class,
	TesteRegrasCadastro.class
})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		killDriver();
	}

}
