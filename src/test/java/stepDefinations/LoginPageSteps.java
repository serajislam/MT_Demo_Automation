package stepDefinations;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps extends BaseClass{
	
	
	LoginPage lp = new LoginPage();
	
	@When("User Click On Provider")
	public void user_click_on_provider() throws InterruptedException {
		lp.clkOnProvider();
	    
	}

	@Then("User Click On Login and Registration")
	public void user_click_on_login_and_registration() {
		lp.clkOnLogin();
	    
	}

	@Then("User enter {string} & {string}")
	public void user_enter_optum_gov_id_or_email_address(String OptumGovID, String Password) throws InterruptedException {
		lp.optumGovIdPwd(OptumGovID, Password);
	    
	}

	@Then("User Click On Continue")
	public void user_click_on_continue() {
		lp.conAftUserIdPWD();
	    
	}

	@Then("User Click On Via Text Message on Verify Your Identity page")
	public void user_click_on_via_text_message_on_verify_your_identity_page() {
		lp.clkOnTextMsg();
	    
	}

	@Then("User enter Access Code {string}")
	public void user_enter_access_code(String AccessCode) {
		lp.enterOTP(AccessCode);
		lp.conAftOTP();
	    
	}

	@Then("User Click On Logout")
	public void user_click_on_logout() {
	   
	}

}
