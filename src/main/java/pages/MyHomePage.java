package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod {
	
	

	
	public CreateLeadPage clickOnLeads()
	{
		//Click on the "Leads" tab.
		getDriver().findElement(By.linkText("Leads")).click();
				return new CreateLeadPage();
	}
	
	
	public void clickOnContacts()
	{
		//Click on the "Contacts" tab.
		getDriver().findElement(By.linkText("Contacts")).click();
	}
	
	public MyAccountPage clickOnAccounts()
	{
		//Click on the "Accounts" tab.
		getDriver().findElement(By.linkText("Accounts")).click();
		return new MyAccountPage();
	}
	
	
}
