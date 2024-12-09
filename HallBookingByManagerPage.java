package org.hints.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HallBookingByManagerPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);

	public HallBookingByManagerPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Event Hall Booking Request\"]")
	public WebElement HallRequestMenu;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[1]")
	public WebElement selectHallTextBox;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> selectHallDropDown;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	public WebElement bookingDate;

	@FindBy(id = "timepicker")
	public WebElement bookingTime;

	@FindBy(id = "hrs")
	public WebElement hoursInput;

	@FindBy(xpath = "//input[@id=\"minutes\"]")
	public WebElement minutesInput;

	@FindBy(xpath = "//button[text()=\"Ok\"]")
	private WebElement OkBtn;

	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root devoteeBooking_halltextfields__-EL+q css-4vxbox\"]")
	private WebElement name;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	private WebElement numberofHrs;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[3]")
	private WebElement numberofMins;

	@FindBy(xpath = "(//textarea[@class=\"devoteeService_textField__aRRTJ\"])[1]")
	public WebElement descriptiontextfield;

	@FindBy(xpath = "//button[text()=\"Schedule Hall\"]")
	public WebElement sendRequestBtn;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[position() < last()]")
	public List<WebElement> hrsDropdown;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> minsDropdown;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[1]")
	public WebElement firstNameTextBox;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	public WebElement LastNameTextBox;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[1]")
	public WebElement RequestTypeTextBox;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[3]")
	public WebElement RequestTypeDropdown;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	public WebElement statusTypeTextBox;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[10]")
	public WebElement statusTypeDropdown;

	@FindBy(xpath = "(//button[@id=\"closeButton\"])[1]")
	private WebElement closeButton;
	

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> tableFirstColumn;
	
	@FindBy(id = "HALL_RENTAL")
	public WebElement hallRentalMenu;
	
	
	public void navigateToHallRentalMenu() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		util.waitUntilElement(driver, devoteeServiceMenu);
		devoteeServiceMenu.click();
		Logging.logger.info("Clicking on Register Devotee menu");
		hallRentalMenu.click();
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

	public void bookHallByManager() throws InterruptedException {

		
		selectHallTextBox.click();
		Thread.sleep(3000);
		Random rand = new Random();
		int hallIndex = rand.nextInt(selectHallDropDown.size());
		Thread.sleep(3000);
		selectHallDropDown.get(hallIndex).click();
		bookingDate.click();
		bookingDate.click();
		Thread.sleep(4000);
		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(7);

		// Define the date formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

		// Format the dates
		String formattedCurrentDate = currentDate.format(formatter);
		String formattedFutureDate = futureDate.format(formatter);
		System.out.println(formattedFutureDate);

		// Remove hyphens from the future date
		String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");

		// Print the formatted dates

		System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
		util.waitUntilElement(driver, bookingDate);

		bookingDate.click();
		bookingDate.click();
		bookingDate.sendKeys(futureDateWithoutHyphens);

		bookingTime.click();
		hoursInput.click();
		hoursInput.sendKeys("07");
//
		util.waitUntilElement(driver, minutesInput);

		minutesInput.sendKeys("40");

		util.waitUntilElement(driver, OkBtn);

		OkBtn.click();
		numberofHrs.click();

		Thread.sleep(4000);
		List<WebElement> options = hrsDropdown;
		// Generate a random number excluding the first 5 options
		int randomIndex = rand.nextInt(options.size() - 4) + 4; // Adjusted range

		// Click on the randomly selected option
		options.get(randomIndex).click();

		Thread.sleep(4000);
		numberofMins.click();
		int minsIndex = rand.nextInt(minsDropdown.size());
		Thread.sleep(3000);
		minsDropdown.get(minsIndex).click();
		descriptiontextfield.sendKeys("test");
		Logging.logger.info("Retrieving Entered hall details...");
		List<String> hallDetails = new ArrayList<>();
		// hallDetails.add(defaultFirstName.getAttribute("value"));
		hallDetails.add(selectHallTextBox.getAttribute("value"));
		hallDetails.add(bookingDate.getAttribute("value"));
		hallDetails.add(bookingTime.getAttribute("value"));

		// Print default address details
		System.out.println("Entered all Details:");
		for (String detail : hallDetails) {
			System.out.println(detail);
		}
		sendRequestBtn.click();
		//Thread.sleep(10000);
		try {

			util.waitUntilElement(driver, closeButton);

		}

		catch (

		ElementClickInterceptedException e) {
			Thread.sleep(1000);
			closeButton.click();
		} catch (Exception e) {
			// Handle other exceptions (if any) here
			e.printStackTrace(); // Print the stack trace for debugging
		}
	}

}
