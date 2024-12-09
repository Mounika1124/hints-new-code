package org.hints.pages;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

//import org.hints.testcases.ForgotUsernamePage;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.netty.util.internal.ThreadLocalRandom;
import io.qameta.allure.Step;

public class PoojaBookingByManagerPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);

	public PoojaBookingByManagerPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[text()='Book pooja/Hall']")
	public WebElement bookPoojaHallButton;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;

	@FindBy(xpath = "//div[@id=\"POOJA_BOOKING\"]")
	public WebElement poojaBookingMenu;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
	public WebElement signInName;

	@FindBy(xpath = "//button[text()=\"Search\"]")
	public WebElement SearchButton;

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> tableFirstColumn;

	@FindBy(xpath = "//div[@id=\"selectPooja\"]")
	public WebElement selectPoojaTextBox;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> selectPoojaDropdown;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	public WebElement selectPriestTextBox;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> selectPriestDropdown;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	public WebElement poojaDate;

	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd Mui-readOnly MuiInputBase-readOnly css-1uvydh2\"]")
	public WebElement poojaTime;

	@FindBy(id = "hrs")
	public WebElement hoursInput;

	@FindBy(id = "minutes")
	public WebElement minutesInput;

	@FindBy(xpath = "//button[text()=\"Ok\"]")
	private WebElement OkBtn;

	@FindBy(xpath = "//button[text()='Add']")
	public WebElement addPoojaButton;

	@FindBy(id = "selectPooja")
	public WebElement SelectPoojaDropdown;

	@FindBy(xpath = "//input[@value='MM-DD-YYYY']")
	public WebElement SelectPoojaDate;

	@FindBy(id = "timepicker")
	public WebElement SelectPoojaTime;

	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement Deities;

	@FindBy(xpath = "//div[@id=\"selectPooja\"]")
	public WebElement selectPooja;
	
	
	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	public WebElement SelectPriestDropdown;

	@FindBy(xpath = "//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li")
	public List<WebElement> priestDropdownValues;

	@FindBy(xpath = "//li[@data-value='Homa']")
	public WebElement SelectHomaText;

	@FindBy(xpath = "//button[@data-timestamp='1707330600000']")
	public WebElement SelectTimeStamp;

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd Mui-readOnly MuiInputBase-readOnly css-segi59\"]//input")
	public WebElement DurationIcon;

	// button[@class="MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium
	// css-1yxmbwk"]

	@FindBy(xpath = "(//div[@id='grouped-select'])[1]")
	public WebElement hallSelect;

	@FindBy(xpath = "//li[text()='Akella Annadana Kitchen']")
	public WebElement hallOption;

	@FindBy(xpath = "//button[text()=\"Add\"]")
	public WebElement addPooja;

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

	@FindBy(xpath = "//li[text()=\"Abhishekam\"]")
	private WebElement abhishekamElement;

	@FindBy(xpath = "//span[@class='MuiBadge-root css-1o69985']")
	private WebElement cartBadgeElement;

	@FindBy(xpath = "(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[2]")
	public WebElement OutsidePoojaRadioBtn;

	@FindBy(xpath = "//button[@id='submit']")
	public WebElement sendRequest_Manager;

	@FindBy(xpath = "//li[normalize-space()='Apara Kriyas']")
	public WebElement poojawithPriest_AprKriyas;

	@FindBy(xpath = "(//div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"])[2]")
	private WebElement numberofHrs;

	@FindBy(xpath = "//button[text()=\"Schedule Priest\"]")
	public WebElement schedulePriestBtn;

	@FindBy(xpath = "//textarea[@class='priestSchedule_text_area_field__uOm96']")
	public WebElement Description;

	@FindBy(xpath = "//div[@class='priestSchedule_schedule_dialog_main_container__jTKYb MuiBox-root css-8atqhb']")
	public WebElement priestSchedulerContainer;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
	public WebElement startTimeicon;

	@FindBy(xpath = "//input[@id='hrs']")
	public WebElement chooseTime;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
	public WebElement endTimeicon;

	@FindBy(xpath = "(//p[contains(text(),'[Add]')])[1]")
	public WebElement addbtn;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	public WebElement okbtn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public WebElement submitbtn;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	public WebElement deletebtn;

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q7d6ug'])")
	public WebElement calendaricon_ManagerDashboard;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	public WebElement CalendarTextbox;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[1]")
	public WebElement date1;

	@FindBy(xpath = "//button[text()=\"Continue to Pooja Booking\"]")
	public WebElement continueToPoojaBookingBtn;

	@FindBy(xpath = "//img[@alt=\"cart Icon\"]")
	public WebElement cartIcon;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-14bczxy\"]")
	public WebElement closeBtn;
	
	@FindBy(xpath = "//div[@class=\"MuiToggleButtonGroup-root MuiToggleButtonGroup-vertical css-11dhxb0\"]")
	public WebElement AMPM;

	@FindBy(xpath="//button[@id='closeButton']")
	public WebElement popup;
	
	@FindBy(xpath = "//li[text()='Abhisheka (Group)']")
	public WebElement selectpooja;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	public WebElement TemplePoojaRadioBtn;
	
	
	
	
	public void navigateToPoojaBookingMenu() throws InterruptedException {
		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		util.waitUntilElement(driver, devoteeServiceMenu);
		devoteeServiceMenu.click();
		Logging.logger.info("Clicking on Register Devotee menu");
		util.waitUntilElement(driver, poojaBookingMenu);
		poojaBookingMenu.click();
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

	public void insidePoojaBookingByManager() throws InterruptedException {

//		Logging.logger.info("Waiting for user profile icon element to be clickable");
//		util.waitUntilElement(driver, UserProfileIcon);
//		Thread.sleep(4000);
//		devoteeServiceMenu.click();
//		Thread.sleep(2000);
//		Logging.logger.info("Clicking on Pooja menu");
//		poojaBookingMenu.click();
//		Thread.sleep(2000);
//		Logging.logger.info("Entering username: vivek0...");
//		signInName.sendKeys("vivek0");
//		SearchButton.click();
//		Logging.logger.info("Entered username: vivek0 and clicked on Search Button");
//		Thread.sleep(4000);
//		Random rand = new Random();
//		int SignInIndex = rand.nextInt(tableFirstColumn.size());
//		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
//		tableFirstColumn.get(SignInIndex).click();
//		Logging.logger.info("Clicked on a random element in tableFirstColumn");
//		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid yellow'", selectPoojaTextBox);
		Thread.sleep(4000);
		util.waitUntilElement(driver, selectPoojaTextBox);
		selectPoojaTextBox.click();
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
//				String selectedPooja = SelectPoojaDropdown.getAttribute("value");
		//
//				System.out.println(selectedPooja);

		addPoojaButton.click();

		util.waitUntilElement(driver, closeButton);

		closeButton.click();

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(4000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();

	}
	
	

	public void outsidePoojaBookingByManager() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", OutsidePoojaRadioBtn);
//		util.waitUntilElement(driver, OutsidePoojaRadioBtn);
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
	
	public void PoojaBokingByManager() throws InterruptedException {

		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		Thread.sleep(4000);
		devoteeServiceMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Clicking on matchingDonations menu");
		poojaBookingMenu.click();
		Thread.sleep(2000);
		Logging.logger.info("Entering username: vivek0...");
		signInName.sendKeys("TISAHOWE");
		SearchButton.click();
		Logging.logger.info("Entered username: vivek0 and clicked on Search Button");
		Thread.sleep(4000);
		Random rand = new Random();
		int SignInIndex = rand.nextInt(tableFirstColumn.size());
		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
		tableFirstColumn.get(SignInIndex).click();
		Logging.logger.info("Clicked on a random element in tableFirstColumn");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid yellow'", selectPoojaTextBox);
		Thread.sleep(4000);
		util.waitUntilElement(driver, selectPoojaTextBox);
		selectPoojaTextBox.click();
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
//				String selectedPooja = SelectPoojaDropdown.getAttribute("value");
		//
//				System.out.println(selectedPooja);

		addPoojaButton.click();

		util.waitUntilElement(driver, closeButton);

		closeButton.click();

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartBadgeElement);
		Thread.sleep(4000);
		util.waitUntilElement(driver, cartBadgeElement);
		cartBadgeElement.click();
	}
	
	public void DeitiesbyManager() throws InterruptedException {

		util.waitUntilElement(driver, devoteeServiceMenu);
		devoteeServiceMenu.click();
		
		util.waitUntilElement(driver, poojaBookingMenu);
		poojaBookingMenu.click();
		
		Logging.logger.info("Entering username: vivek0...");
		signInName.sendKeys("TISAHOWE");
		SearchButton.click();
		Logging.logger.info("Entered username: vivek0 and clicked on Search Button");
		Thread.sleep(4000);
		Random rand = new Random();
		int SignInIndex = rand.nextInt(tableFirstColumn.size());
		Logging.logger.info("Generated random index for tableFirstColumn: " + SignInIndex);
		tableFirstColumn.get(SignInIndex).click();
		Logging.logger.info("Clicked on a random element in tableFirstColumn");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", TemplePoojaRadioBtn);
	    TemplePoojaRadioBtn.click();
	    
	    util.waitUntilElement(driver, SelectPoojaDropdown);
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDropdown);		
		SelectPoojaDropdown.click();
	    
	    util.waitUntilElement(driver, selectpooja);
	    selectpooja.click();
	    
	    String poojavalue=selectpooja.getText();
	    String formattedPoojaValue = poojavalue; 
	    formattedPoojaValue = formattedPoojaValue.trim();

	  //  String expectedPooja = 	"Abhisheka(Group)";
	    //expectedPooja = expectedPooja.trim();	    
	    util.waitUntilElement(driver, Deities);
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", Deities);
	    
	    if (Deities.isDisplayed()) {
	        Deities.click();
	        util.waitUntilElement(driver, Deities);
	        
	        List<WebElement> DeitiesCheckboxList = driver.findElements(By.xpath("//label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-1jaw3da\"]"));
	        
	        System.out.println("Number of Deities elements: " + DeitiesCheckboxList.size());

	        Random random = new Random();
	        int randomIndex = random.nextInt(DeitiesCheckboxList.size());
	        util.waitUntilElement(driver, DeitiesCheckboxList.get(randomIndex));

	        WebElement randomDeitiesElement = DeitiesCheckboxList.get(randomIndex);
	        randomDeitiesElement.click();
	        System.out.println("Selected Deities: " + randomDeitiesElement.getText());       
	    }
	    
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDate);

	    util.waitUntilElement(driver, SelectPoojaDate);
	    SelectPoojaDate.click();

	    LocalDate today = LocalDate.now();
	    LocalDate nextDate = today.plusDays(3);
	    String nextDateString = nextDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	    System.out.println("Selected Date :"+ nextDateString);

	    SelectPoojaDate.clear();
	    SelectPoojaDate.sendKeys(Keys.CONTROL + "a"); 
	    SelectPoojaDate.sendKeys(nextDateString);
   
	    util.waitUntilElement(driver, DurationIcon);
	    DurationIcon.click();

	    LocalTime startTimeAM = LocalTime.of(9, 0);
	    LocalTime endTimePM = LocalTime.of(18, 0);

	    LocalTime currentTime = LocalTime.now();

	    if (currentTime.isAfter(startTimeAM) && currentTime.isBefore(endTimePM)) {
	        startTimeAM = currentTime.plusHours(1).withMinute(0).withSecond(0).withNano(0);
	    }

	    long startSeconds = startTimeAM.toSecondOfDay();
	    long endSeconds = endTimePM.toSecondOfDay();
	    long randomSeconds = ThreadLocalRandom.current().nextLong(startSeconds, Math.min(endSeconds, LocalTime.of(18, 0).toSecondOfDay()));

	    LocalTime randomTime = LocalTime.ofSecondOfDay(randomSeconds);

	    int hour = randomTime.getHour() > 12 ? randomTime.getHour() - 12 : randomTime.getHour();
	    String amPm = randomTime.getHour() >= 12 ? "PM" : "AM";

	    System.out.println("Random time between 9 AM and 6 PM: " + randomTime);

	    util.waitUntilElement(driver, hoursInput);
	    hoursInput.click();
	    hoursInput.clear();
	    hoursInput.sendKeys(String.valueOf(hour));

	    util.waitUntilElement(driver, minutesInput);
	    minutesInput.click();
	    minutesInput.clear();
	    minutesInput.sendKeys(String.valueOf(randomTime.getMinute()));
	    
	    util.waitUntilElement(driver, AMPM);
	    AMPM.click();

	    util.waitUntilElement(driver, OkBtn);
	    OkBtn.click();


		util.waitUntilElement(driver, addPoojaButton);
		addPoojaButton.click();
	    
	    util.waitUntilElement(driver, popup);
	    popup.click();
	    
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",cartBadgeElement);
	    util.waitUntilElement(driver, cartBadgeElement);
	    cartBadgeElement.click();
	            
	    Thread.sleep(5000); 
	    WebElement ListofitemsAdded = driver.findElement(By.xpath("//table[@class='cartItems_tableContainer__7vABU']"));
	   
		String expectedPooja = formattedPoojaValue;
		
		List<WebElement> rows = ListofitemsAdded.findElements(By.tagName("tr"));
		boolean rowFound = false;
		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));

		    if (cells.size() >= 9) {
		        String cellText = cells.get(1).getText().trim();
		        if (cellText.equals(expectedPooja)) {
		            for (WebElement cell : cells) {
		                //System.out.println("Cell value: " + cell.getText());
		            }
		            js.executeScript("arguments[0].style.backgroundColor = 'red';", row);

		            rowFound = true;
		            break;
		        }
		    }
		}
		    
		    }
	
	




	public boolean isDeleteButtonPresent() {
		try {
			// Attempt to find the delete button
			driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
			return true; // If found, return true
		} catch (NoSuchElementException e) {
			return false; // If not found, return false
		}
	}

	public void bookOutsidePoojawithPriest() throws InterruptedException {

		OutsidePoojaRadioBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", SelectPoojaDropdown);
		Thread.sleep(4000);

		// Select poojaSelect = new Select(SelectPoojaDropdown);

		util.waitUntilElement(driver, SelectPoojaDropdown);
		SelectPoojaDropdown.click();
		util.waitUntilElement(driver, poojawithPriest_AprKriyas);
		poojawithPriest_AprKriyas.click();
		Thread.sleep(2000);
		String poojavalue=selectPooja.getText();
	    String formattedPoojaValue = poojavalue;
	    formattedPoojaValue = formattedPoojaValue.trim();
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
		util.waitUntilElement(driver, poojaDateInput);

		poojaDateInput.click();
		poojaDateInput.click();
		poojaDateInput.sendKeys(futureDateWithoutHyphens);

		Thread.sleep(2000);
		SelectPoojaTime.click();
		Thread.sleep(2000);
		hoursInput.click();
		hoursInput.sendKeys("09");
//
		util.waitUntilElement(driver, minutesInput);

		minutesInput.sendKeys("30");

		util.waitUntilElement(driver, OkBtn);

		OkBtn.click();
		// numberofHrs.click();
		util.waitUntilElement(driver, SelectPriestDropdown);
		SelectPriestDropdown.click();
		Thread.sleep(4000);
		Random rand = new Random();
		int priestIndex = rand.nextInt(priestDropdownValues.size());
		Logging.logger.info("Generated random index for priestColumn: " + priestIndex);
		priestDropdownValues.get(priestIndex).click();
		Logging.logger.info("Clicked on a random element in priestColumn");
		schedulePriestBtn.click();
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0, 0);");
		// js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block:
		// 'center' });", calendaricon_ManagerDashboard);
		Thread.sleep(4000);
		util.waitUntilElement(driver, calendaricon_ManagerDashboard);
		calendaricon_ManagerDashboard.click();
		Thread.sleep(3000);
		LocalDate currentDate1 = LocalDate.now();
		LocalDate futureDate1 = currentDate1.plusDays(3);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedFutureDate1 = futureDate.format(formatter1);
		String futureDateWithoutHyphens1 = formattedFutureDate1.replace("-", "");
		System.out.println("Future date without hyphens: " + futureDateWithoutHyphens1);
		util.waitUntilElement(driver, CalendarTextbox);

		CalendarTextbox.click();
		// CalendarTextbox.click();
		Thread.sleep(4000);
		CalendarTextbox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
		// CalendarTextbox.sendKeys(futureDateWithoutHyphens);

		// WebElement futureDateElement =
		// driver.findElement(By.xpath("//td[@data-date='" + formattedFutureDate +
		// "']"));
		Thread.sleep(3000);
		// futureDateElement.click();

		// Clicking anywhere outside the calendar to close it.

		// util.waitUntilElement(driver, random_ele);

		// random_ele.click();

		// System.out.println(scheduleselection.dateonpoojascheduleapproval.getText());
		// Thread.sleep(2000);
		// JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", date1);

		Thread.sleep(4000);
		util.waitUntilElement(driver, date1);
		System.out.println("Scrolled the window to book the priest");
		String dateContainerXPath = "(//div[@class='MuiBox-root css-1n016f7'])[1]";
		WebElement dateContainer = driver.findElement(By.xpath(dateContainerXPath));

		try {
			for (int dateContainerIndex = 1; dateContainerIndex <= 7; dateContainerIndex++) {

				String backgroundColor = ((JavascriptExecutor) driver).executeScript(
						"return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');",
						dateContainer).toString();

				if (backgroundColor.contains("rgb(255, 0, 0)")) {
					System.out.println("Priest is on leave for Selected Date ");
					continue;
				}

			}
			// Check for already scheduled links within the date container
			List<WebElement> alreadyScheduledLinks = dateContainer
					.findElements(By.xpath(".//p[@class='MuiTypography-root MuiTypography-body1 css-13lzuew']"));

			// If already scheduled links exist, click and delete them
			if (!alreadyScheduledLinks.isEmpty()) {
				for (WebElement alreadyScheduledLink : alreadyScheduledLinks) {
					try {
						alreadyScheduledLink.click();
						Thread.sleep(1000); // Add a short delay for the page to update
						// Perform delete action if delete button is present
						if (isDeleteButtonPresent()) {
							deletebtn.click();
							System.out.println("Clicked on 'Delete' button.");
							//closeBtn.click();

							// Wait for 10-12 seconds after deleting
							Thread.sleep(10000); // 10 seconds
						}
					} catch (Exception e) {
						System.out.println("Error clicking on 'alreadyScheduled' link or deleting: " + e.getMessage());
						// Handle the error or continue to next iteration
					}
				}
			}

			// Click on the "Add" button after deleting or if no links were found
			try {
				util.waitUntilElement(driver, addbtn);
				addbtn.click();
				// Add your further logic here to proceed after adding
			} catch (Exception e) {
				System.out.println("Error clicking add button: " + e.getMessage());
				// Handle the error or continue to next iteration
			}

		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println("Error finding date container or add button: " + e.getMessage());
			// Log the error or handle it as needed
		} catch (Exception e) {
			System.out.println("Error processing date container: " + e.getMessage());
			// Log the error or handle it as needed
		}

		// util.waitUntilElement(driver, priestSchedulerContainer);
		Thread.sleep(1000);
		// util.waitUntilElement(driver, AddPriestSchedulewindow);

		// if (priestSchedulerContainer.isDisplayed()
		// && AddPriestSchedulewindow.getText().equalsIgnoreCase("Add Priest
		// Schedule(One Time Schedule)")) {
		util.waitUntilElement(driver, Description);
		// System.out.println(Description);
		Description.sendKeys("Testing schedule booking");
		util.waitUntilElement(driver, startTimeicon);
		startTimeicon.click();
		Thread.sleep(1000);
		util.waitUntilElement(driver, chooseTime);
		chooseTime.sendKeys("09");
		okbtn.click();
		Thread.sleep(2000);

		util.waitUntilElement(driver, endTimeicon);
		endTimeicon.click();
		util.waitUntilElement(driver, chooseTime);
		chooseTime.sendKeys("11");
		okbtn.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, submitbtn);
		submitbtn.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				continueToPoojaBookingBtn);
		util.doMoveToElement(driver, continueToPoojaBookingBtn);
		continueToPoojaBookingBtn.click();
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", addPooja);
		addPooja.click();
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		// Thread.sleep(4000);
		js.executeScript("window.scrollTo(0, 0);");
		util.doMoveToElement(driver, cartIcon);
		cartIcon.click();
		Thread.sleep(6000);
		WebElement table = driver.findElement(By.className("cartItems_tableBody__svnzv"));

		util.waitUntilElement(driver, table);
		WebElement ListofitemsAdded = driver.findElement(By.xpath("//tbody[@id='cartItemsContent']"));
		   
		String expectedPooja = formattedPoojaValue;
		
		List<WebElement> rows = ListofitemsAdded.findElements(By.tagName("tr"));
		boolean rowFound = false;
		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));
 
		    if (cells.size() >= 9) {
		        String cellText = cells.get(1).getText().trim();
		        if (cellText.equals(expectedPooja)) {
		            for (WebElement cell : cells) {
		                System.out.println("Cell value: " + cell.getText());
		            }
		            js.executeScript("arguments[0].style.backgroundColor = 'red';", row);
 
		            rowFound = true;
		            break;
		        }
		    }
		}

	}

}
