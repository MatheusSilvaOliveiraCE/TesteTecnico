package LogIn;

import static testeTecnico.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testeTecnico.core.DSL;

public class LogInPage {

	private DSL dsl;
	
	public LogInPage() {
		dsl = new DSL();
	}
	
	@Test
	public void clickCustomer() {
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");
	}
	
	@Test
	public boolean LogIn(String name){
		Select User = new Select(getDriver().findElement(By.xpath("//select[@ng-model='custId']")));
		List <WebElement> UserOptions = User.getOptions();
		int size = UserOptions.size();
		for(int i = 0; i < size; i++) {
			if(UserOptions.get(i).getText().equals(name)) {
				User.selectByVisibleText(name);
				dsl.clickButton("//button[@class='btn btn-default']");
				return true;
			}
		}
		System.out.println("User not Found!");
		return false;
	}
	
}
