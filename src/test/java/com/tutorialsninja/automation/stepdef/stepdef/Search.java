package com.tutorialsninja.automation.stepdef.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.SearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.tutorialsninja.automation.base.Base;

public class Search {

	HeaderSection headerSection = new HeaderSection(Base.driver);
	SearchPage searchPage = new SearchPage(Base.driver);

	@When("I search for a product {string}")
	public void i_search_for_a_product(String productName) throws InterruptedException {
		// 1. Type the product name into the search box in the header
		Elements.TypeText(headerSection.searchBox, productName);
		Thread.sleep(2000);
		
		// 2. Click the search magnifying glass button
		Elements.click(headerSection.searchButton);
		Thread.sleep(2000);
	}

	@Then("I should see the product in the search results")
	public void i_should_see_the_product_in_the_search_results() throws InterruptedException {
		// 3. Verify the product link is visible on the results page
		Assert.assertTrue(searchPage.searchedProduct.isDisplayed());
		Thread.sleep(2000);
	}
	
	@Then("I should see a warning message stating {string}")
	public void i_should_see_a_warning_message_stating(String expectedWarningText) throws InterruptedException {
		// 1. Verify the warning text element is visible on the screen
		Assert.assertTrue(searchPage.noProductWarningMessage.isDisplayed());
		
		// 2. Extract the actual text and assert it matches our expected message
		String actualWarningText = searchPage.noProductWarningMessage.getText();
		Assert.assertEquals(actualWarningText, expectedWarningText);
		
		// 3. Pause for 3 seconds so you can visually verify the message on screen!
		Thread.sleep(3000);
	}
}
