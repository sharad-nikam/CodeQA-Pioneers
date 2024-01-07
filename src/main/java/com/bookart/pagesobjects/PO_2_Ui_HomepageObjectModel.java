package com.bookart.pagesobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_2_Ui_HomepageObjectModel {
	
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	
	public PO_2_Ui_HomepageObjectModel (WebDriver rdriver) {
		ldriver = rdriver;
	    wait = new WebDriverWait(ldriver, 30); // 20 seconds timeout
		PageFactory.initElements(rdriver, this);
		executor = (JavascriptExecutor) ldriver;
	}
	
	//@FindBy(xpath = "//img[@class='img-fluid w-100 mx-auto ls-is-cached lazyloaded']")
	//WebElement UtkarshAdd;
	
	@FindBy(xpath ="//img[@alt='Rajasthan GK Books']")
	WebElement Gkbooks;
	
	@FindBy(xpath ="//h2[text()='Rajasthan State Exam Latest']")
	WebElement VerifyGkbooks;
	
	
	@FindBy(xpath="//img[@id='img_807947']")
	WebElement CurrentAffairsEoRo;
	
	@FindBy(xpath ="//h1[text()='Nath Current affairs Vishwa Bharat Rajasthan Varshikank EORO ank 15 by vinod swami']")
	WebElement VerifyCurrentAffairsEoRo;

	
	@FindBy(xpath="//img[@id='img_817273']")
	WebElement Drishti;
	
	@FindBy(xpath="//h1[text()='Drishti Current Affairs Today June 2023']")
	WebElement VerifyDrishti;
	
	@FindBy(xpath = "//img[@alt='MAHESH KUMAR BARNWAL BOOKS']")
	WebElement maheshkumar;
	
	@FindBy(xpath="//img[@alt='Drishti The Vision']")
	WebElement drishtiTheVision;
	
	@FindBy(xpath="//i[@class='bi bi-whatsapp']")
	WebElement whatsappIcon;
	
	
	public void clickonUtkarshAdd() {
		
		WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='img-fluid w-100 mx-auto ls-is-cached lazyloaded']")));
		ldriver.navigate().back();
	}
	
	public void clickonGkbooks() {	
		executor.executeScript("arguments[0].click();", Gkbooks);
		 ldriver.navigate().back();
		 
		}
	
	public boolean VerifyonGkbooks() {	
		 
		 return VerifyGkbooks.isDisplayed();
		}
	
	public void clickonCurrentAffairs(){
		
		wait.until(ExpectedConditions.elementToBeClickable(CurrentAffairsEoRo));
	   executor.executeScript("arguments[0].click();",CurrentAffairsEoRo );
	   
		

	}
	public boolean VerifyonCurrentAffairs(){
		
		wait.until(ExpectedConditions.visibilityOf(VerifyCurrentAffairsEoRo));
		
		System.out.println("Verified currentaffaires successfull");
		
		return VerifyCurrentAffairsEoRo.isDisplayed();
		}
	
		public void clickondrishti() {
			
			ldriver.navigate().back();
			
			PO_1_PopupHandle popup = new PO_1_PopupHandle(ldriver);
			
			popup.newsLetterPopup();
			
			wait.until(ExpectedConditions.elementToBeClickable(Drishti));
			executor.executeScript("arguments[0].click();", Drishti);
			System.out.println("clicked on Drishti book ");
		}
		
		public boolean Verifydrishti() {
			
			wait.until(ExpectedConditions.visibilityOf(VerifyDrishti));
			
			return VerifyDrishti.isDisplayed();
		}
	
	public void clickonMaheshKumar() {
		
		ldriver.navigate().back();
		executor.executeScript("arguments[0].click();",maheshkumar);
		
	}

	public void clickonDristiThevision() {
		ldriver.navigate().back();
		executor.executeScript("arguments[0].click();", drishtiTheVision);

	}

	public void clickOnwhatsappIcon() {
		ldriver.navigate().back();
		executor.executeScript("arguments[0].click()", whatsappIcon);
	}
}

