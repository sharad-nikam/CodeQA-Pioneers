package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_2_Ui_HomepageObjectModel;

public class TC_2_UiHomePage extends TC_1_BaseURl_HandleNewspopup {

	// @Test(priority=0)
	// public void utkarshAdd(){
	// UI_HomepageObjectModel utkarsh = new UI_HomepageObjectModel(driver);
	// utkarsh.clickonUtkarshAdd();
	// }

	@Test(enabled = true, priority = 0)
	public void A_LaunchedBaseURL() throws Exception {

		driver.get(url);
		System.out.println("Getting Base URL on Browser");
		System.out.println("Verifying ....Base URL is Opened or not on browser....");
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

	@Test(priority = 1)
	public void verifybookbtn() {
		PO_2_Ui_HomepageObjectModel Gk = new PO_2_Ui_HomepageObjectModel(driver);
		Gk.clickonGkbooks();
		boolean bFlag = Gk.VerifyonGkbooks();
		Assert.assertTrue(bFlag);
		System.out.println("Verify Gkbook successful");
	}

	@Test(priority = 2)
	public void currentAffairs() {
		PO_2_Ui_HomepageObjectModel current = new PO_2_Ui_HomepageObjectModel(driver);
		current.clickonCurrentAffairs();
		boolean bFlag = current.VerifyonCurrentAffairs();
		Assert.assertTrue(bFlag);
		System.out.println("Verify currentAffaires book successful");

	}

	@Test(priority = 3)
	public void drishti() {

		PO_2_Ui_HomepageObjectModel c = new PO_2_Ui_HomepageObjectModel(driver);
		c.clickondrishti();
		boolean bFlag = c.Verifydrishti();
		Assert.assertTrue(bFlag);
		System.out.println("Verify drithti book successful");
	}

	@Test(priority = 4)
	public void maheshkumar() {
		PO_2_Ui_HomepageObjectModel d = new PO_2_Ui_HomepageObjectModel(driver);
		d.clickonMaheshKumar();

		String ActualTitle = driver.getTitle();
		String expectedTitle = "MAHESH KUMAR BARNWAL";
		Assert.assertEquals(ActualTitle, expectedTitle, "title  match");
		System.out.println("Verified MAHESH KUMAR BARNWAL book successfull");
	}

	@Test(priority = 5)
	public void thevision() {

		PO_2_Ui_HomepageObjectModel e = new PO_2_Ui_HomepageObjectModel(driver);
		e.clickonDristiThevision();

		String ActualTitle = driver.getTitle();
		String expectedTitle = "Buy Online Drishti The Vision books latest edition quick books series ras series ncert books sets mains capsule series RAS exam series";
		Assert.assertEquals(ActualTitle, expectedTitle, "title  match");
		System.out.println("Verified Buy Online Drishti The Vision books successfull");
	}

	@Test(priority = 6)
	public void whatsappIcon() {
		PO_2_Ui_HomepageObjectModel f = new PO_2_Ui_HomepageObjectModel(driver);
		f.clickOnwhatsappIcon();
		System.out.println("Verified Share on WhatsApp successfull");

		String ActualTitle = driver.getTitle();
		String expectedTitle = "Share on WhatsApp";
		Assert.assertEquals(ActualTitle, expectedTitle, "title  match");
		driver.navigate().back();
	}
}

