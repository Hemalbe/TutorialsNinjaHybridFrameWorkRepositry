package com.tutorialsninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.tutorials.qa.base.Base;
import com.tutorialsnija.qa.pages.AccountSuccessPage;
import com.tutorialsnija.qa.pages.HomePage;
import com.tutorialsnija.qa.pages.RegisterPage;
import com.tutorialsnija.qa.utlis.Utilities;

public class RegisterTest extends Base{
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		super();
	}
	
	
	public WebDriver driver;
	
		@BeforeMethod
	public void setUP() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		registerPage= homepage.naviagteToRegisterPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
		
	}
	
		@Test(priority =1)
		public void verifyRegistringAccountWithMandatoryFields() {
			
			accountSuccessPage= registerPage.registerwithMandatoryFelids(dataProp.getProperty("firstName"), dataProp.getProperty("LastName"),Utilities.genrateEmailWithTimeStamp(), dataProp.getProperty("phoneNumber"), prop.getProperty("password"), prop.getProperty("password"));
			Assert.assertEquals(accountSuccessPage.getsuccessHeadingMessage(), dataProp.getProperty("accountSuccesfullyCreated"), "Account Success page is not Displayed");
			driver.quit();
			
	}
		
		
		
		@Test(priority =2)
		public void verifyRegistringAccountByProvidingAllFields() {

			accountSuccessPage= registerPage.registerwithAllMandatoryFelids(dataProp.getProperty("firstName"), dataProp.getProperty("LastName"),Utilities.genrateEmailWithTimeStamp(), dataProp.getProperty("phoneNumber"), prop.getProperty("password"), prop.getProperty("password"));
			Assert.assertEquals(accountSuccessPage.getsuccessHeadingMessage(), dataProp.getProperty("accountSuccesfullyCreated"), "Account Success page is not Displayed");
			driver.quit();
			
			
			

	}
		
		@Test(priority =3)
		public void verifyRegistringAccountByProvidingSameEmailId() {
			
			accountSuccessPage= registerPage.registerwithMandatoryFelids(dataProp.getProperty("firstName"), dataProp.getProperty("LastName"),prop.getProperty("username"), dataProp.getProperty("phoneNumber"), prop.getProperty("password"), prop.getProperty("password"));
			Assert.assertTrue(registerPage.getDuplicateEmailWarning().contains(dataProp.getProperty("duplicateEmailWarning")), "Account is not cretaed");
			driver.quit();
			
			
			

	}
		
		@Test(priority =4)
		public void verifyRegistringAccountByNotProvidinganyMandatoryFeilds() {
			
			registerPage.clickOnContinueOption();
			
			Assert.assertTrue(registerPage.displyStatusOfWarningMessage(dataProp.getProperty("expectedPrivacyPolicyWarning"), dataProp.getProperty("expectedFirstNameWarning"), dataProp.getProperty("expectedLastNameWarning"), dataProp.getProperty("expectedEmailWarning"), dataProp.getProperty("expectedTelephoneWarning"), dataProp.getProperty("expectedPasswordWarning")), "Waring message's or bot displayed");
			driver.quit();
			
			
			

	}
		

}
