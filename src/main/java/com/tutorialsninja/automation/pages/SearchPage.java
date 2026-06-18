package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Locates the product text link inside the search results view grid
	@FindBy(linkText = "Samsung SyncMaster 941BW")
	public WebElement searchedProduct;
	
	// Locates the paragraph text that appears when no products are found
		@FindBy(xpath = "//p[contains(text(),'There is no product')]")
		public WebElement noProductWarningMessage;
		
		@FindBy(xpath = "//span[text()='Add to Cart']")
		public WebElement addToCartButton;
}