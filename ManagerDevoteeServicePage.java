package org.hints.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
//import org.hints.pages.ScheduleSelection;
import java.util.Set;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerDevoteeServicePage {

	WebDriver driver;
	Utility util = new Utility(driver, 30);
	// public PoojaBookingPage poojaBooking;
	PoojaBookingPage poojaBookingPage;

	public ManagerDevoteeServicePage(WebDriver Idriver) {
		this.driver = Idriver;
		this.poojaBookingPage = new PoojaBookingPage(driver);
		// this.scheduleselection=new ScheduleSelection();

	}

	public static String poojabookeddate;
	public static String poojabookedtime;
	public static String scheduledpooja;

	public ManagerDevoteeServicePage(PoojaBookingPage poojaBookingPage) {
		this.poojaBookingPage = poojaBookingPage;
	}

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@id='DEVOTEE_POOJA_AND_HALL_REQUESTS']")
	public WebElement DevoteePoojaandHallRequests;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 devoteeManagement_headerTitle__hRmiN css-9l3uo3']")
	public WebElement DevoteeServiceHeader;

	@FindBy(xpath = "//input[@placeholder='Enter Firstname']")
	public WebElement DevoteeService_Firstname;

	@FindBy(xpath = "//body/div[@id='root']/div/main[@class='layout_mainContainer__SJEJ0']/div[@class='managerDashboard_leftMenuNavigationAndOutlet__YtOgf']/div/div[@class='devoteeManagement_DuplicateDevoteeLayout__0BSEl MuiBox-root css-0']/div[4]")
	public WebElement ManagerActionPendingTable;

	@FindBy(xpath = "//td[normalize-space()='Click here']")
	public WebElement ClickHere;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	public WebElement CalendarTextbox;

	@FindBy(xpath = "//table[@class='devoteeManagement_tableContainer__KbfvW']")
	public WebElement DevoteeManagementTable;

	// @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[6]")
	@FindBy(xpath = "//td[normalize-space()='Click here']/..//td[normalize-space()='Click here']")
	public WebElement Clickhere;

	@FindBy(css = "td:nth-child(1)")
	public WebElement RequiredUserPooja;

	@FindBy(xpath = "//input[@placeholder=\"MM-DD-YYYY\"])[1]")
	public WebElement dateonpoojascheduleapproval;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[1]")
	public WebElement date1;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[2]")
	public WebElement date2;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[3]")
	public WebElement date3;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[4]")
	public WebElement date4;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[5]")
	public WebElement date5;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[6]")
	public WebElement date6;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 priestSchedule_date_text__UsV-5 css-gk6kxw\"])[7]")
	public WebElement date7;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-gh6jmv'])[1]")
	public WebElement colorbar_date1;

	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")
	public WebElement RequestType;

	@FindBy(xpath = "//li[normalize-space()='Pooja']")
	public WebElement PoojaValue;

	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined Mui-disabled MuiInputBase-input MuiOutlinedInput-input Mui-disabled Mui-readOnly MuiInputBase-readOnly css-qiwgdb'])[2]")
	public WebElement selectedpuja_PriestSchedulescreen;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-gh6jmv'])[2]")
	public WebElement colorbar_date2;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-gh6jmv'])[3]")
	public WebElement colorbar_date3;

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q7d6ug'])")
	// @FindBy(xpath="//button[@aria-label='Choose date, selected date is May 15,
	// 2024']//*[name()='svg']button[@class")
	public WebElement calendaricon_ManagerDashboard;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 priestSchedule_scheduling_title__CTtO3 css-1fy805r']")
	public WebElement random_ele;

	@FindBy(xpath = "(//p[contains(text(),'[Add]')])[1]")
	public WebElement addbtn;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 priestSchedule_title__R3Ahz css-9l3uo3']")
	public WebElement AddPriestSchedulewindow;

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

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	public WebElement okbtn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public WebElement submitbtn;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ih3mgy']")
	public WebElement overlapErrormsg;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[3]")
	public WebElement ItemsPerpage;

	@FindBy(xpath = "//li[normalize-space()='45']")
	public WebElement fortyfive;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-13lzuew']")
	public WebElement alreadyScheduled;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	public WebElement deletebtn;

	@FindBy(xpath = "(//div[@id='grouped-select'])[2]")
	public WebElement status;

	@FindBy(xpath = "//li[normalize-space()='Pending']")
	public WebElement pending;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-disabled MuiInputBase-inputAdornedEnd Mui-readOnly MuiInputBase-readOnly css-1uvydh2']")
	public WebElement date_PriestSchedulescreen;

	@FindBy(xpath = "(//input[@id='timepicker'])[1]")
	public WebElement poojatime_PriestSchedulescreen;

	// This method is to check if the error message is Displayed in Priest schedule
	// confirmation window

	public boolean isErrorMessageDisplayed() {
		try {
			return overlapErrormsg.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// This method is to get the content of error message
	public String getErrorMessageText() {
		return overlapErrormsg.getText();
	}

	public void closeSuccessPopup() {
		try {
			// Implement the logic to locate and click on the close button of the success
			// pop-up
			// For example:

			closeButton.click();
		} catch (NoSuchElementException e) {
			// If the close button is not found, log a message or handle the situation as
			// needed
			System.out.println("Close button not found for the success pop-up");
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

	// public void schedulePoojaPendingAction(PoojaBookingPage poojaBooking) throws
	// InterruptedException {

	public void outpujawithprieststatus() throws InterruptedException {
		util.waitUntilElement(driver, devoteeServiceMenu);
		Thread.sleep(2000);
		devoteeServiceMenu.click();
		Thread.sleep(1000);
		util.waitUntilElement(driver, DevoteePoojaandHallRequests);
		DevoteePoojaandHallRequests.click();
		// Thread.sleep(1000);

		util.waitUntilElement(driver, DevoteeService_Firstname);
		DevoteeService_Firstname.sendKeys("Niharika");
		Thread.sleep(2000);
		util.waitUntilElement(driver, RequestType);
		RequestType.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, PoojaValue);
		PoojaValue.click();
		util.waitUntilElement(driver, ItemsPerpage);
		ItemsPerpage.click();
		Thread.sleep(1000);
		
		
	}

	public void schedulePoojaPendingAction() throws InterruptedException {
		Thread.sleep(3000);

		util.waitUntilElement(driver, devoteeServiceMenu);
		Thread.sleep(2000);
		devoteeServiceMenu.click();
		Thread.sleep(1000);
		util.waitUntilElement(driver, DevoteePoojaandHallRequests);
		DevoteePoojaandHallRequests.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, DevoteeService_Firstname);
		DevoteeService_Firstname.sendKeys("Niharika");
		Thread.sleep(2000);
		util.waitUntilElement(driver, RequestType);
		RequestType.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, PoojaValue);
		PoojaValue.click();

		util.waitUntilElement(driver, status);
		status.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, pending);
		pending.click();
		util.waitUntilElement(driver, ItemsPerpage);
		ItemsPerpage.click();
		Thread.sleep(1000);

		util.waitUntilElement(driver, fortyfive);
		fortyfive.click();

		util.waitUntilElement(driver, DevoteeManagementTable);
		Thread.sleep(2000);
		System.out.println("Identified Devotee Table");
		String Date = PoojaBookingPage.formattedFutureDate;
		String Time = PoojaBookingPage.enteredTime;
		String otpuja = PoojaBookingPage.selectedpooja;
		String otpriest = PoojaBookingPage.selectedpriest;
		// PoojaBookingResult poojaBookingResult =
		// poojaBookingPage.bookOutsidePoojawithPriest();
		System.out.println("Formatted Future Date: " + Date);
		System.out.println("Entered Time: " + Time);
		System.out.println("Selected Priest: " + otpriest);
		System.out.println("Selected outside pooja with Priest: " + otpuja);

		String expectedDateTime = Date + " " + Time;
		System.out.println("Expected DateTime: " + expectedDateTime);
		// System.out.println("Expected Date Time: " + expectedDateTime);
		// String futureformattedDate = poojaBooking.getFutureformattedDate();
		// String SelectedPoojaTime = poojaBooking.getSelectedPoojaTime();
		// String PriestSelected = poojaBooking.getPriestSelected();
		List<WebElement> rows = DevoteeManagementTable.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			// Get the cells of the row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			if (cells.size() >= 7 && cells.get(6).getText().trim().equalsIgnoreCase("pending")) {
				// Check if the 7th cell (index 6) has the text "pending"
				if (cells.size() >= 2 && cells.get(1).getText().trim().equalsIgnoreCase(otpuja)) {
					String cellDateTime = cells.get(3).getText().trim();
					String expectedDateTimeWithoutAM = expectedDateTime.replaceAll("AM", "").trim();
					String cellPriest = cells.get(4).getText().trim();
					System.out.println("Cell Priest: " + cellPriest);
					boolean isPriestMatching = otpriest.toLowerCase().contains(cellPriest.toLowerCase());
					System.out.println("Is Priest Matching: " + isPriestMatching); // Print if the priest is matching

					if (cellDateTime.equals(expectedDateTimeWithoutAM)) {
						// Check if the 6th cell (index 5) has the text "click here"
						if (cells.size() >= 6 && cells.get(5).getText().trim().equalsIgnoreCase("click here")) {

							// Click on the cell
							cells.get(5).click();
							Thread.sleep(4000);
							break;
						}

					}
				}
			}
		}

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(3000);

		Thread.sleep(4000);
		util.waitUntilElement(driver, date1);
		System.out.println("Scrolled the window to book the priest");

		String dateContainerXPath = "(//div[@class='MuiBox-root css-1n016f7'])[1]";
		WebElement dateContainer = driver.findElement(By.xpath(dateContainerXPath));

		try {
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

		Thread.sleep(1000);
		util.waitUntilElement(driver, selectedpuja_PriestSchedulescreen);
		scheduledpooja = selectedpuja_PriestSchedulescreen.getText();
		System.out.println("The scheduling pooja is : " + scheduledpooja);

		util.waitUntilElement(driver, date_PriestSchedulescreen);
		System.out.println("Identified date");
		poojabookeddate = date_PriestSchedulescreen.getAttribute("value");
		System.out.println("The Pooja booked Date is: " + poojabookeddate);
		util.waitUntilElement(driver, Description);
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

		poojabookedtime = poojatime_PriestSchedulescreen.getAttribute("value");
		System.out.println("Time is : " + poojabookedtime);
		util.waitUntilElement(driver, submitbtn);
		submitbtn.click();
		Thread.sleep(2000);

	}
}
