package com.tutorialsnija.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
WebDriver driver;
	
	
	//Objects
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordFeild;
	
	@FindBy(xpath="//input[@value = 'Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public	LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Actions
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
		
	}
	
	public void enterPassword(String password) {
		
		passwordFeild.sendKeys(password);
		
	}
	
	
	public AccountPage Login(String emailText, String password) {
		emailAddressField.sendKeys(emailText);
		passwordFeild.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage clickonLoginButton() {
		
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String retriveEmailPasswordNotMatchingWarningText() {
		
		return emailPasswordNotMatchingWarning.getText();
		
	}
	
	
	

}
