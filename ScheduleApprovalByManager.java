package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.DevoteeCartPage;
import org.hints.pages.HomePage;
import org.hints.pages.LoginPage;
import org.hints.pages.ManagerDevoteeServicePage;
import org.hints.pages.PoojaBookingPage;
import org.hints.pages.PoojaBookingResult;
import org.hints.pages.PayNowByDevotteforPriestApproved;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ScheduleApprovalByManager extends BaseClass {

	public ExtentReports extent;
	public ExtentTest extentTest;

	HomePage homePage;
	LoginPage loginpage;
	ManagerDevoteeServicePage managerdevoteeservicePage;
	PayNowByDevotteforPriestApproved scheduleselectionpage;
	PoojaBookingPage poojaPage;
	DevoteeCartPage devoteecartpage;
	//PoojaBookingResult poojaBookingResult;
	

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() throws InterruptedException {
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		managerdevoteeservicePage = PageFactory.initElements(driver, ManagerDevoteeServicePage.class);
		scheduleselectionpage = PageFactory.initElements(driver, PayNowByDevotteforPriestApproved.class);
		poojaPage=PageFactory.initElements(driver, PoojaBookingPage.class);
		devoteecartpage= PageFactory.initElements(driver, DevoteeCartPage.class);
		//poojaBookingResult = poojaPage.bookOutsidePoojawithPriest();
	}
	
	
	 @Test(priority = 1)
	    public void verifyOutsidePoojaBookingwithPriest() throws Exception {
		 String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
			String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
			loginpage.Devoteelogin_valid(uname, pwd);
			poojaPage.bookOutsidePoojawithPriest();
		
	    }
	 
	/* @Test(priority = 2,dependsOnMethods = {"verifyOutsidePoojaBookingwithPriest"})
	 public void VerifyStatusofOutsidepoojabookedinManagerpg() throws Exception {
		 String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
			String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
			loginpage.managerLogin_Valid(managerUname, managerPwd);
			Thread.sleep(2000);
			managerdevoteeservicePage.outpujawithprieststatus();
	 } 
*/
	@Test(priority = 2,dependsOnMethods = {"verifyOutsidePoojaBookingwithPriest"})
	//@Test(priority=2)
	public void VerifyManagerapprovideOutsidepoojaschedule() throws Exception {
		
		String managerUname = DataProviderFactory.getConfig().getValue("manager_uname");
		String managerPwd = DataProviderFactory.getConfig().getValue("manager_pwd");
		loginpage.managerLogin_Valid(managerUname, managerPwd);
		Thread.sleep(2000);
		// PoojaBookingPage poojaBooking = new PoojaBookingPage(driver);
		//managerdevoteeservicePage.schedulePoojaPendingAction(poojaBooking);
		managerdevoteeservicePage.schedulePoojaPendingAction();
		//if managerDevoteeServicePage.isErrorMessageDisplayed(){
		 if (managerdevoteeservicePage.isErrorMessageDisplayed()) {
		        String errorMessage = managerdevoteeservicePage.getErrorMessageText();
		        Assert.fail("Error message displayed: " + errorMessage);
		    }
		 managerdevoteeservicePage.closeSuccessPopup();
		 //Assert.assertFalse(managerdevoteeservicePage.isSuccessPopupDisplayed(), "Success pop-up did not close");
		

	}
	
	 @Test(priority=3,dependsOnMethods = {"VerifyManagerapprovideOutsidepoojaschedule"})
	 //@Test(priority=3)
	public void VerifyDevoteePaymentafterPriestScheduleApproval() throws Exception{
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		Thread.sleep(3000);
		scheduleselectionpage.paynowforManagerApprovedPriestSchedule();
		//devoteecartpage.
		
		
	} 
}
