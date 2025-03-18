package base;

import java.io.IOException;
import java.time.Duration;
import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.IntegrationWithTCWithIndices;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests {
	
	
	private static final ThreadLocal<RemoteWebDriver> cdDriver = new ThreadLocal<RemoteWebDriver>();
	//step2
	public static ExtentReports ers;
	public static ExtentTest test;
	public String testName, testDescription, testAuthor, testCategory;
	
	
	public void setDriver() {
		cdDriver.set(new ChromeDriver());
	}

	
	public RemoteWebDriver getDriver() {
		return cdDriver.get();
	}


	public String data;
	
	@BeforeMethod
	public void preCondition() {
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	@AfterMethod
	public void postcondition() {
		getDriver().close();
	}
	
	
	@DataProvider(name="getData",indices = {1})//,indices = {0}
	public String[][] setValue() throws IOException{
			//classname.methodname and return the value 
		return utils.IntegrationWithTCWithIndices.readExcel(data);
				
}
	//step1
	@BeforeSuite
	public void startReport()
	{
		//set path for the report
				ExtentHtmlReporter er = new ExtentHtmlReporter("./reports/result.html");
				//report should not override
				//er.setAppendExisting(true);
				//Create Object for Extent report
				  ers = new ExtentReports();
				//connect step 1 and step2
				ers.attachReporter(er);
	}
	
	//step3
	@AfterSuite
	public void stopReport()
	{
		ers.flush();
	}
	
	@BeforeClass
	public void testdetails()
	{
		
		test = ers.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}
	
	public void reportStep(String stepDetails, String status) throws IOException
	{
		if(status.equalsIgnoreCase("pass"))
		{
			test.pass(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/image"+takeSnap()+".png").build());

		}
		else if((status.equalsIgnoreCase("fail")))
		{
			test.fail(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/image"+takeSnap()+".png").build());
		}
	}
	
	public int takeSnap() throws IOException 
	{
		int random = (int)(Math.random()*99999);
		File scr = getDriver().getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/image"+random+".png");
		FileUtils.copyFile(scr, dst);
		return random;
	}
	
}
