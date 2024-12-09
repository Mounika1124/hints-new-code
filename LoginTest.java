package org.hints.testcases;

import org.testng.annotations.Test;

import org.hints.pages.BaseClass;
import org.hints.pages.HomePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.hints.pages.LoginPage;
import org.hints.pages.DonationPage;

import org.hints.pages.RegisterNewDevotee;
import org.hints.utility.BrowserSetup;
import org.hints.utility.DataProviderFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
//import com.github.javafaker.Faker;

public class LoginTest extends BaseClass {

	LoginPage loginpage;
	RegisterNewDevotee RegDevotee;
	public ExtentReports extent;
	public ExtentTest extentTest;
	DonationPage donationPage;

	@BeforeMethod
	public void Initsetup() {
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		RegDevotee = PageFactory.initElements(driver, RegisterNewDevotee.class);
		donationPage = PageFactory.initElements(driver, DonationPage.class);
	}

	@Test(priority = 1, description = "Verify Login with valid credentials", enabled = false, groups = { "Smoke" })

	public void VerifyLoginSuccess() throws Exception {

		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		loginpage.checkLoginSuccess();

	}

	// Blocker Bug - Don't run
	@Test(priority = 2, description = "Verify Login with Invalid credentials.", enabled = false, groups = { "Smoke" })

	public void VerifyLoginFailure() throws Exception {

		String inUname = DataProviderFactory.getConfig().getValue("in_uname");
		String inPwd = DataProviderFactory.getConfig().getValue("in_pwd");
		loginpage.Devoteelogin_Invalid(inUname, inPwd);

	}

	// Blocker Bug - Don't run
	@Test(priority = 3, description = "Forgot Username with invalid details", enabled = false, groups = { "Smoke" })
	public void VerifyForgotUserName_Invalid() throws Exception {

		String inFName = DataProviderFactory.getConfig().getValue("in_firstNameFU");
		String inLName = DataProviderFactory.getConfig().getValue("in_lastNameFU");
		String inZip = DataProviderFactory.getConfig().getValue("in_ZipcodeFU");
		loginpage.ForgotUserName_Invalid(inFName, inLName, inZip);
		loginpage.checkForgotUserNameFailure();

	}

	// Bug - Working only till filling registration page - can run
	@Test(priority = 1, description = "Verify registration of a new devotee with valid details", enabled = true, groups = {
			"Smoke" })
	public void VerifyDevoteeRegister_Valid() throws Exception {
		Faker faker = new Faker();

		// Personal Information
		String fName = faker.name().firstName();
		String mName = faker.name().lastName();
		String lName = faker.name().lastName();

		// Contact Information
		String address = faker.address().fullAddress();
		String email = DataProviderFactory.getConfig().getValue("regEmail");
		String zip = DataProviderFactory.getConfig().getValue("regZip");
		String username = faker.name().username();
		String addressField = faker.address().fullAddress();

		RegDevotee.devoteeRegister_Valid(fName, lName, mName, zip, email, username, addressField);

		// RegDevotee.checkDevoteeRegSuccess();

	}

	// working
	@Test(priority = 5, description = "Verify inline errors for mandatory details during devotee registration", enabled = false, groups = {
			"Smoke" })
	public void VerifyDevoteeRegInlineErrors()

	{

		RegDevotee.checkDevoteeRegInlineErrors();

	}

	// working
	@Test(priority = 6, description = "Verify registration of a new devotee with invalid details", enabled = false, groups = {
			"Smoke" })
	public void DevoteeReginlinerror_Invalid() {

		// Invalid Personal Information
		String invalidFirstName = DataProviderFactory.getConfig().getValue("invalidRegFirstName");

		String invalidEmail = DataProviderFactory.getConfig().getValue("invalidRegEmail");

		RegDevotee.checkRegErrors_Invalid(invalidEmail);

		// Add assertions to validate error messages or other expected behavior for
		// invalid details

	}

	// working
	@Test(priority = 7, description = "Update profile with valid details", enabled = false, groups = { "Smoke" })
	public void updateProfileWithValidDetails() throws Exception {

		loginpage.Devoteelogin_valid("jvvsatya", "Satya123$");

		// Retrieve values from the configuration
		String changeregFirstName = DataProviderFactory.getConfig().getValue("changeregFirstName");
		String changeregLastName = DataProviderFactory.getConfig().getValue("changeregLastName");
		String changeregMiddleName = DataProviderFactory.getConfig().getValue("changeregMiddleName");
		String regZip = DataProviderFactory.getConfig().getValue("regZip");

		RegDevotee.checkEditProfileSuccess(changeregFirstName, changeregMiddleName, changeregLastName);

	}

	// working
	@Test(priority = 8, description = "Verify cancel button functionality in ForgotUsername", enabled = false, groups = {
			"Smoke" })
	public void verifyCancelInForgotUsername() throws InterruptedException {

		loginpage.checkCancelInForgotUsername();

	}

	// working
	@Test(priority = 9, description = "Verify inline error for mandatory fields in ForgotUsername screen", enabled = false, groups = {
			"Smoke" })
	public void checkInlineErrorForgotUsername() {

		loginpage.checkInlineErrorForForgotUsername();

	}

	// working
	@Test(priority = 10, description = "No errors after filling user details in ForgotUsername", enabled = false, groups = {
			"Smoke" })
	public void VerifyNoErrorsInForgotUser() throws InterruptedException {

		String fu_firstname = DataProviderFactory.getConfig().getValue("in_firstNameFU");
		String fu_lastname = DataProviderFactory.getConfig().getValue("in_lastNameFU");
		String fu_zipcode = DataProviderFactory.getConfig().getValue("in_ZipcodeFU");
		loginpage.CheckNoInlineErrorsForgotUser(fu_firstname, fu_lastname, fu_zipcode);

	}

	// RE-WORK TILL SEND EMAIL VERIFICATION LINK
	@Test(priority = 11, description = "Forgot Password", enabled = false, groups = { "Smoke" })
	public void VerifyForgotPassword() throws Exception {

		String fp_username = DataProviderFactory.getConfig().getValue("unameFp");
		String fp_AnswertoSecret = DataProviderFactory.getConfig().getValue("AnswertoSecretFP");
		String fp_NewPassword = DataProviderFactory.getConfig().getValue("NewPassword");
		String fp_ConfirmNewPassword = DataProviderFactory.getConfig().getValue("ConfirmNewPassword");
		loginpage.ForgotPassword(fp_username, fp_AnswertoSecret, fp_NewPassword, fp_ConfirmNewPassword);

	}

	@Test(priority = 12, description = "Forgot Password - Username Inline error", enabled = false, groups = { "Smoke" })
	public void verifyUsernameRequiredErrorMessage() throws InterruptedException {

		String fp_username = DataProviderFactory.getConfig().getValue("unameFp");

		loginpage.getUsernameRequiredErrorMessage();

	}

	// Not needed - Depreciated
	@Test(priority = 13, description = "Inline error for Secret Answer Fields", enabled = false, groups = { "Smoke" })
	public void verifySecretAnswerRequiredErrorMessage() throws InterruptedException {

		String fp1_username = DataProviderFactory.getConfig().getValue("unamefp1");

		loginpage.getsecretAnswerRequiredErrorMessage(fp1_username);

	}

	// Not needed - Depreciated
	@Test(priority = 14, description = "Inline error for New Password field", enabled = false, groups = { "Smoke" })
	public void VerifyNewPasswordRequiredErrorMessage() throws InterruptedException {

		String fp1_username = DataProviderFactory.getConfig().getValue("unamefp1");
		String fp1_secretanswer = DataProviderFactory.getConfig().getValue("secretanswer");

		loginpage.getNewPasswordRequiredErrorMessage(fp1_username, fp1_secretanswer);

	}

	// Not needed - Depreciated
	@Test(priority = 15, description = "Inline error for confirm New Password field", enabled = false, groups = {
			"Smoke" })
	public void VerifyConfirmNewPasswordRequiredErrorMessage() throws InterruptedException {

		String fp1_username = DataProviderFactory.getConfig().getValue("unamefp1");
		String fp1_secretanswer = DataProviderFactory.getConfig().getValue("secretanswer");

		loginpage.getConfirmNewPasswordRequiredErrorMessage(fp1_username, fp1_secretanswer);

	}

	//// Not needed - Depreciated
	@Test(priority = 16, description = "New password and confirm password mismatch error", enabled = false, groups = {
			"Smoke" })
	public void verifyNewPasswordMismatchErrorMessage() throws InterruptedException {

		String fp2_username = DataProviderFactory.getConfig().getValue("unamefp2");
		String fp2_secretanswer = DataProviderFactory.getConfig().getValue("secretanswer1");
		String fp1_newpassword = DataProviderFactory.getConfig().getValue("NewPassword1");
		String fp1_confirmnewpassword = DataProviderFactory.getConfig().getValue("ConfirmNewPassword1");

		loginpage.getverifyNewPasswordMismatchErrorMessage(fp2_username, fp2_secretanswer, fp1_newpassword,
				fp1_confirmnewpassword);

	}

	@Test(priority = 17, description = "Verify cancel button functionality in ForgotPassword screen", enabled = false, groups = {
			"Smoke" })
	public void testCancelButton() throws InterruptedException {

		String fp_username = DataProviderFactory.getConfig().getValue("unameFp");

		loginpage.ForgotPasswordCancelButton(fp_username);

	}

	@Test(priority = 1, description = "Verify Donation Menu", enabled = false)
	public void verifyDonationMenu() throws Exception {

		String firstName = DataProviderFactory.getConfig().getValue("fname");
		String lastName = DataProviderFactory.getConfig().getValue("lname");
		String email = DataProviderFactory.getConfig().getValue("Email");
		String donationAmt = DataProviderFactory.getConfig().getValue("Amount");

		String zipCode = DataProviderFactory.getConfig().getValue("zip");

		// donationPage.UnRegDevoteeDonate(firstName, lastName, email, donationAmt,
		// zipCode);
	}

	@Test(description = "Validate all carousel buttons", enabled = false, groups = { "Smoke" })
	public void validateAllCarouselButtonsTest() throws InterruptedException {

		// Call the page object method to validate all carousel buttons
		loginpage.validateCarouselContent();
	}

	@Test(description = "Verify user can successfully book a pooja", enabled = false)
	public void verifyPoojaBooking() throws Exception {
		String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
		loginpage.Devoteelogin_valid(uname, pwd);
		loginpage.bookPooja();

	}
	
	@DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
            {"validUser", "validPassword", "Expected Success Message"},
            {"invalidUser", "invalidPassword", "Invalid username or password."},
            {"", "", "Username and password are required."}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) throws Exception {
    	String uname = DataProviderFactory.getConfig().getValue("devotee_uname");
		String pwd = DataProviderFactory.getConfig().getValue("devotee_pwd");
    	loginpage.Devoteelogin_valid(uname, pwd);
        String actualMessage = loginpage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
    }
}
	 

