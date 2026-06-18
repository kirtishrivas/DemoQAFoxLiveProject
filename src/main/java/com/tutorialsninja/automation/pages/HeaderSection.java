package com.tutorialsninja.automation.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {
    
	
    // 1. Tell Selenium how to find the "My Account" link
    @FindBy(xpath = "//span[text()='My Account']")
    public  WebElement myaccountlink;
    
    // 2. Tell Selenium how to find the "Register" link
    @FindBy(linkText = "Register")
    public WebElement register;
    
 // 👇 3. New: Tell Selenium how to find the "Login" link inside the dropdown
    @FindBy(linkText = "Login")
    public WebElement login;
    
    @FindBy(name = "search")
	public WebElement searchBox;
	
	@FindBy(css = "button.btn-default.btn-lg")
	public WebElement searchButton;
	
	@FindBy(linkText = "Checkout")
	public WebElement checkoutLink;
	
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountLink;

	@FindBy(linkText = "Login")
	public WebElement loginLink;
    
    // 3. Create a constructor to initialize these elements using PageFactory
    public HeaderSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	
}
