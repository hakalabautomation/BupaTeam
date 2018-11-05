package cl.cencosud.publicsite.automation.poc.business.flow;

import cl.cencosud.publicsite.automation.poc.model.PageModel;
import cucumber.api.java.Before;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(Suite.class)
@SuiteClasses({})
public class BaseFlow {

	public static WebDriver driver;
	public static PageModel pageModel;
	static DesiredCapabilities capability = null;

	@BeforeClass

	public static void prueba() throws Exception {
//		capability.setJavascriptEnabled(true);
//		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		driver = new ChromeDriver(capability);
		System.setProperty("webdriver.chrome.driver", "C:/Users/rcesp/Desktop/Proyectos/cencosud_test/WebDriver/WebDriver/Chrome/Windows/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.navigate().to("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/404?lang=es_CL");
		pageModel = PageFactory.initElements(driver, PageModel.class);
	}

	@AfterClass
	public static void setUpFinal() throws Exception {

		//driver.quit();
	}

	public static void setDriver() throws MalformedURLException {
		DesiredCapabilities capability = null;
		capability = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(System.getenv("SELENIUM_SERVER_URL")), capability);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}

//	public static void setDriverDesa() throws MalformedURLException {
//		System.setProperty("webdriver.chrome.driver", "C:/Users/rcesp/Desktop/driver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}

}
