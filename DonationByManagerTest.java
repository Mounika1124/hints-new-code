package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.HomePage;
import org.hints.pages.LoginPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.ParseException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class DonationByManagerTest extends BaseClass {
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;
	DonationPage donationPage;
	DevoteeCartPage devoteeCartPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

	}

	@Test(priority = 1, description = "Verify Successful Donation by Manager", enabled = true)
	public void navigateToDonationFromDevoteeService() throws Exception {
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(managerUname, managerPwd);
		donationPage.navigateToDonationFromDevoteeService();
		devoteeCartPage.cartItemCreditCardPayment();

	}

}
