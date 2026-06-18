package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// 1. Tell Selenium how to find the input fields and button
	@FindBy(id = "input-email")
	public WebElement emailField;
	
	@FindBy(id = "input-password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;
	
	// 2. Constructor to initialize the elements using PageFactory
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "div.alert-danger")
	public WebElement mainWarningAlert;
	
	@FindBy(linkText = "Forgotten Password")
	public WebElement forgottenPasswordLink;
	
	// Locates the green success banner that appears after requesting a reset link
	@FindBy(css = "div.alert-success")
	public WebElement successAlertBanner;
	
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButton;
}
