package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// import io.github.bonigarcia.wdm.WebDriverManager;

import utils.Constants;
import utils.Util;

public class BaseClass {

    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    // *******************************************************
    // getDriver() → Returns thread-safe WebDriver instance
    // *******************************************************
    public static WebDriver getDriver() {
        return webDriver.get();
    }

    // *******************************************************
    // launchDriver() → Launches browser based on config file
    // *******************************************************
    public static void launchDriver() throws IOException {

        try {

            String browser = Util.readProperties("browser");
            WebDriver driver;

            if (browser.equalsIgnoreCase("chrome")) {
                 // No need if using WebDriverManager
                System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");  
                // No need if using WebDriverManager
                // WebDriverManager.chromedriver().setup();   

                driver = new ChromeDriver();

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));

                webDriver.set(driver);
                log.info("Driver launched for thread: " + Thread.currentThread().threadId());
            }

            else if (browser.equalsIgnoreCase("ff")) {
                 // No need if using WebDriverManager
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    
                // WebDriverManager.firefoxdriver().setup(); 

                driver = new FirefoxDriver();

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));

                webDriver.set(driver);
                log.info("Driver launched for thread: " + Thread.currentThread().threadId());
            }

            else {
                 // No need if using WebDriverManager
                System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
               
                // WebDriverManager.edgedriver().setup();  

                driver = new EdgeDriver();

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));

                webDriver.set(driver);
                log.info("Driver launched for thread: " + Thread.currentThread().threadId());
            }

        } catch (IOException e) {
            log.error("Failed to read 'browser' property file. " + e.getMessage());
            throw e;

        } catch (Exception e) {
            log.error("Browser failed to launch. Details: " + e.getMessage());
        }
    }

    // *******************************************************
    // openURL() → Loads the given URL in the active browser
    // *******************************************************
    public static void openURL(String url) {

        try {
            getDriver().get(url);
        } catch (Exception e) {
            log.error("Failed to open URL: " + url + ". Details: " + e.getMessage());
        }
    }

    // *******************************************************
    // tearDown() → Closes and quits browser safely
    // *******************************************************
    public static void tearDown() {

        try {

            if (getDriver() != null) {

                getDriver().close();
                log.info("Active browser window closed.");

                getDriver().quit();
                log.info("Browser session quit successfully.");

                log.info("Browser closed for thread: " + Thread.currentThread().threadId());

                webDriver.remove();
            }

        } catch (Exception e) {
            log.error("Browser teardown failed. Details: " + e.getMessage());
        }
    }
}
