package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class AccountPage_TC002 extends ProjectSpecificMethod {

	@Test
	public void login() throws IOException
	{
	//create object for LoginPage
		LoginPage lp = new LoginPage();
		System.out.println();
		
		//method level chaining
		lp.enterUserName("DemoCsr")
		.enterPassword("crmsfa")
		.clickOnLoginButton()
		.clickOnCrmsfa()
		.clickOnAccounts();
		
	
	}
		
		
		
}
