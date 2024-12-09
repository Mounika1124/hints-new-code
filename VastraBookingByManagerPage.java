package org.hints.pages;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import bsh.util.Util;

public class VastraBookingByManagerPage {

	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public VastraBookingByManagerPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement userProfileIcon;

	@FindBy(xpath = "//div[text()='Change Role']")
	private WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	private WebElement devoteeRole;

	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(xpath = "//div[text()=\"Select Purpose of Vastra\"]")
	public WebElement purposeOfVastra;

//	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]")
//	private List<WebElement> pattuSareeValue;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	public WebElement selectPurpose;

	@FindBy(xpath = "//input[@id=\"suggestedDonationAmount\"]")
	public WebElement suggestedDonationAmount;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	public WebElement dateOfAdornment;

	@FindBy(xpath = "//input[@id=\"vastraCategoryOwn\"]")
	private WebElement vastraCategoryOwn;

	@FindBy(xpath = "//input[@id=\"vastraCategoryTemple\"]")
	private WebElement vastraCategoryTemple;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "//input[@id=\"vastraExchangeReturn\"]")
	private WebElement vastraExchangeReturn;

	@FindBy(xpath = "//input[@id=\"vastraExchangeNoReturn\"]")
	private WebElement vastraExchangeNoReturn;

	@FindBy(xpath = "//div[text()=\"Select Vigraha Type\"]")
	private WebElement vigrahaType;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	private List<WebElement> vigrahaTypeDropdown;

	@FindBy(xpath = "//input[@id=\"tangibleAmount\"]")
	private WebElement tangibleAmount;

	@FindBy(xpath = "//div[@id=\"deity\"]")
	public WebElement deity;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	private List<WebElement> deityDropdown;

	@FindBy(xpath = "//textarea[@name=\"description\"]")
	public WebElement vastraDescription;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	public WebElement addVastraBtn;

	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	public WebElement cartIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Donation\"]")
	public WebElement donationMenu;

	@FindBy(xpath = "//div[@class=\"devoteeService_DonationContainer__YBl7d\"]/div/div[2]/div/div[2]/div[1]/div")
	public WebElement purposeOfDonation;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	private List<WebElement> purposeOfDonationDropdown;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g']")
	public WebElement amountOfDollarsField;

	@FindBy(xpath = "//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-30 MuiGrid-grid-sm-13 css-1q75kwg\"]/textarea[1]")
	public WebElement donationDescription;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	public WebElement addDonationBtn;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[text()=\"Pattu Saree\"]")
	public WebElement pattuSaree;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[text()=\"Melchat\"]")
	public WebElement Melchat;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[text()=\"Dhoti\"]")
	public WebElement Dhoti;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-g12m4\"]")
	public WebElement arrowCircleRightOutlinedIcon;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1v4ccyo\"]/input[@placeholder=\"Enter Credit Card Number\"]")
	public WebElement creditCardField;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[@placeholder=\"Enter CVV\"]")
	public WebElement cvvField;

	@FindBy(xpath = "//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]")
	public WebElement creditCardTypeFieldDropdown;

	@FindBy(xpath = "//div[text()=\"Master Card\"]")
	public WebElement creditCardTypeField;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	public WebElement expirydate;

	@FindBy(xpath = "//p[text()=\"Credit Card\"]")
	public WebElement creditCard;

	@FindBy(xpath = "//*[@data-testid=\"KeyboardArrowLeftIcon\"]")
	public WebElement arrowIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@id='VASTRA']")
	public WebElement vastraMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table//td[1]/p")
	public List<WebElement> tableFirstColumn;

	public void selectVastraMenuByManager() throws InterruptedException {

		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, userProfileIcon);
		Thread.sleep(4000);
		devoteeServiceMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Clicking on vastra menu");
		vastraMenu.click();
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
		Logging.logger.info("Waiting for vastra menu element to be clickable");
		util.waitUntilElement(driver, vastraMenu);
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", vastraMenu);
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra menu");
		vastraMenu.click();
		Logging.logger.info("Waiting for purpose of vastra element to be clickable");
		util.waitUntilElement(driver, purposeOfVastra);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", purposeOfVastra);
		Thread.sleep(3000);
		Logging.logger.info("Clicking on purpose of vastra");
		purposeOfVastra.click();

	}

	public void selectOwnPattuSareeForReturn() throws InterruptedException {

		Logging.logger.info("Sleeping for 4 seconds");
		Thread.sleep(4000);
		Logging.logger.info("Clicking on pattu saree");
		pattuSaree.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();
	}

	public void selectOwnPattuSareeForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		pattuSaree.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();
		suggestedDonationAmount.click();
		Logging.logger.info("Clearing the suggested donation amount field");
		suggestedDonationAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "1");

	}

	public void selectTemplePattuSareeForReturn() throws InterruptedException {

		Thread.sleep(4000);
		pattuSaree.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();

	}

	public void selectTemplePattuSareeForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		pattuSaree.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();

	}

	public void selectTempleMelchatForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		Melchat.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();

	}

	public void selectOwnMelchatForReturn() throws InterruptedException {

		Logging.logger.info("Sleeping for 4 seconds");
		Thread.sleep(4000);
		Logging.logger.info("Clicking on pattu saree");
		Melchat.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();
	}

	public void selectOwnMelchatForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		Melchat.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();
		suggestedDonationAmount.click();
		Logging.logger.info("Clearing the suggested donation amount field");
		suggestedDonationAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "1");

	}

	public void selectTempleMelchatForReturn() throws InterruptedException {

		Thread.sleep(4000);
		Melchat.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();

	}

	public void selectTempleDhotiForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		Dhoti.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();

	}

	public void selectOwnDhotiForReturn() throws InterruptedException {

		Logging.logger.info("Sleeping for 4 seconds");
		Thread.sleep(4000);
		Logging.logger.info("Clicking on pattu saree");
		Dhoti.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();
	}

	public void selectOwnDhotiForNoReturn() throws InterruptedException {

		Thread.sleep(4000);
		Dhoti.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category own");
		vastraCategoryOwn.click();
		Logging.logger.info("Clicking on vastra exchange no return");
		vastraExchangeNoReturn.click();
		suggestedDonationAmount.click();
		Logging.logger.info("Clearing the suggested donation amount field");
		suggestedDonationAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "1");

	}

	public void selectTempleDhotiForReturn() throws InterruptedException {

		Thread.sleep(4000);
		Dhoti.click();
		Thread.sleep(3000);
		Logging.logger.info("Clicking on vastra category Temple");
		vastraCategoryTemple.click();
		Logging.logger.info("Clicking on vastra exchange return");
		vastraExchangeReturn.click();

	}

	public void purchase() throws InterruptedException {

//		LocalDate currentDate = LocalDate.now();
//		
//		LocalDate futureDate = currentDate.plusDays(7);
//		System.out.println(futureDate);
//		System.out.println(currentDate);

		String amountValue = suggestedDonationAmount.getAttribute("value");
		System.out.println(amountValue);
		String formattedAmount = "$" + amountValue + ".00";
		String tangibleValue = tangibleAmount.getAttribute("value");
		System.out.println(tangibleValue);
		// Format the amount value
		String formattedAmount1 = "$" + tangibleValue + ".00";
		Thread.sleep(2000);
		util.waitUntilElement(driver, deity);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", deity);
		Thread.sleep(2000);
		deity.click();
		Thread.sleep(2000);
		Random rand = new Random();
		int deityDropdownValues = rand.nextInt(deityDropdown.size());
		deityDropdown.get(deityDropdownValues).click();
		Thread.sleep(6000);
//		String deityValue = deity.getText();
//		System.out.println(deityValue);
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
		util.waitUntilElement(driver, dateOfAdornment);

		dateOfAdornment.click();
		dateOfAdornment.click();
		dateOfAdornment.sendKeys(futureDateWithoutHyphens);
		dateOfAdornment.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
		util.waitUntilElement(driver, vigrahaType);

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", vigrahaType);
		Thread.sleep(3000);
		vigrahaType.click();
		Thread.sleep(2000);

		int vigrahaTypeDropdownValues = rand.nextInt(vigrahaTypeDropdown.size());
		deityDropdown.get(vigrahaTypeDropdownValues).click();
		vastraDescription.sendKeys("test vastra from Manager role");
		Thread.sleep(2000);
		addVastraBtn.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, cartIcon);
		util.doMoveToElement(driver, cartIcon);
		cartIcon.click();
		Thread.sleep(6000);

		WebElement table = driver.findElement(By.xpath("//tbody[@id=\"cartItemsList\"]"));

		util.waitUntilElement(driver, table);

		String expectedVastraPurpose = "VASTRA";
		String expectedVastraAmount = formattedAmount;
		String expectedTangibleAmount = formattedAmount1;
		// String expecteddeityValue = deity.getText();

		// Get all the rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		boolean rowFound = false;
		// Iterate over the rows
		for (WebElement row : rows) {
			// Get the cells in each row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= 8) {
				// Check if the 4th and 5th cell contain the expected data
				if (cells.get(5).getText().equals(expectedVastraPurpose)
						&& cells.get(7).getText().equals(expectedVastraAmount)
						&& cells.get(8).getText().equals(expectedTangibleAmount)) {
					js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);
					rowFound = true;
					break;
				}
			}
		}

		Thread.sleep(4000);

		// Assert that the row is found
		Assert.assertTrue(rowFound, "Row with data in 5th column '" + expectedVastraPurpose + "' and 7th column '"
				+ expectedVastraAmount + "' and 8th column '" + expectedTangibleAmount + "' not found in the table.");

		Thread.sleep(2000);

	}

	public void makecreditCardPayment() {
		util.waitUntilElement(driver, creditCard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", creditCard);
		creditCard.click();
	}

}
