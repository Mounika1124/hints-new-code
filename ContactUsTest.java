package org.hints.testcases;

import java.text.ParseException;

import org.hints.pages.BaseClass;
import org.hints.pages.ContactUsPage;
import org.hints.pages.DashboardPage;
import org.hints.pages.HomePage;
import org.hints.pages.LoginPage;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ContactUsTest extends BaseClass {
	DashboardPage Dashboard;
	public ExtentTest extentTest;
	public ExtentReports extent;
	HomePage homePage;
	LoginPage loginPage;
	ContactUsPage contactUsPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		Dashboard = PageFactory.initElements(driver, DashboardPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);

	}

	@Test(priority = 1, description = "Verify user can send feedback with valid details", enabled = true, groups = {
			"Smoke" })
	public void sendFeedback_ValidDetails() throws Exception {
		{

			contactUsPage.navigateToSendFeedbackPage();

			String feedbackName = DataProviderFactory.getConfig().getValue("sendFeedbackName");
			String feedbackEmail = DataProviderFactory.getConfig().getValue("sendFeedbackEmail");
			String feedbackDes = DataProviderFactory.getConfig().getValue("FeedbackDescription");
			contactUsPage.enterFeedbackDetails(feedbackName, feedbackEmail, feedbackDes);
			contactUsPage.submitFeedbackSuccess();
		}

	}

	@Test(priority = 2, description = "Verify Feedback Submission With Invalid Details", enabled = true, groups = {
			"Smoke" })
	public void sendFeedback_InvalidDetails() throws Exception {
		contactUsPage.navigateToSendFeedbackPage();
		String in_name = DataProviderFactory.getConfig().getValue("sf_iName");
		String in_email = DataProviderFactory.getConfig().getValue("sf_iEmail");
		String in_Feedback = DataProviderFactory.getConfig().getValue("sf_iDescription");
		contactUsPage.enterFeedbackDetails(in_name, in_email, in_Feedback);
	}

	@Test(priority = 3, description = "Verify inline error for mandatory details in send feedback page", enabled = true, groups = {
			"Smoke" })
	public void InlineErrorDuringSendFeedback() throws Exception {
		contactUsPage.navigateToSendFeedbackPage();
		contactUsPage.checkInlineErrorsInSendFeedback();

	}

	@Test(priority = 4, description = "Verify No error messages should be displayed after entering valid data in send feedback", enabled = true, groups = {
			"Smoke" })
	public void hideFeedbackErrorIfValidData() throws Exception {

		String feedbackName = DataProviderFactory.getConfig().getValue("sendFeedbackName");
		String feedbackEmail = DataProviderFactory.getConfig().getValue("sendFeedbackEmail");
		String feedbackDes = DataProviderFactory.getConfig().getValue("FeedbackDescription");

		contactUsPage.navigateToSendFeedbackPage();
		contactUsPage.checkInlineErrorsInSendFeedback();

		contactUsPage.CheckFeedbackErrorCleared(feedbackName, feedbackEmail, feedbackDes);
	}

	@Test(priority = 5, description = "Verify Address content in the Address Tab", enabled = true, groups = { "Smoke" })
	public void VerifyAddressContentInAddressTab() throws InterruptedException

	{

		contactUsPage.navigateToContactInfoPage();
		contactUsPage.checkAddressContent();

	}

	@Test(description = "Verify Executive Committee Member tab table content", enabled = true, groups = { "Smoke" })
	public void VerifyExecutiveCommitteeMemberTabTableContent() throws InterruptedException {
		contactUsPage.navigateToContactInfoPage();
		contactUsPage.CheckECMemberTableContent();
		// contactUsPage.validateTableData(driver, null, null);
//
//        // Expected table content that you want to verify
//        String expectedTableContent = "Your expected table content"; // Replace with the actual expected content
//
//        // Assert that the actual content matches the expected content
//        Assert.assertEquals(actualTableContent, expectedTableContent,
//                "Table content mismatch in the Executive Committee Member tab. Actual: " + actualTableContent
//                        + ", Expected: " + expectedTableContent);
	}

	// Placeholder methods (replace these with actual implementation)

}