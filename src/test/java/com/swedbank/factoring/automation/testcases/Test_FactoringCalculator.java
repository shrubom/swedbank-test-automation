package com.swedbank.factoring.automation.testcases;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swedbank.factoring.automation.pages.BaseClass;
import com.swedbank.factoring.automation.pages.FactoringCalculatorPage;

public class Test_FactoringCalculator extends BaseClass {

	@Test(priority = 7)
	public void sectionDefaultValidations() throws NumberFormatException, InterruptedException {
		extentLogger = extentReport.createTest("Validating the default values when the user lands on the factoring calculator page");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.getDefaultInvoiceAmount(), "10000");
		Assert.assertEquals(Integer.parseInt(calculatorPage.getDefaultAdvanceRate()), 90);
		Assert.assertEquals(calculatorPage.getDefaultInterestRate(), "3");
		Assert.assertEquals(Integer.parseInt(calculatorPage.getDefaultPaymentTerm()), 30);
		Assert.assertEquals(calculatorPage.getDefaultCommissionFees(), "0.3");
		Assert.assertTrue(calculatorPage.defaultCalculationButton());
		Assert.assertEquals(calculatorPage.getDefaultInvoiceFinanceValue(), "0");
		Assert.assertEquals(calculatorPage.getDefaultExpense(), "0.00");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 8)
	public void invoiceAmountAplhaNumericValidation() throws InterruptedException, AWTException {
		extentLogger = extentReport.createTest("Validating the error message on Invoice Amount when the input is aplhanumeric value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountAplhaNumericValidation("1111Ab321"),
				"Please enter a valid number");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 9)
	public void invoiceAmountEmptyValidation() {
		extentLogger = extentReport.createTest("Validating the error message on Invoice Amount when the input is an empty value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountEmptyValidation(""), "This field is required");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 10)
	public void invoiceAmountZeroValidation() {
		extentLogger = extentReport.createTest("Validating the error message on Invoice Amount when the input is a zero value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountZeroValidation("0"),
				"Please enter a value greater than or equal to 1");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 11)
	public void advanceRateValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating if the user can see the different advance rate values");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.advanceRateValidation());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 12)
	public void interestRateAlphaNumericValidation() {
		extentLogger = extentReport.createTest("Validating the error message on Interest rate when the input is aplhanumeric value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateAlphaNumericValidation("3a.2"), "Please enter a valid number");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 13)
	public void interestRateEmptyValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the error message on Interest rate when the input is an empty value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateEmptyValidation(" "), "This field is required");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 14)
	public void interestRateAboveLimitsValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the error message on Interest rate when the input is more than the acceptable limit value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateAboveLimitsValidation("32"),
				"Please enter a value less than or equal to 20");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 15)
	public void paymentTermValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating if the user can see the different Payment Term values");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.paymentTermValidation());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 16)
	public void commissionFeesAlphaNumericValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the error message on Commission Fees when the input is aplhanumeric value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.commissionFeesAlphaNumericValidation("21Aa"), "Please enter a valid number");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 17, enabled = false)
	public void commissionFeesEmptyValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the error message on Commission Fees when the input is an Empty value");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.commissionFeesEmptyValidation(" "), "This field is required");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 18)
	public void applyButtonValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the Apply button is enabled");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.applyButtonValidation());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 19)
	public void howToApplyTabValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user can click on How to Apply and it navigates to the factoring info box section");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.howToApplyTabValidation().contains("Factoring"));
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 20)
	public void docAndFeesTabGeneralConditionsValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user can click on Documents and Fees Tab and can navigate to the general conditions URL");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.docAndFeesTabGeneralConditionsValidation(),
				"https://www.swedbank.lt/business/useful/legislation/legislation");
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 21)
	public void docAndFeesInvoiceListValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user can click on Documents and Fees Tab and can click on download invoice list");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.docAndFeesInvoiceListValidation());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 22)
	public void docAndfeesClaimDocValidation() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user can click on Documents and Fees Tab and can click on download Claim Document");
		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.docAndfeesClaimDocValidation());
		extentLogger.pass("Successful Test");
	}

}
