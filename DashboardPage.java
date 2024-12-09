package org.hints.pages;

import java.util.ArrayList;
import org.hints.utility.DataProviderFactory;
import org.hints.utility.GenerateReports;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	public DashboardPage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//div[text()='My Dashboard']")
	public WebElement MyDashboardTab;

	@FindBy(xpath = "//p[contains(@class, '_UsernameTitle_1dg9h_1')]")
	public WebElement DashboardTitle;

	@FindBy(xpath = "//button[contains(@class, '_carouselButton_1dg9h_634')][1]")
	public WebElement LeftCarousalBtn;

	@FindBy(xpath = "//button[contains(@class, '_carouselButton_1dg9h_634')][2]")
	public WebElement RIghtCarousalBtn;

	@FindBy(xpath = "//img[@alt='Shiva Abhishekam']")
	public WebElement Card1;

	@FindBy(xpath = "//img[@alt='Venkata Abhisekham']")
	public WebElement Card2;

	@FindBy(xpath = "//img[@alt='Eshwara Abhisekham']")
	public WebElement Card3;

	@FindBy(xpath = "//img[@alt='Abhisekham']")
	public WebElement Card4;

	@FindBy(xpath = "//p[text()='Shiva Abhishekam']//following::span[text()='View More']")
	public WebElement Card1_ViewMore;

	@FindBy(xpath = "//p[text()='Venkata Abhisekham']//following::span[text()='View More']")
	public WebElement Card2_ViewMore;

	@FindBy(xpath = "//div[text()='Information']")
	public WebElement InformationTab;

	@FindBy(xpath = "//div[text()='Overview']")
	public WebElement OverviewTab;

	@FindBy(xpath = "//div[text()='Pooja Items']")
	public WebElement PoojaItemsTab;

	@FindBy(xpath = "//div[text()='Services']")
	public WebElement ServicesSubTab;

	@FindBy(xpath = "//div[text()='Newsletter']")
	public WebElement NewsLetterTab;

	@FindBy(xpath = "//div[text()='Awards']")
	public WebElement AwardsTab;

	@FindBy(xpath = "//div[text()='Event Facilities']")
	public WebElement EventFacilitiesTab;

	@FindBy(xpath = "//div[text()='Management Team']")
	public WebElement ManagementTeamTab;

	@FindBy(xpath = "//div[text()='Refund Policy']")
	public WebElement RefundPolicyTab;

	@FindBy(xpath = "//div[text()='Information']//following::div[text()='Services']")
	public WebElement ServicesMainTab;

	@FindBy(xpath = "//div[text()='Human Services']")
	public WebElement HumanServicesTab;

	@FindBy(xpath = "//div[text()='Youth and Education']")
	public WebElement YandETab;

	@FindBy(xpath = "//div[contains(text(), 'Young Adult')]")
	public WebElement YoungAdultTab;

	@FindBy(xpath = "//div[text()='Golden Ager']")
	public WebElement GoldenAgersTab;

	@FindBy(xpath = "//div[text()='Cultural']")
	public WebElement CulturalTab;

	@FindBy(xpath = "//div[text()='Calendar']")
	public WebElement CalendarTab;

	@FindBy(xpath = "//div[text()='Donation']")
	public WebElement DonationTab;

	@FindBy(xpath = "//div[text()='Temple History']")
	public WebElement TempleHistoryTab;

	@FindBy(xpath = "//div[text()='Contact Us']")
	public WebElement ContactUsTab;

	@FindBy(xpath = "//div[text()='Contact Info']")
	public WebElement ContactInfoTab;

	@FindBy(xpath = "//div[text()='Send Feedback']")
	public WebElement SendFeedbackTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement SearchField;
	
	

	public void validateDashboard() throws Exception {
		util.waitUntilElement(driver, DashboardTitle);

		Thread.sleep(2000);
		Card1.click();
		Card1_ViewMore.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Card1_ViewMore);
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.livermoretemple.org/hints/content/html/2023/sudharshana-homam.pdf");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(tab.get(0));
		util.waitUntilElement(driver, DashboardTitle);
		Thread.sleep(2000);
		Card2.click();
		Card2_ViewMore.click();
		ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		String URL1 = driver.getCurrentUrl();
		Assert.assertEquals(URL1,
				"https://www.livermoretemple.org/hints/content/html/2023/sri-vishnu-pushpa-yaagam.pdf");
		driver.close();
	}

}
