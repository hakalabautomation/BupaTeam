package cl.bupa.qa.automation.web.business.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import cl.bupa.qa.automation.web.json.conn.CommJson;
import cl.bupa.qa.automation.web.poc.model.PageModel;
//import cl.bupa.qa.automation.web.poc.util.GenericMethods;
import cl.bupa.qa.automation.web.properties.PropertiesInit;

//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(Suite.class)
@SuiteClasses({})
public class BaseFlow {

	public static WebDriver driver;
	public static PropertiesInit properties;
	public static PageModel pageModel;
	static String driverPath = "C:/eclipse-workspace";
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseFlow.class);
	public static String urlQa = "https://bcp-qa.mybluemix.net/login";
	public static String urlPrd = "https://bcp.mybluemix.net/login";
	public static CommJson commJson;
	@BeforeClass

	public static void prueba() throws Exception {
		try {
			commJson = new CommJson();
			properties = new PropertiesInit();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
					"/WebDriver/WebDriver/Chrome/Windows/chromedriver.exe");
			//System.out.println("RUTA: " + System.getProperty("user.dir")+"/WebDriver/WebDriver/Chrome/Windows/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);			
			driver.navigate().to(urlQa);
			pageModel = PageFactory.initElements(driver, PageModel.class);
			
				
		} catch (Exception e) {
			LOGGER.info(e.toString());
		}
	}

	//@AfterClass
	/*
	public static void setUpFinal() {
		LOGGER.info("************************************************");
		LOGGER.info("**   Finaliza ciclo de pruebas automatizadas  **");
		LOGGER.info("************************************************");
		GenericMethods.cerrarProcesoWebDriver(driver);
	}
	*/
	/*
	public static void setDriver() throws MalformedURLException {
		DesiredCapabilities capability = null;
		capability = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(System.getenv("SELENIUM_SERVER_URL")), capability);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}
	*/
	/*
	public static void setDriverDesa() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/rcesp/Desktop/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	*/
}