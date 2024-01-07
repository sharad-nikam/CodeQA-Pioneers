package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_8_CheckoutBilling_Payment_ConfirmOrder;

public class TC_8_CheckoutBilling_Payment_ConfirmOrder_test extends TC_0_Setup{

	
	@Test(priority = 0)
	public void AddingElementToCart() {
		PO_8_CheckoutBilling_Payment_ConfirmOrder cart = new PO_8_CheckoutBilling_Payment_ConfirmOrder(driver);

		cart.click_addcart();

		boolean bflag = cart.verifyelementaddingcart();
		Assert.assertTrue(bflag);

		System.out.println("Product added into a cart");

		cart.checkoutbtn_click();
		System.out.println("clicked on checkout button");
	}
		
	@Test(priority = 1)
	public void BillingAndShippingPage() throws InterruptedException {
		PO_8_CheckoutBilling_Payment_ConfirmOrder billing = new PO_8_CheckoutBilling_Payment_ConfirmOrder(driver);

		System.out.println("billing name checkout initeate");

		boolean flag = billing.billingpagedisplay();
		Assert.assertTrue(flag);
		System.out.println("billing name checkout complited");

		billing.BillingAndShippingdata();
		System.out.println("data felling completed");

	}
		
//		@Test(priority=2)
//		public void PaymentOptionswithcoupencode() {
//		 P5_CheckoutBilling_Payment_ConfirmOrder Payment = new P5_CheckoutBilling_Payment_ConfirmOrder(driver);
//		 Payment.PymentOptionsUsingCoupen();
//		
//		}	
		
	@Test(priority = 3)
	public void PaymentOptionsPageWithoutoupencode() throws InterruptedException {
		PO_8_CheckoutBilling_Payment_ConfirmOrder Payment = new PO_8_CheckoutBilling_Payment_ConfirmOrder(driver);
		Payment.PymentOptions();

	}

	@Test(priority = 4)
	public void ReviewAndConfirmPage() throws InterruptedException {
		PO_8_CheckoutBilling_Payment_ConfirmOrder Review = new PO_8_CheckoutBilling_Payment_ConfirmOrder(driver);
		Review.ReviewandConfirm();
	}

	@Test(priority = 5)
	public void ConfirmOrderpage() throws InterruptedException {
		PO_8_CheckoutBilling_Payment_ConfirmOrder Confirm = new PO_8_CheckoutBilling_Payment_ConfirmOrder(driver);
		Confirm.OrderConfirm();
	}
}