package com.swedbank.factoring.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if (browserName.equals("Chrome")) {
			driver = WebDriverManager.chromedriver().create();

		} else if (browserName.equals("FireFox")) {
			driver = WebDriverManager.firefoxdriver().create();

		} else if (browserName.equals("Safari")) {
			driver = WebDriverManager.safaridriver().create();

		} else if (browserName.equals("IE")) {
			driver = WebDriverManager.iedriver().create();
		} else {
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(appURL);

		return driver;

	}

}
