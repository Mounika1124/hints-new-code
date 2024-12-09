package org.hints.testcases;

import org.testng.annotations.Test;

import org.hints.pages.BaseClass;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingPage;
import org.hints.pages.LadduKarasevMenuPage;
import org.hints.pages.DonationPage;

import org.hints.pages.RegisterNewDevotee;
import org.hints.utility.BrowserSetup;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.github.javafaker.Faker;

public class LadduKarasevMenuTest extends BaseClass {

	LoginPage loginpage;
	RegisterNewDevotee RegDevotee;
	public ExtentReports extent;
	public ExtentTest extentTest;
	DonationPage donationPage;
	PoojaBookingPage poojaPage;
	LadduKarasevMenuPage ladduKarasevMenuPage;;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod
	public void Initsetup() {
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		RegDevotee = PageFactory.initElements(driver, RegisterNewDevotee.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		poojaPage = PageFactory.initElements(driver, PoojaBookingPage.class);
		ladduKarasevMenuPage = PageFactory.initElements(driver, LadduKarasevMenuPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);
	}

	@Test(priority = 1, enabled = false, description = "Verify Devotee can purchase the Prasadam successfully", groups = {
			"Smoke" })
	public void verifyPurchasePrasadam() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		ladduKarasevMenuPage.addPrasadamItemToCart();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 2, enabled = false, description = "Verify Devotee can purchase the calendar successfully", groups = {
			"Smoke" })
	public void verifyPurchaseCalendar() throws Exception {

		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		ladduKarasevMenuPage.addCalendarToCart();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();
//		devoteeCartPage.checkPaymentSuccess();
	}

}