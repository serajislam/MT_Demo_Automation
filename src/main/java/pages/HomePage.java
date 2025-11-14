package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import base.BaseClass;
import utils.CommonMethod;
import utils.Constants;

public class HomePage extends BaseClass{
	
	
	private CommonMethod commonMethod;
	public HomePage() {
		super();
		WebDriver driver = getDriver();
		//PageFactory.initElements(BaseClass.webDriver.get(), this);
		PageFactory.initElements(driver, this);
		commonMethod = new CommonMethod(driver);
		
	}
/*	
	public HomePage() {
		super();
		WebDriver driver = getDriver(); // ✅ Fetch the correct driver for the current thread
		PageFactory.initElements(driver, this);
		commonMethod = new CommonMethod(driver);
	}
}
*/
	
	
	//Home page 
	@FindBy(xpath = "//span[normalize-space()='Home']")
	private WebElement clkOnHome;

	
	//Contact Us page 
	@FindBy(xpath = "//span[normalize-space()='Contact us']")
	private WebElement clkOnContactUs;
	
	//Getting started
	@FindBy(xpath = "//div[@id='templateGetting_front']")
	private WebElement clkOnGettingStarted;
	
	//Getting started Assertion 
	@FindBy(xpath = "//*[contains(., 'Welcome to the Montana Provider Portal')]")
	private WebElement gettingStartedTxt;
	
	
	//FAQs
	@FindBy(xpath = "//div[@id='template1FAQ_front']")
	private WebElement clkOnFAQs;
	
	//Find a provider
	
	//@FindBy(xpath = "//div[@id='cell_n1302430415_2']")
	@FindBy(xpath = "//div[@id='templateFind_front']//b[contains(text(),'Find a provider')]")
	private WebElement clkOnFindProvider;
	
	//Find a provider Assertion
	@FindBy(xpath = "//span[text()='Find a provider']")
	private WebElement findProviderTxt;
	
	
	
	//Announcements
	@FindBy(xpath = "//a[@href='https://medicaidprovider.mt.gov/']")
	private WebElement clkOnAnnouncements;
	
	//Announcements Assertion
	//@FindBy(xpath = "//a[normalize-space()='MONTANA DPHHS']")
	//private WebElement announcementsTxt;
	
	
	//DPHHS Website
	@FindBy(xpath = "//a[@href='https://dphhs.mt.gov/']")
	private WebElement clkOnDPHHSWebsite;
	
	//DocDNA
	@FindBy(xpath = "//a[@href='https://dna1.documentdna.com/optummt']")
	private WebElement clkOnDocDNA;
	
	
	
	public void clkOnHome()  {
		commonMethod.clickOnElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnHome);
		log.info("Clicked on Home Page");
		// Applying Assertion
		String expText = "Home";
		Assert.assertEquals(commonMethod.getText(clkOnHome, Constants.EXPLICIT_WAIT_TIME), expText);
		//Thread.sleep(3000);
				
	}
	
	public void clkOnContactUs()  {
		
		commonMethod.clickOnElement(clkOnContactUs, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnContactUs);
		log.info("Clicked on Contact US Page");
		
		// Applying Assertion
		String expText = "Contact us";
		Assert.assertEquals(commonMethod.getText(clkOnContactUs, Constants.EXPLICIT_WAIT_TIME), expText);
		commonMethod.highLightElementMethod(clkOnHome);
		commonMethod.clickOnElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
		
				
	}
	
	public void clkOnGettingStarted() {
		commonMethod.highLightElementMethod(clkOnGettingStarted);
		commonMethod.clickOnElement(clkOnGettingStarted, Constants.EXPLICIT_WAIT_TIME);
		
		log.info("Clicked on Getting Started Page");

		// Applying Assertion
		//String expText = "Welcome to the Montana Provider Portal";
		//Assert.assertEquals(commonMethod.getText(gettingStartedTxt, Constants.EXPLICIT_WAIT_TIME), expText);
		commonMethod.highLightElementMethod(clkOnHome);
		commonMethod.clickOnElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
				
	}
	
	public void clkOnFAQs() {
		commonMethod.clickOnElement(clkOnFAQs, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnFAQs);
		
		log.info("Clicked on FAQs Page");
		commonMethod.switchToNewWindow();
		
				
	}
	
	
	public void clkOnFindProvider() throws InterruptedException  {
		commonMethod.clickOnElement(clkOnFindProvider, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnFindProvider);
		log.info("Clicked on Find Provider Page");
		// Applying Assertion
		//String expText = "Find a provider";
		//Assert.assertEquals(commonMethod.getText(findProviderTxt, Constants.EXPLICIT_WAIT_TIME), expText);
		commonMethod.highLightElementMethod(clkOnHome);
		commonMethod.clickOnElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
		
				
	}
	
	public void clkOnAnnouncements() throws InterruptedException {
		commonMethod.clickOnElement(clkOnAnnouncements, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.highLightElementMethod(clkOnAnnouncements);
		log.info("Clicked on Announcements Page");
		
		// Applying Assertion
		//String expText = "MONTANA DPHHS";
		//String actText = driver.findElement(By.xpath("announcementsTxt")).getText();
		//String actText =announcementsTxt.getText();
		//Assert.assertEquals(actText, expText);
		//Assert.assertEquals(commonMethod.getText(announcementsTxt, Constants.EXPLICIT_WAIT_TIME), expText);
		//Thread.sleep(5000);
		
		commonMethod.switchToNewWindow();

		
				
	}
	
	public void clkOnDPHHSWebsite(){
		commonMethod.clickOnElement(clkOnDPHHSWebsite, Constants.EXPLICIT_WAIT_TIME);
		log.info("Clicked on DPHHS Website Page");

		// Applying Assertion
		//String expText = "Contact us";
		//Assert.assertEquals(commonMethod.getText(clkOnContactUs, Constants.EXPLICIT_WAIT_TIME), expText);
		//commonMethod.clickonElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.switchToNewWindow();

		
				
	}
	
	public void clkOnDocDNA()   {
		commonMethod.clickOnElement(clkOnDocDNA, Constants.EXPLICIT_WAIT_TIME);
		log.info("Clicked on DocDNA Page");
		// Applying Assertion
		//String expText = "Contact us";
		//Assert.assertEquals(commonMethod.getText(clkOnContactUs, Constants.EXPLICIT_WAIT_TIME), expText);
		//commonMethod.clickonElement(clkOnHome, Constants.EXPLICIT_WAIT_TIME);
		commonMethod.switchToNewWindow();

		
				
	}


		
	
	

}
