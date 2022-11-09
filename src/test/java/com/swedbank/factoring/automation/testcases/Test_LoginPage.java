package com.swedbank.factoring.automation.testcases;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_LoginPage {
	WebDriver driver;

	@BeforeMethod
	public void goToUrl() throws InterruptedException {
		driver = WebDriverManager.chromedriver().create();
		Thread.sleep(2000);
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		System.out.println("Opening the website");
		
	}

	@Test (priority=0)
	public void usingSwedBanklogo() throws InterruptedException {
		System.out.println("Using SwedBank Logo");
		driver.findElement(By.className("logo")).click();
		List<WebElement> tabElements = driver.findElements(By.className("ui-tabs__captions"));

		// I want to iterate through each element and click on them
		for (WebElement eachItem : tabElements) {
			List<WebElement> eachTagName = eachItem.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {

				if (tagName.getText().equals("Smart-ID")) {
					tagName.click();
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Biometrics")) {
					tagName.click();
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					tagName.click();
					Thread.sleep(1000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					tagName.click();
					Thread.sleep(1000);

				} else if (tagName.getText().equals("ID-card")) {
					tagName.click();
					Thread.sleep(1000);

				}
			}
		}
		Thread.sleep(2000);
	
	}

	@Test (priority=1)
	public void usingApplyButton() throws InterruptedException {
		
		System.out.println("Using APPLY button");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		List<WebElement> tabElements = driver.findElements(By.className("ui-tabs__captions"));
		// I want to iterate through each element and click on them
		for (WebElement eachItem : tabElements) {
			List<WebElement> eachTagName = eachItem.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {

				if (tagName.getText().equals("Smart-ID")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("Biometrics")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("ID-card")) {
					tagName.click();
					Thread.sleep(2000);

				}
			}
		}
		Thread.sleep(2000);
		
		
	}
	@Test(priority=2)
	public void usingLoginButton() throws InterruptedException {
		System.out.println("Using the log In Button");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> tabElements = driver.findElements(By.className("ui-tabs__captions"));
		// I want to iterate through each element and click on them
		for (WebElement eachItem : tabElements) {
			List<WebElement> eachTagName = eachItem.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {

				if (tagName.getText().equals("Smart-ID")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("Biometrics")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					tagName.click();
					Thread.sleep(2000);

				} else if (tagName.getText().equals("ID-card")) {
					tagName.click();
					Thread.sleep(2000);

				}
			}
		}
		Thread.sleep(2000);
		
	}
	

	
	

}
