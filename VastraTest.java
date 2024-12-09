package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;

import org.hints.pages.LoginPage;
import org.hints.pages.RegisterNewDevotee;
import org.hints.pages.VastraPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.github.javafaker.Faker;

public class VastraTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;
	VastraPage vastraPage;
	DonationPage donationPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {

		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		vastraPage = PageFactory.initElements(driver, VastraPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

	}

	@Test(priority = 0, description = "Verify Successful pattusaree booking with own and return options", enabled = false)
	public void pattuSareeOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnPattuSareeForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();
	}

	@Test(priority = 1, description = "Verify Successful pattusaree booking with own and noreturn options", enabled = false)
	public void pattuSareeOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnPattuSareeForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 2, description = "Verify Successful pattusaree booking with Temple and return options", enabled = false)
	public void pattuSareeOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTemplePattuSareeForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 3, description = "Verify Successful pattusaree booking with Temple and no return options", enabled = false)
	public void pattuSareeOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTemplePattuSareeForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 4, description = "Verify Successful melchat booking with own and return options", enabled = true)
	public void melchatOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnMelchatForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();
	}

	@Test(priority = 5, description = "Verify Successful Melchat booking with own and noreturn options", enabled = true)
	public void MelchatOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnMelchatForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 6, description = "Verify Successful Melchat booking with Temple and return options", enabled = true)
	public void MelchatOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTempleMelchatForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 7, description = "Verify Successful Melchat booking with Temple and no return options", enabled = true)
	public void MelchatOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTempleMelchatForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 8, description = "Verify Successful Dhoti booking with own and return options", enabled = true)
	public void DhotiOwnReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnDhotiForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();
	}

	@Test(priority = 9, description = "Verify Successful Dhoti booking with own and noreturn options", enabled = true)
	public void DhotiOwnNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectOwnDhotiForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

	}

	@Test(priority = 10, description = "Verify Successful Dhoti booking with Temple and return options", enabled = true)
	public void DhotiOwnTempleReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTempleDhotiForReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();
	}

	@Test(priority = 11, description = "Verify Successful Dhoti booking with Temple and no return options", enabled = true)
	public void DhotiOwnTempleNoReturn() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		vastraPage.selectVastraMenu();
		vastraPage.selectTempleDhotiForNoReturn();
		vastraPage.purchase();
		devoteeCartPage.cartItemCreditCardPaymentFromDevotee();

//	}

	}
}
