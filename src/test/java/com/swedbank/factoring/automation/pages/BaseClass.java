package com.swedbank.factoring.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.swedbank.factoring.automation.utilities.BrowserUtility;
import com.swedbank.factoring.automation.utilities.ConfigDataProvider;
import com.swedbank.factoring.automation.utilities.ExcelDataProvider;
import com.swedbank.factoring.automation.utilities.Helper;

public class BaseClass {
	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentReports extentReport;
	public static ExtentTest extentLogger;
	
	@BeforeSuite
	public void datDrivenSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extentReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FactoringCalculator_"+Helper.getCurrentDateTime()+".html"));
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentReporter);
	}
	
	
	@BeforeMethod
	public void setup() {
		driver = BrowserUtility.startApplication(driver, config.getBrowserName(), config.getQAUrl());
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.landingPageCookieClick();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentLogger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SKIP) {
			extentLogger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS){
			extentLogger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extentReport.flush();
	}
	

}
