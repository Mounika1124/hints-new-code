package org.hints.pages;

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

public class HallBookingPage {

	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);

	public HallBookingPage(WebDriver Idriver) {
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

	@FindBy(id = "minutes")
	public WebElement minutesInput;

	@FindBy(xpath = "//button[text()=\"Ok\"]")
	private WebElement OkBtn;

	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root devoteeBooking_halltextfields__-EL+q css-4vxbox\"]")
	private WebElement name;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	private WebElement numberofHrs;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[3]")
	private WebElement numberofMins;

	@FindBy(xpath = "(//textarea[@class=\"devoteeBooking_textArea__1ZiTO\"])[1]")
	public WebElement descriptiontextfield;

	@FindBy(xpath = "//button[text()=\"Send Request\"]")
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

	public void bookHall() throws InterruptedException {

		util.waitUntilElement(driver, UserProfileIcon);

		UserProfileIcon.click();

		util.waitUntilElement(driver, changeRoleMenu);

		changeRoleMenu.click();

		util.waitUntilElement(driver, devoteeRole);

		devoteeRole.click();

		util.waitUntilElement(driver, bookPoojaHallButton);

		// Highlight the element using JavaScript

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);

		Thread.sleep(4000);

		bookPoojaHallButton.click();

		util.waitUntilElement(driver, HallRequestMenu);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", HallRequestMenu);

		HallRequestMenu.click();
		selectHallTextBox.click();
		Thread.sleep(3000);
		Random rand = new Random();
		int hallIndex = rand.nextInt(selectHallDropDown.size());
		Thread.sleep(3000);
		selectHallDropDown.get(hallIndex).click();
		bookingDate.click();
		bookingDate.click();
		Thread.sleep(4000);
		bookingDate.sendKeys("06082024");
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

		//Thread.sleep(4000);
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

	public void managerDashbaord() throws InterruptedException {

		util.waitUntilElement(driver, UserProfileIcon);

		UserProfileIcon.click();

		firstNameTextBox.sendKeys("David");
		RequestTypeTextBox.click();
		Thread.sleep(2000);
		RequestTypeDropdown.click();
		statusTypeTextBox.click();
		Thread.sleep(2000);
		statusTypeDropdown.click();
		Thread.sleep(4000);

//		List<String> HallBookingRequestDetails = new ArrayList<>();
//		// hallDetails.add(defaultFirstName.getAttribute("value"));
//		HallBookingRequestDetails.add(selectHallTextBox.getAttribute("value"));
//		HallBookingRequestDetails.add(bookingDate.getAttribute("value"));
//		HallBookingRequestDetails.add(bookingTime.getAttribute("value"));
//
//		System.out.println("Hall booking Request Details from Manager dashboard:");
//		for (String detail : HallBookingRequestDetails) {
//			System.out.println(detail);
//		}
//
//		if (hallDetails.size() == HallBookingRequestDetails.size()
//				&& hallDetails.containsAll(HallBookingRequestDetails)) {
//			System.out.println("Hall details are the same.");
//			Assert.assertTrue(true, "Hall details are the same.");
//		} else {
//			System.out.println("Hall details are different.");
//			Assert.fail("Hall details are different.");
//		}
//		
//
//	}
//
	}
	
	
}
