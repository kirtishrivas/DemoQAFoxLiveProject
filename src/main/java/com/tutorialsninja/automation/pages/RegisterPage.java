package com.tutorialsninja.automation.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tutorialsninja.automation.framework.Elements;
import io.cucumber.datatable.DataTable;

public class RegisterPage {

	// Keep a local copy of the driver to initialize elements on-the-fly if needed
	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	public WebElement firstName;

	@FindBy(id = "input-lastname")
	public WebElement lastName;

	@FindBy(id = "input-email")
	public WebElement email;

	@FindBy(id = "input-telephone")
	public WebElement telephone;

	@FindBy(id = "input-password")
	public WebElement password;

	@FindBy(id = "input-confirm")
	public WebElement confirmPassword;

	@FindBy(name = "agree")
	public WebElement privacyPolicy;

	@FindBy(css = "input.btn.btn-primary")
	public WebElement continueButton;

	public void enterAllDetails(DataTable dataTable) {
		// Re-ensure elements are bound to the current driver state right before typing
		PageFactory.initElements(this.driver, this);
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		// Map keys handling both lower-case and capital letters automatically
		String fName = map.get("firstName") != null ? map.get("firstName") : map.get("FirstName");
		String lName = map.get("lastName") != null ? map.get("lastName") : map.get("LastName");
		String mail = map.get("email") != null ? map.get("email") : map.get("Email");
		String phone = map.get("telephone") != null ? map.get("telephone") : map.get("Telephone");
		String pass = map.get("password") != null ? map.get("password") : map.get("Password");

		Elements.TypeText(firstName, fName);
		Elements.TypeText(lastName, lName);
		Elements.TypeText(email, mail);
		Elements.TypeText(telephone, phone);
		Elements.TypeText(password, pass);
		Elements.TypeText(confirmPassword, pass);
	}
	public void clickContinue() {
		PageFactory.initElements(this.driver, this);
		continueButton.click();
	}
	

	// 👇 PASTE THESE MISSING DECLARATIONS HERE 👇
	@FindBy(css = ".alert-danger")
	public WebElement mainPrivacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	public WebElement firstNameError;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	public WebElement lastNameError;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	public WebElement emailError;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	public WebElement telephoneError;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	public WebElement passwordError;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	public WebElement newsletterYesRadio;

	public boolean isMainWarningDisplayed() {
		return mainPrivacyPolicyWarning.isDisplayed();
	}

	public String getFirstNameErrorText() { 
		return firstNameError.getText(); 
	}
	
	public String getLastNameErrorText() { 
		return lastNameError.getText(); 
	}
	
	public String getEmailErrorText() { 
		return emailError.getText(); 
	}
	
	public String getTelephoneErrorText() { 
		return telephoneError.getText(); 
	}
	
	public String getPasswordErrorText() { 
		return passwordError.getText(); 
	}
	
	public void subscribeToNewsletter() {
		Elements.click(newsletterYesRadio);
	}
	// This method will read the red alert banner text at the top of the registration page
	public String getMainWarningText() {
			return mainPrivacyPolicyWarning.getText();
		}
}
