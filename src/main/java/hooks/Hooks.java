package hooks;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Util;

public class Hooks extends BaseClass {

    // @Before - executes before every scenario
    @Before
    public void beforeScenario(Scenario scenario) throws IOException {

        try {
            launchDriver();
        } catch (Exception e) {
            log.error("Failed to launch browser. Details: " + e.getMessage());
            throw e; // still throw because test cannot continue without browser
        }

        log.info("****************LOG STARTING*******************");
        log.info("Scenario Executing Start :- " + scenario.getName());

        try {
            openURL(Util.readProperties("url"));
            log.info("Application is opened :- " + scenario.getName());
        } catch (Exception e) {
            log.error("Failed to load application URL. Details: " + e.getMessage());
        }
    }

    // @After - executes after every scenario
    @After
    public void afterScenario(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
            }
        } catch (Exception e) {
            log.error("Failed to capture screenshot. Details: " + e.getMessage());
        }

        log.info("Scenario Finish :- " + scenario.getName());

        try {
            tearDown();
        } catch (Exception e) {
            log.error("Teardown failed. Details: " + e.getMessage());
        }
    }

}
