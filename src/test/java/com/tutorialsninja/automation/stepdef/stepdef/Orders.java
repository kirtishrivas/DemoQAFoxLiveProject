package com.tutorialsninja.automation.stepdef.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.SearchPage;
import com.tutorialsninja.automation.pages.OrdersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class Orders {

	HeaderSection headerSection;
	LoginPage loginPage;
	SearchPage searchPage;
	OrdersPage ordersPage;

	@Given("I login to the application")
	public void i_login_to_the_application() throws InterruptedException {
		headerSection = new HeaderSection(Base.driver);
		loginPage = new LoginPage(Base.driver);
		
		Elements.click(headerSection.myAccountLink);
		Elements.click(headerSection.loginLink);
		
		// Using the exact capital 'TypeText' from your Elements class
		Elements.TypeText(loginPage.emailField, Base.reader.getUsername());
		Elements.TypeText(loginPage.passwordField, Base.reader.getPassword());
		Elements.click(loginPage.loginButton);
		Thread.sleep(1500);
	}

	@When("I add any product to Bag and checkout")
	public void i_add_any_product_to_bag_and_checkout() throws InterruptedException {
		searchPage = new SearchPage(Base.driver);
		headerSection = new HeaderSection(Base.driver);
		
		// 🌟 Note: If 'searchField' still has an error, change it to headerSection.searchBox 
		Elements.TypeText(headerSection.searchBox, "MacBook");
		Elements.click(headerSection.searchButton);
		Thread.sleep(1500);
		
		Elements.click(searchPage.addToCartButton);
		Thread.sleep(3000); // Wait for the AJAX addition to settle
		
		Elements.click(headerSection.checkoutLink);
	}

	@And("I place an order")
	public void i_place_an_order() throws InterruptedException {
	    Thread.sleep(3000); 
	    ordersPage = new OrdersPage(Base.driver);
	    
	    // 🌟 ADD THIS STEP: Click the Continue button on the Billing Details section first!
	    Elements.click(ordersPage.continueBillingAddressButton); 
	    Thread.sleep(2000); // Give the accordion time to slide open
	    
	    // Now the Shipping Address section is visible, and this click will work perfectly!
	    Elements.click(ordersPage.continueShippingAddressButton);
	    Thread.sleep(2000); 
	    
	    Elements.click(ordersPage.continueShippingMethodButton);
	    Thread.sleep(2000);
	    
	    Elements.click(ordersPage.termsCheckbox);
	    Elements.click(ordersPage.continuePaymentMethodButton);
	    Thread.sleep(2000);
	    
	    Elements.click(ordersPage.confirmOrderButton);
	    Thread.sleep(4000);
	}
	

	@Then("I should see that the order is placed successfully")
	public void i_should_see_that_the_order_is_placed_successfully() {
		boolean isSuccessDisplayed = Base.driver.getTitle().contains("Success") || Base.driver.getPageSource().contains("Your Order Has Been Processed!");
		Assert.assertTrue("Order placement confirmation failed!", isSuccessDisplayed);
	}
}