package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

/**
 * ✅ CommonMethod Utility Class (Thread-Safe)
 *
 * All methods use getDriver() from BaseClass for thread-safe execution.
 * Avoids direct driver references — safe for parallel testing.
 */
public class CommonMethod extends BaseClass {

    // Constructor
    public CommonMethod(WebDriver driver) {
        this.driver = driver;
        //BaseClass.driver = driver;
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Basic Wait Utilities
    // ----------------------------------------------------------------------------------------------------

    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Scrolling
    // ----------------------------------------------------------------------------------------------------

    public void scrollTo(WebElement element) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Click / Type
    // ----------------------------------------------------------------------------------------------------

    public void clickOnElement(WebElement element, long durationInSeconds) {
        WebElement webelement = waitForElement(element, durationInSeconds);
        webelement.click();
    }

    public void typeTextIntoElement(WebElement element, String textToKeyboard, long durationInSeconds) {
        WebElement webelement = waitForElement(element, durationInSeconds);
        webelement.click();
        webelement.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        webelement.sendKeys(textToKeyboard);
    }

    public void sendKey(WebElement element, String textToKeyboard, long durationInSeconds) {
        WebElement webelement = waitForElement(element, durationInSeconds);
        webelement.click();
        webelement.sendKeys(textToKeyboard);
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Dropdowns
    // ----------------------------------------------------------------------------------------------------

    public void selectOptionFromDropDown(WebElement dropdown, String option, long durationInSeconds) {
        WebElement visibleDropdown = waitForVisibilityOfElement(dropdown, durationInSeconds);
        Select select = new Select(visibleDropdown);
        select.selectByVisibleText(option);
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Mouse Actions
    // ----------------------------------------------------------------------------------------------------

    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        WebDriver driver = getDriver();
        WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);

        try {
            Actions action = new Actions(driver);
            action.moveToElement(webelement).click().build().perform();
            log.info("Mouse hovered and clicked element: " + element);
        } catch (Exception e) {
            log.error("Error performing mouse hover and click: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Alerts
    // ----------------------------------------------------------------------------------------------------

    public void alertAccept() {
        WebDriver driver = getDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            log.info("Alert displayed: " + alert.getText());
            alert.accept();
            log.info("Alert accepted successfully.");
        } catch (Exception e) {
            log.error("Error handling alert: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Windows
    // ----------------------------------------------------------------------------------------------------

    public void switchToNewWindow() {
        WebDriver driver = getDriver();
        String parentWindow = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void switchToWindow(String parentWin, String title) {
        WebDriver driver = getDriver();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWin)) {
                driver.switchTo().window(window);
                log.info("Switched to window: " + driver.getTitle());

                if (driver.getTitle().equalsIgnoreCase(title)) {
                    log.info("✅ Matched Title: " + driver.getTitle());
                    log.info("URL: " + driver.getCurrentUrl());
                    log.info("Handle: " + driver.getWindowHandle());
                }

                driver.close();
            }
        }

        driver.switchTo().window(parentWin);
        log.info("Returned to parent window: " + parentWin);
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Radio Buttons
    // ----------------------------------------------------------------------------------------------------

    public void radioButton(WebElement radio, long durationInSeconds) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.visibilityOf(radio));

        if (!radio.isSelected()) {
            radio.click();
            log.info("Clicked on radio button: " + radio);
        } else {
            log.info("Radio button already selected: " + radio);
        }
    }

    public void radioButton(List<WebElement> radioButtons, String value, long durationInSeconds) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(radioButtons));

        boolean found = false;

        for (WebElement button : radioButtons) {
            String attrValue = button.getAttribute("value").trim();
            if (attrValue.equalsIgnoreCase(value)) {
                if (!button.isSelected()) {
                    button.click();
                    log.info("Selected radio button with value: " + attrValue);
                } else {
                    log.info("Radio button already selected: " + attrValue);
                }
                found = true;
                break;
            }
        }

        if (!found) {
            log.warn("No radio button found with value: " + value);
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Highlight Element
    // ----------------------------------------------------------------------------------------------------

    public void highLightElementMethod(WebElement element) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            String originalStyle = element.getAttribute("style");
            js.executeScript("arguments[0].setAttribute('style', arguments[1] + 'border: 4px solid green;');", element, originalStyle);
            Thread.sleep(500);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
        } catch (Exception e) {
            log.error("Could not highlight element: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Get Text / Visibility
    // ----------------------------------------------------------------------------------------------------

    public boolean elementIsDisplayed(WebElement element, long durationInSeconds) {
        try {
            WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
            return webelement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(WebElement element, long durationInSeconds) {
        WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
        String text = webelement.getText().trim();
        log.info("Fetched text: " + text);
        return text;
    }

    // ----------------------------------------------------------------------------------------------------
    // ✅ Excel Utilities
    // ----------------------------------------------------------------------------------------------------

    public void excel(WebElement element, long durationInSeconds) throws IOException {
        WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);

        File file = new File(".\\DataProvider\\TestData.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet("Regi_Data");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 1; i <= rowCount; i++) {
            webelement.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            FileOutputStream outputStream = new FileOutputStream(".\\DataProvider\\TestData.xls");
            wb.write(outputStream);
        }

        wb.close();
    }

    public String readExcel(String filePath, String sheetName, int cellNo, int rowNo) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet(sheetName);
        HSSFRow row = sheet.getRow(rowNo);
        HSSFCell cell = row.getCell(cellNo);
        String cellData = cell.getStringCellValue();
        wb.close();
        return cellData;
    }
}
