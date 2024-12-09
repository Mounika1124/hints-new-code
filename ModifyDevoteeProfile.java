package org.hints.pages;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

//import org.apache.logging.log4j.plugins.di.Keys;
import org.hints.utility.Logging;

//import com.aventstack.extentreports.util.Assert;

import org.hints.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

	public class ModifyDevoteeProfile {
		WebDriver driver;
		Utility util = new Utility(driver, 30);
		LoginPage Lp = new LoginPage(driver);
		VastraBookingByManagerPage Vastra = new VastraBookingByManagerPage(driver);

		String verificationCode;

		public ModifyDevoteeProfile(WebDriver Idriver) {
			this.driver = Idriver;
		}

		@FindBy(xpath = "//div[@class=\"menuBar_userInfo__sWrm-\"]/div")
		public WebElement LoginBtn_main;

		@FindBy(xpath = "//button[normalize-space()='Register']")
		public WebElement Register_Button;

		@FindBy(id = "firstName")
		public WebElement Register_Fname;
		

		@FindBy(xpath = "//button[@aria-label='User Profile']")
		public WebElement UserProfileIcon;

		@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
		public WebElement devoteeServiceMenu;

		@FindBy(xpath = "//div[@id=\"MODIFY_DEVOTEE_PROFILE\"]")
		public WebElement modifyDevoteeProfileMenu;

		@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-1bp1ao6\"]/input[1]")
		public WebElement signInName;

		@FindBy(xpath = "//button[text()=\"Search\"]")
		public WebElement SearchButton;

		@FindBy(xpath = "//table[@class=\"devoteeService_tableContainer__e2zxA\"]")
		public WebElement table;
        
		@FindBy(xpath = "//table//td[1]/p")
		public List<WebElement> tableFirstColumn;
		
		@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"])[1]")
		public WebElement dob;
		
		@FindBy(xpath = "//button[text()=\"Update Profile\"]")
		public WebElement updateProfileBtn;
		
		
		@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 common_SuccessMessageContent__tHijm css-9l3uo3\"]")
		public WebElement successPopup;
		
		@FindBy(id = "closeButton")
		private WebElement closeButton;
		
		@FindBy(xpath = "//h2[@id=\"alert-dialog-title\"]")
		public WebElement popUpElement;
		
		
		
		
		public void searchDevotee() throws InterruptedException {
			Logging.logger.info("Waiting for user profile icon element to be clickable");
			util.waitUntilElement(driver, UserProfileIcon);
			Thread.sleep(4000);
			devoteeServiceMenu.click();
			Thread.sleep(2000);
			Logging.logger.info("Clicking on matchingDonations menu");
			modifyDevoteeProfileMenu.click();
			Thread.sleep(2000);
			Logging.logger.info("Entering username: david...");
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
		
		
		public void modifyDobOfDevotee() throws InterruptedException {

			Logging.logger.info("Waiting for purpose of donation element to be clickable");
			Random rand = new Random();
			util.waitUntilElement(driver, dob);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", dob);
			LocalDate currentDate = LocalDate.now();
			LocalDate pastDate = currentDate.minusDays(30);

			// Define the date formatter
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD");

			// Format the dates
			String formattedCurrentDate = currentDate.format(formatter);
			String formattedFutureDate = pastDate.format(formatter);

			// Remove hyphens from the future date
			String futureDateWithoutHyphens = formattedFutureDate.replace("-", "");

			// Print the formatted dates

			System.out.println("Future date without hyphens: " + futureDateWithoutHyphens);
			util.waitUntilElement(driver, dob);

			dob.click();
			//dob.click();
			dob.sendKeys(futureDateWithoutHyphens);
			dob.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, futureDateWithoutHyphens);
			updateProfileBtn.click();
			//Thread.sleep(4000);
//			if(successPopup.isDisplayed()) {
				util.waitUntilElement(driver, popUpElement);
				String popUptext = popUpElement.getText();
				System.out.println(popUptext);
				closeButton.click();
				
			//} 
		
		
		
		
		}

}
