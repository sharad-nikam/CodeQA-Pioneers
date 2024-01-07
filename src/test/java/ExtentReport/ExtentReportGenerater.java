package ExtentReport;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerater {
	
	public static WebDriver driver;
	public static ExtentReports configureExtentReport() {
		
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/extentReport.html");
		report.attachReporter(spark);
		
		// system information to report
		report.setSystemInfo("Machine", "PC1");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("User", "Atul");
		
		// configure look and feel to report
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MyReport");
		
		return report;
	}
}
