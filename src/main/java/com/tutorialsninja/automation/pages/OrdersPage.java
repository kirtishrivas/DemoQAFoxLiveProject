package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	public OrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='button-shipping-address']")
	public WebElement continueShippingAddressButton;

	@FindBy(xpath = "//button[@id='button-shipping-method']")
	public WebElement continueShippingMethodButton;

	@FindBy(name = "agree")
	public WebElement termsCheckbox;

	@FindBy(xpath = "//button[@id='button-payment-method']")
	public WebElement continuePaymentMethodButton;

	@FindBy(id = "button-confirm")
	public WebElement confirmOrderButton;

	@FindBy(xpath = "//h1[text()='Your Order Has Been Processed!']")
	public WebElement successOrderHeader;
}
