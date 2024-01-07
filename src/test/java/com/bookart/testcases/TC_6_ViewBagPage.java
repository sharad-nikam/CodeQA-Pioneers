package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_6_ViewBagPage;

public class TC_6_ViewBagPage extends TC_0_Setup {
	
	@Test(priority = 0)
	public void VerifyAddCart() {
		PO_6_ViewBagPage clickaddcartlogo = new PO_6_ViewBagPage(driver);
		clickaddcartlogo.clickedOnImage();

		String ActualTitle = driver.getTitle();
		String expectedTitle = "buy online VIVEK SHANKAR BHARTIYA AVM PASHATYA KAVYASHASTRA 9th Edition 2023";
		Assert.assertEquals(ActualTitle, expectedTitle, "title not  match verify cart failed..");
		System.out.println("Verified VIVEK SHANKAR BHARTIYA book successfull");
	}

	@Test(priority = 1)
	public void AddCartClick() {

		PO_6_ViewBagPage CartTitle = new PO_6_ViewBagPage(driver);
		CartTitle.clickedOnAddCart();
		String ActualTitle = driver.getTitle();
		String expectedTitle = "buy online VIVEK SHANKAR BHARTIYA AVM PASHATYA KAVYASHASTRA 9th Edition 2023";
		Assert.assertEquals(ActualTitle, expectedTitle, "title not  match click cart failed..");
		System.out.println("Successfully clicked on cart button");

	}
	
	@Test(priority = 0)
	public void AddCart() {

		PO_6_ViewBagPage CartTitle = new PO_6_ViewBagPage(driver);
		CartTitle.AddCart();
		PO_6_ViewBagPage YourShopTitle = new PO_6_ViewBagPage(driver);
		YourShopTitle.YourShoppingTitle();
	}

	@Test(enabled=true, priority = 1)
	public void ViewBagButton() {
		System.out.println("***Your Cart All Information***");
		PO_6_ViewBagPage viewBag = new PO_6_ViewBagPage(driver);
		viewBag.ViewBag();
		String ActualTitle = driver.getTitle();
		String expectedTitle = "BoookArt: View Cart";
		Assert.assertEquals(ActualTitle, expectedTitle, "title not  match view cart failed..");
		System.out.println("Successfully clicked on view cart button");
	}

//	@Test(priority = 2)
//	public void ViewBagButton() {
//		System.out.println("***Your Cart All Information***");
//		P6_ViewBagPage viewBag = new P6_ViewBagPage(driver);
//		viewBag.ViewBag();
//		
//	}

	@Test(enabled=true,priority = 3)
	public void Your_Cart() {
		PO_6_ViewBagPage YourCartPage = new PO_6_ViewBagPage(driver);
		YourCartPage.YourCartPage();
		System.out.println("Title page checked");
	}

	@Test(enabled=true,priority = 4)
	public void quantity() throws InterruptedException {
		PO_6_ViewBagPage quant = new PO_6_ViewBagPage(driver);
		String Quantity = quant.Quantity();
		Assert.assertEquals(Quantity, "₹335");
		Thread.sleep(2000);

	}

	@Test(enabled=true,priority = 5)
	public void update_quantity() {
		PO_6_ViewBagPage update_quant = new PO_6_ViewBagPage(driver);
		String Quantity1 = update_quant.Update_Quantity();
		Assert.assertEquals(Quantity1, "₹670");
	}

	@Test(enabled=false,priority = 6)
	public void Total() {
		PO_6_ViewBagPage price = new PO_6_ViewBagPage(driver);
		PO_6_ViewBagPage total = new PO_6_ViewBagPage(driver);
		Double addprice = price.getPrice();
		Double addtotal = total.getTotal();
		System.out.println("Total" + addtotal);
		Double totalExpextedPrize = (addprice * 2) + 2;
		System.out.println("final total" + totalExpextedPrize);
	}

	@Test(enabled=false,priority = 7)
	public void checkout() {
		PO_6_ViewBagPage chrckout_button = new PO_6_ViewBagPage(driver);
		chrckout_button.CheckOut();
	}
}
	

	/*
	 * P5_AddToCartPage_Views clickOnConinouShop = new
	 * P5_AddToCartPage_Views(driver); clickOnConinouShop.continouShoppingBtn();
	 * 
	 * /* P5_AddToCartPage_Views clickedOnViewCartpage = new
	 * P5_AddToCartPage_Views(driver); clickedOnViewCartpage.clickedOnViewCart();
	 */

	//--------------------------------


//	@Test(priority = 2)
//	public void Your_Cart() {
//		P6_ViewBagPage YourCartPage = new P6_ViewBagPage(driver);
//		YourCartPage.YourCartPage();
//	}

//	@Test(priority = 3)
//	public void quantity() {
//		P6_ViewBagPage quant = new P6_ViewBagPage(driver);
//		quant.Quantity();
//	}

//	@Test(priority = 4)
//	public void update_quantity() {
//		P6_ViewBagPage update_quant = new P6_ViewBagPage(driver);
//		update_quant.Update_Quantity();
//	}

//	@Test(priority = 5)
//	public void remove_product() throws InterruptedException {
//		P6_ViewBagPage remove = new P6_ViewBagPage(driver);
//		remove.RemoveProduct();
//
//	}

//	@Test(priority = 6)
//	public void ContinueShopping() {
//		P6_ViewBagPage continueshop = new P6_ViewBagPage(driver);
//		continueshop.ContinueShopping();
//
//	}

	/*
	 * @Test(priority=6) public void checkout() { P6_ViewBagPage chrckout_button =
	 * new P6_ViewBagPage(driver); chrckout_button.CheckOut(); }
	 */

	/*
	 * @Test(priority=5) public void Total() { P6_ViewBagPage price = new
	 * P6_ViewBagPage(driver); P6_ViewBagPage total = new P6_ViewBagPage(driver);
	 * Double addprice = price.getPrice(); Double addtotal= total.getTotal();
	 * System.out.println("Total"+addtotal); Double totalExpextedPrize =
	 * (addprice*2)+2; System.out.println("final total"+totalExpextedPrize); }
	 * 
	 * /*@Test public void Quantity_incres() { P6_AddToCart quantity = new
	 * P6_AddToCart(driver); quantity.Quantity(); }
	 */

	/*
	 * @AfterMethod public void close() { driver.close(); }
	 */
//------------------------------------------------------------------------------
	
//	@Test(priority=0)
//	public void VerifyAddCart() {
//		P6_ViewBagPage clickaddcartlogo = new P6_ViewBagPage(driver);
//		clickaddcartlogo.clickedOnImage();
//	}
	
	
//	@Test(priority=1)
//	public void BuyNow() {
//		P6_ViewBagPage buynow = new P6_ViewBagPage(driver);
//		buynow.ClickOnBuyNow();
//	}
	
/*	@Test(priority=2)
	 public void productDetailsInfo(){
		 P7_BuyNowPage info = new P7_BuyNowPage(driver);
		 info.BookInfo();
	 }*/
	 
//	 @Test(priority=2)
//	 public void quantity() {
//		 P6_ViewBagPage quant = new P6_ViewBagPage(driver);
//		 quant.Quantity();
//	 }
	 
//	 @Test(priority=3)
//	 public void update_quantity() {
//		 P6_ViewBagPage update_quant = new P6_ViewBagPage(driver);
//		 update_quant.Update_Quantity();
//	 }
	 
	 
	 
	
