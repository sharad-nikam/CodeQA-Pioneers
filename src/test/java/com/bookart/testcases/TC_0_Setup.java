package com.bookart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bookart.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_0_Setup {
	
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String email =readConfig.getSigninEmail();
	String password = readConfig.getSigninPassword();
	

	 public static WebDriver driver;
	 public static Logger logger;

	@BeforeClass
	public void setup() throws Exception {

		// Launch Browser
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if(browser.equals("Firefox")){
	//		System.setProperty("webdriver.gecko.driver",FIREFOXDRIVERPATH);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		
		// for Logging tha all Test cases
		// intialize logger
		logger = LogManager.getLogger("BoookartWeb");
		logger.info("The WebDriver Sesssion Starts successfully.");
				
		// Maximized the Browser Window
		driver.manage().window().maximize();
		logger.info("Window is Maximized successfullly.");
		// Geeting Url on Browser
		driver.get(url);
		logger.info("Getting a Base URL on Browser");
		
	}


	@AfterClass
	public void exit() {
		driver.quit();
	}
}
