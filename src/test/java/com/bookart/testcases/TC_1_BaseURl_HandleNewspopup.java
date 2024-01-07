package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import com.bookart.pagesobjects.PO_1_PopupHandle;
import com.bookart.utilities.ReadConfig;

public class TC_1_BaseURl_HandleNewspopup extends TC_0_Setup {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();

	@Test(enabled = true, priority = 0)
	public void TC_Verify_LaunchedBaseURL() throws Exception {
		logger.info("*********TestCase1-Verify-Launched-BaseURL Start ********");
		driver.navigate().to(url);
		logger.info("Verifying ....Home Page URL is Opened or not on browser....");
		Assert.assertEquals(driver.getCurrentUrl(), url);
		logger.info("********TestCase1-Verify-LaunchedBaseURL End********");
	//	Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 1)
	public void TC_Verify_to_HandleNewsletterPopup() {

		logger.info("********* TestCase2-Verify-NewsletterPopup Start ********");
		// NewsLetterPopup handle
		PO_1_PopupHandle popupnews = new PO_1_PopupHandle(driver);
		popupnews.newsLetterPopup();
		logger.info("******** TestCase2-Verify-NewsletterPopup End ********");
	}
}
