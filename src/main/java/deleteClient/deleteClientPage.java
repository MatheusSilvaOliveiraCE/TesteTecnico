package deleteClient;

import static testeTecnico.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class deleteClientPage {

	public void checkClient(String colun, String name, String button) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
		int idColun = getColun(colun, table);
		int idLine = getValueName(name, table, idColun);
		int idColunButton = getColun(button, table);
		
		WebElement cel = table.findElement(By.xpath("./tbody/tr["+idLine+"]/td["+idColunButton+"]"));
		cel.findElement(By.xpath(".//button[@ng-click='deleteCust(cust)']")).click();
		
	}
	
	private int getColun(String colun, WebElement table) {
		List <WebElement> coluns = table.findElements(By.xpath(".//td"));
		int idColun= -1;
		for(int i = 0; i< coluns.size(); i++) {
			String a = coluns.get(i).getText();
			if(a.equals(colun)) {
				idColun = i+1;
				return idColun;
			}
		}
		return idColun;
	}
	
	private int getValueName(String name, WebElement table, int colun) {
		List <WebElement> line = table.findElements(By.xpath("./tbody/tr/td["+colun+"]"));
		int idLine= -1;
		for(int i = 0; i< line.size(); i++) {
			String a = line.get(i).getText();
			if(a.equals(name)) {
				idLine = i+1;
				return idLine;
			}
		}
		return idLine;
	}
	
}
