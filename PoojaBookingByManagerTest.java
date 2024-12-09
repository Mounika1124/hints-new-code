package org.hints.testcases;

import org.hints.pages.BaseClass;

import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;

import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingByManagerPage;
import org.hints.pages.PoojaBookingPage;
import org.hints.pages.RegisterNewDevotee;
import org.hints.pages.VastraPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.github.javafaker.Faker;

public class PoojaBookingByManagerTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;
	VastraPage vastraPage;
	DonationPage donationPage;
	PoojaBookingByManagerPage poojaBooking;
	DevoteeCartPage devoteeCart;
	PoojaBookingPage poojaPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {

		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		vastraPage = PageFactory.initElements(driver, VastraPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		poojaBooking = PageFactory.initElements(driver, PoojaBookingByManagerPage.class);
		devoteeCart = PageFactory.initElements(driver, DevoteeCartPage.class);
		poojaPage = PageFactory.initElements(driver, PoojaBookingPage.class);

	}

	@Test(priority = 0, description = "Verify Successful inside pooja booking by manager", enabled = true)
	public void poojaBookingByManager() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.insidePoojaBookingByManager();
		devoteeCart.cartItemPayPalPayment();

	}

	@Test(priority = 1, description = "Verify Successful outside pooja booking by manager without priest", enabled = true)
	public void outsidePoojaBookingByManager() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.outsidePoojaBookingByManager();
		devoteeCart.cartItemManualReceipt();;
	}
	
	
	@Test(priority = 2, description = "Verify Successful outside pooja booking by manager with priest using cash", enabled = true)
	public void otPujaMgrWithPriestByCash() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemCashPayment();
	}
	

	@Test(priority = 3, description = "Verify Successful outside pooja booking by manager with priest using credit card", enabled = false)
	public void otPujaMgrWithPriestByCreditCard() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemCreditCardPayment();
	}
	
	@Test(priority = 4, description = "Verify Successful outside pooja booking by manager with priest using manual receipt", enabled = false)
	public void otPujaMgrWithPriestByManualReceipt() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemManualReceipt();
	}
	
	@Test(priority = 5, description = "Verify Successful outside pooja booking by manager with priest using coin", enabled = false)
	public void otPujaMgrWithPriestByCoin() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemCoin();
	}
	
	@Test(priority = 6, description = "Verify Successful outside pooja booking by manager with priest using direct deposit", enabled = false)
	public void otPujaMgrWithPriestByDirectDeposit() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemDirectDeposit();
	}
	
	@Test(priority = 7, description = "Verify Successful outside pooja booking by manager with priest using check", enabled = false)
	public void otPujaMgrWithPriestByCheck() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemCheckPayment();
	}
	
	@Test(priority = 8, description = "Verify Successful outside pooja booking by manager with priest using Paypal", enabled = false)
	public void otPujaMgrWithPriestByPaypal() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.navigateToPoojaBookingMenu();
		poojaBooking.bookOutsidePoojawithPriest();
		devoteeCart.cartItemPayPalPayment();
	}
	

//	@Test(priority = 9, description = "Verify Successful pooja booking by manager", enabled = true)
//	public void pattuSareeOwnReturn() throws Exception {
//		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
//		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
//		loginPage.managerLogin_Valid(uname, pwd);
//		poojaBooking.PoojaBokingByManager();
//		devoteeCart.cartItemCashPayment();
//	}
	@Test(priority = 10, description = "Verify Pooja Booking with Deities", enabled = true)
	public void PoojaBookingwithDeities() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		poojaBooking.DeitiesbyManager();
		devoteeCart.cartItemCashPayment();

	}
	
	

}