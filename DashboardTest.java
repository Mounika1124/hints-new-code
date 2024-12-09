package org.hints.testcases;

import java.util.ArrayList;

import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.LoginPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;

public class DashboardTest extends BaseClass {

	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority = 0, description = "", enabled = true)
	public void DevoteeDashboard() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginPage.Devoteelogin_valid(uname, pwd);
		Dashboard.validateDashboard();
	}

}