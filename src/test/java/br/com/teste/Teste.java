package br.com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import br.com.driver.Driver;

public class Teste {

	private String resultado;
	
	@Test
	public void primeiroTeste() {
		Driver.getDriver().findElement(By.id("digit_1")).click();
		Driver.getDriver().findElement(By.id("op_add")).click();
		Driver.getDriver().findElement(By.id("digit_2")).click();
		Driver.getDriver().findElement(By.id("eq")).click();
		resultado = Driver.getDriver().findElement(By.id("result")).getText();
		assertEquals(resultado,"3");
		
	}
}
