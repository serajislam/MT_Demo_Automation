package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import utils.CommonMethod;
import utils.Constants;

public class FindProviderPage extends BaseClass{

	private CommonMethod commonMethod;
	public FindProviderPage() {
		super();

		WebDriver driver = getDriver();
		//PageFactory.initElements(BaseClass.webDriver.get(), this);
		PageFactory.initElements(driver, this);
		commonMethod = new CommonMethod(driver);
		
	}
	
	
	//Find a provider
	@FindBy(xpath = "//div[@id='templateFind_front']//b[contains(text(),'Find a provider')]")
	private WebElement clkOnFindProvider;
		
	//Find a provider Assertion
	@FindBy(xpath = "//span[text()='Find a provider']")
	private WebElement findProviderTxt;
	
	//Filter by Category 
	@FindBy(xpath = "//select[@id='selectCategory']")
	private WebElement selectCategory;
	
	//Filter by specialty
	@FindBy(xpath = "//select[@id='specialtyCategory']")
	private WebElement selectSpecialty;
	
	//Filter by specialty
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	
	//Filter by specialty
	@FindBy(xpath = "//button[@id='findProviders']")
	private WebElement clkOnFindProviders;
	
	
	
	
	public void clkOnFindProvider() throws InterruptedException {
		commonMethod.highLightElementMethod(clkOnFindProvider);
		commonMethod.clickOnElement(clkOnFindProvider, Constants.EXPLICIT_WAIT_TIME);
		log.info("Clicked on Find Provider Page");
		// Applying Assertion
		String expText = "Find a provider";
		Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
	}
	
	
	
	public void selectCategory(String Category) throws InterruptedException {
		commonMethod.clickOnElement(selectCategory, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(selectCategory);
		
		log.info("Clicked on Select Category filter ");
		//Thread.sleep(5000);
		commonMethod.selectOptionFromDropDown(selectCategory, Category, Constants.EXPLICIT_WAIT_TIME);
		log.info("Category Selected ");
		//Thread.sleep(5000);
		// Applying Assertion
		//String expText = "Find a provider";
		//Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
	}
	
	public void selectSpecialty(String Specialty) throws InterruptedException {
		commonMethod.clickOnElement(selectSpecialty, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(selectSpecialty);
		
		log.info("Clicked on Select Specialty filter ");
		//Thread.sleep(5000);
		commonMethod.selectOptionFromDropDown(selectSpecialty, Specialty, Constants.EXPLICIT_WAIT_TIME);
		log.info("Category Selected ");
		//Thread.sleep(5000);
		// Applying Assertion
		//String expText = "Find a provider";
		//Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
	}
	
	public void city(String City) throws InterruptedException {
		commonMethod.clickOnElement(city, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(city);
		log.info("Clicked on city field");
		//Thread.sleep(5000);
		commonMethod.sendKey(city, City, Constants.EXPLICIT_WAIT_TIME);
		//Thread.sleep(5000);
		// Applying Assertion
		//String expText = "Find a provider";
		//Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
	}
	
	public void clkOnFindProviders() throws InterruptedException {
		commonMethod.clickOnElement(clkOnFindProviders, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnFindProviders);
		log.info("Clicked on Find Providers ");
		//Thread.sleep(7000);
		// Applying Assertion
		//String expText = "Find a provider";
		//Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
	}
	
}
