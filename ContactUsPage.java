
package org.hints.pages;

import java.util.ArrayList;
import java.util.List;

import org.hints.utility.DataProviderFactory;
import org.hints.utility.GenerateReports;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.hints.utility.Logging;

public class ContactUsPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public ContactUsPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//div[text()='Contact Us']")
	public WebElement contactUsMenu;

	@FindBy(xpath = "//div[text()='Send Feedback']")
	public WebElement sendFeedbackSubMenu;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[1]")
	public WebElement sendFeedbackNameField;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	public WebElement sendFeedbackEmailField;

	@FindBy(xpath = "(//textarea[@class='contactus_textField__P7EqG'])[1]")
	public WebElement feedbackDescriptionField;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public WebElement feedbackSubmitButton;

	@FindBy(xpath = "//p[text()='Name is required']")
	public WebElement nameError;

	@FindBy(xpath = "//p[text()='Email is required']")
	public WebElement emailError;

	@FindBy(xpath = "//p[text()='Description is required']")
	public WebElement descriptionError;

	@FindBy(xpath = "(//textarea[@class='contactus_errorTextField__T0ND5'])[1]")
	public WebElement errorDescriptionTextbox;

	@FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox']")
	public WebElement notARobotCheckbox;

	@FindBy(xpath = "//div[text()='Contact Info']")
	public WebElement contactInfoSubMenu;

	@FindBy(xpath = "//div[@class='contactus_addressContent__Pf16y']")
	public WebElement addressContentElement;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 contactus_directioncotent__txYJS css-9l3uo3']")
	public WebElement directionContentElement;

	@FindBy(xpath = "//span[text()='Executive Committee Member']")
	private WebElement executiveCommitteeMemberTab;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-146q31f']")
	public WebElement mapDataImageDisplay;
	

	// p[@class="MuiTypography-root MuiTypography-body1
	// contactus_directioncotent__txYJS css-9l3uo3"]

	public void navigateToSendFeedbackPage() {
		Logging.logger.info("Navigating to Send Feedback page...");

		util.waitUntilElement(driver, contactUsMenu);

		contactUsMenu.click();
		util.waitUntilElement(driver, sendFeedbackSubMenu);

		sendFeedbackSubMenu.click();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/feedback";
		Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch after clicking on Send Feedback. Actual URL: "
				+ actualUrl + ", Expected URL: " + expectedUrl);
		Logging.logger.info("Navigation to Send Feedback page completed.");

	}

	public void enterFeedbackDetails(String name, String email, String description) throws InterruptedException {

		HomeTab.click();
		contactUsMenu.click();
		util.waitUntilElement(driver, sendFeedbackSubMenu);

		sendFeedbackSubMenu.click();
		util.waitUntilElement(driver, sendFeedbackNameField);
		Logging.logger.info("Entering feedback details...");

		sendFeedbackNameField.sendKeys(name);
		sendFeedbackEmailField.sendKeys(email);
		feedbackDescriptionField.sendKeys(description);
		notARobotCheckbox.click();
		// Thread.sleep(30000);
		Logging.logger.info("Successfully entered feedback details.");

	}

	public void checkInlineErrorsInSendFeedback() throws InterruptedException

	{
		HomeTab.click();
		Logging.logger.info("Checking inline errors for mandatory details in Send Feedback...");

		util.waitUntilElement(driver, contactUsMenu);
		Thread.sleep(2000);

		contactUsMenu.click();
		util.waitUntilElement(driver, sendFeedbackSubMenu);

		sendFeedbackSubMenu.click();

		feedbackSubmitButton.click();

		util.waitUntilElement(driver, nameError);

		Assert.assertEquals(nameError.getText(), "Name is required", "Name error messages do not match");
		Assert.assertEquals(emailError.getText(), "Email is required", "Email error messages do not match");
		Assert.assertEquals(descriptionError.getText(), "Description is required",
				"Description error messages do not match");

		Logging.logger.info("Assertion of error messages for Send Feedback completed..");

	}

	public void submitFeedbackSuccess() {
		// Api Integration is not done in application
	}

	public void checkFeedbackFailure() {
		// Api Integration is not done in application

	}

	public void CheckFeedbackErrorCleared(String Name, String Email, String description) {

		sendFeedbackNameField.sendKeys(Name);
		sendFeedbackEmailField.sendKeys(Email);
		// util.waitUntilElement(driver, feedbackDescriptionField);

		errorDescriptionTextbox.sendKeys(description);

		try {
			Assert.assertFalse(nameError.isDisplayed(),
					"Unexpected behavior: Name error message is displayed when it should not be");
		} catch (NoSuchElementException e) {

			Logging.logger.info("Name error message element not found as expected");
		}

		try {
			Assert.assertFalse(emailError.isDisplayed(),
					"Unexpected behavior: Email error message is displayed when it should not be");
		} catch (NoSuchElementException e) {
			Logging.logger.info("Email error message element not found as expected");
		}

		try {
			Assert.assertFalse(descriptionError.isDisplayed(),
					"Unexpected behavior: Error description message is displayed when it should not be");
		} catch (NoSuchElementException e) {
			Logging.logger.info("Error description message element not found as expected");
		}

	}

	public void navigateToContactInfoPage() {
		Logging.logger.info("Navigating to Contact Info page...");

		util.waitUntilElement(driver, contactUsMenu);
		contactUsMenu.click();

		util.waitUntilElement(driver, contactInfoSubMenu);
		contactInfoSubMenu.click();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/contactinfo";
		Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch after clicking on Contact Info. Actual URL: "
				+ actualUrl + ", Expected URL: " + expectedUrl);

		Logging.logger.info("Navigation to Contact Info page completed.");

	}

	public void checkAddressContent() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				addressContentElement);
		Thread.sleep(2000);
		String expectedAddress = "Hindu Community and Cultural Center\n" + "1232 Arrowhead Ave.\n"
				+ "Livermore, CA 94551\n" + "info at livermoretemple dot org\n" + "Tax ID# 94-2427126; Inc #D0821589\n"
				+ "Main Telephone : (925) 449 6255\n" + "Alt.Telephone : (925) 449 6254\n"
				+ "Alt.Telephone : (925) 455 6229\n" + "Alt.Telephone : (925) 583 2077\n"
				+ "Alt.Telephone : (925) 583 2078\n" + "Fax : (925) 455 0404\n" + "eFax : (925) 605 1731";

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				directionContentElement);
		Thread.sleep(2000);
		// Expected direction content
		String expectedDirection = "From I-580 in Livermore:\n"
				+ "Exit N. Vasco Road.\n"
				+ "Left on Scenic Ave.\n"
				+ "Left on Arrowhead Avenue.\n"
				+ "1232 Arrowhead Avenue.\n"
				+ "Temple is on your right.";
		
		mapDataImageDisplay.isDisplayed();

		// Assert the address content
		Assert.assertEquals(addressContentElement.getText(), expectedAddress, "Address content mismatch");

		// Assert the direction content
		Assert.assertEquals(directionContentElement.getText(), expectedDirection, "Direction content mismatch");
		
		Assert.assertTrue(mapDataImageDisplay.isDisplayed(), "Image is not displayed");
		
	}

	public void CheckECMemberTableContent() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				executiveCommitteeMemberTab);
		Thread.sleep(5000);

		executiveCommitteeMemberTab.click();

		Thread.sleep(5000);

		String tableXpath = "//table[@class='contactus_tableContainer__L0-B9']";

		// Define the expected table data
		String[][] expectedData = { { "Member Name", "Committee", "Phone Number" },
				// Add more rows as needed
		};

		// Validate the table data, skipping the header row
		validateTableData(driver, tableXpath, expectedData, true);

		// Close the browser
		driver.quit();
	}

	public static void validateTableData(WebDriver driver, String tableId, String[][] expectedData,
			boolean skipHeader) {
		WebElement table = driver.findElement(By.xpath(tableId));

		// Get all rows from the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Determine the starting index based on whether to skip the header row
		int startIndex = skipHeader ? 0 : 16;

		// Check if there are rows in the table
		if (rows.size() - startIndex < expectedData.length) {
			System.out.println("Table data is not valid. Insufficient rows in the table.");
			return;
		}

		// Loop through rows and columns to validate data
		for (int i = startIndex; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < expectedData[i - startIndex].length; j++) {
				String actualData = (cols.size() > j) ? cols.get(j).getText().trim() : "";
				String expected = expectedData[i - startIndex][j].trim();

				// Compare the actual and expected data
				if (!actualData.equals(expected)) {
					System.out.println("Table data is not valid.");
					System.out.println("Expected Data: " + expected);
					System.out.println("Actual Data: " + actualData);
					return;
				}
			}
		}

		// If all data matches, print success message
		System.out.println("Table data is valid.");
	}

}