package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// This element confirms the user successfully logged in and hit the dashboard area
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Account']")
	public WebElement accountBreadcrumb;
	
	public boolean isMyAccountPageDisplayed() {
		PageFactory.initElements(this.driver, this);
		return accountBreadcrumb.isDisplayed();
	}
}
