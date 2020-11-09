package addClient.testTecnico;
import static testeTecnico.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import testeTecnico.core.DSL;
import testeTecnico.core.DriverFactory;


public class AddClient {

	private DSL dsl;
	private AddClientPage page;
	Alert alert;
	
	@Before
	public void Initialize() {
		dsl = new DSL();
		page = new AddClientPage();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@After
	public void Ending() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void AddClients(){
		
		page.clickManagerClient();
		page.clickAddClient();
		page.setName("Matheus");
		page.setLastName("Silva");
		page.setPostCode("1234");
		page.setAddClient();
		
		dsl.alertAccept();
		
	}
	
	@Test
	public void EmptyNameClient(){
		
		page.clickManagerClient();
		page.clickAddClient();
		page.setName("");
		page.setAddClient();
		Assert.assertEquals("", page.getName());
		
	}
	
	@Test
	public void EmptyLastNameClient(){
		
		page.clickManagerClient();
		page.clickAddClient();
		page.setName("Matheus");
		page.setLastName("");
		page.setAddClient();
		Assert.assertEquals("", page.getLastName());
		
	}
	
	@Test
	public void EmptyPostCodeClient(){
		
		page.clickManagerClient();
		page.clickAddClient();
		page.setName("Matheus");
		page.setLastName("Silva");
		page.setPostCode("");
		page.setAddClient();
		Assert.assertEquals("", page.getPostCode());
		
	}
	
}
