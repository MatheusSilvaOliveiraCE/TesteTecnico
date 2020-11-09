package addClient.testTecnico;

import testeTecnico.core.DSL;

public class AddClientPage {

	private DSL dsl;
	
	public AddClientPage() {
		dsl = new DSL();
	}
	
//***************************Field Text********************************//
	
	public void setName(String name) {
		dsl.write("//input[@ng-model='fName']", name);
	}
	
	public String getValue(String field) {
		if(field == "NAME") {
			return dsl.getValue("//input[@ng-model='fName']");
		}
		if(field == "LNAME") {
			return dsl.getValue("//input[@ng-model='lName']");
		}
		if(field == "PCODE") {
			return dsl.getValue("//input[@ng-model='postCd']");
		}
		return null;
	}
	
	public String getName() {
		return dsl.getValue("//input[@ng-model='fName']");
	}
	
	public void setLastName(String lName) {
		dsl.write("//input[@ng-model='lName']", lName);
	}
	
	public String getLastName() {
		return dsl.getValue("//input[@ng-model='lName']");
	}
	
	public void setPostCode(String pCode) {
		dsl.write("//input[@ng-model='postCd']", pCode);
	}
	
	public String getPostCode() {
		return dsl.getValue("//input[@ng-model='postCd']");
	}
	
	
//*****************************Buttons**********************************//
	public void clickManagerClient() {
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
	}
	
	public void clickAddClient() {
		dsl.clickButton("//button[@class='btn btn-lg tab']");
	}
	
	public void setAddClient() {
		dsl.clickButton("//button[@class='btn btn-default' and contains(.,'Add Customer')]");
	}
	
	
	
}
