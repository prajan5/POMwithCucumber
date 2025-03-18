package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	
	

	public MyHomePage clickOnCrmsfa()
	{
	//Click on the "CRM/SFA" link.
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		
		return new MyHomePage();

	}

	
	
	public LoginPage clickOnLogOut()
	{
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new LoginPage();
	}
}
