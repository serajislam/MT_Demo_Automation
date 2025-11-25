package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import utils.CommonMethod;
import utils.Constants;

public class LoginPage extends BaseClass{
	
	private CommonMethod commonMethod;
	public LoginPage() {
		super();

		WebDriver driver = getDriver();
		//PageFactory.initElements(BaseClass.webDriver.get(), this);
		PageFactory.initElements(driver, this);
		commonMethod = new CommonMethod(driver);
		
	}
	
	// click on provider
	@FindBy(xpath = "//button[text()='Provider']")
	private WebElement clkOnProvider;
	
	
	// click on Login and Registration
	@FindBy(xpath = "//button[text()='Login and Registration']")
	private WebElement clkOnLogin;
	
	//button[text()='Login and Registration']
	//button[@id='extLink_n747805711']
	
	//Optum GovID field
	@FindBy(xpath = "//input[@id='username']")
	private WebElement enterUserID;
	
	//Password field
	@FindBy(xpath = "//input[@id='login-pwd']")
	private WebElement enterUserPWD;
	
	//Continue after entering userid & pwd
	@FindBy(xpath = "//button[@id='btnLogin']")
	private WebElement conAftUserIdPWD;
	
	//click on Text message
	@FindBy(xpath = "//button[@id='textMsg']")
	private WebElement clkOnTextMsg;
	
	//enter OTP
	@FindBy(xpath = "//input[@id='otpBox']")
	private WebElement enterOTP;
	
	//Continue after OTP
	@FindBy(xpath = "//button[@id='continuebtn']")
	private WebElement conAftOTP;
	
	//assertion
	@FindBy(xpath = "//span[normalize-space()='Account Settings']")
	private WebElement accSet;
	
	//Logout
	@FindBy(xpath = "//span[normalize-space()='Log Out']")
	private WebElement logout;
	
	
	
	public void clkOnProvider() {
		
		commonMethod.highLightElementMethod(clkOnProvider);
		commonMethod.clickOnElement(clkOnProvider, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Provider Page");
		
	}
	
	
	public void clkOnLogin() {
		
		commonMethod.highLightElementMethod(clkOnLogin);
		commonMethod.clickOnElement(clkOnLogin, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Login & Registration Page");
		
	}
	
	
	public void optumGovIdPwd(String OptumGovID, String Password) throws InterruptedException {
		commonMethod.highLightElementMethod(enterUserID);
		commonMethod.sendKey(enterUserID, OptumGovID, Constants.IMPLICIT_WAIT_TIME);
		log.info("Endeted User Id");
		
		commonMethod.highLightElementMethod(enterUserPWD);
		commonMethod.sendKey(enterUserPWD, Password, Constants.IMPLICIT_WAIT_TIME);
		log.info("Endeted Password");
		Thread.sleep(3000);
		
		
		
	}
	
	public void conAftUserIdPWD() {
		commonMethod.highLightElementMethod(conAftUserIdPWD);
		commonMethod.clickOnElement(conAftUserIdPWD, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Continue");
		
		
	}
	
	public void clkOnTextMsg() {
		commonMethod.highLightElementMethod(clkOnTextMsg);
		commonMethod.clickOnElement(clkOnTextMsg, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Via Text msg");
		
	}
	
	public void enterOTP(String AccessCode) {
		commonMethod.highLightElementMethod(enterOTP);
		commonMethod.sendKey(enterOTP,AccessCode, Constants.IMPLICIT_WAIT_TIME);
		log.info("Entered OTP");
		
	}
	
	
	public void conAftOTP() {
		commonMethod.highLightElementMethod(conAftOTP);
		commonMethod.clickOnElement(conAftOTP, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Continue after OTP");
		
	}
	
	public void logout() {
		commonMethod.highLightElementMethod(logout);
		commonMethod.clickOnElement(logout, Constants.IMPLICIT_WAIT_TIME);
		log.info("Clicked on Logout");
		
	}
	
	
	

}
