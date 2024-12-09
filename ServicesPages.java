package org.hints.pages;

import java.util.ArrayList;
import java.util.List;

import org.hints.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ServicesPages {

	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public ServicesPages(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement userProfileIcon;

	@FindBy(xpath = "//div[text()='Change Role']")
	private WebElement changeRoleMenu;

	@FindBy(xpath = "//div[text()='Devotee']")
	private WebElement devoteeRole;

	@FindBy(xpath = "//div[text()=\"Services\"]")
	public WebElement servicesTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[5]")
	public WebElement culturalTab;

	@FindBy(xpath = "//img[@src=\"/images/cultural.png\"]")
	public WebElement culturalImage;

	@FindBy(xpath = "//button[text()=\"Donate for event\"]")
	public WebElement donateForEvent;

	@FindBy(xpath = "//div[@class=\"MuiDialogContent-root devotee_CommonDonationFormContainer__XNcU9 css-1ty026z\"]")
	public WebElement donationPopUp;
	
	public void validateCulturalPage() throws InterruptedException {

		servicesTab.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(servicesTab, 0, 0).build().perform();
		Thread.sleep(2000);
		culturalTab.click();
		Thread.sleep(4000);
		culturalImage.isDisplayed();
		Assert.assertTrue(culturalImage.isDisplayed(), "Image is not displayed");
		System.out.println("cultural image is displayed");

	}

	public void validateDonateForEvent() throws InterruptedException {

		servicesTab.click();
		Thread.sleep(2000);
		culturalTab.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", donateForEvent);
		donateForEvent.click();
		donationPopUp.isDisplayed();
		Assert.assertTrue(donationPopUp.isDisplayed(), "Image is not displayed");
		Thread.sleep(4000);
		

	}

}
