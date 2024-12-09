package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DonationPage;
import org.hints.pages.HallBookingPage;
import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingPage;
import org.hints.pages.RegisterNewDevotee;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class HallBookingTest extends BaseClass {

	LoginPage loginpage;
	RegisterNewDevotee RegDevotee;
	public ExtentReports extent;
	public ExtentTest extentTest;
	DonationPage donationPage;
	HallBookingPage hallPage;

	@BeforeMethod
	public void Initsetup() {
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		RegDevotee = PageFactory.initElements(driver, RegisterNewDevotee.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		hallPage = PageFactory.initElements(driver, HallBookingPage.class);
	}

	@Test(priority = 1, description = "Verify Successful hall booking", enabled = true)
	public void HallBooking() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		hallPage.bookHall();

	}

}
