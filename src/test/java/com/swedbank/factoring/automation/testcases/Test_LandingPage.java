package com.swedbank.factoring.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swedbank.factoring.automation.pages.BaseClass;
import com.swedbank.factoring.automation.pages.LandingPage;
import com.swedbank.factoring.automation.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_LandingPage extends BaseClass{
	private boolean cookieClicked = false;
//	WebDriver driver = WebDriverManager.chromedriver().create();

	@Test(priority = 0)
	public void landingPage() {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		String textPresent = landingPage.getFactoringText();
		Assert.assertEquals(true, textPresent.contains("Factoring calculator"));

	}

	@Test(priority = 1)
	public void becomeACustomer() throws InterruptedException {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.becomeCustomer();
		Assert.assertTrue(landingPage.bankCustomerbuttonEnabled());
		Assert.assertTrue(landingPage.addAccountButtonEnabled());

	}

	@Test(priority = 2)
	public void navigatingTabs() throws InterruptedException {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.homeClick();
		Assert.assertEquals(landingPage.loginText(), "Log in with");
		landingPage.otherTabClick();
		String displayedText = landingPage.search("Factoring");
		Assert.assertTrue(displayedText.contains("Factoring calculator"));

	}
	

//	@Test(priority=1)
//	public void langOnLandingPage() throws InterruptedException {
//		// Choosing different languages
//
//		getBalancesForLang("LT");
//		getBalancesForLang("RU");
//
//	}

}
