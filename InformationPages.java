package org.hints.pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hints.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;

public class InformationPages {
	WebDriver driver;
	Utility util = new Utility(driver, 30);

	String title;

	public InformationPages(WebDriver Idriver) {
		this.driver = Idriver;
	}

	@FindBy(xpath = "//div[text()=\"Information\"]")
	public WebElement InformationTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[1]")
	public WebElement OverviewTab;

	@FindBy(xpath = "//p[contains(@class, 'Information_typoGraphyHeading__kOnGc') and contains(text(), 'Overview')]")
	public WebElement OverviewHeading;

	@FindBy(xpath = "(//p[contains(@class, 'Information_headername__zlkrX')])[1]")
	public WebElement Overviewheader1;

	@FindBy(xpath = "//p[contains(@class, 'Information_content__fVFjb')]")
	public WebElement OverviewText1;

	@FindBy(xpath = "(//p[contains(@class, 'Information_headercontent__4cPDM')])[1]")
	public WebElement HistoricalHead;

	@FindBy(xpath = "//p[contains(@class, 'Information_infomationtypo__xpN1Z')]")
	public WebElement HistoricalText;

	@FindBy(xpath = "(//p[contains(@class, 'Information_headercontent__4cPDM')])[2]")
	public WebElement ServicesOffHead;

	@FindBy(xpath = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-9l3uo3']")
	public WebElement ServicesOffText;

	@FindBy(xpath = "(//div[@class='MuiGrid-root css-fb1r0s'])[1]")
	public WebElement DevoteeData;

	@FindBy(xpath = "(//div[@class='MuiGrid-root css-fb1r0s'])[2]")
	public WebElement VolData;

	@FindBy(xpath = "(//div[@class='MuiGrid-root css-mo1c2l'])[1]")
	public WebElement PriestData;

	@FindBy(xpath = "//p[text()='Our Priests and Pachakas Details']")
	public WebElement PriestsLink;

	@FindBy(xpath = "//p[text()='Priests']")
	public WebElement PriestsHeading;

	@FindBy(xpath = "//div[@class='Information_priestscontainer__mtvRH'][1]")
	public WebElement Priest1;

	@FindBy(xpath = "//div[@class='Information_priestscontainer__mtvRH'][2]")
	public WebElement Priest2;

	@FindBy(xpath = "//div[@class='Information_priestscontainer__mtvRH'][3]")
	public WebElement Priest3;

	@FindBy(xpath = "//div[@class='Information_priestscontainer__mtvRH'][4]")
	public WebElement Priest4;

	@FindBy(xpath = "//div[@class='Information_priestscontainer__mtvRH'][5]")
	public WebElement Priest5;

	@FindBy(xpath = "(//p[contains(@class, 'Information_typoGraphyHeading__kOnGc')]//child::span)[1]")
	public WebElement PriestBackChevron;

	@FindBy(xpath = "(//p[contains(@class, 'Information_typoGraphyHeading__kOnGc')]//child::span)[2]")
	public WebElement PriestPrintBtn;

	@FindBy(xpath = "(//div[@class='MuiGrid-root css-mo1c2l'])[2]")
	public WebElement SupStaffData;

	@FindBy(xpath = "(//p[contains(@class, 'Information_headercontent__4cPDM')])[7]")
	public WebElement MgmtHead;

	@FindBy(xpath = "(//div[@class='MuiGrid-root css-rfnosa'])[4]")
	public WebElement MgmtText;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[2]")
	public WebElement PoojaItemsTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[3]")
	public WebElement ServicesSubTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[4]")
	public WebElement NewsletterTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[5]")
	public WebElement AwardsTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[6]")
	public WebElement EventFacilitiesTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[7]")
	public WebElement ManagementTab;

	@FindBy(xpath = "//div[@class='menuBar_subTabs__v6TNx']//child::div[8]")
	public WebElement RefundPolicyTab;

	@FindBy(xpath = "//table[@class=\"Information_tableContainer__qFsWT\"]")
	public WebElement NewsLetterTableDisplay;

	@FindBy(xpath = "//table[@class=\"Information_tableContainer__qFsWT\"]/thead/tr/th[1]")
	public WebElement titleColumn;

	@FindBy(xpath = "//tr[@class='Information_tableRow__5lvL-']/td[1]")
	public List<WebElement> titleColumnUi;

	@FindBy(xpath = "//tr[@class='Information_tableRow__5lvL-']/td[2]")
	public List<WebElement> dateAndTimeColumnUi;

	@FindBy(xpath = "//*[@data-testid=\"NavigateNextIcon\"]")
	public WebElement pagination;

	@FindBy(xpath = "(//table[@class=\"Information_tableContainers__F1yrw\"])[1]")
	public WebElement boardOfDirectorsTable;

	@FindBy(xpath = "(//tr[@class='Information_tableRow__5lvL-'])[position() < 10]")
	public List<WebElement> boardOfDirectorsTableData;
	
	
	@FindBy(xpath = "(//tr[@class='Information_tableRow__5lvL-'])[position() > 9]")
	public List<WebElement> executiveCommitteeMembersTableData;

	public void validateOverviewTab() throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(InformationTab).perform();
		if (OverviewTab.isDisplayed()) {
			Assert.assertEquals(OverviewTab.getText(), "Overview");
			OverviewTab.click();
			util.waitUntilElement(driver, OverviewHeading);
			OverviewHeading.isDisplayed();
			// Assert.assertEquals(Overviewheader1.getText(), "Sthala Puraana (Temple Story)
			// of Shiva-Vishnu Temple");
			Assert.assertEquals(OverviewText1.getText(),
					"HCCC was established in 1977 with the goal of offering religious services to Hindu community. "
							+ "In the last 35 years the HCCC has evolved into an established institution as a place of worship with the needed services for the community.");

			Assert.assertEquals(HistoricalHead.getText(), "HCCC Historical Information");
			Assert.assertEquals(HistoricalText.getText(), "1977: HCCC was incorporated\n"
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
					+ "Alaya Shikar Kalasha and Prabhavalis");

			Assert.assertEquals(ServicesOffHead.getText(), "Services Offered by HCCC");
			Assert.assertEquals(ServicesOffText.getText(),
					"Religious Services at temple and devotee residences\n" + "Renting of Facilities\n"
							+ "Human Services\n" + "Youth and Education\n" + "Cultural Events\n"
							+ "Spiritual Services\n"
							+ "Additional details on the above services are furnished in the subsequent sections.");

			Assert.assertEquals(DevoteeData.getText(), "Devotees\n"
					+ "The participation and support of the devotees keep the HCCC momentum going. The HCCC is sustained by the generosity of devotees.\n"
					+ "Devotee feedback on the services and the operational aspects will be well appreciated and helpful in serving the devotee and the community needs.");

			Assert.assertEquals(VolData.getText(), "Volunteers\n"
					+ "It would not have been possible to build this institution without the dedicated support of many volunteers.\n"
					+ "Volunteers play various roles and help in many operational aspects to serve the devotee and the community needs supported by the management and the support staff:\n"
					+ "Coordinating events\n" + "Assisting in event activities\n"
					+ "Parking control during major events\n" + "Fund raising support\n"
					+ "Garland making for the deities\n" + "In the front office\n" + "In the kitchen\n"
					+ "Maintenance & construction support\n"
					+ "Each year HCCC management awards Steering Committee membership to the dedicated volunteers as per the HCCC policy.");

			Assert.assertEquals(PriestData.getText(), "Priests and Pachakas\n"
					+ "Our priests are well versed with the pujas, chanting, Hindu traditions and sampradayas. They speak multiple languages.\n"
					+ "Pachakas support the priests with the neivedyam preparation. They also make the laddu and vada prasadam, and annadana food served on the weekends.\n"
					+ "The HCCC has 12 priests and two pachakas, are supported by the management, the supporting staff and the volunteers.\n"
					+ "Our Priests and Pachakas Details");

			Assert.assertEquals(SupStaffData.getText(), "Support Staff\n"
					+ "Includes a Manager, Assistant Manager, front desk staff, maintenance staff and a part-time librarian.\n"
					+ "Plays a key role in the day to day operations of HCCC supported by the management.");

			Assert.assertEquals(MgmtHead.getText(), "Management");
			Assert.assertEquals(MgmtText.getText(), "Steering Committee:\n"
					+ "The supreme body of HCCC. Meets once a quarter.\n"
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
					+ "Reviews and approves the operational resolutions.");

			PriestsLink.click();
			util.waitUntilElement(driver, PriestsHeading);

			Assert.assertEquals(Priest1.getText(), "PDT. SRID\n" + "Lakshmi Shrine & Anjaneya Shrine\n"
					+ "Pdt. Sridharan born in Bhattacharyar family and hails from Kattumannar Koil,Tamil Nadu. "
					+ "He studied Nalayara Divya Prabhandam, Krishna yajurvedam and Pancha Rathra Agamam at Sri Rangam Kusi Patasala. He graduated in Panch Ratra Ratnakara. "
					+ "He servered at TTD as Ekangi for 16 years. He joined Temple in 1998. He is fluent in Tamil, Telugu, and English.");

			Assert.assertEquals(Priest2.getText(), "PT.S BHAT\n"
					+ "Pdt. S. Sridhara Bhattar is a Pancharathra Agama Priest. He is a Pancharathra Agama Praveena, and a Vishistadwaitha Vidwath and he holds B.Com and M.A (Sanskrit) degrees. "
					+ " He has been an Archaka at Lakshmi Venkataramana Swamy Temple, Ontikoppal, Mysore, Karnataka for 20 years. He also served as Sanskrit Lecturer at Mathru Mandali Junior College,Mysore for 8 years and recently as Sanskrit Professor, Maharaja Sanskrit College, Mysore. \n"
					+ "He has written 3 books - Shabda Manjari, Sanskrit Vyakarana Parichaya, and Pancharathra Kalpadruma. He speaks Kannada, Sanskrit, Tamil, Telugu and English.");

			Assert.assertEquals(Priest3.getText(), "PT. Divi Pawan Kumar\n"
					+ "Pdt. Divi Pawan Kumar is a Vaikanasa Priest. He has graduated from T.T.D. Sri Venkateswara Veda Pathasala, "
					+ "Tirumala with first class (Pradhama Sreni) in the Pratishanta Vaikanasa Agama examination after 8 years of study. "
					+ "He has also passed the Archaka Pravesa and Vara examinations conducted by the Government of Andhra Pradesh with first class. "
					+ "He has been involved in the Pratishtas, Brahmotsavams, Pavithrotsavams for the last 3 years, and is also associated as priest with "
					+ "Sri. Chitti Anjaneya Swamy Mandir, Tenali. He has also passed Sanskrit Vichakshana examination with distinction.\n"
					+ "Language: Telugu, Tamil, English, Hindi and Sanskrit");

			Assert.assertEquals(Priest4.getText(), "PT. Sridhara S Bhattar\n"
					+ "Pdt. S. Sridhara Bhattar is a Pancharathra Agama Priest. He is a Pancharathra Agama Praveena, and a Vishistadwaitha Vidwath and holds "
					+ "B.Com and M.A (Sanskrit) degrees. He has been an Archaka at Lakshmi Venkataramana Swamy Temple, Ontikoppal, Mysore, Karnataka for 20 years. "
					+ "He also served as Sanskrit Lecturer at Mathru Mandali Junior College, Mysore for 8 years and recently as Sanskrit Professor, Maharaja Sanskrit College, Mysore. "
					+ "He has written 3 books - Shabda Manjari, Sanskrit Vyakarana Parichaya, and Pancharathra Kalpadruma.\n"
					+ "Language: Kannada, Sanskrit, Tamil, Telugu and English");

			Assert.assertEquals(Priest5.getText(), "PT. Raghunathan Natarajan\n"
					+ "Pdt. Raghunath Natarajan is a Krishna Yajurveda Priest. He studied for 12 years and completed his Veda Adhyayanam Kramantham in Kumbhakonam. "
					+ "He is well trained in all rituals of Vaideekam (Poorva and Apara). He was a Head Priest for 23 years in Mumbai Sri Ram Temple (1984-2006) "
					+ "and was also teaching Veda.\n" + "Language: English, Tamil, Telugu, Malayalam and Hindi");

			PriestPrintBtn.isEnabled();

			PriestBackChevron.click();
			OverviewHeading.isDisplayed();

		}

	}

	public void validatePoojaItemsTab() {
		// TODO Auto-generated method stub
		String tableId = "your_table_id";

		// Define the expected table data
		String[][] expectedData = { { "Header1", "Header2", "Header3" }, { "Row1Data1", "Row1Data2", "Row1Data3" },
				{ "Row2Data1", "Row2Data2", "Row2Data3" }
				// Add more rows as needed
		};

		// Validate the table data
		validateTableData(driver, tableId, expectedData);

		// Close the browser
		driver.quit();

	}

	public List<String> validateNewsLetter() throws InterruptedException {
		List<String> titles = new ArrayList<>();
		util.doMoveToElement(driver, InformationTab);
		InformationTab.click();
		Thread.sleep(2000);
		NewsletterTab.click();
		Thread.sleep(4000);
		NewsLetterTableDisplay.isDisplayed();
		try (Connection connection = Utility.getDatabaseConnection()) {
			if (connection != null) {
				System.out.println("Connected to the database");
				String query = "SELECT title, description, uploadedon  FROM tabPV where deleted=false ORDER BY uploadedon DESC";
				ResultSet resultSet = Utility.executeQuery(connection, query);
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				System.out.println(columnCount);

				while (resultSet.next()) {
					String title = resultSet.getString("title");

					// Format the title before adding it to the list
					title = formatTitleForComparisonofDB(title);

					// Add formatted title to the list
					titles.add(title);
				}

				// Print all titles
				System.out.println("Title");
				for (String title : titles) {
					System.out.println(title);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titles;
	}

	// Formatting method for title comparison
	private String formatTitleForComparisonofDB(String title) {
		// Remove extra spaces from within the string
		title = title.trim().replaceAll("\\s+", " ");
		// Convert to lowercase
		title = title.toLowerCase();
		return title;

	}

	public List<String> extractTitleData() throws InterruptedException {
		List<String> titles = new ArrayList<>();
		util.doMoveToElement(driver, InformationTab);
		InformationTab.click();
		Thread.sleep(2000);
		NewsletterTab.click();
		Thread.sleep(4000);
		if (NewsLetterTableDisplay.isDisplayed()) {
			System.out.println("Table is displayed");

			// Loop through each page
			int currentPage = 1;
			while (true) {
				List<WebElement> table = titleColumnUi;
				// System.out.println("Page " + currentPage + ": " + table.size() + " rows");

				// Extracting title data from each row
				for (WebElement row : table) {
					String title = row.getText(); // Extracting text from the row

					// Format the title before adding it to the list
					title = formatTitleForComparisonOfUI(title);

					System.out.println(title);
					titles.add(title); // Add title to the list
				}

				// Check if there is a next page button
				WebElement nextPageButton = pagination; // Implement this method to locate the next page button
				if (nextPageButton != null && currentPage != 3) {
					nextPageButton.click();
					Thread.sleep(2000); // Add a short delay to ensure the next page is loaded
					currentPage++;
				} else {
					System.out.println("No more pages available. Exiting loop.");
					break; // Exit the loop if there are no more pages or if it's the 3rd page
				}
			}
		} else {
			System.out.println("Table is not displayed");
		}

		return titles; // Return the list of titles
	}

	private String formatTitleForComparisonOfUI(String title) {
		// Remove extra spaces from within the string
		title = title.trim().replaceAll("\\s+", " ");
		// Convert to lowercase
		title = title.toLowerCase();
		return title;
	}

	public void compareTitlesData() throws InterruptedException {
		List<String> dbTitles = validateNewsLetter(); // Retrieve data from the database
		List<String> uiTitles = extractTitleData(); // Extract data from the UI table

		// Check if data retrieval was successful
		if (dbTitles == null || uiTitles == null) {
			System.out.println("Data retrieval failed. Cannot perform comparison.");
			return;
		}

		// Check if both lists are empty
		if (dbTitles.isEmpty() && uiTitles.isEmpty()) {
			System.out.println("Both data sources are empty. Nothing to compare.");
			return;
		}

		// Compare the data obtained from both sources
		if (dbTitles.equals(uiTitles)) {
			System.out.println("Data from database and UI table match!");
		} else {
			System.out.println("Data from database and UI table do not match!");
		}
	}

	private static void validateTableData(WebDriver driver, String tableId, String[][] expectedData) {
		WebElement table = driver.findElement(By.id(tableId));

		// Get all rows from the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Loop through rows and columns to validate data
		for (int i = 0; i < expectedData.length; i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < expectedData[i].length; j++) {
				String actualData = cols.get(j).getText().trim();
				String expected = expectedData[i][j].trim();

				// Compare the actual and expected data
				if (!actualData.equals(expected)) {
					System.out.println("Table data is not valid.");
					System.out.println("Expected Data: " + expected);
					System.out.println("Actual Data: " + actualData);
					return;
				}
			}
		}
		// If all data matches, print success message
		System.out.println("Table data is valid.");
	}

	public List<String> validateBODManagementTeamFromDB() throws InterruptedException {
		List<String> names = new ArrayList<>();
		try (Connection connection = Utility.getDatabaseConnection()) {
			if (connection != null) {
				System.out.println("Connected to the database");
				String query = "SELECT fullname, committee FROM dbo.tabpastmanagement pme WHERE pme.yearFrom = '2024-2025' AND pme.category = 'BOD' ORDER BY pme.fullName ASC";
				ResultSet resultSet = Utility.executeQuery(connection, query);
				while (resultSet.next()) {
					String fullname = resultSet.getString("fullname").trim();
					String committee = resultSet.getString("committee").trim();
					String formattedName = String.format("%-20s", fullname); // Decreased space to 20 characters
					String formattedCommittee = committee.isEmpty() ? "-" : committee; // If committee is empty, replace
																						// with "-"
					String output = String.format("%-20s%s", formattedName, formattedCommittee).trim(); // Trim spaces
					names.add(output);
					System.out.println(output); // Print each name and committee pair
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}

	public List<String> validateBODManagementTeamFromUI() throws InterruptedException {
		List<String> names = new ArrayList<>();
		try {
			util.doMoveToElement(driver, InformationTab);
			util.waitUntilElement(driver, InformationTab);
			InformationTab.click();
			Thread.sleep(2000);
			ManagementTab.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(ManagementTab, 50, 50).build().perform();
			Thread.sleep(4000);
			boardOfDirectorsTable.isDisplayed();

			// Find the maximum length of the full names and committees
			int maxNameLength = 0;
			int maxCommitteeLength = 0;

			List<WebElement> rows = boardOfDirectorsTableData;
			for (WebElement row : rows) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				String name = columns.get(0).getText().trim();
				String committee = columns.get(1).getText().trim();
				maxNameLength = Math.max(maxNameLength, name.length());
				maxCommitteeLength = Math.max(maxCommitteeLength, committee.length());
			}

			// Loop through each row in the table and format the names and committees
			for (WebElement row : rows) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				String name = columns.get(0).getText().trim();
				String committee = columns.get(1).getText().trim();
				String formattedName = String.format("%-" + maxNameLength + "s", name);
				String formattedCommittee = String.format("%-" + maxCommitteeLength + "s", committee);
				names.add(formattedName + " " + formattedCommittee);
				System.out.println(formattedName + " " + formattedCommittee);
			}
		} catch (Exception e) {
			e.printStackTrace(); // Print any exceptions that occur
		}
		return names;
	}

	public void validateBODDataTable() throws InterruptedException {
	    // Retrieve data from the database
	    List<String> dbBOD = validateBODManagementTeamFromDB();
	    // Extract data from the UI table
	    List<String> uiBOD = validateBODManagementTeamFromUI();

	    // Check if data retrieval was successful
	    if (dbBOD == null || uiBOD == null) {
	        System.out.println("Data retrieval failed. Cannot perform comparison.");
	        return;
	    }

	    // Check if both lists are empty
	    if (dbBOD.isEmpty() && uiBOD.isEmpty()) {
	        System.out.println("Both data sources are empty. Nothing to compare.");
	        return;
	    }

	    // Standardize the formatting by removing extra spaces between name and description
	    dbBOD = removeExtraSpaces(dbBOD);
	    uiBOD = removeExtraSpaces(uiBOD);

	    // Sort both lists before comparison
	    Collections.sort(dbBOD);
	    Collections.sort(uiBOD);

	    // Compare the data obtained from both sources
	    if (dbBOD.equals(uiBOD)) {
	        System.out.println("Data from database and UI table match!");
	    } else {
	        util.compareData(dbBOD, uiBOD);
	    }
	}

	// Helper method to remove extra spaces between name and description
	private List<String> removeExtraSpaces(List<String> data) {
	    List<String> formattedData = new ArrayList<>();
	    for (String entry : data) {
	        // Split the entry into name and description
	        String[] parts = entry.split("\\s{2,}");
	        // Join the parts with a single space
	        String formattedEntry = String.join(" ", parts);
	        formattedData.add(formattedEntry.trim());
	    }
	    return formattedData;
	}
	
	
	public List<String> validateEcManagementTeamFromDB() throws InterruptedException {
	    List<String> names = new ArrayList<>();
	    try (Connection connection = Utility.getDatabaseConnection()) {
	        if (connection != null) {
	            System.out.println("Connected to the database");
	            String query = "SELECT fullname, committee FROM dbo.tabpastmanagement pme WHERE pme.yearFrom = '2024-2025' AND pme.category = 'EC' ORDER BY pme.fullName ASC";
	            ResultSet resultSet = Utility.executeQuery(connection, query);
	            while (resultSet.next()) {
	                String fullname = resultSet.getString("fullname").trim();
	                String committee = resultSet.getString("committee").trim();
	                String formattedCommittee = committee.isEmpty() ? "-" : committee; // If committee is empty, replace with "-"
	                String output = String.format("%s %s", fullname, formattedCommittee); // Format with a single space
	                names.add(output);
	                System.out.println(output); // Print each name and committee pair
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return names;
	}

	public List<String> validateEcManagementTeamFromUI() throws InterruptedException {
	    List<String> names = new ArrayList<>();
	    try {
	        util.doMoveToElement(driver, InformationTab);
	        util.waitUntilElement(driver, InformationTab);
	        InformationTab.click();
	        Thread.sleep(2000);
	        ManagementTab.click();
	        Actions actions = new Actions(driver);
	        actions.moveToElement(ManagementTab, 50, 50).build().perform();
	        Thread.sleep(4000);
	        boardOfDirectorsTable.isDisplayed();

	        List<WebElement> rows = executiveCommitteeMembersTableData;
	        for (WebElement row : rows) {
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            String name = columns.get(0).getText().trim();
	            String committee = columns.get(1).getText().trim();
	            String formattedCommittee = committee.isEmpty() ? "-" : committee; // If committee is empty, replace with "-"
	            String output = String.format("%s %s", name, formattedCommittee); // Format with a single space
	            names.add(output);
	            System.out.println(output); // Print each name and committee pair
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Print any exceptions that occur
	    }
	    return names;
	}

	public void compareExecutiveMembersData() throws InterruptedException {
	    // Retrieve data from the database
	    List<String> dbMembers = validateEcManagementTeamFromDB();
	    System.out.println("Database members: " + dbMembers);

	    // Extract data from the UI table
	    List<String> uiMembers = validateEcManagementTeamFromUI();
	    System.out.println("UI members: " + uiMembers);

	    // Check if data retrieval was successful
	    if (dbMembers == null || uiMembers == null) {
	        System.out.println("Data retrieval failed. Cannot perform comparison.");
	        if (dbMembers == null) {
	            System.out.println("Database members list is null.");
	        }
	        if (uiMembers == null) {
	            System.out.println("UI members list is null.");
	        }
	        return;
	    }

	    // Check if both lists are empty
	    if (dbMembers.isEmpty() && uiMembers.isEmpty()) {
	        System.out.println("Both data sources are empty. Nothing to compare.");
	        return;
	    }

	    // Print sizes before formatting
	    System.out.println("Size of database members list before formatting: " + dbMembers.size());
	    System.out.println("Size of UI members list before formatting: " + uiMembers.size());

	    // Standardize the formatting by ensuring there's a single space between name and committee
	    dbMembers = standardizeSpacing(dbMembers, "DB");
	    uiMembers = standardizeSpacing(uiMembers, "UI");

	    // Print formatted lists
	    System.out.println("Formatted Database members: " + dbMembers);
	    System.out.println("Formatted UI members: " + uiMembers);

	    // Sort both lists before comparison
	    Collections.sort(dbMembers);
	    Collections.sort(uiMembers);

	    // Print sorted lists
	    System.out.println("Sorted Database members: " + dbMembers);
	    System.out.println("Sorted UI members: " + uiMembers);

	    // Compare the data obtained from both sources
	    if (dbMembers.equals(uiMembers)) {
	        System.out.println("Data from database and UI table match!");
	    } else {
	        System.out.println("Data mismatch detected!");
	        printDifferences(dbMembers, uiMembers);
	    }
	}

	// Helper method to ensure a single space between name and committee
	private List<String> standardizeSpacing(List<String> data, String source) {
	    List<String> formattedData = new ArrayList<>();
	    for (String entry : data) {
	        // Specifically handle missing space between name and committee name
	        String formattedEntry = entry.replaceAll("([a-zA-Z])([A-Z])", "$1 $2");
	        formattedData.add(formattedEntry.trim());
	        System.out.println(source + " Original: [" + entry + "] (length: " + entry.length() + ") -> Formatted: [" + formattedEntry + "] (length: " + formattedEntry.length() + ")");
	    }
	    return formattedData;
	}

	// Helper method to print differences between two lists
	private void printDifferences(List<String> dbMembers, List<String> uiMembers) {
	    System.out.println("Differences between Database and UI members:");
	    int maxSize = Math.max(dbMembers.size(), uiMembers.size());
	    for (int i = 0; i < maxSize; i++) {
	        String dbMember = i < dbMembers.size() ? dbMembers.get(i) : "N/A";
	        String uiMember = i < uiMembers.size() ? uiMembers.get(i) : "N/A";
	        if (!dbMember.equals(uiMember)) {
	            System.out.println("Database: [" + dbMember + "] (length: " + dbMember.length() + ") | UI: [" + uiMember + "] (length: " + uiMember.length() + ")");
	            compareCharacters(dbMember, uiMember);
	        }
	    }
	}

	// Helper method to compare two strings character by character
	private void compareCharacters(String dbMember, String uiMember) {
	    int maxLength = Math.max(dbMember.length(), uiMember.length());
	    for (int i = 0; i < maxLength; i++) {
	        char dbChar = i < dbMember.length() ? dbMember.charAt(i) : ' ';
	        char uiChar = i < uiMember.length() ? uiMember.charAt(i) : ' ';
	        if (dbChar != uiChar) {
	            System.out.println("Mismatch at index " + i + ": Database char [" + dbChar + "] | UI char [" + uiChar + "]");
	        }
	    }
	}


}
