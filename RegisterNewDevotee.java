package org.hints.pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

//import org.apache.logging.log4j.plugins.di.Keys;
import org.hints.utility.Logging;

//import com.aventstack.extentreports.util.Assert;

import org.hints.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class RegisterNewDevotee {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);
	VastraBookingByManagerPage Vastra = new VastraBookingByManagerPage(driver);

	String verificationCode;

	public RegisterNewDevotee(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[@class=\"menuBar_userInfo__sWrm-\"]/div")
	public WebElement LoginBtn_main;

	@FindBy(xpath = "//button[normalize-space()='Register']")
	public WebElement Register_Button;

	@FindBy(id = "firstName")
	public WebElement Register_Fname;

	@FindBy(id = "middleName")
	public WebElement Register_Mname;

	@FindBy(id = "lastName")
	public WebElement Register_Lname;

	@FindBy(xpath = "//label[text()='DOB']//following::input[1]")
	public WebElement Register_DOB;

	@FindBy(id = "password")
	public WebElement passwordInput;

	@FindBy(id = "prefferedLanguages")
	public WebElement preferredLanguages;

	@FindBy(xpath = "//label[text()='User Name']//following::input[1]")
	public WebElement userNameInput;

	@FindBy(id = "reEnterPassword")
	public WebElement reenterPasswordInput;

	@FindBy(xpath = "//label[text()='Secret Question']//following::input[1]")
	public WebElement SecreatQuestion;

	@FindBy(xpath = "//label[text()='Answer to Secret Question']//following::input[1]")
	public WebElement AnswerSecreatQuestion;

	@FindBy(xpath = "//label[text()='Confirm Answer to Secret Question']//following::input[1]")
	public WebElement ConfirmAnswerSecreatQuestion;

	@FindBy(id = "email")
	public WebElement emailInputField;

	@FindBy(xpath = "//label[text()='Zip Code']//following::input[1]")
	public WebElement ZipCode;

	@FindBy(xpath = "//label[text()='Address']//following::input[1]")
	public WebElement Address;

	@FindBy(id = "phoneNumber")
	public WebElement Contact_no;

	@FindBy(xpath = "(//button[@aria-label=\"Choose date\" and contains(tabindex ,MuiButtonBase-root)])[1]")
	public WebElement dob;

	@FindBy(xpath = "//button[@aria-label=\"calendar view is open, switch to year view\"]")
	public WebElement dobYearButton;

	@FindBy(xpath = "//button[text()='1991']")
	public WebElement dobYearViewButton;

	@FindBy(xpath = "//button[text()='1']")
	public WebElement dobMonthButton;

	@FindBy(xpath = "//button[text()='Register Now']")
	public WebElement reg_button;

	@FindBy(xpath = "//p[text()='User details updated successfully!']")
	private WebElement profileUpdateSuccessMessage;

	// Inline

	@FindBy(xpath = "//p[text()='Last Name is required']")
	public WebElement lastNameErrorMessage;

	@FindBy(xpath = "//p[text()='DOB is required']")
	public WebElement dobErrorMessage;

	@FindBy(xpath = "//p[text()='zipcode is required']")
	public WebElement zipcodeErrorMessage;

	@FindBy(xpath = "//p[text()='city is required']")
	public WebElement cityErrorMessage;

	@FindBy(xpath = "//p[text()='state is required']")
	public WebElement stateErrorMessage;

	@FindBy(xpath = "//label[text()='Email']//following-sibling::div[1]/div/input/../../following-sibling::p[@class=\"MuiTypography-root MuiTypography-body1 css-1m6vh3t\"]")
	public WebElement emailErrorMessage;

	@FindBy(xpath = "//p[text()='Phone Number is required']")
	public WebElement phoneNumberErrorMessage;

	@FindBy(xpath = "//p[text()='User Name is required']")
	public WebElement userNameErrorMessage;

	@FindBy(xpath = "//p[text()='Password is required']")
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//p[text()='Re-enter Password is required']")
	public WebElement reEnterPasswordErrorMessage;

	/////////////////////// user//////////////////////////
	@FindBy(xpath = "//button[@aria-label='User Profile']//*[name()='svg']")
	public WebElement userProfileButton;

	@FindBy(xpath = "//li[normalize-space()='Edit Profile']")
	public WebElement editProfileButton;

	@FindBy(xpath = "//button[text()='Update Profile']")
	public WebElement UpdateProfileButton;

	@FindBy(xpath = "//button[text()='Add Family']")
	public WebElement addFamilyButton;

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> tableFirstColumn;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-148fdm8\"]//div")
	public WebElement UserProfileIcon;

//	@FindBy(xpath class="MuiTouchRipple-root css-w0pj6f"
//
//	@FindBy(id = "verify")

	private WebElement verify;

	@FindBy(id = "otp")

	private WebElement OTP;

	@FindBy(id = "emailVerification")

	private WebElement emailVerification;

	@FindBy(xpath = "(//span[@class=\"MuiTouchRipple-root css-w0pj6f\"])[21]")

	private WebElement otpVerificationWindow;

	@FindBy(xpath = "//*[@id='registerNow']")
	private WebElement registerButton;

	@FindBy(id = "DEVOTEE_MANAGEMENT")
	public WebElement devoteeManagementMenu;

	@FindBy(xpath = "//li[contains(text(), 'Telugu')]")
	public WebElement teluguLanguage;

	@FindBy(id = "REGISTER_DEVOTEE")
	public WebElement registerDevoteeMenu;

	@FindBy(xpath = "//div[@id='VASTRA']")
	public WebElement vastraMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(id = "gothram")
	public WebElement gothram;

	@FindBy(id = "address")
	public WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement city;

	@FindBy(xpath = "//input[@id='state']")
	public WebElement state;

	@FindBy(xpath = "(//button[@aria-label=\"close\"])[2]")
	private WebElement closeButton;

	@FindBy(xpath = "//button[text()=\"Register Now\"]")
	private WebElement registerNowButton;

	public void devoteeRegister_Valid(String firstName, String middleName, String lastName, String Zipcode,
			String regEmailInput, String regUsernameInput, String AddressField) throws InterruptedException {

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, Register_Button);
		Register_Button.click();
		Logging.logger.info("Clicked on Register button.");
		util.waitUntilElement(driver, Register_Fname);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", Register_Fname);
		Thread.sleep(1000);
		Register_Fname.sendKeys(firstName);
		Register_Mname.sendKeys(middleName);
		Register_Lname.sendKeys(lastName);

		util.waitUntilElement(driver, dob);
		dob.click();
		util.waitUntilElement(driver, dobYearButton);
		dobYearButton.click();
		util.waitUntilElement(driver, dobYearViewButton);
		dobYearViewButton.click();

		Thread.sleep(1000);

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", preferredLanguages);

		util.waitUntilElement(driver, preferredLanguages);

		preferredLanguages.click();
		util.waitUntilElement(driver, teluguLanguage);
		teluguLanguage.click();
		gothram.sendKeys("Bharadvja");

		// Assuming ZipCode is a WebElement representing the ZIP code input field
		ZipCode.sendKeys("94550");

		// Remove focus from the ZIP code input field using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].blur();", ZipCode);

		util.waitUntilAttributeNotEmpty(driver, city, "value");
		util.waitUntilAttributeNotEmpty(driver, state, "value");

//
//		// Wait for the state field to be populated
//		until.waitUntilAttributeNotEmpty(driver, state, "value");

		address.sendKeys(AddressField);
		Thread.sleep(5000);
		long con = 8522915087L;
		Contact_no.sendKeys(Long.toString(con));
		// Remove focus from the ZIP code input field using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].blur();", Contact_no);

		emailInputField.sendKeys(regEmailInput);
		emailVerification.click();
		Thread.sleep(500);
		util.waitUntilElement(driver, closeButton);
		closeButton.click();

		// Validate database connection
		try (Connection connection = Utility.getDatabaseConnection()) {
			if (connection != null) {
				System.out.println("Connected to the database");
				String query = "SELECT *\r\n" + "FROM dbo.tabemailvalidation\r\n"
						+ "WHERE email = 'korviyakshith@gmail.com'\r\n" + "ORDER BY expirationtime DESC\r\n"
						+ "LIMIT 1;\r\n" + "";
				ResultSet resultSet = Utility.executeQuery(connection, query);
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();

				while (resultSet.next()) {
					verificationCode = resultSet.getString("verificationcode");
					System.out.println("Verification Code: " + verificationCode);
					break; // Exit the loop after fetching the verification code
				}
			} else {
				System.out.println("Failed to connect to the database");
			}
		} catch (SQLException e) {
			System.out.println("Error connecting to the database: " + e.getMessage());
		}

		// otpVerificationWindow.click();
		OTP.sendKeys(verificationCode);

		util.waitUntilElement(driver, verify);

		verify.click();
		Thread.sleep(1000);
		closeButton.click();

		Faker faker = new Faker();
		String username;
		do {
			username = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
		} while (username.length() < 4 || username.length() > 10);

		// ZipCode.sendKeys("94550");

		userNameInput.sendKeys(username);
		util.waitUntilElement(driver, passwordInput);

		passwordInput.sendKeys("WaveRock@1995");
		reenterPasswordInput.sendKeys("WaveRock@1995");

		registerButton.click();
		Thread.sleep(2000);

	}

	public void devoteeRegisterByManager(String firstName, String middleName, String lastName, String Zipcode,
			String regEmailInput, String regUsernameInput, String AddressField) throws InterruptedException {
		util.waitUntilElement(driver, Register_Fname);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", Register_Fname);
		Thread.sleep(1000);
		Register_Fname.sendKeys(firstName);
		Register_Mname.sendKeys(middleName);
		Register_Lname.sendKeys(lastName);

		util.waitUntilElement(driver, dob);
		dob.click();
		util.waitUntilElement(driver, dobYearButton);
		dobYearButton.click();
		util.waitUntilElement(driver, dobYearViewButton);
		dobYearViewButton.click();
		util.waitUntilElement(driver, preferredLanguages);

		preferredLanguages.click();
		util.waitUntilElement(driver, teluguLanguage);
		teluguLanguage.click();
		gothram.sendKeys("Bharadvja");

		ZipCode.sendKeys("94550");

		// Remove focus from the ZIP code input field using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].blur();", ZipCode);

		util.waitUntilAttributeNotEmpty(driver, city, "value");
		util.waitUntilAttributeNotEmpty(driver, state, "value");

		address.sendKeys(AddressField);
		Thread.sleep(5000);
		long con = 8522915087L;
		Contact_no.sendKeys(Long.toString(con));
		((JavascriptExecutor) driver).executeScript("arguments[0].blur();", Contact_no);

		emailInputField.sendKeys(regEmailInput);

		Faker faker = new Faker();
		String username;
		do {
			username = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
		} while (username.length() < 4 || username.length() > 10);

		// ZipCode.sendKeys("94550");

		userNameInput.sendKeys(username);
		util.waitUntilElement(driver, passwordInput);

		passwordInput.sendKeys("WaveRock@1995");
		reenterPasswordInput.sendKeys("WaveRock@1995");
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", registerNowButton);
		Thread.sleep(1000);
		util.waitUntilElement(driver, registerNowButton);

		registerNowButton.click();
		Thread.sleep(2000);
	}

	public void checkDevoteeRegInlineErrors() {

		util.waitUntilElement(driver, HomeTab);
		HomeTab.click();

		util.waitUntilElement(driver, LoginBtn_main);
		Logging.logger.info("Waiting for LoginBtn_main element to appear");
		LoginBtn_main.click();
		Logging.logger.info("Clicked on LoginBtn_main");

		util.waitUntilElement(driver, Register_Button);
		Logging.logger.info("Waiting for Register_Button element to appear");
		Register_Button.click();
		Logging.logger.info("Clicked on Register_Button");

		util.waitUntilElement(driver, reg_button);
		Logging.logger.info("Waiting for reg_button element to appear");
		reg_button.click();
		Logging.logger.info("Clicked on reg_button");

		util.waitUntilElement(driver, lastNameErrorMessage);
		Logging.logger.info("Waiting for Last Name error message to appear");
		String actualLastNameErrorMessage = lastNameErrorMessage.getText();
		Assert.assertTrue(actualLastNameErrorMessage.contains("Last Name is required"),
				"Actual error message for Last Name does not match expected.");

		util.waitUntilElement(driver, dobErrorMessage);
		Logging.logger.info("Waiting for DOB error message to appear");
		String actualDOBErrorMessage = dobErrorMessage.getText();
		Assert.assertTrue(actualDOBErrorMessage.contains("DOB is required"),
				"Actual error message for DOB does not match expected.");

		util.waitUntilElement(driver, zipcodeErrorMessage);
		Logging.logger.info("Waiting for Zipcode error message to appear");
		String actualZipcodeErrorMessage = zipcodeErrorMessage.getText();
		Assert.assertTrue(actualZipcodeErrorMessage.contains("zipcode is required"),
				"Actual error message for Zipcode does not match expected.");

		// Apply wait before retrieving the text of the City error message
		util.waitUntilElement(driver, cityErrorMessage);
		Logging.logger.info("Waiting for City error message to appear");
		String actualCityErrorMessage = cityErrorMessage.getText();
		Assert.assertTrue(actualCityErrorMessage.contains("city is required"),
				"Actual error message for City does not match expected.");

		util.waitUntilElement(driver, stateErrorMessage);
		Logging.logger.info("Waiting for State error message to appear");
		String actualStateErrorMessage = stateErrorMessage.getText();
		Assert.assertTrue(actualStateErrorMessage.contains("state is required"),
				"Actual error message for State does not match expected.");

		util.waitUntilElement(driver, emailErrorMessage);
		Logging.logger.info("Waiting for Email error message to appear");
		String actualEmailErrorMessage = emailErrorMessage.getText();
		Assert.assertTrue(actualEmailErrorMessage.contains("Email is required"),
				"Actual error message for Email does not match expected.");

		util.waitUntilElement(driver, phoneNumberErrorMessage);
		Logging.logger.info("Waiting for Phone Number error message to appear");
		String actualPhoneNumberErrorMessage = phoneNumberErrorMessage.getText();
		Assert.assertTrue(actualPhoneNumberErrorMessage.contains("Phone Number is required"),
				"Actual error message for Phone Number does not match expected.");

		util.waitUntilElement(driver, userNameErrorMessage);
		Logging.logger.info("Waiting for User Name error message to appear");
		String actualUserNameErrorMessage = userNameErrorMessage.getText();
		Assert.assertTrue(actualUserNameErrorMessage.contains("User Name is required"),
				"Actual error message for User Name does not match expected.");

		util.waitUntilElement(driver, passwordErrorMessage);
		Logging.logger.info("Waiting for Password error message to appear");
		String actualPasswordErrorMessage = passwordErrorMessage.getText();
		Assert.assertTrue(actualPasswordErrorMessage.contains("Password is required"),
				"Actual error message for Password does not match expected.");

		util.waitUntilElement(driver, reEnterPasswordErrorMessage);
		Logging.logger.info("Waiting for Re-enter Password error message to appear");
		String actualReEnterPasswordErrorMessage = reEnterPasswordErrorMessage.getText();
		Assert.assertTrue(actualReEnterPasswordErrorMessage.contains("Re-enter Password is required"),
				"Actual error message for Re-enter Password does not match expected.");

		Logging.logger.info("Registration Successfully completed");

	}

	public void checkRegErrors_Invalid(String invalidRegEmail) {

		util.waitUntilElement(driver, HomeTab);
		HomeTab.click();

		util.waitUntilElement(driver, LoginBtn_main);
		LoginBtn_main.click();
		util.waitUntilElement(driver, Register_Button);
		Register_Button.click();
		util.waitUntilElement(driver, reg_button);
		util.waitUntilElement(driver, emailInputField);
		emailInputField.sendKeys(invalidRegEmail);
		reg_button.click();

		util.waitUntilElement(driver, emailErrorMessage);

		String actualEmailErrorMessage = emailErrorMessage.getText();

		Assert.assertTrue(actualEmailErrorMessage.contains("Invalid email address"), "Invalid email address");

	}

	public void checkDevoteeRegSuccess() {

	}

	public void checkEditProfileSuccess(String updatedFirstName, String updatedMiddleName, String updatedLastName) {

		util.waitUntilElement(driver, userProfileButton);
		userProfileButton.click();
		util.waitUntilElement(driver, editProfileButton);
		editProfileButton.click();

		Register_Fname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, updatedFirstName);

		Register_Fname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, updatedMiddleName);
		Register_Fname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, updatedLastName);
		util.waitUntilElement(driver, userProfileButton);

		userProfileButton.click();
		util.waitUntilElement(driver, UpdateProfileButton);

		UpdateProfileButton.click();

		// Enter the updated first name
		// Register_Fname.sendKeys(updatedFirstName);

		// Register_Mname.sendKeys(updatedMiddleName);

		// Register_Lname.sendKeys(updatedLastName);

		util.waitUntilElement(driver, profileUpdateSuccessMessage);
		String actualSuccessMessage = profileUpdateSuccessMessage.getText();

		String expectedSuccessMessage = "User details updated successfully!";
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Profile update success message mismatch");

	}

	public void navigateToRegisterDevoteeMenu() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		util.waitUntilElement(driver, devoteeManagementMenu);
		devoteeManagementMenu.click();
		Logging.logger.info("Clicking on Register Devotee menu");
		registerDevoteeMenu.click();

	}

}
