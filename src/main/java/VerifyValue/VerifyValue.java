package VerifyValue;
import static testeTecnico.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testeTecnico.core.DSL;
import testeTecnico.core.DriverFactory;

public class VerifyValue {

	Alert alert;
	private DSL dsl;
	private VerifyValuePage page;
	
	@Before
	public void Initialize() {
		dsl = new DSL();
		page = new VerifyValuePage();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		getDriver().get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void Ending() {
		DriverFactory.killDriver();
	}
	
	
	@Test
	public void OpenAccount(){

		page.clickManagerClient();
		page.clickManagerOpenAccount();
		
		page.selectAccount("Hermoine Granger");
		page.selectCurrency("Pound");
		
		page.clickSubmit();
		
		dsl.alertAccept();
		
		page.clickHome();
		page.clickCustomer();
		page.selectAccount("Hermoine Granger");
		page.clickLogIn();
		
		page.clickDeposit();
		page.setTransactionValue("10");
		page.confirmDeposit();
		
		page.clickWithdrawl();
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default' and contains(text(), 'Withdraw')]")));
		page.setTransactionValue("35");
		page.confirmWithDrawl();
		
		
	}
}
