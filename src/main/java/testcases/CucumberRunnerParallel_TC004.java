package testcases;

import org.testng.annotations.DataProvider;

import base.ProjectSpecificMethod;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/Login.feature",
glue="pages",
publish=true,
monochrome=true)

public class CucumberRunnerParallel_TC004 extends ProjectSpecificMethod{
	
	 @DataProvider(parallel=true)
	    public Object[][] scenarios() {
		 return super.scenarios();
	      
	    }



}
