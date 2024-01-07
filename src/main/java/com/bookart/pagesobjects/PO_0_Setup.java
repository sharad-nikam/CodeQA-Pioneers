package com.bookart.pagesobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_0_Setup {
	
	WebDriver ldriver;

	public String getPageTitle() {
		return (ldriver.getTitle());
	}

	public PO_0_Setup(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	// xpath for User Account option for signin or login
	@FindBy(xpath ="//a[@id='user_profile']")
	WebElement profileIcon;
	public void clickUserProfileIcon() {
		Actions act2 = new Actions(ldriver);
		act2.moveToElement(profileIcon).build().perform();
		profileIcon.click();
	}
	
	@FindBy(xpath ="(//button[@type='button'])[18]")
	WebElement loginpopupclosebtn;
	public void clickTocloseLoginPopup() {
		loginpopupclosebtn.click();
	}
	
	@FindBy(xpath ="(//a[@class='dropdown-item'][normalize-space()='Logout'])[1]	")
	WebElement logutdropdown;
	
	public String getLogouttext() {
		String logouttext = logutdropdown.getText();
		return logouttext;
	}
	
	public void clickOnLogoutDropDownOpt() {
		
		Actions act2 = new Actions(ldriver);
		act2.moveToElement(logutdropdown).build().perform();
		logutdropdown.click();
	}
	
	
	
	@FindBy(xpath ="//button[@id='btnCloseModal']")
	WebElement newsletterpopup;
	public void clickToClosePopup() {
		newsletterpopup.click();
	}

	@FindBy(xpath = "//h4[text()='Login']")
	WebElement LoginText;

	public void getLoginTesxt() {
		LoginText.isEnabled();
	}

	@FindBy(xpath = "(//input[@id='email'])[4]")
	WebElement regemailob;

	public void enterRegEmail(String regemailid) {
		
		regemailob.sendKeys(regemailid);
	}

//	@FindBy(id = "password")
	@FindBy(xpath="//div[@class='field field--full clearfix']//input[@id='password']")
	WebElement regpassob;

	public void enterRegPassword(String regpass) {
		regpassob.sendKeys(regpass);
	}
	
	
	@FindBy(xpath = "(//span[contains(text(),'Submit')])[1]") 
	WebElement submit;
	
	public void clickedOnSigninButton (){
		
		Actions act = new Actions(ldriver);
		act.moveToElement(submit).build().perform();
		submit.click();
	}

	@FindBy(xpath = "(//span[contains(text(),'Hello')])[1]")
	WebElement labletext;
	//@FindBy(xpath ="(//span[@class='font-weight-bold'][normalize-space()='Usser1 Harry'])[1]")
	public String getlbltextafterlogin() {
		String text = labletext.getText();
		return text;
	}
	
	// xpath for Login via Google form user account popup
	@FindBy(xpath = "(//a[@id='btn_google_login'])[1]")
	WebElement userloginwithGoogle;

	public boolean ClickableOrNotGoogleButton() {
		boolean active = userloginwithGoogle.isEnabled();
		return active;
	}

	// xpath for Login via facebook form user account popup
	@FindBy(xpath = "(//a[@id='btn_facebook_login'])[1]")
	WebElement userloginwithfacebook;

	public void userloginwithfacebook() {
		Actions act = new Actions(ldriver);
		act.moveToElement(userloginwithfacebook).build().perform();
		userloginwithfacebook.click();
	}

	// Log in to use your Facebook account with Boookart.
	@FindBy(xpath = "(//a[@id='btn_google_login'])[1]")
	WebElement facebooktext;

	public String getloginfbtext() {
		String fbwindowtext = facebooktext.getText();
		return fbwindowtext;
	}

	// xpath for SignUp button
	//@FindBy(xpath = "//a[text()=' Sign Up']")
	@FindBy(xpath = "(//a[normalize-space()='Sign Up'])[1]")
	WebElement Signup;

	public void clickOnSignUpButton() {
		Signup.click();
	}

	// xpath for SignIn button
	@FindBy(xpath = "//a[text()='Sign In']")
	
	WebElement Signin;
	public void clickOnSignInButton() {
		Signin.click();
	}

	@FindBy(id = "lbl_modal_title")
	WebElement titleLoginPopup;

	public String getTitleLoginPopup() {
		String popUpLogintext = titleLoginPopup.getText();
		return popUpLogintext;
	}

}
