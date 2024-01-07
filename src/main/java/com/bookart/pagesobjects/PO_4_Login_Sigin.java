package com.bookart.pagesobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_4_Login_Sigin {

	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor executor;

	public PO_4_Login_Sigin(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
		executor = (JavascriptExecutor) ldriver;

		wait = new WebDriverWait(ldriver, 20);

		PageFactory.initElements(rdriver, this);
	}

// Object element 
	@FindBy(id = "email")
	WebElement regemailob;

	@FindBy(id = "password")
	WebElement regpassob;

	// @FindBy(xpath = "//button[normalize-space()='Sign In']")
	@FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg\"]")
	WebElement enterbtnob;

	@FindBy(xpath = "//a[@id='btn_google_login']")
	// indexxpath- //a[normalize-space()='Google'])[1])
	WebElement loginviagooglebtn;

	@FindBy(xpath = "//a[@id='btn_facebook_login']")
	WebElement loginviafacebookbtn;

	@FindBy(id = "//label[@id='email-error']")

	WebElement lableerroremail;

	@FindBy(id = "//label[@id='password-error']")
	WebElement lableerrorpass;

	@FindBy(xpath = "(//div[contains(text(),'Email ID is not registered with us.')])[1]")
	//div[contains(text(),'Email ID is not registered with us.')]
	WebElement getlableerrormsgwrongemail;
	
	@FindBy(xpath ="//div[contains(text(),'Password is incorrect')]")
	WebElement getlableerrormsgwrongpass;
	
	@FindBy(xpath = "(//button[@aria-label='Close'])[2]")
	WebElement closelablebuttonarialbl;
	
	
	
	// identify action on webelement


	public String getlableerrormsgwrongemail() {
		String text = getlableerrormsgwrongemail.getText();
		return text;
	}

	public String getlableerrormsgwrongpass() {
		String text = getlableerrormsgwrongpass.getText();
		return text;
	}
	
	public void closeedlableerror() {
		closelablebuttonarialbl.click();
	}
	
	public String getlableerroremail() {

		String text = lableerroremail.getText();
		return text;
	}

	public String getlableerrorpass() {
		String text = lableerrorpass.getText();
		return text;
	}
	
	public void enterRegEmail(String regemailid) {

		regemailob.clear();
		regemailob.sendKeys(regemailid);
	}

	public void enterRegPassword(String regpass) {
		regpassob.clear();
		regpassob.sendKeys(regpass);
	}

	public void clickedOnSigninButton() {

		wait.until(ExpectedConditions.elementToBeClickable(enterbtnob));
		executor.executeScript("arguments[0].click();", enterbtnob);

//		Actions act = new Actions(ldriver);	
//		act.moveToElement(enterbtnob).build().perform();
//		enterbtnob.click();
	}

	@FindBy(xpath = "//button[@id='btnCloseModal']")
	WebElement NewsLetter;

	public void HandleNewsletterPopup() {
		// NewsLetterPopup handle
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(NewsLetter));
			NewsLetter.click();

//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			jsExecutor.executeScript("arguments[0].click();", NewsLetter);
			System.out.println("Newsletter Popup Handled");

		} catch (Exception e) {
			System.out.println("Newsletter Popup not Found");
		}
	}

	public void clickedOnGoogle() {
		Actions act = new Actions(ldriver);
		act.moveToElement(loginviagooglebtn).build().perform();
		loginviagooglebtn.click();
	}

	public void clickedOnFacebook() {
		Actions act = new Actions(ldriver);
		act.moveToElement(loginviafacebookbtn).click().perform();
		loginviafacebookbtn.click();
	}

}
