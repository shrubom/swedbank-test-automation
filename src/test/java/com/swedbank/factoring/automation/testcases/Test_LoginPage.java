package com.swedbank.factoring.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swedbank.factoring.automation.pages.BaseClass;
import com.swedbank.factoring.automation.pages.LoginPage;

public class Test_LoginPage extends BaseClass {

	@Test(priority = 4)
	public void usingSwedBanklogo() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingSwedbankLogo());
	}

	@Test(priority = 5)
	public void usingApplyButton() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingApplyButton());
	}

	@Test(priority = 6)
	public void usingLoginButton() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(BaseClass.driver, LoginPage.class);
		Assert.assertTrue(loginPage.usingLoginButton());
	}

}
