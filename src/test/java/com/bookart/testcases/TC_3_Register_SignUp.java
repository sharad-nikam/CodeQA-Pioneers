package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_1_PopupHandle;
import com.bookart.pagesobjects.PO_0_Setup;
import com.bookart.pagesobjects.PO_3_Register_Sigup;
import com.bookart.utilities.ReadConfig;

public class TC_3_Register_SignUp extends TC_0_Setup {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String SignupURl = "https://www.boookart.com/customers/register";
	String country = "India";

	// Test Cases for Signup or Registration.

	@Test(enabled = true, priority = 1)
	public void TC_Verify_NavigationFlow_from_HomePage_To_SignupPage() throws Exception {
		//driver.navigate().to(url);
		PO_1_PopupHandle clasoePopup = new PO_1_PopupHandle(driver);
		clasoePopup.newsLetterPopup();
		logger.info("Clicking on User Profile Account Menu ");
		PO_0_Setup userprofile = new PO_0_Setup(driver);
		userprofile.clickUserProfileIcon();
		Thread.sleep(2000);
		logger.info("Clicking on Signup button");
		PO_0_Setup signup = new PO_0_Setup(driver);
		signup.clickOnSignUpButton();
		Assert.assertEquals(driver.getCurrentUrl(), SignupURl);
	}

	@Test(enabled = true, priority = 2)
	public void TC_Validating_NavigationOf_SignInpage_from_SignUpPage() throws Exception {
		logger.info("TC_Validating_NavigationOf_SignInpage_from_SignUpPage");
		// Verifying redirection to the Login page from Registration page
		PO_3_Register_Sigup customerSignUp = new PO_3_Register_Sigup(driver);
		customerSignUp.ClickonSigIn();
		// Verifying redirection to the landing page
		String expectedURL = "https://www.boookart.com/customers/login";
		String actualURL = driver.getCurrentUrl();
		logger.info("The current page URL is: " + actualURL);
		Assert.assertEquals(actualURL, expectedURL);
		// Verifying redirection to the Titile of current page
		String expectedTitle = "BoookArt: Login";
		String actualTitle = driver.getTitle();
		logger.info("The current page Title is: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	// Test Starts :
	// Registration with email id which already have account
	
	@Test(enabled = true, priority = 3)
	public void TC_Verify_CustomerSignUp_ForAlready_Registered_Customer() throws Exception {
		logger.info("TC_Verify_CustomerSignUp_ForAlready_Registered_Customer");
		driver.get(SignupURl);
		PO_3_Register_Sigup customerSignUp = new PO_3_Register_Sigup(driver);
		customerSignUp.enterEmail("user1Harry@gmail.com");
		customerSignUp.entePassword("(//input[@id='email'])[1]");
		customerSignUp.enteFirstName("User1");
		customerSignUp.enteLastName("Harry");
		customerSignUp.enterMobile("0987654321");
		customerSignUp.selectCountrandTermscodnCheckBox_Submit();
		String expectedErrorMsg = "You are already registered with us, Please login";
		String actualErrorMsg = customerSignUp.geterrortextforreguser();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		logger.info("The Error Message for already register customer is :" + expectedErrorMsg);
		customerSignUp.closeerrortextforreguser();
	}

}

//@Test(enabled = false, priority = 4)
//public void Verify_RegisterPage_UI_Testing() throws Exception {
//	P2_Register_Sigup_PageObject SignUpPageElements = new P2_Register_Sigup_PageObject(driver);
//	SignUpPageElements.getHeaderText();
//	SignUpPageElements.termsandconditionlink();
//}