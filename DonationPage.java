package org.hints.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DonationPage {

	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public DonationPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[text() ='Donation']")
	public WebElement Donation_menu;

	@FindBy(xpath = "//label[text()='First Name']//following::input[1]")
	public WebElement Donation_Fname;

	@FindBy(xpath = "//label[text()='Last Name']//following::input[1]")
	public WebElement Donation_Lname;

	@FindBy(xpath = "//label[text()='Phone No']//following::input[1]")
	public WebElement Donation_PhoneNo;

	@FindBy(xpath = "//label[text()='Email']//following::input[1]")
	public WebElement Donation_Email;

	@FindBy(xpath = "//label[text()='Amount (in dollars)']//following::input[1]")
	public WebElement Donation_Amount;

	@FindBy(xpath = "//label[text()='Zip Code']//following::input[1]")
	public WebElement Donation_ZipCode;

	@FindBy(xpath = "//label[text()='City']//following::input[1]")
	public WebElement Donation_City;

	@FindBy(xpath = "//label[text()='State']//following::input[1]")
	public WebElement Donation_State;

	@FindBy(xpath = "//div[@id='donationPurpose']")
	public WebElement Donation_Drop;

	@FindBy(xpath = "//li[normalize-space()='ANNADANA HALL']")
	public WebElement Donation_purpose;

	@FindBy(xpath = "//img[@src=\"/images/CreditCard.svg\"]")
	public WebElement creditCard;

	@FindBy(xpath = "//button[text()=\"Proceed\"]")
	public WebElement proceedButton;

	@FindBy(xpath = "//input[@placeholder=\"Enter Credit Card Number\"]")
	public WebElement creditCardFeild;

	@FindBy(xpath = "//input[@placeholder=\"Enter CVV\"]")
	public WebElement cvvField;

	@FindBy(xpath = "//input[@value=\"Master Card\"]")
	public WebElement creditCardTypeField;

	@FindBy(xpath = "//input[@class ='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	public WebElement expirydate;

	@FindBy(id = "makePayment")
	public WebElement paymentButton;

	@FindBy(xpath = "//div[@class=\"success_animationCtn__zlYbs\"]")
	public WebElement Paymentsuccess;

	@FindBy(xpath = "//div[@class=\"devotee_donateButtonContainer__FSVWn MuiBox-root css-0\"][1]")

	public WebElement specialEventdonateButton;

	@FindBy(xpath = "//div[normalize-space()='Click here to Generate Receipt']")

	public WebElement GenerateReceipt;

	@FindBy(xpath = "//div[@class=\"Information_singleCard__KR463\"][1]")
	public WebElement award1;

	@FindBy(xpath = "//div[@class=\"Information_singleCard__KR463\"][2]")
	public WebElement award2;

	@FindBy(xpath = "//div[@class='menuBar_tab__3haMu'][3]")
	public WebElement informationMenu;

	@FindBy(xpath = "(//div[text()=\"Awards\"]")
	public WebElement awardsSubmenu;

	@FindBy(xpath = "//div[text()='Click here to Generate Receipt']")
	public WebElement GeneratedReceipt;

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-g12m4\"]")
	public WebElement arrowCircleRightOutlinedIcon;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[1]")
	private WebElement defaultFirstName;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[2]")
	private WebElement defaultLastName;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[3]")
	private WebElement defaultAddress;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[4]")
	private WebElement defaultZipCode;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[5]")
	private WebElement defaultCity;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[6]")
	private WebElement defaultState;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[7]")
	private WebElement defaultCountry;

	@FindBy(xpath = "(//input[@placeholder='Enter First Name'])")
	private WebElement populatedFirstName;

	@FindBy(xpath = "(//input[@placeholder='Enter Last Name'])")
	private WebElement populatedLastName;

	@FindBy(id = "address-edit")
	private WebElement populatedAddress;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 devoteeService_singlePay__BuSNL css-9l3uo3\"])[1]")
	private WebElement totalAmount;

	@FindBy(xpath = "//input[@placeholder='Enter Zipcode']")
	private WebElement populatedZipCode;

	@FindBy(xpath = "((//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[8])")
	private WebElement populatedCity;

	@FindBy(xpath = "(((//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-readOnly MuiInputBase-readOnly css-1x5jdmq'])[9]))")
	private WebElement populatedState;

	@FindBy(xpath = "//input[@placeholder='Enter Country']")
	private WebElement populatedCountry;

	@FindBy(xpath = "//input[@id='address']")
	private WebElement addressField;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement userProfileIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Donation\"]")
	public WebElement donationMenu;

	@FindBy(id = "DONATION")
	private WebElement donationMenuDevoteeservice;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]")
	public WebElement purposeOfDonation;
	
	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;
	
	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	private List<WebElement> purposeOfDonationDropdown;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g']")
	public WebElement amountOfDollarsField;

	@FindBy(xpath = "//textarea[@class=\"text_area_field text_area_compact\"]")
	public WebElement donationDescription;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	public WebElement addDonationBtn;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	public WebElement serviceDate;

	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	public WebElement messageToBeDisplayed;

	@FindBy(xpath = "//input[@placeholder=\"Enter Vastra Code\"]")
	public WebElement vastraCode;

	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	public WebElement cartIcon;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> tableFirstColumn;
	
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 common_SuccessMessageContent__tHijm css-9l3uo3\"]")
	public WebElement successPopup;
	
	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li[104]")
	public WebElement vastra;
	
	@FindBy(xpath = "//p[text()=\"Please select the purpose of donation\"]")
	public WebElement purposeOfDonationInlineErrorText;
	
	@FindBy(xpath = "//p[text()=\"Minimum donation amount is 1\"]")
	public WebElement suggestedDonationAmountInlineErrorText;
	
	
	public void RegDevoteeDonate() throws InterruptedException

	{

	}

	public void enterUnregDevoteeDetail(String fname, String lname, String email, String donationAmt, String zipCode,
			String Address) throws InterruptedException {

		util.waitUntilElement(driver, addressField);
		addressField.sendKeys(Address);
		Logging.logger.info("Entering donation details...");
		Donation_Fname.sendKeys(fname);
		Donation_Lname.sendKeys(lname);
		Donation_PhoneNo.click();
		long con = 8522915087L;
		Donation_PhoneNo.sendKeys(Long.toString(con));
		Donation_Email.sendKeys(email);
		Donation_Amount.sendKeys(String.valueOf(donationAmt));
		Donation_ZipCode.sendKeys(zipCode);
		util.waitUntilElement(driver, Donation_Drop);
		Logging.logger.info("Selecting donation drop...");
		Donation_Drop.click();
		Logging.logger.info("Selecting donation purpose...");
		util.waitUntilElement(driver, Donation_purpose);
		Donation_purpose.click();

		Thread.sleep(3000);
		creditCard.click();
		proceedButton.click();
		Logging.logger.info("Donation details entered successfully.");
	}

	public void enterCreditCardPaymentDetails() throws InterruptedException {

		Logging.logger.info("Entering credit card details...");
		Thread.sleep(2000);
		arrowCircleRightOutlinedIcon.click();

		List<String> defaultAddressDetails = new ArrayList<>();
		defaultAddressDetails.add(defaultFirstName.getAttribute("value"));
		defaultAddressDetails.add(defaultLastName.getAttribute("value"));
		defaultAddressDetails.add(defaultAddress.getAttribute("value"));
		defaultAddressDetails.add(defaultZipCode.getAttribute("value"));
		defaultAddressDetails.add(defaultCity.getAttribute("value"));
		defaultAddressDetails.add(defaultState.getAttribute("value"));
		defaultAddressDetails.add(defaultCountry.getAttribute("value"));

		// Print default address details
		System.out.println("Default Address Details:");
		for (String detail : defaultAddressDetails) {
			System.out.println(detail);
		}

		util.waitUntilElement(driver, populatedFirstName);

		List<String> populatedAddressDetails = new ArrayList<>();
		populatedAddressDetails.add(populatedFirstName.getAttribute("value"));
		populatedAddressDetails.add(populatedLastName.getAttribute("value"));
		populatedAddressDetails.add(populatedAddress.getAttribute("value"));
		populatedAddressDetails.add(populatedZipCode.getAttribute("value"));
		populatedAddressDetails.add(populatedCity.getAttribute("value"));
		populatedAddressDetails.add(populatedState.getAttribute("value"));
		populatedAddressDetails.add(populatedCountry.getAttribute("value"));

		System.out.println("Populated Address Details:");
		for (String detail : populatedAddressDetails) {
			System.out.println(detail);
		}

		if (defaultAddressDetails.size() == populatedAddressDetails.size()
				&& defaultAddressDetails.containsAll(populatedAddressDetails)) {
			System.out.println("Address details are the same.");
			Assert.assertTrue(true, "Address details are the same.");
		} else {
			System.out.println("Address details are different.");
			Assert.fail("Address details are different.");
		}

		creditCardFeild.sendKeys("5121212121212124");
		util.waitUntilElement(driver, cvvField);
		cvvField.sendKeys("123");
		expirydate.click();
		expirydate.click();
		expirydate.sendKeys("1125");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", paymentButton);
		Thread.sleep(3000);
		paymentButton.click();
		// util.waitUntilElement(driver, closeButton);
		// closeButton.click();
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
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);

	}

	public void DonateforSpecialevent() throws InterruptedException

	{
		HomeTab.click();
		Thread.sleep(3000);
		// System.out.println("Hi");
		List<WebElement> specialEvents = driver.findElements(By.xpath("//div[@class='devotee_cardInfo__zJej+']"));

		// Check if at least one special event is present
		if (!specialEvents.isEmpty()) {
			// At least one special event is present
			System.out.println("At least one special event is present");
			specialEventdonateButton.click();

			// Iterate over each special event and print its text
//			for (WebElement event : specialEvents) {
//				System.out.println("Special Event: " + event.getText());
//			}

			// Perform further actions here, such as clicking on the special events or
			// logging them
		} else {
			// No special events are present
			System.out.println("No special events are present");

			// You can handle this case accordingly, such as logging a message or performing
			// alternative actions
		}

	}

	public void verifyAwards() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);

		Thread.sleep(1000);
		informationMenu.click();

		Thread.sleep(1000);

		// util.waitUntilElement(driver, awardsSubmenu);
		awardsSubmenu.click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", award1);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(informationMenu, 0, 0).build().perform();
//		Thread.sleep(3000);
//
//		Assert.assertTrue(award1.isDisplayed(), "Award 1 is not displayed");
//		Assert.assertTrue(award2.isDisplayed(), "Award 2 is not displayed");
//		System.out.println("Awards Verified");
	}

	public void navigateToDonation() throws InterruptedException {

		util.waitUntilElement(driver, userProfileIcon);
		userProfileIcon.click();

		util.waitUntilElement(driver, changeRoleMenu);

		changeRoleMenu.click();
		util.waitUntilElement(driver, devoteeRole);

		devoteeRole.click();

		util.waitUntilElement(driver, bookPoojaHallButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
		Thread.sleep(2000);
		bookPoojaHallButton.click();
		Thread.sleep(6000);
		util.waitUntilElement(driver, donationMenu);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", donationMenu);
		Thread.sleep(3000);
		donationMenu.click();
		Random rand = new Random();
		util.waitUntilElement(driver, purposeOfDonation);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", purposeOfDonation);
		Thread.sleep(3000);
		purposeOfDonation.click();
		Thread.sleep(3000);
		//vastra.click();
		int donationIndex = rand.nextInt(purposeOfDonationDropdown.size());
		purposeOfDonationDropdown.get(donationIndex).click();
		System.out.println(purposeOfDonationDropdown.get(donationIndex));
		Thread.sleep(2000);
		System.out.println(purposeOfDonation.getText());
		Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
       if(purposeOfDonation.getText().equalsIgnoreCase("VASTRA")) {
			vastraCode.sendKeys("1256");
			int randomAmount = new Random().nextInt(249);
            amountOfDollarsField.sendKeys(String.valueOf(randomAmount));
			String amount = amountOfDollarsField.getAttribute("value");
			Logging.logger.info("Entered random amount for donation: " + amount);
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
			Thread.sleep(2000);
			donationDescription.sendKeys("test donation from devotee role");
			addDonationBtn.click();
			Thread.sleep(3000);

//			util.waitUntilElement(driver, closeButton);
//			closeButton.click();
//			if(successPopup.isDisplayed()) {
//			closeButton.click();
////				disbursementReference.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
////				int randomReference1 = new Random().nextInt(10000);
////				disbursementReference.sendKeys(String.valueOf(randomReference1));
//				//addBtn.click();
//				//util.waitUntilElement(driver, closeButton);
//			    //closeButton.click();
//				util.waitUntilElement(driver, cartIcon);
//				util.doMoveToElement(driver, cartIcon);
//				cartIcon.click();
				Thread.sleep(3000);
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
			//}

		}

        else {
        	Logging.logger.info("Clicked on a random element in purposeOfDonationDropdown");
			Thread.sleep(4000);
			amountOfDollarsField.click();
			int randomAmount = new Random().nextInt(249);
            amountOfDollarsField.sendKeys(String.valueOf(randomAmount));
			//amountOfDollarsField.sendKeys("10");
			Thread.sleep(3000);
			donationDescription.sendKeys("test donation from devotee role");
			Thread.sleep(3000);
			addDonationBtn.click();
			Thread.sleep(3000);
//			util.waitUntilElement(driver, closeButton);
//			closeButton.click();
//			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartIcon);
//			util.waitUntilElement(driver, cartIcon);
//			util.doMoveToElement(driver, cartIcon);
//			cartIcon.click();
//			Thread.sleep(6000);
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

				Logging.logger.info("Navigation to Donor Advisory page completed successfully.");

			}
		}
        
	}

	

	public void navigateToDonationFromDevoteeService() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, userProfileIcon);
		util.waitUntilElement(driver, devoteeServiceMenu);
		devoteeServiceMenu.click();

		Logging.logger.info("Clicking on donationMenu menu");
		util.waitUntilElement(driver, donationMenuDevoteeservice);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		donationMenuDevoteeservice.click();
		Thread.sleep(3000);
		Logging.logger.info("Entering username: vivek0...");
		signInName.sendKeys("vivek0");
		SearchButton.click();
		Logging.logger.info("Entered username: vivek0 and clicked on Search Button");
		Thread.sleep(2000);
		Random rand = new Random();
		int SignInIndex = rand.nextInt(tableFirstColumn.size());
		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
		tableFirstColumn.get(SignInIndex).click();
		Logging.logger.info("Clicked on a random element in tableFirstColumn");
		Thread.sleep(2000);

		purposeOfDonation.click();
		Thread.sleep(4000);
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
			amountOfDollarsField.click();
			amountOfDollarsField.sendKeys("10");
			Thread.sleep(3000);
			donationDescription.sendKeys("test");
			Thread.sleep(3000);
			addDonationBtn.click();
			Thread.sleep(500);
			util.waitUntilElement(driver, closeButton);
			closeButton.click();
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartIcon);
			util.waitUntilElement(driver, cartIcon);
			util.doMoveToElement(driver, cartIcon);
			cartIcon.click();
			Thread.sleep(6000);
			WebElement table = driver.findElement(By.className("cartItems_tableBody__svnzv"));

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
						js.executeScript("arguments[0].style.backgroundColor = 'red';", row);
						rowFound = true;
						break;
					}
				}

				Thread.sleep(4000);

				// Assert that the row is found
				Assert.assertTrue(rowFound, "Row with data in 0th column '" + "' not found in the table.");
				Logging.logger.info("Row with data in 0th column found in the table.");
				Thread.sleep(2000);

			}

		}
	}
	
	
	public void captureInlineErrorMessages() throws InterruptedException {

		util.waitUntilElement(driver, userProfileIcon);
		userProfileIcon.click();

		util.waitUntilElement(driver, changeRoleMenu);

		changeRoleMenu.click();
		util.waitUntilElement(driver, devoteeRole);

		devoteeRole.click();

		util.waitUntilElement(driver, bookPoojaHallButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
		Thread.sleep(2000);
		bookPoojaHallButton.click();
		Thread.sleep(6000);
		util.waitUntilElement(driver, donationMenu);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", donationMenu);
		Thread.sleep(3000);
		donationMenu.click();
		addDonationBtn.click();
		Thread.sleep(2000);
		System.out.println(purposeOfDonationInlineErrorText.getText());
		//System.out.println(purposeOfDonationInlineText);
		System.out.println(suggestedDonationAmountInlineErrorText.getText());
		//System.out.println(suggestedDonationAmountInlineText);
		
		
}
	
}	