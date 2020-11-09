package VerifyValue;

import testeTecnico.core.DSL;
public class VerifyValuePage {

private DSL dsl;
	
	public VerifyValuePage() {
		dsl = new DSL();
	}
//***********************************Buttons****************************************//
	public void clickManagerClient() {
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
	}
	
	public void clickManagerOpenAccount() {
		dsl.clickButton("//button[@class='btn btn-lg tab' and @ng-click='openAccount()']");
	}
	
	public void clickSubmit() {
		dsl.clickButton("//button[@type='submit']");
	}

	public void clickHome() {
		dsl.clickButton("//button[@class='btn home' and @ng-click='home()']");
	}

	public void clickCustomer() {
		dsl.clickButton("//button[@class='btn btn-primary btn-lg' and @ng-click='customer()']");
	}
	
	public void clickLogIn() {
		dsl.clickButton("//button[@class='btn btn-default']");
	}
	
	public void clickWithdrawl() {
		dsl.clickButton("//button[@ng-click='withdrawl()']");
	}
	
	public void clickDeposit() {
		dsl.clickButton("//button[@ng-click='deposit()']");
	}
	
	public void clickTransaction() {
		dsl.clickButton("//button[@ng-click='transactions()']");
	}
	
	public void clickDatetime(){
		dsl.clickLink("Date-Time");
	}
	
	public void confirmDeposit() {
		dsl.clickButton("//button[@class='btn btn-default' and contains(text(), 'Deposit')]");
	}
	
	public void confirmWithDrawl() {
		dsl.clickButton("//button[@class='btn btn-default' and contains(text(), 'Withdraw')]");
	}
	
//***********************************Box****************************************//
	
	public void selectAccount(String name) {
		dsl.selectComboBox("//select[@id='userSelect']", name);
	}
	
	public void selectCurrency(String currency) {
		dsl.selectComboBox("//select[@id='currency']", currency);
	}
	
	//***********************************Write****************************************//
	
	public void setTransactionValue(String value) {
		dsl.write("//input[@ng-model='amount']", value);
	}
}
