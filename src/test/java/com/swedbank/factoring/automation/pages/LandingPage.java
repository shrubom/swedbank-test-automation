package com.swedbank.factoring.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	WebDriver driver;
	private boolean cookieClicked = false;

	public LandingPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(css = "button.button.ui-cookie-consent__accept-button")
	WebElement cookie;
	@FindBy(css = "div.calculator-container")
	WebElement factoringText;
	@FindBy(css = ".new-customer-link")
	WebElement becomeCustomer;
	@FindBy(css = "a.button.-left")
	WebElement bankCustomer;
	@FindBy(xpath = "//a[text()='Open an additional account']")
	WebElement additionalAccount;
	@FindBy(css = "a.ui-navitem__primary-link.-icon")
	WebElement home;
	@FindBy(xpath = "//ui-navitem[@label='Everyday banking']")
	WebElement everydayBanking;
	@FindBy(xpath = "//ui-navitem[@label='Cards']")
	WebElement cards;
	@FindBy(xpath = "//ui-navitem[@label='Payment collection']")
	WebElement paymentCollection;
	@FindBy(xpath = "//ui-navitem[@label='Financing, Insurance']")
	WebElement financeInsurance;
	@FindBy(xpath = "//ui-navitem[@label='Savings, Investments']")
	WebElement savingInvest;
	@FindBy(xpath = "//ui-navitem[@label='Traderoom']")
	WebElement trade;
	@FindBy(xpath = "//ui-navitem[@label='Group account']")
	WebElement groupAcc;
	@FindBy(xpath = "//ui-navitem[@label='For your business']")
	WebElement yourBusiness;
	@FindBy(id = "nav-search-button")
	WebElement search;
	@FindBy(css = "#login-widget-heading")
	WebElement loginHeading;
	@FindBy(id = "nav-search-query")
	WebElement searchQuery;
	@FindBy(id = "nav-search-submit")
	WebElement searchSubmit;
	@FindBy(xpath = "//div[@id='searchResults'] //a[@class='found_page_title']")
	WebElement firstSearch;
	@FindBy(css = "ui-dropdown#language-bar")
	WebElement languageBar;
	@FindBy(css = ".ui-dropdown__options")
	List<WebElement> langOptions;


	// Method to click on accept for cookies
	public void landingPageCookieClick() {
		if (!cookieClicked) {
			cookie.click();
		}
		cookieClicked = true;
	}

	// Method to capture the text of factoring calculator
	public String getFactoringText() throws InterruptedException {
		Thread.sleep(900);
		String factoring = factoringText.getText();
		return factoring;
	}

	// Method to click on become a customer
	public void becomeCustomer() throws InterruptedException {
		Thread.sleep(900);
		becomeCustomer.click();
		Thread.sleep(1000);
	}

	// Method to find button is enabled
	public Boolean bankCustomerbuttonEnabled() throws InterruptedException {
		Thread.sleep(2000);
		Boolean status = bankCustomer.isEnabled();
		return status;
	}

	// Method to find additionalAccountButton is enabled
	public Boolean addAccountButtonEnabled() throws InterruptedException {
		Thread.sleep(3000);
		Boolean status = additionalAccount.isEnabled();
		return status;
	}

	// Method for clicking on homebutton
	public void homeClick() {
		home.click();
	}

	// Validating login text
	public String loginText() throws InterruptedException {
		String logText = loginHeading.getText();
		Thread.sleep(200);
		return logText;
	}

	// Method for clicking on other tabs
	public void otherTabClick() throws InterruptedException {
		Thread.sleep(3000);
		everydayBanking.click();
		Thread.sleep(300);
		cards.click();
		Thread.sleep(300);
		paymentCollection.click();
		Thread.sleep(300);
		financeInsurance.click();
		Thread.sleep(300);
		savingInvest.click();
		Thread.sleep(300);
		trade.click();
		Thread.sleep(300);
		groupAcc.click();
		Thread.sleep(300);
		yourBusiness.click();
		Thread.sleep(300);

	}

	// method to type on search bar and return text
	public String search(String queryText) throws InterruptedException {
		search.click();
		Thread.sleep(300);
		searchQuery.sendKeys("Factoring");
		Thread.sleep(300);
		searchSubmit.click();
		Thread.sleep(15000);
		if (firstSearch.getText().contains("Factoring")) {
			firstSearch.click();
			Thread.sleep(10000);
		}
		return (getFactoringText());
	}

	// Method to get the pages for different languages
	public void getPagesForLang(String lang) throws InterruptedException {
		try {
			languageSelection(lang);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			languageSelection(lang);
		}
	}

	// Method to choose different languages
	public void languageSelection(String lang) throws InterruptedException {
		if (!lang.equals("EN")) {
			languageBar.click();
			for (WebElement languageOptions : langOptions) {
				List<WebElement> eachTagName = languageOptions.findElements(By.tagName("li"));
				for (WebElement tagName : eachTagName) {
					if (!tagName.getText().isEmpty()) {
						if (tagName.getText().equals(lang)) {
							tagName.click();
							Thread.sleep(2000);
							JavascriptExecutor jse = (JavascriptExecutor) driver;
							jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
							Thread.sleep(1000);
							break;
						}
					}
				}

			}
		}

	}

}
