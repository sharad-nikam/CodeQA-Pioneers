package com.bookart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_6_ViewBagPage {
	WebDriver ldriver;
	JavascriptExecutor executor;
	private int itemCount;

	public PO_6_ViewBagPage(WebDriver rdriver) {
		ldriver = rdriver;
		this.itemCount = 1;
		PageFactory.initElements(rdriver, this);
		executor = (JavascriptExecutor) ldriver;
	}

	@FindBy(xpath = "//div[@class='teaser-name'][normalize-space()='VIVEK SHANKAR BHARTIYA AVM PASHATYA KAVYASHASTRA 9th Edition 2023']")
	WebElement clickonimage;

	@FindBy(xpath = "//div[@class='col-12 col-lg-5']//button[@id='add-to-cart']")
	WebElement addcartbutton;

	// ------------------------------------------------------------

	@FindBy(xpath = "//body/section[1]/div[3]/div[12]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]/i[1]")
	WebElement add_cart;

	@FindBy(xpath = "//h4[text()='Your Shopping Bag']")
	WebElement yourShoppingTitle;

	@FindBy(xpath = "//a[normalize-space()='View Bag']")
	WebElement veiw_bag;

	@FindBy(xpath = "//div[@class='col-sm-9 col-9']")
	WebElement description;

	// YourCArt page locator

	@FindBy(xpath = "//body/section[@class='container-screen position-static']/div[@class='page-section mid-content']/div[@class='container clearfix']/div[@class='mt-3']/div[@class='cart-page']/div[1]/div[1]")
	WebElement yourcarttitle;

	@FindBy(xpath = "//div[@class='item-name']")
	WebElement bookname;

	@FindBy(xpath = "//div[@class='mb-1 viewcart-sku']")
	WebElement des;

	@FindBy(xpath = "//a[normalize-space()='+']")
	WebElement quantity;

	@FindBy(xpath = "//div[@class='row mt-4']//div[3]//div[1]")
	WebElement price;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement quantity_update;

	@FindBy(xpath = "//a[normalize-space()='Checkout']")
	WebElement checkout;

	@FindBy(xpath = "//li[@class='d-flex h4 justify-content-between']/span[2]")
	WebElement getTotal;

	@FindBy(xpath = "//div[@class='row mt-4']//div[3]//div[2]")
	WebElement getPrice;

	@FindBy(xpath = "//span[@class='d-none d-sm-block btn-link']")
	WebElement removeproduct;

	@FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
	WebElement continueshopping;
	// --------------------------------------------------------------

	@FindBy(xpath = "//div[@class='col-12 col-lg-5 btn-buynow-hold ']//button[@id='add-to-cart']")
	WebElement buynowbutton;

	@FindBy(xpath = "//p[contains(text(),'BHARTIYA AVM PASHCHATYA KAVYASHASTRA WRITTEN BY Dr')]")
	WebElement bookDescription;

	@FindBy(xpath = "//table[@class='table-new table-bordered-new table-condensed']")
	WebElement bookdetails;

	@FindBy(xpath = "div[dir='auto']")
	WebElement details;

	public void clickedOnImage() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", clickonimage);

	}

	public void clickedOnAddCart() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", addcartbutton);

	}

	// ------------------------------------------------------------------
	public void AddCart() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", add_cart);
		// add_cart.click();
	}

	public void YourShoppingTitle() {
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		WebElement yourShoppingTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Your Shopping Bag']")));
		String Title = yourShoppingTitle.getText();
		System.out.println("Title:-" + Title);
		String discr = description.getText();
		System.out.println("Description: " + discr);

	}

	public void ViewBag() {

		WebDriverWait wait = new WebDriverWait(ldriver, 20); // 10 seconds timeout
		WebElement veiw_bag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Bag']")));
		veiw_bag.click();

	}

	public void YourCartPage() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,250)", "");
		String yourTitle = yourcarttitle.getText();
		System.out.println(yourTitle);
		String bookName = bookname.getText();
		System.out.println(bookName);
		String describ = des.getText();

		System.out.println(describ);
	}

	public String Quantity() {
		WebDriverWait wait = new WebDriverWait(ldriver, 12); // 10 seconds timeout
		WebElement quantity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='+']")));
		// String q = quantity.getText();
		// System.out.println(q);
		quantity.click();
		String current_value = getTotal.getText();
		System.out.println("Current Value:" + current_value);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,250)", "");

		return current_value;
	}

	public String Update_Quantity() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", quantity_update);
		 WebDriverWait wait = new WebDriverWait(ldriver, 20); // 20 seconds timeout
		   WebElement quantity_update =
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update']")));
//		   Actions actions = new Actions(ldriver);
//		   actions.moveToElement(quantity_update).build().perform();
//		   quantity_update.click();
		   
		   executor.executeScript("arguments[0].click();", quantity_update);
		String updated_value = getTotal.getText();
		System.out.println("Updated Value:" + updated_value);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,250)", "");
		return updated_value;
	}

	public void CheckOut() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30); // 10 seconds timeout
		WebElement checkout = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Checkout']")));
		checkout.click();
	}

//	public double getPrice() {
//		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
//		executor.executeScript("arguments[0].click();", getPrice);
//		String get_price = getPrice.getText();
//		String price = get_price.replaceAll("[^a-zA-Z0-9_]", "");
//		double finalprice = Double.parseDouble(price);
//		return finalprice / 100;
//
//	}

//	public double getTotal() {
//		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
//		executor.executeScript("arguments[0].click();", getTotal);
//		String get_total = getPrice.getText();
//		String total = get_total.replaceAll("[^a-zA-Z0-9_]", "");
//		double finaltotal = Double.parseDouble(total);
//		return finaltotal / 100;
//	}

	public void RemoveProduct() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(ldriver, 12); // 10 seconds timeout
		// WebElement removeproduct =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='d-none
		// d-sm-block btn-link']")));
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", removeproduct);
		// removeproduct.click();
		// Thread.sleep(5000);
		// ldriver.switchTo().alert().accept();
		Alert alert = ldriver.switchTo().alert();
		String alerttext = alert.getText();
		Thread.sleep(5000);
		System.out.println(alerttext);
		Thread.sleep(5000);
		alert.accept();
	}

	public void ContinueShopping() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", continueshopping);
		// WebDriverWait wait = new WebDriverWait(ldriver, 10); // 10 seconds timeout
		// wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//a[normalize-space()='Continue
		// Shopping']")));
		// continueshopping.click();
	}
//-----------------------------------------------------

	public void ClickOnBuyNow() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", buynowbutton);

	}

	public double getPrice() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", getPrice);
		String get_price = getPrice.getText();
		String price = get_price.replaceAll("[^a-zA-Z0-9_]", "");
		double finalprice = Double.parseDouble(price);
		return finalprice / 100;

	}

	public double getTotal() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();", getTotal);
		String get_total = getPrice.getText();
		String total = get_total.replaceAll("[^a-zA-Z0-9_]", "");
		double finaltotal = Double.parseDouble(total);
		return finaltotal / 100;
	}

	public void BookInfo() {

		String describ = bookDescription.getText();
		System.out.println("Book Description: " + describ);
		// String bookDetails = bookdetails.getText();
		// System.out.println("Book Description: "+bookDetails);
		String Details = details.getText();
		System.out.println("Book Details: " + Details);

	}
}
