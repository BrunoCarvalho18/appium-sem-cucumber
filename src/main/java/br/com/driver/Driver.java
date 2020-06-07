package br.com.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

//<?> --> tipo genérico --> posso passar qualquer web element
// Tipos Parametrizados
public class Driver {
	
	 private static AndroidDriver<?> driver;

	    public static  AndroidDriver<?> getDriver(){
	        if(driver == null){
	            conectar();
	        }
	        return driver;
	    }

	    @SuppressWarnings("rawtypes")
		@Before
	    private static AndroidDriver<?> conectar() {
	        File diretorioAplicacao = new File("app");
	        File arquivoAplicacao = new File(diretorioAplicacao, "ExactCalculator.apk");

	        DesiredCapabilities capacidade = new DesiredCapabilities();
	        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	        capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
	        capacidade.setCapability(MobileCapabilityType.NO_RESET, "true");
	        capacidade.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
	        capacidade.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 4600);


	        try {
	            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capacidade);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }

	        return driver;
	    }


	    public static WebDriverWait esperarpeloDriver(WebDriver driver) {
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        return wait;
	    }
	    
	    @After
	    public static void encerrarDriver() {
	        try {
	            driver.quit();
	        } catch (Exception ign) {}
	    }
	    

}
