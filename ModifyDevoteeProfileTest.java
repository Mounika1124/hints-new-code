package org.hints.testcases;
import org.hints.pages.BaseClass;
import org.hints.pages.DashboardPage;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.DonationPage;
import org.hints.pages.DonorAdvisoryFundsPage;
import org.hints.pages.LoginPage;
import org.hints.pages.MatchingDonationsPage;
import org.hints.pages.ModifyDevoteeProfile;
import org.hints.pages.VastraPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

	public class ModifyDevoteeProfileTest extends BaseClass {

		LoginPage loginpage;
		ModifyDevoteeProfile modifyDevoteeProfile;
		public ExtentReports extent;
		public ExtentTest extentTest;
		DevoteeCartPage devoteeCartPage;
		

		@BeforeMethod
		public void Initsetup() {
			loginpage = PageFactory.initElements(driver, LoginPage.class);
			modifyDevoteeProfile = PageFactory.initElements(driver, ModifyDevoteeProfile.class);
			devoteeCartPage = PageFactory.initElements(driver, DevoteeCartPage.class);

		}

		@Test(priority = 1, description = "Verify manager can modify devotee details successfully", enabled = true, groups = {
				"Smoke" })

		public void verifyDobModifyDevoteeProfile() throws Exception {
			String uname = DataProviderFactory.getConfig().getValue("manager_uname");
			String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
			loginpage.managerLogin_Valid(uname, pwd);
			modifyDevoteeProfile.searchDevotee();
			modifyDevoteeProfile.modifyDobOfDevotee();
			

	}

}
