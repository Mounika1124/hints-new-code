package org.hints.pages;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

//import org.hints.testcases.ForgotUsernamePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LadduKarasevMenuPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);
	PoojaBookingPage poojaPage = new PoojaBookingPage(driver);

	public LadduKarasevMenuPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;

	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(id = "LADDU_OR_KARASEV_OR_VADA")
	private WebElement ladduKaraVadaSubMenu;

	@FindBy(xpath = "//div[text()=\"Prasadam\"]")
	private WebElement prasadamDropdown;
	
	@FindBy(xpath = "//li[text()='VADA']")
	private WebElement vadaPrasadamOption;

	@FindBy(id = "add")
	private WebElement addPrasadamButton;

	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	private WebElement cartBadgeElement;

	@FindBy(id = "suggestedDonationAmount")
	private WebElement amountInDollarsField;

	@FindBy(xpath = "//input[@value=\"Calendar\"]")
	private WebElement calendarRadioButton;

	@FindBy(id = "grouped-select")
	private WebElement groupedSelectDropdown;

	@FindBy(xpath = "//img[@src='/images/successImage.svg']")
	private WebElement successImage;

	@FindBy(xpath = "//li[text()=\"8\"]")
	private WebElement calendarDay;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "(//div[@id='quantity'])[2]")
	private WebElement calenderQuantity;

	@FindBy(xpath = "//li[@data-value='3']")
	private WebElement listItemWithValueThree;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addCalendar;

	@FindBy(xpath = "(//button[@id='closeButton'])[2]")

	private WebElement calendarPopupclose;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//*[@data-testid=\"KeyboardArrowLeftIcon\"]")
	public WebElement arrowIcon;

	@FindBy(xpath = "//div[@id='VASTRA']")
	public WebElement vastraMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table//td[1]/p")
	public List<WebElement> tableFirstColumn;

	// li[@data-value="3"]

	public void addPrasadamItemToCart() throws InterruptedException {
		Thread.sleep(3000);
		UserProfileIcon.click();
		changeRoleMenu.click();
		devoteeRole.click();
		util.waitUntilElement(driver, bookPoojaHallButton);

		// Scroll to the relevant elements
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
		bookPoojaHallButton.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", ladduKaraVadaSubMenu);
		util.waitUntilElement(driver, ladduKaraVadaSubMenu);
		ladduKaraVadaSubMenu.click();
		Thread.sleep(1000);
		// cartBadgeElement.click();
		prasadamDropdown.click();

		util.waitUntilElement(driver, vadaPrasadamOption);

		vadaPrasadamOption.click();

		// Get the amount value from the field
		String amountValue = amountInDollarsField.getAttribute("value");

		// Format the amount value
		String formattedAmount = "$" + amountValue + ".00";

		addPrasadamButton.click();

		util.waitUntilElement(driver, closeButton);

		closeButton.click();

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(1000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();
		// Define the expected values for comparison

		Thread.sleep(4000);

		WebElement table = driver.findElement(By.xpath("//tbody[@id=\"cartItemsList\"]"));

		util.waitUntilElement(driver, table);

		String expectedPrasadamItem = "VADA";
		String expectedPrasadamAmount = formattedAmount;

		// Get all the rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		boolean rowFound = false;
		// Iterate over the rowss
		for (WebElement row : rows) {
			// Get the cells in each row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= 7) {
				// Check if the 4th and 5th cell contain the expected data
				if (cells.get(5).getText().equals(expectedPrasadamItem)
						&& cells.get(7).getText().equals(expectedPrasadamAmount)) {

					// Highlight the row with a thick yellow border
					js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);

					rowFound = true;
					break;
				}
			}
		}

		Thread.sleep(1000);
		// Assert that the row is found
		Assert.assertTrue(rowFound, "Row with data in 4th column '" + expectedPrasadamItem + "' and 5th column '"
				+ expectedPrasadamAmount + "' not found in the table.");
	}

	public void addCalendarToCart() throws InterruptedException {
		Thread.sleep(3000);
		UserProfileIcon.click();
		changeRoleMenu.click();
		devoteeRole.click();
		util.waitUntilElement(driver, bookPoojaHallButton);
		Thread.sleep(2000);
		// Scroll to the relevant elements
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
		bookPoojaHallButton.click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", ladduKaraVadaSubMenu);

		util.waitUntilElement(driver, ladduKaraVadaSubMenu);
		ladduKaraVadaSubMenu.click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", calendarRadioButton);
		util.waitUntilElement(driver, ladduKaraVadaSubMenu);

		calendarRadioButton.click();
		Thread.sleep(3000);

		calenderQuantity.click();
		util.waitUntilElement(driver, listItemWithValueThree);

		listItemWithValueThree.click();
		util.waitUntilElement(driver, addCalendar);
		addCalendar.click();
		util.waitUntilElement(driver, calendarPopupclose);

		calendarPopupclose.click();

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(2000);
		util.waitUntilElement(driver, cartBadgeElement);

		cartBadgeElement.click();

	}

	public void navigateToLadduKaravadaMenu() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		util.waitUntilElement(driver, devoteeServiceMenu);
		devoteeServiceMenu.click();
		Logging.logger.info("Clicking on Register Devotee menu");
		ladduKaraVadaSubMenu.click();
		Thread.sleep(3000);
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
	}

	public void addCalendarToCartFromDevoteeService() throws InterruptedException {
		calendarRadioButton.click();
		Thread.sleep(3000);

		calenderQuantity.click();
		listItemWithValueThree.click();

		addCalendar.click();
		Thread.sleep(2000);

		calendarPopupclose.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(2000);

		cartBadgeElement.click();
		
	}

	public void addPrasadamToCartFromDevoteeService() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		prasadamDropdown.click();

		util.waitUntilElement(driver, vadaPrasadamOption);

		vadaPrasadamOption.click();

		// Get the amount value from the field
		String amountValue = amountInDollarsField.getAttribute("value");

		// Format the amount value
		String formattedAmount = "$" + amountValue + ".00";

		addPrasadamButton.click();

		util.waitUntilElement(driver, closeButton);

		closeButton.click();

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(1000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();
		// Define the expected values for comparison

		Thread.sleep(4000);

		WebElement table = driver.findElement(By.xpath("//tbody[@id='cartItemsList']"));

		util.waitUntilElement(driver, table);
		System.out.println(driver.getPageSource());


		String expectedPrasadamItem = "VADA";
		String expectedPrasadamAmount = formattedAmount;

		// Get all the rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		boolean rowFound = false;
		// Iterate over the rowss
		for (WebElement row : rows) {
			// Get the cells in each row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= 7) {
				// Check if the 4th and 5th cell contain the expected data
				if (cells.get(5).getText().equals(expectedPrasadamItem)
						&& cells.get(7).getText().equals(expectedPrasadamAmount)) {

					// Highlight the row with a thick yellow border
					js.executeScript("arguments[0].style.backgroundColor = 'blue';", row);

					rowFound = true;
					break;
				}
			}
		}

		Thread.sleep(1000);
		// Assert that the row is found
		Assert.assertTrue(rowFound, "Row with data in 4th column '" + expectedPrasadamItem + "' and 5th column '"
				+ expectedPrasadamAmount + "' not found in the table.");
	}

}