package org.hints.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.hints.utility.DataProviderFactory;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class MatchingDonationsPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public MatchingDonationsPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@id=\"MATCHING_DONATIONS\"]")
	public WebElement matchingDonationsMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table[@class=\"devoteeService_tableContainer__e2zxA\"]")
	public WebElement table;

	@FindBy(xpath = "//table//td[1]/p")
	public List<WebElement> tableFirstColumn;

	@FindBy(xpath = "//div[@id=\"purposeOfDonation\"]")
	public WebElement purposeOfDonation;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g\"]")
	public WebElement amountOfDollarsMatchingDonation;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> purposeOfDonationDropdown;

	@FindBy(xpath = "//input[@id=\"disbursementReference\"]")
	public WebElement disbursementReference;

	@FindBy(xpath = "//div[@class=\"MuiStack-root css-froe0x\"]/div/div/input")
	public WebElement periodEnding;
	
	@FindBy(xpath = "	(//div[@class=\"MuiStack-root css-froe0x\"]/div/div/input)[2]")
	public WebElement periodEndingannvastra;


	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "//button[text()=\"Search Devotee\"]")
	public WebElement searchDevoteeBtn;

	@FindBy(xpath = "//input[@id=\"signInName\"]")
	public WebElement signInNameTextBox;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement searchBtn;

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> FirstColumn;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[3]")
	public WebElement amountField;
	
	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[4]")
	public WebElement amountField1;
	

	@FindBy(xpath = "(//textarea[@class=\"devoteeService_textArea__k6qY+\"])[1]")
	public WebElement descriptiontextfield;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	public WebElement addBtn;
	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	public WebElement cartIcon;
	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"])[1]")
	public WebElement serviceDate;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	public WebElement messageToBeDisplayed;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	public WebElement vastraCode;
	
	@FindBy(xpath = "//p[text()=\"Disbursement reference already exists.\"]")
	public WebElement disbursementErrorPopup;
	
	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[4]")
	public WebElement annadana;
	
	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[104]")
	public WebElement vastra;
	
	
	
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 common_SuccessMessageContent__tHijm css-9l3uo3\"]")
	public WebElement successPopup;
	
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-eals3p\"]")
	public WebElement popUpElement;
	
	
	
	
	
	public void searchDevotee() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		Thread.sleep(4000);
		devoteeServiceMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Clicking on matchingDonations menu");
		matchingDonationsMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Entering username: testwr...");
		signInName.sendKeys("david54");
		SearchButton.click();
		Logging.logger.info("Entered username: testwr and clicked on Search Button");
		Thread.sleep(4000);
		Random rand = new Random();
		int SignInIndex = rand.nextInt(tableFirstColumn.size());
		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
		tableFirstColumn.get(SignInIndex).click();
		Logging.logger.info("Clicked on a random element in tableFirstColumn");
		Thread.sleep(2000);
	}

	public void navigateToMatchingdonations() throws InterruptedException {

		Logging.logger.info("Waiting for purpose of donation element to be clickable");
		Random rand = new Random();
		util.waitUntilElement(driver, purposeOfDonation);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", purposeOfDonation);
		Thread.sleep(3000);
		purposeOfDonation.click();
		Thread.sleep(3000);
		//annadana.click();
		//vastra.click();
		int donationIndex = rand.nextInt(purposeOfDonationDropdown.size());
		purposeOfDonationDropdown.get(donationIndex).click();
		System.out.println(purposeOfDonation.getText());
		Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
		if (purposeOfDonation.getText().equals("ANNADAANA")) {

			messageToBeDisplayed.sendKeys("Annadana event is going on");
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusDays(7);

			// Define the date formatter
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

			// Format the dates
			String formattedCurrentDate = currentDate.format(formatter);
			String formattedFutureDate = futureDate.format(formatter);

			// Remove hyphens from the future date
			String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");

			// Print the formatted dates

			System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
			util.waitUntilElement(driver, serviceDate);

			serviceDate.click();
			serviceDate.click();
			serviceDate.sendKeys(futureDateWithoutHyphens);
			serviceDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			util.waitUntilElement(driver, periodEndingannvastra);

			periodEndingannvastra.click();
			periodEndingannvastra.click();
			periodEndingannvastra.sendKeys(futureDateWithoutHyphens);
			periodEndingannvastra.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			int randomAmount = new Random().nextInt(10000);
			amountOfDollarsMatchingDonation.sendKeys(String.valueOf(randomAmount));
			String amount = amountOfDollarsMatchingDonation.getAttribute("value");
			Logging.logger.info("Entered random amount for donation: " + amount);
			amountField1.sendKeys(amount);
			Thread.sleep(2000);
			disbursementReference.sendKeys("9621");
			int randomReference = new Random().nextInt(10000);
			disbursementReference.sendKeys(String.valueOf(randomReference));
			String randomReferenceValue = disbursementReference.getAttribute("value");
			System.out.println(randomReferenceValue);
			((JavascriptExecutor) driver).executeScript("arguments[0].blur();", disbursementReference);
			searchDevoteeBtn.click();
			Thread.sleep(2000);
			signInNameTextBox.sendKeys("abkulkarni");
			searchBtn.click();
			Thread.sleep(4000);
			int SignInNameIndex = rand.nextInt(FirstColumn.size());
			FirstColumn.get(SignInNameIndex).click();
			Thread.sleep(2000);
			descriptiontextfield.sendKeys("test matching donations");
			addBtn.click();
			Thread.sleep(1000);

//			util.waitUntilElement(driver, closeButton);
//			closeButton.click();
			if(successPopup.isDisplayed()) {
			closeButton.click();
//				disbursementReference.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//				int randomReference1 = new Random().nextInt(10000);
//				disbursementReference.sendKeys(String.valueOf(randomReference1));
				//addBtn.click();
				//util.waitUntilElement(driver, closeButton);
			    //closeButton.click();
				util.waitUntilElement(driver, cartIcon);
				util.doMoveToElement(driver, cartIcon);
				cartIcon.click();
				Thread.sleep(6000);
				WebElement table = driver.findElement(By.xpath("//tbody[@id=\"cartItemsList\"]"));

				util.waitUntilElement(driver, table);

				String expectedDonation = "Donation";

				// Get all the rows in the table
				List<WebElement> rows = table.findElements(By.tagName("tr"));

				boolean rowFound = false;
				// Iterate over the rows
				for (WebElement row : rows) {
					// Get the cells in each row
					List<WebElement> cells = row.findElements(By.tagName("td"));

					if (cells.size() >= 8) {
						// Check if the 4th and 5th cell contain the expected data
						if (cells.get(0).getText().equals(expectedDonation)) {
							js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);
							rowFound = true;
							break;
						}
					}

					Thread.sleep(4000);

					// Assert that the row is found
					Assert.assertTrue(rowFound, "Row with data in 0th column '" + "' not found in the table.");
					Logging.logger.info("Row with data in 0th column found in the table.");
					Thread.sleep(4000);

					Logging.logger.info("Navigation to Matching Donations page completed successfully.");

				}
			}

			
		}
		else if (purposeOfDonation.getText().equals("VASTRA")) {
			
			vastraCode.sendKeys("1256");
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusDays(7);

			// Define the date formatter
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

			// Format the dates
			String formattedCurrentDate = currentDate.format(formatter);
			String formattedFutureDate = futureDate.format(formatter);

			// Remove hyphens from the future date
			String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");

			// Print the formatted dates

			System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
			util.waitUntilElement(driver, serviceDate);

			serviceDate.click();
			serviceDate.click();
			serviceDate.sendKeys(futureDateWithoutHyphens);
			serviceDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			util.waitUntilElement(driver, periodEndingannvastra);

			periodEndingannvastra.click();
			periodEndingannvastra.click();
			periodEndingannvastra.sendKeys(futureDateWithoutHyphens);
			periodEndingannvastra.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			int randomAmount = new Random().nextInt(10000);
			amountOfDollarsMatchingDonation.sendKeys(String.valueOf(randomAmount));
			String amount = amountOfDollarsMatchingDonation.getAttribute("value");
			Logging.logger.info("Entered random amount for donation: " + amount);
			amountField1.sendKeys(amount);
			Thread.sleep(2000);
			disbursementReference.sendKeys("9621");
			int randomReference = new Random().nextInt(10000);
			disbursementReference.sendKeys(String.valueOf(randomReference));
			String randomReferenceValue = disbursementReference.getAttribute("value");
			System.out.println(randomReferenceValue);
			((JavascriptExecutor) driver).executeScript("arguments[0].blur();", disbursementReference);
			searchDevoteeBtn.click();
			Thread.sleep(2000);
			signInNameTextBox.sendKeys("abkulkarni");
			searchBtn.click();
			Thread.sleep(4000);
			int SignInNameIndex = rand.nextInt(FirstColumn.size());
			FirstColumn.get(SignInNameIndex).click();
			Thread.sleep(2000);
			descriptiontextfield.sendKeys("test matching donations");
			addBtn.click();
			Thread.sleep(1000);

//			util.waitUntilElement(driver, closeButton);
//			closeButton.click();
			if(successPopup.isDisplayed()) {
			closeButton.click();
//				disbursementReference.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//				int randomReference1 = new Random().nextInt(10000);
//				disbursementReference.sendKeys(String.valueOf(randomReference1));
				//addBtn.click();
				//util.waitUntilElement(driver, closeButton);
			    //closeButton.click();
				util.waitUntilElement(driver, cartIcon);
				util.doMoveToElement(driver, cartIcon);
				cartIcon.click();
				Thread.sleep(6000);
				WebElement table = driver.findElement(By.xpath("//tbody[@id=\"cartItemsList\"]"));

				util.waitUntilElement(driver, table);

				String expectedDonation = "Donation";

				// Get all the rows in the table
				List<WebElement> rows = table.findElements(By.tagName("tr"));

				boolean rowFound = false;
				// Iterate over the rows
				for (WebElement row : rows) {
					// Get the cells in each row
					List<WebElement> cells = row.findElements(By.tagName("td"));

					if (cells.size() >= 8) {
						// Check if the 4th and 5th cell contain the expected data
						if (cells.get(0).getText().equals(expectedDonation)) {
							js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);
							rowFound = true;
							break;
						}
					}

					Thread.sleep(4000);

					// Assert that the row is found
					Assert.assertTrue(rowFound, "Row with data in 0th column '" + "' not found in the table.");
					Logging.logger.info("Row with data in 0th column found in the table.");
					Thread.sleep(4000);

					Logging.logger.info("Navigation to Matching Donations page completed successfully.");

				}
			}

		}
		else {
//			if (!purposeOfDonationDropdown.isEmpty()) {
//				int donationIndex;
//				do {
//					donationIndex = rand.nextInt(purposeOfDonationDropdown.size());
//				} while (donationIndex >= purposeOfDonationDropdown.size());
//				purposeOfDonationDropdown.get(donationIndex).click();
//			} else {
//				// Handle the case when the dropdown is empty
//				// For example, log a message or throw an exception
//				System.out.println("Dropdown is empty");
//			}
		

			System.out.println(purposeOfDonation.getText());
			Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
			Thread.sleep(6000);
			int randomAmount = new Random().nextInt(10000);
			amountOfDollarsMatchingDonation.sendKeys(String.valueOf(randomAmount));
			String amount = amountOfDollarsMatchingDonation.getAttribute("value");
			Logging.logger.info("Entered random amount for donation: " + amount);
			// js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block:
			// 'center' });", disbursementReference);
			Thread.sleep(2000);
			disbursementReference.sendKeys("9621");
//			int randomReference = new Random().nextInt(10000);
//			disbursementReference.sendKeys(String.valueOf(randomReference));
//			String randomReferenceValue = disbursementReference.getAttribute("value");
//			System.out.println(randomReferenceValue);
			((JavascriptExecutor) driver).executeScript("arguments[0].blur();", disbursementReference);

			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusDays(7);

			// Define the date formatter
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

			// Format the dates
			String formattedCurrentDate = currentDate.format(formatter);
			String formattedFutureDate = futureDate.format(formatter);

			// Remove hyphens from the future date
			String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");

			// Print the formatted dates

			System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
			util.waitUntilElement(driver, periodEnding);

			periodEnding.click();
			periodEnding.click();
			periodEnding.sendKeys(futureDateWithoutHyphens);
			periodEnding.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			searchDevoteeBtn.click();
			Thread.sleep(2000);
			signInNameTextBox.sendKeys("abkulkarni");
			searchBtn.click();
			Thread.sleep(4000);
			int SignInNameIndex = rand.nextInt(FirstColumn.size());
			FirstColumn.get(SignInNameIndex).click();
			Thread.sleep(2000);
			amountField.sendKeys(amount);
			descriptiontextfield.sendKeys("test matching donations");
			addBtn.click();
			Thread.sleep(1000);

//			util.waitUntilElement(driver, closeButton);
//			closeButton.click();
			if(disbursementErrorPopup.isDisplayed()) {
				closeButton.click();
				disbursementReference.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
				int randomReference1 = new Random().nextInt(10000);
				disbursementReference.sendKeys(String.valueOf(randomReference1));
				addBtn.click();
				util.waitUntilElement(driver, closeButton);
			    closeButton.click();
				util.waitUntilElement(driver, cartIcon);
				util.doMoveToElement(driver, cartIcon);
				cartIcon.click();
				Thread.sleep(6000);
				WebElement table = driver.findElement(By.xpath("//tbody[@id=\"cartItemsList\"]"));

				util.waitUntilElement(driver, table);

				String expectedDonation = "Donation";

				// Get all the rows in the table
				List<WebElement> rows = table.findElements(By.tagName("tr"));

				boolean rowFound = false;
				// Iterate over the rows
				for (WebElement row : rows) {
					// Get the cells in each row
					List<WebElement> cells = row.findElements(By.tagName("td"));

					if (cells.size() >= 8) {
						// Check if the 4th and 5th cell contain the expected data
						if (cells.get(0).getText().equals(expectedDonation)) {
							js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);
							rowFound = true;
							break;
						}
					}

					Thread.sleep(4000);

					// Assert that the row is found
					Assert.assertTrue(rowFound, "Row with data in 0th column '" + "' not found in the table.");
					Logging.logger.info("Row with data in 0th column found in the table.");
					Thread.sleep(4000);

					Logging.logger.info("Navigation to Matching Donations page completed successfully.");

				}
			}

		
	}
		
	}
	
	public void captureAlertMessage() throws InterruptedException {

		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		Thread.sleep(4000);
		devoteeServiceMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Clicking on matchingDonations menu");
		matchingDonationsMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Entering username: vivek0...");
		signInName.sendKeys("vivek0");
		SearchButton.click();
		Logging.logger.info("Entered username: vivek0 and clicked on Search Button");
		Thread.sleep(4000);
		Random rand = new Random();
		int SignInIndex = rand.nextInt(tableFirstColumn.size());
		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
		tableFirstColumn.get(SignInIndex).click();
		Logging.logger.info("Clicked on a random element in tableFirstColumn");
		Thread.sleep(2000);
		Logging.logger.info("Waiting for purpose of donation element to be clickable");
		util.waitUntilElement(driver, purposeOfDonation);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", purposeOfDonation);
		Thread.sleep(3000);
		purposeOfDonation.click();
		Thread.sleep(3000);
//		WebElement option = vastraValue;
//		option.click();
//		int donationIndex = rand.nextInt(purposeOfDonationDropdown.size());
//		purposeOfDonationDropdown.get(donationIndex).click();
		System.out.println(purposeOfDonation.getText());
		Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
		if (purposeOfDonation.getText().equals("ANNADAANA")) {
			serviceDate.click();
			serviceDate.click();
			serviceDate.sendKeys("07092026");
			messageToBeDisplayed.sendKeys("Annadana event is going on");
		} else if (purposeOfDonation.getText().equals("VASTRA")) {
			serviceDate.click();
			serviceDate.click();
			serviceDate.sendKeys("11242024");
			vastraCode.sendKeys("1256");
			Thread.sleep(3000);
		} else {
			if (!purposeOfDonationDropdown.isEmpty()) {
				int donationIndex;
				do {
					donationIndex = rand.nextInt(purposeOfDonationDropdown.size());
				} while (donationIndex >= purposeOfDonationDropdown.size());
				purposeOfDonationDropdown.get(donationIndex).click();
			} else {
				// Handle the case when the dropdown is empty
				// For example, log a message or throw an exception
				System.out.println("Dropdown is empty");
			}

			System.out.println(purposeOfDonation.getText());
			Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
			Thread.sleep(6000);
			int randomAmount = new Random().nextInt(1000000);
			amountOfDollarsMatchingDonation.sendKeys(String.valueOf(randomAmount));
			String amount = amountOfDollarsMatchingDonation.getAttribute("value");
			Logging.logger.info("Entered random amount for donation: " + amount);
			// js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block:
			// 'center' });", disbursementReference);
			Thread.sleep(2000);
			disbursementReference.sendKeys("123456");
			Thread.sleep(4000);
			periodEnding.click();
			periodEnding.click();
			Thread.sleep(4000);
			periodEnding.sendKeys("09102025");
			searchDevoteeBtn.click();
			Thread.sleep(4000);
			signInNameTextBox.sendKeys("abkulkarni");
			searchBtn.click();
			Thread.sleep(4000);
			Thread.sleep(4000);
			int SignInNameIndex = rand.nextInt(FirstColumn.size());
			tableFirstColumn.get(SignInNameIndex).click();
			Thread.sleep(2000);
			int randomAmount1 = new Random().nextInt(10000);
			amountField.sendKeys(String.valueOf(randomAmount1));
			descriptiontextfield.sendKeys("test");
			addBtn.click();
			Thread.sleep(4000);
			util.waitUntilElement(driver, popUpElement);
			String popUptext = popUpElement.getText();
			System.out.println(popUptext);

		}

	}
	}


