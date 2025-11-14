package hooks;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Util;


public class Hooks extends BaseClass{
	
	//every test scenario execution before this method is executed

		//just like @beforeMethod
		@Before
		public void beforeScenario(Scenario scenario) throws IOException
		{
			//launchDriver();
			launchDriver();
			log.info("****************LOG STARTING*******************");
			log.info("Scenario Executing Start :-"+ scenario.getName());
			//openURL(Util.readProperties("url"));
			openURL(Util.readProperties("url"));
			log.info("Application is opended :-"+ scenario.getName());
			
			
			
		}

		//just like @afterMethod
		@After
		public void afterScenario(Scenario scenario)
		{
			/*
			boolean failed = scenario.isFailed();
			if(failed) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png",scenario.getName());
				
				
				}
			*/
			
			
			//validate if scenario has failed
	        if(scenario.isFailed()) {
			//scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
			scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
	        }
		
			// log.info("Scenario Executing Finish :-"+ scenario.getName());
			//tearDown();
			
			log.info("Scenario Finish :- " + scenario.getName());
	        tearDown(); // ✅ Ensures driver is closed per thread

		}
	
}
