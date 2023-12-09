package com.tutorialsnija.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	
	//Objects
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement myAccountDropMeny;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchValue;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchOption;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Actions
	
	public void clickOnMyAccountDropMenu() {
		
		myAccountDropMeny.click();
		
	}
	
	public LoginPage selectLoginOption() {
		
		loginOption.click();
		return new LoginPage(driver);
		
	}

	
	public LoginPage naviagteToLoginPage() {
		
		myAccountDropMeny.click();
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisterOption() {
		
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	

	public RegisterPage naviagteToRegisterPage() {
		
		myAccountDropMeny.click();
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterSerachValue(String searchvalue) {
		
		searchValue.sendKeys(searchvalue);
		
	}
	
	public SearchPage clickOnSerachOption() {
		
		searchOption.click();
		return new SearchPage(driver);
		
	}
	
	public SearchPage SearchForAProduct(String searchvalue) {
		searchValue.sendKeys(searchvalue);
		searchOption.click();
		return new SearchPage(driver);
		
	}
	
	
	
	
	
}
