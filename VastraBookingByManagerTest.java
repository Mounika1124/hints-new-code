package org.hints.testcases;

import org.hints.pages.BaseClass;

import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.LoginPage;
import org.hints.pages.VastraBookingByManagerPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class VastraBookingByManagerTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;
	VastraBookingByManagerPage vastraBookingByManagerPage;
	DonationPage donationPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		vastraBookingByManagerPage = PageFactory.initElements(driver, VastraBookingByManagerPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

	}

	@Test(priority = 0, description = "Verify Successful pattusaree booking with own and return options", enabled = true)
	public void pattuSareeOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnPattuSareeForReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemPayPalPayment();

	}

	@Test(priority = 1, description = "Verify Successful pattusaree booking with own and noreturn options", enabled = false)
	public void pattuSareeOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnPattuSareeForNoReturn();
		vastraBookingByManagerPage.purchase();
		vastraBookingByManagerPage.makecreditCardPayment();
		devoteeCartPage.cartItemCheckPayment();

	}

	@Test(priority = 2, description = "Verify Successful pattusaree booking with Temple and return options", enabled = false)
	public void pattuSareeOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTemplePattuSareeForReturn();
		vastraBookingByManagerPage.purchase();
		vastraBookingByManagerPage.makecreditCardPayment();
		devoteeCartPage.cartItemCoin();

	}

	@Test(priority = 3, description = "Verify Successful pattusaree booking with Temple and no return options", enabled = false)
	public void pattuSareeOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTemplePattuSareeForNoReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemDirectDeposit();

	}

	@Test(priority = 4, description = "Verify Successful melchat booking with own and return options", enabled = false)
	public void melchatOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnMelchatForReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemPayPalPayment();

	}

	@Test(priority = 5, description = "Verify Successful Melchat booking with own and noreturn options", enabled = false)
	public void MelchatOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnMelchatForNoReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemManualReceipt();

	}

	@Test(priority = 6, description = "Verify Successful Melchat booking with Temple and return options", enabled = false)
	public void MelchatOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTempleMelchatForReturn();
		vastraBookingByManagerPage.purchase();
		// devoteeCartPage.cartItemCreditCardPayment();

	}

	@Test(priority = 7, description = "Verify Successful Melchat booking with Temple and no return options", enabled = false)
	public void MelchatOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTempleMelchatForNoReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemCreditCardPayment();

	}

	@Test(priority = 8, description = "Verify Successful Dhoti booking with own and return options", enabled = false)
	public void DhotiOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnDhotiForReturn();
		vastraBookingByManagerPage.purchase();
		devoteeCartPage.cartItemCreditCardPayment();

	}

	@Test(priority = 9, description = "Verify Successful Dhoti booking with own and noreturn options", enabled = false)
	public void DhotiOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectOwnDhotiForNoReturn();
		vastraBookingByManagerPage.purchase();
		vastraBookingByManagerPage.makecreditCardPayment();
		donationPage.enterCreditCardPaymentDetails();

	}

	@Test(priority = 10, description = "Verify Successful Dhoti booking with Temple and return options", enabled = false)
	public void DhotiOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTempleDhotiForReturn();
		vastraBookingByManagerPage.purchase();
		vastraBookingByManagerPage.makecreditCardPayment();
		donationPage.enterCreditCardPaymentDetails();

	}

	@Test(priority = 11, description = "Verify Successful Dhoti booking with Temple and no return options", enabled = false)
	public void DhotiOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		vastraBookingByManagerPage.selectVastraMenuByManager();
		vastraBookingByManagerPage.selectTempleDhotiForNoReturn();
		vastraBookingByManagerPage.purchase();
		vastraBookingByManagerPage.makecreditCardPayment();
		donationPage.enterCreditCardPaymentDetails();

	}

}
