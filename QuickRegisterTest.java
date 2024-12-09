package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DonationPage;
import org.hints.pages.HomePage;
import org.hints.pages.LoginPage;
import org.hints.pages.QuickRegisterPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

public class QuickRegisterTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;
	DonationPage donationPage;
	QuickRegisterPage quickregisterPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
		quickregisterPage = PageFactory.initElements(driver, QuickRegisterPage.class);
	}

	@Test(priority = 1, description = "Verify successful user creation through quick register", enabled = true)
	public void verifyQuickRegisterCreation() throws Exception {

		Faker faker = new Faker();
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginPage.managerLogin_Valid(managerUname, managerPwd);
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = DataProviderFactory.getConfig().getValue("email");
		String signInNametext = DataProviderFactory.getConfig().getValue("signInNametext");
		quickregisterPage.quickRegister(firstName, lastName, email, signInNametext);

	}

}
