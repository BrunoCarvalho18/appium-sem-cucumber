package br.com.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import br.com.driver.Driver;

@DisplayName("Suite de testes para realizar as operacoes com a calculadora")
public class Teste {

	private String resultado;
	
	
	@DisplayName("Teste para realizar a soma")
	@Test
	public void somarNumeros() {
		Driver.getDriver().findElement(By.id("digit_1")).click();
		Driver.getDriver().findElement(By.id("op_add")).click();
		Driver.getDriver().findElement(By.id("digit_2")).click();
		Driver.getDriver().findElement(By.id("eq")).click();
		resultado = Driver.getDriver().findElement(By.id("result")).getText();
		assertEquals(resultado,"3");
	}
}
