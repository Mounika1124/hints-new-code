package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.HallBookingByManagerPage;
import org.hints.pages.HallBookingPage;
import org.hints.pages.HomePage;
import org.hints.pages.LadduKarasevMenuPage;
import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class HallBookingByManagerTest extends BaseClass {
	
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;
	DonationPage donationPage;
	PoojaBookingPage poojaPage;
	HallBookingByManagerPage hallBookingPageByManager;
	DevoteeCartPage devoteeCartPage;
	
	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		poojaPage = PageFactory.initElements(driver, PoojaBookingPage.class);
		hallBookingPageByManager = PageFactory.initElements(driver, HallBookingByManagerPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);
	}

	@Test(enabled = true, description = "Verify Manager can bbok hall for the devotee successfully", groups = {
			"Smoke" })
	public void verifyHallBookingByManager() throws Exception {
		// Login as manager
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(managerUname, managerPwd);
		hallBookingPageByManager.navigateToHallRentalMenu();
		hallBookingPageByManager.bookHallByManager();
		//devoteeCartPage.cartItemCreditCardPayment();

	}

}
