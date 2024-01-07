package com.bookart.pagesobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PO_7_AddtoCart_PageObject {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;

	public PO_7_AddtoCart_PageObject(WebDriver driver1) {
		driver = driver1;
		wait = new WebDriverWait(driver, 30);
		executor = (JavascriptExecutor) driver;

		PageFactory.initElements(driver1, this);

	}

	@FindBy(xpath = "//button[@data-row-id='764909']")
	WebElement addCart;

	@FindBy(xpath = "//button[@data-row-id='625931']")
	WebElement addCart1;

	@FindBy(xpath = "//button[@data-row-id='442629']")
	WebElement addCart2;

	@FindBy(xpath = "(//span[@aria-hidden=\"true\"])[1]")
	WebElement NewsletterPopup;

	@FindBy(xpath = "(//div[@class=\"text-dark w-75\"])[1]")
	WebElement cartIteam;

	@FindBy(xpath = "(//img[@class=\"img-fluid pt-1\"])[2]")
	WebElement cartIteam1;

	@FindBy(xpath = "(//img[@class=\"img-fluid pt-1\"])[3]")
	WebElement cartIteam2;

	@FindBy(xpath = "//a[@class=\"m-0 position-absolute panel-close\"]")
	WebElement Close;

	@FindBy(xpath = "(//div[text()='Utkarsh phool pati wali class current affairs May ank 27 2023 edition written by kumar gaurav'])[1]")
	WebElement SoldoutProduct;

	@FindBy(xpath = "(//button[@id=\"add-to-cart\"])[1]")
	WebElement SoldoutButton;

	@FindBy(xpath = "//span[@class=\"position-absolute rounded-circle badge badge-primary bg-dark text-white\"]")
	WebElement cartButton;

	@FindBy(xpath = "(//a[@class='cart-item-remove d-block text-danger'])[1]")
	WebElement deletCart;

	@FindBy(xpath = "(//a[@class='cart-item-remove d-block text-danger'])[2]")
	WebElement deletCart1;

	@FindBy(xpath="//a[@data-totalprice='395']")
	WebElement deletCart2;

	@FindBy(xpath = "(//img[@alt=\"Spring Board RAS Foundation Vigyan Prodhogiki by Shivendra Singh\"])[2]")
	WebElement cartProduct;

	@FindBy(xpath = "//img[@alt=\"Bhartiya Chitrakala evm Murtikala ka Itihas by Dr Reeta Pratap 36th Edition\"")
	WebElement cartProduct1;

	@FindBy(xpath = "(//img[@alt=\"Audyogik Bhugol by Rajmal Lodha Deepak Maheswari\"])[2]")
	WebElement cartProduct2;

	@FindBy(xpath = "//div[@class='cart-empty mb-3 mt-2']")
	WebElement emptyCart;

	public void Cart() {

		wait.until(ExpectedConditions.elementToBeClickable(addCart));
		executor.executeScript("arguments[0].click();", addCart);

		// NewsLetterPopup handle
		try {
			wait.until(ExpectedConditions.elementToBeClickable(NewsletterPopup));
			executor.executeScript("arguments[0].click();", NewsletterPopup);
			System.out.println("Newsletter Popup Handled");
		} catch (Exception e) {
			System.out.println("Newsletter Popup not Found");
		}

	}

	public boolean VerifyCartElement() {

		String cartIt = cartIteam.getText();

		System.out.println(cartIt);

		return cartIteam.isDisplayed();

	}

	public void closeCart() {
		// close cart
		wait.until(ExpectedConditions.elementToBeClickable(Close));
		executor.executeScript("arguments[0].click();", Close);

	}

	public void openCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		executor.executeScript("arguments[0].click();", cartButton);

	}

	public void MultipleIteamsAddCart() {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(NewsletterPopup));
			executor.executeScript("arguments[0].click();", NewsletterPopup);
			System.out.println("Newsletter Popup Handled");

		} catch (Exception e) {
			System.out.println("Newsletter Popup not found");
		}

		wait.until(ExpectedConditions.elementToBeClickable(addCart1));
		executor.executeScript("arguments[0].click();", addCart1);

		closeCart();

		wait.until(ExpectedConditions.elementToBeClickable(addCart2));
		executor.executeScript("arguments[0].click();", addCart2);

	}

	public boolean VerifyMultipleCartElement() {

		wait.until(ExpectedConditions.visibilityOf(cartIteam1));

		wait.until(ExpectedConditions.visibilityOf(cartIteam2));


//	    String cartItem1Text = cartIteam1.getText();
//	    String cartItem2Text = cartIteam2.getText();
//        System.out.println("Cart Item 1: " + cartItem1Text);
//        System.out.println("Cart Item 2: " + cartItem2Text);

		return cartIteam1.isDisplayed() && cartIteam2.isDisplayed();


	}

	public boolean soldOut() {

		closeCart();

		wait.until(ExpectedConditions.elementToBeClickable(SoldoutProduct));
		executor.executeScript("arguments[0].click();", SoldoutProduct);


		return SoldoutButton.isEnabled();
	}

	public boolean removeIteamfromCart() {
		driver.navigate().back();
		openCart();

		wait.until(ExpectedConditions.elementToBeClickable(deletCart));
		executor.executeScript("arguments[0].click();", deletCart);

		// Assert.assertTrue(cartProduct.isDisplayed());

		return cartProduct.isDisplayed();
	}

	public boolean emptyCart() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(deletCart1));
		executor.executeScript("arguments[0].click();", deletCart1);
        Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(deletCart2));
		executor.executeScript("arguments[0].click();", deletCart2);
       
		wait.until(ExpectedConditions.visibilityOf(emptyCart));
		return emptyCart.isDisplayed();
		
		// return cartProduct1.isDisplayed() && cartProduct2.isDisplayed();
	}
}
