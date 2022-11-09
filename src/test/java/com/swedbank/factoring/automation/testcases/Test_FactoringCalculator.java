package com.swedbank.factoring.automation.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_FactoringCalculator {
	private boolean cookieClicked = false;
	WebDriver driver = WebDriverManager.chromedriver().create();

	@Test
	public void sectionDefaultValidations() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		// Validating the default invoice amount
		String defaultInvoiceAmt = driver.findElement(By.xpath("//input[@name='calc_d5']")).getAttribute("value");
		if (defaultInvoiceAmt != null) {
			Assert.assertEquals(defaultInvoiceAmt, "10000");
		}
		// Validating the default Advance Rate
		Select defaultAdvanceRate = new Select(driver.findElement(By.xpath("//select[@id='D6']")));
		Assert.assertEquals(Integer.parseInt(defaultAdvanceRate.getFirstSelectedOption().getText()), 90);
		// Validating the default interest rate
		String defaultInterestRate = driver.findElement(By.xpath("//input[@name='calc_d7']")).getAttribute("value");
		if (defaultInterestRate != null) {
			Assert.assertEquals(defaultInterestRate, "3");
		}
		// Validating the default Payment term
		Select defaultPaymentTerm = new Select(driver.findElement(By.id("D8")));
		Assert.assertEquals(Integer.parseInt(defaultPaymentTerm.getFirstSelectedOption().getText()), 30);
		// validating the default commission fees
		String defaultCommissionFees = driver.findElement(By.xpath("//input[@name='calc_d9']")).getAttribute("value");
		if (defaultCommissionFees != null) {
			Assert.assertEquals(defaultCommissionFees, "0.3");
		}
		// Validation of the calculation button is enabled
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='calculate-factoring']")).isEnabled());
		// Validating the default calculation values
		String defaultInvoiceFinancingVal = driver.findElement(By.xpath("//span[@id='result_perc']")).getText();
		if (defaultInvoiceFinancingVal != null) {
			Assert.assertEquals(defaultInvoiceFinancingVal, "0");
		}
		// Validation the default expense
		String defaultExpenses = driver.findElement(By.xpath("//span[@id='result']")).getText();
		if (defaultExpenses != null) {
			Assert.assertEquals(defaultExpenses, "0.00");
		}
	}

	@Test
	public void invoiceAmountAplhaNumericValidation() throws InterruptedException, AWTException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement invoiceAmt = driver.findElement(By.xpath("//input[@name='calc_d5']"));
		invoiceAmt.clear();
		invoiceAmt.sendKeys("1111Ab321");
		invoiceAmt.sendKeys(Keys.TAB);
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "Please enter a valid number");

	}

	@Test
	public void invoiceAmountEmptyValidation() {

		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement invoiceAmt = driver.findElement(By.xpath("//input[@name='calc_d5']"));
		invoiceAmt.clear();
		invoiceAmt.sendKeys("");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@id='calculate-factoring']"))).click().perform();
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "This field is required");

	}

	@Test
	public void invoiceAmountZeroValidation() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement invoiceAmt = driver.findElement(By.xpath("//input[@name='calc_d5']"));
		invoiceAmt.clear();
		invoiceAmt.sendKeys("0");
		invoiceAmt.sendKeys(Keys.TAB);
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "Please enter a value greater than or equal to 1");

	}

	@Test
	public void advanceRateValidation() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		List<String> displayedOptions = new ArrayList<String>();
		Select advanceRateSelections = new Select(driver.findElement(By.xpath("//select[@id='D6']")));
		List<WebElement> options = advanceRateSelections.getOptions();
		for (WebElement opt : options) {
			opt.getText();
			displayedOptions.add(opt.getText());
		}
		String[] displayedOptionsExpected = { "75", "80", "85", "90" };
		Assert.assertEquals(displayedOptionsExpected, displayedOptions.toArray());
	}

	@Test
	public void interestRateAlphaNumericValidation() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement interestRate = driver.findElement(By.xpath("//input[@name='calc_d7']"));
		interestRate.clear();
		interestRate.sendKeys("3a.2");
		interestRate.sendKeys(Keys.TAB);
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "Please enter a valid number");
	}

	@Test
	public void interestRateEmptyValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement interestRate = driver.findElement(By.xpath("//input[@name='calc_d7']"));
		interestRate.clear();
		interestRate.sendKeys("");
		Thread.sleep(200);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@id='calculate-factoring']"))).click().perform();
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "This field is required");

	}

	@Test
	public void interestRateAboveLimitsValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement interestRate = driver.findElement(By.xpath("//input[@name='calc_d7']"));
		interestRate.clear();
		interestRate.sendKeys("32");
		Thread.sleep(200);
		interestRate.sendKeys(Keys.TAB);
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "Please enter a value less than or equal to 20");

	}

	@Test
	public void paymentTermValidation() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		List<String> displayedPaymentTermOptions = new ArrayList<String>();
		Select paymentTermSelections = new Select(driver.findElement(By.xpath("//select[@id='D8']")));
		List<WebElement> options = paymentTermSelections.getOptions();
		for (WebElement opt : options) {
			opt.getText();
			displayedPaymentTermOptions.add(opt.getText());
		}
		String[] displayedOptionsExpected = { "30", "60", "90", "120" };
		Assert.assertEquals(displayedPaymentTermOptions.toArray(), displayedOptionsExpected);
	}

	@Test
	public void commissionFeesAlphaNumericValidation() {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement commissionFees = driver.findElement(By.xpath("//input[@name='calc_d9']"));
		Actions commissionAction = new Actions(driver);
		commissionAction.moveToElement(commissionFees).click().perform();
		commissionFees.clear();
		commissionFees.sendKeys("21Aa");
		commissionFees.sendKeys(Keys.TAB);
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "Please enter a valid number");
	}

	@Test
	public void commissionFeesEmptyValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement commissionFees = driver.findElement(By.xpath("//input[@name='calc_d9']"));
		Actions commissionAction = new Actions(driver);
		commissionAction.moveToElement(commissionFees).click().perform();
		Thread.sleep(200);
		commissionFees.clear();
		commissionFees.sendKeys("");
		driver.findElement(By.xpath("//button[@id='calculate-factoring']")).click();
		String errorMsg = driver.findElement(By.xpath("//div[@class='error validation-message']")).getText();
		Assert.assertEquals(errorMsg, "This field is required");
	}

	@Test
	public void applyButtonValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement applyButtonElement = driver.findElement(By.xpath("//button[@class='button']"));
		Actions applyButton = new Actions(driver);
		applyButton.moveToElement(applyButtonElement).perform();
		Thread.sleep(1500);
		Assert.assertTrue(applyButtonElement.isEnabled());
	}

	@Test
	public void howToApplyTabValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
        //When you are having a permanent overlay use the below method. 
		WebElement howToApply = driver.findElement(By.xpath("//span[contains(text(),'How to apply?')]"));
		//Validating if How to apply is enabled.
		Assert.assertTrue(howToApply.isEnabled());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", howToApply);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(200);
		//Validating if Factoring term is seen in the tab info
		WebElement factoringInfoBox = driver.findElement(By.xpath("//ui-infobox[@label='Factoring']"));
		String displayedStringName_1 = factoringInfoBox.getText();
		Assert.assertTrue(displayedStringName_1.contains("Factoring"));

	}
	@Test
	public void docAndFeesTabGeneralConditionsValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement docAndFees = driver.findElement(By.xpath("//span[contains(text(),'Documents and fees')]"));
		Assert.assertTrue(docAndFees.isEnabled());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", docAndFees);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(200);
		//Clicking on the relevant downloads.
		//General Conditions
		driver.findElement(By.xpath("//a[text()='General conditions']")).click();
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.swedbank.lt/business/useful/legislation/legislation");
	}
	
	@Test
	public void docAndFeesInvoiceListValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement docAndFees = driver.findElement(By.xpath("//span[contains(text(),'Documents and fees')]"));
		Assert.assertTrue(docAndFees.isEnabled());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", docAndFees);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(200);
		driver.findElement(By.xpath("//a[text()='List of invoices']")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void docAndfeesClaimDocValidation() throws InterruptedException {
		driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
		if (!cookieClicked) {
			driver.findElement(By.cssSelector("button.button.ui-cookie-consent__accept-button")).click();
		}
		cookieClicked = true;
		WebElement docAndFees = driver.findElement(By.xpath("//span[contains(text(),'Documents and fees')]"));
		Assert.assertTrue(docAndFees.isEnabled());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", docAndFees);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(200);
		driver.findElement(By.xpath("//a[text()='Claim Assignment Document']")).click();
		Thread.sleep(2000);
		
	}

}
