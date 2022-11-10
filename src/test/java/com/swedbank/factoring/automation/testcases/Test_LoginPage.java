package com.swedbank.factoring.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swedbank.factoring.automation.pages.BaseClass;
import com.swedbank.factoring.automation.pages.LoginPage;

public class Test_LoginPage extends BaseClass {

	@Test(priority = 4)
	public void usingSwedBanklogo() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user is taken to login page upon clicking on swedbank logo");
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingSwedbankLogo());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 5)
	public void usingApplyButton() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user is taken to login page upon clicking on apply button");
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingApplyButton());
		extentLogger.pass("Successful Test");
	}

	@Test(priority = 6)
	public void usingLoginButton() throws InterruptedException {
		extentLogger = extentReport.createTest("Validating the user is taken to login page upon clicking on Login button");
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingLoginButton());
		extentLogger.pass("Successful Test");
	}

}
