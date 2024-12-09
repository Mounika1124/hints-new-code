package org.hints.pages;

import java.util.List;
import java.util.Random;

import org.hints.utility.DataProviderFactory;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

public class QuickRegisterPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public QuickRegisterPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Service\"]")
	public WebElement devoteeServiceMenu;

	@FindBy(xpath = "//div[@class=\"leftMenuNavigation_mainMenu__9E+8D \" and text()=\"Devotee Management\"]")
	public WebElement devoteeManagementMenu;

	@FindBy(xpath = "//div[@id=\"QUICK_REGISTRATION\"]")
	public WebElement quickRegisterMenu;

	@FindBy(xpath = "(//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-gnno8h\"]//div//div/input)[1]")
	public WebElement firstNameTextField;

	@FindBy(xpath = "(//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-gnno8h\"]//div//div/input)[3]")
	public WebElement emailTextField;

	@FindBy(xpath = "(//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-gnno8h\"]//div//div/input)[2]")
	public WebElement lastNameTextField;

	@FindBy(xpath = "//input[@id=\"workPhone\"]")
	public WebElement workPhoneTextField;

	@FindBy(xpath = "//input[@id=\"homePhone\"]")
	public WebElement homePhoneTextField;

	@FindBy(xpath = "(//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 css-h3o6is\"])[6]//div/input")
	public WebElement signInTextField;

	@FindBy(xpath = "//button[@id=\"registerNow\"]")
	public WebElement registerNowBtn;

	public void quickRegister(String firstName, String lastName, String email, String signInNametext)
			throws InterruptedException {

		Logging.logger.info("Waiting for user profile icon element to be clickable");
		util.waitUntilElement(driver, UserProfileIcon);
		Thread.sleep(4000);
		devoteeManagementMenu.click();
		Thread.sleep(4000);
		quickRegisterMenu.click();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		Thread.sleep(4000);
		workPhoneTextField.click();
		long con = 8522915087L;
		workPhoneTextField.sendKeys(Long.toString(con));
		homePhoneTextField.click();
		long con1 = 8906753412L;
		homePhoneTextField.sendKeys(Long.toString(con1));
		Faker faker = new Faker();
		String username;
		do {
			username = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
		} while (username.length() < 4 || username.length() > 10);

		// ZipCode.sendKeys("94550");

		signInTextField.sendKeys(username);

		registerNowBtn.click();
		Thread.sleep(3000);

	}

}
