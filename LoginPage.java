package org.hints.pages;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

//import org.hints.testcases.ForgotUsernamePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.qameta.allure.Step;

public class LoginPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public LoginPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[@class='menuBar_userInfo__sWrm-']/div")
	public WebElement LoginBtn_main;

	@FindBy(linkText = "Forgot Username?")
	public WebElement forgotUsernameLink;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]")
	public WebElement fuFirstName;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[3]")
	public WebElement fuLastName;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[4]")
	public WebElement fuZipcode;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-148fdm8\"]//div")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//input[@id=\"login-username\"]")
	public WebElement UsernameTxtField;

	@FindBy(xpath = "//input[@id=\"login-password\"]")
	public WebElement PasswordTxtField;

	@FindBy(xpath = "//div[@class='MuiDialogContent-root css-1ty026z']//child::button[text()='Login']")
	public WebElement Login_Submit;

	@FindBy(xpath = "//div[@class='MuiDialogContent-root css-1ty026z']//child::button[text()='Register']")
	public WebElement RegisterBtn;

	@FindBy(xpath = "//span[text()='Remember me']")
	public WebElement RememberMe;

	@FindBy(xpath = "//button[text()='Get Sign In Name']")
	public WebElement getSignInNameButton;

	@FindBy(xpath = "//div[@class='_closeIcon_1oq6k_53']")

	public WebElement CloseIcon;

	@FindBy(xpath = "//input[@name='txtFirstName']")
	public WebElement FirstName;

	@FindBy(xpath = "//h3[text()='Favorite Events']")
	public WebElement user_dash;

	@FindBy(xpath = "//p[text()='Sorry, please try again later.']")
	public WebElement loginError;

	@FindBy(xpath = "//p[text()='No Records found with following Information']")
	public WebElement Forgotusernameerror;

	@FindBy(xpath = "//li[text()= 'Logout']")
	public WebElement Logout;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//p[text()='First Name is required']")
	public WebElement firstNameErrorMessage;

	@FindBy(xpath = "//p[text()='Last Name is required']")
	public WebElement lastNameErrorMessage;

	@FindBy(xpath = "//p[text()='Zipcode is required']")
	public WebElement zipcodeErrorMessage;

	@FindBy(xpath = "//p[text()='Forgot Password?']")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//label[text()='User Name']//following::input")
	public WebElement forgotPassword_UserName_Field;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	public WebElement forgotPassword_NextButton_Link;

	@FindBy(xpath = "//label[text()='Answer to Secret']//following::input")
	public WebElement forgotPassword_AnswertoSecret_Field;

	@FindBy(xpath = "//button[text()='Submit'][1]")
	public WebElement forgotPassword_Submit;

	@FindBy(xpath = "//label[text()='New Password']//following::input[1]")
	public WebElement forgotPassword_NP_Field;

	@FindBy(xpath = "//label[text()='New Password']//following::input[2]")
	public WebElement forgotPassword_CNP_Field;

	@FindBy(xpath = "//button[normalize-space()='Submit'][1]")
	public WebElement forgotPassword_SubmitButton;

	@FindBy(xpath = "//label[text()='New Password']//following::input[1]")
	public WebElement forgotPassword_NewPassword_Field;

	@FindBy(xpath = "//label[text()='New Password']//following::input[2]")
	public WebElement forgotPassword_ConfirmNewPassword_Field;

	@FindBy(xpath = "//button[normalize-space()='Submit'][1]")
	public WebElement fP_SubmitBtn;

	@FindBy(xpath = "//label[text()='User Name']//following::input")
	public WebElement forgotPassword_UN_Field;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	public WebElement forgotPassword_NB_Link;

	@FindBy(xpath = "//label[text()='Answer to Secret']//following::input")
	public WebElement forgotPassword_ASQ_Field;

	@FindBy(xpath = "//button[text()='Submit'][1]")
	public WebElement forgotPassword_SB;

	@FindBy(xpath = "//p[text()='Username is required'][1]")
	public WebElement usernameRequiredErrorMessage;

	@FindBy(xpath = "//p[text()='Secret Answer is required'][1]")
	public WebElement secretAnswerRequiredErrorMessage;

	@FindBy(xpath = "//p[text()='New Password is required']")
	public WebElement newPasswordRequiredErrorMessage;

	@FindBy(xpath = "//p[text()='Confirm New Password is required']")
	public WebElement confirmNewPasswordRequiredErrorMessage;

	@FindBy(xpath = "//button[text()='Submit'][1]")
	public WebElement forgotPwd_SB;

	@FindBy(xpath = "//p[text()='New Password and Confirm Password must match']")
	public WebElement newPasswordMismatchErrorMessage;

	@FindBy(xpath = "//p[text()='No Records found with following Information']")
	public WebElement noRecordsFoundToastMessage;

	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	public WebElement Cancel_Button;
	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")
	public WebElement DurationIcon;

	// button[@class="MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium
	// css-1yxmbwk"]

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;

	@FindBy(xpath = "(//div[@id='grouped-select'])[1]")
	public WebElement hallSelect;

	@FindBy(xpath = "//li[text()='Akella Annadana Kitchen']")
	public WebElement hallOption;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']//following::input[5]")
	public WebElement hoursInput;

	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-bocury']//input")
	public WebElement minutesInput;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-2d4knz']")
	private WebElement OkBtn;

	// button[@class="MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium
	// css-1yxmbwk"]

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-30 MuiGrid-grid-sm-13 css-2ycpn7']")
	public WebElement poojaDescriptionField;

	@FindBy(xpath = "//div[text()='Event Hall Booking Request']")
	public WebElement eventHallMenu;

	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root devoteeBooking_textField__KtqoV css-yf2b9l']")
	public WebElement bookingDate;

//	@FindBy(xpath = "//button[@aria-label=\"calendar view is open, switch to year view\"]")
//	public WebElement dobYearButton;

	@FindBy(xpath = "//button[@aria-label=\"calendar view is open, switch to year view\"]")
	public WebElement dobYearButton;

	@FindBy(xpath = "//button[text()='2024']")
	public WebElement dobYearViewButton;

	@FindBy(xpath = "//button[text()='8']")
	public WebElement dobMonthButton;

	@Step("Enter Credentials with Username and Password and Click on Submit button")
	public void Devoteelogin_valid(String uname, String pwd) throws Exception {
		util.waitUntilElement(driver, LoginBtn_main);
		HomeTab.click();

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, UsernameTxtField);
		Logging.logger.info("Waiting for Username field to appear");
		UsernameTxtField.sendKeys(uname);
		PasswordTxtField.sendKeys(pwd);
		Login_Submit.click();

	}

	public void checkLoginSuccess() throws Exception {
		util.waitUntilElement(driver, user_dash);
		Logging.logger.info("Waiting for Dashboard to appear.");
		System.out.println(user_dash);
		Assert.assertTrue(user_dash.isDisplayed());
		Utility.captureScreenshot(driver);
		UserProfileIcon.click();
		Logout.click();
	}

	@Step("Enter Invalid Credentials and Click on Submit button")
	public void Devoteelogin_Invalid(String inUname, String inPwd) throws Exception {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, UsernameTxtField);
		Logging.logger.info("Waiting for Username field to appear");
		UsernameTxtField.sendKeys(inUname);
		PasswordTxtField.sendKeys(inPwd);
		Login_Submit.click();
		util.waitUntilElement(driver, loginError);
		String error = loginError.getText();
		assertTrue(error.contains("please try again"), "Sorry, please try again later.");
		Utility.captureScreenshot(driver);

	}

	public void ForgotPassword(String username, String AnswertoSecret, String NewPassword, String ConfirmNewPassword)
			throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UN_Field);
		Logging.logger.info("Waiting for Username field to appear");
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		util.waitUntilElement(driver, forgotPassword_ASQ_Field);
		util.waitUntilElement(driver, forgotPassword_SB);
		forgotPassword_SB.click();

		util.waitUntilElement(driver, forgotPassword_AnswertoSecret_Field);
		forgotPassword_AnswertoSecret_Field.sendKeys(AnswertoSecret);
		util.waitUntilElement(driver, forgotPassword_Submit);
		forgotPassword_Submit.click();
		util.waitUntilElement(driver, forgotPassword_NP_Field);
		util.waitUntilElement(driver, forgotPassword_CNP_Field);

		util.waitUntilElement(driver, fP_SubmitBtn);
		fP_SubmitBtn.click();
		util.waitUntilElement(driver, forgotPassword_NewPassword_Field);
		forgotPassword_NewPassword_Field.sendKeys(NewPassword);
		util.waitUntilElement(driver, forgotPassword_ConfirmNewPassword_Field);
		forgotPassword_ConfirmNewPassword_Field.sendKeys(ConfirmNewPassword);
		util.waitUntilElement(driver, forgotPassword_SubmitButton);
		forgotPassword_SubmitButton.click();

		Thread.sleep(5000);
	}

	public void managerLogin_Valid(String uname, String pwd) throws Exception {
		util.waitUntilElement(driver, LoginBtn_main);
		HomeTab.click();
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, UsernameTxtField);
		Logging.logger.info("Waiting for Username field to appear");
		UsernameTxtField.sendKeys(uname);
		PasswordTxtField.sendKeys(pwd);
		Login_Submit.click();
	}

	public void ForgotPasswordCancelButton(String fp_username) throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, cancelButton);
		cancelButton.click();
		Assert.assertTrue(forgotPasswordLink.isDisplayed(), "User did not navigate back successfully");
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(fp_username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, Cancel_Button);
		Cancel_Button.click();

	}

	public void getUsernameRequiredErrorMessage() throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UN_Field);
		Logging.logger.info("Waiting for Username field to appear");
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();

		Thread.sleep(2000);
		util.waitUntilElement(driver, usernameRequiredErrorMessage);
		String actualusernameRequiredErrorMessage = usernameRequiredErrorMessage.getText();
		System.out.print(actualusernameRequiredErrorMessage);
		Assert.assertTrue(actualusernameRequiredErrorMessage.contains("Username is required"),
				"Actual error message for username does not match expected.");

	}

	public void getsecretAnswerRequiredErrorMessage(String fp1_username) throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(fp1_username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		util.waitUntilElement(driver, forgotPassword_ASQ_Field);
		util.waitUntilElement(driver, forgotPassword_SB);
		forgotPassword_SB.click();

		Thread.sleep(2000);
		util.waitUntilElement(driver, secretAnswerRequiredErrorMessage);
		String actualSecretAnsweRequiredErrorMessage = secretAnswerRequiredErrorMessage.getText();
		System.out.print(actualSecretAnsweRequiredErrorMessage);
		Assert.assertTrue(actualSecretAnsweRequiredErrorMessage.contains("Secret Answer is required"),
				"Actual error message for Secret Answer does not match expected.");

	}

	public void getNewPasswordRequiredErrorMessage(String fp1_username, String fp1_secretanswer)
			throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(fp1_username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		util.waitUntilElement(driver, forgotPassword_AnswertoSecret_Field);
		forgotPassword_AnswertoSecret_Field.sendKeys(fp1_secretanswer);
		util.waitUntilElement(driver, forgotPassword_SB);
		forgotPassword_SB.click();
		Thread.sleep(2000);

		util.waitUntilElement(driver, forgotPwd_SB);
		forgotPwd_SB.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, newPasswordRequiredErrorMessage);
		String actualgetNewPasswordRequiredErrorMessage = newPasswordRequiredErrorMessage.getText();
		System.out.print(actualgetNewPasswordRequiredErrorMessage);
		Assert.assertTrue(actualgetNewPasswordRequiredErrorMessage.contains("New Password is required"),
				"Actual error message for New password does not match expected.");

	}

	public void getConfirmNewPasswordRequiredErrorMessage(String fp1_username, String fp1_secretanswer)
			throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(fp1_username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		util.waitUntilElement(driver, forgotPassword_AnswertoSecret_Field);
		forgotPassword_AnswertoSecret_Field.sendKeys(fp1_secretanswer);
		util.waitUntilElement(driver, forgotPassword_SB);
		forgotPassword_SB.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, forgotPassword_Submit);
		forgotPassword_Submit.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, confirmNewPasswordRequiredErrorMessage);
		String actualgetConfirmNewPasswordRequiredErrorMessage = confirmNewPasswordRequiredErrorMessage.getText();
		System.out.print(actualgetConfirmNewPasswordRequiredErrorMessage);
		Assert.assertTrue(actualgetConfirmNewPasswordRequiredErrorMessage.contains("Confirm New Password is required"),
				"Actual error message for Confirm New password does not match expected.");
	}

	public void getverifyNewPasswordMismatchErrorMessage(String fp2_username, String fp2_secretanswer,
			String fp1_newpassword, String fp1_confirmnewpassword) throws InterruptedException {
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		util.waitUntilElement(driver, forgotPassword_UserName_Field);
		Logging.logger.info("Waiting for Username field to appear");
		forgotPassword_UserName_Field.sendKeys(fp2_username);
		util.waitUntilElement(driver, forgotPassword_NextButton_Link);
		forgotPassword_NextButton_Link.click();
		util.waitUntilElement(driver, forgotPassword_AnswertoSecret_Field);
		forgotPassword_AnswertoSecret_Field.sendKeys(fp2_secretanswer);
		util.waitUntilElement(driver, forgotPassword_SB);
		forgotPassword_SB.click();

		util.waitUntilElement(driver, forgotPassword_NewPassword_Field);
		forgotPassword_NewPassword_Field.sendKeys(fp1_newpassword);
		util.waitUntilElement(driver, forgotPassword_ConfirmNewPassword_Field);
		forgotPassword_ConfirmNewPassword_Field.sendKeys(fp1_confirmnewpassword);
		util.waitUntilElement(driver, forgotPassword_Submit);
		forgotPassword_Submit.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, newPasswordMismatchErrorMessage);
		String actualgetverifyNewPasswordMismatchErrorMessage = newPasswordMismatchErrorMessage.getText();
		System.out.print(actualgetverifyNewPasswordMismatchErrorMessage);
		Assert.assertTrue(
				actualgetverifyNewPasswordMismatchErrorMessage.contains("New Password and Confirm Password must match"),
				"Actual error message for New password and Confirm New password does not match expected.");
	}

	public void ForgotUserName_Invalid(String firstname, String lastname, String zipcode) throws InterruptedException {
		util.waitUntilElement(driver, HomeTab);

		HomeTab.click();

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotUsernameLink);
		Logging.logger.info("Forgot Username link is visible");

		forgotUsernameLink.click();

		util.waitUntilElement(driver, fuFirstName);

		fuFirstName.sendKeys(firstname);

		util.waitUntilElement(driver, fuLastName);

		fuLastName.sendKeys(lastname);
		util.waitUntilElement(driver, fuZipcode);

		fuZipcode.sendKeys(zipcode);

		getSignInNameButton.click();

		Logging.logger.info("Clicked on SignInName button");
		Utility.captureScreenshot(driver);

	}

	public void checkForgotUserNameFailure() {
		util.waitUntilElement(driver, Forgotusernameerror);

		String toastMessageText = Forgotusernameerror.getText();
		assertTrue(toastMessageText.contains("No Records found with following Information"),
				"Expected toast message not found: " + toastMessageText);
	}

	public void checkCancelInForgotUsername() throws InterruptedException {
		util.waitUntilElement(driver, HomeTab);

		HomeTab.click();
		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotUsernameLink);
		Logging.logger.info("Forgot Username link is visible");
		forgotUsernameLink.click();
		util.waitUntilElement(driver, cancelButton);

		cancelButton.click();

		Assert.assertTrue(forgotUsernameLink.isDisplayed(), "User did not navigate back successfully");
	}

	public void checkInlineErrorForForgotUsername() {

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotUsernameLink);
		Logging.logger.info("Forgot Username link is visible");
		forgotUsernameLink.click();

		getSignInNameButton.click();

		util.waitUntilElement(driver, firstNameErrorMessage);

		Assert.assertEquals(firstNameErrorMessage.getText(), "First Name is required",
				"First Name error messages do not match");
		Assert.assertEquals(lastNameErrorMessage.getText(), "Last Name is required",
				"Last Name error messages do not match");
		Assert.assertEquals(zipcodeErrorMessage.getText(), "Zipcode is required",
				"Zipcode error messages do not match");
	}

	public void CheckNoInlineErrorsForgotUser(String firstname, String lastname, String zipcode)
			throws InterruptedException {

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, forgotUsernameLink);
		Logging.logger.info("Forgot Username link is visible");
		forgotUsernameLink.click();
		getSignInNameButton.click();
		util.waitUntilElement(driver, firstNameErrorMessage);

		Assert.assertEquals(firstNameErrorMessage.getText(), "First Name is required",
				"First Name error messages do not match");
		Assert.assertEquals(lastNameErrorMessage.getText(), "Last Name is required",
				"Last Name error messages do not match");
		Assert.assertEquals(zipcodeErrorMessage.getText(), "Zipcode is required",
				"Zipcode error messages do not match");

		util.waitUntilElement(driver, fuFirstName);
		Logging.logger.info("Waiting for Firstname field to appear");
		fuFirstName.sendKeys(firstname);
		util.waitUntilElement(driver, fuLastName);
		Logging.logger.info("Waiting for Lastname field to appear");

		fuLastName.sendKeys(lastname);

		Logging.logger.info("Zipcode field is visible");

		fuZipcode.sendKeys(zipcode);

		try {
			Assert.assertFalse(firstNameErrorMessage.isDisplayed(),
					"Unexpected behavior: First Name error message is displayed when it should not be");
			Logging.logger.info("First Name error message is not displayed as expected");
		} catch (NoSuchElementException e) {
			// Log a message if the element is not found
			Logging.logger.info("First Name error message element not found as expected");
		}

//        // Assert that the element is not displayed
//		Assert.assertFalse(firstNameErrorMessage.isDisplayed(),
//				"First Name error message still displayed after filling details");
		try {
			Assert.assertFalse(lastNameErrorMessage.isDisplayed(),
					"Unexpected behavior: Last Name error message is displayed when it should not be");
			Logging.logger.info("Last Name error message is not displayed as expected");
		} catch (NoSuchElementException e) {
			// Log a message if the element is not found
			Logging.logger.info("Last Name error message element not found as expected");
		}

		// Assert that the zipcode error message is not displayed
		try {
			Assert.assertFalse(zipcodeErrorMessage.isDisplayed(),
					"Unexpected behavior: Zipcode error message is displayed when it should not be");
			Logging.logger.info("Zipcode error message is not displayed as expected");
		} catch (NoSuchElementException e) {
			// Log a message if the element is not found
			Logging.logger.info("Zipcode error message element not found as expected");
		}

	}

	public void validateCarouselContent() throws InterruptedException {
		Thread.sleep(5000);

		// Get the list of carousel buttons
		List<WebElement> carouselButtons = driver
				.findElements(By.xpath("//div[@class='Carousel_ButtonContainer__zoViU']/button"));

		// Get the list of carousel images
		List<WebElement> carouselImages = driver
				.findElements(By.xpath("//div[@class='Carousel_Slide__srXk8 Carousel_hovered__5d6RJ']/img"));

		// Define expected path segments
		String[] expectedPathSegments = { "/young_adults1.jpg", "/mobileapp1.jpg", "/2024cal.jpg", "/grant.jpg",
				"/arudra.jpg", "/wedding1.jpg", "/thai.jpg" };

		// Validate each carousel button and image
		for (int i = 0; i < carouselButtons.size(); i++) {
			// Click on the carousel button
			carouselButtons.get(i).click();

			// Perform validation for the carousel content
			// Validate carousel image
			WebElement image = carouselImages.get(i);

			util.waitUntilElement(driver, image);

			// Basic validation: Check if the image is displayed
			if (image.isDisplayed()) {

				System.out.println("Carousel Image " + (i + 1) + " is displayed.");

				// Print the source (src) attribute of the image
				String actualUrl = image.getAttribute("src");
				System.out.println("Image Source (src): " + actualUrl);

				// Extract path segments
				String actualPathSegment = actualUrl.substring(actualUrl.lastIndexOf('/'));

				// Compare with expected path segment using assertion
				if (i < expectedPathSegments.length) {
					String expectedPathSegment = expectedPathSegments[i];
					Assert.assertEquals(actualPathSegment, expectedPathSegment,
							"Path segment mismatch for Image " + (i + 1));
					System.out.println("Expected Path Segment matches Actual Path Segment.");
				}
			} else {
				System.out.println("Carousel Image " + (i + 1) + " is NOT displayed.");
				// You can throw an exception or handle the failure in some way
			}

		}

	}
	
	 @DataProvider(name = "loginData")
	    public Object[][] provideLoginData() {
	        return new Object[][] {
	            {"user1", "password1"},
	            {"user2", "password2"}
	        };
	    }
	 
	 public String getErrorMessage() {
	        return driver.findElement(By.id("errorMessage")).getText();
	    }

	public void bookPooja() throws InterruptedException, SQLException {
		util.waitUntilElement(driver, UserProfileIcon);

		UserProfileIcon.click();

		util.waitUntilElement(driver, changeRoleMenu);

		changeRoleMenu.click();

		util.waitUntilElement(driver, devoteeRole);

		devoteeRole.click();

		util.waitUntilElement(driver, bookPoojaHallButton);

		// Highlight the element using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid yellow'", bookPoojaHallButton);

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);

		Thread.sleep(4000);
		bookPoojaHallButton.click();
		util.waitUntilElement(driver, eventHallMenu);

		eventHallMenu.click();

		util.waitUntilElement(driver, hallSelect);
		hallSelect.click();

		util.waitUntilElement(driver, hallOption);
		hallOption.click();

		bookingDate.click();

		util.waitUntilElement(driver, dobMonthButton);

		dobMonthButton.click();

		DurationIcon.click();
		Thread.sleep(4000);

		hoursInput.sendKeys("4");
		minutesInput.sendKeys("2");
		OkBtn.click();

		Thread.sleep(4000);

		Utility.getDatabaseConnection();

		// bookPoojaHallButton.click();
	}
//    private static String extractImageNameFromUrl(String imageUrl) {
//        try {
//            URL url = new URL(imageUrl);
//            String path = url.getPath();
//            String[] pathSegments = path.split("/");
//            return pathSegments[pathSegments.length - 1];
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    private void assertImageName(String actualImageName, String expectedImageName, String imageSrc) {
//        // Define the assertion message
//        String assertionMessage = "Image validation failed for image with source: " + imageSrc;
//
//        // Assert that the actual image name matches the expected image name
//        org.testng.Assert.assertEquals(actualImageName, expectedImageName, assertionMessage);
//    }
//}
}
