package com.swedbank.factoring.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	Boolean status = false;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[@class='logo']") WebElement logo;
	@FindBy(xpath = "//button[@class='button -left' and text()='Apply']") WebElement applyBtn;
	@FindBy(xpath = "//ui-icon[@glyph='log-in']") WebElement loginBtn;
	@FindBy(className = "ui-tabs__captions") List<WebElement> loginTabs;

	// Method to go to loginPage using Swedbank logo
	public Boolean usingSwedbankLogo() throws InterruptedException {
		Thread.sleep(1000);
		logo.click();
		Thread.sleep(1000);
		for (WebElement tabElemts : loginTabs) {
			List<WebElement> eachTagName = tabElemts.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {
				if (tagName.getText().equals("Smart-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Biometrics")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("ID-card")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				}

			}
		}
		Thread.sleep(1000);
		return status;
	}
	
	public Boolean usingApplyButton() throws InterruptedException {
		Thread.sleep(5000);
		applyBtn.click();
		Thread.sleep(4000);
		for (WebElement tabElemts : loginTabs) {
			List<WebElement> eachTagName = tabElemts.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {
				if (tagName.getText().equals("Smart-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Biometrics")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("ID-card")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				}

			}
		}
		Thread.sleep(1000);
		return status;
		
	}
	
	//Method to validate login page using login button
	public Boolean usingLoginButton() throws InterruptedException {
		Thread.sleep(4000);
		loginBtn.click();
		Thread.sleep(4000);
		for (WebElement tabElemts : loginTabs) {
			List<WebElement> eachTagName = tabElemts.findElements(By.tagName("li"));
			for (WebElement tagName : eachTagName) {
				if (tagName.getText().equals("Smart-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Biometrics")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("Mobile-ID")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("PIN-calculator")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				} else if (tagName.getText().equals("ID-card")) {
					if (tagName.isEnabled()) {
						status = true;
						tagName.click();
					}
					Thread.sleep(1000);

				}

			}
		}
		Thread.sleep(1000);
		return status;
	}
}
