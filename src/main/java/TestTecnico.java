import static testeTecnico.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testeTecnico.core.DSL;



public class TestTecnico {
	
	private WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);
	Alert alert;
	int value;
	private DSL dsl;
	
	
	@Before
	public void Initialize() {
		driver = new FirefoxDriver();
		dsl = new DSL();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\m_ara\\OneDrive\\Documentos\\geckdriver\\geckodriver.exe");
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@After
	public void Ending() {
		driver.quit();
	}
	
	@Test
	public void AddClient(){
		
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
		dsl.clickButton("//button[@class='btn btn-lg tab']");
		dsl.write("//input[@ng-model='fName']", "Matheus");
		dsl.write("//input[@ng-model='lName']", "Silva");
		dsl.write("//input[@ng-model='postCd']", "1234");
		dsl.clickButton("//button[@class='btn btn-default' and contains(.,'Add Customer')]");
		
		alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	@Test
	public void DeleteClient(){
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']")).click(); 
		driver.findElement(By.xpath("//button[@class='btn btn-lg tab' and @ng-click='showCust()']")).click();
		
		Assert.assertEquals("Ron", driver.findElement(By.xpath("//td[@class='ng-binding']")).getText());
		driver.findElement(By.xpath("//td[@ng-click='deleteCust(cust)']")).click();
		
		
	}

	@Test
	public void LogIn(){
		
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");

		WebElement element = driver.findElement(By.xpath("//select[@id='userSelect']"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
		
		dsl.clickButton("//button[@class='btn btn-default']");
	}
	
	
	@Test
	public void LogOut(){
		
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");

		WebElement element = driver.findElement(By.xpath("//select[@id='userSelect']"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
		
		dsl.clickButton("//button[@class='btn btn-default']");
		dsl.clickButton("//button[@class='btn logout']");
		
	}
	
	@Test
	public void OpenAccount(){

		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
		dsl.clickButton("//button[@class='btn btn-lg tab' and @ng-class='btnClass2']");
		
		dsl.selectComboBox("//select[@id='userSelect']", "Harry Potter");
		
		dsl.selectComboBox("//select[@id='currency']", "Pound");
		
		dsl.clickButton("//button[@type='submit']");
		
		dsl.alertAccept();
	}
	
	@Test
	public void Deposit(){

		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");
		
		dsl.selectComboBox("//select[@id='userSelect']", "Harry Potter");
		
		dsl.clickButton("//button[@class='btn btn-default']");
		
		value = Integer.parseInt(dsl.getValue("//strong[2][@class='ng-binding']"));
		
		dsl.clickButton("//button[@ng-click='deposit()']");
		dsl.write("//input[@ng-model='amount']", "50");;
		dsl.clickButton("//button[@class='btn btn-default']");
		Assert.assertEquals(value + 50, value + 50);
	}
	
	@Test
	public void Withdrawl(){
		
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");
		
		dsl.selectComboBox("//select[@id='userSelect']", "Harry Potter");
		
		dsl.clickButton("//button[@class='btn btn-default']");
		
		value = Integer.parseInt(dsl.getValue("//strong[2][@class='ng-binding']"));
		
		dsl.clickButton("//button[@ng-click='withdrawl()']");
		dsl.write("//input[@ng-model='amount']", "50");
		dsl.clickButton("//button[@class='btn btn-default']");
		Assert.assertEquals(value + 50, value + 50);
	}
	
	@Test
	public void ValidTransactions(){

		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");
		
		dsl.selectComboBox("//select[@id='userSelect']", "Harry Potter");
		
		dsl.clickButton("//button[@class='btn btn-default']");
			
		dsl.clickButton("//button[@ng-click='transactions()']");
		dsl.clickLink("Date-Time");
	}
	
	@Test
	public void test() {
		
//		System.out.println(driver.findElement(By.xpath("//button[@class='btn home']")).getAttribute("value"));
//		System.out.println(driver.findElement(By.xpath("//button[@class='btn home']")).getText());
	}
	
}