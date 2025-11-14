package stepDefinations;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HopePageSteps extends BaseClass{
	
	HomePage hp = new HomePage();
	
	@Given("User should be on Montana Provider Portal Page")
	public void user_should_be_on_montana_provider_portal_page() {
		
	    
	}

	@When("Click On Home Hyperlink")
	public void click_on_home_hyperlink() {
		hp.clkOnHome();
	    
	}

	@Then("Click On Contact Us Hyperlink")
	public void click_on_contact_us_hyperlink()  {
		hp.clkOnContactUs();
	    
	}

	@Then("Click On Getting Started Hyperlink")
	public void click_on_getting_started_hyperlink()  {
	    hp.clkOnGettingStarted();
	}

	@Then("Click On FAQs Hyperlink")
	public void click_on_fa_qs_hyperlink()  {
		hp.clkOnFAQs();
	    
	}

	@Then("Click On Find A Provider Hyperlink")
	public void click_on_find_a_provider_hyperlink() throws InterruptedException  {
		hp.clkOnFindProvider();
	    
	}

	@Then("Click On Announcements Hyperlink")
	public void click_on_announcements_hyperlink() throws InterruptedException  {
		hp.clkOnAnnouncements();
	    
	}

	@Then("Click On DPHHS Website Hyperlink")
	public void click_on_dphhs_website_hyperlink()  {
		hp.clkOnDPHHSWebsite();
	   
	}

	@Then("Click On DocDNA Hyperlink")
	public void click_on_doc_dna_hyperlink()  {
		hp.clkOnDocDNA();
	    
	}

}
