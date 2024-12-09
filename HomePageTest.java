package org.hints.testcases;

import java.text.ParseException;

import org.hints.pages.BaseClass;

import org.hints.pages.DashboardPage;
import org.hints.pages.HomePage;
import org.hints.pages.LoginPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class HomePageTest extends BaseClass {
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	//Dont run
		@Test(priority = 1, description = "Unregistered devotee Home page", enabled = false)
		public void UnRegHomePage() throws Exception {
			homePage.bannerValidation();
		}

		// Dont run

		@Test(priority = 2, description = "Registered Devotee Home page", enabled = false)
		public void RegHomePage() throws Exception {
			String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
			String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
			loginPage.Devoteelogin_valid(uname, pwd);
			homePage.bannerValidation();
		}

		@Test(priority = 3, description = "Unregistered Devotee Services on Homepage", enabled = false)
		public void testCardValidationForUnregisteredUser() throws Exception {
			homePage.serviceBannerValidation();
		}

		@Test(priority = 4, description = "Registered Devotee Services on Homepage", enabled = false)
		public void testCardValidationForregisteredUser() throws Exception {
			RegHomePage();
			homePage.serviceBannerValidation();
			Thread.sleep(50000);
		}

		@Test(priority = 5, description = "Verify user navigation on the Sahanavavthu page", enabled = true, groups = {
				"Smoke" })
		public void verifySahanavavthuPageNavigation() throws Exception
		{
			homePage.navigateToSahanavavthuPage();
		}

		@Test(priority = 6, description = "Verify Bajana page cards", enabled = false, groups = { "Smoke" })
		public void verifyBajanaPageCards() throws Exception {

			homePage.navigateToSahanavavthuPage();
			homePage.validateBajanCards();
		}

		@Test(priority = 7,description = "Verify user navigation to the About Temple page",enabled = false, groups = { "Smoke" })
		public void verifyAboutTempleNav() throws Exception {
			homePage.navigateToAboutTemplePage();
		}

		@Test(priority = 8,description = "Verify navigation of links on About Temple page", enabled = false, groups = { "Smoke" })
		public void verifyLinksOnAboutTemplePage() throws Exception {
			homePage.navigateToAboutTemplePage();
			homePage.validateAboutTemplePageLinks();
		}

		@Test(priority = 9, description = "Verify FAQ questions", enabled = false, groups = { "Smoke" })
		public void verifyFAQQuestions() throws InterruptedException {

			homePage.navigateToFAQPage();
			homePage.validateFAQQuestions();
		}

		@Test(priority = 10, description = "Verify user can view events in the next seven days", enabled = false, groups = {
				"Smoke" })
		public void verifyViewEventsInNextSevenDays() throws ParseException, InterruptedException {
			homePage.navigateToNext7DaysEvents();
		}

		@Test(priority = 11, description = "Verify user can select a particular date and view corresponding events",enabled = false, groups = {
				"Functional" })
		public void verifyEventsForSelectedDate() throws InterruptedException {

			homePage.CheckEventsDisplayedForSelectedDate();
		}
		
		@Test(priority = 12, description = "verify refund policy", enabled = false, groups = { "Smoke" })
		public void verifyrefundpolicy() throws InterruptedException {

			homePage.navigatetorefundPolicy();
			homePage.validaterefundPolicy();
		}
		@Test(priority = 13, description = "verify overview", enabled = false, groups = { "Smoke" })
		public void verifyoverview() throws InterruptedException {

			homePage.navigatetooverview();
			homePage.validateoverview();
		}
		@Test(priority = 14, description = "verify Religious", enabled = true, groups = { "Smoke" })
		public void verifyReligious() throws InterruptedException {

			homePage.navigatetoReligious();
			homePage.validateReligious();
		}
		
		@Test(priority = 15, description = "verify Religious TempleServices", enabled = false, groups = { "Smoke" })
		public void verifyReligiousTempleServices() throws InterruptedException {
			
			homePage.navigatetoReligious();
			homePage.validateReligiousTempleServices();
		}
		
		@Test(priority = 16, description = "verify Religious ResidenceServices", enabled = false, groups = { "Smoke" })
		public void verifyReligiousResidenceServices() throws InterruptedException {
			
			homePage.navigatetoReligious();
			homePage.validateReligiousResidenceServices();
		}	
		
		@Test(priority = 17, description = "verify Religious KeyEvents", enabled = false, groups = { "Smoke" })
		public void verifyReligiousKeyEvents() throws InterruptedException {
			
			homePage.navigatetoReligious();
			homePage.validateReligiousKeyEvents();
		}
		@Test(priority = 18, description = "verify HumanServices", enabled = false, groups = { "Smoke" })
		public void verifyHumanServices() throws InterruptedException {

			homePage.navigatetohumanservices();
			homePage.validateHumanServices();
		}
		
		@Test(priority = 19, description = "verify HumanServices Programs", enabled = false, groups = { "Smoke" })
		public void verifyHumanServicesPrograms() throws InterruptedException {

			homePage.navigatetohumanservices();
			homePage.validateHumanServicesPrograms();
		}
		

		@Test(priority = 20, description = "verify YouthandEducation", enabled = false, groups = { "Smoke" })
		public void verifyYouthandEducation() throws InterruptedException {

			homePage.navigatetoYouthandEducation();
			homePage.validateYouthandEducation();
		}
		
		@Test(priority = 21, description = "verify YouthandEducation keyEvents", enabled = false, groups = { "Smoke" })
		public void verifyYouthandEducationkeyEvents() throws InterruptedException {

			homePage.navigatetoYouthandEducation();
			homePage.validateYouthandEducationkeyEvents();
		}
			
		@Test(priority = 22, description = "verify Awards", enabled = false, groups = { "Smoke" })
		public void verifyAwards() throws InterruptedException {

			homePage.verifyAwards();
		}	
		
		@Test(priority = 23, description = "verify EventFacilities", enabled = false, groups = { "Smoke" })
		public void verifyEventFacilities() throws InterruptedException {

			homePage.navigatetoEventFacilities();
			homePage.verifyEventFacilities();
		}
		
	@Test(priority = 24, description = "verify ExpandedFacilities", enabled = false, groups = { "Smoke" })
	public void verifyExpandedFacilities() throws InterruptedException {

		homePage.navigatetoEventFacilities();
		homePage.verifyExpandedFacilities();

	}	

	@Test(priority = 25, description = "verify RentalFacilities", enabled = false, groups = { "Smoke" })
	public void verifyRentalFacilities() throws InterruptedException {

		homePage.navigatetoEventFacilities();
		homePage.verifyRentalFacilities();
	}	

	@Test(priority = 25, description = "verify EventsHosting", enabled = false, groups = { "Smoke" })
	public void verifyEventsHosting() throws InterruptedException {

		homePage.navigatetoEventFacilities();
		homePage.verifyEventsHosting();
	}

	@Test(priority = 26, description = "verify Amenities", enabled = false, groups = { "Smoke" })
	public void verifyAmenities() throws InterruptedException {

		homePage.navigatetoEventFacilities();
		homePage.verifyAmenities();
	}

	@Test(priority = 27, description = "verify GoldenAgersOverview", enabled = false, groups = { "Smoke" })
	public void verifyservice() throws InterruptedException {

		homePage.navigatetoGoldenAgers();
		homePage.validateGoldenAgersOverview();
	}

	@Test(priority = 28, description = "verify GoldenAgersActivity", enabled = false, groups = { "Smoke" })
	public void verifyGoldenAgersActivity() throws InterruptedException {

		homePage.navigatetoGoldenAgersActivity();
		homePage.validateGoldenAgersActivity();
	}

	@Test(priority = 29, description = "verify Servies Overview", enabled = false, groups = { "Smoke" })
	public void verifyServiesOverview() throws Exception {

		homePage.navigatetoservicesoverview();
		homePage.validateservicesoverview();
	}

	@Test(priority = 30, description = "verify Services Policy", enabled = false, groups = { "Smoke" })
	public void verifyservicesPolicy() throws Exception {

		homePage.navigatetoservicesPolicy();
		homePage.validateservicesPolicy();
	}

	@Test(priority = 31, description = "verify Services ContactUs", enabled = false, groups = { "Smoke" })
	public void verifyservicesContactUs() throws Exception {

		homePage.navigatetoservicesContactUs();
		homePage.validateservicesContactUs();
	}

	@Test(priority = 32, description = "verify services Youth Activity ", enabled = false, groups = { "Smoke" })
	public void verifyservicesYouthandEducation() throws Exception {

		homePage.navigatetoservicesactivity();
		homePage.validateservicesactivity();
	}

	@Test(priority = 33, description = "verify services Youth ContactUs", enabled = false, groups = { "Smoke" })
	public void verifyservicesYouthContactUs() throws Exception {

		homePage.navigatetoservicesYouthContactUs();
		homePage.validateservicesyouthContactUs();
	}

	@Test(priority = 34, description = "verify services Young Adult's Overview", enabled = true, groups = { "Smoke" })
	public void verifyservicesYoungAdultsOverview() throws Exception {

		homePage.navigatetoservicesYoungAdultsOverview();
		homePage.validateservicesYoungAdultsOverview();
	}
	
	//failing need to check
	@Test(priority = 35, description = "verify services Young Adult's ContactUs", enabled = false, groups = { "Smoke" })
	public void verifyservicesYoungAdultsContactUs() throws Exception {

		homePage.navigatetoservicesYoungAdultsContactUs();
		homePage.validateservicesYoungAdultsContactUs();
	}

	//failing need to check
	@Test(priority = 36, description = "verify services Young Adult's Acivity", enabled = false, groups = { "Smoke" })
	public void verifyservicesYoungAdultsAcivity() throws Exception {

		homePage.navigatetoservicesYoungAdultsAcivity();
		homePage.validateservicesYoungAdultsAcivity();
	}

	@Test(priority = 37, description = "verify TempleHistoryPage", enabled = false, groups = { "Smoke" })
	public void verifyTempleHistoryPage() throws Exception {

		homePage.navigateToTempleHistoryPage();
		homePage.links();
	}
	


		
//		@Test(priority = 15, description = "verify ConsolidateAccounts", enabled = false, groups = { "Smoke" })
//		public void verifyCONSOLIDATEACCOUNTS() throws Exception {
//			String uname = DataProviderFactory.getConfig().getValue("manager_uname");
//			String pwd = DataProviderFactory.getConfig().getValue("manager_pwd");
//			loginPage.Devoteelogin_valid(uname, pwd);
	//
//			homePage.ConsolidateAccounts();
//			homePage.validatedevotee();
//		}
}

