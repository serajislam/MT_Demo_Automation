package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\Features",
		// features=".\\Features",
		glue = { "stepDefinations", "hooks" },
		// dryRun=true,
		monochrome = true,
		// running with single tags
		//tags = "@Smoke",
		
		//running with both tags.this will run if feature file has both tag
		//tags = "@Smoke and @Regression",	
		
		//running with either tags. this will run if feature file has either tag
		//tags = "@Smoke or @Regression",
		plugin = { "pretty", "html:CucumberReport/CucumberReport.html",
				"json:target/JsonReport/JsonReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)

public class Runner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true) // THIS ENABLES PARALLEL EXECUTION
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
