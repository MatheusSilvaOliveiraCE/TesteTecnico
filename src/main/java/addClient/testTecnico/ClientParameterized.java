package addClient.testTecnico;
import static testeTecnico.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;

import testeTecnico.core.DSL;
import testeTecnico.core.DriverFactory;

@RunWith(Parameterized.class)
public class ClientParameterized {

	private DSL dsl;
	private AddClientPage page;
	Alert alert;
	
	@Parameter
	public String name;
	@Parameter(value = 1)
	public String lName;
	@Parameter(value = 2)
	public String pCode;
	@Parameter(value = 3)
	public String expected;
	@Parameter(value = 4)
	public String aPage;
	
	@Before
	public void Initialize() {
		dsl = new DSL();
		page = new AddClientPage();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void Ending() {
		DriverFactory.killDriver();
	}
	
	@Parameters
	public static Collection<Object[]> getClientTests(){
		return Arrays.asList(new Object[][] {
			{"ASD", "ASD", "ASD", "ASD", "NAME"},
			{"Matheus", "ASD", "", "", "PCODE"},
			{"Dick", "", "", "", "LNAME"},
			{"", "", "", "", "NAME"},
		});
			
	}
	
	@Test
	public void ValidClient(){
		
		page.clickManagerClient();
		page.clickAddClient();
		page.setName(name);
		page.setLastName(lName);
		page.setPostCode(pCode);
		page.setAddClient();
		try {
			dsl.alertAccept();
		} catch (Exception E) {
			Assert.assertEquals(expected, page.getValue(aPage));
		}
		
	}
	
	
}
