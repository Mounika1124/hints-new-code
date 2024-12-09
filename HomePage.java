package org.hints.pages;

import static org.testng.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.hints.utility.Logging;
import org.hints.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import bsh.ParseException;

//import com.aventstack.extentreports.util.Assert;

public class HomePage {
	WebDriver driver;
	Utility util = new Utility(driver, 30);
	public List<WebElement> faqQuestions;

	public HomePage(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[@class=\"menuBar_userInfo__sWrm-\"]/div")
	public WebElement LoginBtn_main;
	
	@FindBy(xpath = "(//div[@class='Carousel_Slide__srXk8 Carousel_hovered__5d6RJ'])[1]")
	public WebElement bannerButton1;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[2]")
	public WebElement bannerButton2;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[3]")
	public WebElement bannerButton3;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[4]")
	public WebElement bannerButton4;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[5]")
	public WebElement bannerButton5;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[6]")
	public WebElement bannerButton6;

	@FindBy(xpath = "//div[@class='_ButtonContainer_62ixz_16']//child::button[7]")
	public WebElement bannerButton7;

	@FindBy(xpath = "//img[@src='./images/facilities-ban2.jpg']")
	public WebElement eventBanner1;

	@FindBy(xpath = "//img[@src='./images/karthika-masa.jpg']")
	public WebElement eventBanner2;

	@FindBy(xpath = "//img[@src='https://hints20.livermoretemple.org/hints/images/2024/banners/ai-ban2.jpg']")
	public WebElement eventBanner3;

	@FindBy(xpath = "//img[@src='./images/ayyappa-mandala.jpg']")
	public WebElement eventBanner4;

	@FindBy(xpath = "//img[@src='./images/annadana-banner.jpg']")
	public WebElement eventBanner5;

	@FindBy(xpath = "//img[@src='https://hints20.livermoretemple.org/hints/images/2024/banners/2024cal.jpg']")
	public WebElement eventBanner6;

	@FindBy(xpath = "//img[@src='./images/mobile-app-banner.jpg']")
	public WebElement eventBanner7;

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement HomeTab;

	//// Service Banner///

	@FindBy(xpath = "//img[@src='https://hints20.livermoretemple.org/hints/images/2024/pujabooking1.jpg']")
	public WebElement poojaBookingBanner;
	
	@FindBy(xpath = "//img[@src='https://hints20.livermoretemple.org/hints/images/2024/annadana-service.jpg']")
	public WebElement annadanamBanner;

	@FindBy(xpath = "//img[@src='https://hints20.livermoretemple.org/hints/images/2014/facilities.gif']")
	public WebElement eventBookingBanner;
	
	@FindBy(xpath = "//p[normalize-space()='Pooja Booking']/following-sibling::button")
	public WebElement poojaBookingButton;

	@FindBy(xpath = "//button[normalize-space()='donate']")
	public WebElement annadanaDonationButton;
	
	@FindBy(xpath = "//div[contains(@class,'SliderServices_servicesMainContainer__sPU+6 MuiBox-root css-0')]//div[3]//div[2]//button[1]")
	public WebElement eventbookingButton;

	@FindBy(xpath = "//button[@aria-label='close']")
	public WebElement CloseButton;

	@FindBy(xpath = "(//p[text()='Please Login'])[1]")
	public WebElement pleaseLoginToastMessage;

	/// Others///
	@FindBy(xpath = "//img[@src=\"/images/Prayer.svg\"]")
	public WebElement sahanavavthuCard;

	@FindBy(xpath = "//img[@src='/images/sahana.png']")
	public WebElement sahanaVavathupCard;

	@FindBy(xpath = "//img[@src='/images/omjai.png']")
	public WebElement omJaiJagadishHareCard;

	@FindBy(xpath = "//img[@src='/images/omnames.png']")
	public WebElement omNamahShivaayaCard;

	@FindBy(xpath = "//img[@src=\"/images/AboutTempleSmall.svg\"]")
	public WebElement aboutTempleCard;

	@FindBy(linkText = "https://hints20.livermoretemple.org//hints/content/html/2022/temple-history.pdf")
	public WebElement templeHistoryLink;

	@FindBy(xpath = "//a[@href='https://hccccars.org']")
	public WebElement hcccHistoryLink;

	@FindBy(xpath = "//img[@src=\"/images/FAQ.svg\"]")
	public WebElement faqCard;
	
	@FindBy(xpath="//div[text()=\"Temple History\"]")
	public WebElement TempleHistory;

	@FindBy(xpath = "//div[text()='Information']")
	public WebElement InformationTab;

	@FindBy(xpath = "//div[@class=\"menuBar_tab__3haMu\"][1]")
	public WebElement informationMenu;

	@FindBy(xpath = "//div[text()='Refund Policy']")
	public WebElement RefundPoilcy;

	@FindBy(xpath = "//div[text()='Overview']")
	public WebElement Overview;

	@FindBy(xpath = "//div[@class='menuBar_subTab__S54-u'][normalize-space()='Services']")
	public WebElement Services;

	@FindBy(xpath = "//span[normalize-space()='Religious']")
	public WebElement Religious;

	@FindBy(xpath = "//span[normalize-space()='Human Services']")
	public WebElement HumanServices;

	@FindBy(xpath = "//span[text()='Youth & Education']")
	public WebElement YouthandEducation;

	@FindBy(xpath= "//div[text()='Event Facilities']")
	public WebElement EventFacilities;
	
	@FindBy(xpath = "//button[@aria-label='User Profile']")
	public WebElement UserProfileIcon;

	@FindBy(xpath = "//div[text()='Change Role']")
	public WebElement changeRoleMenu;

	@FindBy(xpath = "//div[@id=\"Manager\"]")
	public WebElement ManagerRole;

	@FindBy(xpath = "//div[contains(text(),'Devotee Management')]")
	public WebElement DevoteeManagement;

	@FindBy(xpath = "//div[@id='CONSOLIDATE_ACCOUNTS']")
	public WebElement CONSOLIDATEACCOUNTS;

	@FindBy(xpath = "//input[@placeholder=\"Enter Firstname\"]")
	public WebElement Firstname;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement Search;

	@FindBy(xpath = "//p[text()=\"AATestF AAU test (AATEST)\"]")
	public WebElement AATestF;

	@FindBy(xpath = "//p[text()=\"newtestt testneww (ABCD2577)\"]")
	public WebElement newtestt;

	@FindBy(xpath = "//img[@alt='rightArrow']")
	public WebElement RightArrow;

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement Submit;

	@FindBy(xpath = "//button[text()='Clear']")
	public WebElement Clear;

	@FindBy(xpath = "//div[text()='Devotee Service']")
	public WebElement DevoteeService;

	@FindBy(xpath = "//div[@id='DONATION']")
	public WebElement Donation;

	@FindBy(xpath = "//input[@id='signInName']")
	public WebElement Donationsigninname;

	@FindBy(xpath = "//button[@id='search']")
	public WebElement search;

	@FindBy(xpath = "//tbody[@id='searchData']//tr[@class=\"devoteeService_tableRow__eRfED\"]//td[@class=\"devoteeService_tableDiagonal__WHx9s\"][1]")
	public WebElement searchsignInName;

	@FindBy(xpath = "//div[@id='purposeDonation']")
	public WebElement Donation_Drop;

	@FindBy(xpath = "//input[@id='ammountinDollars']")
	public WebElement DonationAmount;

	@FindBy(xpath = "//textarea[@id='description']")
	public WebElement Description;

	@FindBy(xpath = "//button[@id='add']")
	public WebElement Add;

	@FindBy(xpath = "//button[@id='closeButton']")
	public WebElement popUpElement;

	@FindBy(xpath = "//img[@alt='cart Icon']")
	public WebElement carticon;
	
	@FindBy(xpath = "//div[@class=\"Information_singleCard__KR463\"][1]")
	public WebElement award1;

	@FindBy(xpath = "//div[@class=\"Information_singleCard__KR463\"][2]")
	public WebElement award2;

	@FindBy(xpath = "//div[text()=\"Awards\"]")
	public WebElement awardsSubmenu;
	
	@FindBy(xpath = "(//pre[text()='PDF to view the award'])[1]")
	public WebElement award1pdf;
	
	@FindBy(xpath = "(//pre[text()='PDF to view the award'])[2]")
	public WebElement award2pdf;

//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][1]")
//	public WebElement faqQuestion1;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][2]")
//	public WebElement faqQuestion2;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][3]")
//	public WebElement faqQuestion3;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][4]")
//	public WebElement faqQuestion4;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][5]")
//	public WebElement faqQuestion5;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][6]")
//	public WebElement faqQuestion6;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][7]")
//	public WebElement faqQuestion7;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][8]")
//	public WebElement faqQuestion8;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][9]")
//	public WebElement faqQuestion9;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][10]")
//	public WebElement faqQuestion10;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][11]")
//	public WebElement faqQuestion11;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][12]")
//	public WebElement faqQuestion12;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][13]")
//	public WebElement faqQuestion13;
//
//	@FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle1')][14]")
//	public WebElement faqQuestion14;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ghxf0f']")
	public WebElement DateElement;

	@FindBy(xpath = "(//*[local-name()='svg' and @data-testid='ChevronRightIcon'])[3]")
	public WebElement rightArrow;

	@FindBy(xpath = "(//*[local-name()='svg' and @data-testid='ChevronLeftIcon'])[3]")
	public WebElement leftScrollbar;

	@FindBy(xpath = "//div[@class='MuiStep-root MuiStep-vertical css-0']")
	public List<WebElement> templeTimingElements;

	@FindBy(xpath = "//div[text()='Select Date']")
	public WebElement selectedDateTab;

	@FindBy(xpath = "//div[@class='devotee_ScheduleEventTemplateContainer__aN-1a']")
	public WebElement templeSchedule;

	@FindBy(xpath = "//table[@class=\"Others_historycontainer__cv6Yq\"]")
	public WebElement hccHistoricalInfo;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 Others_content__WBFXZ css-9l3uo3']")
	private WebElement aboutTemplecontent;
	
	//ServicesTab//
	
		@FindBy(xpath="//div[text()='Services']")
		public WebElement ServicesTab;
		
		@FindBy(xpath = "//div[text()=\"Human Services\"]")
		public WebElement Humanservices;
		
		@FindBy(xpath = "//span[text()=\"Policy\"]")
		public WebElement Policy;
		
		@FindBy(xpath ="//span[text()=\"Contact Us\"]")
		public WebElement ContactUs;
		
		@FindBy(xpath ="//p[text()=\" Download the Brochure\"]")
		public WebElement DownloadtheBrochurePdf ;
		
		@FindBy(xpath ="//p[text()=\" Grant-In-Aid Program Article in the Independent\"]")
		public WebElement GrantInAidPdf ;
		
		@FindBy(xpath ="//div[text()=\"Youth and Education\"]")
		public WebElement YouthEducation ;
		
		@FindBy(xpath ="//span[text()=\"Activity\"]")
		public WebElement activity ;
		
		@FindBy(xpath ="//div[text()=\"Young Adult's\"]")
		public WebElement YoungAdults ;

		@FindBy(xpath="//div[text()=\"Golden Ager's\"]")
		public WebElement GoldenAgers;
		
		@FindBy(xpath="//span[text()=\"Overview\"]")
		public WebElement overview;
		
		@FindBy(xpath="//span[text()=\"Activity\"]")
		public WebElement Activity;

		@FindBy(xpath="//button[@class=\"p-dialog-header-icon p-dialog-header-close p-link\"]")
		public WebElement carspopup;

	public void bannerValidation() throws Exception {
		util.waitUntilElement(driver, HomeTab);
		HomeTab.click();
		util.waitUntilElement(driver, bannerButton1);
		bannerButton1.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner1.isDisplayed(), "Facilities banner is visible");
		} else {
			bannerButton1.click();
			assertTrue(eventBanner1.isDisplayed(), "Facilities banner is visible");
		}
		bannerButton2.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner2.isDisplayed(), "karthika masa banner is visible");
		} else {
			bannerButton2.click();
			assertTrue(eventBanner2.isDisplayed(), "karthika masa banner is visible");
		}

		bannerButton3.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner3.isDisplayed(), "calendar banner is visible");
		} else {
			bannerButton3.click();
			assertTrue(eventBanner3.isDisplayed(), "calendar banner is visible");
		}

		bannerButton4.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner4.isDisplayed(), "ayyappa mandala banner is visible");
		} else {
			bannerButton4.click();
			assertTrue(eventBanner4.isDisplayed(), "ayyappa mandala banner is visible");
		}

		bannerButton5.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner5.isDisplayed(), "annadana banner is visible");
		} else {
			bannerButton5.click();
			assertTrue(eventBanner5.isDisplayed(), "annadana banner is visible");
		}

		bannerButton6.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner6.isDisplayed(), "young adults banner is visible");
		} else {
			bannerButton6.click();
			assertTrue(eventBanner6.isDisplayed(), "young adults banner is visible");
		}

		bannerButton7.click();
		if (eventBanner1.isDisplayed()) {
			assertTrue(eventBanner7.isDisplayed(), "Mobile app banner is visible");
		} else {
			bannerButton7.click();
			assertTrue(eventBanner7.isDisplayed(), "Mobile app banner is visible");
		}

	}

	public void serviceBannerValidation() throws InterruptedException {
		util.waitUntilElement(driver, HomeTab);
		HomeTab.click();
		util.waitUntilElement(driver, annadanamBanner);
		if (annadanamBanner.isDisplayed()) {
			assertTrue(annadanamBanner.isDisplayed(), "Mobile app banner is visible");
			util.waitUntilElement(driver, annadanaDonationButton);

			annadanaDonationButton.click();
			util.waitUntilElement(driver, CloseButton);

			CloseButton.click();

		} else {
			System.out.println("Banner not displayed");
		}

		if (poojaBookingBanner.isDisplayed()) {
			assertTrue(poojaBookingBanner.isDisplayed(), "Mobile app banner is visible");

			util.waitUntilElement(driver, poojaBookingButton);

			poojaBookingButton.click();

			String actualSuccessMessage = pleaseLoginToastMessage.getText();

			String expectedSuccessMessage = "Please Login";
			Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Please Login message mismatch");

		}

	}

	public void navigateToSahanavavthuPage() throws Exception

	{
		util.waitUntilElement(driver, sahanavavthuCard);

		sahanavavthuCard.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/bhajana";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");

	}

	public void validateBajanCards() {
		util.waitUntilElement(driver, sahanaVavathupCard);
		Assert.assertTrue(sahanaVavathupCard.isDisplayed(), "sahanaVavathupCard is not displayed");

		util.waitUntilElement(driver, omJaiJagadishHareCard);
		Assert.assertTrue(omJaiJagadishHareCard.isDisplayed(), "omJaiJagadishHareCard is not displayed");

		util.waitUntilElement(driver, omNamahShivaayaCard);
		Assert.assertTrue(omNamahShivaayaCard.isDisplayed(), "omNamahShivaayaCard is not displayed");

	}

	public void navigateToAboutTemplePage() throws Exception {

		util.waitUntilElement(driver, aboutTempleCard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", aboutTempleCard);

		aboutTempleCard.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/abouttemple";

		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the About Temple page. Current URL: ");

//		System.out.println(aboutTemplecontent.getText());
//
//		System.out.println(hccHistoricalInfo.getText());
	}

	public void validateAboutTemplePageLinks() throws InterruptedException {

		util.waitUntilElement(driver, templeHistoryLink);

		if (templeHistoryLink.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
					templeHistoryLink);
			Thread.sleep(2000);

			String parentHandle = driver.getWindowHandle();

			templeHistoryLink.click();
			Thread.sleep(2000);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(parentHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://hints20.livermoretemple.org//hints/content/html/2022/temple-history.pdf";
			Assert.assertEquals(actualUrl, expectedUrl,
					"URL mismatch after clicking on Temple Story link in the new window.");

			driver.close();

			// Switch back to the original window
			driver.switchTo().window(parentHandle);
		} else {
			Assert.fail("Temple Story link is not present on the About Temple page");
		}

		if (hcccHistoryLink.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", hcccHistoryLink);
			Thread.sleep(2000);

			String parentHandle = driver.getWindowHandle();

			hcccHistoryLink.click();

			// Switch to the new window
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(parentHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://hccccars.org/";
			Assert.assertEquals(actualUrl, expectedUrl,
					"URL mismatch after clicking on HCCC History link in the new window.");

			driver.close();

			driver.switchTo().window(parentHandle);

		} else {
			Assert.fail("HCCC History link is not present on the About Temple page");
		}

	}

	public void navigateToFAQPage() {
		util.waitUntilElement(driver, faqCard);

		faqCard.click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/faqs";
		Assert.assertEquals(actualUrl, expectedUrl,
				"URL mismatch after clicking on FAQ card. Actual URL: " + actualUrl + ", Expected URL: " + expectedUrl);

	}

	public void validateFAQQuestions() throws InterruptedException {
		// Expected questions
		String[] expectedQuestions = { "What is the history of HCCC or Shiva Vishnu Temple or Livermore Temple",
				"What type 0f Services are Offered by HCCC?", "How are Devotees helping HCCC?",
				"How can I, as a Devotee, Donate?", "How are Volunteers helping HCCC?",
				"Can you talk about Livermore Temple Priests and Pachakas?",
				"Can you talk about Livermore Temple Support Staff?",
				"What is HCCC Management Structure and their role in HCCC?",
				"What type of religious services are offered at the Livermore temple?",
				"What type of Religious Services offered at the Temple?",
				"What type of Religious Services offered at the residence of devotees?",
				"What are some Key Events Celebrated at the Temple?", "What type of Other Services I expect from HCCC?",
				"What is HCCC’s Refund, Return & Cancellation Policy?"

		};

		for (int i = 0; i < expectedQuestions.length; i++) {
			WebElement faqQuestion = driver
					.findElement(By.xpath("(//h6[contains(@class, 'MuiTypography-subtitle1')])[" + (i + 1) + "]"));
			String actualQuestion = faqQuestion.getText();

			Assert.assertEquals(actualQuestion, expectedQuestions[i],
					"FAQ Question " + (i + 1) + " doesn't match the expected question.");
			Thread.sleep(1000);

		}

	}

	public void navigateToNext7DaysEvents() throws java.text.ParseException, InterruptedException {

		String currentDate = DateElement.getText();

		for (int i = 0; i < 7 && rightArrow.isEnabled(); i++) {
			String nextDate = DateElement.getText();
			if (isDateIncremented(currentDate, nextDate)) {

				Logging.logger.info("Checking temple timing for " + nextDate);
				util.waitUntilElement(driver, templeSchedule);

				Assert.assertTrue(templeSchedule.isDisplayed(), "Temple schedule is not displayed for " + nextDate);

				/// checkTempleTiming();

//				List<WebElement> elements = templeTimingElements;
//				// Iterate through the elements and print their details
//				for (int y = 0; y < elements.size(); y++) {
//					WebElement element = elements.get(y);
//
//					System.out.println("Temple Detail " + (y + 1) + ": " + element.getText());
//				}
				// Update the current date
				currentDate = nextDate;
			}
			Thread.sleep(6000);
			// Click the right arrow to go to the next day
			rightArrow.click();
		}
	}

	private boolean isDateIncremented(String currentDate, String nextDate) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date current = sdf.parse(currentDate);
		java.util.Date next = sdf.parse(nextDate);
		return next.after(current);
	}

	public void CheckEventsDisplayedForSelectedDate() throws InterruptedException {
		selectedDateTab.click();
		Thread.sleep(4000);
		List<WebElement> elements = templeTimingElements;

		for (int y = 0; y < elements.size(); y++) {
			WebElement element = elements.get(y);

			System.out.println("Temple Detail " + (y + 1) + ": " + element.getText());
		}

	}
	public void navigatetorefundPolicy() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();
        Thread.sleep(2000);
		util.waitUntilElement(driver, RefundPoilcy);
		RefundPoilcy.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/refundPolicy";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}

	public void validaterefundPolicy() throws InterruptedException {

		String[] expectedtext = { "The donations can be refunded", "returned or cancelled", "if you send us an email",
				"explaining the circumstances for your request", "within 24 hours of your donation",
				"Upon receipt of your request", "it would take us up to 10 days to post to your credit card",
				"You should send an email torefunds@livermoretemple",
				"orgusing your email address that is registered in temple website" };
		WebElement informationContent = driver.findElement(
				By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 Information_content__fVFjb css-9l3uo3']"));

		String actualText = informationContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}

	public void navigatetooverview() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();
		Thread.sleep(2000);
		util.waitUntilElement(driver, Overview);
		Overview.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/overview";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}

	public void validateoverview() throws InterruptedException {

		String[] expectedtext = {
				"HCCC was established in 1977 with the goal of offering religious services to Hindu community. In the last 35 years the HCCC has evolved into an established institution as a place of worship with the needed services for the community.\n"
						+ "HCCC Historical Information\n" + "1977: HCCC was incorporated\n"
						+ "1980 - 83: Land acquired in Livermore\n" + "1983 – 86: Interim Temple.\n"
						+ "1984 - 85: Idols donated by Tamil Nadu Govt. & TTD\n" + "1984 - 86:\n"
						+ "Foundation stone laid by Sri. N.T. Rama Rao.\n"
						+ "Shilpis arrive from India and major construction began.\n"
						+ "Foundation ceremonies for cultural center by Pdt. Ravi Shankar and Ustad Ali Akbar Khan\n"
						+ "1986: Kumbhabhishekam - July 13\n"
						+ "1992: Enclosure and roof completed & Raja gopuram and other Gopurams completed\n"
						+ "1997: Assembly Hall inaugurated by Livermore City Councilman\n"
						+ "Inaugural concert by K.J. Yesudas & Party\n" + "1998: Mahakumbhabhishekam in July 5\n"
						+ "Dakshina Bhoomi purchased\n" + "1999: Poorva Bhoomi purchased\n"
						+ "2001: Temple Flooring completed\n" + "2002: 25th Anniversary Celebrations\n"
						+ "2003: Endowment Fund Intiation.\n" + "2010: Mahakumbhabhishekam II - June 16\n"
						+ "2011: Kanaka Durga Prayer Hall completion\n" + "2012:\n"
						+ "Administrative Building Completion.\n" + "Multi-Purpose Building Completion.\n"
						+ "Akella Annadana Kitchen Completion\n" + "2013:\n" + "Lakireddy Auditorium Completion\n"
						+ "East Parking Lot Completion\n" + "2016: Solar Project\n" + "2019: Temple 33rd Anniversary\n"
						+ "2022: Mahakumbhabhishekam III July 10\n" + "Panavattam in Shiva Shrine\n"
						+ "Kohstha vigrahas for Balaji Shrine\n" + "Sri Chandikeshwara deity\n"
						+ "new moola murthies of Sri Rama Parivar\n" + "gold plated Dwajasthambhas\n"
						+ "Alaya Shikar Kalasha and Prabhavalis\n" + "Services Offered by HCCC\n"
						+ "Religious Services at temple and devotee residences\n" + "Renting of Facilities\n"
						+ "Human Services\n" + "Youth and Education\n" + "Cultural Events\n" + "Spiritual Services\n"
						+ "Additional details on the above services are furnished in the subsequent sections.\n"
						+ "Devotees\n"
						+ "The participation and support of the devotees keep the HCCC momentum going. The HCCC is sustained by the generosity of devotees.\n"
						+ "Devotee feedback on the services and the operational aspects will be well appreciated and helpful in serving the devotee and the community needs.\n"
						+ "Donors\n"
						+ "There are many ways donors contribute such as hundi donation, religious services, annadana program, construction programs, abharanas, abharana account, endowment account, etc.\n"
						+ "HCCC greatly appreciates the support and generosity of the donors.\n" + "Volunteers\n"
						+ "It would not have been possible to build this institution without the dedicated support of many volunteers.\n"
						+ "Volunteers play various roles and help in many operational aspects to serve the devotee and the community needs supported by the management and the support staff:\n"
						+ "Coordinating events\n" + "Assisting in event activities\n"
						+ "Parking control during major events\n" + "Fund raising support\n"
						+ "Garland making for the deities\n" + "In the front office\n" + "In the kitchen\n"
						+ "Maintenance & construction support\n"
						+ "Each year HCCC management awards Steering Committee membership to the dedicated volunteers as per the HCCC policy.\n"
						+ "Priests and Pachakas\n"
						+ "Our priests are well versed with the pujas, chanting, Hindu traditions and sampradayas. They speak multiple languages.\n"
						+ "Pachakas support the priests with the neivedyam preparation. They also make the laddu and vada prasadam, and annadana food served on the weekends.\n"
						+ "The HCCC has 12 priests and two pachakas, are supported by the management, the supporting staff and the volunteers.\n"
						+ "Our Priests and Pachakas Details\n" + "Support Staff\n"
						+ "Includes a Manager, Assistant Manager, front desk staff, maintenance staff and a part-time librarian.\n"
						+ "Plays a key role in the day to day operations of HCCC supported by the management.\n"
						+ "Management\n" + "Steering Committee:\n" + "The supreme body of HCCC. Meets once a quarter.\n"
						+ "Elects Board of Directors (BOD) and Executive Committee (EC) members through an election process.\n"
						+ "Advises the BOD on the strategic matters.\n"
						+ "Reviews and approves the annual budget and the resolutions recommended by BOD.\n"
						+ "Board of Directors (BOD):\n"
						+ "Consists of nine members headed by a Chairman. Meets once a month or as needed.\n"
						+ "Has fiduciary responsibility and oversees the temple operations guiding EC.\n"
						+ "Review and approve resolutions recommended by EC.\n"
						+ "Review and recommend annual budget proposed by Treasurer to SC.\n"
						+ "Executive Committee (EC):\n"
						+ "Consists of multiple members headed by a President who is a board member. Meets once a month or as needed.\n"
						+ "Each member can opt as a chair of a functional area as per the board approval.\n"
						+ "Each chair oversees the assigned functional area tasks and the respective budget.\n"
						+ "Treasurer oversees all the financial aspects and the overall budget.\n"
						+ "Reviews and approves the operational resolutions." };
		WebElement overviewContent = driver.findElement(By.xpath(
				"//body/div[@id='root']/div/main[@class='layout_mainContainer__SJEJ0']/div[@class='Information_OverView__S85VZ']/div[@class='MuiGrid-root css-rfnosa']/div[@class='Information_cardContainer__zyGwG']"));

		String actualText = overviewContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}	
	public void navigatetoReligious() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();
        Thread.sleep(2000);
		util.waitUntilElement(driver, Services);
		Services.click();

		util.waitUntilElement(driver, Religious);
		Religious.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(informationMenu, 0, 0).build().perform();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/serviceinformation";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}

	public void validateReligious() throws InterruptedException {

		String[] expectedtext = {
				"The Shiva-Vishnu Temple is offering religious services for the Hindu community both at the temple and at the residence of devotees. HCCC also serves the community needs through human services, youth & education, and cultural events.\n"
						+ "The deities in the main temple are: Ganesha, Shiva, Parvati, Kartikeya, Sridevi (Lakshmi), Vishnu, Bhoodevi, Radha-Krishna, Rama-Sita, Navagraha, Hanuman, Kalabhairava, and Dashbhuja Durga. Deity Kanaka Durga Devi is in Kanaka Durga prayer hall. Serving the devotee needs as per Hindu traditions and sampradayas in authentic way is objective of HCCC."

		};
		WebElement ReligiousContent = driver.findElement(By
				.xpath("//p[@class=\"MuiTypography-root MuiTypography-body1 Information_content__fVFjb css-9l3uo3\"]"));

		String actualText = ReligiousContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	public void validateReligiousTempleServices() {
		
	    List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container Information_grid__gb7Zw css-v3z1wi'])[position() > 0 and position() < 16]"));

	    // Iterate through the list and validate each element
	    for (WebElement element : elements) {
	        WebElement image = element.findElement(By.xpath(".//img"));
	        WebElement text = element.findElement(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_offeredName__geh3F css-9l3uo3\"]")); // Adjust 'your-text-class' to the actual class of the text element

	        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");

	        Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

	        String textContent = text.getText();
	        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
	        System.out.println("Text Content: " + textContent);
	    }
	}		
	public void validateReligiousResidenceServices() {
		
		 List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container Information_grid__gb7Zw css-v3z1wi'])[position() > 15 and position() < 26]"));

		    // Iterate through the list and validate each element
		    for (WebElement element : elements) {
		        WebElement image = element.findElement(By.xpath(".//img"));
		        WebElement text = element.findElement(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_offeredName__geh3F css-9l3uo3\"]")); // Adjust 'your-text-class' to the actual class of the text element

		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");

		        Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

		        String textContent = text.getText();
		        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
		        System.out.println("Text Content: " + textContent);
		    } 	
	}
	public void validateReligiousKeyEvents() {
		
		 List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container Information_grid__gb7Zw css-v3z1wi'])[position() > 25 and position() < 41]"));

		    // Iterate through the list and validate each element
		    for (WebElement element : elements) {
		        WebElement image = element.findElement(By.xpath(".//img"));
		        WebElement text = element.findElement(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_offeredName__geh3F css-9l3uo3\"]")); // Adjust 'your-text-class' to the actual class of the text element

		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");

		        Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

		        String textContent = text.getText();
		        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
		        System.out.println("Text Content: " + textContent);
		    } 
	}
	public void navigatetohumanservices() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();

		util.waitUntilElement(driver, Services);
		Services.click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(informationMenu, 0, 0).build().perform();

		util.waitUntilElement(driver, HumanServices);
		HumanServices.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/serviceinformation";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}

	public void validateHumanServices() throws InterruptedException {

		String[] expectedtext = {
				"1. The Human Services Committee is an integral part of HCCC and is chartered with the responsibility of serving the communities locally and globally on a need basis irrespective of religion, race, and cultural identity depending upon the available funds, on a priority and need basis.\n"
						+ "2. HCCC allocates limited amount of funds each year for supporting eligible organizations engaged strictly in Human Service functions. Recipient organizations will be required to disclose the affiliations with other organizations to enable HCCC to determine their eligibility to receive HCCC charity funds.\n"
						+ "3. Human Service projects are mainly aimed at basic human needs as food, shelter, medical and educational purposes. All of its funds will be spent in these areas only.\n"
						+ "4.Human Services Committee welcomes the association of individuals and groups who would like to identify, donate and execute projects for human cause within its spectrum of coverage"

		};
		WebElement HumanServicesContent = driver.findElement(
				By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 Information_content__fVFjb css-9l3uo3']"));

		String actualText = HumanServicesContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	public void validateHumanServicesPrograms() {
		
		 List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container Information_grid__gb7Zw css-v3z1wi'])[position() > 0 and position() < 10]"));

		    // Iterate through the list and validate each element
		    for (WebElement element : elements) {
		        WebElement image = element.findElement(By.xpath(".//img"));
		        WebElement text = element.findElement(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_offeredName__geh3F css-9l3uo3\"]")); // Adjust 'your-text-class' to the actual class of the text element

		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");

		        Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

		        String textContent = text.getText();
		        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
		        System.out.println("Text Content: " + textContent);
		    } 
	}	
	public void navigatetoYouthandEducation() throws InterruptedException {
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();

		util.waitUntilElement(driver, Services);
		Services.click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(informationMenu, 0, 0).build().perform();

		util.waitUntilElement(driver, YouthandEducation);
		YouthandEducation.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/serviceinformation";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}

	public void validateYouthandEducation() throws InterruptedException {

		String[] expectedtext = {
				"1.To establish a full-fledged Learning Center which includes a library and conducting regular classes for enabling religious, cultural and spiritual learning for Asian-Indian children, youth and adults in the Northern California Community. The key elements of the center will include:\n"
						+ "An extensive state-of-the-art library housing authoritative books and audio-visual media on Vedic literature, religion and Indian history and culture in English and several Indian languages.\n"
						+ "Discourses and classes for youth and adults\n"
						+ "2.To establish systems and conduct regular youth workshops that inspire the youth by increasing their awareness of the spiritual and cultural richness of our heritage.\n"
						+ "3. To continuously advance the Learning Center though networking with other religious, cultural and spiritual learning centers around the world.\n"
						+ "Key Events Celebrated at the Temple\n" + "Art and Craft exhibitions\n"
						+ "Bala Jyothi classes\n" + "Bhagavad Gita and Vishnushasranamam classes\n"
						+ "Bhagavad gita discussions\n" + "Bhakti Jyothi classes\n"
						+ "Ganesha Chathurthi Children's program\n" + "Graduation Saraswati puja\n"
						+ "Navarathri Golu Musical program\n" + "Sanskrit as a Foreign Language program\n"
						+ "Sanskrit Camps\n" + "Sanskrit classes\n" + "Spelling and Math bee\n"
						+ "Summer Reading Program\n" + "Youth forum\n" + "Youth volunteer credit programs\n"
						+ "Library\n"
						+ "1.The HCCC library is housed in administrative building and open on Saturdays and Sundays from 10:30AM to 3:30PM.\n"
						+ "2.HCCC would be grateful to devotees for making generous donations of books, Audio-Visual material and/or monetary help for the development of the HCCC Learning Center. Books are media should ideally be one of the following subjects:\n"
						+ "Religious Texts such as Ramayana, Mahabharata, Bhagawad Gita, Bhagavatam, Upanishads etc.\n"
						+ "Indian Culture\n" + "Indian History\n" + "Indian/Hindu Philosophy and Spiritualism\n"
						+ "Books for Children like Amar Chitra Katha, Panchatantra etc." };
		WebElement YouthandEducationContent = driver
				.findElement(By.xpath("//div[@class=\"Information_Youthandeducation__S0joq\"]"));

		String actualText = YouthandEducationContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void validateYouthandEducationkeyEvents() {
		
		 List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container Information_grid__gb7Zw css-v3z1wi'])[position() > 0 and position() < 16]"));
		    for (WebElement element : elements) {
		        WebElement image = element.findElement(By.xpath(".//img"));
		        WebElement text = element.findElement(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_offeredName__geh3F css-9l3uo3\"]"));

		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");
		        Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

		        String textContent = text.getText();
		        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
		        System.out.println("Text Content: " + textContent);
		    } 
	}	
	
	public void navigatetoEventFacilities() throws InterruptedException {
		
		util.waitUntilElement(driver, informationMenu);
		informationMenu.click();
		
		util.waitUntilElement(driver, EventFacilities);
		EventFacilities.click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(informationMenu, 0, 0).build().perform();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://40.90.194.2:8080/eventFacilities";
		Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
	}
	
	public void verifyEventFacilities() {
			    List<WebElement> EventFacilities = driver.findElements(By.xpath("//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root Information_cardContainer__zyGwG css-s18byi\"] "));

		    for (WebElement EventFacilitie : EventFacilities) {
		        Assert.assertTrue(EventFacilitie.isDisplayed(), "EventFacilities is not displayed");
		    }
		}
	public void verifyExpandedFacilities () {
	    List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"Information_container__oCGPV\"]"));
	    for (WebElement element : elements) {
	        WebElement image = element.findElement(By.xpath(".//img"));
	        List<WebElement> texts = element.findElements(By.xpath(".//p[@class=\"MuiTypography-root MuiTypography-body1 Information_facilitieName__L7CTo css-9l3uo3\"]"));

	        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");
	        for (WebElement text : texts) {
	            Assert.assertTrue(text.isDisplayed(), "Text is not displayed");

	            String textContent = text.getText();
	            Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
	            System.out.println("Text Content: " + textContent);
	        }
	    }
	}

	public void verifyRentalFacilities () {
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"Information_container__oCGPV\"]"));
	    for (WebElement element : elements) {
	        WebElement image = element.findElement(By.xpath(".//img"));
	       // WebElement text = element.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 Information_facilitieName__L7CTo css-9l3uo3\"])[position() <4]"));
	        List<WebElement> texts = element.findElements(By.xpath("(//div[@class=\"Information_rentalContainer__au0zJ\"])[position() <14]"));
	        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");
	        for (WebElement text1 : texts) {

	        Assert.assertTrue(text1.isDisplayed(), "Text is not displayed");

	        String textContent = text1.getText();
	        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
	        System.out.println("Text Content: " + textContent);
	    } 	
	    }
	}
	
	public void verifyEventsHosting() {
	    List<WebElement> EventsHosting = driver.findElements(By.xpath("(//div[@class=\"Information_containersList__Ss9H0\"])[position() <7]"));

    for (WebElement EventHosting : EventsHosting) {
        Assert.assertTrue(EventHosting.isDisplayed(), "EventsHosting is not displayed");
    }
}
	
	public void  verifyAmenities() {
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"Information_amenitiescard__gn74O\"]"));

	        for (WebElement text1 : elements) {

	        Assert.assertTrue(text1.isDisplayed(), "Text is not displayed");
	        String textContent = text1.getText();
	        Assert.assertFalse(textContent.isEmpty(), "Text content is empty");
	        System.out.println("Text Content: " + textContent);
	    } 		
	}	
	public void verifyAwards() throws InterruptedException {
	    util.waitUntilElement(driver, informationMenu);

	    Thread.sleep(1000);
	    informationMenu.click();

	    // util.waitUntilElement(driver, awardsSubmenu);
	    awardsSubmenu.click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", award1);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(informationMenu, 0, 0).build().perform();
	    Thread.sleep(3000);

	    Assert.assertTrue(award1.isDisplayed(), "Award 1 is not displayed");
	    Assert.assertTrue(award2.isDisplayed(), "Award 2 is not displayed");
	    System.out.println("Awards Verified");

	    int initialWindowCount = driver.getWindowHandles().size();

	    util.waitUntilElement(driver, award1pdf);
	    award1pdf.click();

	    util.waitUntilElement(driver, award2pdf);
	    award2pdf.click();

	    Set<String> windowHandles = driver.getWindowHandles();
	    Assert.assertEquals(windowHandles.size(), initialWindowCount + 2, "Both PDFs were not opened in different windows");

	    driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
	    Assert.assertTrue(driver.getCurrentUrl().endsWith(".pdf"), "Award 1 PDF did not open in a new window");

	    driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 2]);
	    Assert.assertTrue(driver.getCurrentUrl().endsWith(".pdf"), "Award 2 PDF did not open in a new window");
	    
//	    Assert.assertTrue(award1PdfOpened, "Award 1 PDF did not open in another browser");
//	    Assert.assertTrue(award2PdfOpened, "Award 2 PDF did not open in another browser");
	}
	
	public void navigatetoGoldenAgers() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, GoldenAgers);
			GoldenAgers.click();
			
			util.waitUntilElement(driver, overview);
			overview.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/goldenAgers";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateGoldenAgersOverview() throws InterruptedException {

		String[] expectedtext = {
				"Charter\n"
				+ "In recognition of contribution by Senior Community in promotion of Hindu community wellbeing, culture and tradition, HCCC established the “Golden Ager’s Hindu Community Committee” as Strategic Standing Committee here in synonymous with and referred as “GASSC”, to prioritize and guide the much-needed Services at their golden age, Daily Living, Legal and as well as Financial within in the means.\n"
				+ "Our Mission\n"
				+ "In recognition of contribution by Senior Community in promotion of Hindu community wellbeing, culture and tradition, HCCC established the “Golden Ager’s Hindu Community Committee” as Strategic Standing Committee here in synonymous with and referred as “GASSC”, to prioritize and guide the much-needed Services at their golden age, Daily Living, Legal and as well as Financial within in the means.\n"
				+ "Objectives\n"
				+ "To look in to existing Senior services with avenues of updating along with incorporating. Other needed services derived from input on the portal of GAHC on HCCC Web Site. The Website of this Comte.” GASSC “is to facilitate communication among same age groups of Different backgrounds get together, help and assist each other. The services to be achievable and sustainable. Moreover, make them feel appreciated and be proud of their contribution in sharing of their experience and knowledge to the younger generation.\n"
				+ "Our Goals\n"
				+ "Establish a website including services and contact information for specific services available.\n"
				+ "Establish a roster of members to sign in to the website for assistance and as a channel of communication.\n"
				+ "Establish a roster of individual volunteers with special talents and/or resources willing to contribute to the community at large.\n"
				+ "Look into community needs met with existing avenues and reassess to promote or be a part of them.\n"
				+ "Identify other locations beyond SVT close to their vicinity to assist their needs and identify a place for getting together.\n"
				+ "Develop information and sources for their needs, including advisory services such as retirement planning, financial management, estate planning, avenues of funeral services, tax services, health directives, nutritional support services, health checkup services, and information on the management of health and well-being, including exercise programs such as yoga and meditation.\n"
				+ "Raise awareness of avenues and encourage contributions to SVT Endowment Funds at their will.\n"
				+ "Historical\n"
				+ "Dr. Peraiah Sudanagunta (Chairman)\n"
				+ "Dr. Kamala Shankar\n"
				+ "Mr. Bala Mani\n"
				+ "Mr. Kamlesh Jain\n"
				+ "Mr. Kumar Padmini\n"
				+ "Mr. Anand Gundu (Board Liaison)\n"
				+ "GASSC met on 5th.Dec,2017 and elected Dr. Peraiah Sudanagunta as chairman and Dr. Kamala Shankar as Vice Chairman.This committee has the goal to strategically plan and improve services for Seniors of Hindu heritage in Bay area.Historical perspective- HCCC Senior activities/ program under Human services;HCCC Human services has conducted various activities involving senior devotees. In 2007 Board of Directors initiated Senior activity program lead by Dr Kamala Shankar and Coordinated by Smt. Savitha Setlur. Over the years the program evolved under Human services EC lead by many coordinators, Mr. Anand Gundu, Smt. Suman Jain, Smt. Dharini Baskaran, Smt. Padmaja Madhusudan. The program /activities have continued namely: Yearly seniors day, Yearly bus trips, Volunteering at the temple, Senior activity program twice monthly ongoing for10 years, Arts/crafts activities, Bhagavat Gita discussion - Yoga/exercise and Socialization etc."

		};
		WebElement OverviewContent = driver.findElement(By
				.xpath("//div[@class=\"services_GoldenAgersOverviewContainer__J68St MuiBox-root css-0\"]"));

		String actualText = OverviewContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void navigatetoGoldenAgersActivity() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, GoldenAgers);
			GoldenAgers.click();
			
			util.waitUntilElement(driver, Activity);
			Activity.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/goldenAgers";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
		
	public void validateGoldenAgersActivity() throws InterruptedException {

		String[] expectedtext = {
				"Educational Activities | Spiritual Activities | Health & Wellness | In House Support | Funeral Services | Retirement Planning\n"
				+ "Introduction\n"
				+ "The goal of GASSC Educational Activity is to promote and provide assistance in continuing education, domain knowledge, and skills for its members. This program addresses the needs of members who wish to update, upgrade, or learn totally new domain knowledge and skills for changing their professional profile to continue being employed. The Education Activity also includes an initiative to institute and maintain a Golden Agers Mentoring program along with a hiring and internship referral service.The objectives, key success factors, and tactical activity plan for 2018 is provided below.\n"
				+ "Objectives\n"
				+ "Provide a 'Mentee Portal' on education, domain knowledge, and skills - Inbound\n"
				+ "Provide a 'Mentoring Portal' on education, domain knowledge, and skills - Outbound\n"
				+ "Build alliances for hiring and intern opportunities\n"
				+ "Build a team of Service Providers (sevaka) for educational activities\n"
				+ "Create 'Mailing List' for educational activities\n"
				+ "Maintain an up to date status of ESA tab on GASSC website\n"
				+ "Success Factors\n"
				+ "Promotion of Educational Activity\n"
				+ "Effectiveness of Service Providers (sevaka)\n"
				+ "Signup of mentors for mentees\n"
				+ "Signup of mentees for mentors\n"
				+ "Signup of alliances for referrals\n"
				+ "Signup of Service Providers (sevaka)\n"
				+ "2018 Activity Plan\n"
				+ "Create Service Provider job description\n"
				+ "Promote Service Provider requirement\n"
				+ "Identify the Service Provider leader to manage the Service Provisioning program\n"
				+ "Conduct initial and periodic Service Provider signup program\n"
				+ "Create the Service Provider team with specific defined service (responsibilities)\n"
				+ "Identity mentors for at least two areas of education, domain knowledge, and skills\n"
				+ "Create ‘Mentor-Mentee’ rules of engagement\n"
				+ "Promote mentors on ‘Mentor Platform’\n"
				+ "Create Mentee Registration Form\n"
				+ "Create list of potential employers for hiring and internships\n"
				+ "Create mailing list for educational activities\n"
				+ "Create quarterly report of ESA activities for GASSC leadership team\n"
				+ "Earth Quake\n"
				+ "Safety Checklist\n"
				+ "What to do"

		};
		WebElement OverviewContent = driver.findElement(By
				.xpath("//div[@class=\"services_goldenAgersActivityConatiner__BOmjj MuiBox-root css-0\"]"));

		String actualText = OverviewContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
				"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void navigatetoservicesoverview() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, Humanservices);
			Humanservices.click();
			
			util.waitUntilElement(driver, overview);
			overview.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/humanservices";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateservicesoverview() throws InterruptedException {

		String[] expectedtext = {
				"About Us\n"
				+ "Serving the community at large by making a difference in the lives of needy people is one of the important functions of the HCCC (Hindu Community and Cultural Center).Such activities are covered under Human Services. The HCCC strongly preaches in \"Serving God by Serving Humanity\" and practices it as its motto. In the past years, several social programs were successfully executed on different occasions. These activities range from assisting needy people and supporting student education activities to providing relief for victims of natural disasters. The Human Services committee organizes such programs with the help of kind-hearted donors and dedicated volunteers, who are willing to donate their time and resources for such noble causes. If you could spare a few hours a week and donate your valuable time Volunteer or resources Donations to serve the community, we warmly welcome you onboard.\n"
				+ "Projects\n"
				+ "The scope of the projects conducted is mostly limited by the available resources. However, all projects and events require pre-approval by the HCCC board and will be conducted with in the frame work of its policies.The following is a list of projects identified by the Human Services. Every year some of these projects or events are being executed routinely based upon the need for specific occasion and available resources and space. The committee appreciates motivated individuals identifying and conducting similar projects in different areas of public need and interest.\n"
				+ "Food programs for the needy\n"
				+ "Distribution of clothing, blankets, and toys.\n"
				+ "Senior activities and program for seniors.\n"
				+ "Support to other non-profit organizations dedicated to human services .... Application\n"
				+ "Thanksgiving and Christmas Dinner (Livermore and in Bay area)\n"
				+ "Health Advisory and Education Center on HCCC Premises ....FAQ’s.\n"
				+ "Health classes such as Yoga and/or meditation.\n"
				+ "Health drives such as blood donation and bone marrow.\n"
				+ "Donation of learning material to schools and libraries such as computers and books.\n"
				+ "Scholarships for gifted but needy students globally.\n"
				+ "Donations to victims of Natural Disaster globally.\n"
				+ "Funeral Services for devotees upon request.\n"
				+ "Prayer or Puja for critically ill upon request.\n"
				+ "Volunteers\n"
				+ "The Human Services Committee would to like to express our deepest appreciation and gratitude to those who have volunteered and are providing their services and untiring support in the hope of assisting the communities locally and globally. We are continually looking for volunteers and volunteering physicians to support our activities in the areas of project execution, fund raising and health advisory. The following is a list of a few of our volunteers. If you would like to be volunteer you are most welcome and your service is appreciated.\n"
				+ "Volunteers\n"
				+ "Venu Surakanti - Chairman\n"
				+ "Murali Swaminathan - President\n"
				+ "Venu Surakanti - Chairman\n"
				+ "Usha Ramaswamy - BOD Liaison\n"
				+ "Shyamala Venkateswaran- EC Chair\n"
				+ "Suman Jain\n"
				+ "Padmaja Madhusudan\n"
				+ "Saha Bode\n"
				+ "Raji Ramakrishnan\n"
				+ "Sathya Raghu\n"
				+ "Pranati Manava\n"
				+ "Manoj Srivatsava\n"
				+ "Jyothi Sarma\n"
				+ "Anand Gundu\n"
				+ "Vamsi Pulapa\n"
				+ "Bhaskar Swaminathan\n"
				+ "Geetha Haravu\n"
				+ "Kamlesh Jain\n"
				+ "Volunteering Physicians\n"
				+ "Dr. R Ravinder Kumar\n"
				+ "Dr. James Patel\n"
				+ "Dr. Kayal Sambandam\n"
				+ "Dr. Vuppa Ramesh\n"
				+ "Dr. Arunasri Kelleti\n"
				+ "Dr. Neel Palakurthy\n"
				+ "Dr. Yasminah Shabbar\n"
				+ "Dr. Sharda Patel\n"
				+ "Dr. Chitgopekar\n"
				+ "Dr. Uma Patel\n"
				+ "Dr. Ratika Sharma\n"
				+ "Dr. Manjula Reddy\n"
				+ "Dr. Murali Golconda\n"
				+ "Dr. Kiran Kapila\n"
				+ "Dr. Rishi Kapila\n"
				+ "Dr. Sampath Ramakrishana\n"
				+ "Dr. Sankari Kasi\n"
				+ "Dr. Elena Lopez\n"
				+ "Jyoti Saboo - Physical Therapist\n"
				+ "Surekha Pol - Physical Therapist\n"
				+ "Asha Bajaj - Physical Therapist\n"
				+ "Mala Seshagiri - Nutritionist\n"
				+ "Rini Johar - Homeopathy\n"
				+ "Dhira Gupta - Ayurveda\n"
				+ "Bhuvana Himakuntala\n"
				+ "Rashana Sharma\n"
				+ "Dr. Namitha Agarwal\n"
				+ "Dr. Sneha Kishore\n"
				+ "Preeti Gupta Ayurveda\n"
				+ "Volunteering Non-Profit Organisations\n"
				+ "South Asian Heart Association\n"
				+ "Samaj Saves Lives\n"
				+ "Dr. Kayal Sambandam\n"
				+ "Stanford Asian Liver Cancer Center\n"
				+ "US 2020 Census Recruiting Awareness\n"
				+ "National Bone Marrow Institute"
		};
		WebElement OverviewContent = driver.findElement(By
				.xpath("//div[@class=\"services_overviewLayout__4i7OA\"]"));

		String actualText = OverviewContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void navigatetoservicesPolicy() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, Humanservices);
			Humanservices.click();
			
			util.waitUntilElement(driver, Policy);
			Policy.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/humanservices";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateservicesPolicy() throws InterruptedException {

		String[] expectedtext = {
				"The Human Services Committee is an integral part of HCCC and is chartered with the responsibility of serving the communities locally and globally on a need basis. HCCC board is the governing body for all Human Services activities.\n"
				+ "Hindu Community & Cultural Center (HCCC) will strive to meet the Human Services needs of the worldwide community irrespective of religion, race, and cultural identity depending upon the available funds, on a priority and need basis.\n"
				+ "HCCC allocates limited amount of funds each year for supporting eligible organizations engaged strictly in Human Service functions. Recipient organizations will be required to disclose the affiliations with other organizations to enable HCCC to determine their eligibility to receive HCCC charity funds.\n"
				+ "Human Service projects are mainly aimed at basic human needs as food, shelter, medical and educational purposes. All of its funds will be spent in these areas only. Any deviation from this requires the approval from HCCC.\n"
				+ "HCCC approves Human Service projects anywhere on the globe without geographical limitations. Human Services Committee strives hard to create reliable ways and means so that the projects are well executed and funds are 100% utilized on the targeted project.\n"
				+ "Human Services Committee welcomes the association of individuals and groups who would like to identify, donate and execute projects for human cause within its spectrum of coverage."
		};
		WebElement PolicyContent = driver.findElement(By
				.xpath("//p[@class='MuiTypography-root MuiTypography-body1 services_content__UIkhU css-9l3uo3']"));

		String actualText = PolicyContent.getText();
		System.out.println(actualText);

		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void navigatetoservicesContactUs() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, Humanservices);
			Humanservices.click();
			
			util.waitUntilElement(driver, ContactUs);
			ContactUs.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/humanservices";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateservicesContactUs() throws InterruptedException {

		String[] expectedtext = {
				"Contact us\n"
				+ "Please feel free to contact any one of the following individuals regarding Human Services activities:\n"
				+ "Usha Ramaswamy (Board Liaison)\n"
				+ "408-421-5647\n"
				+ "uvrsolutions@gmail.com\n"
				+ "Shyamala Venkateswaran (EC chair Human Services)\n"
				+ "408-375-4684\n"
				+ "ec_human_services@livermoretemple.org\n"
				+ "Suman Jain (Member)\n"
				+ "925-371-5640\n"
				+ "suman1218@yahoo.com"
		};
		WebElement ContactUsContent = driver.findElement(By
				.xpath("//div[@class=\"services_cardContainer__9CM+u\"]"));

		String actualText = ContactUsContent.getText();
		System.out.println(actualText);
		
		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}

		util.waitUntilElement(driver, DownloadtheBrochurePdf);

		if (DownloadtheBrochurePdf.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",DownloadtheBrochurePdf);
			Thread.sleep(2000);

			String parentHandle = driver.getWindowHandle();

			DownloadtheBrochurePdf.click();
			Thread.sleep(2000);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(parentHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://hints20.livermoretemple.org//hints/content/html/2022/hccc-human-services1.pdf";
			Assert.assertEquals(actualUrl, expectedUrl,
					"URL mismatch after clicking on Temple Story link in the new window.");

			driver.close();
			driver.switchTo().window(parentHandle);
			
			 if (GrantInAidPdf.isDisplayed()) {
	                js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", GrantInAidPdf);
	                Thread.sleep(2000);
	                GrantInAidPdf.click();
	                Thread.sleep(2000);
	                for (String windowHandle : driver.getWindowHandles()) {
	                    if (!windowHandle.equals(parentHandle)) {
	                        driver.switchTo().window(windowHandle);
	                        break;
	                    }
	                }
	                String grantInAidUrl = driver.getCurrentUrl();
	                String expectedGrantInAidUrl = "https://www.independentnews.com/community/grant-in-aid-program-provides-funds-to-organizations/article_0adc3c3e-50db-11e9-b75f-4307439d4936.html"; 
	                Assert.assertEquals(grantInAidUrl, expectedGrantInAidUrl, "URL mismatch after clicking on Grant-In-Aid Program Article link in the new window.");
	                driver.close();
	                driver.switchTo().window(parentHandle);
	            } else {
	                Assert.fail("Grant-In-Aid Program Article link is not present on the page");
	            }			
			
		} else {
			Assert.fail("Download the Brochure is not present on the Contact Us page");
		}
	}
	
	public void navigatetoservicesactivity() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, YouthEducation);
			YouthEducation.click();
			
			util.waitUntilElement(driver, activity);
			activity.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/servicesyouthandeducation";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateservicesactivity() throws InterruptedException {
		
	    String[] expectedText = {
	        "Please click on the links below for registering students to attend free classes conducted by HCCC Youth & Education Committee or for volunteering or just to stay informed about Y&E activities.\n"
	        + "Click here to register students to HCCC Y&E Classes\n"
	        + "Click here to register for volunteering and for teaching classes\n"
	        + "Click here to receive notifications regarding HCCC Y&E classes and activities"
	    };
	    List<WebElement> elements = driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 services_details__KZG0m css-9l3uo3']"));
	    StringBuilder actualTextBuilder = new StringBuilder();
	    for (WebElement element : elements) {
	        actualTextBuilder.append(element.getText()).append("\n");
	    }
	    String actualText = actualTextBuilder.toString();
	    System.out.println(actualText);
	    
	    for (String expected : expectedText) {
	        Assert.assertTrue(actualText.contains(expected), "Expected text '" + expected + "' not found on the webpage.");
	    }
	    // Find all hyperlinks within the elements
	    List<WebElement> links = driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 services_details__KZG0m css-9l3uo3']//a"));
	    
	    int initialWindowCount = driver.getWindowHandles().size();

	    for (WebElement link : links) {
	        String href = link.getAttribute("href");
	        System.out.println("Hyperlink found: " + href);

	        String parentHandle = driver.getWindowHandle();

	        link.click();
	        Thread.sleep(2000); 

	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(parentHandle)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        String actualUrl = driver.getCurrentUrl();
	        System.out.println("New window URL: " + actualUrl);
	        Assert.assertTrue(actualUrl.endsWith("viewform"), "URL does not end with 'viewform' for hyperlink: " + href);

	        driver.close();
	        driver.switchTo().window(parentHandle);
	    }
	    Set<String> finalWindowHandles = driver.getWindowHandles();
	    Assert.assertEquals(finalWindowHandles.size(), initialWindowCount, "Unexpected number of windows opened.");
	    
	    WebElement imageContainer = driver.findElement(By.className("services_activityImage__XP1rv"));
	    Assert.assertTrue(imageContainer.isDisplayed(), "Image is not displayed");
	}
	
	public void navigatetoservicesYouthContactUs() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, YouthEducation);
			YouthEducation.click();
			
			util.waitUntilElement(driver, ContactUs);
			ContactUs.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/servicesyouthandeducation";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	public void validateservicesyouthContactUs() throws InterruptedException {

		String[] expectedtext = {
				"Contact Us\n"
				+ "EC Chair Youth & Education: Goutham Vedanti\n"
				+ "youthevents@livermoretemple.org\n"
				+ "925-449-625"
		};
		WebElement ContactUsContent = driver.findElement(By
				.xpath("//div[@class=\"services_ContactUsContainer__KlNJ3 MuiBox-root css-0\"]"));

		String actualText = ContactUsContent.getText();
		System.out.println(actualText);
		
		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	
	public void navigatetoservicesYoungAdultsOverview() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, YoungAdults);
			YoungAdults.click();
			
			util.waitUntilElement(driver, overview);
			overview.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/youngadults";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	
	public void validateservicesYoungAdultsOverview() throws InterruptedException {

		String[] expectedtext = {
				"Overview\n"
				+ "The Hindu Community and Cultural Center introduced Young Adults Committee aimed at meeting the needs of individuals aged 18-32 within our community. This initiative is designed to assist young adults in achieving their social and career objectives, while also providing exposure to Hindu religion and culture through periodic Q&A sessions and volunteer opportunities. The objective is to foster self-confidence, promote success in both careers and relationships, navigate cross-cultural dynamics within our communities, lead fulfilling lives, and contribute positively to the community.\n"
				+ "Mission Statement\n"
				+ "Build the next-generation platform of young adults shaped by the Hindu Community and Cultural Center's heritage and values while advancing interests in career counseling, professional networking, and mental and spiritual well-being.\n"
				+ "Young Adults Team\n"
				+ "Dimple Cyril - Executive Committee Chairperson\n"
				+ "ec_young_adults@livermoretemple.org"
		};
		WebElement ContactUsContent = driver.findElement(By
				.xpath("//div[@class=\"services_youngadultOverview__t2aGZ\"]"));

		String actualText = ContactUsContent.getText();
		System.out.println(actualText);
		
		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}
	public void navigatetoservicesYoungAdultsContactUs() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, YoungAdults);
			YoungAdults.click();
			
			Actions actions = new Actions(driver);
			actions.moveToElement(ServicesTab, 0, 0).build().perform();
			
			util.waitUntilElement(driver, ContactUs);
			ContactUs.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/youngadults";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	public void validateservicesYoungAdultsContactUs() throws InterruptedException {

		String[] expectedtext = {
				"Contactus\n"
				+ "For information, please contact\n"
				+ "ec_young_adults@livermoretemple.org"
		};
		WebElement ContactUsContent = driver.findElement(By
				.xpath("//div[@class=\"services_YoungadultsContactusLayout__lD3XI\"]"));

		String actualText = ContactUsContent.getText();
		System.out.println(actualText);
		
		for (String expected : expectedtext) {
			Assert.assertTrue(actualText.contains(expected),
					"Expected text '" + expected + "' not found on the webpage.");
		}
	}

	public void navigatetoservicesYoungAdultsAcivity() {
		{
			util.waitUntilElement(driver, ServicesTab);
			ServicesTab.click();
			
			util.waitUntilElement(driver, YoungAdults);
			YoungAdults.click();
			
			Actions actions = new Actions(driver);
			actions.moveToElement(ServicesTab, 0, 0).build().perform();
			
			util.waitUntilElement(driver, activity);
			activity.click();

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://40.90.194.2:8080/youngadults";
			Assert.assertEquals(currentUrl, expectedUrl, "User is not navigated to the desired URL.");
		}		
	}
	public void validateservicesYoungAdultsAcivity() throws InterruptedException {
		
		 List<WebElement> elements = driver.findElements(By.xpath("//div[@class='services_YoungadultactivitytotalLaout__mCogM MuiBox-root css-0']"));

		    // Initialize a counter for images
		    int imageCount = 0;

		    // Iterate through each element
		    for (WebElement element : elements) {
		        // Find the image within the current element
		        WebElement image = element.findElement(By.xpath("//img[@class='MuiBox-root css-dsh2wy']"));

		        // Check if the image is displayed
		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");

		        // Increment the image count
		        imageCount++;
		    }

		    // Print the total number of images
		    System.out.println("Total number of images: " + imageCount);
		}
	
	
	public void navigateToTempleHistoryPage() throws Exception {

		util.waitUntilElement(driver, TempleHistory);

		if (TempleHistory.isDisplayed()) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",TempleHistory);
			Thread.sleep(2000);

			String parentHandle = driver.getWindowHandle();

			TempleHistory.click();
			Thread.sleep(2000);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(parentHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			String expectedUrl = "https://hccccars.org/";
			Assert.assertEquals(actualUrl, expectedUrl,
					"URL mismatch after clicking on TempleHistory in the new window.");
			// Switch back to the original window
			//driver.switchTo().window(parentHandle);
		} else {
			Assert.fail("TempleHistory is not present on the  Home page");
		}
	}
	
	public void links() throws InterruptedException {
		
		util.waitUntilElement(driver, carspopup);
		carspopup.click();
		
		Thread.sleep(5000);
		
		   List<WebElement>rectangles = driver.findElements(By.xpath("//div[@class='fileName'] | //div[@class='more']"));
		    for (WebElement rectangle : rectangles) {
		        if (rectangle.isDisplayed()) {
		            // Use JavaScript to click on the element
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rectangle);
		            System.out.println(rectangle.getText());
		        }
		
//		 List<WebElement>rectangles = driver.findElements(By.xpath("//div[@class='fileName']"));
//		    for (WebElement rectangle : rectangles) {
//		        if (rectangle.isDisplayed()) {
//		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rectangle);
//		            System.out.println(rectangle.getText());
//		            
//		            WebElement moreElement = driver.findElement(By.xpath("//div[@class='more']"));
//				    if (moreElement.isDisplayed()) {		        
//				        moreElement.click();   
//				        Thread.sleep(9000);
//					    WebElement popup = driver.findElement(By.xpath("//div[@id='pr_id_2']"));
//				        Thread.sleep(9000);
//				        List<WebElement>rectangles1 = driver.findElements(By.xpath("//div[@class='fileName']"));
//					    for (WebElement rectangle1 : rectangles1) {
//					        if (rectangle1.isDisplayed()) {
//					            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rectangle1);
//					            System.out.println(rectangle1.getText());				        
//				    }
//		        }
//		    }		    
//}
//		    }
		    }
	}

//	public void ConsolidateAccounts() throws InterruptedException {
//		util.waitUntilElement(driver, DevoteeManagement);
//		DevoteeManagement.click();
//
//		util.waitUntilElement(driver, CONSOLIDATEACCOUNTS);
//		CONSOLIDATEACCOUNTS.click();
//
//		util.waitUntilElement(driver, Firstname);
//		Firstname.sendKeys("test");
//
//		util.waitUntilElement(driver, Search);
//		Search.click();
//
//		try {
//			if (Clear.isDisplayed()) {
//				Clear.click();
//			} else {
//				System.out.println("Clear not found.");
//				try {
//					util.waitUntilElement(driver, AATestF);
//					AATestF.click();
//
//					util.waitUntilElement(driver, newtestt);
//					newtestt.click();
//
//					util.waitUntilElement(driver, RightArrow);
//					RightArrow.click();
//
//					util.waitUntilElement(driver, Submit);
//					Submit.click();
//				} catch (Exception e) {
//					System.out.println("An unexpected error occurred during the remaining flow: " + e.getMessage());
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("An unexpected error occurred: " + e.getMessage());
//		}
//	}
//
//	public void validatedevotee() {
//
//		List<WebElement> elements = driver.findElements(By.xpath("//p[contains(text(), 'AATEST')]"));
//		String actualText1 = elements.get(1).getText();
//		String expectedText1 = "AATEST";
//		Assert.assertEquals(actualText1, expectedText1, "Text does not match");
//
//		List<WebElement> actual = driver.findElements(By.xpath("//p[contains(text(), 'ABCD2577')]"));
//		String actualText2 = actual.get(1).getText();
//		String expectedText2 = "ABCD2577";
//		Assert.assertEquals(actualText2, expectedText2, "Text does not match");
//	}



}


