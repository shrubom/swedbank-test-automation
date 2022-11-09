package com.swedbank.factoring.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
	
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Factoring_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(screenshot, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to take the screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return (df.format(currentDate));
	}

}
