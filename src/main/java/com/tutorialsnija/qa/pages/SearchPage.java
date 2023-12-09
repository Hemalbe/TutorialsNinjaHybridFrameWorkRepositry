package com.tutorialsnija.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(linkText="HP LP3065")
	private WebElement serachValue;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement productCriteriaNotMetWarning;
	

	

	
	public	SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Actions
	
	public boolean isPresentSerachValue() {
		
		return serachValue.isDisplayed();
		
	}
	
	public  String getProductCriteriaNotMetWarning() {
		
		return productCriteriaNotMetWarning.getText();
		
	}

}
