package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_1_PopupHandle;
import com.bookart.pagesobjects.PO_0_Setup;
import com.bookart.pagesobjects.PO_3_Register_Sigup;
import com.bookart.pagesobjects.PO_4_Login_Sigin;

public class TC_4_Login_Test extends TC_0_Setup {

	String correctemail = readConfig.getSigninEmail();
	String correctpassword = readConfig.getSigninPassword();
	String LoginURL = "https://www.boookart.com/customers/login";
	String expectedLoginURL = "https://www.boookart.com/customers/login";
	String actloginurl = "https://www.boookart.com/customers/login";
	String invalidemail = "user1harrygmail.com";
	String wrongpassword = "12345678";
	String nonregmailforsignin = "user2harry@gmail.com";

	@Test(enabled = true, priority = 2)

	public void TC_Login_Verify_LoginPageURL() throws Exception {
		PO_1_PopupHandle clasoePopup = new PO_1_PopupHandle(driver);
		clasoePopup.newsLetterPopup();
		logger.info("*********Login Scenario Starts ********");
		logger.info("Login Step#1: Navigate to Login Page URL.");
		driver.navigate().to(expectedLoginURL);
		logger.info("Login step#2: Verifying that LoginURL is landing on correct page or not");
		String actLoginURL = driver.getCurrentUrl();
		logger.info(actLoginURL);
		Assert.assertEquals(expectedLoginURL, actLoginURL);
	}

	@Test(enabled = true, priority = 3)
	public void TC_Login_Validate_LoginPagetitle() throws Exception {
		logger.info("*********Login Scenario Start ********");
		logger.info("Login Step #1 : Navigate to Login Page URL.");
		driver.navigate().to(LoginURL);
		logger.info("Login Step #2 : Validate that, actucal Login Page title as expected Login Page Title");
		String expLoginPageTitle = "BoookArt: Login";
		String actLoginPageTitile = driver.getTitle();
		logger.info("The Actual Login Page Title is: " + actLoginPageTitile);
		Assert.assertEquals(expLoginPageTitle, actLoginPageTitile);
	}

	@Test(enabled = false, priority = 4)
	public void TC_Login_Verify_Entering_wrong_Email_and_login_will_Show_Error_message() throws Exception {
		logger.info("Login Step #1 : Navigate to Login Page URL.");
		driver.navigate().to(LoginURL);
		logger.info("Login Step #2 :Enter wrong email");
		PO_4_Login_Sigin emaiforsignin = new PO_4_Login_Sigin(driver);
		emaiforsignin.enterRegEmail(nonregmailforsignin);
		logger.info("Login Step #3 :Enter correct password");
		PO_4_Login_Sigin passforsigin = new PO_4_Login_Sigin(driver);
		passforsigin.enterRegPassword(correctpassword);
		logger.info("Login Step #4 :Click on SignIn button to login to account");
		PO_4_Login_Sigin submit = new PO_4_Login_Sigin(driver);
		submit.clickedOnSigninButton();
		logger.info(
				"Login Step #5 : TC_Verfiy that for wrong email, customer able to see error message 'Email ID is not registered with us.' on Login page screen");
		PO_4_Login_Sigin wrongerroremail = new PO_4_Login_Sigin(driver);
		String actlblerrorforwrongemail = wrongerroremail.getlableerrormsgwrongemail();
		String expelblrrorforwrongemail = "Email ID is not registered with us.";
		logger.info("The Actual error Message is for invalid email : " + actlblerrorforwrongemail);
		Assert.assertEquals(expelblrrorforwrongemail, actlblerrorforwrongemail);
		wrongerroremail.closeedlableerror();
	}

	@Test(enabled = true, priority = 5)
	public void TC_Login_Verify_Entering_wrong_password_and_login_will_Show_Error_message() throws Exception {
		logger.info("Login Step #1 : Navigate to Login Page URL.");
		driver.navigate().to(LoginURL);
		logger.info("Login Step #2 :Enter correct email");
		PO_4_Login_Sigin emaiforsignin = new PO_4_Login_Sigin(driver);
		emaiforsignin.enterRegEmail(correctemail);
		logger.info("Login Step #3 :Enter incorrect password");
		PO_4_Login_Sigin passforsigin = new PO_4_Login_Sigin(driver);
		passforsigin.enterRegPassword(wrongpassword);
		logger.info("Login Step #4 :Click on SignIn button to login to account");
		PO_4_Login_Sigin submit = new PO_4_Login_Sigin(driver);
		submit.clickedOnSigninButton();
		logger.info(
				"Login Step #5 : TC_Verfiy that for wrong email, customer able to see error message 'password is incoorect' on Login page screen");
		PO_4_Login_Sigin wrongerrorpass = new PO_4_Login_Sigin(driver);
		String actlblrrorforwrongpass = wrongerrorpass.getlableerrormsgwrongpass();
		String expelblrrorforwrongpass = "Password is incorrect";
		logger.info("The Actual error Message is for invalid passord is : " + actlblrrorforwrongpass);
		Assert.assertEquals(expelblrrorforwrongpass, actlblrrorforwrongpass);
		wrongerrorpass.closeedlableerror();
	}


	@Test(enabled = true, priority = 6)
	public void TC_Login_Verify_Valid_Login_Credentials() throws Exception {
		logger.info("Login Step #1 : Navigate to Login Page URL.");
		driver.navigate().to(LoginURL);
		logger.info("Login Step #2 :Enter Correct email");
		PO_4_Login_Sigin emaiforsignin = new PO_4_Login_Sigin(driver);
		emaiforsignin.enterRegEmail(correctemail);
		logger.info("Login Step #3 :Enter correct password");
		PO_4_Login_Sigin passforsigin = new PO_4_Login_Sigin(driver);
		passforsigin.enterRegPassword(correctpassword);
		logger.info("Login Step #4 :Click on SignIn button to login to account");
		PO_4_Login_Sigin submit = new PO_4_Login_Sigin(driver);
		submit.clickedOnSigninButton();
		Thread.sleep(7000);
		logger.info("Login Step #5: Closed Newsletter popup after login");
		PO_1_PopupHandle closeedPopup = new PO_1_PopupHandle(driver);
		closeedPopup.newsLetterPopup();
		logger.info("Login Step #6: Click on User profile icon");
		PO_0_Setup prfileicon = new PO_0_Setup(driver);
		prfileicon.clickUserProfileIcon();
		logger.info("Login Step #7: Verify User can able see welcome mesaaege as 'Hello' ");
		String labelWelComeMessage = prfileicon.getlbltextafterlogin();
		String explabelWelComeMessage = "Hello";
		if (explabelWelComeMessage.equals(labelWelComeMessage)) {
			logger.info("Verify with Valid Login Credentials - Passed");
			Assert.assertTrue(true);
		} else {
			logger.info("Verify with Valid Login Credentials - Failed");
			//captureScreenShot(driver, "TC_Login_Verify_Valid_Login_Credentials");
			Assert.assertTrue(false);

		}
	}
}

//@Test(enabled = false, priority = 6)
//public void TC_Login_Verify_Entering_empty_email_password_and_login_() throws Exception {
//	logger.info("Login Step #1 : Navigate to Login Page URL.");
//	driver.navigate().to(LoginURL);
//	logger.info("Login Step #2 :Enter correct email");
//	PO_4_Login_Sigin emaiforsignin = new PO_4_Login_Sigin(driver);
//	emaiforsignin.enterRegEmail("");
//	logger.info("Login Step #3 :Enter invalid password");
//	PO_4_Login_Sigin passforsigin = new PO_4_Login_Sigin(driver);
//	passforsigin.enterRegPassword("");
//	logger.info("Login Step #4 :Click on SignIn button to login to account");
//	PO_4_Login_Sigin submit = new PO_4_Login_Sigin(driver);
//	submit.clickedOnSigninButton();
//	logger.info(
//			"Login Step #5 : TC_Verfiy that for invalid password , customer able to see error message 'Please enter valid password' on Login page");
//	PO_4_Login_Sigin errorpass = new PO_4_Login_Sigin(driver);
//	String acterrorpass = errorpass.getlableerrorpass();
//	String experrorpass = "Please enter valid password";
//	logger.info("The Actual error Message is for invalid email : " + acterrorpass);
//	Assert.assertEquals(acterrorpass, experrorpass);
//	//invalidemail
//}


//	@Test(enabled = true, priority = 7)
//	public void TC_Verify_Subscriber_NewsletterPopup_Shown_after_Customer_Login() {
//		PO_0_PopupHandle closeedPopup = new PO_0_PopupHandle(driver);
//		closeedPopup.newsLetterPopup();
//	}
//
//}

//	@Test(enabled = false, priority = 3)
//	public void Verify_RegCutomer_Login_With_Google_ValidCredentials() throws Exception {
//		System.out.println("Verifying Login Test With Google button option for valid Credentials");
//		PO_4_Login_Sigin logingoogle = new PO_4_Login_Sigin(driver);
//		logingoogle.clickedOnGoogle();
//		System.out.println("---------LoginTest login with Google End--------");
//	}
//
//	// Login With Google from Popup Window //currently Google option is blocked
//	@Test(enabled = false, priority = 4)
//	public void EnterLoginDetails() throws Exception {
//		System.out.println("Entering signin Details");
//		try {
//			PO_1_Setup userloginviagoogle = new PO_1_Setup(driver);
//			userloginviagoogle.ClickableOrNotGoogleButton();
//			System.out.println("------validating button enable or disable----");
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
//	}
