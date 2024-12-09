package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.DonorAdvisoryFundsPage;
import org.hints.pages.LoginPage;
import org.hints.pages.MatchingDonationsPage;
import org.hints.pages.VastraPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class DonorAdvisoryFundsTest extends BaseClass {
	
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;
	VastraPage vastraPage;
	DonationPage donationPage;
	MatchingDonationsPage matchingdonationsPage;
	DonorAdvisoryFundsPage donoradvisoryfundsPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod (alwaysRun=true)
	public void Initsetup() {
		
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		//vastraPage =PageFactory.initElements(driver, VastraPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		matchingdonationsPage =PageFactory.initElements(driver, MatchingDonationsPage.class);
		donoradvisoryfundsPage =PageFactory.initElements(driver, DonorAdvisoryFundsPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);
		
		}

	@Test(priority=0, description= "Verify Donor Advisory Funds with CreditCard payment	", enabled=true )
	public void donorAdvisoryWithCreditCardMode() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemCreditCardPayment();
		
	}
	
	@Test(priority=1, description= "Verify Donor Advisory Funds with cash", enabled=true )
	public void donorAdvisoryWithCash() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemCashPayment();
		
	}
	
	@Test(priority=2, description= "Verify Donor Advisory Funds with PayPal", enabled=true )
	public void donorAdvisoryWithPayPal() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemPayPalPayment();
		
	}
	
	
	@Test(priority=3, description= "Verify Donor Advisory Funds with Manual Receipt", enabled=true )
	public void donorAdvisoryWithManualReceipt() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemManualReceipt();
		
	}
	
	@Test(priority=4, description= "Verify Donor Advisory Funds with Coin", enabled=false )
	public void donorAdvisoryWithCoin() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemCoin();
		
	}
	
	@Test(priority=5, description= "Verify Donor Advisory Funds with Check Payment", enabled=false )
	public void donorAdvisoryWithCheckPayment() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemCheckPayment();
		
	}
	
	@Test(priority=6, description= "Verify Donor Advisory Funds with direct deposit", enabled=false )
	public void donorAdvisoryWithDirectDeposit() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(uname, pwd);
		donoradvisoryfundsPage.searchDevotee();
		donoradvisoryfundsPage.navigateToDonorAdvisory();
		devoteeCartPage.cartItemDirectDeposit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	














}


