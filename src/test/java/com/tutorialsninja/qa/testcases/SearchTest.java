package com.tutorialsninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.tutorials.qa.base.Base;
import com.tutorialsnija.qa.pages.HomePage;
import com.tutorialsnija.qa.pages.SearchPage;

//updateComment

public class SearchTest extends Base{
	
	SearchPage searchPage;
	HomePage homepage;
	
	public SearchTest(){
		super();
	}
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homepage = new HomePage(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
		
	}
	
	
	
	@Test(priority =1)
	public void VerifySearchWithValidProduct() {
		searchPage= homepage.SearchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.isPresentSerachValue(), "Valid product HP is not Displayed");	
		
	}
	
	@Test(priority =2)
	public void VerifySearchWithInvalidProduct() {
		searchPage= homepage.SearchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(searchPage.getProductCriteriaNotMetWarning(),"abcd", "Product not found");	
		
	}
	
	
	@Test(priority =3, dependsOnMethods= {"VerifySearchWithInvalidProduct"})
	public void VerifySearchWithEmptyProduct() {
		
		searchPage = homepage.clickOnSerachOption();
		Assert.assertEquals(searchPage.getProductCriteriaNotMetWarning(),dataProp.getProperty("noProductTextInSerach"), "Product not found");	
		
	}

}
