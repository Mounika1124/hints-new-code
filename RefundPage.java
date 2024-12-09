package org.hints.pages;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hints.utility.DataProviderFactory;
import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

public class RefundPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	String ReferenceNumber;
	String Amount;

	public RefundPage(WebDriver Idriver) {
		this.driver = Idriver;
	}
	

	@FindBy(xpath = "//button[@id='closeButton']")
	public WebElement closepopup;

	@FindBy(xpath="//div[text()=\"My Dashboard\"]")
	public WebElement MyDashboard;
	
	@FindBy(xpath = "//div[text()='Devotee Service']")
	public WebElement DevoteeService;

	@FindBy(xpath = "//div[@id='REFUND']")
	public WebElement Refund;

	@FindBy(xpath = "//input[@id='signInName']")
	public WebElement Devtoeesigninname;

	@FindBy(xpath = "//button[@id='search']")
	public WebElement search;

	@FindBy(xpath = "//tbody[@id='searchData']//tr[@class=\"devoteeService_tableRow__eRfED\"]//td[@class=\"devoteeService_tableDiagonal__WHx9s\"][1]")
	public WebElement searchsignInName;

	@FindBy(xpath = "//input[@id='referenceNumber']")
	public WebElement referencenumber;
	
	@FindBy(xpath="//input[@id=\"refundAmount\"]")
	public WebElement refundAmount;
	
	@FindBy(xpath="(//div[@id=\"typeOfRefund\"])[1]")
	public WebElement typeOfRefund;
	
	@FindBy(xpath="//li[text()='Donation']")
	public WebElement Donation;
	
	@FindBy(xpath="//li[text()='Pooja']")
	public WebElement Pooja;
	
	@FindBy(xpath="//input[@id='checkNumber']")
	public WebElement checkNumber;
	
	@FindBy(xpath="//input[@id='reasonForRefund']")
	public WebElement reasonForRefund;
	
	@FindBy(xpath="//button[@id=\"refund\"]")
	public WebElement refund;
	
	@FindBy(xpath="//div[@class='MuiDialogContent-root common_ErrorMessageDiagloContent__bl8vH css-168rdr0']")
	public WebElement errorpopup;
	
	@FindBy(xpath="//h2[text()=\"Refund Initiated\"]")
	public WebElement successPopup;

	
	public void Recepitnumber() throws InterruptedException {

		 //util.waitUntilElement(driver, closepopup);
		// closepopup.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		WebElement ReceiptNo = driver
				.findElement(By.xpath("//div[@class='Receipt_receeiptNoAndDate__9TBRJ']"));
		String ReceiptNumber = ReceiptNo.getText();
		System.out.println("Receipt number is : " + ReceiptNumber);

		WebElement table = driver.findElement(By.xpath("//tbody[@id='listOfItems']"));

	
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", table);

		WebElement firstRow = table.findElement(By.xpath("//tbody[@id='listOfItems']//tr[@class=\"Receipt_tableRowOdd__aSFwv Receipt_tableRow__mShzp\"] "));

		WebElement firstCell = firstRow.findElement(By.xpath("//tbody[@id='listOfItems']//td[@class=\"Receipt_tableDiagonal__YS7uN\"][1]"));
		Thread.sleep(1000);
		ReferenceNumber = firstCell.getText();
		System.out.println("ReferenceNumber from Receipt Page: " + ReferenceNumber);
		
		
		WebElement amount = firstRow.findElement(By.xpath("//td[@class='Receipt_tableDiagonalAmount__aB37f'][1]"));
		Thread.sleep(1000);
		Amount = amount.getText();
		System.out.println("Amount from Receipt Page: " + Amount);
	}

	public void Refund(String checknumber,String reasonforrefund) throws InterruptedException {
		
		util.waitUntilElement(driver, MyDashboard);
		MyDashboard.click();
		
		util.waitUntilElement(driver, DevoteeService);
		DevoteeService.click();

		util.waitUntilElement(driver, Refund);
		Refund.click();

		util.waitUntilElement(driver, referencenumber);
		System.out.println("Reference Number before sending: " + ReferenceNumber);
		referencenumber.sendKeys(ReferenceNumber);
		
		util.waitUntilElement(driver, refundAmount);
		System.out.println("Reference Number before sending: " + Amount);
		refundAmount.sendKeys(Amount);
			
		util.waitUntilElement(driver, typeOfRefund);
		typeOfRefund.click();
		
		util.waitUntilElement(driver, Pooja);
		Pooja.click();
		
		util.waitUntilElement(driver, checkNumber);
		checkNumber.sendKeys(checknumber);
		
		util.waitUntilElement(driver, reasonForRefund);
		reasonForRefund.sendKeys(reasonforrefund);
		
		util.waitUntilElement(driver, refund);
		refund.click();	
		
		util.waitUntilElement(driver, successPopup);
		  WebElement Refund = driver.findElement(By.xpath("//div[@class=\"MuiDialogContent-root common_SuccessMessageDiagloContent__DE1rk css-1ty026z\"]//p[@class=\"MuiTypography-root MuiTypography-body1 common_SuccessMessageContent__tHijm css-9l3uo3\"]"));
		  Thread.sleep(1000);
		  String expectedText = "Refund was initiated with this $" + " Amount."; 
		  String actualRefundText = Refund.getText();

		  Pattern pattern = Pattern.compile("\\$\\d+\\.\\d{2}");
		  Matcher matcher = pattern.matcher(actualRefundText);
		  if (matcher.find()) {
		      String actualAmount = matcher.group(); 
		      expectedText = expectedText.replace("$ Amount.", actualAmount + " Amount.");
		  }
		  System.out.println("Actual Refund Text: " + actualRefundText); 
		  Assert.assertEquals(actualRefundText, expectedText, "Refund popup text is not as expected: Expected text: " + expectedText + ", Actual text: " + actualRefundText);
	}
	
	public void DecreaseRefund(String checknumber,String reasonforrefund) throws InterruptedException {
		
		util.waitUntilElement(driver, MyDashboard);
		MyDashboard.click();
		
		util.waitUntilElement(driver, DevoteeService);
		DevoteeService.click();

		util.waitUntilElement(driver, Refund);
		Refund.click();

		util.waitUntilElement(driver, referencenumber);
		System.out.println("Reference Number before sending: " + ReferenceNumber);
		referencenumber.sendKeys(ReferenceNumber);
		
		util.waitUntilElement(driver, refundAmount);
		System.out.println("Refund Amount before sending: " + Amount);
	    double amount = Double.parseDouble(Amount.replace("$", ""));
		amount -= 1;
		System.out.println("Decreased Refund Amount: " + amount);
		refundAmount.sendKeys(String.valueOf(amount));
		
		util.waitUntilElement(driver, typeOfRefund);
		typeOfRefund.click();
		
		util.waitUntilElement(driver, Pooja);
		Pooja.click();
		
		util.waitUntilElement(driver, checkNumber);
		checkNumber.sendKeys(checknumber);
		
		util.waitUntilElement(driver, reasonForRefund);
		reasonForRefund.sendKeys(reasonforrefund);
		
		util.waitUntilElement(driver, refund);
		refund.click();	
		//Thread.sleep(5000);
		
		  util.waitUntilElement(driver, successPopup);		  
		  WebElement Refund = driver.findElement(By.xpath("//div[@class=\"MuiDialogContent-root common_SuccessMessageDiagloContent__DE1rk css-1ty026z\"]//p[@class=\"MuiTypography-root MuiTypography-body1 common_SuccessMessageContent__tHijm css-9l3uo3\"]"));
		  Thread.sleep(1000);
		  String expectedText = "Refund was initiated with this $" + " Amount."; 
		  String actualRefundText = Refund.getText();

		  Pattern pattern = Pattern.compile("\\$\\d+\\.\\d{2}");
		  Matcher matcher = pattern.matcher(actualRefundText);
		  if (matcher.find()) {
		      String actualAmount = matcher.group(); 
		      expectedText = expectedText.replace("$ Amount.", actualAmount + " Amount.");
		  }
		  System.out.println("Actual Refund Text: " + actualRefundText); 
		  Assert.assertEquals(actualRefundText, expectedText, "Refund popup text is not as expected: Expected text: " + expectedText + ", Actual text: " + actualRefundText);

	}
	
	public void IncreaseRefund(String checknumber,String reasonforrefund) throws InterruptedException {
		
		util.waitUntilElement(driver, MyDashboard);
		MyDashboard.click();
		
		util.waitUntilElement(driver, DevoteeService);
		DevoteeService.click();

		util.waitUntilElement(driver, Refund);
		Refund.click();

		util.waitUntilElement(driver, referencenumber);
		System.out.println("Reference Number before sending: " + ReferenceNumber);
		referencenumber.sendKeys(ReferenceNumber);
		
		util.waitUntilElement(driver, refundAmount);
		System.out.println("Refund Amount : " + Amount);
	    double amount = Double.parseDouble(Amount.replace("$", ""));
		amount += 1;
		System.out.println("Increased Refund Amount: " + amount);
		refundAmount.sendKeys(String.valueOf(amount));
		
		util.waitUntilElement(driver, typeOfRefund);
		typeOfRefund.click();
		
		util.waitUntilElement(driver, Pooja);
		Pooja.click();
		
		util.waitUntilElement(driver, checkNumber);
		checkNumber.sendKeys(checknumber);
		
		util.waitUntilElement(driver, reasonForRefund);
		reasonForRefund.sendKeys(reasonforrefund);
		
		util.waitUntilElement(driver, refund);
		refund.click();	
		//Thread.sleep(10000);
		util.waitUntilElement(driver, errorpopup);
		WebElement Refund = driver.findElement(By.xpath("//p[text()='Refund amount should not be greater than the donation amount.']"));
		//Thread.sleep(1000);
		String RefundText = Refund.getText();
		System.out.println(RefundText);
		Assert.assertEquals(RefundText, "Refund amount should not be greater than the donation amount.", "Refund popup text is not as expected");
	}

}
	



