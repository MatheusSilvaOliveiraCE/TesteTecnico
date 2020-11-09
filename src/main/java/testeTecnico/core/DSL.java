package testeTecnico.core;
import static testeTecnico.core.DriverFactory.getDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	Alert alert;

	public void write(String xpath, String value) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public void clickButton(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public String getValue(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getAttribute("value");
	}
	
	public void selectComboBox(String xpath, String name) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		
		combo.selectByVisibleText(name);
		
	}
		
	public void alertAccept() {
		alert = getDriver().switchTo().alert();
		alert.accept();
	}
}
