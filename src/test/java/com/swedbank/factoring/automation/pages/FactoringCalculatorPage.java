package com.swedbank.factoring.automation.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FactoringCalculatorPage {

	WebDriver driver;
	Boolean status = false;

	public FactoringCalculatorPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@name='calc_d5']")
	WebElement invoiceAmount;
	@FindBy(xpath = "//select[@id='D6']")
	WebElement advanceRate;
	@FindBy(xpath = "//input[@name='calc_d7']")
	WebElement interestRate;
	@FindBy(xpath = "//select[@id='D8']")
	WebElement paymentTerm;
	@FindBy(xpath = "//input[@name='calc_d9']")
	WebElement commissionFees;
	@FindBy(xpath = "//button[@id='calculate-factoring']")
	WebElement calculateBtn;
	@FindBy(xpath = "//span[@id='result_perc']")
	WebElement invoiceFinanceVal;
	@FindBy(xpath = "//span[@id='result']")
	WebElement expenses;
	@FindBy(xpath = "//div[@class='error validation-message']")
	WebElement errorMessage;
	@FindBy(xpath = "//button[@class='button']")
	WebElement applyButton;
	@FindBy(xpath = "//span[contains(text(),'How to apply?')]")
	WebElement howToApply;
	@FindBy(xpath = "//ui-infobox[@label='Factoring']")
	WebElement factoringInfoBox;
	@FindBy(xpath = "//span[contains(text(),'Documents and fees')]")
	WebElement docAndFees;
	@FindBy(xpath = "//a[text()='General conditions']")
	WebElement generalCond;
	@FindBy(xpath = "//a[text()='List of invoices']")
	WebElement invoiceList;
	@FindBy(xpath = "//a[text()='Claim Assignment Document']")
	WebElement claimDoc;
	

	// Method to validate the default factoring calculator values
	// invoiceAmount
	public String getDefaultInvoiceAmount() throws InterruptedException {
		Thread.sleep(900);
		String defaultInvoiceAmount = invoiceAmount.getAttribute("value");
		if (defaultInvoiceAmount != null) {
			return defaultInvoiceAmount;
		} else
			return null;

	}

	// AdvanceRate
	public String getDefaultAdvanceRate() {
		Select sAdvanceRate = new Select(advanceRate);
		String defaultAdvanceRate = sAdvanceRate.getFirstSelectedOption().getText();
		return defaultAdvanceRate;
	}

	// InterestRate
	public String getDefaultInterestRate() {
		String defaultInterestRate = interestRate.getAttribute("value");
		if (defaultInterestRate != null) {
			return defaultInterestRate;
		} else
			return null;

	}

	// PaymentTerm
	public String getDefaultPaymentTerm() throws InterruptedException {
		Thread.sleep(1000);
		Select sPaymentTerm = new Select(paymentTerm);
		Thread.sleep(1000);
		String defaultPaymentTerm = sPaymentTerm.getFirstSelectedOption().getText();
		return defaultPaymentTerm;

	}

	// Commission Fees
	public String getDefaultCommissionFees() {
		String defaultCommissionFees = commissionFees.getAttribute("value");
		if (defaultCommissionFees != null) {
			return defaultCommissionFees;
		} else
			return null;

	}

	// Calculation Button
	public Boolean defaultCalculationButton() {
		Boolean status = calculateBtn.isEnabled();
		return status;

	}

	// Invoice Financing Value
	public String getDefaultInvoiceFinanceValue() {
		String defaultInvoiceFinanceValue = invoiceFinanceVal.getText();
		if (defaultInvoiceFinanceValue != null) {
			return defaultInvoiceFinanceValue;
		} else
			return null;

	}

	// Expense
	public String getDefaultExpense() {
		String defaultExpense = expenses.getText();
		if (defaultExpense != null) {
			return defaultExpense;
		} else
			return null;

	}

	// Validating error messages
	// Invoice Amount AplhaNumeric
	public String invoiceAmountAplhaNumericValidation(String alphaNumeric) throws InterruptedException {
		invoiceAmount.clear();
		invoiceAmount.sendKeys(alphaNumeric);
		invoiceAmount.sendKeys(Keys.TAB);
		Thread.sleep(900);
		String errorMsg = errorMessage.getText();
		return errorMsg;
	}

	// Invoice AMount Empty Validation
	public String invoiceAmountEmptyValidation(String empty) {
		invoiceAmount.clear();
		invoiceAmount.sendKeys(empty);
		Actions action = new Actions(driver);
		action.moveToElement(calculateBtn).click().perform();
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Invoice Amount Zero Validation
	public String invoiceAmountZeroValidation(String zero) {
		invoiceAmount.clear();
		invoiceAmount.sendKeys(zero);
		invoiceAmount.sendKeys(Keys.TAB);
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Advance Rate
	public Boolean advanceRateValidation() throws InterruptedException {
		Boolean status = false;
		String[] displayedOptionsExpected = { "75", "80", "85", "90" };
		List<String> list = Arrays.asList(displayedOptionsExpected);
		List<String> newList=new ArrayList<String>(list);
		List<String> displayedOptions = new ArrayList<String>();
		Thread.sleep(1000);
		Select advanceRateSelections = new Select(advanceRate);
		List<WebElement> options = advanceRateSelections.getOptions();
		for (WebElement opt : options) {
			opt.getText();
			displayedOptions.add(opt.getText());
		}
		if (newList.equals(displayedOptions)) {
			status = true;
		}
		return status;

	}

	// interest Rate Alpha Numeric Validation
	public String interestRateAlphaNumericValidation(String alphaNumeric) {
		interestRate.clear();
		interestRate.sendKeys(alphaNumeric);
		interestRate.sendKeys(Keys.TAB);
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Interest Rate Empty Validation
	public String interestRateEmptyValidation(String empty) throws InterruptedException {
		interestRate.clear();
		interestRate.sendKeys(empty);
		Thread.sleep(900);
		Actions action = new Actions(driver);
		action.moveToElement(calculateBtn).click().perform();
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Interest Rate Above Limits
	public String interestRateAboveLimitsValidation(String aboveLimit) throws InterruptedException {
		interestRate.clear();
		interestRate.sendKeys(aboveLimit);
		Thread.sleep(900);
		interestRate.sendKeys(Keys.TAB);
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Payment Term Validation
	public Boolean paymentTermValidation() throws InterruptedException {
		Boolean status = false;
		List<String> displayedPaymentTermOptions = new ArrayList<String>();
		Thread.sleep(1000);
		Select paymentTermSelections = new Select(paymentTerm);
		List<WebElement> options = paymentTermSelections.getOptions();
		for (WebElement opt : options) {
			opt.getText();
			displayedPaymentTermOptions.add(opt.getText());
		}
		String[] displayedOptionsExpected = { "30", "60", "90", "120" };
		List<String> list = Arrays.asList(displayedOptionsExpected);
		List<String> newList=new ArrayList<String>(list);
		if (newList.equals(displayedPaymentTermOptions)) {
			status = true;
		}
		return status;

	}

	// commission Fees Aplha Numeric
	public String commissionFeesAlphaNumericValidation(String alphaNumeric) throws InterruptedException {
		Actions commissionAction = new Actions(driver);
		commissionAction.moveToElement(commissionFees).click().perform();
		commissionFees.clear();
		commissionFees.sendKeys(alphaNumeric);
		commissionFees.sendKeys(Keys.TAB);
		Thread.sleep(900);
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Commission Fees Empty
	public String commissionFeesEmptyValidation(String empty) throws InterruptedException {
		Actions commissionAction = new Actions(driver);
		commissionAction.moveToElement(commissionFees).click().perform();
		Thread.sleep(200);
		commissionFees.clear();
		commissionAction.sendKeys("");
		calculateBtn.click();
		String errorMsg = errorMessage.getText();
		return errorMsg;

	}

	// Apply Button
	public Boolean applyButtonValidation() throws InterruptedException {
		Boolean status = false;
		Actions applyBtn = new Actions(driver);
		applyBtn.moveToElement(applyButton).perform();
		Thread.sleep(1500);
		if (applyButton.isEnabled()) {
			status = true;
		}
		return status;
	}
	//How to Apply
	public String howToApplyTabValidation() throws InterruptedException {
		String displayedStringName_1 = null;
		if(howToApply.isEnabled()) {
			status = true;
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", howToApply);
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			Thread.sleep(200);
			displayedStringName_1 = factoringInfoBox.getText();
		}
		return displayedStringName_1;
		
	}
	//Docs and Fees General Conditions
	public String docAndFeesTabGeneralConditionsValidation() throws InterruptedException {
		String currentURL = null;
		if(docAndFees.isEnabled()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", docAndFees);
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			Thread.sleep(200);
			generalCond.click();
			Thread.sleep(1000);
			currentURL= driver.getCurrentUrl();
		}
		return currentURL;
		
	}
	//Doc ANd Fees Invoice List
	public Boolean docAndFeesInvoiceListValidation() throws InterruptedException {
		Boolean status = false;
		if(docAndFees.isEnabled()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", docAndFees);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			Thread.sleep(200);
			if(invoiceList.isEnabled()) {
				status = true;
				invoiceList.click();
				Thread.sleep(2000);
			}
		}
		return status;
		
	}
	
	//Doc and Fees Claim Document
	public Boolean docAndfeesClaimDocValidation() throws InterruptedException {
		Boolean status = false;
		if(docAndFees.isEnabled()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", docAndFees);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			Thread.sleep(200);
			if(claimDoc.isEnabled()) {
				status = true;
				claimDoc.click();
				Thread.sleep(2000);
			}
			
		}
		
		return status;
		
	}
	

}
