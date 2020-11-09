package LogIn;

import static testeTecnico.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

public class LogIn {

	private LogInPage page;
	Alert alert;
	
	@Before
	public void Initialize() {
		page = new LogInPage();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After
	public void Ending() {
//		DriverFactory.killDriver();
	}
	
	@Test
	public void LogInOk() {
		page.clickCustomer();
		Assert.assertTrue(page.LogIn("Harry Potter"));
	}
}