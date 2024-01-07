package com.bookart.pagesobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_3_Register_Sigup {
	// create obect of webdriver
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor executor;

	// Constructor
	public PO_3_Register_Sigup(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(ldriver, 30);
		executor=(JavascriptExecutor)ldriver;
		PageFactory.initElements(rdriver, this);
	}
	// identify WebElements on this Page : Regigistration Page

	@FindBy(tagName = "h2")
	WebElement headerRegPage;
	// h2[@class='text-xs-start']

	@FindBy(id = "email")
	// @FindBy(xpath="(//input[@id='email'])[1]")
	// div[@class='field field--half clearfix field--active']//input[@id='email']
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	// phone_mobile
	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "country_id")
	WebElement selectCountry;

	@FindBy(xpath = "(//input[@id='C'])[1]")
	WebElement checkBoxElement;

	@FindBy(id = "CustomerAgree")
	WebElement checkbox1;

	@FindBy(xpath = "(//label[@for='CustomerAgree'])[1]")
	WebElement agreeCheckbox;

	// closr login popup
	@FindBy(xpath = "(//button[@aria-hidden=\"Close\"])[1]")
	WebElement closelogintab;

	@FindBy(xpath = "//a[@class='btn-link']")
	WebElement termscondlink;

	// @FindBy(tagName = "Submit")
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[1]")
	WebElement signupsubmit;

	@FindBy(xpath = "//div[contains(text(),'You are already registered with us, Please login')]")
	WebElement regusererrortext;

	@FindBy(xpath = "(//button[@aria-label='Close'])[2]")
	WebElement closerrormsglbl;

	@FindBy(xpath = "(//a[normalize-space()='Sign In'])[1]")
	WebElement siginbutton;

	// Action on webelement

	public String getPageTitle() {
		return (ldriver.getTitle());
	}

	public void signupheaderText() {
		headerRegPage.isDisplayed();
	}

	public String getHeaderText() {
		String regHeaderText = headerRegPage.getText();
		System.out.println("Header Text is : " + regHeaderText);
		return regHeaderText;

	}

	public void termsandconditionlink() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(termscondlink));
		Actions termslink = new Actions(ldriver);
		termslink.moveToElement(termscondlink).build().perform();
		termscondlink.click();
	}

	public void enterEmail(String createemail) {
		System.out.println("Filling SigUp Form..");
		email.sendKeys(createemail);
	}

	public void entePassword(String createpassword) {
		password.sendKeys(createpassword);
	}

	public void enteFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enteLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterMobile(String mobile) {
		phone.sendKeys(mobile);
		System.out.println("Customer Registration details entered");
	}

	public void selectCountrandTermscodnCheckBox_Submit() throws Exception {
		// use space to checked/unchecked box
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB); // default read chekbox -->> unselected.
		System.out.println("Curser is on Select country");

		// agreeCheckbox.click();

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB); // default read chekbox -->> unselected.
		System.out.println("curser is On read Checkbox");

		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE); // CheckBox is Checked
		System.out.println("CheckBox is marked as Checked");
		// Thread.sleep(2000);

		// On Terms & condition link
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB); // on terms link
		System.out.println("curser is On Terms & Conditon Link");
		// Thread.sleep(2000);

		// Clicked terms and conditions button via enter virtual key
		// r.keyPress(KeyEvent.VK_ENTER);
		// r.keyRelease(KeyEvent.VK_ENTER); // on Submit
		// Thread.sleep(2000);
		// System.out.println("Clicked on terms and conditions");

		// for subscriber newsletter checkbox
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		System.out.println("curser is On Newsleeter chebox");
		// on subscriber checkbox // default subscriber chekbox is selected.
		//Thread.sleep(2000);

		// r.keyPress(KeyEvent.VK_SPACE);
		// r.keyRelease(KeyEvent.VK_SPACE); // Subscribe for newsletter is UnChecked
		// Thread.sleep(2000);
		// System.out.println("Subscribe for newsletter is UnChecked");

		// Verify Submit button
		// On Submit
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB); // on Submit
		// Thread.sleep(2000);
		System.out.println("Curser is on Submit button");

		// Clicked Submit button via enter virtual key
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER); // on Submit
		//Thread.sleep(3000);
		System.out.println("Submit button is Clicked");

	}

	// public void closelogintab() {
	// Actions closrLogin = new Actions(ldriver);
	// closrLogin.moveToElement(closelogintab).build().perform();
	// closelogintab.click();
	// }

	public String geterrortextforreguser() {
		String errortext = regusererrortext.getText();
		return errortext;
	}

	public void closeerrortextforreguser() throws InterruptedException {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(closerrormsglbl));
		executor.executeScript("arguments[0].click();", closerrormsglbl);
		
	}

	public void ClickonSigIn() throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(siginbutton));
		executor.executeScript("arguments[0].click();", siginbutton);
	}

}

//System.out.println("The checkbox is selection state is - " + agreeCheckbox.isSelected());
//if(!agreeCheckbox.isSelected())
//