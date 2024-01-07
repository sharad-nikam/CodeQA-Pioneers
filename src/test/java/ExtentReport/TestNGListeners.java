package ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.bookart.testcases.TC_1_BaseURl_HandleNewspopup;


public class TestNGListeners extends TC_1_BaseURl_HandleNewspopup implements ITestListener {
	
	ExtentReports report= ExtentReportGenerater.configureExtentReport();// call extent report
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String testname=result.getName();
		test=report.createTest(testname);
		test.log(Status.INFO, testname+"execution started");
		
	}
//--------------------------------------
	
	public void onTestSuccess(ITestResult itresult) {
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of Passed Test Case is: " + itresult.getName(), ExtentColor.GREEN));
	}

	private String takeScreenShot(WebDriver driver, String testname) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile,
					new File("src/../captureScreenShots/" + testname + System.currentTimeMillis() + ".png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return srcFile.getAbsolutePath();

	}

	public void onTestFailure(ITestResult itresult) {
		String testname = itresult.getName();
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of Failed Test Case is: " + itresult.getName(), ExtentColor.RED));
		test.log(Status.INFO, itresult.getThrowable());

		// for taking screenshot we need driver so take driver from that failed test
		// case
		try {
			driver = (WebDriver) itresult.getTestClass().getRealClass().getDeclaredField("driver")
					.get(itresult.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| NullPointerException e) {
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(takeScreenShot(driver, testname));

	}

	public void onTestSkipped(ITestResult itresult) {
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of Skip Test Case is: "+itresult.getName(), ExtentColor.YELLOW));
		test.log(Status.INFO, itresult.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult itr) {
		
	}

	public void onFinish(ITestContext ctx) {
		System.out.println("Test execution Completed :"+ctx.getName());
		report.flush(); 
		
		
		// to open report automatically on browser
		File reportFile= new File(System.getProperty("user.dir")+"./target/extentReport.html");
		try {
			Desktop.getDesktop().browse(reportFile.toURI());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
