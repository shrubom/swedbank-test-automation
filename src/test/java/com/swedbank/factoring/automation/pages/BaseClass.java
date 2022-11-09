package com.swedbank.factoring.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.swedbank.factoring.automation.utilities.BrowserUtility;

public class BaseClass {
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = BrowserUtility.startApplication(driver, "Chrome", "https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.landingPageCookieClick();
	}

}
