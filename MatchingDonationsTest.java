package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.LoginPage;
import org.hints.pages.MatchingDonationsPage;
import org.hints.pages.VastraPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class MatchingDonationsTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;
	VastraPage vastraPage;
	DonationPage donationPage;
	MatchingDonationsPage matchingdonationsPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {

		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		// vastraPage =PageFactory.initElements(driver, VastraPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		matchingdonationsPage = PageFactory.initElements(driver, MatchingDonationsPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

	}

	@Test(priority = 0, description = "Verify matching donations with CreditCard payment	", enabled = false)
	public void matchingDonationsWithCreditCardMode() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemCreditCardPayment();
	}

	@Test(priority = 1, description = "Verify matching donations Funds with cash", enabled = false)
	public void matchingDonationsWithCash() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemCashPayment();

	}

	@Test(priority = 2, description = "Verify matching donations Funds with PayPal", enabled = false)
	public void matchingDonationsWithPayPal() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemPayPalPayment();

	}

	@Test(priority = 3, description = "Verify matching donations Funds with Manual Receipt", enabled = true)
	public void matchingDonationsWithManualReceipt() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemManualReceipt();

	}

	@Test(priority = 4, description = "Verify matching donations Funds with Coin", enabled = false)
	public void matchingDonationsWithCoin() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemCoin();

	}

	@Test(priority = 5, description = "Verify matching donations Funds with Check Payment", enabled = false)
	public void matchingDonationsWithCheckPayment() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemCheckPayment();

	}
	
	@Test(priority=6, description= "Verify matching donations Funds with direct deposit", enabled=false )
	public void matchingDonationsWithDirectDeposit() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		matchingdonationsPage.searchDevotee();
		matchingdonationsPage.navigateToMatchingdonations();
		devoteeCartPage.cartItemDirectDeposit();
		
	}

}
