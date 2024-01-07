package com.bookart.pagesobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_8_CheckoutBilling_Payment_ConfirmOrder {
	
	WebDriver driver1;
	WebDriverWait wait;
    JavascriptExecutor executor;
    
	
	public PO_8_CheckoutBilling_Payment_ConfirmOrder(WebDriver driver2) {
		driver1=driver2;
		wait = new WebDriverWait(driver1, 20);
		executor = (JavascriptExecutor) driver1;
		
		
		PageFactory.initElements(driver2, this);
	}
	//click on add to cart
	@FindBy(xpath="//body/section[1]/div[3]/div[12]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]/i[1]")
	WebElement Add_crt;
	
	
	//pop up handle
	@FindBy(xpath = "//button[@id='btnCloseModal']")
	WebElement NewsLetter;
	
	//check if element is added or not
	@FindBy(xpath = "(//div[text()='VIVEK SHANKAR BHARTIYA AVM PASHATYA KAVYASHASTRA 9th Edition 2023'])[2]")
	WebElement CheckAdd_crt;
	
	// checkout cart 
	@FindBy(xpath="//a[@class=\"btn btn-lg btn-primary w-100 checkout-btn\"]")
	WebElement checkoutbtn;
	
	
	//billing and shipping
	
	@FindBy(xpath="//p[text()='Billing & Shipping']")
	WebElement BillingandShippingname;
	
	@FindBy(xpath="//label[@for=\"checkout_via2\"]")
	WebElement CheckoutGuestclk;
	
	@FindBy(id="shipping_email")
	WebElement Email;
	
//	@FindBy(id="shipping_password")
//	WebElement password;
	
	@FindBy(id="shipping_first_name")
	WebElement Fname;
	
	@FindBy(id="shipping_last_name")
	WebElement Lname;
	
	@FindBy(id="shipping_phone")
	WebElement Mobileno;
	
	@FindBy(id="shipping_address")
	WebElement ShippingAdd;
	
	@FindBy(id="shipping_zip")
	WebElement Zipcode;
	
	@FindBy(id="shipping_state_id")  //dropdown
	WebElement state;
	
	@FindBy(xpath="//input[@id=\"shipping_city_name\"]")
	WebElement city;
	
	@FindBy(xpath="//input[@name=\"data[StoreOrder][is_agree_terms]\"]")
	WebElement agreecbx;
	
	@FindBy(xpath="//button[@id=\"btnStoreOrder\"]")
	WebElement continuebtn;
	
	
	//payment option
	@FindBy(xpath="(//input[@id=\"coupon_code\"])[2]")
	WebElement couponcode;
	
	@FindBy(xpath="(//button[@type=\"submit\"])[3]")
	WebElement apply;
	
	@FindBy(xpath="(//div[@class=\"cart-payment-name\"])[4]")
	WebElement slctpayoption;
	
	@FindBy(xpath="(//button[@type=\"submit\"])[1]")
	WebElement countinuebtn1;
	
	//Review & Confirm page
	@FindBy(xpath="//h3[text()='Review your order']")
	WebElement Reviewyourordernamedisplay;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary btn-block btn-lg btn-reviewpay ripple\"]")
	WebElement placeorderbtn;
	
	//continue shopping page
	@FindBy(xpath="//p[text()='Thank you for your order. Kindly note your order number. You may mention this number for communication with our customer service team on 8949270689']")
	WebElement thankyou_msg;
	
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-lg']")
	WebElement ContinueSpg;
	
	
	    //click on add to cart
	    public void click_addcart() {
	    	
		    executor.executeScript("arguments[0].click();", Add_crt);

	    }
	
		// verify added element
		public boolean verifyelementaddingcart() {

			// popup handle
			try {
				wait.until(ExpectedConditions.elementToBeClickable(NewsLetter));
				NewsLetter.click();	
				
			}
			catch(Exception e) {
				System.out.println("News letter popup not found");
			}
			
			// check cart name
			String checkcart = CheckAdd_crt.getText();
			System.out.println(checkcart);
			return CheckAdd_crt.isDisplayed();
		}
       
		// checkoutbtn click
		public void checkoutbtn_click() {
			//wait
//			
//			wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
			// click
			executor.executeScript("arguments[0].click();", checkoutbtn);
		}
       
		// verify billing page
		public boolean billingpagedisplay() throws InterruptedException {

			Thread.sleep(2000);

			String billingnamecheck = BillingandShippingname.getText();
			System.out.println(billingnamecheck);
			return BillingandShippingname.isDisplayed();
		}

		// billing and shipping data
		public void BillingAndShippingdata() {

			CheckoutGuestclk.click();
			Email.sendKeys("user1harry@gmail.com");
			// password.sendKeys("12345678");
			Fname.sendKeys("abc");
			Lname.sendKeys("xyz");
			Mobileno.sendKeys("1234567890");
			ShippingAdd.sendKeys("a/p-efg tal-rhd dist-jdhd");
			Zipcode.sendKeys("123456");
			Select state_n = new Select(state);
			state_n.selectByVisibleText("Maharashtra");
			city.sendKeys("pune");
			agreecbx.click();
			continuebtn.click();
		}
    
		public void PymentOptionsUsingCoupen() {
			couponcode.sendKeys("PGMH0VXFTAO8");
			apply.click();
			slctpayoption.click();
			countinuebtn1.click();
		}
	
		public void PymentOptions() throws InterruptedException {
			slctpayoption.click();
			countinuebtn1.click();
			
			System.out.println("Payment option selected");
    	    Thread.sleep(2000);
		}

		// Review & Confirm page
		public String ReviewandConfirm() {

			wait.until(ExpectedConditions.visibilityOf(Reviewyourordernamedisplay));
			String ReviewOrd = Reviewyourordernamedisplay.getText();
			System.out.println("Reviwe Order title printed: "+ReviewOrd);

			wait.until(ExpectedConditions.elementToBeClickable(placeorderbtn));
			placeorderbtn.click();
			return ReviewOrd;
		}
    	
		// Order Confirmation page
		public String OrderConfirm() {

			wait.until(ExpectedConditions.visibilityOf(thankyou_msg));
			String ConfOrd = thankyou_msg.getText();
			System.out.println("Order conf msg" + ConfOrd);
		
			wait.until(ExpectedConditions.elementToBeClickable(ContinueSpg));
			executor.executeScript("arguments[0].click();", ContinueSpg);
			System.out.println("Order placed sucessfully");
			return ConfOrd;
		}
 }