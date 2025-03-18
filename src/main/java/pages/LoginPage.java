package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethod {
	

	
	@When("Enter the username as {string}")
	public LoginPage enterUserName(String uName) throws IOException
	{
		try {
			getDriver().findElement(By.id("username")).sendKeys(uName);
			reportStep("Username entered successfully","pass");
		} catch (Exception e) {
			reportStep("Username is not entered ","fail");
		}
		//m1
		//LoginPage lp = new LoginPage();
		//return lp;
		
		//m2
		
		return this;
	}
	@And("Enter the passWord as {string}")
	public LoginPage enterPassword(String pass) throws IOException
	{
		try {
			getDriver().findElement(By.id("password")).sendKeys(pass);
			reportStep("Password entered successfully","pass");
		} catch (Exception e) {
			reportStep("Password is not entered ","fail");
		}
		return this;
	}

	@And("Click on Login Button")
	public HomePage clickOnLoginButton()
	{
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//m1
			//HomePage hp = new HomePage();
			//return hp;
		//m2
		return new HomePage();
	}

	@Then("Verfiy the login is Successful")
	public void negativeLogin() {
		String title = getDriver().getTitle();
		if(title.contains("WebOrders")) {
			System.out.println("Login is Successful");
		}else {
			System.out.println("Login is not Successful");
		}
	}
}
