package org.hints.testcases;

import org.hints.pages.BaseClass;
import org.hints.pages.InformationPages;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InformationPagesTest extends BaseClass {

	InformationPages infoPage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		infoPage = PageFactory.initElements(driver, InformationPages.class);
	}

	@Test(priority = 0, description = "Data in Overview tab", enabled = false)
	public void OverviewPage() throws Exception {
		infoPage.validateOverviewTab();
	}

	@Test(priority = 1, description = "Data in Pooja Items tab", enabled = false)
	public void PoojaItemsPage() throws Exception {
		infoPage.validatePoojaItemsTab();
	}
	
	@Test(priority = 2, description = "Data in Newslettertab", enabled = false)
	public void NewsLetterPage() throws Exception {
		//infoPage.validateNewsLetter();
		//infoPage.extractTitleData();
		infoPage.compareTitlesData();
	}
	
	@Test(priority = 3, description = "Data in Managementtab", enabled = false)
	public void ManagementTabPage() throws Exception {
		//infoPage.validateBODManagementTeamFromDB();
		//infoPage.validateBODManagementTeamFromUI();
		infoPage.validateBODDataTable();
	}
	
	
	@Test(priority = 4, description = "Data in Managementtab", enabled = true)
	public void ManagementTabEcPage() throws Exception {
		//infoPage.validateEcManagementTeamFromDB();
		//infoPage.validateEcManagementTeamFromUI();
		infoPage.compareExecutiveMembersData();
	}
}
