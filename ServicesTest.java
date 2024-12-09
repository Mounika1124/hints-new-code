package org.hints.testcases;


import org.hints.pages.BaseClass;
import org.hints.pages.ServicesPages;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServicesTest extends BaseClass {
	
	ServicesPages servicePage;

	@BeforeMethod(alwaysRun = true)
	public void Initsetup() {
		servicePage = PageFactory.initElements(driver, ServicesPages.class);
	}

	@Test(priority = 0, description = "Image in Cultural tab", enabled = true)
	public void culturalPage() throws Exception {
		servicePage.validateCulturalPage();
	}
	
	@Test(priority = 1, description = "Donate button in Cultural tab", enabled = true)
	public void donateForEvent() throws Exception {
		servicePage.validateDonateForEvent();

}
	
}
