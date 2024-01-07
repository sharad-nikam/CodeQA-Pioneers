package com.bookart.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;

	String path = System.getProperty("user.dir")+"/configuration/config.properties";

//	public static String CONFIG_FILE_PATH =System.getProperty("user.dir")+"/src/main/java/com/gb/Configuration/config.properties";
	
	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}

	public String getSigninEmail() { 
		String email = properties.getProperty("emailforsignin");
		if(email!=null) 
			return email; 
		else 
			throw new RuntimeException("email not specified in config file.");
	}


	public String getSigninPassword() { 
		String password =properties.getProperty("passwordforsigin"); 
		if(password!=null) 
			return password; 
		else
			throw new RuntimeException("password not specified in config file.");
	}

}
