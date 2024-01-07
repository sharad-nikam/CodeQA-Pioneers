package com.bookart.pagesobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PO_5_SearchPageobj {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor executor;

	public PO_5_SearchPageobj(WebDriver rdriver) {
		ldriver = rdriver;
		executor = (JavascriptExecutor) ldriver;

		wait = new WebDriverWait(ldriver, 20);

		PageFactory.initElements(rdriver, this);
	}

	//click on searchbox
	@FindBy(xpath="//div[@class='search-toggle closed']")
   private WebElement search;
	public void searchbox() {
		search.click();
		
	}//send value to searchbox
	@FindBy(xpath="//input[@id='keyword']")
	private WebElement value;
	public void sendvalue(String entervalue) {
		value.sendKeys(entervalue);
		
	} // click on searchbutton
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement click1;
	public void clickonsearchbox() {
		click1.click();	
	}
	//verify the message
	@FindBy(xpath="//span[text()='Search Results on \"']")
	private WebElement search_result_match;
	
	public String verifygetstatus() {
		String st =search_result_match.getText();
		return st;	
	}
	//-------------------------------------------------------------
	//verify the error input message
	//send value to searchbox
		@FindBy(xpath="//input[@id='keyword']")
		private WebElement value1;
		public void sendvalue1(String entervalue) {
			value1.sendKeys(entervalue);
		}
		@FindBy(xpath="(//button[@type='submit'])[1]")
		private WebElement click2;
		public void clickonsearchbox1() {
			click2.click();	
		}
		
		@FindBy(xpath="//body/section[1]/div[3]/div[3]/div[1]/div[2]/h4[1]")
		private WebElement message1;
		
		public String verifygetstatus1() {
			String st1 = search_result_match.getText();
			return st1;
		}
	}