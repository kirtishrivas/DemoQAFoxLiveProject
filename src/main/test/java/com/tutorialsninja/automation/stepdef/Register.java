package com.tutorialsninja.automation.stepdef;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.RegisterPage;



public class Register {
	
	HeaderSection headersection = new HeaderSection();
	RegisterPage registerpage = new RegisterPage();
	AccountSuccessPage accountsuccesspage = new AccountSuccessPage();
	
	@Given("I launch the application")
	public void i_launch_the_application() {
	   Base.driver.get(Base.reader.getUrl());
	    
	}

	@And("I navigate to Account Registration page")
	public void i_navigate_to_account_registration_page() {
	    
	    Elements.click(HeaderSection.myaccountlink);
	    Elements.click(HeaderSection.register);
	}

	@When("I provide all the below valid details")
	public void i_provide_all_the_below_valid_details(io.cucumber.datatable.DataTable dataTable) {
	    
	    RegisterPage.enterAllDetails(dataTable);
	}

	@And("I select the Privacy Policy")
	public void i_select_the_privacy_policy() {
	    Elements.click(RegisterPage.privacyPolicy);
	    
	}

	@And("I click on Continue button")
	public void i_click_on_continue_button() {
	    
	    Elements.click(RegisterPage.continueButton);
	}

	@Then("I should see that the User Account has successfully created")
	public void i_should_see_that_the_user_account_has_successfully_created() {
	    Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadcrumb));
	    
	    
	}


}
