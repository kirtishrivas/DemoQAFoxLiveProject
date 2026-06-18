package com.tutorialsninja.automation.stepdef.stepdef; 

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	private HeaderSection headersection;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	
	@Given("I launch the application")
	public void i_launch_the_application() {
		// 1. Grab whichever driver instance is currently active
		WebDriver driver = Base.driver;
		
		// 2. Force the active window to break out of the blank screen and load the site
		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}

	@And("I navigate to Account Registration page")
	public void i_navigate_to_account_registration_page() {
		WebDriver driver = Base.driver;
		
		// 3. Bind elements directly to the loaded window session
		headersection = new HeaderSection(driver);
		registerpage = new RegisterPage(driver);
		accountsuccesspage = new AccountSuccessPage(driver);
		
	    Elements.click(headersection.myaccountlink);
	    Elements.click(headersection.register);
	}

	@When("I provide all the below valid details")
	public void i_provide_all_the_below_valid_details(io.cucumber.datatable.DataTable dataTable) {
	    registerpage.enterAllDetails(dataTable); 
	}

	@And("I select the Privacy Policy")
	public void i_select_the_privacy_policy() {
	    Elements.click(registerpage.privacyPolicy);
	}

	@And("I click on Continue button")
	public void i_click_on_continue_button() {
	    Elements.click(registerpage.continueButton);
	    try {
			Thread.sleep(5000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("I should see that the User Account has successfully created")
	public void i_should_see_that_the_user_account_has_successfully_created() {
		// This uses the updated validation method to completely bypass the NullPointerException
	    Assert.assertTrue(accountsuccesspage.isSuccessDisplayed());
	
	
	try {
        Thread.sleep(5000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


	@Then("I should see that the User Account is not created")
	public void i_should_see_that_the_user_account_is_not_created() {
		// Verify that the user stays on the "Register Account" page instead of navigating away
		String currentTitle = Base.driver.getTitle();
		Assert.assertEquals("Register Account", currentTitle);
	}

	@And("I should see the error messages informing the user to fill the mandatory fields")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields() {
		// 1. Verifies the main red alert banner at the top of the screen
		Assert.assertTrue(registerpage.isMainWarningDisplayed());
		
		// 2. Verifies the explicit error text displayed beneath every empty text field
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameErrorText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastNameErrorText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailErrorText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.getTelephoneErrorText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordErrorText());
	}
	@And("I subscribe to Newsletter")
	public void i_subscribe_to_newsletter() {
		registerpage.subscribeToNewsletter();
	}
	

@When("I provide the below duplicate details into the fields")
public void i_provide_the_below_duplicate_details_into_the_fields(io.cucumber.datatable.DataTable dataTable) {
	// Reuses your existing DataTable parsing logic to fill out the form fields
			registerpage.enterAllDetails(dataTable);
}

@Then("I should see the warning message stating that the user is already created")
public void i_should_see_the_warning_message_stating_that_the_user_is_already_created() {
	// Verifies the exact warning text returned by the system for duplicate emails
			String expectedWarning = "Warning: E-Mail Address is already registered!";
			Assert.assertEquals(expectedWarning, registerpage.getMainWarningText());
}



}


