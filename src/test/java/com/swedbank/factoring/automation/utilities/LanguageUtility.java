package com.swedbank.factoring.automation.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.swedbank.factoring.automation.pages.BaseClass;

public class LanguageUtility extends BaseClass{
	public WebDriver driver;
	
	public void getBalancesForLang(String lang) throws InterruptedException {
		try {
			getBalances(lang);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			getBalances(lang);
		}

	}

	public void getBalances(String lang) throws InterruptedException {
		if (!lang.equals("EN")) {

	//		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
			WebElement languageBarClick = driver.findElement(By.cssSelector("ui-dropdown#language-bar"));
			languageBarClick.click();
			List<WebElement> languageOptions = driver.findElements(By.cssSelector(".ui-dropdown__options"));
			for (WebElement langEle : languageOptions) {
				List<WebElement> eachTagName = langEle.findElements(By.tagName("li"));
				for (WebElement tagName : eachTagName) {
					if (!tagName.getText().isBlank()) {
						if (tagName.getText().equals(lang)) {
							tagName.click();
							Thread.sleep(2000);
							JavascriptExecutor jse = (JavascriptExecutor)driver;
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
