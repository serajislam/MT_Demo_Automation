package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features=".\\Features",
		//features=".\\Features",
		glue={"stepDefinations", "hooks"},
	   //dryRun=true,
	   monochrome=true, 
	    // running with single tags
	   // tags = "@Smoke",
	    plugin = {"pretty","html:CucumberReport/CucumberReport.html",
	    		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    		 }
	
		)

public class Runner extends AbstractTestNGCucumberTests{

	
	@Override
	@DataProvider(parallel = true) // THIS ENABLES PARALLEL EXECUTION
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
