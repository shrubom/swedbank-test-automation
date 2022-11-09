package com.swedbank.factoring.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swedbank.factoring.automation.pages.BaseClass;
import com.swedbank.factoring.automation.pages.LandingPage;

public class Test_LandingPage extends BaseClass {

	@Test(priority = 0)
	public void landingPage() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the Factoring Text on the landing page");
		LandingPage landingPage = PageFactory.initElements(BaseClass.driver, LandingPage.class);
		extentLogger.info("Grabbing the factoring text");
		String textPresent = landingPage.getFactoringText();
		Assert.assertEquals(true, textPresent.contains(excel.getStringData("LandingPage", 0, 0)));
		extentLogger.pass("Successfully found the text");
	}

	@Test(priority = 1)
	public void becomeACustomer() throws InterruptedException {
		LandingPage landingPage = PageFactory.initElements(BaseClass.driver, LandingPage.class);
		landingPage.becomeCustomer();
		Assert.assertTrue(landingPage.bankCustomerbuttonEnabled());
		Assert.assertTrue(landingPage.addAccountButtonEnabled());

	}

	@Test(priority = 2)
	public void navigatingTabs() throws InterruptedException {
		LandingPage landingPage = PageFactory.initElements(BaseClass.driver, LandingPage.class);
		landingPage.homeClick();
		Assert.assertEquals(landingPage.loginText(), "Log in with");
		landingPage.otherTabClick();
		String displayedText = landingPage.search("Factoring");
		Assert.assertTrue(displayedText.contains("Factoring calculator"));

	}

	@Test(priority = 3)
	public void langOnLandingPage() throws InterruptedException {
		LandingPage landingPage = PageFactory.initElements(BaseClass.driver, LandingPage.class);
		landingPage.getPagesForLang("LT");
		landingPage.getPagesForLang("RU");

	}

}
