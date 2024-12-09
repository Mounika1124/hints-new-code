package org.hints.pages;
 
//import org.odftoolkit.simple.table.OdfTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
 
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
//import org.hints.testcases.readcsv;
//import org.odftoolkit.simple.SpreadSheetDocument;
//import org.hints.testcases.ForgotUsernamePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.odftoolkit.odfdom.changes.Table;
import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
 
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
 
public class PoojaBookingPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);
 
	public PoojaBookingPage(WebDriver Idriver) {
		this.driver = Idriver;
		// util = new Utility(driver, 30);
	}
 
	public static String formattedFutureDate;
	public static String enteredTime;
	public static String selectedpriest;
	public static String selectedpooja;
 
	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;
 
	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;
 
	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;
 
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	public WebElement TemplePoojaRadioBtn;
 
	@FindBy(id = "outLocation")
	public WebElement OutsidePoojaRadioBtn;
 
	@FindBy(id = "poojaTitle")
	public WebElement SelectPoojaDropdown;
 
	@FindBy(xpath = "//input[@value='MM-DD-YYYY']")
	public WebElement SelectPoojaDate;
 
	@FindBy(id = "timepicker")
	public WebElement SelectPoojaTime;
 
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd Mui-readOnly MuiInputBase-readOnly css-1uvydh2']")
	public WebElement PoojaTime;
 
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement Deities;
 
	@FindBy(xpath = "//div[@role='combobox']")
	public WebElement SelectPriestDropdown;
 
	@FindBy(xpath = "//li[@data-value='Homa']")
	public WebElement SelectHomaText;
 
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M20 3h-1V1')]")
	public WebElement datePicker_calendar;
 
	@FindBy(xpath = "//div[@class=\"MuiToggleButtonGroup-root MuiToggleButtonGroup-vertical css-11dhxb0\"]")
	public WebElement AMPM;
 
	@FindBy(xpath = "//button[normalize-space()='AM']")
	public WebElement ambtn;
 
	/*
	 * @FindBy(xpath = "//button[@data-timestamp='1707330600000']") public
	 * WebElement SelectTimeStamp;
	 */
 
	// @FindBy(xpath = "//button[@aria-label='User Profile']//*[name()='svg']")
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M12 12c2.2')]")
	public WebElement UserProfileIcon;
 
	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd Mui-readOnly MuiInputBase-readOnly css-segi59\"]//input")
	public WebElement DurationIcon;
 
	// button[@class="MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium
	// css-1yxmbwk"]
 
	@FindBy(xpath = "(//div[@id='grouped-select'])[1]")
	public WebElement hallSelect;
 
	@FindBy(xpath = "//li[text()='Akella Annadana Kitchen']")
	public WebElement hallOption;
 
	@FindBy(id = "hrs")
	public WebElement hoursInput;
 
	@FindBy(id = "minutes")
	public WebElement minutesInput;
 
	@FindBy(xpath = "//button[text()=\"Ok\"]")
	private WebElement OkBtn;
 
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	public WebElement okbutton;
 
	@FindBy(id = "submit")
	public WebElement addPooja;
 
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement sendRequest_Manager;
 
	@FindBy(xpath = "//li[normalize-space()='Apara Kriyas']")
	public WebElement poojawithPriest_AprKriyas;
 
	@FindBy(id = "selectPriest")
	public WebElement selectPriestDropdown;
 
	@FindBy(xpath = "//li[normalize-space()='PDT. PAWA KUMA']")
	public WebElement priestSelection;
 
	@FindBy(xpath = "//div[text()='Event Hall Booking Request']")
	public WebElement HallRequestMenu;
 
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-id8jn6\"]")
	public WebElement priestSelectionValues;
 
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-id8jn6']//li")
	private List<WebElement> dropdownValues;
 
	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-id8jn6']//li")
	private List<WebElement> PriestdropdownValues;
 
	@FindBy(xpath = "//div[@class='MuiFormControl-root devoteeBooking_dropDowns__SklWB css-13sljp9'][2]")
 
	private WebElement numberofmns;
 
	@FindBy(xpath = "//li[text()=\"Vahana Puja\"]")
	private WebElement VahanaPuja;
 
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	private WebElement poojaDateInput;
 
	@FindBy(id = "closeButton")
	private WebElement closeButton;
 
	@FindBy(xpath = "//button[@id='closeButton']//*[name()='svg']")
	private WebElement poojawithpriest_close;
 
	@FindBy(xpath = "//li[@data-value='Abhishekam']")
	private WebElement abhishekamElement;
 
	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	private WebElement cartBadgeElement;
 
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	public WebElement logoutbtn;
 
	public void bookPooja() throws InterruptedException {
 
		util.waitUntilElement(driver, UserProfileIcon);
 
		UserProfileIcon.click();
 
		util.waitUntilElement(driver, changeRoleMenu);
 
		changeRoleMenu.click();
 
		util.waitUntilElement(driver, devoteeRole);
 
		devoteeRole.click();
 
		util.waitUntilElement(driver, bookPoojaHallButton);
 
		JavascriptExecutor js = (JavascriptExecutor) driver;
 
		// js.executeScript("arguments[0].style.border='2px solid yellow'",
		// bookPoojaHallButton);
 
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
 
		Thread.sleep(4000);
 
		bookPoojaHallButton.click();
 
//		js.executeScript("arguments[0].style.border='2px solid yellow'", SelectPoojaDropdown);
//		Thread.sleep(3000);
//
//		util.waitUntilElement(driver, SelectPoojaDropdown);
//
//		SelectPoojaDropdown.click();
 
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDropdown);
		Thread.sleep(4000);
 
		// Select poojaSelect = new Select(SelectPoojaDropdown);
 
		util.waitUntilElement(driver, SelectPoojaDropdown);
		SelectPoojaDropdown.click();
		util.waitUntilElement(driver, VahanaPuja);
		VahanaPuja.click();
		Thread.sleep(4000);
 
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
		util.waitUntilElement(driver, poojaDateInput);
 
		poojaDateInput.click();
		poojaDateInput.click();
		poojaDateInput.sendKeys(futureDateWithoutHyphens);
 
		Thread.sleep(2000);
 
		// Get the amount value from the field
//		String selectedPooja = SelectPoojaDropdown.getAttribute("value");
//
//		System.out.println(selectedPooja);
 
		addPooja.click();
 
		util.waitUntilElement(driver, closeButton);
 
		closeButton.click();
 
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(4000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();
 
//		// Format the amount value
//		String formattedAmount = "$" + amountValue + ".00";
//
//		addPrasadamButton.click();
//
//		util.waitUntilElement(driver, closeButton);
//
//		closeButton.click();
//
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
//		Thread.sleep(1000);
//		util.waitUntilElement(driver, cartBadgeElement);
//		cartBadgeElement.click();
//		// Define the expected values for comparison
//
//		Thread.sleep(4000);
//
//		WebElement table = driver.findElement(By.className("cartItems_tableBody__svnzv"));
//
//		util.waitUntilElement(driver, table);
//
//		String expectedPrasadamItem = "VADA";
//		String expectedPrasadamAmount = formattedAmount;
//
//		// Get all the rows in the table
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//		boolean rowFound = false;
//		// Iterate over the rowss
//		for (WebElement row : rows) {
//			// Get the cells in each row
//			List<WebElement> cells = row.findElements(By.tagName("td"));
//
//			if (cells.size() >= 7) {
//				// Check if the 4th and 5th cell contain the expected data
//				if (cells.get(5).getText().equals(expectedPrasadamItem)
//						&& cells.get(7).getText().equals(expectedPrasadamAmount)) {
//
//					// Highlight the row with a thick yellow border
//					js.executeScript("arguments[0].style.backgroundColor = 'red';", row);
//
//					rowFound = true;
//					break;
//				}
//			}
//		}
//
//		Thread.sleep(8000);
//		// Assert that the row is found
//		Assert.assertTrue(rowFound, "Row with data in 4th column '" + expectedPrasadamItem + "' and 5th column '"
//				+ expectedPrasadamAmount + "' not found in the table.");
//		System.out.println(dropdownValues.size());
//
//		Random rand = new Random();
//		//
//		int randomIndex = rand.nextInt(dropdownValues.size());
//
//		dropdownValues.get(randomIndex).click();
//		System.out.println("Sele" + "" + "cted POoja" + SelectPoojaDropdown.getAttribute("value"));
//
//		Thread.sleep(4000);
//
//		// util.waitUntilElement(driver, selectPriestDropdown);
//
//		try {
//			if (selectPriestDropdown.isDisplayed()) {
//////int randomIndex1 = rand.nextInt(PriestdropdownValues.size());
//////				System.out.println(randomIndex1);
////
////				dropdownValues.get(randomIndex1).click();
////
////				Thread.sleep(4000);
//
//				selectPriestDropdown.click();
//
//				System.out.println(
//						"HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
//				priestSelectionValues.click();
//
//				// div[@class="MuiPaper-root MuiPaper-elevation MuiPaper-rounded
//				// MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-id8jn6"]
//
//			}
//		} catch (NoSuchElementException e) {
//			// Handle the case where no priest dropdown is displayed
//			System.out.println("No priest dropdown displayed. Skipping priest selection.");
//		}
//
//		// Get all the options from the pooja dropdown
////		List<WebElement> poojaOptions = poojaSelect.getOptions();
////
////		// Generate a random index to select a pooja
////		Random rand = new Random();
////
////		int randomIndex = rand.nextInt(poojaOptions.size());
////
////		// Select the pooja at the random index
////		poojaSelect.selectByIndex(randomIndex);
//
////		util.waitUntilElement(driver, SelectHomaText);
////
////		SelectHomaText.click();
////
////		util.waitUntilElement(driver, SelectPoojaDate);
////
//
//		SelectPoojaDate.click();
//		SelectPoojaDate.click();
//		SelectPoojaDate.sendKeys("10152025");
//
//		Thread.sleep(4000);
//
////
//		util.waitUntilElement(driver, DurationIcon);
//
//		DurationIcon.click();
//		util.waitUntilElement(driver, hoursInput);
//		hoursInput.click();
//		hoursInput.sendKeys("10");
//		util.waitUntilElement(driver, minutesInput);
//
//		minutesInput.sendKeys("30");
//
//		util.waitUntilElement(driver, OkBtn);
//
//		OkBtn.click();
////
//		Thread.sleep(4000);
//
////		util.waitUntilElement(driver, addPoojaButton);
////
////		addPoojaButton.click();
////
////		util.waitUntilElement(driver, selectPriestDropdown);
////
////		selectPriestDropdown.click();
////		util.waitUntilElement(driver, priestSelection);
////
////		// priestSelection.click();
////
////		Thread.sleep(2000);
//
//		// AddBtn.click();
 
	}
 
	public void bookOutsidePooja() throws InterruptedException {
 
		util.waitUntilElement(driver, UserProfileIcon);
 
		UserProfileIcon.click();
 
		util.waitUntilElement(driver, changeRoleMenu);
 
		changeRoleMenu.click();
 
		util.waitUntilElement(driver, devoteeRole);
 
		devoteeRole.click();
 
		util.waitUntilElement(driver, bookPoojaHallButton);
 
		// Highlight the element using JavaScript
 
		JavascriptExecutor js = (JavascriptExecutor) driver;
 
		// js.executeScript("arguments[0].style.border='2px solid yellow'",
		// bookPoojaHallButton);
 
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
 
		Thread.sleep(4000);
 
		bookPoojaHallButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", OutsidePoojaRadioBtn);
		Thread.sleep(2000);
		OutsidePoojaRadioBtn.click();
 
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDropdown);
		Thread.sleep(4000);
 
		// Select poojaSelect = new Select(SelectPoojaDropdown);
 
		util.waitUntilElement(driver, SelectPoojaDropdown);
		SelectPoojaDropdown.click();
		util.waitUntilElement(driver, abhishekamElement);
 
		abhishekamElement.click();
		addPooja.click();
 
		util.waitUntilElement(driver, closeButton);
 
		closeButton.click();
 
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(4000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();
 
	}
 
	// public PoojaBookingResult bookOutsidePoojawithPriest() throws
	// InterruptedException {
	
	
	public void bookOutsidePoojawithPriest() throws InterruptedException {
		Thread.sleep(2000);
 
		util.waitUntilElement(driver, UserProfileIcon);
		UserProfileIcon.click();
 
		util.waitUntilElement(driver, changeRoleMenu);
		changeRoleMenu.click();
 
		util.waitUntilElement(driver, devoteeRole);
		devoteeRole.click();
 
		util.waitUntilElement(driver, bookPoojaHallButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", bookPoojaHallButton);
 
		Thread.sleep(4000);
 
		bookPoojaHallButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", OutsidePoojaRadioBtn);
		Thread.sleep(2000);
		OutsidePoojaRadioBtn.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDropdown);
		Thread.sleep(4000);
 
		// Select poojaSelect = new Select(SelectPoojaDropdown);
 
		util.waitUntilElement(driver, SelectPoojaDropdown);
		SelectPoojaDropdown.click();
 
		Thread.sleep(4000);
		 List<String> csvValues = readCSVValues("src/test/resources/test.csv");
		//util.waitUntilElement(driver, poojawithPriest_AprKriyas);
		//poojawithPriest_AprKriyas.click();
		 List<WebElement> dropdownOptions = driver.findElements(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li"));
		 List<String> dropdownTexts = dropdownOptions.stream()
		            .map(WebElement::getText)
		            .collect(Collectors.toList());
 
		    List<String> matchedOptions = csvValues.stream()
		            .filter(dropdownTexts::contains)
		            .collect(Collectors.toList());
		    
		    System.out.println(matchedOptions);
 
		    if (matchedOptions.isEmpty()) {
		        throw new IllegalStateException("No matching options found in the dropdown.");
		    }
		    Random rand = new Random();
		   selectedpooja = matchedOptions.get(rand.nextInt(matchedOptions.size()));
		    System.out.println("Random matched option: " + selectedpooja);
 
		    // Click the matched option
		    for (WebElement option : dropdownOptions) {
		        if (option.getText().equals(selectedpooja)) {
		            option.click();
		            break;
		        }
		    }
		
		
		
		 Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(7);
 
		// Define the date formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
 
		// Format the dates
		String formattedCurrentDate = currentDate.format(formatter);
		formattedFutureDate = futureDate.format(formatter);
		System.out.println(formattedFutureDate);
		System.out.println("Date picked is : " + formattedFutureDate);
		// Remove hyphens from the future date
		String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");
 
		// Print the formatted dates
 
		System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
		util.waitUntilElement(driver, poojaDateInput);
 
		poojaDateInput.click();
		poojaDateInput.click();
		poojaDateInput.sendKeys(futureDateWithoutHyphens);
 
		Thread.sleep(2000);
		util.waitUntilElement(driver, SelectPoojaTime);
		SelectPoojaTime.click();
		util.waitUntilElement(driver, hoursInput);
		hoursInput.sendKeys("09");
 
		util.waitUntilElement(driver, ambtn);
		if (ambtn.isSelected()) {
			okbutton.click();
		} else {
			ambtn.click();
			okbutton.click();
		}
		Thread.sleep(2000);
		enteredTime = SelectPoojaTime.getAttribute("value");
		System.out.println("Entered time: " + enteredTime);
		PoojaBookingResult poojaBookingResult = new PoojaBookingResult(formattedFutureDate, enteredTime);
 
		util.waitUntilElement(driver, selectPriestDropdown);
		//selectPriestDropdown.click();
		// This priestSelection element selects specific pandit PDT. PAWA KUMA
 
		//util.waitUntilElement(driver, priestSelection);
		//priestSelection.click();
		
		try {
			if (selectPriestDropdown.isDisplayed()) {
				
				util.waitUntilElement(driver, selectPriestDropdown);
				selectPriestDropdown.click();
				List<WebElement> priestElements = driver.findElements(By.xpath(
						"//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-id8jn6']//li"));
 
				System.out.println("Number of priest elements: " + priestElements.size());
 
				int randomIndexPriest = rand.nextInt(priestElements.size());
				WebElement randomPriestElement = priestElements.get(randomIndexPriest);
				util.waitUntilElement(driver, randomPriestElement);
				randomPriestElement.click();
			selectedpriest=	 randomPriestElement.getText();
			System.out.println(selectedpriest);
			} else {
				System.out.println("No elements found in the priest dropdown.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Priest dropdown not found. Skipping priest selection.");
		}
 
		Thread.sleep(3000);
 
		util.waitUntilElement(driver, sendRequest_Manager);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", sendRequest_Manager);
 
		util.waitUntilElement(driver, sendRequest_Manager);
		sendRequest_Manager.click();
		Thread.sleep(2000);
 
		try {
 
			util.waitUntilElement(driver, closeButton);
 
		}
 
		catch (ElementClickInterceptedException e) {
			Thread.sleep(1000);
			closeButton.click();
		} catch (Exception e) {
			// Handle other exceptions (if any) here
			e.printStackTrace();
// Print the stack trace for debugging
		}
 
		Logging.logger.info("Clicked on Close button.");
 
	}
 
	private List<String> readCSVValues(String csvFilePath) {
	    List<String> values = new ArrayList<>();
	    try (FileReader reader = new FileReader(csvFilePath)) {
	        CSVFormat csvformat = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build();
	        Iterable<CSVRecord> records = csvformat.parse(reader);
	        for (CSVRecord record : records) {
	            values.add(record.get(0));  // Adjust index if needed
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return values;
	}
	
	public void cartItemCreditCardPayment() throws InterruptedException {
		// Add logic to process credit card payment for items in the cart
		// This method should interact with elements related to credit card payment
		// and verify that the payment is successful
	}
 
}