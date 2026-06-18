package com.tutorialsninja.automation.stepdef.stepdef;

import org.junit.Assert;
import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	private HeaderSection headerSection;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;

	@Given("I navigate to Login page")
	public void i_navigate_to_login_page() {
		// Initialize the page objects using the active driver instance
		headerSection = new HeaderSection(Base.driver);
		loginPage = new LoginPage(Base.driver);
		myAccountPage = new MyAccountPage(Base.driver);
		
		// Navigate through the header menu
		Elements.click(headerSection.myaccountlink);
		Elements.click(headerSection.login); 
	}

	@When("I enter valid email address {string}")
	public void i_enter_valid_email_address(String email) throws InterruptedException {
		Elements.TypeText(loginPage.emailField, email);
		Thread.sleep(2000);
	}

	@When("I enter valid password {string}")
	public void i_enter_valid_password(String password) throws InterruptedException {
		Elements.TypeText(loginPage.passwordField, password);
		Thread.sleep(2000);
	}

	@When("I click on Login button")
	public void i_click_on_login_button() throws InterruptedException {
		Elements.click(loginPage.loginButton);
		Thread.sleep(2000);
	}

	@Then("I should see that the user is successfully logged in")
	public void i_should_see_that_the_user_is_successfully_logged_in() {
		// Validates that the "My Account" header dashboard element is present
		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
	}
	@When("I login to the application using Username {string} and Password {string}")
	public void i_login_to_the_application_using_username_and_password(String username, String password) {
		Elements.TypeText(loginPage.emailField, username);
		Elements.TypeText(loginPage.passwordField, password);
		Elements.click(loginPage.loginButton);
	}

	@Then("I should see an error message informing the User about invalid credentials")
	public void i_should_see_an_error_message_informing_the_user_about_invalid_credentials() throws InterruptedException {
		// Validates that the warning alert banner is displayed on top of the login panel
		Assert.assertTrue(loginPage.mainWarningAlert.isDisplayed());
		
		// Optional extra credit: verify the exact text matches!
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarning = loginPage.mainWarningAlert.getText();
		Assert.assertEquals(actualWarning, expectedWarning);
		Thread.sleep(3000);
	}
	@When("I reset the forgotten password for {string}")
	public void i_reset_the_forgotten_password_for(String email) throws InterruptedException {
		Elements.click(loginPage.forgottenPasswordLink);
		
		// The application takes us to the Forgot Password page where we reuse emailField
		Elements.TypeText(loginPage.emailField, email);
		
		// Reuses the blue button element to submit the form
		Elements.click(loginPage.continueButton);
		Thread.sleep(2000); // Optional pause to watch the transition
	}

	@Then("I should see a message informing that the password reset details have been sent to the email address")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address() throws InterruptedException {
		// Validates that the green success message banner is displayed
		Assert.assertTrue(loginPage.successAlertBanner.isDisplayed());
		
		// Verifies the exact confirmation text matches
		String expectedSuccessMessage = "An email with a confirmation link has been sent your email address.";
		String actualSuccessMessage = loginPage.successAlertBanner.getText();
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		
		Thread.sleep(3000); // Hold for 3 seconds so you can visually verify
	}
}