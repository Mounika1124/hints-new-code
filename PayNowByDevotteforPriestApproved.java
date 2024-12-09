package org.hints.pages;

import java.util.List;

import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayNowByDevotteforPriestApproved {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	LoginPage Lp = new LoginPage(driver);
	ManagerDevoteeServicePage mgrdevoteeservicepage;

	public PayNowByDevotteforPriestApproved(WebDriver Idriver) {
		this.driver = Idriver;

	}

	// public static String devoteedateandtime;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[text()='Devotee']")
	public WebElement devoteeRole;

	@FindBy(xpath = "//p[normalize-space()='Booked Pooja/Hall']")
	public WebElement BookedPoojaorHallTitle;

	@FindBy(xpath = "//div[@class='pagination_paginationContainer__N1wdq']//button[2]//*[name()='svg']")
	public WebElement nxtPage;

	@FindBy(xpath = "//p[normalize-space()='Credit Card']")
	public WebElement creditcardbtn;

	@FindBy(xpath = "//button[normalize-space()='Proceed']")
	public WebElement proceedbtn;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-g12m4\"]")
	public WebElement arrowCircleRightOutlinedIcon;

	@FindBy(xpath = "//input[@placeholder='Enter Credit Card Number']")
	public WebElement creditCardNoField;

	@FindBy(xpath = "//input[@placeholder=\"MM/YY\"]")
	public WebElement expiryDateField;

	@FindBy(xpath = "//input[@placeholder='Enter CVV']")
	public WebElement cvvCodeField;

	@FindBy(id = "makePayment")
	public WebElement makePaymentButton;

	@FindBy(id = "closeButton")
	private WebElement closeButton;

	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 devoteeService_singlePay__BuSNL css-9l3uo3\"])[1]")
	private WebElement totalAmount;

	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 devotee_date__SYw7H css-9l3uo3'])[1]")
	public WebElement choosenpoojandtime;

	private void clickNextPageButton(WebDriver driver) {
		WebElement nextPageButton = driver.findElement(
				By.xpath("//div[@class='pagination_paginationContainer__N1wdq']//button[2]//*[name()='svg']"));
		nextPageButton.click();
	}

	/*
	 * private static boolean isNextPageAvailable(WebDriver driver) {
	 * List<WebElement> nextButtons = driver.findElements( By.xpath(
	 * "//div[@class='pagination_paginationContainer__N1wdq']//button[2]//*[name()='svg']"
	 * )); return !nextButtons.isEmpty() && nextButtons.get(0).isEnabled(); /* if
	 * (nextButtons.size() > 0) { WebElement nextButton = nextButtons.get(0); return
	 * nextButton.isEnabled(); } else { return false; }
	 */

	// }

	public void paynowforManagerApprovedPriestSchedule() throws InterruptedException {

		util.waitUntilElement(driver, UserProfileIcon);

		UserProfileIcon.click();

		util.waitUntilElement(driver, changeRoleMenu);

		changeRoleMenu.click();

		util.waitUntilElement(driver, devoteeRole);

		devoteeRole.click();
		util.waitUntilElement(driver, BookedPoojaorHallTitle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				BookedPoojaorHallTitle);
		Thread.sleep(2000);

		String PoojaapprovedDate = ManagerDevoteeServicePage.poojabookeddate;
		String PoojaapprovedTime = ManagerDevoteeServicePage.poojabookedtime;

		String expectedDateTimeondevotee = PoojaapprovedDate + " " + PoojaapprovedTime;
		String expectedDateTimeondevoteeWithoutAM = expectedDateTimeondevotee.replaceAll("AM", "").trim();
		System.out.println("The pooja booked date/time is: " + expectedDateTimeondevoteeWithoutAM);
		String nxtbtndevoteepagination = "//div[@class='pagination_paginationContainer__N1wdq']//button[2]//*[name()='svg']";
		String ScheduledPooja = ManagerDevoteeServicePage.scheduledpooja;

		System.out.println("The Pooja Scheduled is :" + ScheduledPooja);

		boolean payNowClicked = false;
		while (!payNowClicked && Utility.isNextPageAvailable(driver, nxtbtndevoteepagination)) {
			for (int i = 1; i <= 5; i++) {
				String devoteepoojadetailsxpath = "(//div[@class='devotee_poojaDetails__DpGLL MuiBox-root css-0'])[" + i
						+ "]";
				String bookedpoojaorhall = "(//p[@class='MuiTypography-root MuiTypography-body1 devotee_title__2aEbT css-9l3uo3'])["
						+ i + "]";
				String pujascheduledate = "(//p[@class='MuiTypography-root MuiTypography-body1 devotee_date__SYw7H css-9l3uo3'])["
						+ i + "]";

				WebElement identifiedpoojatext = driver.findElement(By.xpath(bookedpoojaorhall));
				System.out.println("The pooja text identified: " + identifiedpoojatext.getText());
				WebElement identifiedPujaScheduleDate = driver.findElement(By.xpath(pujascheduledate));

				js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
						identifiedpoojatext);
				Thread.sleep(1000);
				if (identifiedPujaScheduleDate.getText().equals(expectedDateTimeondevoteeWithoutAM)
						&& ScheduledPooja.equals(identifiedpoojatext.getText())) {
					System.out.println("ScheduledPooja and identifiedpoojatext match.");
					System.out.println("Date matches the expected date.");
					Thread.sleep(2000);
					try {
						String payNowButtonXpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-185vgvk'])["
								+ i + "]";
						WebElement payNowButton = driver.findElement(By.xpath(payNowButtonXpath));
						if (payNowButton.isDisplayed() && payNowButton.isEnabled()) {
							js.executeScript("arguments[0].click();", payNowButton);
							System.out.println("Pay Now is reached");
							Thread.sleep(2000);
							payNowButton = driver.findElement(By.xpath(payNowButtonXpath));
							// Click on the "Paynow" button
							payNowButton.click();

							System.out.println("Paynow is clicked");
							payNowClicked = true;
							Thread.sleep(2000);
						} else {
							System.out.println("Pay Now button is not clickable.");
						}

						// Break the loop since Paynow button is clicked
						break;

					} catch (NoSuchElementException e) {
						continue;
					} catch (StaleElementReferenceException e) {
						System.out.println(
								"StaleElementReferenceException caught. Retrying to locate and click the Pay Now button.");
						// Re-locate and retry the Pay Now button
						String payNowButtonXpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-185vgvk'])["
								+ i + "]";
						WebElement payNowButton = driver.findElement(By.xpath(payNowButtonXpath));
						js.executeScript("arguments[0].click();", payNowButton);
						System.out.println("Pay Now is clicked");

						// Re-locate and click the Pay Now button again to ensure it is clicked
						payNowButton = driver.findElement(By.xpath(payNowButtonXpath));
						payNowButton.click();
						System.out.println("Pay Now is clicked");
						payNowClicked = true;
						Thread.sleep(2000);

						// Break the loop since Pay Now button is clicked
						break;
					}
				} else {
					System.out.println("ScheduledPooja or date does not match. Moving to the next item.");
				}
			}

			if (!payNowClicked && Utility.isNextPageAvailable(driver, nxtbtndevoteepagination)) {
				clickNextPageButton(driver);
				Thread.sleep(2000); // Wait for page to load
			}
		}
		Thread.sleep(3000);
		
		util.waitUntilElement(driver, creditcardbtn);
		creditcardbtn.click();
		Thread.sleep(1000);
		util.waitUntilElement(driver, proceedbtn);
		proceedbtn.click();
		Thread.sleep(1000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
				arrowCircleRightOutlinedIcon);
		Thread.sleep(2000);

		arrowCircleRightOutlinedIcon.click();

		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", creditCardNoField);

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

}
