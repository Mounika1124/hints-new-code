package org.hints.testcases;

import org.testng.annotations.Test;
import org.hints.pages.BaseClass;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingByManagerPage;
import org.hints.pages.PoojaBookingPage;
import org.hints.pages.RefundPage;
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

public class RefundTest extends BaseClass {

	LoginPage loginpage;
	RegisterNewDevotee RegDevotee;
	public ExtentReports extent;
	public ExtentTest extentTest;
	DonationPage donationPage;
	PoojaBookingByManagerPage poojaBooking;
	DevoteeCartPage devoteeCartPage;
	RefundPage refundPage;

	@BeforeMethod
	public void Initsetup() {
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		RegDevotee = PageFactory.initElements(driver, RegisterNewDevotee.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		poojaBooking = PageFactory.initElements(driver, PoojaBookingByManagerPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);
		refundPage =  PageFactory.initElements(driver, RefundPage.class);
	}
	@Test(priority = 1, description = "Verify Refund", enabled = true, groups = {
	"Smoke" })
	public void verifyRefund() throws Exception {		

		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		
		String checknumber = DataProviderFactory.getConfig().getValue("checknumber");
		String reasonforrefund = DataProviderFactory.getConfig().getValue("reasonforrefund");
		
		poojaBooking.PoojaBokingByManager();
		devoteeCartPage.cartItemCashPayment();
		refundPage.Recepitnumber();	
		refundPage.Refund(checknumber,reasonforrefund);
	}
	
	@Test(priority = 2, description = "Verify Increase Refund", enabled = true, groups = {
	"Smoke" })
	public void verifyIncreaseRefund() throws Exception {
		
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		
		String checknumber = DataProviderFactory.getConfig().getValue("checknumber");
		String reasonforrefund = DataProviderFactory.getConfig().getValue("reasonforrefund");
		
		poojaBooking.PoojaBokingByManager();
		devoteeCartPage.cartItemCashPayment();
		refundPage.Recepitnumber();	
		refundPage.IncreaseRefund(checknumber,reasonforrefund);	
	}
	
	@Test(priority = 3, description = "Verify Decrease Refund", enabled = true, groups = {
	"Smoke" })
	public void verifyDecreaseRefund() throws Exception {
		
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		
		String checknumber = DataProviderFactory.getConfig().getValue("checknumber");
		String reasonforrefund = DataProviderFactory.getConfig().getValue("reasonforrefund");
		
		poojaBooking.PoojaBokingByManager();
		devoteeCartPage.cartItemCashPayment();
		refundPage.Recepitnumber();	
		refundPage.DecreaseRefund(checknumber,reasonforrefund);
	}
}
