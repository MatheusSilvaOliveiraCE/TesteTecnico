package deleteClient;

import static testeTecnico.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import testeTecnico.core.DriverFactory;


public class deleteClient {

	private deleteClientPage page;
	Alert alert;
	
	@Before
	public void Initialize() {
		page = new deleteClientPage();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After
	public void Ending() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void DeleteClient(){
		getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']")).click(); 
		getDriver().findElement(By.xpath("//button[@class='btn btn-lg tab' and @ng-click='showCust()']")).click();
		page.checkClient("First Name","Ron", "Delete Customer");
		
	}

	
	
	
	
}