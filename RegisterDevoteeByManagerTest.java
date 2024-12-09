package org.hints.testcases;

import org.testng.annotations.Test;

import org.hints.pages.BaseClass;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.hints.pages.LoginPage;
import org.hints.pages.PoojaBookingPage;
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
import com.github.javafaker.Faker;

public class RegisterDevoteeByManagerTest extends BaseClass {

	LoginPage loginpage;
	RegisterNewDevotee RegDevotee;
	public ExtentReports extent;
	public ExtentTest extentTest;
	DonationPage donationPage;
	PoojaBookingPage poojaPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod
	public void Initsetup() {
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		RegDevotee = PageFactory.initElements(driver, RegisterNewDevotee.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		poojaPage = PageFactory.initElements(driver, PoojaBookingPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

	}

	@Test(priority = 1, description = "Verify manager can create devotee successfully", enabled = true, groups = {
			"Smoke" })

	public void verifyManagerCreatesDevotee() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("manager_uname");
		String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginpage.managerLogin_Valid(uname, pwd);
		RegDevotee.navigateToRegisterDevoteeMenu();
		Faker faker = new Faker();
		String fName = faker.name().firstName();
		String mName = faker.name().lastName();
		String lName = faker.name().lastName();
		String address = faker.address().fullAddress();
		String email = DataProviderFactory.getConfig().getValue("regEmail");
		String zip = DataProviderFactory.getConfig().getValue("regZip");
		String username = faker.name().username();
		String addressField = faker.address().fullAddress();
		RegDevotee.devoteeRegisterByManager(fName, lName, mName, zip, email, username, addressField);
	}

}

//package org.hints.testcases;
//
//public class RegisterDevoteeByManagerTest 
//{
//
//}
