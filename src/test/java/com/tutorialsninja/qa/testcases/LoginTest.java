package com.tutorialsninja.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.tutorials.qa.base.Base;
import com.tutorialsnija.qa.pages.AccountPage;
import com.tutorialsnija.qa.pages.HomePage;
import com.tutorialsnija.qa.pages.LoginPage;
import com.tutorialsnija.qa.utlis.Utilities;

public class LoginTest extends Base{
	
	LoginPage loginPage;
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		loginPage=homepage.naviagteToLoginPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
		
	}
	
	
	@Test(priority =1,dataProvider="validCredentialsSupplier")
	public void verifyLogicWithValidCredentails(String email,String password) {
		
		AccountPage accountPage= loginPage.Login(email, password);
		Assert.assertTrue(accountPage.isDisplayedEditYourAccountInformationOption(), "Edit your account information is not found");
	
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] SupplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
		
		
	}
	
	@Test(priority =2)
	public void verifyLogicWithInValidCredentails() {
		loginPage.Login(Utilities.genrateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning Message is not displayed");
	
		
	}
	
	@Test(priority =3)
	public void verifyLogicWithInValidEmailCredentails() {
		
		loginPage.Login(Utilities.genrateEmailWithTimeStamp(), prop.getProperty("password"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning Message is not displayed");
		
	}

	
	@Test(priority =4)
	public void verifyLogicWithInValidPasswordCredentails() {

		loginPage.Login(prop.getProperty("username"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning Message is not displayed");
		
		
	}
	
	@Test(priority =5)
	
	public void verifyLogicWithoutCredentails() {

		loginPage.clickonLoginButton();
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning Message is not displayed");
		
		
	}
	
	
}
