package org.hints.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DevoteeCartPage {

	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public DevoteeCartPage(WebDriver Idriver) {
		this.driver = Idriver;

	}

	@FindBy(xpath = "//input[@id='creditCardNumber']")
	public WebElement creditCardNoField;

	@FindBy(xpath = "//input[@placeholder=\"MM/YY\"]")
	public WebElement expiryDateField;

	@FindBy(xpath = "//input[@id='cvv']")
	public WebElement cvvCodeField;

	@FindBy(id = "makePayment")
	public WebElement makePaymentButton;

	@FindBy(xpath = "//p[text()=\"Credit Card\"]")
	private WebElement creditCardButton;
	
	@FindBy(xpath = "//img[@src=\"/images/CreditCard.svg\"]")
	private WebElement creditCardDevotee;

	@FindBy(xpath = "//img[@src='/images/successImage.svg']")
	private WebElement successImage;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-g12m4\"]")
	public WebElement arrowCircleRightOutlinedIcon;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "//*[@id='grouped-select']")
	private WebElement calenderQuantity;

	@FindBy(xpath = "//*[@id='calenderadd']//button[text()='Add']")
	private WebElement addCalendar;

	@FindBy(xpath = "//img[@src=\"/images/cashimg.svg\"]")
	public WebElement cashMode;

	@FindBy(xpath = "//button[@aria-label='Direct Deposit Mode']")
	public WebElement directDepositeMode;

	@FindBy(xpath = "//img[@src=\"/images/coinimg.svg\"]")
	public WebElement coinMode;

	@FindBy(xpath = "//img[@src=\"/images/manualreceiptimg.svg\"]")
	public WebElement manualReceiptMode;

	@FindBy(xpath = "//img[@src=\"/images/checkimg.svg\"]")
	public WebElement checkMode;

	@FindBy(xpath = "//input[@placeholder='Enter Check Number']")
	private WebElement checkNumber;

	@FindBy(xpath = "//input[@placeholder=\"Enter Bank Name\"]")
	private WebElement bankName;

	@FindBy(xpath = "//input[@placeholder=\"MM-DD-YYYY\"]")
	private WebElement chequeDate;

	@FindBy(xpath = "//img[@src=\"/images/paypalimg.svg\"]")
	public WebElement payPalMode;

	@FindBy(xpath = "//input[@placeholder=\"PayPal Transaction Id\"]")
	public WebElement payPalTransactionId;

	@FindBy(xpath = "//input[@placeholder=\"MM-DD-YYYY\"]")
	public WebElement transactiondateInput;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 Receipt_singlePay__HdkDf css-9l3uo3\"])[1]")
	private WebElement totalAmount;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement makePayment;

	@FindBy(xpath = "//button[text()=\"Make Payment\"]")
	private WebElement checkDetailsSubmit;

	@FindBy(xpath = "//img[@src=\"/images/directdepositimg.svg\"]")
	private WebElement directDepositmode;

	@FindBy(xpath = "//span[@class=\"MuiTouchRipple-root css-w0pj6f\"])[4]")
	private WebElement checksubmit;

	// button[@class="MuiButtonBase-root MuiButton-root MuiButton-text
	// MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium
	// MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary
	// MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary
	// App_saveButton__fVEKx css-2d4knz"]

	// button[text()="Make Payment"]/span

	// button[@class="MuiButtonBase-root MuiButton-root MuiButton-text
	// MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium
	// MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary
	// MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary
	// css-4qmski"]

	public void cartItemCreditCardPayment() throws InterruptedException {
		Thread.sleep(2000);
		creditCardButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
//				arrowCircleRightOutlinedIcon);
//		Thread.sleep(2000);
//
//		arrowCircleRightOutlinedIcon.click();
//
//		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", creditCardNoField);

		creditCardNoField.sendKeys("5121212121212124");
		util.waitUntilElement(driver, expiryDateField);
		expiryDateField.click();
		expiryDateField.click();
		expiryDateField.sendKeys("1124");

		cvvCodeField.sendKeys("123");
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", makePaymentButton);
		Thread.sleep(1000);
		makePaymentButton.click();
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);


	}
	
	public void cartItemCreditCardPaymentFromDevotee() throws InterruptedException {
		Thread.sleep(2000);
		creditCardDevotee.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
  	    creditCardNoField.sendKeys("5121212121212124");
		util.waitUntilElement(driver, expiryDateField);
		expiryDateField.click();
		expiryDateField.click();
		expiryDateField.sendKeys("1124");

		cvvCodeField.sendKeys("123");
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", makePaymentButton);
		Thread.sleep(1000);
		makePaymentButton.click();
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);


	}

	public void cartItemCheckPayment() throws InterruptedException {
		util.waitUntilElement(driver, checkMode);

		checkMode.click();

		checkNumber.sendKeys("12121222111");

		bankName.sendKeys("12121222111");

		chequeDate.click();
		chequeDate.click();

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
		util.waitUntilElement(driver, transactiondateInput);

		chequeDate.sendKeys(futureDateWithoutHyphens);

		util.doMoveToElement(driver, checkDetailsSubmit);

		checkDetailsSubmit.click();

		Thread.sleep(9000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);

	}

	public void cartItemCashPayment() throws InterruptedException {

		util.waitUntilElement(driver, cashMode);
		cashMode.click();

		makePayment.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		Thread.sleep(500);
		closeButton.click();
		//Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);
	}

	public void cartItemManualReceipt() throws InterruptedException {
		util.waitUntilElement(driver, manualReceiptMode);
		manualReceiptMode.click();

		makePayment.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(2000);
	}

	public void cartItemCoin() throws InterruptedException {
		util.waitUntilElement(driver, coinMode);
		coinMode.click();

		makePayment.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(2000);

	}

	public void cartItemPayPalPayment() throws InterruptedException {

		util.waitUntilElement(driver, payPalMode);

		payPalMode.click();
		payPalTransactionId.sendKeys("5656565556555565");
		transactiondateInput.click();
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
		util.waitUntilElement(driver, transactiondateInput);

		transactiondateInput.click();
		transactiondateInput.sendKeys(futureDateWithoutHyphens);

		Thread.sleep(2000);

		checkDetailsSubmit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(2000);

	}

	public void cartItemDirectDeposit() throws InterruptedException {
		util.waitUntilElement(driver, directDepositmode);
		directDepositmode.click();

		makePayment.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.waitUntilElement(driver, closeButton);
		closeButton.click();
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", totalAmount);
		Thread.sleep(1000);
	}

}