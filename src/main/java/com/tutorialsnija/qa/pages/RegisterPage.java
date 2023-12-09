package com.tutorialsnija.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
WebDriver driver;
	
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNumber;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;
	
	@FindBy(name="agree")
	private WebElement privacyagreeOption;
	
	@FindBy(xpath="//input[@value = 'Continue']")
	private WebElement continueOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetter;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
		
	
	public	RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Actions
	
	public void enterFirstName(String firstNameText) {
		
		firstName.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		lastName.sendKeys(lastNameText);
		
	}
	
	public void enterEmail(String emailText) {
		
		email.sendKeys(emailText);
		
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
		telephoneNumber.sendKeys(telephoneText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		password.sendKeys(passwordText);
		
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		
		confirmpassword.sendKeys(confirmPasswordText);
		
	}
	
	public void clickOnPrivacyagreeOption() {
		
		privacyagreeOption.click();
		
	}
	
	
	public void clickOnContinueOption() {
		
		continueOption.click();
		
	}


	
	public void clickonYesNewsLetter() {
		
		 yesNewsLetter.click();
		
	}

	public String getDuplicateEmailWarning() {
		
		return duplicateEmailWarning.getText();
		
	}
	
	public String getPrivacyPolicyWarning() {
		
		return privacyPolicyWarning.getText();
		
	}
	
	public String getFirstNameWarning() {
		
		return firstNameWarning.getText();
		
	}
	
	public String getLastNameWarning() {
		
		return lastNameWarning.getText();
		
	}
	
	public String getEmailWarning() {
		
		return emailWarning.getText();
		
	}
	
	public String getTelephoneWarning() {
		
		return telephoneWarning.getText();
		
	}
	
	public String getPasswordWarning() {
		
		return passwordWarning.getText();
		
	}
	
	public AccountSuccessPage registerwithMandatoryFelids(String firstNameText,String lastNameText ,String emailText,String telephoneText, String passwordText, String confirmPasswordText) {
		
			
			firstName.sendKeys(firstNameText);
			lastName.sendKeys(lastNameText);
			email.sendKeys(emailText);
			telephoneNumber.sendKeys(telephoneText);
			password.sendKeys(passwordText);
			confirmpassword.sendKeys(confirmPasswordText);
			privacyagreeOption.click();
			continueOption.click();
			return new AccountSuccessPage(driver);
			
		
	}
	
	public AccountSuccessPage registerwithAllMandatoryFelids(String firstNameText,String lastNameText ,String emailText,String telephoneText, String passwordText, String confirmPasswordText) {
		
		
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		email.sendKeys(emailText);
		telephoneNumber.sendKeys(telephoneText);
		password.sendKeys(passwordText);
		confirmpassword.sendKeys(confirmPasswordText);
		yesNewsLetter.click();
		privacyagreeOption.click();
		continueOption.click();
		return new AccountSuccessPage(driver);
		
	
	}
	
	public boolean displyStatusOfWarningMessage(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning ) {

		boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarning.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarning.getText().contains(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarning.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarning.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarning.getText().contains(expectedPasswordWarning);
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
		
		
	}
	
	
	



}
