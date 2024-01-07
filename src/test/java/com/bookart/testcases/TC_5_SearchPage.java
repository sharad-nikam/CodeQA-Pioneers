package com.bookart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bookart.pagesobjects.PO_5_SearchPageobj;

public class TC_5_SearchPage extends TC_0_Setup {

	@Test
	public void verifySearchPage() throws InterruptedException {

		PO_5_SearchPageobj sb = new PO_5_SearchPageobj(driver);
		sb.searchbox();
		sb.sendvalue("Drishti Current Affairs Today June 2023 ank 96");
		sb.clickonsearchbox();
		Thread.sleep(1000);
		sb.verifygetstatus();
		Thread.sleep(1000);
		// sb.sendvalue1("ABCDEFG");
		Thread.sleep(1000);
		// sb.clickonsearchbox1();
		Thread.sleep(1000);
		// sb.verifygetstatus1();
		Thread.sleep(1000);
		String search_result_match = "Search Results on \"";
		Assert.assertEquals(search_result_match, sb.verifygetstatus());

		// String errormessage1="Sorry, no products matched your search criteria. Please
		// refine your search term and try again..";
		// Assert.assertEquals(errormessage1, sb.verifygetstatus1());

	}
}
