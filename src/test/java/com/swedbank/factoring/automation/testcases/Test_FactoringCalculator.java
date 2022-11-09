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

	}

	@Test(priority = 8)
	public void invoiceAmountAplhaNumericValidation() throws InterruptedException, AWTException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountAplhaNumericValidation("1111Ab321"),
				"Please enter a valid number");

	}

	@Test(priority = 9)
	public void invoiceAmountEmptyValidation() {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountEmptyValidation(""), "This field is required");

	}

	@Test(priority = 10)
	public void invoiceAmountZeroValidation() {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.invoiceAmountZeroValidation("0"),
				"Please enter a value greater than or equal to 1");

	}

	@Test(priority = 11)
	public void advanceRateValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.advanceRateValidation());
	}

	@Test(priority = 12)
	public void interestRateAlphaNumericValidation() {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateAlphaNumericValidation("3a.2"), "Please enter a valid number");
	}

	@Test(priority = 13)
	public void interestRateEmptyValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateEmptyValidation(" "), "This field is required");

	}

	@Test(priority = 14)
	public void interestRateAboveLimitsValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.interestRateAboveLimitsValidation("32"),
				"Please enter a value less than or equal to 20");

	}

	@Test(priority = 15)
	public void paymentTermValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.paymentTermValidation());
	}

	@Test(priority = 16)
	public void commissionFeesAlphaNumericValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.commissionFeesAlphaNumericValidation("21Aa"), "Please enter a valid number");
	}

	@Test(priority = 17, enabled = false)
	public void commissionFeesEmptyValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.commissionFeesEmptyValidation(" "), "This field is required");
	}

	@Test(priority = 18)
	public void applyButtonValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.applyButtonValidation());
	}

	@Test(priority = 19)
	public void howToApplyTabValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.howToApplyTabValidation().contains("Factoring"));
	}

	@Test(priority = 20)
	public void docAndFeesTabGeneralConditionsValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertEquals(calculatorPage.docAndFeesTabGeneralConditionsValidation(),
				"https://www.swedbank.lt/business/useful/legislation/legislation");
	}

	@Test(priority = 21)
	public void docAndFeesInvoiceListValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.docAndFeesInvoiceListValidation());
	}

	@Test(priority = 22)
	public void docAndfeesClaimDocValidation() throws InterruptedException {

		FactoringCalculatorPage calculatorPage = PageFactory.initElements(BaseClass.driver,
				FactoringCalculatorPage.class);
		Assert.assertTrue(calculatorPage.docAndfeesClaimDocValidation());

	}

}
