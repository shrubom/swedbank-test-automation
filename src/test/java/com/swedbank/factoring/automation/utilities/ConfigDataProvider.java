package com.swedbank.factoring.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties properties;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load the congif file" + e.getMessage());

		}
	}
	
	public String getBrowserName() {
		return(properties.getProperty("Browser"));
	}
	
	public String getQAUrl() {
		return(properties.getProperty("qaURL"));
	}

}
