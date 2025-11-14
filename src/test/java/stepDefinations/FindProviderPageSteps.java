package stepDefinations;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindProviderPage;

public class FindProviderPageSteps  extends BaseClass {
	
	
	FindProviderPage fp = new FindProviderPage();
	
	@When("User Click On Find A Provider Hyperlink")
	public void user_click_on_find_a_provider_hyperlink() throws InterruptedException {
		fp.clkOnFindProvider();
	    
	}

	@Then("User select {string} from Filter by Category dropdown")
	public void user_select_category_from_filter_by_category_dropdown(String Category) throws InterruptedException {
		fp.selectCategory(Category);
	}
	
	
	@Then("User select {string} from Filter by Specialty dropdown")
	public void user_select_specialty_from_filter_by_specialty_dropdown(String Specialty) throws InterruptedException {
		fp.selectSpecialty(Specialty);
	}

	@Then("User enter {string}")
	public void user_enter_city(String City) throws InterruptedException {
		fp.city(City);
	}

	@Then("Click On Find providers")
	public void click_on_find_providers() throws InterruptedException {
		fp.clkOnFindProviders();
	}

}
