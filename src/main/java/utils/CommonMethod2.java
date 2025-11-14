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

public class CommonMethod2 extends BaseClass {

	
	public WebDriver driver = webDriver.get();
	
	public CommonMethod2(WebDriver driver) {
		this.driver = driver;

	}
	
	public void scrollTo (WebElement e) {
	    JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeAsyncScript("arguments[0].scrollIntoView(true)", e);
	    //js.executeAsyncScript("window.scrollBy(0,-150)");
	    //e.click();
	}
	
   //This method will click on a WebElement
	public void clickonElement(WebElement element, long durationInSeconds) {

		WebElement webelement = waitforelement(element, durationInSeconds);
		webelement.click();
	}
	
	 //This method  will also click on a WebElement since same method can not click on if need to click on  element twice
	public void clickOnWebElement(WebElement element, long durationInSeconds) {

		WebElement webelement = waitforelement(element, durationInSeconds);
		webelement.click();
	}

	//This method will work as send key method on a WebElement
	public void typetextIntoElement(WebElement element, WebElement element1, String textToKeyboard , long durationInSeconds) {

		WebElement webelement = waitforelement(element, durationInSeconds);
		webelement.click(); // clcking on element
		
		// clearing any text in element
		//webelement.clear();
		// clearing complete text in element
		webelement.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// and then typing any text in element
		webelement.sendKeys(textToKeyboard);
		//webelement.sendKeys(textToKeyboard);
		
	}
	
	//This method will work as send key method on a WebElement
		public void sendKey(WebElement element, String textToKeyboard , long durationInSeconds) {

			WebElement webelement = waitforelement(element, durationInSeconds);
			webelement.click(); // clcking on element
			
			// clearing any text in element
			//webelement.clear();
			// clearing complete text in element
			//webelement.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			// and then typing any text in element
			webelement.sendKeys(textToKeyboard);
			
		}
	

	public WebElement waitforelement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			e.printStackTrace();

		}
		return webelement;
	}

	
	// ✅ Wait for element to be clickable (thread-safe)
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
	    WebDriver driver = getDriver();
	    if (driver == null) {
	        throw new IllegalStateException("WebDriver is null in waitForElement().");
	    }

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void selFromDropdown(WebElement element, String option, long durationInSeconds) {

		WebElement webelement = waitforelement(element, durationInSeconds);
		//Select select = new Select(webelement);
		//select.selectByVisibleText(dropdownoption);
		
		Select sel = new Select(webelement);
		sel.selectByVisibleText(option);
		//select.selectByIndex(dropdownoptionIndex);
		//log.info("Dropdown Total element count :- "+sel.getOptions().size());
	}
	
	
public void selectOptionFromDropDown(WebElement dropdown, String option) {
		
		//wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select= new Select(dropdown);
		select.selectByVisibleText(option);
		//log.info("Dropdown Total element count :- "+select.getOptions().size());
		
	}

//✅ Thread-safe version: uses getDriver() from BaseClass
public void mouseHoverAndClK(WebElement element, long durationInSeconds) {
 WebDriver driver = getDriver(); // ✅ Always use the thread-local driver
 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in mouseHoverAndClK().");
 }

 WebElement webelement = waitforvisibilityofelement(element, durationInSeconds);

 try {
     Actions action = new Actions(driver);
     action.moveToElement(webelement).click().build().perform(); // ✅ Combined hover+click
     log.info("Mouse hovered and clicked element: " + element);
 } catch (Exception e) {
     log.error("Error performing mouse hover and click: " + e.getMessage());
 }
}

//✅ Thread-safe alert accept using getDriver()
public void alertAccept() throws Exception {
 WebDriver driver = getDriver(); // ✅ Always get the correct driver
 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in alertAccept().");
 }

 try {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // ✅ waits safely

     log.info("Alert displayed: " + alert.getText());
     alert.accept();
     log.info("Alert accepted successfully.");

 } catch (Exception e) {
     log.error("Error handling alert: " + e.getMessage());
 }
}

  
  

	public WebElement waitforvisibilityofelement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();

		}
		return webelement;
	}

	public boolean elementisdisplayed(WebElement element, long durationInSeconds) {

		WebElement webelement = waitforvisibilityofelement(element, durationInSeconds);
		try {
			return webelement.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public String gettingText(WebElement element, long durationInSeconds) {

		WebElement webelement = waitforvisibilityofelement(element, durationInSeconds);
		String text = null;
		try {
			text = webelement.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}
	
	
	// this method is for assertion
	public String getText(WebElement element, long durationInSeconds) {

		WebElement webelement = waitforvisibilityofelement(element, durationInSeconds);
		String actText = null;
		actText =webelement.getText();
		log.info(" Actual Text is " +webelement.getText());
		return actText;
	}
/*
	
public void switchToNewWindow(WebDriver driver) {
		
	      // Store the current window handle
			String winHandleBefore = driver.getWindowHandle();
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			

			// Perform the actions on new window
			

			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);

			// Continue with original browser (first window)

	}
*/
public void switchToNewWindow() {
    WebDriver driver = getDriver(); // ✅ fetch correct driver
    if (driver == null) {
        throw new IllegalStateException("WebDriver is null in switchToNewWindow()");
    }

    String winHandleBefore = driver.getWindowHandle();

    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
    }

    driver.close();
    driver.switchTo().window(winHandleBefore);
}



//✅ Thread-safe window switch method using getDriver()
public void switchToWindow(String parentWin, String title) {
 WebDriver driver = getDriver(); // ✅ Always get thread-local driver
 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in switchToWindow().");
 }

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

         driver.close(); // ✅ Close new window
     }
 }

 driver.switchTo().window(parentWin);
 log.info("Returned to parent window: " + parentWin);
}

//✅ Clicks single radio button only if not already selected
public void radioButton(WebElement radio, long durationInSeconds) {
 WebDriver driver = getDriver();
 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in radioButton().");
 }

 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
 wait.until(ExpectedConditions.visibilityOf(radio));

 if (!radio.isSelected()) { // ✅ fixed logic
     radio.click();
     log.info("Clicked on radio button: " + radio);
 } else {
     log.info("Radio button already selected: " + radio);
 }
}

//✅ Selects radio button from list by value attribute
public void radioButton(List<WebElement> radioButtons, String value, long durationInSeconds) {
 WebDriver driver = getDriver();
 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in radioButton(List).");
 }

 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
 wait.until(ExpectedConditions.visibilityOfAllElements(radioButtons));

 boolean found = false;

 for (WebElement button : radioButtons) {
     String attrValue = button.getAttribute("value").trim(); // ✅ lowercase "value"
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


//✅ Thread-safe highlight method that works with your ThreadLocal driver setup
public void highLightElementMethod(WebElement element) {
 WebDriver driver = getDriver(); // ✅ Always fetch current thread's WebDriver

 if (driver == null) {
     throw new IllegalStateException("WebDriver instance is null in highLightElementMethod().");
 }

 JavascriptExecutor js = (JavascriptExecutor) driver;

 try {
     // Store original element style (so we can revert it later)
     String originalStyle = element.getAttribute("style");

     // Apply temporary highlight (green border)
     js.executeScript(
         "arguments[0].setAttribute('style', arguments[1] + 'border: 4px solid green; border-style: solid;');",
         element, originalStyle
     );

     // Short delay so highlight is visible (reduce to 300–500 ms for faster tests)
     Thread.sleep(3000);

     // Restore original style to avoid affecting UI
     js.executeScript(
         "arguments[0].setAttribute('style', arguments[1]);",
         element, originalStyle
     );

 } catch (Exception e) {
     System.err.println("Could not highlight element: " + e.getMessage());
 }
}

		
		
		// reading data from excel
		  
		  public void excel(WebElement element, long durationInSeconds) throws IOException {
			  
			  WebElement webelement = waitforvisibilityofelement(element, durationInSeconds);
			  
			  //webelement.sendKeys(textToKeyboard);

		        //Create an object of File class to open xls file
		        File file =    new File(".\\DataProvider\\TestData.xls");
		        
		        //Create an object of FileInputStream class to read excel file
		        FileInputStream inputStream = new FileInputStream(file);
		        
		        //creating workbook instance that refers to .xls file
		        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		        
		        //creating a Sheet object
		        HSSFSheet sheet=wb.getSheet("Regi_Data");
		        
		        //get all rows in the sheet
		        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

		        //Identify the WebElements for the student registration form
		       /* WebElement firstName=driver.findElement(By.id("firstName"));
		        WebElement lastName=driver.findElement(By.id("lastName"));
		        WebElement email=driver.findElement(By.id("userEmail"));
		        WebElement genderMale= driver.findElement(By.id("gender-radio-1"));
		        WebElement mobile=driver.findElement(By.id("userNumber"));
		        WebElement address=driver.findElement(By.id("currentAddress"));
		        WebElement submitBtn=driver.findElement(By.id("submit"));
		        */



		        //iterate over all the rows in Excel and put data in the form.
		        for(int i=1;i<=rowCount;i++) {
		            //Enter the values read from Excel in firstname,lastname,mobile,email,address
					/*
					 * firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
					 * lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
					 * email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
					 * mobile.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
					 * address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
					 */
		        	
		        	webelement.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		        	//webelement.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		        	//webelement.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		        	//webelement.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
		        	
		        	//webelement.sendKeys(textToKeyboard);
		        	
		        	
		            
		            //create a new cell in the row at index 6
		           // HSSFCell cell = sheet.getRow(i).createCell(6);

		            
		            // Write the data back in the Excel file
		            FileOutputStream outputStream = new FileOutputStream(".\\\\DataProvider\\\\TestData.xls");
		            wb.write(outputStream);

		        }
		        
		        //Close the workbook
		        wb.close();
		        
			
		  }
		 
		  public String readExcel(String filePath,String sheetName, int cellNo,int rowNo) throws IOException {
			 
			  
			//Create an object of File class to open xls file
		        File file =    new File(filePath);
		      //Create an object of FileInputStream class to read excel file
		        FileInputStream inputStream = new FileInputStream(file);
		        //creating workbook instance that refers to .xls file
		        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		        //creating a Sheet object
		        HSSFSheet sheet=wb.getSheet(sheetName);
		        
		        HSSFRow row = sheet.getRow(rowNo);
		        HSSFCell cell = row.getCell(cellNo);
		        String cellData = cell.getStringCellValue();
			  
			  
			  
			  
			return cellData;
			  
		  }
		  
		 
}
