package testcases;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethod;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/Login.feature",
glue="pages",
publish=true,
monochrome=true)

public class CucumberRunner_TC003 extends ProjectSpecificMethod{

	@BeforeTest
	public void setValues()
	{
		data="LoginPage";
		testName="LoginPae";
		testDescription ="Leaptap Application for Login";
		testAuthor = "Priya";
		testCategory ="smoke";
	}

}
