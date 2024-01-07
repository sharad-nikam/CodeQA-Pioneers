package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_7_AddtoCart_PageObject;

public class TC_7_AddtoCart_Test extends TC_0_Setup {


	@Test(priority=1)
	public void addCart() {
		PO_7_AddtoCart_PageObject book = new PO_7_AddtoCart_PageObject(driver);
		book.Cart();
		boolean bflag = book.VerifyCartElement();
		Assert.assertTrue(bflag);
		System.out.println("Product Successfully added to the cart");
		book.closeCart();

	}

	@Test(priority=2)
	public void addmultipleCart() throws InterruptedException  {
		PO_7_AddtoCart_PageObject book1 = new PO_7_AddtoCart_PageObject(driver);
		book1.MultipleIteamsAddCart();

		boolean bflag1 = book1.VerifyMultipleCartElement();

		Assert.assertTrue(bflag1);
		System.out.println("Multiple Products are Successfully added to the cart");

	}

	@Test(priority=3)
	public void outOfStock() {

		PO_7_AddtoCart_PageObject outofst = new PO_7_AddtoCart_PageObject(driver);

		boolean bflag2 = outofst.soldOut();

		Assert.assertFalse(bflag2,"Sold Out Button is not Disabled");
//--------
		System.out.println("Out of Stock Method Executed Successfully");


	}

	@Test(priority=4)
	public void removeIteam() {
		PO_7_AddtoCart_PageObject remove = new PO_7_AddtoCart_PageObject(driver);
		boolean bflag = remove.removeIteamfromCart();
		Assert.assertTrue(bflag);
		System.out.println("Iteam Successfully Removed from Cart");

	}

	@Test(priority=5)
	public void emptyCart() throws InterruptedException {
		PO_7_AddtoCart_PageObject empty = new PO_7_AddtoCart_PageObject(driver);
		boolean bflag = empty.emptyCart();
		Assert.assertTrue(bflag);
		System.out.println("Cart emptying successful");
	}


//	@AfterMethod
//	public void tearDown() {
//        if (driver != null) {
//
//		driver.close();
//        }
//	}

}



