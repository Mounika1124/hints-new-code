package org.hints.testcases;

import java.text.ParseException;

import org.hints.pages.BaseClass;

import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
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

public class LadduKaraByManagerTest extends BaseClass {
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;
	DonationPage donationPage;
	PoojaBookingPage poojaPage;
	LadduKarasevMenuPage ladduKarasevMenuPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		poojaPage = PageFactory.initElements(driver, PoojaBookingPage.class);
		ladduKarasevMenuPage = PageFactory.initElements(driver, LadduKarasevMenuPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);
	}

	@Test(enabled = false, description = "Verify Manager can purchase Prasadam for the devotee successfully", groups = {
			"Smoke" })
	public void verifyManagerPrasadamPurchaseForDevotee() throws Exception {
		// Login as manager
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(managerUname, managerPwd);
		ladduKarasevMenuPage.navigateToLadduKaravadaMenu();
		ladduKarasevMenuPage.addPrasadamToCartFromDevoteeService();
		devoteeCartPage.cartItemManualReceipt();

	}

	@Test(enabled = true, description = "Verify Manager can purchase calendar for the devotee successfully", groups = {
			"Smoke" })
	public void verifyManagerCalendarPurchaseForDevotee() throws Exception {
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(managerUname, managerPwd);
		ladduKarasevMenuPage.navigateToLadduKaravadaMenu();
		ladduKarasevMenuPage.addCalendarToCartFromDevoteeService();
		devoteeCartPage.cartItemDirectDeposit();
	}

}
