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

public class CommonMethod extends BaseClass {

    public CommonMethod(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------------------------------------------------
    // Basic Wait Utilities
    // ---------------------------------------------------------
    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            log.error("waitForElement failed: " + e.getMessage());
            return null;
        }
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error("waitForVisibilityOfElement failed: " + e.getMessage());
            return null;
        }
    }

    // ---------------------------------------------------------
    // Scrolling
    // ---------------------------------------------------------
    public void scrollTo(WebElement element) {
        try {
            WebDriver driver = getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
        } catch (Exception e) {
            log.error("scrollTo failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Click / Type
    // ---------------------------------------------------------
    public void clickOnElement(WebElement element, long durationInSeconds) {
        try {
            WebElement webelement = waitForElement(element, durationInSeconds);
            webelement.click();
        } catch (Exception e) {
            log.error("clickOnElement failed: " + e.getMessage());
        }
    }

    public void typeTextIntoElement(WebElement element, String textToKeyboard, long durationInSeconds) {
        try {
            WebElement webelement = waitForElement(element, durationInSeconds);
            webelement.click();
            webelement.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
            webelement.sendKeys(textToKeyboard);
        } catch (Exception e) {
            log.error("typeTextIntoElement failed: " + e.getMessage());
        }
    }

    public void sendKey(WebElement element, String textToKeyboard, long durationInSeconds) {
        try {
            WebElement webelement = waitForElement(element, durationInSeconds);
            webelement.click();
            webelement.sendKeys(textToKeyboard);
        } catch (Exception e) {
            log.error("sendKey failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Dropdowns
    // ---------------------------------------------------------
    public void selectOptionFromDropDown(WebElement dropdown, String option, long durationInSeconds) {
        try {
            WebElement visibleDropdown = waitForVisibilityOfElement(dropdown, durationInSeconds);
            Select select = new Select(visibleDropdown);
            select.selectByVisibleText(option);
        } catch (Exception e) {
            log.error("selectOptionFromDropDown failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Mouse Actions
    // ---------------------------------------------------------
    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        try {
            WebDriver driver = getDriver();
            WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
            Actions action = new Actions(driver);
            action.moveToElement(webelement).click().build().perform();
        } catch (Exception e) {
            log.error("mouseHoverAndClick failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Alerts
    // ---------------------------------------------------------
    public void alertAccept() {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            log.error("alertAccept failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Windows
    // ---------------------------------------------------------
    public void switchToNewWindow() {
        try {
            WebDriver driver = getDriver();
            String parentWindow = driver.getWindowHandle();

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            driver.close();
            driver.switchTo().window(parentWindow);
        } catch (Exception e) {
            log.error("switchToNewWindow failed: " + e.getMessage());
        }
    }

    public void switchToWindow(String parentWin, String title) {
        try {
            WebDriver driver = getDriver();
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(parentWin)) {
                    driver.switchTo().window(window);

                    if (driver.getTitle().equalsIgnoreCase(title)) {
                        log.info("Window found: " + title);
                    }

                    driver.close();
                }
            }

            driver.switchTo().window(parentWin);
        } catch (Exception e) {
            log.error("switchToWindow failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Radio Buttons
    // ---------------------------------------------------------
    public void radioButton(WebElement radio, long durationInSeconds) {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.visibilityOf(radio));

            if (!radio.isSelected()) {
                radio.click();
            }
        } catch (Exception e) {
            log.error("radioButton failed: " + e.getMessage());
        }
    }

    public void radioButton(List<WebElement> radioButtons, String value, long durationInSeconds) {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.visibilityOfAllElements(radioButtons));

            for (WebElement button : radioButtons) {
                String attrValue = button.getAttribute("value").trim();
                if (attrValue.equalsIgnoreCase(value)) {
                    if (!button.isSelected()) {
                        button.click();
                    }
                    return;
                }
            }
        } catch (Exception e) {
            log.error("radioButton(list) failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Highlight
    // ---------------------------------------------------------
    public void highLightElementMethod(WebElement element) {
        try {
            WebDriver driver = getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalStyle = element.getAttribute("style");

            js.executeScript("arguments[0].setAttribute('style', arguments[1] + 'border: 4px solid green;');",
                    element, originalStyle);
            Thread.sleep(500);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, originalStyle);

        } catch (Exception e) {
            log.error("highLightElementMethod failed: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // Visibility / Get Text
    // ---------------------------------------------------------
    public boolean elementIsDisplayed(WebElement element, long durationInSeconds) {
        try {
            WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
            return webelement.isDisplayed();
        } catch (Exception e) {
            log.error("elementIsDisplayed failed: " + e.getMessage());
            return false;
        }
    }

    public String getText(WebElement element, long durationInSeconds) {
        try {
            WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
            return webelement.getText().trim();
        } catch (Exception e) {
            log.error("getText failed: " + e.getMessage());
            return "";
        }
    }

    // ---------------------------------------------------------
    // Excel Utilities
    // ---------------------------------------------------------
    public void excel(WebElement element, long durationInSeconds) throws IOException {
        try {
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
        } catch (Exception e) {
            log.error("excel write failed: " + e.getMessage());
            throw e;
        }
    }

    public String readExcel(String filePath, String sheetName, int cellNo, int rowNo) throws IOException {
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheet(sheetName);
            HSSFRow row = sheet.getRow(rowNo);
            HSSFCell cell = row.getCell(cellNo);
            String cellData = cell.getStringCellValue();
            wb.close();
            return cellData;
        } catch (Exception e) {
            log.error("readExcel failed: " + e.getMessage());
            throw e;
        }
    }
}
