package org.hints.pages;

import java.io.IOException;

import org.hints.utility.BrowserSetup;
import org.hints.utility.ConfigDataProvider;
import org.hints.utility.DataProviderFactory;
import org.hints.utility.GenerateReports;
import org.hints.utility.Utility;
import org.hints.utility.Logging;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class BaseClass {

	public static WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	protected Utility util;
	protected ConfigDataProvider testData;
	public static ExtentReporter htmlReporter;
	public static GenerateReports reports;
	// Configure Log4j to perform error logging

	@BeforeSuite
	public void setup() {
		System.out.println("Extent report is getting started");

		// report=new ExtentReports();

		// ExtentHtmlReporter html=new
		// ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\hints+"+Utility.getCurrentDateTime()+".html");

		// report.attachReporter(html);

		System.out.println("Extent report is ready to use ");

	}

	@BeforeTest
	public void initialTestSetup() {
		System.out.println("inside @BeforeTest initialTestSetup method");
		reports = GenerateReports.getInstance();
	}

	// @Parameters({"browser","url"})
	@Parameters("browserName")
	@BeforeClass
	// public void setup(String browser, String url)
	public void setupBrowser() {

		Reporter.log("LOG: INFO : Creating browser instances", true);

		driver = BrowserSetup.startApplication(driver, DataProviderFactory.getConfig().getValue("browser"),
				DataProviderFactory.getConfig().getValue("loginurl"));

		// driver=new BrowserSetup().startApplication(browser,url);

		util = new Utility(driver, 30);

		Reporter.log("LOG: INFO : Browser instance is ready ", true);

	}

	@BeforeMethod
	public void openingUrl() {
		Reporter.log("LOG: INFO : Creating browser instances", true);

		driver = BrowserSetup.startApplication(driver, DataProviderFactory.getConfig().getValue("browser"),
				DataProviderFactory.getConfig().getValue("loginurl"));

		// driver=new BrowserSetup().startApplication(browser,url);

		util = new Utility(driver, 30);

		Reporter.log("LOG: INFO : Browser instance is ready ", true);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		System.out.println("Driver value in after method is " + driver);

		System.out.println("Runnisng After method Test executed with below status");

		System.out.println("Status value " + result.getStatus());

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("LOG : PASS User is able to login");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("LOG : FAIL Test failed to executed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("LOG : SKIP Test did not executed");
		}
		BrowserSetup.closeBrowser(driver);

		// Quit the driver after each test method

		// report.flush();

	}

	@AfterClass
	public void tearDown() {

		Reporter.log("LOG: INFO : Closing browser instances", true);

		BrowserSetup.closeBrowser(driver);

		Reporter.log("LOG: INFO : Browser instances closed", true);

	}

	@AfterTest
	public void finalTestTearDown() {

		System.out.println("@afterTest started");
		driver.quit();

		// BrowserSetup.closeBrowser(driver);
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}
}
