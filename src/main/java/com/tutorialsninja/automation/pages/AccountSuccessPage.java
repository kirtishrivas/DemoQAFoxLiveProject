package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	private WebDriver driver;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Success']")
	public WebElement successBreadcrumb;
	
	// Helper method to ensure the element refreshes its state right before the assertion check
	public boolean isSuccessDisplayed() {
		PageFactory.initElements(this.driver, this);
		return successBreadcrumb.isDisplayed();
	}
}