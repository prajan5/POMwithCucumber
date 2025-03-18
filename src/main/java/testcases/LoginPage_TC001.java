package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class LoginPage_TC001 extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setValues()
	{
		data="LoginPage";
		testName="LoginPae";
		testDescription ="Leaptap Application for Login";
		testAuthor = "Priya";
		testCategory ="smoke";
		
	}
@Test(dataProvider = "getData")
public void login(String userName, String password) throws IOException
{
	//create object for LoginPage
	LoginPage lp = new LoginPage();
	System.out.println();
	//method level chaining
	lp.enterUserName(userName)
	.enterPassword(password)
	.clickOnLoginButton()
	.clickOnCrmsfa()
	.clickOnLeads();

	
	
	}



}
